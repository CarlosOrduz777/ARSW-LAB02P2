package arsw.threads;

/**
 * Un galgo que puede correr en un carril
 * 
 * @author rlopez
 * 
 */
public class Galgo extends Thread {
	private int paso;
	private Carril carril;
	RegistroLlegada regl;
	boolean stop;

	public Galgo(Carril carril, String name, RegistroLlegada reg) {
		super(name);
		this.carril = carril;
		paso = 0;
		this.regl=reg;
	}

	public void corra() throws InterruptedException {
		while (paso < carril.size()) {			
			Thread.sleep(100);
			carril.setPasoOn(paso++);
			carril.displayPasos(paso);
			
			if (paso == carril.size()) {						
				carril.finish();
				int ubicacion=regl.getUltimaPosicionAlcanzada();
				synchronized (this){
					regl.setUltimaPosicionAlcanzada(ubicacion+1);
				}
				System.out.println("El galgo "+this.getName()+" llego en la posicion "+ubicacion);
				if (ubicacion==1){
					regl.setGanador(this.getName());
				}
				
			}

			synchronized (this){
				while (stop){
					try {
						this.wait();
					}catch (InterruptedException e){
						System.out.println("Error for Stop Galgo");
					}
				}
			}
		}
	}

	public void resumeCarril(){
		setStop(false);
		synchronized (this){
			this.notifyAll();
		}
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		
		try {
			corra();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

# Laboratorio Parte 2

## Laura Alvarado, Carlos Orduz



Corrija la aplicación para que el aviso de resultados se muestre sólo cuando la ejecución de todos los hilos ‘galgo’ haya finalizado. Para esto tenga en cuenta:

a. La acción de iniciar la carrera y mostrar los resultados se realiza a partir de la línea 38 de MainCanodromo.

### Nos aparece el resultado del ganador como null, ya que está sacando puntaje antes de que los golgos lleguen a la meta.

![imagen](https://user-images.githubusercontent.com/98195579/185815653-553917ea-4434-40b0-8fce-873b8d892c96.png)

b. Puede utilizarse el método join() de la clase Thread para sincronizar el hilo que inicia la carrera, con la finalización de los hilos de los galgos.

El método join() permite que se bloquee el hilo actual hasta que se complete otro.

![imagen](https://user-images.githubusercontent.com/98195579/185815758-3a6a8d0e-697f-4f7b-af83-2d42d1027856.png)

2. Una vez corregido el problema inicial, corra la aplicación varias veces, e identifique las inconsistencias en los resultados de las mismas viendo el ‘ranking’ mostrado en consola (algunas veces podrían salir resultados válidos, pero en otros se pueden presentar dichas inconsistencias). A partir de esto, identifique las regiones críticas () del programa.

![imagen](https://user-images.githubusercontent.com/98195579/185809096-9ad32504-f246-4269-9e11-6ad0c9621824.png)

### La inconsistencia que encontramos es que varios golgos llegaban a la misma posición de llegada, por lo tanto, la llegada viene siendo la región crítica ya que, están entrando más de dos golgos a la misma zona.

3. Utilice un mecanismo de sincronización para garantizar que a dichas regiones críticas sólo acceda un hilo a la vez. Verifique los resultados.

Sincronizamos donde se asigna el valor de la ubicación, de forma que en la llegada se realice de manera sincronizada.

![imagen](https://user-images.githubusercontent.com/98195579/185817272-6338ac6d-9db0-4247-89ba-163c71aee102.png)

4. Implemente las funcionalidades de pausa y continuar. Con estas, cuando se haga clic en ‘Stop’, todos los hilos de los galgos deberían dormirse, y cuando se haga clic en ‘Continue’ los mismos deberían despertarse y continuar con la carrera. Diseñe una solución que permita hacer esto utilizando los mecanismos de sincronización con las primitivas de los Locks provistos por el lenguaje (wait y notifyAll).

Utilizamos la variable booleana stop que es la que nos permite saber si esta en pausa o no, de forma que si se va a pausar stop sera true y se pondra a esperar hasta que se reanude el hilo, usando notifyall() al tratarse de varios. 

![imagen](https://user-images.githubusercontent.com/98195579/185817292-04c26771-8acb-47c8-abb0-d0e3a6410d62.png)




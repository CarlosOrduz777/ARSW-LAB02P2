# Laboratorio Parte 2

## Laura Alvarado, Carlos Orduz



Corrija la aplicación para que el aviso de resultados se muestre sólo cuando la ejecución de todos los hilos ‘galgo’ haya finalizado. Para esto tenga en cuenta:

a. La acción de iniciar la carrera y mostrar los resultados se realiza a partir de la línea 38 de MainCanodromo.

### Nos aparece el resultado del ganador como null, ya que está sacando puntaje antes de que los golgos lleguen a la meta.

![imagen](https://user-images.githubusercontent.com/98195579/185815653-553917ea-4434-40b0-8fce-873b8d892c96.png)

b. Puede utilizarse el método join() de la clase Thread para sincronizar el hilo que inicia la carrera, con la finalización de los hilos de los galgos.



2. Una vez corregido el problema inicial, corra la aplicación varias veces, e identifique las inconsistencias en los resultados de las mismas viendo el ‘ranking’ mostrado en consola (algunas veces podrían salir resultados válidos, pero en otros se pueden presentar dichas inconsistencias). A partir de esto, identifique las regiones críticas () del programa.

![imagen](https://user-images.githubusercontent.com/98195579/185809096-9ad32504-f246-4269-9e11-6ad0c9621824.png)

### La inconsistencia que encontramos es que varios golgos llegaban a la misma posición de llegada, por lo tanto, la llegada viene siendo la región crítica ya que, están entrando más de dos golgos a la misma zona.

# CaptureTheFlag

## Arquitectura de software 

## Descripcion 

Juego multijugador web, de plataformas,donde cada jugador debe competir por capturar la bandera del mapa. En el mapa se encontraran poderes distribuidos aleatoriamente que cada jugador puede obtener para así afectar el rendimiento de los demás o beneficiarse de estos para así mejorar sus probabilidades de conseguir la bandera, cada jugador tendra 100 puntos de vida donde al morir reaparecerán después de 3 segundos, tambien tendra un contador de puntos que ira aumentando dependiendo de cuanto tiempo dure con la bandera, cada partida contara con maximo 5 jugadores y minimo 2. Este juego se desarrollara en java para el backend, html5 y javascript para el frontend y maven para gestionar el proyecto.
 

## Autores 

- Diego Alejandro Corredor Tolosa -  [diego2097](https://github.com/diego2097)
- Cristian David Lopez Arevalo -  [cdavidd](https://github.com/cdavidd)
- Daniel Mauricio Cifuentes Ramirez - [dcifuentesR](https://github.com/dcifuentesR) 

## Heroku 

[heroku](https://capturetheflag-arsw.herokuapp.com/)

# Analisis estatico de codigo con codacy 
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/fb0b361734014f6c9e5aa86f93babe7c)](https://www.codacy.com/manual/diego2097/CaptureTheFlag?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=diego2097/CaptureTheFlag&amp;utm_campaign=Badge_Grade)

## Arquitectura de la aplicacion 

### Diagrama de clases - backend 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/Diagrama_de_clases.PNG)

### Diagrama de entidad relacion

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/DataBase.png)

### Diagrama de desplieuge 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/Deployment_Diagram.PNG)

### Casos de uso 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/Casos-De-Uso.png)

### Diagrama de componentes

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/Component-Diagram.png)

## Atributos no funcionales 

### Performance 

#### Primer escenario. Latencia 

Caracteristica | Valor 
-- | --
Fuente                |   Usuarios 
Estimulo              |   Se solicitan y envian datos de la partida
Artefacto             |   Sistema 
Ambiente              |   Durante la ejecucion del juego 
Respuesta             |   Las solicitudes y datos son procesados
Tiempo de respuesta   |   Mayor a 150ms con velocidad de descarga menor a 1Mbps
Tiempo de respuesta   |   100ms - 130ms con velocidad de descarga 1Mbps - 5Mbps
Tiempo de respuesta   |   80ms - 90ms con velocidad de descarga > 5Mbps

Utilizamos el monitor de tareas, el cual tiene funcion donde se puede visualizar la latencia de 
cada servicio de red que esta consumiendo. 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/monitor_recursos.PNG)

Ahora iniciamos una partida y verificamos con la ip de nuestro servicio en el monitor de tareas la latencia. 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/latencia.png)

#### Segundo escenario. Tiempo de carga 

Caracteristica | Valor 
-- | --
Fuente               |  Usuarios 
Estimulo             |  Se hace el request a una pagina
Artefacto            |  Sistema
Ambiente             |  Bajo condiciones normales 
Respuesta            |  Se carga la pagina
Tiempo de respuesta  |  En promedio el tiempo de carga es de 3.3s 

Para calcular el tiempo de carga promedio se utilizo la herramienta audits de google, la cual nos permite calcular el tiempo de interaccion de cada pagina. Como se puede observar en la imagen: 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/timeInteractive.png)

El tiempo de interaccion es el tiempo en que la página parece estar lo suficientemente lista para que un usuario pueda interactuar con ella.

### Indicaciones básicas de uso de la aplicación

Para registarse en la aplicacion, clickear **sign up**, alli se encontrara un formulario para poder registrarse, se debe ingresar **correo**, **nick** y **password**

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/sign_up.PNG)

Para ingresar a la aplicacion, usar el usuario **diego**  y la contraseña **123** 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/index.PNG)

Al loggearse en la aplicacion el usuario sera redirido a la pagina home, donde podra encontrar 5 pestañas **perfil**, **salas**, **crear**, **instrucciones** y **cerrar sesion**. 

En la pestaña perfil podra encontrar toda la informacion relacionada al perfil del usuario como tambien algunas estadisitcas de sus partidas, como victorias globales, muertes, kills y el porcentaje de victorias totales. Tambien se podran encontrar estadisticas mas detalladas sobre todas las partidas que ha jugado el usuario.  

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/home.PNG)


En la pestaña salas, se encuentran todas las salas disponibles en el juego, para unirse a una sala el jugador solo debe clickear en unirse. y sera redirigido a la sala donde esperara a que el dueño de la sala decida iniciar la partida. 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/salas.PNG)

En la pestaña craer el usuario puede crear una sala especifica, eligiendo el mapa en el que desee jugar. 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/crear.PNG)

Despues de esto sera redirigido a la sala, donde podra elegir el skin a utilizar durante la partida. 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/crear2.PNG)

Cuando el usuario este listo, podra clickear jugar y la partida empezara. 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/juego.PNG)

Finalmente se tiene la ventana de instrucciones donde se especifica de manera clara el objetivo del juego y su jugabilidad. 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/instrucciones.PNG)
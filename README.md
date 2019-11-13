# CaptureTheFlag

## Arquitectura de software 


## Descripcion 

Juego multijugador web,  de plataformas, donde cada jugador debe competir por capturar la bandera del mapa. En el mapa se encontraran poderes distribuidos aleatoriamente que cada jugador puede obtener para así afectar el rendimiento de los demás o beneficiarse de estos para así mejorar sus probabilidades de conseguir la bandera, cada jugador tendra 100 puntos de vida donde al morir reaparecerán después de 3 segundos, tambien tendra un contador de puntos que ira aumentando dependiendo de cuanto tiempo dure con la bandera, cada partida contara con maximo 5 jugadores y minimo 2. Este juego se desarrollara en java para el backend, html5 y javascript para el frontend y maven para gestionar el proyecto.
 

## Autores 

- Diego Alejandro Corredor Tolosa -  [diego2097](https://github.com/diego2097)
- Cristian David Lopez Arevalo -  [cdavidd](https://github.com/cdavidd)
- Daniel Mauricio Cifuentes Ramirez - [dcifuentesR](https://github.com/dcifuentesR) 

## Heroku 

[heroku](https://capturetheflag-arsw.herokuapp.com/)

# Analisis estatico de codigo con codacy 
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/fb0b361734014f6c9e5aa86f93babe7c)](https://www.codacy.com/manual/diego2097/CaptureTheFlag?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=diego2097/CaptureTheFlag&amp;utm_campaign=Badge_Grade)

## Arquitectura de la aplicacion 

### Diagrama de clases

 ![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/Diagrama%20de%20clases.PNG)

### Diagrama de entidad relacion

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/DataBase.png)

### Diagrama de desplieuge 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/Deployment_Diagram.PNG)

### Casos de uso 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/Casos-De-Uso.png)

### Diagrama de componentes

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/Component-Diagram.png)

### Indicaciones básicas de uso de la aplicación

Para ingresar a la aplicacion, usar el usuario **diego**  y la contraseña **123** 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/index.PNG)

Al loggearse en la aplicacion el usuario sera redirido a la pagina home, donde podra encontrar 3 pestañas **perfil**, **salas** y **crear**. 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/home.PNG)

En la pestaña perfil podra encontrar toda la informacion relacionada al perfil del usuario como tambien algunas estadisitcas de sus partidas, como victorias globales, muertes, kills y el porcentaje de victorias totales. Tambien se podran encontrar estadisticas mas detalladas sobre todas las partidas que ha jugado el usuario.  

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/perfil.PNG)

En la pestaña salas, se encuentran todas las salas disponibles en el juego, para unirse a una sala el jugador solo debe clickear en unirse. y sera redirigido a la sala donde esperara a que el dueño de la sala decida iniciar la partida. 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/salas.PNG)

En la pestaña craer el usuario puede crear una sala espesfica, eligiendo el mapa en el que desee jugar. 

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/crear.PNG)

Para registarse en la aplicacion, clickear **sign up**, alli se encontrara un formulario para poder registrarse, se debe ingresar **correo**, **nick** y **password**

![alt text](https://github.com/diego2097/CaptureTheFlag/blob/master/pictures/sign_up.PNG)

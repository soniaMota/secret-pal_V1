# Documentación prueba técnica
[TOC]

## Tecnologías empleadas
   Además de los requerimientos para la parte del backend, Java EE 6 ó 7 y base de datos HSQLDB se ha utilizado Java 11 y un servidor de aplicaciones Wildfly 18.0.1.Final. Para la parte del frontend se ha utilizado React.
## Metodología y paradigmas
   Se han empleado paradigmas de programación inmutable y programación funcional tanto en la parte del back como en el front, haciendo un uso exclusivo de los componentes funcionales de React. Ademas se ha tratado de aplicar la metodología DDD para el diseño del backend.
## Ejecución y despliegue
  Las dos aplicaciones del ejercicio han sido dockerizadas, así como la BBDD. Para ello se requiere de ```docker``` como de ```docker-compose```. En la raiz de proyecto hay un script ```start.sh``` que construye los proyectos y levanta todos los contenedores de forma automática.  Una vez termine el script la api del backend se encontrará disponible en ```localhost:8080``` y el front en ```localhost:3000```.
## Control de versiones
  En cuanto a la pregunta sobre el control de versiones, entiendo que se refiere a la api y sus posibles evoluciones, y la complejidad que implica que ésta cambie, estando obligados, por cuestiones de compatibilidad, ha mantener diferentes versiones conviviendo. Es un problema complejo, porque el modelo de datos puede ser un factor limitante. Pero como primera aproximación seguramente habría que convenir una semántica del versionado y ser rigurosos con los estandares establecidos. También se podrían estudiar herramientas como GraphQL que ayuden a construir apis mas flexibles. Además un buen sistema de CI/CD ayuda a que los cambios se introduzcan de forma mas progresiva, produciendose de este modo errores habitualmente mas pequeños y faciles de corregir. Si la pregunta tambien iba enfocada al versionado / mantenimiento del código supongo que ```git``` se ha convertido en la Herramienta, que en combinación con aplicaciones de repositorios de código como Github, Bitbucket o Gitlab permiten dotar de trazabilidad y control sobre los cambios introducidos en el mismo. 
## Webservice
  Se han generado un servicio web cuyo WSDL se encuentra en la siguiente url [localhost:8080/backend/UsersWebservice?wsdl](localhost:8080/backend/UsersWebservice?wsdl). El servico se ha protegido con una autorización de tipo ```Basic```, pasando la cabecera ```Authorization: Basic base64(user:pass)``` .
  ## Endpoints de la API de Usuarios

    Get all Users : GET /api/users/
    Get An User : GET /api/users/:username
    Update An User password : PUT /api/users/:username/
    Create An User : POST /api/users/

### Get all users

**URL** : `/api/users/`

**Method** : `GET`

### Get an user

**URL** : `/api/users/:username`

**Method** : `GET`

### Update user password

**URL** : `/api/users/:username`

**Method** : `PUT`

**Data constraints**

```json
{
    "username": "anUsername",
    "password": "Passw0rd"
}
```
### Create a new user

**URL** : `/api/users/`

**Method** : `POST`

**Data constraints**

```json
{
    "username": "anUsername",
    "fullname": "Full Name User",
    "password": "Passw0rd"
}
```




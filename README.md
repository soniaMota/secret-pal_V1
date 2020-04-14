# Documentación prueba técnica
[TOC]

## Tecnologías empleadas
   Además de los requerimientos para la parte del backend, Java EE 6 ó 7 y base de datos HSQLDB se ha utilizado Java 11 y un servidor de aplicaciones Wildfly 18.0.1.Final. Para la parte del frontend se ha utilizado React.
## Metodología y paradigmas
   Se han empleado paradigmas de programación inmutable y programación funcional tanto en la parte del back como en el front, haciendo un uso exclusivo de los componentes funcionales de React. Ademas se ha tratado de aplicar la metodología DDD para el diseño del backend.
## Ejecución y despliegue
  Las dos aplicaciones del ejercicio han sido dockerizadas, así como la BBDD. Para ello se requiere de ```docker``` como de ```docker-compose```. En la raiz de proyecto hay un script ```start.sh``` que construye los proyectos y levanta todos los contenedores de forma automática.  Una vez termine el script la api del backend se encontrará disponible en ```localhost:8080``` y el front en ```localhost:3000```.
  ## endpoints de la api de usuarios

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




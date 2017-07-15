# Pizza app

## Build & run
``mvn test`` build & run tests
``mvn spring-boot:run`` build & execute application

## Spring boot pizza service
A service in spring boot to expose a REST API for adding, deleting and retrieving pizzas. It is backed by a simple embedded Redis db. 
Some example curl commmands:

Create Pizzas
``curl -d "{\"name\":\"Margarita\",\"cost\":999,\"ingredients\":[\"cheese\",\"tomato\"]}" --header "Content-Type: application/json" http://localhost:8080/pizzas``

``curl -d "{\"name\":\"Hawaiian\",\"cost\":1299,\"ingredients\":[\"cheese\",\"tomato\",\"ham\",\"pineapple\"]}" --header "Content-Type: application/json" http://localhost:8080/pizzas``

List all pizzas
``curl http://localhost:8080/pizzas`` 

Get pizza from id
``curl http://localhost:8080/pizzas/{id}``

Delete pizza from id
``curl -X DELETE http://localhost:8080/pizzas/{id}``

## Quick and simple UI
The spring boot app includes a SPA for basic creation and listing of pizzas using the REST API described above. Go to
``http://localhost:8080``

# SpringBootApi
## RESTful API using HTTP methods for CRUD(Create, Retrieve, Update and Delete) operations in Spring Boot along with the MYSQL database.
### Get
-> localhost:8080/users
### Post
-> localhost:8080/users/
-> e.g body 
        "firstName":"Kumar ",
        "lastName":"Amrit",
        "userName":"AK"
### Get by id
-> e.g   localhost:8080/users/6

###PUT Request method along with ID to update the user with id 6
-> localhost:8080/users/6
-> body e.g 
        "firstName":"Kumar ",
        "lastName":"Amrit"
    
### Delete with id 6
-> localhost:8080/users/6

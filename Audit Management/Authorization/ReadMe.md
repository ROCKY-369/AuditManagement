# Authorization Microservice

This is a microservice of the audit management system project. This microservice accepts userName and password as JSON with HTTP requests to return the jwt token that is valid for 30 mins. Its also provide the functionality to validate that token.

## Api Endpoints

##### A valid JwtToken token should be present as a bearer token in the request header.
##### POST request to submit the userName Password as JSON to receive a jwt token that is valid for 30mins.

```url
/Authorization/login
```
##### GET request to get the validity of the JwtToken token presents as a bearer token in the request header.  

```url
/Authorization/validate
```


## Strarting the microservice
1. create the package by running the command

```bash
mvn clean install
```
2. Run the created jar file present in the \target folder of the microservice

```bash
java -jar 'jar-fie-name'
```
##### By default it will run on port number 8008. So use the URL for sending the requests
```url
http://localhost:8008/
```

## Configuration
use the "application.properties" file present in the "/src/resource" folder for the configuration of the microservice. 

####  The default configuration
```properties
server.port=8008
server.servlet.context-path=/authorization

spring.datasource.url=jdbc:h2:mem:authorization_db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update

spring.h2.console.enabled=true

spring.h2.console.settings.web-allow-others=true
```
### Default Credentials
UserName : user
Password : user123
## About
The project is made during the Cognizant Full Stack Java Internship.
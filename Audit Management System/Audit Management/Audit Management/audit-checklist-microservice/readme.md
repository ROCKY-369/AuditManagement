# Audit Checklist Microservice

This is a microservice of the audit management system project. This microservice accepts HTTP requests to return the questions according to the audit type and receives the user's response and stores it in the H2 database.

## Api Endpoints

##### A valid JwtToken token should be present as a bearer token in the request header.

##### POST request to get the questions from the database according to the audit type. The auditType must be provided as the JSON body.  

```url
/getAuditQuestions
```
##### POST request to save the response of the questions should be sent to the following end point as JSON.

```url
/saveResponses
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
##### By default it will run on the port number 8092. So use the URL foe sending the requests
```url
http://localhost:8092/
```

## Configuration
use the "application.properties" file present in the "/src/resource" folder for the configuration of the microservice. 

####  The default configuration
```properties
server.port=8092
logging.level=info
server.port=8092

spring.h2.console.enabled=true
spring.datasource.patform=h2
spring.datasource.url=jdbc:h2:mem:auditchecklistdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto = update

logging.level.org.hibernate.stat=debug
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.show-sql=true
```
## About
The project is made during the Cognizant Full Stack Java Internship.
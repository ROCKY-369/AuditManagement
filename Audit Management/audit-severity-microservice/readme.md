# Audit Severity Microservice

This is a microservice of the audit management system project. This microservice accepts HTTP requests to return the project status according to the audit responses received for the audit questions and also can send back the history of all the audits.

## Api Endpoints

##### A valid JwtToken token should be present as a bearer token in the request header.
##### POST request to submit the project details of the audit as Json and it will receive the audit question response from the checklist microservice and predict the remedial actions that need to be taken.

```url
/projectExecutionStatus
```
##### GET request to get the history of all the audits and their status.  

```url
/getAuditHistory
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
##### By default it will run on port number 8009. So use the URL for sending the requests
```url
http://localhost:8009/
```

## Configuration
use the "application.properties" file present in the "/src/resource" folder for the configuration of the microservice. 

####  The default configuration
```properties
server.port=8009
logging.level.root=DEBUG

spring.application.name=audit-severity
spring.cloud.loadbalancer.ribbon.enable=false
#H2 Configuration
spring.datasource.url=jdbc:h2:mem:Audit
spring.datasource.driverClassName=org.h2.Driver
spring.h2.console.enabled=true
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto = update
spring.jpa.defer-datasource-initialization=true
spring.h2.console.settings.web-allow-others=true
spring.h2.console.path=/h2-console

spring.jpa.show-sql = true

logging.level.org.springframework=info
logging.level.com.cognizant=debug
```
## About
The project is made during the Cognizant Full Stack Java Internship.
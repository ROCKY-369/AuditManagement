# Audit Benchmark Microservice

This is a microservice of the audit management system project. This microservice accepts HTTP requests to return the benchmark of the audit on which the remedial actions need to be taken.

## Api Endpoints

##### A valid JwtToken token should be present as a bearer token in the request header.
##### GET request to get the benchmark of the audits in JSON format.  

```url
/AuditBenchmark
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
##### By default it will run on port number 9093. So use the URL for sending the requests
```url
http://localhost:9093/
```

## Configuration
use the "application.properties" file present in the "/src/resource" folder for the configuration of the microservice. 

####  The default configuration
```properties
server.port=9093
logging.level.org.hibernate.stat=debug

logging.level.org.springframework.web: DEBUG
logging.level.org.springframework.context=DEBUG

```
## About
The project is made during the Cognizant Full Stack Java Internship.
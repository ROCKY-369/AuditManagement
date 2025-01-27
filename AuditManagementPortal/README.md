#Audit Management System

The Audit Management System is a web-based platform to optimize auditing processes and risk management. The system uses a microservices architecture and includes four key services: Authorization, Checklist, Benchmark, and Severity. The system integrates a user-friendly front-end built with Angular and a powerful back-end powered by Spring Boot REST APIs. The application is deployed on AWS Elastic Beanstalk with a continuous integration and deployment (CI/CD) pipeline to ensure seamless updates and deployment.

Microservices Architecture: The application is split into four main microservices, each with a specific responsibility:

Authorization: Manages user authentication and role-based access control (RBAC).
Checklist: Allows users to create and manage audit checklists.
Benchmark: Provides benchmarks to compare audit results against predefined standards.
Severity: Classifies and prioritizes audit findings based on severity.
Front-End Portal: The user interface is developed using Angular, providing an interactive and intuitive experience for users.
Back-End API: The system is powered by Spring Boot, which serves as the foundation for building RESTful APIs that manage data and logic for each microservice.
Deployment: Deployed on AWS Elastic Beanstalk, ensuring scalability and high availability.
CI/CD Pipeline: Continuous Integration and Continuous Deployment setup to enable automatic and reliable updates.

# AuditManagementPortal

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 12.1.1.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.


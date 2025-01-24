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

[![Build and push microservices](https://github.com/Wayde2112/Microservices_Project/actions/workflows/build.yml/badge.svg)](https://github.com/Wayde2112/Microservices_Project/actions/workflows/build.yml)

# Microservices_Project
Exam project // ITS Cloud Specialist 2021-23



Microservices can be developed in any any techology , but they must comply with following constraints:

    Use HTTP/REST for synchronous communication
    Use at least two different database technology (RDBMS and NoSQL).
    Use a message broker (Kafka, Active MQ, Rabbit MQ) for asynchronous communications (ie: calling the Notification service)

Evaluation criteria:

    Microservices (0 to 5 points)
    Design patterns (0 to 5 points)
    Testing (0 to 5 points)
    Logging and tracing (0 to 5 points)
    CI/CD (0 to 5 points)
    Docker and Kubernetes (0 to 5 points)


## Authors

- [Lorenzo Avondo](https://github.com/LorenzoAvondo)
- [Leonardo Cionchi](https://github.com/LeonardoCionchi)
- [Riccardo Maldera](https://github.com/riccardo-maldera)
- [Giacomo Quaglia](https://github.com/giacomoquaglia)
- [Stefano Enanias Saldana Moreno](https://github.com/Wayde2112)

## Architecture

![Architecture](https://github.com/Wayde2112/Microservices_Project/blob/main/Architecture.png?raw=true)

## Tech Stack
### Books Microservices

- **Programming Language:** NodeJS with Express & Babel

- **Database:** MySQL

- **Logging:** Javascript Log



### Customers Microservices

**Programming Language:** Java with Spring

**Database:** PostgreSQL

**Logging:** Slf4j



### Borrowing Microservices

**Programming Language:** Java with Spring

**Database:** MongoDB Atlas

**Logging:** Slf4j

**Testing:** JUnit

**Testing Database:** MockMVC



### Notifications Microservices

**Programming Language:** Java with Spring

**Logging:** Slf4j

**Notification:** Kafka
## Project Tree

To deploy this project run

```bash
MICROSERVICES_PROJECT
├───.github
│   └───workflows
├───.idea
├───books-service
│   ├───.vscode
│   └───src
│       ├───controllers
│       ├───database
│       └───routes
├───borrowing-service
│   ├───.idea
│   │   ├───dataSources
│   │   │   ├───55906e67-7f58-45c6-bf08-63ad2778e3a6
│   │   │   │   └───storage_v2
│   │   │   │       └───_src_
│   │   │   │           └───database
│   │   │   │               └───postgres.edMnLQ
│   │   │   │                   └───schema
│   │   │   ├───5db2679a-6eff-40c1-b1f9-cbcca2ee3208
│   │   │   │   └───storage_v2
│   │   │   │       └───_src_
│   │   │   │           └───database
│   │   │   │               ├───CustomerDB._OSSGA
│   │   │   │               │   └───schema
│   │   │   │               └───postgres.edMnLQ
│   │   │   │                   └───schema
│   │   │   └───f9c73c8e-3cbe-47be-a777-ca19dbe4212a
│   │   │       └───storage_v2
│   │   │           └───_src_
│   │   │               └───database
│   │   │                   ├───CustomerDB._OSSGA
│   │   │                   │   └───schema
│   │   │                   └───postgres.edMnLQ
│   │   │                       └───schema
│   │   └───inspectionProfiles
│   ├───src
│   │   ├───main
│   │   │   ├───java
│   │   │   │   └───com
│   │   │   │       └───microservices
│   │   │   │           └───borrowing
│   │   │   │               ├───controller
│   │   │   │               ├───entity
│   │   │   │               ├───exceptions
│   │   │   │               ├───repository
│   │   │   │               └───service
│   │   │   └───resources
│   │   └───test
│   │       └───java
│   │           └───com
│   │               └───microservices
│   │                   └───borrowing
│   └───target
│       ├───classes
│       │   └───com
│       │       └───microservices
│       │           └───borrowing
│       │               ├───controller
│       │               ├───entity
│       │               ├───exceptions
│       │               ├───repository
│       │               └───service
│       └───test-classes
│           └───com
│               └───microservices
│                   └───customer
├───customer-service
│   ├───.idea
│   │   ├───dataSources
│   │   │   ├───55906e67-7f58-45c6-bf08-63ad2778e3a6
│   │   │   │   └───storage_v2
│   │   │   │       └───_src_
│   │   │   │           └───database
│   │   │   │               └───postgres.edMnLQ
│   │   │   │                   └───schema
│   │   │   ├───5db2679a-6eff-40c1-b1f9-cbcca2ee3208
│   │   │   │   └───storage_v2
│   │   │   │       └───_src_
│   │   │   │           └───database
│   │   │   │               ├───CustomerDB._OSSGA
│   │   │   │               │   └───schema
│   │   │   │               └───postgres.edMnLQ
│   │   │   │                   └───schema
│   │   │   └───f9c73c8e-3cbe-47be-a777-ca19dbe4212a
│   │   │       └───storage_v2
│   │   │           └───_src_
│   │   │               └───database
│   │   │                   ├───CustomerDB._OSSGA
│   │   │                   │   └───schema
│   │   │                   └───postgres.edMnLQ
│   │   │                       └───schema
│   │   └───inspectionProfiles
│   ├───src
│   │   ├───main
│   │   │   ├───java
│   │   │   │   └───com
│   │   │   │       └───microservices
│   │   │   │           └───customer
│   │   │   │               ├───controller
│   │   │   │               ├───entity
│   │   │   │               ├───repository
│   │   │   │               └───service
│   │   │   └───resources
│   │   └───test
│   │       └───java
│   │           └───com
│   │               └───microservices
│   │                   └───customer
│   └───target
│       ├───classes
│       │   └───com
│       │       └───microservices
│       │           └───customer
│       │               ├───controller
│       │               ├───entity
│       │               ├───repository
│       │               └───service
│       ├───generated-sources
│       │   └───annotations
│       ├───generated-test-sources
│       │   └───test-annotations
│       └───test-classes
│           └───com
│               └───microservices
│                   └───customer
└───notifications-service
    ├───.mvn
    │   └───wrapper
    └───src
        ├───main
        │   ├───java
        │   │   └───com
        │   │       └───microservices
        │   │           └───notifications
        │   │               └───routing
        │   └───resources
        └───test
            └───java
                └───com
                    └───microservices
                        └───notifications
```


## Usage/Examples

#### **Requirements**: Docker, Java, NodeJS

- First of all, you have to go on -> settings/secrets/actions to set *DOCKER_USERNAME* & *DOCKER_PASSWORD*
- Run the workflow on GitHub *"Build and push microservices"*
- Now run the *"docker-compose.yml"*

```
docker-compose up
```
- All the services are going to inizialize when you see all the containers running
```
[+] Running 6/6
 - Network microservices_project_default  Created                                                                                                                            1.1s 
 - Container customer-postgres            Created                                                                                                                            2.9s
 - Container borrowing-service            Created                                                                                                                            2.8s 
 - Container book-mysql                   Created                                                                                                                            2.9s 
 - Container books-service                Created                                                                                                                            0.2s
 - Container customer-service             Created                                                                                                                            0.2s 
Attaching to book-mysql, books-service, borrowing-service, customer-postgres, customer-service
```
- Now you're ready to do all the tests
- To remove the containers you have to run this command and automatically shut down all the instance.

```
docker-compose down
```
```
[+] Running 6/6
 - Container customer-service             Removed                                                                                                                            1.2s
 - Container books-service                Removed                                                                                                                            0.8s
 - Container borrowing-service            Removed                                                                                                                            1.8s
 - Container book-mysql                   Removed                                                                                                                            1.4s
 - Container customer-postgres            Removed                                                                                                                            0.9s
 - Network microservices_project_default  Removed                                                                                                                            0.7s
```

# kotlin-ktor-rest-api
A Modern Kotlin-Ktor RESTful API example. Connects to a PostgreSQL database and uses Exposed framework for database
operations. Focused on Clean Architecture, SOLID Principles and feature based development.

- Ktor Framework
- Kotlin
- Dependency Injection -> Koin
- Authorization -> JWT
- Database -> PostgreSQL
- ORM SQL Framework -> Exposed
- Ktor Client -> For External API calls
- Build Tool -> Gradle
- Server -> Tomcat

# Architecture
![github (6)](https://user-images.githubusercontent.com/86873858/131125468-99d372c5-2b55-473b-9f12-0fbd2c7e9bf7.png)

# Database Credentials
resources/application.conf
```
    database {
        exampleDatabaseUrl="jdbc:postgresql://localhost:5432/exampleDatabase"
        exampleDatabaseDriver="org.postgresql.Driver"
        exampleDatabaseUser="postgres"
        exampleDatabasePassword="Test1234"
    }
```
# Features
## - Health Check

GET /healthCheck</br>
&nbsp; Just returns a simple object</br>
## - Authentication

POST /createUser</br>
&nbsp; Registers a user to the db</br>
POST /login</br>
&nbsp; Returns a jwt token if success</br>
GET /userInfo (Needs Authroization token from login as Authorization header)</br>
&nbsp; Return user information</br>
## - Star Wars

GET /movie (Needs Authroization token from login as Authorization header)</br>
&nbsp; An External API call example. Returns a movie information from an external api

# FirApplication
The Masai Truck Application is a web-based application that helps to manage the trucks and their information. The application has three different roles: manager, driver, and guest. The manager can view all the details of the trucks, update or delete them. On the other hand, the driver can view only his own truck details, update or delete them. And the guest can only register themselves into the system.


# Tech Stack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Lambok
- Maven


# Features
- Users can register themselves into the system as a driver, manager, or guest.
- Users can log into the system and get a JWT token that is valid for 24 hours.
- Managers can view all the trucks in the system and their details, update or delete them.
- Drivers can view only their own truck details, update or delete them.
- Guests can register themselves into the system.


# Modules

- Login Module
- User Module
- Truck Module






# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
   server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/MasaiTruckDB
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

# API Root Endpoint
```
https://localhost:8080/
```
```
http://localhost:8080/swagger-ui/
```

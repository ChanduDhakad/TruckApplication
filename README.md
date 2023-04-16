# TruckApplication


# BookStoreApplication
Masai Book Store Application is a web application for a book store that allows users to register, login, browse books, add books to their cart, and purchase books. The application also includes features like tracking popular authors, refreshing the cart, analyzing the most number of unique books that the user can buy, and deleting an author

#Technologies Used

# Tech Stack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Lambok
- Maven







# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8080

    spring.datasource.url=jdbc:mysql://localhost:3306/TruckDB;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

# API Root Endpoint
```
https://localhost:8080/
```
```
http://localhost:8080/swagger-ui/
```

Authentication
The application uses Spring Security for authentication. Users can register and log in with their email and password.

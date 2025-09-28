 Student Login System

A simple **Student Login and Registration System** built with **Spring Boot**, **Thymeleaf**, **MySQL**, and **Spring Security**.

## Features

* Student registration with full name, email, username, and password.
* Secure login and authentication.
* Dashboard page after successful login.
* Validation for unique username and correct credentials.

## Technologies Used

* Java 17
* Spring Boot 3.5.6
* Spring MVC, Spring Data JPA, Spring Security
* Thymeleaf
* MySQL
* Bootstrap 5

## Prerequisites

* Java 17 installed
* MySQL installed
* Maven installed
* IDE (Eclipse, IntelliJ, or any Java IDE)

## Database Setup

1. Open MySQL Workbench or CLI.
2. Create the database:

```sql
CREATE DATABASE studentdb;
```

3. Create a MySQL user (if not already):

```sql
CREATE USER 'student'@'localhost' IDENTIFIED BY 'student123';
GRANT ALL PRIVILEGES ON studentdb.* TO 'student'@'localhost';
FLUSH PRIVILEGES;
```

4. Update `src/main/resources/application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb?useSSL=false&serverTimezone=UTC
spring.datasource.username=student
spring.datasource.password=student123

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

spring.thymeleaf.cache=false
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
spring.thymeleaf.mode=HTML

server.port=9090
```

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/AKRB1608/student-login-system.git
cd student-login-system
```

2. Build and run with Maven:

```bash
mvn clean install
mvn spring-boot:run
```

3. Open your browser and go to:

```
http://localhost:9090/
```

4. Use the navigation links to **Register** or **Login**.

## Project Structure

```
student-login-system
│
├─ src/main/java/com/studentloginsystem
│   ├─ controller/StudentController.java
│   ├─ model/Student.java
│   ├─ repository/StudentRepository.java
│   ├─ service/StudentService.java
│   └─ StudentloginsystemApplication.java
│
├─ src/main/resources/templates
│   ├─ index.html
│   ├─ login.html
│   ├─ register.html
│   └─ dashboard.html
│
└─ src/main/resources/application.properties
```

 Author

AKRB1608

-
Do you want me to do that next?

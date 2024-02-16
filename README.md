
# About

This project is a Java application that allows performing basic CRUD (Create, Read, Update, Delete) operations on a user database. It provides functionalities to manage user records such as adding new users, retrieving user information, updating user details and deleting users from the database.

## Requirements

- Java JDK installed
- MySQL installed
- MySQL database installed locally or created in IntelliJ IDEA with following data:
```sql
CREATE DATABASE workshop2
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;
```
```sql
CREATE TABLE users (
    id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    email varchar(255) NOT NULL UNIQUE,
    username varchar(255) NOT NULL,
    password varchar(60) NOT NULL
);
```

## Dependencies

To run this project, ensure the following dependencies are added to the `pom.xml` file:

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
<dependency>
    <groupId>org.mindrot</groupId>
    <artifactId>jbcrypt</artifactId>
    <version>0.4</version>
</dependency>
```

## Usage

1. Clone or download the repository.
2. Open the project in IntelliJ IDEA.
3. Set up a local MySQL connection in IntelliJ IDEA.
4. Run the application to perform operations on the user (workshop2) database by using one of the following classes:
   
   - MainDaoCreate (_only one user with a specific email can be created!_)
   - MainDaoRead
   - MainDaoUpdate
   - MainDaoDelete
   - MainDaoFindAll

5. You can adjust the values in these accordingly to your needs.

## Functionality

- Create: Add new user to the database.
- Read: Retrieve user information from the database.
- Update: Modify user details in the database.
- Delete: Remove user from the database.
- Find All: Display all users from the database.

## Contributors

Feel free to contribute to this project by submitting pull requests or reporting issues.

## License

MIT License
package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainDaoCreate {

  public static void main(String[] args) {

    User user = new User();
    user.setUserName("Ian");
    user.setEmail("ian@buziaczek.pl");
    user.setPassword("!m343423398?");

    UserDao userDao = new UserDao();
    User userDb = userDao.create(
        user); // do met. create wrzucamy usera stworzonego wyzej a po lewej user z utworzonym id w bazie
    /*System.out.println(
        "User created: " + "User ID = " + userDb.getId() + " username: " + userDb.getUserName()
            + " email: " + userDb.getEmail() + " password: " + userDao.hashPassword(
            userDb.getPassword()));*/
    System.out.println(userDb);
  }
}

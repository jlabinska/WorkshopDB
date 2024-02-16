package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainDaoUpdate {

  public static void main(String[] args) {

    UserDao userDao = new UserDao();
    User userToUpdate = userDao.read(1);

    userToUpdate.setUserName("Joasia");
    userToUpdate.setEmail("assia@gmail.com");
    userToUpdate.setPassword("piesek13");

    userDao.update(userToUpdate);


  }
}

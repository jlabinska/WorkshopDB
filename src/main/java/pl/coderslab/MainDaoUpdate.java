package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainDaoUpdate {

  public static void main(String[] args) {

    User user = new User();
    user.setId(1);
    user.setUserName("Asia");
    user.setEmail("blabla@gmail.com");
    user.setPassword("piesek13");

    UserDao userDao = new UserDao();
    userDao.update(user);


  }
}

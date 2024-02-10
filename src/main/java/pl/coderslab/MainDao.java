package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainDao {

  public static void main(String[] args) {

    // create:
    User user = new User();
    user.setUserName("Basia");
    user.setEmail("bla3@gmail.com");
    user.setPassword("kotek12");

    UserDao userDao = new UserDao();
    User userDb = userDao.create(user);   // do met. create wrzucamy usera stworzonego a po lewej user z utworzonym id w bazie
    System.out.println("User ID = " + userDb.getId());    // print user id

  // update:
    User user = new User();
    user.setId(1);
    user.setUserName("Asia");
    user.setEmail("blabla@gmail.com");
    user.setPassword("piesek13");

    UserDao userDao = new UserDao();
    userDao.update(user);


  }
}

package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainDaoFindAll {

  public static void main(String[] args) {

    UserDao userDao = new UserDao();
    User[] allUsers = userDao.findAll();
    /*for (int i = 0; i < allUsers.length; i++) {
      System.out.println("User[" + i + "] = {id: " + allUsers[i].getId() + ", username: "
          + allUsers[i].getUserName() + ", email: " + allUsers[i].getEmail() + ", password: "
          + allUsers[i].getPassword());*/
    for (User u : allUsers) {
      System.out.println(u);
    }

  }
}

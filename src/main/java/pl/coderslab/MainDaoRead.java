package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

public class MainDaoRead {

  public static void main(String[] args) {

    UserDao userDao = new UserDao();
    User userDb = userDao.read(8);
 /*   System.out.println(
        "User searched: " + "User ID = " + userDb.getId() + " username: " + userDb.getUserName()
            + " email: " + userDb.getEmail() + " password: " + userDb.getPassword());*/
    System.out.println(userDb);
  }

}

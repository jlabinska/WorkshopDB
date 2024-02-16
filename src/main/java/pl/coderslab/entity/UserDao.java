package pl.coderslab.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.DbUtil;

public class UserDao {

  private static final String CREATE_USER_QUERY = """
      INSERT INTO users(username, email, password) VALUES (?, ?, ?);
      """;

  private static final String READ_USER_QUERY = """
      SELECT * FROM users WHERE id = ?;
      """;

  private static final String UPDATE_USER_QUERY = """
      UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?;
      """;

  private static final String DELETE_USER_QUERY = """
      DELETE FROM users WHERE id = ?;
      """;
  private static final String SELECT_ALL_USERS_QUERY = """
      SELECT * FROM users;
      """;

  /*metoda create przyjmuje jeden parametr tj.obiekt klasy User, który ma zostać zapisany jako nowy wiersz w bazie.*/
  public User create(User user) {
    try (Connection connection = DbUtil.connect()) {
      PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_QUERY,
          Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, user.getUserName());
      preparedStatement.setString(2, user.getEmail());
      preparedStatement.setString(3, hashPassword(user.getPassword()));
      preparedStatement.executeUpdate();
      // do tego momentu stworzenie usera
      // pobieramy wstawiony do bazy identyfikator, a następnie ustawiamy id obiektu user:
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      if (resultSet.next()) {
        user.setId(resultSet.getInt(1));
      }
      return user;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;    // dostal exception i nie ma update'u na bazie a musi cos zwrocic
    }
  }

  /*metoda read przyjmue jeden parametr: id wiersza do wczytania.*/
  public User read(int userId) {
    try (Connection connection = DbUtil.connect()) {
      PreparedStatement preparedStatement = connection.prepareStatement(READ_USER_QUERY);
      preparedStatement.setInt(1, userId);  // userId ktorego szukamy
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        User user = new User();
        user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUserName(resultSet.getString("username"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        return user;
      } else {
        System.out.println("Searched User ID does not exist in the database.");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /*metoda update przyjmuje  jeden parametr tj. obiekt klasy User, który ma zostać zmodyfikowany.*/
  public void update(User user) {
    try (Connection connection = DbUtil.connect()) {
      PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_QUERY);
      preparedStatement.setString(1, user.getUserName());
      preparedStatement.setString(2, user.getEmail());
      preparedStatement.setString(3, hashPassword(user.getPassword()));
      preparedStatement.setInt(4, user.getId());
      int rowsUpdated = preparedStatement.executeUpdate();
      System.out.println(rowsUpdated + " row(s) updated.");

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public void delete(int userId) {
    try (Connection connection = DbUtil.connect()) {
      PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_QUERY);
      preparedStatement.setInt(1, userId);
      int rowsDeleted = preparedStatement.executeUpdate();
      System.out.println((rowsDeleted + " row(s) removed."));

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public User[] findAll() {
    User[] users = new User[0];
    try (Connection connection = DbUtil.connect()) {
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_QUERY);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        User user = new User();
        user.setId(resultSet.getInt(1));
        user.setUserName(resultSet.getString(2));
        user.setEmail(resultSet.getString(3));
        user.setPassword(resultSet.getString(4));
        users = addToArray(user,
            users); //zapisujemy nowa powiekszona tablice w swojej tablicy users
      }
      return users;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public String hashPassword(String password) {
    return BCrypt.hashpw(password, BCrypt.gensalt());
  }

  private User[] addToArray(User user, User[] users) {
    User[] tmpUsers = Arrays.copyOf(users, users.length + 1);

    tmpUsers[users.length] = user;
    return tmpUsers;
  }


}

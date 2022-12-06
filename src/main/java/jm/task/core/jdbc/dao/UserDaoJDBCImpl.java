//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//    public UserDaoJDBCImpl() {
//
//    }
//
//    public void createUsersTable() {
//        String SQL =
//                "CREATE TABLE Users(id BIGINT not null PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), last_name VARCHAR(50), age TINYINT(3));";
//        try (Statement statement = Util.getMySQLConnection().createStatement()) {
//            statement.executeUpdate(SQL);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void dropUsersTable() {
//        String SQL = "DROP TABLE IF EXISTS Users";
//        try (Statement statement = Util.getMySQLConnection().createStatement()) {
//            statement.executeUpdate(SQL);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        try (PreparedStatement statement = Util.getMySQLConnection()
//                .prepareStatement("INSERT INTO users (name, last_name, age) VALUES (?, ?, ?)")) {
//            statement.setString(1, name);
//            statement.setString(2, lastName);
//            statement.setByte(3, age);
//            statement.executeUpdate();
//            System.out.println("User с именем – " + name + " добавлен в базу данных");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeUserById(long id) {
//        try (PreparedStatement statement = Util.getMySQLConnection()
//                .prepareStatement("DELETE FROM users WHERE id = ?")) {
//            statement.setLong(1, id);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> userList = new ArrayList<>();
//        String SQL = "SELECT * FROM users";
//        try (Statement statement = Util.getMySQLConnection().createStatement()) {
//            ResultSet rs = statement.executeQuery(SQL);
//            while (rs.next()) {
//                User user = new User();
//
//                user.setId(rs.getLong("id"));
//                user.setName(rs.getString("name"));
//                user.setLastName(rs.getString("last_name"));
//                user.setAge(rs.getByte("age"));
//
//                userList.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return userList;
//    }
//
//    public void cleanUsersTable() {
//        String SQL = "TRUNCATE TABLE users";
//        try (Statement statement = Util.getMySQLConnection().createStatement()) {
//            statement.executeUpdate(SQL);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}

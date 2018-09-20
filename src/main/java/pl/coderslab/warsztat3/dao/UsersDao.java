package pl.coderslab.warsztat3.dao;

import pl.coderslab.warsztat3.db.DbUtil;
import pl.coderslab.warsztat3.model.NotFoundException;
import pl.coderslab.warsztat3.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao {
    // ZAPYTANIA SQL
    private static final String CREATE_users_QUERY = "INSERT INTO users (username, email, password, user_group_id) VALUES (?,?,?,?)";
    private static final String DELETE_users_QUERY = "DELETE FROM users where id = ?";
    private static final String FIND_ALL_users_QUERY = "SELECT * FROM users where user_group_id = ?";
    private static final String GET_ALL_users_QUERY = "SELECT * FROM users ";
    private static final String READ_users_QUERY = "Select * from users where id = ?";
    private static final String UPDATE_users_QUERY = "UPDATE users SET username = ?, email = ?, user_group_id=? WHERE id = ?";

    /**
     * usuwanie po id
     */
    public static void removeProduct(int id) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_users_QUERY)) {
            ;
            preparedStatement.setInt(1, id);
            if (!preparedStatement.execute()) {
                throw new NotFoundException("No product with id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static Users getById(int id) {
        Users user = new Users ();
        try (Connection connection = DbUtil.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(READ_users_QUERY)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user.setId(resultSet.getInt("id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPasword(resultSet.getString("password"));
                    user.setUser_Group_id(resultSet.getInt("user_group_id"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }
    /**
     * wyswietl wszystko z
     */
    public static List<Users> findAll(int id) {
        List<Users> users = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_users_QUERY)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Users user = new Users();
                    user.setId(resultSet.getInt("id"));
                    user.setUsername(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("lastname"));
                    user.setPasword(resultSet.getString("password"));
                    user.setUser_Group_id(resultSet.getInt("user_group_id"));
                    users.add(user);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Cos sie nie powiodło");
            }
        }catch (SQLException E){
        System.out.println("upss zle");
        }
        return users;
    }
    /**
     * Create book
     */
        public static Users create (Users user)  {
            try (Connection connection = DbUtil.getConnection();
                 PreparedStatement insertStm = connection.prepareStatement(CREATE_users_QUERY,
                         PreparedStatement.RETURN_GENERATED_KEYS)) {
                insertStm.setString(1, user.getUsername());
                insertStm.setString(2, user.getEmail());
                insertStm.setString(3, user.getPasword());
                insertStm.setInt(4, user.getUser_Group_id());
                int result = insertStm.executeUpdate();

                if (result != 1) {
                    throw new RuntimeException("Execute update returned " + result);
                }

                try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                    if (generatedKeys.first()) {
                        user.setId(generatedKeys.getInt(1));
                        return user;
                    } else {
                        throw new RuntimeException("Generated key was not found");
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Cos sie nie powiodło");
            }
            return null;
        }

    public static void update(Users user) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_users_QUERY);) {
            statement.setInt(4, user.getId());
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getUser_Group_id());


            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }

    }
    public static List<Users> getAll() {
        List<Users> users = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_users_QUERY)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Users user = new Users();
                    user.setId(resultSet.getInt("id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPasword(resultSet.getString("password"));
                    user.setUser_Group_id(resultSet.getInt("user_group_id"));
                    users.add(user);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Cos sie nie powiodło");
            }
        }catch (SQLException E){
            System.out.println("upss zle");
        }
        return users;
    }
    }


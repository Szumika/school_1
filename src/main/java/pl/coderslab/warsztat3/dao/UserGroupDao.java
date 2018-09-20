package pl.coderslab.warsztat3.dao;

import pl.coderslab.warsztat3.db.DbUtil;
import pl.coderslab.warsztat3.model.NotFoundException;
import pl.coderslab.warsztat3.model.User_Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserGroupDao {
    // ZAPYTANIA SQL
    private static final String CREATE_user_group_QUERY = "INSERT INTO user_group (name) VALUES (?)";
    private static final String DELETE_user_group_QUERY = "DELETE FROM user_group where id = ?";
    private static final String FIND_ALL_user_group_QUERY = "SELECT * FROM user_group";
    private static final String READ_user_group_QUERY = "Select * from user_group where id = ?";
    private static final String UPDATE_user_group_QUERY = "UPDATE	user_group SET name = ? WHERE id = ?";

    /**
     * usuwanie po id
     */
    public static void removeProduct(int id) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_user_group_QUERY)) {
            ;
            preparedStatement.setInt(1, id);
            if (!preparedStatement.execute()) {
                throw new NotFoundException("No product with id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public  static User_Group getById(int id) {
        User_Group user_grp = new User_Group();
        try (Connection connection = DbUtil.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(READ_user_group_QUERY)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user_grp.setId(resultSet.getInt("id"));
                    user_grp.setName(resultSet.getString("name"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user_grp;
    }
    /**
     * wyswietlanie po id
     */
    public static User_Group read(Integer id) {
        User_Group user_grp = new User_Group();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_user_group_QUERY);

        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    user_grp.setId(resultSet.getInt("id"));
                    user_grp.setName(resultSet.getString("name"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return user_grp;

    }
    /**
     * wyswietl wszystko z
     */
    public static List<User_Group> findAll() {
        List<User_Group> users_group = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_user_group_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                User_Group user_grp = new User_Group();
                user_grp.setId(resultSet.getInt("id"));
                user_grp.setName(resultSet.getString("name"));
                users_group.add(user_grp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return users_group;
    }
    /**
     * Create book
     */
    public static User_Group create (User_Group user_group)  {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_user_group_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, user_group.getName());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    user_group.setId(generatedKeys.getInt(1));
                    return user_group;
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
    public static void delete(Integer id) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_user_group_QUERY);) {
            statement.setInt(1, id);
            boolean deleted = statement.execute();
            if (!deleted) {
                throw new NotFoundException("Product not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
    }
    public static void update(User_Group user_group) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_user_group_QUERY);) {
            statement.setInt(2, user_group.getId());
            statement.setString(1, user_group.getName());


            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }

    }
}


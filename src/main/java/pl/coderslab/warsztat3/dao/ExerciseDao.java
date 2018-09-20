package pl.coderslab.warsztat3.dao;

import pl.coderslab.warsztat3.db.DbUtil;
import pl.coderslab.warsztat3.model.Exercise;
import pl.coderslab.warsztat3.model.NotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDao {
    // ZAPYTANIA SQL
    private static final String CREATE_exercise_QUERY = "INSERT INTO exercise (title, description) VALUES (?,?)";
    private static final String DELETE_exercise_QUERY = "DELETE FROM exercise where id = ?";
    private static final String FIND_ALL_exercise_QUERY = "SELECT * FROM exercise";
    private static final String READ_exerciseQUERY = "Select * from exercise where id = ?";
    private static final String UPDATE_exercise_QUERY = "UPDATE exercise SET title = ?, description = ? WHERE id = ?";

    /**
     * usuwanie po id
     */
    public static void removeProduct(int id) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_exercise_QUERY)) {
            ;
            preparedStatement.setInt(1, id);
            if (!preparedStatement.execute()) {
                throw new NotFoundException("No product with id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static Exercise getById(int id) {
        Exercise exercise = new Exercise();
        try (Connection connection = DbUtil.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(READ_exerciseQUERY)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    exercise.setId(resultSet.getInt("id"));
                    exercise.setTitle(resultSet.getString("title"));
                    exercise.setDescription(resultSet.getString("description"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return exercise;
    }
    /**
     * wyswietl wszystko z
     */
    public static List<Exercise> findAll() {
        List<Exercise> exercises = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_exercise_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Exercise exercise = new Exercise();
                exercise.setId(resultSet.getInt("id"));
                exercise.setTitle(resultSet.getString("title"));
                exercise.setDescription(resultSet.getString("description"));
                exercises.add(exercise);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return exercises;
    }
    /**
     * Create book
     */
        public static Exercise create (Exercise exercise)  {
            try (Connection connection = DbUtil.getConnection();
                 PreparedStatement insertStm = connection.prepareStatement(CREATE_exercise_QUERY,
                         PreparedStatement.RETURN_GENERATED_KEYS)) {
                insertStm.setString(1, exercise.getTitle());
                insertStm.setString(2, exercise.getDescription());
                int result = insertStm.executeUpdate();

                if (result != 1) {
                    throw new RuntimeException("Execute update returned " + result);
                }

                try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                    if (generatedKeys.first()) {
                        exercise.setId(generatedKeys.getInt(1));
                        return exercise;
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
    public static void update(Exercise exercise) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_exercise_QUERY);) {
            statement.setInt(3, exercise.getId());
            statement.setString(1, exercise.getTitle());
            statement.setString(2, exercise.getDescription());


            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }

    }
    }


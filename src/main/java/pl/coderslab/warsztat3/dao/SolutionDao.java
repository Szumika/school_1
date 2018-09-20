package pl.coderslab.warsztat3.dao;

import pl.coderslab.warsztat3.db.DbUtil;
import pl.coderslab.warsztat3.model.NotFoundException;
import pl.coderslab.warsztat3.model.Solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolutionDao {
    // ZAPYTANIA SQL
    private static final String CREATE_solution_QUERY = "INSERT INTO solution (created, updated, description, exercise_id, users_id) VALUES (?,?,?,?,?)";
    private static final String DELETE_solution_QUERY = "DELETE FROM solution where id = ?";
    private static final String FIND_ALL_solution_QUERY = "SELECT * FROM solution ORDER BY created DESC LIMIT 5;";
    private static final String READ_solution_QUERY = "Select * from solution where users_id = ?";
    private static final String UPDATE_solution_QUERY = "UPDATE solution SET created = ?, updated = ?, description=?, exercise_id=?,users_id=? WHERE id = ?";
    private static final String GET_solution_QUERY_MAIN_PAGE = "SELECT * FROM solution ORDER BY created DESC LIMIT ? ;";
    /**
     * usuwanie po id
     */
    public static void removeProduct(int id) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_solution_QUERY)) {
            ;
            preparedStatement.setInt(1, id);
            if (!preparedStatement.execute()) {
                throw new NotFoundException("No product with id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static List<Solution> getById(int id) {
        List<Solution> solutions = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_solution_QUERY)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Solution solution = new Solution();
                    solution.setId(resultSet.getInt("id"));
                    solution.setCreated(resultSet.getString("created"));
                    solution.setUpdated(resultSet.getString("updated"));
                    solution.setDescription(resultSet.getString("description"));
                    solution.setExercise_id(resultSet.getInt("exercise_id"));
                    solution.setUsers_id(resultSet.getInt("users_id"));
                    solutions.add(solution);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Cos sie nie powiodło");
            }
        }catch (SQLException E){

        }
            return solutions;
        }
    /**
     * wyswietl wszystko z
     */
    public static List<Solution> findAll() {
        List<Solution> solutions = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_solution_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getString("created"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUsers_id(resultSet.getInt("users_id"));
                solutions.add(solution);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return solutions;
    }
    /**
     * Create book
     */
        public static Solution create (Solution solution)  {
            try (Connection connection = DbUtil.getConnection();
                 PreparedStatement insertStm = connection.prepareStatement(CREATE_solution_QUERY,
                         PreparedStatement.RETURN_GENERATED_KEYS)) {
                insertStm.setString(1, solution.getCreated());
                insertStm.setString(2, solution.getUpdated());
                insertStm.setString(3, solution.getDescription());
                insertStm.setInt(4, solution.getExercise_id());
                insertStm.setInt(5, solution.getUsers_id());
                int result = insertStm.executeUpdate();

                if (result != 1) {
                    throw new RuntimeException("Execute update returned " + result);
                }

                try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                    if (generatedKeys.first()) {
                        solution.setId(generatedKeys.getInt(1));
                        return solution;
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

    public static void update(Solution solution) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_solution_QUERY);) {
            statement.setInt(6, solution.getId());
            statement.setString(1, solution.getCreated());
            statement.setString(2, solution.getUpdated());
            statement.setString(3, solution.getDescription());
            statement.setInt(4, solution.getUsers_id());
            statement.setInt(4, solution.getExercise_id());


            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }

    }
    public static List<Solution> getAll(int param) {
        List<Solution> solutions = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_solution_QUERY_MAIN_PAGE);
             ResultSet resultSet = statement.executeQuery()) {
            statement.setInt(1,param);
            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getString("created"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUsers_id(resultSet.getInt("users_id"));
                solutions.add(solution);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cos sie nie powiodło");
        }
        return solutions;
    }
    }


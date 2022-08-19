/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author rafae
 */
public class TaskController {

    public void save(Task task) throws SQLException {
        String sql = "INSERT INTO tasks ("
                + "name,"
                + "description,"
                + "completed, "
                + "note,"
                + "createdAt,"
                + "updatedAt, "
                + "projectId"
                + ") VALUES(?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setBoolean(3, task.isCompleted());
            statement.setString(4, task.getNote());
            statement.setDate(5, new Date(task.getCreatedAt().getTime()));
            statement.setDate(6, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(7, task.getProjectId());
            statement.execute();

        } catch (SQLException err) {
            throw new SQLException("Error during save task");
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
     
    }

    public void deleteById(int id) throws SQLException {
        String sql = "DELETE FROM tasks WHERE id = ?";

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException err) {
            throw new SQLException("Error during delete task");
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }

    public void update(Task task) throws SQLException {

        String sql = "UPDATE tasks SET "
                + "name = ?,"
                + "description = ?,"
                + "completed = ?,"
                + "note = ?,"
                + "createdAt = ?,"
                + "updatedAt = ?, "
                + "projectId = ? "
                + "WHERE id = ?";

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setBoolean(3, task.isCompleted());
            statement.setString(4, task.getNote());
            statement.setDate(5, new Date(task.getCreatedAt().getTime()));
            statement.setDate(6, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(7, task.getProjectId());
            statement.setInt(8, task.getId());

            statement.execute();

        } catch (SQLException err) {
            throw new SQLException("Fail during update task");
        } finally {

            ConnectionFactory.closeConnection(conn, statement);
        }


    }

    public List<Task> getAllTasks(int projectId) throws SQLException {

        String sql = "SELECT * FROM tasks WHERE projectId = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Task> tasks = new ArrayList<Task>();

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareCall(sql);

            statement.setInt(1, projectId);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setCompleted(resultSet.getBoolean("completed"));
                task.setNote(resultSet.getString("note"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                task.setProjectId(resultSet.getInt("projectId"));

                tasks.add(task);
            }
        } catch (SQLException err) {
            throw new SQLException("Fail during get tasks");
        } finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }

        return tasks;
    }

}

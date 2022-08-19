package controller;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rafae
 */
public class ProjectController {
    
    public void save(Project project) throws SQLException {
        String sql = "INSERT INTO projects"
                + "(name, description, createdAt, updatedAt) "
                + "VALUES (? ,? ,? ,?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
        
            statement.execute();
            
        }catch(SQLException err) {
            throw new SQLException("Error during save project", err);
        }finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
       
    }
    
    public void deleteById(int id) throws SQLException {
        String sql = "DELETE  FROM projects WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id);
      
            statement.execute();
            
        } catch(SQLException err) {
            throw new SQLException("Error during project delete", err);
        }finally {
               ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void update(Project project) throws SQLException{
        String sql = "UPDATE projects SET "
                + "name = ? ,"
                + "description = ? ,"
                + "createdAt = ? ,"
                + "updatedAt = ? ,";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(3, new Date(project.getUpdatedAt().getTime()));
        } catch(SQLException err) {
            throw new SQLException("Error during project update", err);
            
        }finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    
    }
    
    public List<Project> getAllProjects(int id) throws SQLException {
        
        String sql = "SELECT * FROM projects WHERE ID = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Project> projects = new ArrayList<Project>();
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            
           resultSet = statement.executeQuery();
           
           while (resultSet.next()){
               Project project = new Project();
               project.setName(resultSet.getString("name"));
               project.setDescription(resultSet.getString("description"));
               project.setCreatedAt(resultSet.getDate("createdAt"));
               project.setUpdatedAt(resultSet.getDate("updatedAt"));
               
               projects.add(project);
           }
        } catch (SQLException err) {
            throw new SQLException("Error during get all projects", err);
        } finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        
        return projects;
    }
}

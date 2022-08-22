/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package TodoApp;

import controller.ProjectController;
import controller.TaskController;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Project;
import model.Task;
import util.ConnectionFactory;

public class App {

    public static void main(String[] args) {
/*
        ProjectController projectController = new ProjectController();
        TaskController taskController = new TaskController();

        Project project = new Project();
        Project project2 = new Project();

        project.setName("House");
        project.setDescription("Daily tasks of my house");
        project.setUpdatedAt(new Date());

        project2.setName("College");
        project2.setDescription("Daily tasks of college");
        project2.setUpdatedAt(new Date());

        Task task = new Task();
        Task task2 = new Task();

        task.setName("Make lunch");
        task.setDescription("Make lunch for the family :)");
        task.setCompleted(false);
        task.setNote("Dont' add too much salt to the food");
        task.setProjectId(2);
        task.setUpdatedAt(new Date());
        task.setDeadline(new Date());

        task2.setName("Wash the house");
        task2.setDescription("Full house cleaning");
        task2.setCompleted(true);
        task2.setNote("Clean the bathroom!");
        task2.setProjectId(2);
        task2.setDeadline(new Date());
        task2.setUpdatedAt(new Date());

        try {
//      Save Projects;;
            projectController.save(project);
            projectController.save(project2);

//      Update project
            project.setId(1);
            project.setName("BIG HOUSE");
            projectController.update(project);

//      Get all projects by id            
            System.out.println(projectController.getAllProjects(2));

//      Delete project
            projectController.deleteById(project.getId());
            
//      Save Task
            taskController.save(task);
            taskController.save(task2);

//      Update Task
            task.setName("Make dinner");
            task.setId(1);
            taskController.update(task);

//      Get all tasks by Project Id
            System.out.println(taskController.getAllTasks());

//      Delete Task
            taskController.deleteById(task.getId());
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
    }
}

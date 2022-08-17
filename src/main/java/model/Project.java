/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
/**
 *
 * @author rafae
 */
public class Project {
    int id;
    String name;
    String description;
    Date createdAt;
    Date updatedAt;

    public Project(
            int id,
            String name,
            String description,
            Date createdAt,
            Date updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}

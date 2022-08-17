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
public class Task {
    int id;
    String name;
    String description;
    boolean completed;
    String note;
    Date createdAt;
    Date updatedAt;
    
    public Task(
    int id,
    String name,
    String description,
    boolean completed,
    String note,
    Date createdAt,
    Date updatedAt
   ){
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.note = note;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", name=" + name + ", description=" + description + ", completed=" + completed + ", note=" + note + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    

}

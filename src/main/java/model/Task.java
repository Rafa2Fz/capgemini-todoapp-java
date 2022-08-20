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
    private String name;
    String description;
    boolean completed;
    String note;
    int projectId;
    Date deadline;
    Date createdAt;
    Date updatedAt;
    
    
    public Task(
    int id,
    String name,
    String description,
    boolean completed,
    String note,
    Date deadline,
    Date createdAt,
    Date updatedAt,
    int projectId
   ){
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.note = note;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.projectId = projectId;
    }
    
    public Task () {
        this.createdAt = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

       public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", name=" + name + ", description=" + description + ", completed=" + completed + ", note=" + note + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    

}

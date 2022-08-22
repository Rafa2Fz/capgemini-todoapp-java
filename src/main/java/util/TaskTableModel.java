/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author rafae
 */
public class TaskTableModel extends AbstractTableModel {
    private String[] columns = {"Name", "Description", "Note", "Deadline", "Completed", "Edit", "Delete"};
    List<Task> tasks = new ArrayList<>();
    
    
    @Override
    public int getRowCount() {
        return this.tasks.size();
    }

    @Override
    public int getColumnCount() {
       return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                return tasks.get(rowIndex).getName();
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                return tasks.get(rowIndex).getNote();
            case 3:
             return tasks.get(rowIndex).getDeadline();
            case 4:
             return tasks.get(rowIndex).isCompleted();
            case 5:
             return "";
            case 6:
             return "";
            default:
            return "Data not found";
        }
    }
    
    @Override
    public String getColumnName(int columnId){
        return columns[columnId];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return columnIndex == 4;
    }
     @Override
    public void setValueAt(Object aValue,int rowIndex, int columnIndex){
       tasks.get(rowIndex).setCompleted((boolean) aValue);
    }
   public Class<?> getColumnClass(int columnIndex) {
        if(tasks.isEmpty()){
            return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass();
    }
    public String[] getColumns(){
        return this.columns;
    }
    
    public void setTasks(List<Task> tasks){
        this.tasks = tasks;
    }
    
    public List<Task> getTasks() {
      return this.tasks;  
    }
    
}

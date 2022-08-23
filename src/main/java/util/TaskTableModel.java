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
        return switch (columnIndex) {
            case 0 -> tasks.get(rowIndex).getName();
            case 1 -> tasks.get(rowIndex).getDescription();
            case 2 -> tasks.get(rowIndex).getNote();
            case 3 -> tasks.get(rowIndex).getDeadline();
            case 4 -> tasks.get(rowIndex).isCompleted();
            case 5 -> "";
            case 6 -> "";
            default -> "Data not found";
        };
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

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

}

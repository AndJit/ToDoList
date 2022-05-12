package dev.testapp.todo.ToDoList.sorages;

import dev.testapp.todo.ToDoList.entities.Task;

import java.util.ArrayList;
import java.util.List;

public class TasksStorage {

    private List<Task> taskList = new ArrayList<>();

    public List<Task> getAllTasks(){
        return taskList;
    }

    public void save(Task task){
        taskList.add(task);
    }

    public Task findTaskById(int id){
        try {
            return taskList.get(id);
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public void deleteTask(int id) {
        taskList.remove(id);
    }
}

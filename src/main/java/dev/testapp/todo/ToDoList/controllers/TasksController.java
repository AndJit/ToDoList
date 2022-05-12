package dev.testapp.todo.ToDoList.controllers;

import dev.testapp.todo.ToDoList.entities.Task;
import dev.testapp.todo.ToDoList.sorages.TasksStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
public class TasksController {

    @Autowired
    private TasksStorage tasksStorage;

    @PreAuthorize("hasRole('ROLE_CREATE')")
    @PostMapping("/create")
    public Map<String, String> createTask(@RequestBody Map<String, String> payload){
        String description = payload.get("description");
        String completed = payload.get("completed");
        Task task = new Task(description, Boolean.parseBoolean(completed));
        tasksStorage.save(task);
        return Collections.singletonMap("response" , "successful");
    }

    @PreAuthorize("hasRole('ROLE_READ')")
    @GetMapping("/{id}")
    public Task readTask(@PathVariable int id){
        Task task = tasksStorage.findTaskById(id);
        return task;
    }

    @PreAuthorize("hasRole('ROLE_READ')")
    @GetMapping("/list")
    public List<Task> readTasks(){
        return tasksStorage.getAllTasks();
    }

    @PreAuthorize("hasRole('ROLE_UPDATE')")
    @PostMapping("/update/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Map<String, String> payload){
        String description = payload.get("description");
        String completed = payload.get("completed");
        Task task = tasksStorage.findTaskById(id);
        if (task != null) {
            if (description != null) task.setDescription(description);
            if (completed != null) task.setCompleted(Boolean.parseBoolean(completed));
        }
        return task;
    }


    @PreAuthorize("hasRole('ROLE_DELETE')")
    @PostMapping("/delete/{id}")
    public Map<String, String> deleteTask(@PathVariable int id){
        Task task = tasksStorage.findTaskById(id);
        if (task != null) tasksStorage.deleteTask(id);
        return Collections.singletonMap("response" , "successful");
    }



}

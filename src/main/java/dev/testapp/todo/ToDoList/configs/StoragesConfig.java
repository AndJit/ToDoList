package dev.testapp.todo.ToDoList.configs;

import dev.testapp.todo.ToDoList.sorages.TasksStorage;
import dev.testapp.todo.ToDoList.sorages.UsersStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoragesConfig {

    @Bean
    public UsersStorage getUsersStorage(){
        return new UsersStorage();
    }

    @Bean
    public TasksStorage getTasksStorage(){
        return new TasksStorage();
    }
}

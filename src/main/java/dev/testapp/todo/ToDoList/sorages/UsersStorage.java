package dev.testapp.todo.ToDoList.sorages;

import dev.testapp.todo.ToDoList.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UsersStorage{

    private List<User> users = new ArrayList<>();

    public void save(User user){
        users.add(user);
    }

    public User findUserByName(String name){
        User user = users.stream()
                .filter(dbUser -> name.equals(dbUser.getName())).findFirst().orElse(null);
        return user;
    }


}

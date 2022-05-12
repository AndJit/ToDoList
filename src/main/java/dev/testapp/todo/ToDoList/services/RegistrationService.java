package dev.testapp.todo.ToDoList.services;

import dev.testapp.todo.ToDoList.entities.User;
import dev.testapp.todo.ToDoList.sorages.UsersStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RegistrationService {

    @Autowired
    private UsersStorage usersStorage;
    public boolean registerUser(String name, String password) throws NullPointerException {
        if (name == null || password == null) throw new NullPointerException();
        User user = new User(name, password);
        user.setRights(Arrays.asList(User.Right.CREATE, User.Right.READ, User.Right.UPDATE, User.Right.DELETE));
        if (usersStorage.findUserByName(name) == null){
            usersStorage.save(user);
            return true;
        }
        return false;
    }


}

package dev.testapp.todo.ToDoList.services;

import dev.testapp.todo.ToDoList.entities.User;
import dev.testapp.todo.ToDoList.sorages.UsersStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TodoUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersStorage usersStorage;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User dbUser = usersStorage.findUserByName(username);
         if (dbUser != null) {
             return new org.springframework.security.core.userdetails.User(dbUser.getName(), dbUser.getPassword(), dbUser.getRights());
         }else {
             throw new UsernameNotFoundException("User not found");
         }
    }

}

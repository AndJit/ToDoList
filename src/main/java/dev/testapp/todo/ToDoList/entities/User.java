package dev.testapp.todo.ToDoList.entities;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String password;

    private List<Right> rights;

    public User(){

    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List getRights() {
        return rights;
    }

    public void setRights(List<Right> rights) {
        this.rights = rights;
    }

    public void deleteRight(Right right){
        rights.remove(right);
    }
    public enum Right implements GrantedAuthority {

        CREATE, READ, UPDATE, DELETE;

        @Override
        public String getAuthority() {
            return "ROLE_" + name();
        }
    }
}

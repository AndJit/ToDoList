package dev.testapp.todo.ToDoList.controllers;

import dev.testapp.todo.ToDoList.entities.User;
import dev.testapp.todo.ToDoList.services.JwtProvider;
import dev.testapp.todo.ToDoList.sorages.UsersStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsersStorage usersStorage;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping
    public ResponseEntity<Map<String, Object>> auth(@RequestBody Map<String, String> payload){
        Map<String, Object> responseData = new HashMap();
        int statusCode;
        try {
            String name = payload.get("username");
            String password = payload.get("password");

            User dbUser = usersStorage.findUserByName(name);
            String token = null;
            if (dbUser != null && dbUser.getPassword().equals(password)) token = jwtProvider.generateToken(name, password);
            if (token != null) {
                responseData.put("response", token);
                statusCode = 200;
            }else {
                responseData.put("response", "user not found");
                statusCode = 404;
            }
        }catch (NullPointerException e){
            responseData.put("response", "invalid request");
            statusCode = 400;
        } catch (Exception e){
            responseData.put("response", "server exception");
            statusCode = 503;
            e.printStackTrace();
        }
        return new ResponseEntity<>(responseData, HttpStatus.valueOf(statusCode));
    }

}

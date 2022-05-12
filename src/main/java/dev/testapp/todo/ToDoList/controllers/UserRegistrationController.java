package dev.testapp.todo.ToDoList.controllers;

import dev.testapp.todo.ToDoList.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> registration(@RequestBody Map<String, String> payload){
        Map<String, Object> responseData = new HashMap();
        int statusCode;
        try {
            String name = payload.get("username");
            String password = payload.get("password");
            boolean registered = registrationService.registerUser(name, password);
            if (registered) responseData.put("response", "successful");
            statusCode = 201;
        } catch (NullPointerException e){
            responseData.put("response", "invalid request");
            statusCode = 400;
        } catch (Exception e) {
            responseData.put("response", "server exception");
            statusCode = 503;
            e.printStackTrace();
        }
        return new ResponseEntity<>(responseData, HttpStatus.valueOf(statusCode));
    }

    @GetMapping
    public String g(){
        return "hello";
    }
}

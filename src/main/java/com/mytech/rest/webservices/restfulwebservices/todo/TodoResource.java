package com.mytech.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
public class TodoResource {

    @Autowired
    private HardCodedService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        //throw new RuntimeException("Some Error has Happened! Contact Support at **** - **** - ****");
        return HardCodedService.FindByUserName(username);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity deleteTodoFromUser(@PathVariable String username, @PathVariable long id) {
        //throw new RuntimeException("Some Error has Happened! Contact Support at **** - **** - ****");
        Todo todo = HardCodedService.deleteById(username, id);
        if (todo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

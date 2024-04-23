package com.mytech.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        return HardCodedService.FindByUserNameAndId(username, id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> deleteTodoFromUser(@PathVariable String username, @PathVariable long id) {
        //throw new RuntimeException("Some Error has Happened! Contact Support at **** - **** - ****");
        Todo todo = HardCodedService.deleteById(username, id);
        if (todo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
        Todo todoUpdated = HardCodedService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo savedTodo = HardCodedService.save(todo);

        // envoyer location aprés la création de chaque todo
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTodo.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}

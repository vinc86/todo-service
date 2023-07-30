package dev.vinzmanz.todo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService service;
    private TodoRepository repo;
    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos(){
        return new ResponseEntity(service.getAllTodos(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public String saveTodo(@RequestBody Todo todo){
        return service.saveTodo(todo);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable ObjectId id){
        return service.deleteTodo(id);
    }
}

package dev.vinzmanz.todo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repo;

    public List<Todo> getAllTodos(){
        return repo.findAll();
    }

    public String saveTodo(Todo todo){
        repo.save(todo);
        return "Todo saved successfully";
    }

    public String deleteTodo(ObjectId id){
        repo.deleteById(id);
        return "todo deleted!";
    }
}

package info.salma.controller;

import info.salma.entity.Task;
import info.salma.entity.Todo;
import info.salma.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/toDos")
    public List<Todo> getAllTodo () {
        return todoService.getAllToDo();
    }

    @GetMapping("/toDos/{id}}")
    public Todo getToDo(@PathVariable String id) {
        return todoService.getToDo(id);
    }

    @PostMapping("/toDo")
    public String addToDo(@RequestBody Todo toDo) {
        todoService.addToDo(toDo);
        return "Save ToDo successfully";
    }

    @PostMapping(value = "/toDos/tasks/{taskId}")
    public String addToDoTask(@RequestBody Todo toDo, @PathVariable String taskId) {
        toDo.setTask(new Task(taskId, "",""));
        todoService.addToDo(toDo);
        return "Save ToDo successfully";
    }
}

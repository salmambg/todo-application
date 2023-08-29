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

    // all todo
    @GetMapping("/todos")
    public List<Todo> getAllTodo () {
        return todoService.getAllToDo();
    }

    // single todo
    @GetMapping("/todos/{id}}")
    public Todo getToDo(@PathVariable String id) {
        return todoService.getToDo(id);
    }

    // save single todo
    @PostMapping("/todos")
    public String addToDo(@RequestBody Todo toDo) {
        todoService.addToDo(toDo);
        return "Save ToDo successfully";
    }

    // save single todo with task
    @PostMapping(value = "/todos/tasks/{taskId}")
    public String addToDoTask(@RequestBody Todo toDo, @PathVariable String taskId) {
        toDo.setTask(new Task(taskId, "",""));
        todoService.addToDo(toDo);
        return "Save ToDo successfully";
    }
}

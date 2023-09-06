package info.salma.controller;

import info.salma.entity.Task;
import info.salma.entity.Todo;
import info.salma.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @PostMapping("/todos/tasks/{taskId}")
    public String addToDoTask(@PathVariable String  taskId, @RequestParam String todoId) {
        // Fetch the existing Todo by its ID
        Todo todo = todoService.getTodoById(todoId);

        // Create a new Task using taskId and associate it with the Todo
        Task task = new Task();
        task.setId(taskId);
        task.setTodo(todo);

        // Add the task to the Todo's list of tasks
        todo.getTasks().add(task);

        // Save the updated Todo to persist the association
        todoService.saveTodoWithTasks(todo);

        return "Task added to Todo successfully";
    }
    @PutMapping(value = "/todos/{id}")
    public String updateTodo (@RequestBody Todo todo,@PathVariable String id) {
    todoService.updateToDo(id, todo );
    return "Update Course Successfully";
    }

    @DeleteMapping(value = "/todos/{id}")
    public void deleteTopic (@PathVariable String id) {
        todoService.deleteToDo(id);
    }


}

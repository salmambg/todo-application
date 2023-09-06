package info.salma.controller;

import info.salma.entity.Task;
import info.salma.entity.Todo;
import info.salma.service.TaskService;
import info.salma.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TodoService todoService;

    @RequestMapping("/tasks")
    public List<Task> getAllTasks () {
        return taskService.getAllTasks();
    }

    @RequestMapping("/tasks/{id}")
    public Task getTask(@PathVariable String id) {
        return taskService.getTask(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/tasks/todos/{todoId}")
    public String addTaskToTodo(@RequestBody Task task, @PathVariable String todoId) {
        // Fetch the existing Todo by its ID
        Todo todo = todoService.getTodoById(todoId);

        // Set the Todo reference for the Task
        task.setTodo(todo);

        // Save the Task, which will also update the association with the Todo
        taskService.addTask(task);

        return "Task added to Todo successfully";
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/tasks/{id}")
    public String updateTask(@RequestBody Task task, @PathVariable String id) {
        taskService.updateTask(id,task);
        return "Update task successfully";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/tasks/{id}")
    public void DeleteTask(@PathVariable String id) {
        taskService.DeleteTask(id);
    }


}

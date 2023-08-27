package info.salma.controller;

import info.salma.entity.Task;
import info.salma.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/tasks")
    public List<Task> getAllTasks () {
        return taskService.getAllTasks();
    }

    @RequestMapping("/tasks/{id}")
    public Task getTask(@PathVariable String id) {
        return taskService.getTask(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/tasks")
    public String addTopic(@RequestBody Task task) {
        taskService.addTasks(task);
        return "Save task successfully";
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/tasks/{id}")
    public String updateTask(@RequestBody Task task, @PathVariable String id) {
        taskService.updateTask(id,task);
        return "Update task successfully";

    }


}

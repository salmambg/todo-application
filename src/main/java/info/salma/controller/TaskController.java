package info.salma.controller;

import info.salma.entity.Task;
import info.salma.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}

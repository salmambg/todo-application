package info.salma.service;

import info.salma.entity.Task;
import info.salma.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks () {
        return taskRepository.findAll();
    }
    public void addTasks(Task task) {
        taskRepository.save(task);
    }

    public Task getTask(String id) {
        Optional<Task> task =taskRepository.findById(id);
        return task.orElse(null);
    }

    public void updateTask(String id, Task task) {
        taskRepository.save(task);
    }



}

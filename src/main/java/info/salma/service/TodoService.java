package info.salma.service;

import info.salma.entity.Todo;
import info.salma.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository toDoRepository;

    public List<Todo> getAllToDo () {
        return toDoRepository.findAll();
    }

    public void addToDo (Todo toDo) {
        toDoRepository.save(toDo);
    }

    public Todo getToDo(String id) {
        Optional<Todo> toDo = toDoRepository.findById(id);
        return toDo.orElse(null);
    }
    public void updateToDo(String id, Todo toDo) {
        toDoRepository.save(toDo);
    }

    public void deleteToDo(String id) {
        toDoRepository.deleteById(id);
    }

}

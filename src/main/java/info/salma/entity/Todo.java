package info.salma.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Todo {
    @Id
    private String id;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "todo", fetch = FetchType.EAGER)
    private List<Task> tasks;

    public Todo() {

    }

    public Todo(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

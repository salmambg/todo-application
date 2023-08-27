package info.salma.controller;

import info.salma.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController {
    @Autowired
    private ToDoService todoService;
}

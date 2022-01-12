package ssf.ibf.todo.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ssf.ibf.todo.models.TaskModel;

@Controller
public class TaskController {

    @PostMapping(path = "/task", produces = MediaType.TEXT_HTML_VALUE)
    public String printFields(@ModelAttribute TaskModel task) {
        System.out.println(task.getTaskName());
        return "redirect:/";
    }
}

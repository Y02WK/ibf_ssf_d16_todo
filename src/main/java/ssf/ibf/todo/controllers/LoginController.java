package ssf.ibf.todo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ssf.ibf.todo.services.TaskService;

@Controller
@RequestMapping(path = "/login", produces = MediaType.TEXT_HTML_VALUE)
public class LoginController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public String loginUser(@RequestBody MultiValueMap<String, String> form, Model model) {
        List<String> taskList = new ArrayList<>();
        String username = form.getFirst("userName").toUpperCase();

        // gets existing taskList from Redis if username is found in database
        if (taskService.hasKey(username)) {
            taskList = taskService.get(username).get();
            model.addAttribute("taskList", taskList);
        }

        model.addAttribute("username", username);
        return "tasklist";
    }
}

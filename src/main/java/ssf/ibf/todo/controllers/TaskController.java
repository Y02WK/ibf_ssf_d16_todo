package ssf.ibf.todo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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
@RequestMapping(path = "/task", produces = MediaType.TEXT_HTML_VALUE)
public class TaskController {
    @Autowired
    private TaskService taskService;

    private final Logger logger = Logger.getLogger(TaskController.class.getName());

    @PostMapping
    public String addTask(@RequestBody MultiValueMap<String, String> form, Model model) {
        List<String> taskList = form.get("taskName");

        logger.info(taskList.toString());
        logger.info(form.toString());

        model.addAttribute("taskList", taskList);
        return "index";
    }

    @PostMapping("/save")
    public String saveTasks(@RequestBody MultiValueMap<String, String> form, Model model) {
        ArrayList<String> taskList = new ArrayList<>(form.get("taskName"));

        do {
            taskList.remove("");
        } while (taskList.remove(""));

        logger.info(taskList.toString());
        logger.info(Integer.toString(taskList.size()));

        if (taskList.size() > 0) {
            model.addAttribute("flash", "Tasks saved successfully.");
        } else {
            model.addAttribute("flash", "Error. No tasks to save!");
        }
        return "index";
    }
}

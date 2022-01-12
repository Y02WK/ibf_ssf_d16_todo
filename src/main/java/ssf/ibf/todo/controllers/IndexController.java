package ssf.ibf.todo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class IndexController {

    @PostMapping("/")
    public String printFields(@RequestBody MultiValueMap<String, String> form) {
        String task = form.getFirst("addTask");
        System.out.println(task);
        return "blank";
    }
}

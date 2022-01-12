package ssf.ibf.todo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssf.ibf.todo.constants.Constants;
import ssf.ibf.todo.repositories.TaskRepository;

@Service
public class TaskService {
    // @Service class to operate on the TaskRepository
    @Autowired
    private TaskRepository taskRepository;

    public void saveTasks(String key, List<String> tasks) {
        String listAsString = String.join(Constants.JOIN_DELIMITER, tasks);
        taskRepository.save(key, listAsString);
    }

    public boolean hasKey(String key) {
        Optional<String> opt = taskRepository.get(key);
        return opt.isPresent();
    }

    public Optional<List<String>> get(String key) {
        Optional<String> opt = taskRepository.get(key);
        if (opt.isPresent()) {
            return Optional
                    .ofNullable(new ArrayList<String>(Arrays.asList(opt.get().split(Constants.SPLIT_DELIMITER))));
        } else {
            return Optional.empty();
        }
    }
}
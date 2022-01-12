package ssf.ibf.todo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssf.ibf.todo.repositories.TaskRepository;

@Service
public class TaskService {
    // @Service class to operate on the TaskRepository
    @Autowired
    private TaskRepository taskRepository;
}

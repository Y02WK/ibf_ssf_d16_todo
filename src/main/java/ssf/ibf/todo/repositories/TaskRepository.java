package ssf.ibf.todo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository {
    // @repository class for storing task entity. No business logic
    @Autowired
    private RedisTemplate<String, Object> template;
}

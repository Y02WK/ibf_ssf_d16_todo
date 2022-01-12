package ssf.ibf.todo.models;

import java.io.Serializable;

public class TaskModel implements Serializable {
    private String taskName;

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}

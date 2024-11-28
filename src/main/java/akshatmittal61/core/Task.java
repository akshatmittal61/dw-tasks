package akshatmittal61.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.optional.qual.Present;
import org.checkerframework.common.value.qual.BoolVal;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.UUID;

public class Task {
    private String id;
    @NotNull
    @NotEmpty(message = "cannot be empty")
    private String content;
    @NotNull
    private Boolean completed;

    public Task() {
        this.id = UUID.randomUUID().toString();
        this.content = "";
        this.completed = false;
    }
    public Task(String id, String content, Boolean completed) {
        this.id = id;
        this.content = content;
        this.completed = completed;
    }
    public Task(String content, Boolean completed) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.completed = completed;
    }
    public Task(Task existingTask) {
        this.id = existingTask.getId();
        this.content = existingTask.getContent();
        this.completed = existingTask.getCompleted();
    }

    @JsonProperty("id")
    public String getId() {
        return this.id;
    }
    @JsonProperty("content")
    public String getContent() {
        return this.content;
    }
    @JsonProperty("completed")
    public Boolean getCompleted() {
        return this.completed;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + ", Content: " + this.content + ", Completed: " + this.completed;
    }
}

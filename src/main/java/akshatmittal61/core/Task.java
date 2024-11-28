package akshatmittal61.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Task {
    private final String id;
    private String content;
    private Boolean completed;

    public Task() {
        this.id = UUID.randomUUID().toString();
        this.content = "";
        this.completed = false;
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

    @JsonProperty
    public String getId() {
        return this.id;
    }
    @JsonProperty
    public String getContent() {
        return this.content;
    }
    @JsonProperty
    public Boolean getCompleted() {
        return this.completed;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}

package com.richard.todolist.todolist_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.Instant;


public class TaskRequestDTO {

    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, max = 255, message = "The title should contain between 3 and 255 characters")
    private String title;

    @NotBlank
    @Size(max = 255, message = "The title should contain 255 characters")
    private String description;

    private Boolean concluded;


    public String getTitle() {
        return title;
    }

    public TaskRequestDTO(){}

    public TaskRequestDTO(String title, String description, Boolean concluded) {
        this.title = title;
        this.description = description;
        this.concluded = concluded;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getConcluded() {
        return concluded;
    }

    public void setConcluded(Boolean concluded) {
        this.concluded = concluded;
    }

}

package com.richard.todolist.todolist_api.config;

import com.richard.todolist.todolist_api.model.Task;
import com.richard.todolist.todolist_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        Task entity = new Task(null, "Title", "Description", false, Instant.parse("2019-06-20T19:53:07Z"));
        Task entity1 = new Task(null, "Title 1" , "Description222", true, Instant.parse("2019-06-20T19:53:07Z"));

        taskRepository.saveAll(Arrays.asList(entity,entity1));
    }
}

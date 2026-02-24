package com.richard.todolist.todolist_api.config;

import com.richard.todolist.todolist_api.entities.Todo;
import com.richard.todolist.todolist_api.repositories.TodoRepository;
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
    private TodoRepository todoRepository;

    @Override
    public void run(String... args) throws Exception {
        Todo entity = new Todo(null, "Title", "Description", false, Instant.parse("2019-06-20T19:53:07Z"));
        Todo entity1 = new Todo(null, "Title 1" , "Description222", true, Instant.parse("2019-06-20T19:53:07Z"));

        todoRepository.saveAll(Arrays.asList(entity,entity1));
    }
}

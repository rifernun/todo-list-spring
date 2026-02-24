package com.richard.todolist.todolist_api.services;

import com.richard.todolist.todolist_api.entities.Todo;
import com.richard.todolist.todolist_api.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public List<Todo> findAll(){
        return repository.findAll();
    }

    public Todo findById(UUID uuid) {
        Optional<Todo> obj = repository.findById(uuid);
        return obj.get();
    }

    public Todo insert(Todo obj) {
        return repository.save(obj);
    }

    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }

    public Todo update(UUID uuid, Todo obj) {
        Todo entity = repository.getReferenceById(uuid);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Todo entity, Todo obj) {
        entity.setTitle(obj.getTitle());
        entity.setDescription(obj.getDescription());
        entity.setConcluded(obj.getConcluded());
        entity.setCreatedAt(obj.getCreatedAt());
    }
}

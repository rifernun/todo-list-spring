package com.richard.todolist.todolist_api.service;

import com.richard.todolist.todolist_api.dto.TaskRequestDTO;
import com.richard.todolist.todolist_api.model.Task;
import com.richard.todolist.todolist_api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> findAll(){
        return repository.findAll();
    }

    public Task findById(UUID uuid) {
        Optional<Task> obj = repository.findById(uuid);
        return obj.get();
    }

    public Task insert(TaskRequestDTO dto) {
        Task newTask = new Task();
        newTask.setTitle(dto.getTitle());
        newTask.setDescription(dto.getDescription());
        newTask.setCreatedAt(Instant.now());
        newTask.setConcluded(false);
        return repository.save(newTask);
    }

    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }

    public Task update(UUID uuid, TaskRequestDTO obj) {
        Task entity = repository.getReferenceById(uuid);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Task entity, TaskRequestDTO obj) {
        entity.setTitle(obj.getTitle());
        entity.setDescription(obj.getDescription());
        entity.setConcluded(obj.getConcluded());
    }
}

package com.richard.todolist.todolist_api.repositories;

import com.richard.todolist.todolist_api.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoRepository extends JpaRepository<Todo, UUID> {
}

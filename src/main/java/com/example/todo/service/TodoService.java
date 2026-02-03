package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.entity.Todo;
import com.example.todo.exception.ResourceNotFoundException;
import com.example.todo.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository repo;

    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    // Create
    public Todo createTodo(Todo todo) {
        return repo.save(todo);
    }

    // Read all
    public List<Todo> getAllTodos() {
        return repo.findAll();
    }

    // Read by id
    public Todo getTodoById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id " + id));
    }

    // Update
    public Todo updateTodo(Long id, Todo updatedTodo) {
        Todo todo = getTodoById(id);
        todo.setTitle(updatedTodo.getTitle());
        todo.setDescription(updatedTodo.getDescription());
        todo.setCompleted(updatedTodo.isCompleted());
        return repo.save(todo);
    }

    // Delete
    public void deleteTodo(Long id) {
        Todo todo = getTodoById(id);
        repo.delete(todo);
    }
}

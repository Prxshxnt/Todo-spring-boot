package com.example.todo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        return service.createTodo(todo);
    }

    // Get all
    @GetMapping
    public List<Todo> getAllTodos() {
        return service.getAllTodos();
    }

    // Get by id
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return service.getTodoById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return service.updateTodo(id, todo);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {
        service.deleteTodo(id);
        return "Todo deleted successfully";
    }
}

package com.example.demo.Service;


import com.example.demo.Model.Todo;
import com.example.demo.Repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    public List<Todo> getAllTodos() {

        return todoRepository.findAll();
    }

    public void addTodo( Todo todo) {
        todoRepository.save(todo);
    }

    public void deleteTodo( Integer todoId){
            Todo todo=todoRepository.findTodoById(todoId);
             if(todo==null){
                throw new UsernameNotFoundException("Error,authentication");
            }

            todoRepository.save(todo);
        }
        
        public void updateTodo(Todo todo, Integer todoId){
        Todo oldTodo=todoRepository.findTodoById(todoId);
        if (oldTodo==null) {
            throw new UsernameNotFoundException("Todo not found");
        }
        oldTodo.setMessage(todo.getMessage());
        todoRepository.save(oldTodo);
    }

}

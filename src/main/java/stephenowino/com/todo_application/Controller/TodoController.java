package stephenowino.com.todo_application.Controller;
// TodoRepository.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stephenowino.com.todo_application.Entity.Todo;
import stephenowino.com.todo_application.Repository.TodoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
        @Autowired
        private TodoRepository todoRepository;

        @GetMapping
        public List<Todo> getAllTodos() {
                return todoRepository.findAll();
        }

        @PostMapping
        public Todo addTodo(@RequestBody Todo todo) {
                return todoRepository.save(todo);
        }

        @PutMapping("/{id}")
        public Todo updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
                return todoRepository.findById(id).map(todo -> {
                        todo.setTitle(updatedTodo.getTitle());
                        todo.setCompleted(updatedTodo.isCompleted());
                        return todoRepository.save(todo);
                }).orElseThrow(() -> new RuntimeException("Todo not found"));
        }

        @DeleteMapping("/{id}")
        public void deleteTodo(@PathVariable Long id) {
                todoRepository.deleteById(id);
        }
}



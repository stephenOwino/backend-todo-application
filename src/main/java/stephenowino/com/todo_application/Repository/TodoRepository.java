package stephenowino.com.todo_application.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import stephenowino.com.todo_application.Entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}

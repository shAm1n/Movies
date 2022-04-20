package project.movies.domain;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Long> {
	List<Actor> findByLastname(String lastname);
}

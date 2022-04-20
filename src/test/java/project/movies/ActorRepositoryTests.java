package project.movies;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import project.movies.domain.Actor;
import project.movies.domain.ActorRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ActorRepositoryTests {

	@Autowired
	private ActorRepository actors;
	
	@Test
	public void findByLastnameShouldReturnActor() {
		List<Actor> actorlist = actors.findByLastname("Hanks");
		assertThat(actorlist).hasSize(1);
		assertThat(actorlist.get(0).getFirstname()).isEqualTo("Tom");
	}
	
	@Test
	public void createNewActor() {
		Actor actor = new Actor("Sandra", "Bullock");
		actors.save(actor);
		assertThat(actor.getActid()).isNotNull();
	}
	
	@Test
	public void deleteActor() {
		Actor actor = new Actor("Sandra", "Bullock");
		actors.save(actor);
		List<Actor> actorlist = actors.findByLastname("Bullock");
		assertThat(actorlist).hasSize(1);
		actors.deleteById(actorlist.get(0).getActid());
		List<Actor> checklist = actors.findByLastname("Bullock");
		assertThat(checklist).isEmpty();
	}
}

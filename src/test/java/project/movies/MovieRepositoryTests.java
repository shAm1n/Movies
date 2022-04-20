package project.movies;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import project.movies.domain.Movie;
import project.movies.domain.MovieRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MovieRepositoryTests {
	
	@Autowired
	private MovieRepository movies;
	
	@Test
	public void findByTitleShouldReturnMovie() {
		List<Movie> movielist = movies.findByTitle("Forrest Gump");
		assertThat(movielist).hasSize(1);
		assertThat(movielist.get(0).getDecade()).isEqualTo("1990s");
	}
	
	@Test
	public void createNewMovie() {
		Movie movie = new Movie("Good Will Hunting", null, null, 1997, "1990s", 126, 8,
				"Will Hunting, a janitor at M.I.T., has a gift for mathematics, but needs help from a psychologist to find direction in his life.",
				"Some people can never believe in themselves, until someone believes in them", true);
		movies.save(movie);
		assertThat(movie.getId()).isNotNull();
	}
	
	@Test
	public void deleteMovie() {
		Movie movie = new Movie("Good Will Hunting", null, null, 1997, "1990s", 126, 8,
				"Will Hunting, a janitor at M.I.T., has a gift for mathematics, but needs help from a psychologist to find direction in his life.",
				"Some people can never believe in themselves, until someone believes in them", true);
		movies.save(movie);
		List<Movie> movielist = movies.findByTitle("Good Will Hunting");
		assertThat(movielist).hasSize(1);
		movies.deleteById(movielist.get(0).getId());
		List<Movie> checklist = movies.findByTitle("Good Will Hunting");
		assertThat(checklist).isEmpty();
	}

}

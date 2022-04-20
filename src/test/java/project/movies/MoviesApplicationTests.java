package project.movies;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import project.movies.web.MovieController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MoviesApplicationTests {
	
	@Autowired
	private MovieController movies;

	@Test
	void contextLoads() throws Exception {
		assertThat(movies).isNotNull();
	}

}

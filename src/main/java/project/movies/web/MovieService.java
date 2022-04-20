package project.movies.web;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.movies.domain.Movie;
import project.movies.domain.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movies;
	
	public List<Movie> listAll(String keyword) {
		if (keyword != null) {
			return movies.search(keyword);
		}
		return movies.findAll();
	}

}

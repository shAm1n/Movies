package project.movies.web;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

//import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import project.movies.domain.ActorRepository;
import project.movies.domain.CategoryRepository;
import project.movies.domain.Movie;
import project.movies.domain.MovieRepository;

@CrossOrigin
@Controller
public class MovieController {
	@Autowired
	private MovieRepository movies;
	@Autowired
	private ActorRepository actors;
	@Autowired
	private CategoryRepository cats;
	@Autowired
	private MovieService service;
	
	@GetMapping("/movielist")
	public String Movielist(Model model ) {
		model.addAttribute("movies", movies.findAll());
		return "movies";
	}
	
	@RequestMapping("/search")
	public String Moviesearch(@Param("keyword") String keyword, Model model) {
		List<Movie> movies = service.listAll(keyword);
		model.addAttribute("movies", movies);
		return "movies";
	}
	
	/*@GetMapping("/movies/{id}")
	public String findMovie(@PathVariable("id") Long id, Model model) {
		model.addAttribute("movies", movies.findById(id));
		return "movies";
	}*/
	
	@GetMapping("/abc")
	public String MoviesABC(Model model ) {
		model.addAttribute("movies", movies.findAllByOrderByTitle());
		return "movies";
	}
	
	@GetMapping("/yearAsc")
	public String MoviesYearAsc(Model model ) {
		model.addAttribute("movies", movies.findAllByOrderByYear());
		return "movies";
	}
	
	@GetMapping("/yearDesc")
	public String MoviesYearDesc(Model model ) {
		model.addAttribute("movies", movies.findAllByOrderByYearDesc());
		return "movies";
	}
	
	@GetMapping("/rating")
	public String MoviesRating(Model model ) {
		model.addAttribute("movies", movies.findAllByOrderByRatingDesc());
		return "movies";
	}
	
	@GetMapping("/notseen")
	public String MoviesNotSeen(Model model ) {
		model.addAttribute("movies", movies.findAllBySeenFalse());
		return "movies";
	}
	
	@GetMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteMovie(@PathVariable("id") Long id, Model model) {
		movies.deleteById(id);
		return "redirect:../movielist";
	}
	
	@GetMapping("/add")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String newMovie(Model model) {
		model.addAttribute("movie", new Movie());
		model.addAttribute("categories", cats.findAll());
		model.addAttribute("actors", actors.findAll());
		return "newmovie";
	}
	
	@PostMapping("/save")
	public String saveMovie(@Valid Movie movie, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("categories", cats.findAll());
			model.addAttribute("actors", actors.findAll());
			return "newmovie";
		} else {
			movies.save(movie);
			return "redirect:movielist";
		}
	}
	
	@GetMapping("/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editMovie(@PathVariable("id") Long id, Model model) {
		Movie movie = movies.findById(id).get();
		model.addAttribute("movie", movie);
		model.addAttribute("category", movie.getCategory());
		model.addAttribute("actor", movie.getActor());
		model.addAttribute("categories", cats.findAll());
		model.addAttribute("actors", actors.findAll());
		return "editmovie";
	}
	
	//REST find all
	@GetMapping("/movies")
	public @ResponseBody List<Movie> movieListRest() {
		return (List<Movie>) movies.findAll();
	}
	
	//REST find by id
	@GetMapping("/movies/{id}")
	public @ResponseBody Optional<Movie> findMovieRest(@PathVariable("id") Long id) {	
    	return movies.findById(id);
    }
	
	//REST new movie
	@PostMapping("/movies")
	public @ResponseBody Movie saveMovieRest(@RequestBody Movie movie) {	
    	return movies.save(movie);
    }
	
	
}
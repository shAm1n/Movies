package project.movies.domain;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
	List<Movie> findByTitle(String title);
	List<Movie> findAllByOrderByTitle();
	List<Movie> findAllByOrderByYear();
	List<Movie> findAllByOrderByYearDesc();
	List<Movie> findAllByOrderByRatingDesc();
	List<Movie> findAllBySeenFalse();
	List<Movie> findAll();
	
	@Query("SELECT m FROM Movie m WHERE CONCAT(m.title, ' ', m.decade) LIKE %?1% OR "
			+"EXISTS (SELECT 1 FROM Category c WHERE m.category.catid=c.catid AND c.name LIKE %?1%) "
			+"OR EXISTS (SELECT 1 FROM Actor a WHERE m.actor.actid=a.actid AND CONCAT(a.firstname, ' ', a.lastname) LIKE %?1%)")
	public List<Movie> search(String keyword);
	
}

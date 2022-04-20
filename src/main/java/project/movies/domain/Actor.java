package project.movies.domain;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long actid;
	private String firstname;
	private String lastname;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "actor")
	@JsonIgnoreProperties("actor")
	private List<Movie> movies;
	
	public Actor() {
	}
	
	public Actor(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Actor(Long actid, String firstname, String lastname) {
		super();
		this.actid = actid;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Long getActid() {
		return actid;
	}

	public void setActid(Long actid) {
		this.actid = actid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLast_name(String lastname) {
		this.lastname = lastname;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Actor [actid=" + actid + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
}
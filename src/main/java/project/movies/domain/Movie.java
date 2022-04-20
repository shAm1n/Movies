package project.movies.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private int year;
	private String decade;	//1980s, 2010s...
	private int length;
	private int rating;
	/*private double imdb_rating;
	private double rottentom_rating;*/
	private String description;
	private String tagline;
	private boolean seen;
	
	@ManyToOne
	@JsonIgnoreProperties ("movies")
	@JoinColumn(name="catid")
	private Category category;
	
	@ManyToOne
	@JsonIgnoreProperties ("movies")
	@JoinColumn(name="actid")
	private Actor actor;
	
	public Movie() {
	}
	
	public Movie(String title, Actor actor, Category category, int year, String decade, int length, int rating, /*double imdb_rating, double rottentom_rating,*/
			String description, String tagline, boolean seen) {
		super();
		this.title = title;
		this.actor = actor;
		this.category = category;
		this.year = year;
		this.decade = decade;
		this.length = length;
		this.rating = rating;
		/*this.imdb_rating = imdb_rating;
		this.rottentom_rating = rottentom_rating;*/
		this.description = description;
		this.tagline = tagline;
		this.seen = seen;
	}

	public Movie(Long id, String title, int year, String decade, int length, int rating, /*double imdb_rating, double rottentom_rating,*/
			String description, String tagline, boolean seen, Category category, Actor actor) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.decade = decade;
		this.length = length;
		this.rating = rating;
		/*this.imdb_rating = imdb_rating;
		this.rottentom_rating = rottentom_rating;*/
		this.description = description;
		this.tagline = tagline;
		this.seen = seen;
		this.category = category;
		this.actor = actor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDecade() {
		return decade;
	}

	public void setDecade(String decade) {
		this.decade = decade;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	/*public double getImdb_rating() {
		return imdb_rating;
	}

	public void setImdb_rating(double imdb_rating) {
		this.imdb_rating = imdb_rating;
	}

	public double getRottentom_rating() {
		return rottentom_rating;
	}

	public void setRottentom_rating(double rottentom_rating) {
		this.rottentom_rating = rottentom_rating;
	}*/

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	@Override
	public String toString() {
		if (this.category != null)
		return
			"Movie [id=" + id + ", title=" + title + ", year=" + year + ", decade=" + decade + ", length=" + length + ", rating=" + rating
			+ /*", imdb_rating=" + imdb_rating + ", rottentom_rating=" + rottentom_rating + */", description="
			+ description + ", tagline=" + tagline + ", seen=" + seen  + this.getCategory() + "]";
		else if (this.actor != null)
		return
				"Movie [id=" + id + ", title=" + title + ", year=" + year + ", decade=" + decade + ", length=" + length + ", rating=" + rating
				+ /*", imdb_rating=" + imdb_rating + ", rottentom_rating=" + rottentom_rating + */", description="
				+ description + ", tagline=" + tagline + ", seen=" + seen + this.getActor() + "]";
		else
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", decade=" + decade + ", length=" + length + ", rating=" + rating
				+ /*", imdb_rating=" + imdb_rating + ", rottentom_rating=" + rottentom_rating + */", description="
				+ description + ", tagline=" + tagline + ", seen=" + seen + "]";
	}
}
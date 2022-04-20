package project.movies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project.movies.domain.Actor;
import project.movies.domain.ActorRepository;
import project.movies.domain.Category;
import project.movies.domain.CategoryRepository;
import project.movies.domain.Movie;
import project.movies.domain.MovieRepository;
import project.movies.domain.User;
import project.movies.domain.UserRepository;

@SpringBootApplication
public class MoviesApplication {
	private static final Logger log = LoggerFactory.getLogger(MoviesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(MovieRepository movies, CategoryRepository cats, ActorRepository acts, UserRepository users) {
		return (args) -> {
			Category cat1 = new Category("Drama");
				cats.save(cat1);
			Category cat2 = new Category("Comedy");
				cats.save(cat2);
			Category cat3 = new Category("Action");
				cats.save(cat3);
			Category cat4 = new Category("Fantasy");
				cats.save(cat4);
			Category cat5 = new Category("Crime");
				cats.save(cat5);
			Category cat6 = new Category("Adventure");
				cats.save(cat6);
			Category cat7 = new Category("Romance");
				cats.save(cat7);
			Category cat8 = new Category("Thriller");
				cats.save(cat8);
			Category cat9 = new Category("Sci-Fi");
				cats.save(cat9);
			Category cat10 = new Category("Mystery");
				cats.save(cat10);
			Category cat11 = new Category("Animation");
				cats.save(cat11);
			Category cat12 = new Category("War");
				cats.save(cat12);
			Category cat13 = new Category("Film-Noir");
				cats.save(cat13);
			Category cat14 = new Category("History");
				cats.save(cat14);
			Category cat15 = new Category("Horror");
				cats.save(cat15);
			Category cat16 = new Category("Musical");
				cats.save(cat16);
			Category cat17 = new Category("Biography");
				cats.save(cat17);
			Category cat18 = new Category("Documentary");
				cats.save(cat18);
			
			//Category cat = new Category("");
				//cats.save(cat);
			
			Actor act1 = new Actor("Tim", "Robbins");
				acts.save(act1);
			Actor act2 = new Actor("Tom", "Hanks");
				acts.save(act2);
			Actor act3 = new Actor("Henry", "Fonda");
				acts.save(act3);
			Actor act4 = new Actor("Aamir", "Khan");
				acts.save(act4);
			Actor act5 = new Actor("Rami", "Malek");
				acts.save(act5);
			Actor act6 = new Actor("Leonardo", "DiCaprio");
				acts.save(act6);
			Actor act7 = new Actor("Joaquin", "Phoenix");
				acts.save(act7);
			Actor act8 = new Actor("Daniel", "Craig");
				acts.save(act8);
			Actor act9 = new Actor("Lin-Manuel", "Miranda");
				acts.save(act9);
			Actor act10 = new Actor("Jon", "Favreau");
				acts.save(act10);
			Actor act11 = new Actor("Matt", "Damon");
				acts.save(act11);
			Actor act12 = new Actor("Anthony", "Hopkins");
				acts.save(act12);
			Actor act13 = new Actor("Frances", "McDormand");
				acts.save(act13);
			Actor act14 = new Actor("Andrew", "Garfield");
				acts.save(act14);
			Actor act15 = new Actor("James", "Stewart");
				acts.save(act15);
			Actor act16 = new Actor("Chieko", "Baisho");
				acts.save(act16);
			Actor act17 = new Actor("J.K.", "Simmons");
				acts.save(act17);
			Actor act18 = new Actor("Robert", "Downey Jr.");
				acts.save(act18);
			Actor act19 = new Actor("The", "Marx Brothers");
				acts.save(act19);
			
			//Actor act = new Actor("", "");
				//acts.save(act);
			
			movies.save(new Movie("The Shawshank Redemption", act1, cat1, 1994, "1990s", 142, 9, /*9.2, 9.1,*/
					"Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
					"Fear can hold you prisoner. Hope can set you free", true));
			movies.save(new Movie("Forrest Gump", act2, cat1, 1994, "1990s", 142, 9, /*8.8, 7,*/
					"The heartwarming story follows the life events of Forrest Gump as they intertwine with historical events.",
					"Life is like a box of chocolates...you never know what you're gonna get", true));
			movies.save(new Movie("12 Angry Men", act3, cat13, 1957, "1950s", 96, 8, /*9.0, 9.2,*/
					"The jury deliberations in a New York City murder trial.",
					"Life is in their hands. Death is on their minds!", true));
			movies.save(new Movie("3 Idiots", act4, cat1, 2009, "2000s", 170, 9,
					"Two friends revisit their college days and recall the memories of their friend who inspired them to think differently.",
					"Don't be Stupid. Be an I.D.I.O.T.", true));
			movies.save(new Movie("Bohemian Rhapsody", act5, cat17, 2018, "2010s", 134, 9,
					"The story of the legendary British rock band Queen and lead singer Freddie Mercury, leading up to their famous performance at Live Aid.",
					"Fearless lives forever", true));
			movies.save(new Movie("Catch Me If You Can", act6, cat17, 2002, "2000s", 141, 9,
					"Barely 21 yet, Frank is a skilled forger who has passed as a doctor, lawyer and pilot. FBI agent Carl becomes obsessed with tracking down the con man, who only revels in the pursuit.",
					"The true story of a real fake", true));
			movies.save(new Movie("Joker", act7, cat8, 2019, "2010s", 122, 9,
					"A mentally troubled stand-up comedian embarks on a downward spiral that leads to the creation of an iconic villain.",
					"Put on a happy face", true)); //https://www.indieground.net/images/blog/2019/joker_indiegroundblog_01.jpg
			movies.save(new Movie("Knives Out", act8, cat10, 2019, "2010s", 130, 9,
					"A detective investigates the death of the patriarch of an eccentric, combative family.",
					"Everyone has a motive. No one has a clue", true));
			movies.save(new Movie("Hamilton", act9, cat16, 2020, "2020s", 160, 9,
					"The story of one of America's founding fathers and first Secretary of the Treasury, Alexander Hamilton. Captured live on Broadway with the original Broadway cast. Hamilton is the story of America then, told by America now.",
					"An American Musical", true));
			movies.save(new Movie("Chef", act10, cat6, 2014, "2010s", 114, 8,
					"A head chef quits his restaurant job and buys a food truck in an effort to reclaim his creative promise, while piecing back together his estranged family.",
					"Starting from scratch never tasted so good", true));
			movies.save(new Movie("The Martian", act11, cat6, 2015, "2010s", 144, 8,
					"An astronaut becomes stranded on Mars after his team assume him dead, and must rely on his ingenuity to find a way to signal to Earth that he is alive and can survive until a potential rescue.",
					"Help is only 140 million miles away", true));
			movies.save(new Movie("The Father", act12, cat1, 2020, "2020s", 97, 9,
					"A man refuses all assistance from his daughter as he ages. As he tries to make sense of his changing circumstances, he begins to doubt his loved ones, his own mind and even the fabric of his reality.",
					"Nothing is as it seems", true));
			movies.save(new Movie("The French Dispatch", act13, cat2, 2021, "2020s", 107, 8,
					"A love letter to journalists set in an outpost of an American newspaper in a fictional twentieth century French city that brings to life a collection of stories published in The French Dispatch Magazine.",
					"All grand beauties withhold their deepest secrets", true));
			movies.save(new Movie("Hacksaw Ridge", act14, cat12, 2016, "2010s", 139, 7,
					"World War II American Army Medic Desmond T. Doss, who served during the Battle of Okinawa, refuses to kill people and becomes the first man in American history to receive the Medal of Honor without firing a shot.",
					"When the order came to retreat, one man stayed", true));
			movies.save(new Movie("Rear Window", act15, cat13, 1954, "1950s", 112, 8,
					"A wheelchair-bound photographer spies on his neighbors from his Greenwich Village courtyard apartment window, and becomes convinced one of them has committed murder, despite the skepticism of his fashion-model girlfriend.",
					"The Essential Hitchcock", true));
			movies.save(new Movie("Shutter Island", act6, cat8, 2010, "2010s", 138, 8,
					"In 1954, a U.S. Marshal investigates the disappearance of a murderer who escaped from a hospital for the criminally insane.",
					"Some places never let you go", true));
			movies.save(new Movie("Titanic", act6, cat7, 1997, "1990s", 194, 8,
					"A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.",
					"Nothing on earth could come between them", true));
			movies.save(new Movie("Howl's moving castle", act16, cat11, 2004, "2000s", 119, 0,
					"When an unconfident young woman is cursed with an old body by a spiteful witch, her only chance of breaking the spell lies with a self-indulgent yet insecure young wizard and his companions in his legged, walking castle.",
					"Here's another curse for you - may all your bacon burn", false));
			movies.save(new Movie("C'mon, C'mon", act7, cat1, 2021, "2020s", 109, 0,
					"When his sister asks him to look after her son, a radio journalist embarks on a cross-country trip with his energetic nephew to show him life away from Los Angeles.",
					"Be funny comma when you can period", false));
			movies.save(new Movie("Avengers: Endgame", act18, cat3, 2019, "2010s", 181, 9,
					"After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.",
					"Part of the journey is the end", true));
			movies.save(new Movie("Klaus", act17, cat11, 2019, "2010s", 96, 10,
					"A simple act of kindness always sparks another, even in a frozen, faraway place. When Smeerensburg's new postman, Jesper, befriends toymaker Klaus, their gifts melt an age-old feud and deliver a sleigh full of holiday traditions.",
					"Welcome to the jingle", true));
			movies.save(new Movie("Duck Soup", act19, cat13, 1933, "1930s", 69, 0,
					"Rufus T. Firefly is named the dictator of bankrupt Freedonia and declares war on neighboring Sylvania over the love of his wealthy backer Mrs. Teasdale, contending with two inept spies who can't seem to keep straight which side they're on.",
					"Come up and sue us sometime", false));
			
			//movies.save(new Movie());
			
			User user1 = new User("shAm1n", "$2a$10$pxlBFLrmG0m5jaUx5wLDAuw9kYj67V6tuNbTnm/2xzucJkmXwJmBa", "admin@mail.com", "ADMIN");
				users.save(user1);
			User user2 = new User("user", "$2a$10$tsEogvww9usE3ARRCBDdruddOEa.QJpkWbFK78XedBsqjnJ/HebZi", "user@mail.com", "USER");
				users.save(user2);
			
			for (Movie movie : movies.findAll()) {
				log.info(movie.toString());
			}
		};
	}
}

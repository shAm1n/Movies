package project.movies;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import project.movies.domain.Category;
import project.movies.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTests {

	@Autowired
	private CategoryRepository cats;
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> catlist = cats.findByName("Drama");
		assertThat(catlist).hasSize(1);
	}
	
	@Test
	public void createNewCategory() {
		Category cat = new Category("Western");
		cats.save(cat);
		assertThat(cat.getCatid()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		Category cat = new Category("Western");
		cats.save(cat);
		List<Category> catlist = cats.findByName("Western");
		assertThat(catlist).hasSize(1);
		cats.deleteById(catlist.get(0).getCatid());
		List<Category> checklist = cats.findByName("Western");
		assertThat(checklist).isEmpty();
	}
}

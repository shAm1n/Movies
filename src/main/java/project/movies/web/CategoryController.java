package project.movies.web;
//import java.util.List;
//import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import project.movies.domain.Category;
import project.movies.domain.CategoryRepository;

@CrossOrigin
@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository cats;
	
	@GetMapping("/categories")
	public String catlist(Model model) {
		model.addAttribute("categories", cats.findAll());
		return "categories";
	}
	@GetMapping("/newcategory")
	public String newCategory(Model model) {
		model.addAttribute("category", new Category());
		return "newcategory";
	}
	@PostMapping("/savecategory")
	public String saveCategory(Category category) {
		cats.save(category);
		return "redirect:categories";
	}
	/*//REST find all
	@GetMapping("/categories")
    public @ResponseBody List<Category> getCategoriesRest() {	
        return (List<Category>) categories.findAll();
    }    

	//REST get by id
    @GetMapping(value="/categories/{id}")
    public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long catId) {	
    	return categories.findById(catId);
    } 
    
    //REST save new category
    @PostMapping("/categories")
    public @ResponseBody Category saveCategoryRest(@RequestBody Category cat) {	
    	return categories.save(cat);
    }*/
}

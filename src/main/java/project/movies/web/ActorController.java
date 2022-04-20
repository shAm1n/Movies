package project.movies.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.movies.domain.Actor;
import project.movies.domain.ActorRepository;

@CrossOrigin
@Controller
public class ActorController {
	@Autowired
	private ActorRepository actors;
	
	@GetMapping("/actors")
	public String actorlist(Model model) {
		model.addAttribute("actors", actors.findAll());
		return "actors";
	}
	@GetMapping("/newactor")
	public String newActor(Model model) {
		model.addAttribute("actor", new Actor());
		return "newactor";
	}
	@PostMapping("/saveactor")
	public String saveActor(Actor actor) {
		actors.save(actor);
		return "redirect:actors";
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

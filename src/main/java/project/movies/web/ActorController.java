package project.movies.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/editactor/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editActor(@PathVariable("id") Long actid, Model model) {
		Actor actor = actors.findById(actid).get();
		model.addAttribute("actor", actor);
		return "editactor";
	}
	
	@PostMapping("/saveactor")
	public String saveActor(Actor actor) {
		actors.save(actor);
		return "redirect:actors";
	}
	@GetMapping("/deleteactor/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteActor(@PathVariable("id") Long actid, Model model) {
		actors.deleteById(actid);
		return "redirect:../actors";
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

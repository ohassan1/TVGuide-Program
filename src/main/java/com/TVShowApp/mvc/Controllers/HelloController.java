package com.TVShowApp.mvc.Controllers;

import com.TVShowApp.mvc.Models.Show;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Welcome to the Nife's TV Guide");
		return "hello";
	}

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String displayAllShows(ModelMap model) {

        Show show = new Show("Friends", 1, "This is a test description");

        model.addAttribute("id", show.getName());
        model.addAttribute("name", show.getName());
        model.addAttribute("description", show.getDescription());

        return "Shows";
    }

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public String displayById(ModelMap model) {
        return "id";
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String displayByName(ModelMap model) {

        Show show = new Show("Friends", 1, "This is a test description");

        model.addAttribute("id", show.getName());
        model.addAttribute("name", show.getName());
        model.addAttribute("description", show.getDescription());
        return "name";
    }
}
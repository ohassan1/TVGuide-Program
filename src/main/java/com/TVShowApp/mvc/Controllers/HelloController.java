package com.TVShowApp.mvc.Controllers;

import com.TVShowApp.mvc.Dao.TVDao;
import com.TVShowApp.mvc.Models.Channel;
import com.TVShowApp.mvc.Models.Show;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("message", "Welcome to Nife's TV Listings!");

        TVDao tvDao = new TVDao();
        ArrayList<Channel> channelList = tvDao.getChannels();
        ArrayList<Show> showList = tvDao.getPrograms();
        ArrayList<String> chanName = new ArrayList<String>();

        for (Show show : showList) {
            chanName.add(show.getChannel());
        }


        model.addAttribute("chanList", channelList);
        model.addAttribute("showList", showList);
        model.addAttribute("chanName", chanName);

		return "hello";
	}
}
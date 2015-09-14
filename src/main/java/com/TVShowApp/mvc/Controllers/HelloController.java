package com.TVShowApp.mvc.Controllers;

import com.TVShowApp.mvc.Dao.TVDao;
import com.TVShowApp.mvc.Models.Channel;
import com.TVShowApp.mvc.Models.Show;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
        ArrayList<String> realTimes = tvDao.currentTime();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm a");

        int unroundedMinutes = cal.get(Calendar.MINUTE);
        int mod = unroundedMinutes % 30;
        cal.add(Calendar.MINUTE, mod == 0 ? 30 : 30 - mod);


        model.addAttribute("chanList", channelList);
        model.addAttribute("showList", showList);
        model.addAttribute("chanName", chanName);
        model.addAttribute("realTimes", realTimes);
        model.addAttribute("actualTime", sdf.format(cal.getTime()));

		return "hello";
	}
}
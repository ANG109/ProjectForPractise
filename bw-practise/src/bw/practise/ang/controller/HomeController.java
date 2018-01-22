package bw.practise.ang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("returnReport.do")
	public ModelAndView getHome(){
		return new ModelAndView("html/vote/votePage");
	}
}

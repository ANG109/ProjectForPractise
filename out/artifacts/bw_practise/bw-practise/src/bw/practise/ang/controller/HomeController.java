package bw.practise.ang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("home.do")
	public ModelAndView accountPreview(){
		
		return new ModelAndView("html/home/account-preview");
	}
	
	

}

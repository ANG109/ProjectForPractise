package bw.practise.ang.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import bw.practise.ang.bean.User;
import bw.practise.ang.service.UserService;

@Controller
@SessionAttributes("sessionUser")
public class UserController {
    
	@Autowired
	private UserService userService;
	@RequestMapping(value="loginUI.do",method=RequestMethod.GET)
	public ModelAndView login(){
		System.out.println("this is login");
		return new ModelAndView("html/login");
	}

	@RequestMapping(value="register.do",method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,
			@RequestParam(value="phone", required=false) String phone,
			@RequestParam(value="password", required=false) String password,
			ModelMap viewMap){
		    User user = userService.LoginUI(phone, password);
		    if(user!=null){
		    	request.getSession().setAttribute(phone, password);
		    	viewMap.addAttribute("sessionUser",user);
		    	return new ModelAndView("html/main");
		    }
		return new ModelAndView("html/error");
	}
}

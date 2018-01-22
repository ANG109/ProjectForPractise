package bw.practise.ang.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bw.practise.ang.bean.User;
import bw.practise.ang.service.UserService;

@Controller
public class UserController extends BaseController{
	private final Gson gson = new GsonBuilder().setDateFormat("yyyyMMddHHmmss").create();
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="loginUI.do",method=RequestMethod.GET)
	public ModelAndView login(){
		
		System.out.println("this is loginUI.do");
		return new ModelAndView("html/login");
	}

	@RequestMapping(value="register.do",method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,
		@RequestParam(value="phone", required=true) String phone,
		@RequestParam(value="password", required=true)String password,
		@RequestParam(value="user_code",required=true)String user_code,
		ModelMap viewMap){
			User user = userService.LoginUI(phone, password);
			request.getSession().setAttribute("user_data",gson.toJson(user));
			User user2  = gson.fromJson(request.getSession().getAttribute("user").toString(), User.class);
			if(user!=null){
				//setSession(USER_DATA_KEY, user);
				viewMap.put("user", user2);
				System.out.println("user2:"+user2);
				return new ModelAndView("html/main",viewMap);
			}
		
		return new ModelAndView("html/error");
	}
	
}

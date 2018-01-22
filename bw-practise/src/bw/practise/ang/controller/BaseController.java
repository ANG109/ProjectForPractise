package bw.practise.ang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import bw.practise.ang.bean.User;

public class BaseController {
	protected final static String USER_DATA_KEY = "user_data";
	protected final static String IMG_INVITE_CODE_KEY = "img_invite_code";
	protected static User getUserInfo(){
		return (User)getSession().getAttribute(USER_DATA_KEY);
	}
	protected void setSession(String key,Object value){
		getSession().getAttribute(key);
	}
	protected static HttpSession getSession(){
		HttpSession session = null;
		try {
			session = getRequest().getSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}
	protected Object getSession(String key){
		return getSession().getAttribute(key);
	}
	protected static HttpServletRequest getRequest(){
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest(); 
	}
}

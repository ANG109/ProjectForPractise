package bw.practise.ang.Interceptor;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import bw.practise.ang.bean.User;
import bw.practise.ang.global.Authorization;

public class PermissionInterceptor extends HandlerInterceptorAdapter {
	private static final Logger LOGGER = Logger.getLogger(PermissionInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response,Object handler)throws Exception{
		Object user = request.getSession().getAttribute("user_data");
		String simpleName = getURLSimpleName(request.getServletPath());
		System.out.println("simpleName:"+simpleName);
		LOGGER.info(String.format("====>path:%s Method:%s", simpleName,request.getMethod()));
		String authorization = this.checkAuthorization(simpleName); 
		if(user==null && (authorization == null || Integer.parseInt(authorization) == 1)){
			response.sendRedirect("loginUI.do");
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	
	@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
			super.afterCompletion(request, response, handler, ex);
		}
	
	
	public static String getURLSimpleName(String text){
		String rex = ".*/(.+)\\.[do,json]";
		Pattern pattern = Pattern.compile(rex);
		Matcher matcher = pattern.matcher(text);
		if(matcher.find()){
			return matcher.group(1);
		}
		return null;
	}
	private String checkAuthorization(String name){
		Map<String, String> authStrMap = Authorization.getStrMap();
		Map<String, String> authObsMap = Authorization.getObsMap();
		String auth = "1";//用户权限默认为1：做权限判断
		String head = null;
		String[] strs = name.split("_");
		if(strs != null && strs.length > 0){
			head = strs[0];
		}
		if(authStrMap != null && authStrMap.size() > 0 && authStrMap.containsKey(name)){
			//获取action权限标识
			auth = authStrMap.get(name);
		}else if(authObsMap != null && authObsMap.size() > 0 && head != null && authObsMap.containsKey(head)){
			auth = authObsMap.get(head);
		}
		return auth;
	}
}

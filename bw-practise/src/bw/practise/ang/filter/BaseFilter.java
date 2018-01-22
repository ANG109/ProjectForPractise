package bw.practise.ang.filter;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import bw.practise.ang.global.Environment;

public class BaseFilter implements Filter{
	private FilterConfig config;
	public void destroy() {
		this.config = null;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		initEnvironment(req);
		chain.doFilter(req, response);
	}

	public void init(FilterConfig config) throws ServletException {
		setConfig(config);
	}

	private void initEnvironment(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Map<String, String> globalMap = Environment.getGlobalMap();
		for (String key : globalMap.keySet()) {
			session.setAttribute(key, globalMap.get(key));
		}
		
		Properties pros = Environment.getGlobalProperties();
		for (Object obj : pros.keySet()) {
			String key = (String) obj;
			session.setAttribute(key, pros.getProperty(key));
			
		}
		System.out.println();
	}
	
	public FilterConfig getConfig() {
		return config;
	}

	public void setConfig(FilterConfig config) {
		this.config = config;
	}
}

package bw.practise.ang.controller;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bw.practise.ang.util.VerifyCodeUtils;

@Controller
public class InviteCodeController extends BaseController{
	private static final Logger LOG  = Logger.getLogger(InviteCodeController.class); 
	
	@RequestMapping("veriCode.do")
	public void veriCode(HttpServletResponse response){
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		setSession(IMG_INVITE_CODE_KEY, verifyCode);
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		//将图像输出到Servlet输出流中
		try {
			int w = 200 ,h = 80;
			VerifyCodeUtils.outputImage(w, h, response.getOutputStream(),
					verifyCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}

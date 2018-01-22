package bw.practise.ang.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sun.net.httpserver.HttpContext;

import bw.practise.ang.util.sendEmailMethod;

@Controller
public class FunctionController {
	
    public static final String  FILEURL ="D:\\image";
	
	@RequestMapping("upload.do")
	public ModelAndView imageUpload(){
		return new ModelAndView("functions/upLoad");
		
		
	}
	
 	@RequestMapping(value = "UploadFile.do",method = RequestMethod.POST)
	public String ProcessRequest(HttpContext context,
			@RequestParam(value="fileUpload")MultipartFile file,
			HttpServletRequest request)
	{
	    String realPath = request.getSession().getServletContext().getRealPath(FILEURL);
	    String fileName = file.getOriginalFilename();
	    File targetfFile = new File(realPath,fileName);
	    if(!targetfFile.exists()){
	    	targetfFile.mkdirs();
	    }
	    
	    try {
	    	file.transferTo(targetfFile);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	    String fileUrl = request.getContextPath()+FILEURL+fileName;
	    System.out.println(fileUrl);
	    return fileUrl;
	    
	}
	
	@RequestMapping(value="musicListening.do", method=RequestMethod.GET)
	public ModelAndView music(){
		
		return new ModelAndView("functions/sendEmail");
	}
    
	@ResponseBody
	@RequestMapping(value="sendMail.do", method=RequestMethod.POST)
	public ModelAndView sendMail1(HttpServletRequest request,HttpServletResponse resp,
			@RequestParam(value="source",required=true)MultipartFile file,
			@RequestParam(value="width",required=false)Integer width,
			@RequestParam(value="height",required=false)Integer height,
			@RequestParam(value="mail_address",required=true) String mail_address,
			@RequestParam(value="mail_title",required=false)String mail_title,
			@RequestParam(value="file_name",required=false)String file_name,
			@RequestParam(value="mail_content",required=false)String mail_content
			){
		    
		  String mail_file = FileUploadController.upload(request, resp, file, width, height);
		  try{
			  if(mail_file!=null){
				  System.out.println("------------------------not null-----------------");
			  sendEmailMethod.sendMailFilter(mail_address, mail_title, mail_file, mail_content, file_name);
			  }
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return new ModelAndView("main");
		}

	

}

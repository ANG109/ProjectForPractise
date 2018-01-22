package bw.practise.ang.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import bw.practise.ang.bean.Resp;
public class FileUploadController {

	private static final Logger logger = Logger.getLogger(FileUploadController.class);
	
	/**
	 * 文件上传
	 * @return 
	 */
	@SuppressWarnings("finally")
	public static String upload(HttpServletRequest request, HttpServletResponse resp, MultipartFile file, Integer width,Integer height){
		Resp apiResp = new Resp();
		try {
			BufferedImage img = ImageIO.read(file.getInputStream());
			System.out.println("img.getWidth():"+img.getWidth());
			System.out.println("img.getHeight():"+img.getHeight());
			logger.info(String.format("上传图片宽:%d 高:%d", img.getWidth(),img.getHeight()));
			if((width!=null&&width!=img.getWidth())||(height!=null&&height!=img.getHeight())){
				apiResp.setResult(-1);
				apiResp.setMsg("图片尺寸不符合要求（"+width+"*"+height+"）");
			}else{
				// 上传文件并返回保存路径
				String path = (String) request.getSession().getAttribute("uploadRoot");
				String dir = (String) request.getSession().getAttribute("uploadDir");
				String file_type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
		        String fileName = UUID.randomUUID().toString().replaceAll("-","") + "." + file_type;  
		        File targetFile = new File(path+dir, fileName);  
		        if(!targetFile.exists()) 
		        	targetFile.mkdirs();   
		        file.transferTo(targetFile);  
		        apiResp.setResult(Resp.RESULT_OK);
		        apiResp.setMsg("/" + dir + "/" +fileName);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			apiResp.setResult(-1);
			apiResp.setMsg("系统错误");
		} finally{
			FileUploadController.writeJson(resp,JSON.toJSONString(apiResp));
			return JSON.toJSONString(apiResp);
        }
	}
	
	public static String writeJson(HttpServletResponse response, String jsonString){
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(jsonString);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		return jsonString;
	}

}
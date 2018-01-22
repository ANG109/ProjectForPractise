package bw.practise.ang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bw.practise.ang.bean.SmsRecord;
import bw.practise.ang.bean.SmsType;
import bw.practise.ang.bean.User;
import bw.practise.ang.service.SmsRecordService;
import bw.practise.ang.service.SmsTypeService;

@Controller
public class SmsController {
	
	@Autowired
	private SmsRecordService smsRecordService;
	@Autowired
	private SmsTypeService smsTypeService;
	
	@RequestMapping("returnReport.do")
	public ModelAndView returnReport(ModelMap viewMap){
		
		List<SmsType> smsType = smsTypeService.findAll();
		viewMap.put("smsType", smsType);
		return new ModelAndView("html/sms/return-report",viewMap);
		
	}
	@RequestMapping("smsRecord.do")
    public ModelAndView smsRecord(HttpServletRequest req,
    		@ModelAttribute("sessionUser") User sessionUser,
    		@RequestParam(value="send_time",required=false)String send_time,
    		@RequestParam(value="phone",required=false)String phone,
    		@RequestParam(value="result_status",required=false)Integer result_status,
    		@RequestParam(value="content",required=false)String content,
    		@RequestParam(value="sms_type",required=false) Integer sms_type,
    		ModelMap viewMap)
    		{
			 List<SmsType> smsType = smsTypeService.findAll();
		     List<SmsRecord> list=smsRecordService.smsRecord(send_time,phone,content);
		     viewMap.put("smsType", smsType);
		     viewMap.put("list", list);
		     viewMap.put("phone", phone);
		     viewMap.put("sms_type", sms_type);
		     viewMap.put("result_status", result_status);
		     viewMap.put("content", content);
		
		     return new ModelAndView("html/sms/return-report",viewMap);
    }
	
	@RequestMapping("recordReturn.do")
	 public ModelAndView recordReturn(HttpServletRequest req,
	    		@RequestParam(value="send_time",required=false)String send_time,
	    		@RequestParam(value="phone",required=false)String phone,
	    		@RequestParam(value="result_status",required=false)Integer result_status,
	    		@RequestParam(value="content",required=false)String content,
	    		@RequestParam(value="sms_type",required=false) Integer sms_type,
	    		ModelMap viewMap)
	    		{
			    
				 List<SmsType> smsType = smsTypeService.findAll();
			     List<SmsRecord> list=smsRecordService.smsRecord(send_time,phone,content);
			     viewMap.put("smsType", smsType);
			     viewMap.put("list", list);
			     viewMap.put("phone", phone);
			     viewMap.put("sms_type", sms_type);
			     viewMap.put("result_status", result_status);
			
			return new ModelAndView("html/sms/record-return",viewMap);
	}
}

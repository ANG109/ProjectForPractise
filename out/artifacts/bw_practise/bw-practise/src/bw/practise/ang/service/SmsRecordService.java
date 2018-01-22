package bw.practise.ang.service;


import java.util.List;

import bw.practise.ang.bean.SmsRecord;

public interface SmsRecordService {

	List<SmsRecord> smsRecord(String send_time, String phone, String content);
	
	

}

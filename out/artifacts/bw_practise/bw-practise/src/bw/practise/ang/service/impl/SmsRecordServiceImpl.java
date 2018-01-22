package bw.practise.ang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bw.practise.ang.bean.SmsRecord;
import bw.practise.ang.mapper.SmsRecordMapper;
import bw.practise.ang.service.SmsRecordService;

@Service
public class SmsRecordServiceImpl implements SmsRecordService{

	@Autowired
	private SmsRecordMapper smsRecordMapper;

	@Override
	public List<SmsRecord> smsRecord(String send_time, String phone, String content) {
		// TODO Auto-generated method stub
		Map<Object, String> paramMap = new HashMap<Object, String>();
		paramMap.put("phone", phone);
		paramMap.put("send_time", send_time);
		paramMap.put("content", content);
		List<SmsRecord> list = smsRecordMapper.smsRecord(paramMap);
		return list;
	}
	

}

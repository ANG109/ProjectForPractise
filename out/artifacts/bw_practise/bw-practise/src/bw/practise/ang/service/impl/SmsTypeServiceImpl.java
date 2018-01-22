package bw.practise.ang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bw.practise.ang.bean.SmsType;
import bw.practise.ang.mapper.SmsTypeMapper;
import bw.practise.ang.service.SmsTypeService;

@Service
public class SmsTypeServiceImpl implements SmsTypeService{
	
	@Autowired
	private SmsTypeMapper smsTypeMapper;

	@Override
	public List<SmsType> findAll() {
		// TODO Auto-generated method stub
		List<SmsType> list = smsTypeMapper.findAll();
		return list;
	}

}

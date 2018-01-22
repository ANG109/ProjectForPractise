package bw.practise.ang.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import bw.practise.ang.bean.SmsRecord;

public interface SmsRecordMapper {

	List<SmsRecord> smsRecord(@Param("paramMap") Map<Object, String> paramMap);

}

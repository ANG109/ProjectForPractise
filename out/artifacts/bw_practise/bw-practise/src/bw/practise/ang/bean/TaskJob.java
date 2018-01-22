package bw.practise.ang.bean;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("taskJob")
public class TaskJob {
	@Scheduled(cron = "0 0 3 * * ?")
	public void job1(){
		System.out.println("定时任务任务进行中");
		
	}

}

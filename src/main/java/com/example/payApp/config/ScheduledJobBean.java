package com.example.payApp.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledJobBean {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	
	
	@Scheduled(cron = "0 */1 * * * ?")
	public void perform() throws Exception {
		JobParameters parameters = new JobParametersBuilder()
				.addString("JobId", String.valueOf(System.currentTimeMillis())).toJobParameters();
		jobLauncher.run(job, parameters);
		
	}
	
	
	
	
	
	
}

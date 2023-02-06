package com.example.payApp.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBatchTest
class SpringBatchConfigTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Autowired
	private JobRepositoryTestUtils jobRepositoryTestUtils;
	
	@BeforeEach
	void setup() {
		jobRepositoryTestUtils.removeJobExecutions();
		
	}
	
	
	@Test
	public void testMyJob() throws Exception{
		JobParameters jobParameter = jobLauncherTestUtils.getUniqueJobParameters();
		
		JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameter);
		
		Assertions.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
	}

}

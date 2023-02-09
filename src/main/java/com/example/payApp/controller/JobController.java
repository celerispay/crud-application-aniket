package com.example.payApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;
	
	@Autowired
	private JobExplorer jobExplorer;
	

	@PostMapping("/importBanks")
	public void importCsvToDB() throws Exception{
		JobParameters jobParameters = new JobParametersBuilder()
				.addLong("startAt", System.currentTimeMillis()).toJobParameters();
			jobLauncher.run(job, jobParameters);
	}
	
	@GetMapping("/allJobs")
	public List<String> getAllJobs(){
		return jobExplorer.getJobNames();
	}
	
	@GetMapping("/failedJobs")
	public ResponseEntity<String> getFailedExitStatus(){
		String jabName = job.getName();
		JobInstance instanceId = jobExplorer.getLastJobInstance(jabName);
		List<JobExecution> list  = jobExplorer.getJobExecutions(instanceId);
		for(JobExecution j : list) {
			JobExecution jobExecution = new JobExecution(j);
			if(jobExecution.getStatus() == BatchStatus.FAILED) {
				
				return ResponseEntity.status(HttpStatus.FOUND).body("Job Fail with Job name " + jabName + "");
			}
		}
		return ResponseEntity.ok().body("Every Job Running fine");
		
	}
	
}

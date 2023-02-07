package com.example.payApp.config;





import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.batch.test.StepScopeTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;

import com.example.payApp.models.Bank;


@SpringBatchTest
@SpringBootTest
@ActiveProfiles("dev")
class SpringBatchConfigTest {
	
 
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Autowired
	private JobRepositoryTestUtils jobRepositoryTestUtils;
	
	 @Autowired
	    private FlatFileItemReader<Bank> reader;
	
	@BeforeEach
	void setup() {
		jobRepositoryTestUtils.removeJobExecutions();
		
	}
	
	@DisplayName("This is testing the Job launcher is working with exit status completed")
	@Test
	public void testMyJob() throws Exception{
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		
		Assertions.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
	}
	
	
	@DisplayName("This checking Item reader is working")
	@Test
	public void readerTest() throws Exception {
		ExecutionContext context = new ExecutionContext();
		context.put("filename", new ClassPathResource("top15banks.csv"));
		
		StepExecution stepExecution = MetaDataInstanceFactory.createStepExecution(context);
		
		List<Bank> items = StepScopeTestUtils.doInStepScope(stepExecution, () -> {
            List<Bank> result = new ArrayList<>();
            Bank item;
            reader.open(stepExecution.getExecutionContext());
            while ((item = reader.read()) != null) {
                result.add(item);
            }
            reader.close();
            return result;
        });
		
		
		int expectedSize = 15;
		Assertions.assertEquals(expectedSize, items.size());
		
	}
	
	
	
	

}

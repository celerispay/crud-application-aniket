package com.example.payApp.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.example.payApp.models.Bank;
import com.example.payApp.repository.BankRepository;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private BankRepository bankRepository;

	@Bean
	public FlatFileItemReader<Bank> reader(){
		FlatFileItemReader<Bank> itemReader = new FlatFileItemReader<Bank>();
		itemReader.setResource(new ClassPathResource("top15banks.csv"));
		itemReader.setName("csvReader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());
		return itemReader;
	}
	
	private LineMapper<Bank> lineMapper(){
		DefaultLineMapper<Bank> lineMapper = new DefaultLineMapper<Bank>();
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("id","bank","country", "totalAssetsusb", "balanceSheet");
		
		BeanWrapperFieldSetMapper<Bank> fieldSetMapper = new BeanWrapperFieldSetMapper<Bank>();
		fieldSetMapper.setTargetType(Bank.class);
		
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
		
	}
	
	@Bean
	public BankProcessor processor() {
		return new BankProcessor();
	}
	
	@Bean
	public RepositoryItemWriter<Bank> writer(){
		RepositoryItemWriter<Bank> writer = new RepositoryItemWriter<Bank>();
		
		writer.setRepository(bankRepository);
		writer.setMethodName("save");
		return writer;
	}
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("csv-step").<Bank,Bank>chunk(1)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.faultTolerant()
				.skipLimit(1)
				.skip(Exception.class)
				.taskExecutor(taskExecutor())
				.build();
	}
	
	@Bean
	public Job runJob() {
		return jobBuilderFactory.get("importBanks")
				.flow(step1()).end().build();
	}
	
	@Bean
	public TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
		asyncTaskExecutor.setConcurrencyLimit(10);
		return asyncTaskExecutor;
	}
	
}

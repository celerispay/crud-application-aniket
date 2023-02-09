package com.example.payApp.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.example.payApp.PayAppApplication;
import com.example.payApp.models.Customer;
import com.example.payApp.repository.service.CustomerRepoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = {PayAppApplication.class})
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@DirtiesContext
@ActiveProfiles("dev")
class CustomerServiceImplTest {
	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	
	@MockBean
	private CustomerRepoService customerRepoServiceMock;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		new ObjectMapper();
	}
	@DisplayName("This will  addCustomer")
	@Test
	void testAddCustomers() {
		Customer expectedCustomer = new Customer((long)1,"Aniket Kumar","9090909090","aniket@gmail.com", 10000, "Upi");
		
		when(customerRepoServiceMock.save(any(Customer.class))).thenReturn(expectedCustomer);
		Customer customer = new Customer("Aniket Kumar","9090909090","aniket@gmail.com", 10000, "Upi");
		Long actualCustomerId = customerServiceImpl.addCustomers(customer);
		Assertions.assertEquals(actualCustomerId, expectedCustomer.getCustomerId());
		
	}

	@Test
	@DisplayName("This will find customer")
	void testFindCustomerById() {
		Customer expectedCustomer = new Customer((long)1,"Aniket Kumar","9090909090","aniket@gmail.com", 10000, "Upi");
		when(customerRepoServiceMock.findById(anyLong())).thenReturn(expectedCustomer);
		Customer actualCustomer = customerServiceImpl.findCustomerById((long)1);
		Assertions.assertEquals(actualCustomer, expectedCustomer);
	}
	
	@DisplayName("This will Update the customer")
	@Test
	void testUpdateCustomerById() {
		Customer expectedCustomer = new Customer((long)1,"Aniket Kumar","9090909090","aniket@gmail.com", 10000, "Card");
		when(customerRepoServiceMock.updateById(any(Customer.class), anyLong())).thenReturn(expectedCustomer);
		Customer customer = new Customer("Aniket Kumar","9090909090","aniket@gmail.com", 10000, "Upi");
		Customer actualCustomer = customerServiceImpl.updateCustomerById(customer,(long) 1);
		Assertions.assertEquals(actualCustomer, expectedCustomer);
	}


}

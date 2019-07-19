package com.yjqz.binge.batch.xml.job001;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.yjqz.binge.batch.xml.domain.Customer;

public class Job01ItemProcess implements ItemProcessor<List<String>, List<String>>{

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<String> process(List<String> items) throws Exception {
		for (String custIdStr : items) {
			
			Customer customer = new Customer();
//			customer.setCustomerNo(UUID.randomUUID().toString());
			customer.setCustId(Integer.valueOf(custIdStr));
			em.persist(customer);
			System.out.println("process");
			logger.info("process: [{}]", customer);
		}
		return items;
	}

}

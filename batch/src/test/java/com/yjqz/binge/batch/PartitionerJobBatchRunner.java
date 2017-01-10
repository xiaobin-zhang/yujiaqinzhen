package com.yjqz.binge.batch;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/config/batch-context.xml", "/job002.xml"})
public class PartitionerJobBatchRunner {

	@Autowired
	public JobOperator jobOperator;
	
	@Autowired
	public JobExplorer jobExplorer;
	
	@Test
	public void simpleJobRunner2(){
		try {
			Set<String> jobNames = jobOperator.getJobNames();
			for (String jobName : jobNames) {
				Long instance = jobOperator.startNextInstance(jobName);
				JobExecution je = jobExplorer.getJobExecution(instance);
				System.out.println(je.getExitStatus());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}

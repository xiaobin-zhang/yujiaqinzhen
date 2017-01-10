package com.yjqz.binge.batch.xml.job001;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

public class SimpleJobIncrementer implements JobParametersIncrementer{

	@Override
	public JobParameters getNext(JobParameters parameters) {
		String yyyymmdd = new SimpleDateFormat("yyyyMMdd").format(new Date());
		return new JobParametersBuilder()
				.addString("yyyymmdd", yyyymmdd)
				.toJobParameters();
	}

}

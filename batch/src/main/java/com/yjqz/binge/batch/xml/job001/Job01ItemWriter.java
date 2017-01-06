package com.yjqz.binge.batch.xml.job001;

import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamWriter;

public class Job01ItemWriter implements ItemStreamWriter<String>{

	@Override
	public void close() throws ItemStreamException {
		
	}

	@Override
	public void open(ExecutionContext ec) throws ItemStreamException {
		
	}

	@Override
	public void update(ExecutionContext ec) throws ItemStreamException {
		
	}

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println(items.toString());
	}

}

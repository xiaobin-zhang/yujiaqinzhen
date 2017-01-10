package com.yjqz.binge.batch.xml.job002;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
@Service
@Scope("step")
public class Job01ItemProcess implements ItemProcessor<List<String>, List<String>>{

	@Override
	public List<String> process(List<String> items) throws Exception {
		String str = items.toString();
		items.add(str);
		return items;
	}

}

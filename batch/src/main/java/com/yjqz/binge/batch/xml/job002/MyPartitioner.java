package com.yjqz.binge.batch.xml.job002;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
@Service
@Scope("step")
public class MyPartitioner implements Partitioner{

	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		Map<String,ExecutionContext> result = new TreeMap<String, ExecutionContext>();
		for (int i = 0; i < gridSize; i++) {
			ExecutionContext context = new ExecutionContext();
			context.put("key", String.valueOf(i));
			context.put("gridSize", String.valueOf(gridSize));
			result.put(String.valueOf(i), context);
		}
		return result;
	}

}

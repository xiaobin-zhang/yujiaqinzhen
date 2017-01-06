package com.yjqz.binge.batch.xml.job001;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Job01ItemReader implements ItemStreamReader<List<String>>{

	/*
	 * 关闭读取的资源。
	 */
	@Override
	public void close() throws ItemStreamException {
		
	}

	/*
	 * 根据参数ec打开需要读取资源的stream；可以根据持久化在执行上下文executionContext中的数据重新定位需要读取记录的位置。
	 */
	@Override
	public void open(ExecutionContext ec) throws ItemStreamException {
		
	}

	/*
	 * 将需要持久化的数据存放在执行上下文executionContext中。
	 */
	@Override
	public void update(ExecutionContext ec) throws ItemStreamException {
		
	}

	@Override
	public List<String> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		List<String> strs = new ArrayList<String>();
		strs.add("good");
		strs.add("very good");
		strs.add("very very good");
		return strs;
	}


}

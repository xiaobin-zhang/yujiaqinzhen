package com.yjqz.binge.event.demo;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yjqz.binge.event.demo.Result.TransResult;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConversationEventConfig.class);
		CoversationRunner publisher = context.getBean(CoversationRunner.class);
		publisher.conversation();
		context.close();
	}
	
	public static String getResult(){
		StringWriter str=new StringWriter();
		Result result = new Result();
		result.setFrom("from");
		result.setTo("to");
		Result.TransResult transResult = new Result.TransResult();
		transResult.setDst("Dst");
		transResult.setSrc("Src");
		List<TransResult> list = new ArrayList<TransResult>();
		list.add(transResult);
		result.setTrans_result(list);
		ObjectMapper objectMapper = new ObjectMapper();
	
		try {
			objectMapper.writeValue(str, result);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(str);
		return str.toString();
	}
}

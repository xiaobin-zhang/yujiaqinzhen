package com.yjqz.binge.event.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yjqz.binge.event.baidufanyi.TransApi;
import com.yjqz.binge.event.demo.Result.TransResult;

@Component
public class ConversationListener implements ApplicationListener<ConversationEvent>{

	private static final String APP_ID = "20170704000062547";
	 
	private static final String SECURITY_KEY = "J2iKQ8rbHBqqO3Wtv6e1";
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public void onApplicationEvent(ConversationEvent event) {
		String name = event.getName();
		String content = event.getContent();
		String usedLanguage = event.getUsedLanguage();
		String transResult = transResult(content, usedLanguage);
		Result result = new Result();;
		try {
			result = objectMapper.readValue(transResult, Result.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<TransResult> trans_result = result.getTrans_result();
		if (trans_result != null && trans_result.size() > 0) {
			StringBuffer sb = new StringBuffer();
			for (TransResult tr : trans_result) {
				sb.append(tr.getDst());
			}
			System.out.println(name + " say :" + sb.toString());
		}
	}

	public String transResult(String content, String usedLanguage){
		TransApi api = new TransApi(APP_ID, SECURITY_KEY);
		String result = api.getTransResult(content, "auto", usedLanguage);
		return result;
	}
}

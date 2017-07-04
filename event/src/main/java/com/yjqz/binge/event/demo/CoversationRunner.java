package com.yjqz.binge.event.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class CoversationRunner {

	@Autowired
	ApplicationContext applicationContext;
	
	public void conversation(){
		ConversationEvent usedZhEvent = new ConversationEvent(this);
		usedZhEvent.setName("周杰伦");
		usedZhEvent.setContent("哎哟！不错哦");
		applicationContext.publishEvent(usedZhEvent);
		
		ConversationEvent usedEnEvent = new ConversationEvent(this);
		usedEnEvent.setUsedLanguage("en");
		usedEnEvent.setName("乔丹");
		usedEnEvent.setContent("一切皆有可能");
		applicationContext.publishEvent(usedEnEvent);
		
		ConversationEvent usedJpEvent = new ConversationEvent(this);
		usedJpEvent.setUsedLanguage("jp");
		usedJpEvent.setName("龟田太君");
		usedJpEvent.setContent("请多关照");
		applicationContext.publishEvent(usedJpEvent);
		
		ConversationEvent usedKorEvent = new ConversationEvent(this);
		usedKorEvent.setUsedLanguage("kor");
		usedKorEvent.setName("朴槿惠");
		usedKorEvent.setContent("哥，我爱你");
		applicationContext.publishEvent(usedKorEvent);
		
		ConversationEvent usedWywEvent = new ConversationEvent(this);
		usedWywEvent.setUsedLanguage("wyw");
		usedWywEvent.setName("孔子");
		usedWywEvent.setContent("知道就知道，不知道就是知道，这才是聪明的");
		applicationContext.publishEvent(usedWywEvent);
		
		ConversationEvent usedWywEvent2 = new ConversationEvent(this);
		usedWywEvent2.setUsedLanguage("wyw");
		usedWywEvent2.setName("李白");
		usedWywEvent2.setContent("仰首看那空中的一轮明月，不由得低下头来沉思，愈加想念自己的故乡");
		applicationContext.publishEvent(usedWywEvent2);
		
		ConversationEvent usedWywEvent3 = new ConversationEvent(this);
		usedWywEvent3.setUsedLanguage("wyw");
		usedWywEvent3.setName("李白");
		usedWywEvent3.setContent("侠士的宝剑锋利无比，剑术高超，所向无敌，在十步之内就能结束别人的性命，侠士身下的白马日行千里，千里漫长的路途也阻留不住他们前进飞驰的脚步");
		applicationContext.publishEvent(usedWywEvent3);
	}
}

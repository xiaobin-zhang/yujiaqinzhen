#Spring Integration Spring集成
	主要解决的问题是，不同系统之间交互的问题，通过异步消息驱动来达到系统之间的松耦合。
##主要知识点：

1. Message
2. Channel
3. Message EndPoint

##知识点详解

1. Message:用来在不同部分之间传递数据。Message由两部分组成：消息体(payload)和消息头(header)。消息体可以是任何数据类型(XML、JSON、Java对象)；消息头表示的元素就是解释消息体的内容。<br>	
```
			pulic interface Message<T> {
				T getPayload();
				MessageHeaders getHeaders();
			}
```
2. Channel:在消息体统中，消息发送者发送消息到通道(Channel)，消息收受者从通道(Channel)接收消息。MessageChannel是SpringIntegration消息通道的顶级接口。当使用send方法发送消息时。返回值为true,表示消息发送成功。MessageChannel有两大子接口，分别是PollableChannel(可轮询)和SubscribableChannel(可订阅)。我们所有的消息通道类型都是实现这两个接口。<br>
```
			public interface MessageChannel {
				public static long INDEFINITE_TIMEOUT = -1;
				boolean send(Message<?> message);
				boolean send(Message<?> message, long timeout);
			}
```

> 常用消息通道：
>> (1) PublishSubscribeChannel:允许广播消息给所有的订阅者。
```
			@Bean
			public PublishSubscribeChannel publishSubscribeChannel() {
				PublishSubscribeChannel channel = new PublishSubscribeChannel()
				return channel;
			}
			//其中，当前的消息通道id为publishSubscribeChannel。
```
>> (2) QueueChannel:允许消息接收者轮询获得消息，用一个队列接收消息，队列的容量大小可配置。
```
			@Bean
			public QueueChannel queueChannel() {
				QueueChannel channel = new QueueChannel(10);
				return channel; 
			}
			//其中构造参数10即为队列的容量。
```
>> (3) PriorityChannel:可以依据消息头的priority,按照优先级将数据存储到队列，
```
			@Bean
			public PriorityChannel priotityChannel() {
				PriorityChannel channel = new PriorityChannel(10);
				return channel;
			}
```
>> (4) RendezvousChannel:确保每一个接收者都收到消息后再发送消息。
```
			@Bean
			public RendezvousChannel priotityChannel() {
				RendezvousChannel channel = new RendezvousChannel();
				return channel;
			}
```
>> (5) DirectChannel:是Spring Integration默认的消息通道，它允许将消息发送给一个订阅者，然后阻碍消息发送直到消息被接收。
```
			@Bean
			public DirectChannel priotityChannel() {
				DirectChannel channel = new DirectChannel();
				return channel;
			}
```
>> (6) ExecutorChannel:可绑定一个多线程的task executor.
```
			@Bean
			public ExecutorChannel priotityChannel() {
				ExecutorChannel channel = new ExecutorChannel(executor());
				return channel;
			}
			
			@Bean
			public Executor executor() {
				ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
				taskExecutor.setCorePoolSize(5);
				taskExecutor.setMaxPoolSize(10);
				taskExecutor.setQueueCapacity(25);
				taskExecutor.initialize();
				return taskExecutor;
			}
```

3. Message EndPoint:消息端点，真正处理消息的组件，还可以控制通道的路由。

>(1) Channel Adapter



			





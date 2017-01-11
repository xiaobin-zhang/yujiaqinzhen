#Scheduled计划任务
###计划任务在Spring中实现异常的简单。首先通过@EnableScheduling来开启对计划任务的支持，然后在要执行计划任务的方法上注@Scheduled,声明这是一个计划任务.

###@Scheduled支持多种类型的计划任务，包含 cron ，fixDelay ，fixRate等。
- cron:该属性表示，按照指定时间执行，cron是UNIX和Linux系统下的定时任务。
- fixDelay:该属性表示，当前任务在执行结束之后，间隔fixDalay指定的时间后，再次执行。
- fixRate:该属性表示，当前任务启动之后，间隔fixRate指定的时间后，再次启动。但是，如果当前任务执行时间超过fixRate指定的时间，则该任务需要在执行结束后，经fixRate指定的时间等待后，再次启动。

###定时任务也可以通过xml配置文件来实现。
	
		1<task:scheduler id="taskScheduler1" pool-size="5"/>
		2<task:scheduled-tasks scheduler="taskScheduler1">
		3	<task:scheduled ref="demoClass" method="processMethod1" fixed-delay="1000"/>
		4	<task:scheduled ref="demoClass" method="processMethod2" fixed-rate="1000"/>
		5</task:scheduled-tasks>
1. 创建一个线程池，线程数为1；
2. 创建一个scheduled-tasks，为其分配线程池taskScheduler1；
3. 声明一个轮询任务，ref=轮询任务类，method=该类中需要轮芯的方法。fixed-dalay指定间隔时间。
4. 上面配置中，第三行和第四行分别代表两个轮询任务，两个任务之间互不干涉，其间隔时间仅针对其本身的任务而言。两者之间谁抢到线程谁执行。
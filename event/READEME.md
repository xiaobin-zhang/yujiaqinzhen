#Application Event 事件
###Spring Event 需要遵守以下流程：
1. 自定义事件，继承ApplicationEvent
2. 定义事件监听器，实现ApplicationListener
3. 使用容器发布事件.

###Spring 事件其主要通过应用了观察者模式来实现。

##Lombok:
- @EqualsAndHashCode:此注解会生成equal和hashCode方法，可以通过exclude排除一些属性，可以通过参数of指定仅使用那些属性，它默认仅使用该类中定义的属性，可以通过callSuper=true让其生成的方法中调用父类的方法。
- @Data相当于@Gatter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode这5个注解的集合。


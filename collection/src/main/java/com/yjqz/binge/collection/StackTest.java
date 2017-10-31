package com.yjqz.binge.collection;

import java.util.Stack;

import org.junit.Test;

public class StackTest {

	@Test
	public void test1() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1); //入栈
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack);
		System.out.println(stack.search(4)); //返回4在栈中的位置
		
		stack.pop(); //出栈
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		
		System.out.println(stack.empty());
	}
	
	@Test
	public void test2() {
		Stack<String> stack = new Stack<String>();
		stack.push("apple1");
		stack.push("apple2");
		stack.push("apple3");
		System.out.println(stack.peek()); //查看栈顶的信息
		System.out.println(stack.empty()); //判断栈是否为空
		System.out.println(stack.search("apple1")); //返回apple1在栈中的位置
	}
	
	
}

package com.yjqz.binge.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

public class ListTest {

	@Test
	public void test1() {
		/**
		 * 不建议使用asList转换数组为list,有缺陷
		 */
		int[] a = {1,2,3,4,5};
		List<int[]> list = Arrays.asList(a); //在使用 asList 时不要将基本数据类型当做参数。
		System.out.println(list); 
		
		Integer[] b = {1,2,3,4,5};
		List<Integer> list2 = Arrays.asList(b);
		System.out.println(list2);
		
		boolean add = list2.add(6);	//不要试图改变 asList 返回的列表,这里会抛java.lang.UnsupportedOperationException异常
		System.out.println(add);
	}
	
	@Test
	public void test2() {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		List<Integer> list2 = new ArrayList<Integer>(list1);
		List<Integer> list3 = list1.subList(0, list1.size()); //subList 返回的只是原列表的一个视图，它所有的操作最终都会作用在原列表上
		
		System.out.println(list1.equals(list2));
		System.out.println(list1.equals(list3));
		
		list3.add(5);
		System.out.println(list1.equals(list3));
		
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		
		list1.add(6);
		System.out.println(list1);
		System.out.println(list3); //生成子列表后，不要试图去操作原列表，否则会造成子列表的不稳定而产生异常,java.util.ConcurrentModificationException
	}
	
	@Test
	public void test3() {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		System.out.println(list1);
		/*
		 * 删除列表中某一段的数据
		 */
		for (int i = 0; i < list1.size(); i++) {
			if (i > 2 && i < 4) {
				list1.remove(i);
			}
		}
		System.out.println(list1);
		
		list1.clear();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		System.out.println(list1);
		list1.subList(3, 4).clear(); //推荐使用 subList 处理局部列表
		System.out.println(list1);
	}
	
	@Test
	public void test4() {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		for (Integer a : list1) {
			if (a == 2) {
				list1.add(6); //fail-fast java.util.ConcurrentModificationException
			}
		}
	}
	
	@Test
	public void test5() {
		//解决fail-fast 问题
		List<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<Integer>();
		copyOnWriteArrayList.add(1);
		copyOnWriteArrayList.add(2);
		copyOnWriteArrayList.add(3);
		copyOnWriteArrayList.add(4);
		copyOnWriteArrayList.add(5);
		
		for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
			if (i == 2) {
				copyOnWriteArrayList.add(6);
			}
		}
		System.out.println(copyOnWriteArrayList);
	}
}

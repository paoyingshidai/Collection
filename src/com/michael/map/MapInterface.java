package com.michael.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class MapInterface {

	private static Map<Object,Object> map;

	public static void hashMapSize() {
		map = new HashMap<>();
		map.put("key1","value1");
		map.put("key2","value2");
		map.put("key3","value3");
		map.put("key4","value3");
		map.put("key7","value3");
		map.put("key6","value3");
		map.put("key0","value3");
		map.put("key8","value3");

		map.put(new String("key9"),"value3");
		map.put(new String("key9"),"value4");

		for (Entry<Object, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
//		无序。 且键不能相同，若相同 则覆盖
//		key1-value1
//		key2-value2
//		key0-value3
//		key6-value3
//		key3-value3
//		key4-value3
//		key9-value3
//		key7-value3
//		key8-value3
	}


	public static void identifyHashMap() {
		IdentityHashMap<Object, Object> map = new IdentityHashMap<>();
		map.put("key1","value1");
		map.put("key2","value2");
		map.put("key3","value3");
		map.put("key4","value3");
		map.put("key7","value3");
		map.put("key6","value3");
		map.put("key0","value3");
		map.put("key8","value3");

		String string = new String("key9");

		map.put(string,"value3");
		map.put(new String("key9"),"value4");


		System.out.println(map.get(string));
//		value3

//		for (Entry<Object, Object> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + "-" + entry.getValue());
//		}
	}

	public static void linkedHashMap() {
		map = new LinkedHashMap<>();
		map.put("key1","value1");
		map.put("key2","value2");
		map.put("key3","value3");
		map.put("key4","value3");
		map.put("key7","value3");
		map.put("key6","value3");
		map.put("key0","value3");
		map.put("key8","value3");

		map.put("key9","value3");
		map.put("key9","value4");

		for (Entry<Object, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
//		先进先出
//		key1-value1
//		key2-value2
//		key3-value3
//		key4-value3
//		key7-value3
//		key6-value3
//		key0-value3
//		key8-value3
//		key9-value4
	}

	public static void treeMapOrder() {
		map = new TreeMap<>();
		map.put("key1","value1");
		map.put("key2","value2");
		map.put("key3","value3");
		map.put("key4","value3");
		map.put("key7","value3");
		map.put("key6","value3");
		map.put("key0","value3");
		map.put("key8","value3");

		map.put("key9","value3");
		map.put("key9","value4");

		for (Entry<Object, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
//		顺序
//		key0-value3
//		key1-value1
//		key2-value2
//		key3-value3
//		key4-value3
//		key6-value3
//		key7-value3
//		key8-value3
//		key9-value4
	}

	public static void treeMap() {

		map = new TreeMap<>();
		// 实现同步
		map = Collections.synchronizedMap(map);
		map.put("a", 3);
		map.put("b", 2);
		map.put("c", 1);
		map.put("f", 1);
		map.put("e", 2);
		map.put("d", 3);
		for (Entry<Object, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
//		根据 key 进行排序
//		结果
//		a-3
//		b-2
//		c-1
//		d-3
//		e-2
//		f-1
	}

	public static void storedMap() {

	}

}

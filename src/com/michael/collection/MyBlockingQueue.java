package com.michael.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class MyBlockingQueue {

	private static BlockingQueue<Object> blockingQueue;

	public static void arrayBlockingQueue() throws InterruptedException{
		blockingQueue = new ArrayBlockingQueue<>(13);

		// 如果生产者的数量大于缓冲区，那么生产动作就会一直阻塞，知道有位置保存元素
		for (int i = 0; i < 14; i++) {
			blockingQueue.put(i);
		}
		System.out.println(blockingQueue.size());
		int size = blockingQueue.size();
		for (int i = 0; i < size+1; i++) {
			System.out.println(blockingQueue.poll(i,TimeUnit.SECONDS));
		}

		// 如果有元素就立即取出， 如果没有就等待 i 秒后在取出。
		// 最后一个元素等到十秒后在取
		System.out.println("取完");
	}

	public static void delayedQueue() throws Exception{
		DelayQueue<MyDelayed> delayQueue = new DelayQueue<>();
		delayQueue.add(new MyDelayed(3000));
		// 三秒后执行方法
		Thread.sleep(4000);
		new Thread(delayQueue.poll()).start();
	}

}

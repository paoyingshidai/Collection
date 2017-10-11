package com.michael.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class MyBlockingQueue {

	private static BlockingQueue<Object> blockingQueue;

	public static void arrayBlockingQueue() throws InterruptedException{
		blockingQueue = new ArrayBlockingQueue<>(13);

		// ��������ߵ��������ڻ���������ô���������ͻ�һֱ������֪����λ�ñ���Ԫ��
		for (int i = 0; i < 14; i++) {
			blockingQueue.put(i);
		}
		System.out.println(blockingQueue.size());
		int size = blockingQueue.size();
		for (int i = 0; i < size+1; i++) {
			System.out.println(blockingQueue.poll(i,TimeUnit.SECONDS));
		}

		// �����Ԫ�ؾ�����ȡ���� ���û�о͵ȴ� i �����ȡ����
		// ���һ��Ԫ�صȵ�ʮ�����ȡ
		System.out.println("ȡ��");
	}

	public static void delayedQueue() throws Exception{
		DelayQueue<MyDelayed> delayQueue = new DelayQueue<>();
		delayQueue.add(new MyDelayed(3000));
		// �����ִ�з���
		Thread.sleep(4000);
		new Thread(delayQueue.poll()).start();
	}

}

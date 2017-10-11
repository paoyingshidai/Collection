package com.michael.collection;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TaskQueueDaemonThread {

	private TaskQueueDaemonThread() {

	}

	private static class LazyHolder {
		private static TaskQueueDaemonThread taskQueueDaemonThread
					= new TaskQueueDaemonThread();
	}

	public static TaskQueueDaemonThread getInstance() {
		return LazyHolder.taskQueueDaemonThread;
	}

	Executor executor = Executors.newFixedThreadPool(20);

	private Thread daemonThread;

	public void init() {
		daemonThread = new Thread(() -> execute());
		daemonThread.setDaemon(true);
		daemonThread.setName("Task Queue Daemon Thead");
		daemonThread.start();
	}

	private void execute() {
		System.out.println("start: " + System.currentTimeMillis());
		while (true) {
			try {
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	private DelayQueue<Task> t = new DelayQueue<>();

	public void put(long time, Runnable task) {
		long nanoTime = TimeUnit.NANOSECONDS.convert(time, TimeUnit.MILLISECONDS);
		Task k = new Task<Runnable>(nanoTime, task);
		t.put(k);
	}

	public boolean endTask(Task<Runnable> task) {
		return t.remove(task);
	}
}

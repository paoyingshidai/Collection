package com.michael.netbar;

import java.util.concurrent.DelayQueue;

public class NetBar {

	private DelayQueue<People> peoples = new DelayQueue<>();

	public void upLine(People people) {
		peoples.put(people);
		System.out.println(people.getName() + " иооъ");
	}

	public People downLine() throws InterruptedException {
		return peoples.take();
	}

}

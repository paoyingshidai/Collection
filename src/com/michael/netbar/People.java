package com.michael.netbar;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class People implements Delayed, Runnable {

	private final long time;

	private String name;

	public People(long time, String name) {
		this.time = time + System.currentTimeMillis();
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + " обоъ");
	}


	@Override
	public int compareTo(Delayed o) {
		if (o == null) {
			return 0;
		}
		if (o instanceof People) {
			People people = (People) o;
			long d = getDelay(TimeUnit.MILLISECONDS) - people.getDelay(TimeUnit.MILLISECONDS);
			return d == 0 ? 0 :(d < 0 ? -1 : 1);
		}
		long d = getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS);
		return d == 0 ? 0 :(d < 0 ? -1 : 1);
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(time - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

package com.michael.collection;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class MyDelayed implements Delayed,Runnable{

	private final long handlerTime;

	public MyDelayed(long delayTime) {
		this.handlerTime = delayTime + System.currentTimeMillis();
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert((handlerTime - System.currentTimeMillis()),
				TimeUnit.MILLISECONDS);
	}

	@Override
	public int compareTo(Delayed object){
		if (object == null) {
			System.out.println("delayed can't be null");
			return 0;
		}
		if (object instanceof MyDelayed) {
			MyDelayed delayed = (MyDelayed) object;
			long d = this.getDelay(TimeUnit.MILLISECONDS)
					- delayed.getDelay(TimeUnit.MILLISECONDS);

			return d == 0 ? 0 : (d < 0 ? -1 : 1);
		}
		long d = this.getDelay(TimeUnit.MILLISECONDS)
				- object.getDelay(TimeUnit.MILLISECONDS);
		return d == 0 ? 0 : (d < 0 ? -1 : 1);
	}

	@Override
	public String toString() {
		return "do something";
	}

	@Override
	public void run() {
		System.out.println("登陆完成后发送短信   : " +
				+ System.currentTimeMillis());
	}

}

package com.michael.collection;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Task<T extends Runnable> implements Delayed{

	private final long time;

	private final T task;

	private static final AtomicLong atomic = new AtomicLong(0);

	private final long n;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}


	public Task(long timeout, T task) {
		super();
		this.time = System.nanoTime() + timeout;
		this.task = task;
		this.n = atomic.getAndIncrement();
	}


	@Override
	public int compareTo(Delayed o) {
		if (o == this) {
			return 0;
		}
		if (o instanceof Task) {
			Task x = (Task) o;
			long diff = time - x.time;
			if (diff < 0) {
				return -1;
			}else if (diff > 0) {
				return 1;
			}else if (n < x.n) {
				return -1;
			}else {
				return 1;
			}
		}
		long d = (getDelay(TimeUnit.NANOSECONDS)-o.getDelay(TimeUnit.NANOSECONDS));
		return (d == 0) ? 0 : ((d<0) ? -1 : 1);
	}

	public T getTask() {
		return task;
	}

	@Override
	public int hashCode() {
		return task.hashCode();
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(this.time - System.nanoTime(), TimeUnit.NANOSECONDS);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Task) {
			return obj.hashCode() == hashCode() ? true : false;
		}
		return super.equals(obj);
	}

}

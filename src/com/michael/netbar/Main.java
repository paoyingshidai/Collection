package com.michael.netbar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

	public  void main(String[] args) throws InterruptedException {
		Executor executor = Executors.newCachedThreadPool();
		NetBar netBar = new NetBar();
		netBar.upLine(new People(1000, "1111"));
		netBar.upLine(new People(2000, "2222"));
		netBar.upLine(new People(3000, "3333"));
		new CustomBuilder(netBar).start();
		while(true) {
			executor.execute(netBar.downLine());
		}
	}

}

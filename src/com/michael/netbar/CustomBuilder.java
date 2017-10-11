package com.michael.netbar;

public class CustomBuilder extends Thread{

	private NetBar netBar;

	public CustomBuilder(NetBar netBar) {
		this.netBar = netBar;
	}

	// 模拟中途有客人加入网吧
	@Override
	public void run() {
		int i = 10;
		while(i > 0) {
			netBar.upLine(new People(i * 1000, "用户" + i + ""));
			i--;
		}
	}

}

package com.michael.netbar;

public class CustomBuilder extends Thread{

	private NetBar netBar;

	public CustomBuilder(NetBar netBar) {
		this.netBar = netBar;
	}

	// ģ����;�п��˼�������
	@Override
	public void run() {
		int i = 10;
		while(i > 0) {
			netBar.upLine(new People(i * 1000, "�û�" + i + ""));
			i--;
		}
	}

}

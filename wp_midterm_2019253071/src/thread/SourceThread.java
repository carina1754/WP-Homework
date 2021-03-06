package thread;

import wp_midterm_2019253071.*;

public class SourceThread implements Runnable{
	
	int scvUnitCount;
	User user;
	int threadCount = 0;	// SCV가 5번 자원을 벌때마다 자원 출력
	public int getcount() {
		return threadCount;
	}
	public void addUnitcount() {
		scvUnitCount++;
	}
	public void subUnitcount() {
		scvUnitCount--;
	}
	public SourceThread(User user, int scvUnitCount) {
		this.user = user;
		this.scvUnitCount = scvUnitCount;
	}

	@Override
	public void run() {
		while(true) {
			try {
				if(scvUnitCount == 0) {
					System.out.println("SCV가 없습니다.                                    SCV를 생산해 주세요.");
				}
				
				Thread.sleep(1000);
				user.addResource(scvUnitCount, threadCount);
				threadCount ++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
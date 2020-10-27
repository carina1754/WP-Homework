package thread;

import wp_midterm_2019253071.*;

public class SourceThread implements Runnable{
	
	int scvUnitCount;
	User user;
	int threadCount = 0;	// SCV�� 5�� �ڿ��� �������� �ڿ� ���
	
	public SourceThread(User user, int scvUnitCount) {
		this.user = user;
		this.scvUnitCount = scvUnitCount;
	}

	@Override
	public void run() {
		while(true) {
			try {
				if(scvUnitCount == 0) {
					System.out.println("SCV�� �����ϴ�... Thread�� �����մϴ�");
					break;
				}
				
				Thread.sleep(5000);
				user.addResource(scvUnitCount, threadCount);
				threadCount ++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
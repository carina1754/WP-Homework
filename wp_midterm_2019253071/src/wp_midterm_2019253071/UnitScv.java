package wp_midterm_2019253071;
import wp_midterm_2019253071.*;
public class UnitScv {
	private static int scvNum = 0;
	public UnitScv(){
		
	}
	public int getMineral() {	
		return UnitPrice.SCV_M;
	}

	public int getPopulationNum() {	
		return 1;
	}
	public int getUnitNum() {	// ���������� ȣ��, ������ +1
		this.scvNum ++;
		System.out.println("���� SCV ����: " + scvNum + "���� �Դϴ�.");
		return this.scvNum;
	}
	public void getSound() {
		System.out.println("���� SCV !!!!!!!!!!!!!");
	}
	public int getMakeTime() {	
		return UnitTime.SCV_T;
	}
	public static void setUnitNum(int i) {
		scvNum =+ i;
	}
}

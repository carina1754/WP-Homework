package wp_midterm_2019253071;

import wp_midterm_2019253071.*;
public class UnitMarine extends Unit{
	private int marineNum;
	public UnitMarine(){
		
	}
	public int getMineral() {	
		return UnitPrice.MARINE_M;
	}
	public int getPopulationNum() {	
		return 1;
	}
	public int getUnitNum() {	// ���������� ȣ��, ������ +1
		this.marineNum ++;
		System.out.println("���� ���� ����: " + marineNum + "���� �Դϴ�.");
		return this.marineNum;
	}
	public void getSound() {
		System.out.println("���� ���� !!!!!!!!!!!!!");
	}
	public int getMakeTime() {	
		return UnitTime.MARINE_T; 
	}
}

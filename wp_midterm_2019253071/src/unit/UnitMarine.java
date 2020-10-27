package unit;

import wp_midterm_2019253071.*;
public class UnitMarine extends Unit{
	
	private int marineNum=0;

	public int getMineral() {	
		return UnitPrice.MARINE_M;
	}
	public int getUnitNum() throws InterruptedException {	// ���������� ȣ��, ������ +1
		System.out.println("������ " + UnitTime.MARINE_T + "�� �ڿ� �����˴ϴ�...");
		Thread.sleep(UnitTime.MARINE_T*1000);
		this.marineNum ++;
		return this.marineNum;
	}
	public void getSound() {
		System.out.println("���� ���� !!!!!!!!!!!!!");
	}
	public int getMakeTime() {	
		return UnitTime.MARINE_T; 
	}
	
	@Override
	public void killUnit() {
		// TODO Auto-generated method stub
		this.marineNum --;
	}
	@Override
	public void printUnitInfo() {
		// TODO Auto-generated method stub
		System.out.println("����� : 40");
		System.out.println("���ݷ� : 6");
		System.out.println("���� : 0");
		System.out.println("���� ��� : ����, ����");
		System.out.println("���� �ӵ� : 15");
		System.out.println("��Ÿ� : 4");
		System.out.println("�̵��ӵ� : 1.875");
		System.out.println("�þ� : 7");
	}
	@Override
	public void printUnitPopulation() {
		// TODO Auto-generated method stub
		System.out.println("���� ���� ����: " + marineNum + "���� �Դϴ�.");	
	}
}

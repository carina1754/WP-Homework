package unit;
import wp_midterm_2019253071.*;
public class UnitScv extends Unit{

	private static int scvNum = 0;

	public int getMineral() {	
		return UnitPrice.SCV_M;
	}
	public int getUnitNum () throws InterruptedException {	// ���������� ȣ��, ������ +1
		System.out.println("SCV�� " + UnitTime.SCV_T + "�� �ڿ� �����˴ϴ�...");
		Thread.sleep(UnitTime.SCV_T*1000);
		scvNum ++;
		return scvNum;
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
	@Override
	public void killUnit() {
		// TODO Auto-generated method stub
		scvNum--;
	}
	@Override
	public void printUnitInfo() {
		// TODO Auto-generated method stub
		System.out.println("����� : 60");
		System.out.println("���ݷ� : 5");
		System.out.println("���� : 0");
		System.out.println("���� ��� : ����");
		System.out.println("���� �ӵ� : 7");
		System.out.println("��Ÿ� : 1");
		System.out.println("�̵��ӵ� : 1.875");
		System.out.println("�þ� : 7");
	}
	@Override
	public void printUnitPopulation() {
		// TODO Auto-generated method stub
		System.out.println("���� SCV ����: " + scvNum + "���� �Դϴ�.");
	}
}

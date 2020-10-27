package unit;
import wp_midterm_2019253071.*;
public class UnitScv extends Unit{

	private static int scvNum = 0;

	public int getMineral() {	
		return UnitPrice.SCV_M;
	}
	public int getUnitNum () throws InterruptedException {	// 마린생성시 호출, 마린수 +1
		System.out.println("SCV가 " + UnitTime.SCV_T + "초 뒤에 생성됩니다...");
		Thread.sleep(UnitTime.SCV_T*1000);
		scvNum ++;
		return scvNum;
	}
	public void getSound() {
		System.out.println("나는 SCV !!!!!!!!!!!!!");
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
		System.out.println("생명력 : 60");
		System.out.println("공격력 : 5");
		System.out.println("방어력 : 0");
		System.out.println("공격 대상 : 지상");
		System.out.println("공걱 속도 : 7");
		System.out.println("사거리 : 1");
		System.out.println("이동속도 : 1.875");
		System.out.println("시야 : 7");
	}
	@Override
	public void printUnitPopulation() {
		// TODO Auto-generated method stub
		System.out.println("현재 SCV 수는: " + scvNum + "마리 입니다.");
	}
}

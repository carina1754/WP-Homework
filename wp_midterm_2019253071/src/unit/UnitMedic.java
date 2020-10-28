package unit;
import wp_midterm_2019253071.*;
public class UnitMedic extends Unit{

	private int medicNum=0;

	public int getMineral() {	
		return UnitPrice.MEDIC_M;
	}
	public int getGas() {	
		return UnitPrice.MEDIC_G;
	}
	public int getPopulationNum() {	
		return 2;
	}
	public int addUnitNum() throws InterruptedException {	// 마린생성시 호출, 마린수 +1
		System.out.println("메딕이 " + UnitTime.MEDIC_T +"초 뒤에 생성됩니다...");
		Thread.sleep(UnitTime.MEDIC_T*1000);
		medicNum++;
		return medicNum;
	}
	public void getSound() {
		System.out.println("나는 메딕 !!!!!!!!!!!!!");
	}
	public int getMakeTime() {	
		return UnitTime.MEDIC_T;
	}
	
	@Override
	public void killUnit() {
		// TODO Auto-generated method stub
		medicNum --;
	}
	@Override
	public void printUnitInfo() {
		// TODO Auto-generated method stub
		System.out.println("생명력 : 60");
		System.out.println("공격력 : 0");
		System.out.println("방어력 : 1");
		System.out.println("초기 에너지 : 50");
		System.out.println("최대 에너지 : 200");
		System.out.println("이동속도 : 1.875");
		System.out.println("시야 : 9");
	}
	@Override
	public void printUnitPopulation() {
		// TODO Auto-generated method stub
		System.out.println("현재 메딕 수는: " + medicNum + "마리 입니다.");
	}
}

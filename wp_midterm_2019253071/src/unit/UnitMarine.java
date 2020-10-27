package unit;

import wp_midterm_2019253071.*;
public class UnitMarine extends Unit{
	
	private int marineNum=0;

	public int getMineral() {	
		return UnitPrice.MARINE_M;
	}
	public int getUnitNum() throws InterruptedException {	// 마린생성시 호출, 마린수 +1
		System.out.println("마린이 " + UnitTime.MARINE_T + "초 뒤에 생성됩니다...");
		Thread.sleep(UnitTime.MARINE_T*1000);
		this.marineNum ++;
		return this.marineNum;
	}
	public void getSound() {
		System.out.println("나는 마린 !!!!!!!!!!!!!");
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
		System.out.println("생명력 : 40");
		System.out.println("공격력 : 6");
		System.out.println("방어력 : 0");
		System.out.println("공격 대상 : 지상, 공중");
		System.out.println("공걱 속도 : 15");
		System.out.println("사거리 : 4");
		System.out.println("이동속도 : 1.875");
		System.out.println("시야 : 7");
	}
	@Override
	public void printUnitPopulation() {
		// TODO Auto-generated method stub
		System.out.println("현재 마린 수는: " + marineNum + "마리 입니다.");	
	}
}

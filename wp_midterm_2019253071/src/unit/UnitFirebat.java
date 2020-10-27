package unit;

import wp_midterm_2019253071.*;
public class UnitFirebat extends Unit{

	private int firebatNum=0;

	public int getMineral() {	
		return UnitPrice.FIREBAT_M;
	}

	public int getGas() {	
		return UnitPrice.FIREBAT_G;
	}
	public int getUnitNum() throws InterruptedException {	// 마린생성시 호출, 마린수 +1
		System.out.println("파이어뱃이 " + UnitTime.FIREBAT_T +"초 뒤에 생성됩니다...");
		Thread.sleep(UnitTime.FIREBAT_T*1000);
		this.firebatNum ++;
		return this.firebatNum;
	}
	public void getSound() {
		System.out.println("나는 파이어뱃 !!!!!!!!!!!!!");
	}
	public int getMakeTime() {	
		return UnitTime.FIREBAT_T;
	}

	@Override
	public void killUnit() {
		// TODO Auto-generated method stub
		this.firebatNum --;
	}

	@Override
	public void printUnitInfo() {
		// TODO Auto-generated method stub
		System.out.println("생명력 : 50");
		System.out.println("공격력 : 8*2");
		System.out.println("방어력 : 1");
		System.out.println("공격 대상 : 지상");
		System.out.println("공걱 속도 : 22");
		System.out.println("사거리 : 1.5");
		System.out.println("이동속도 : 1.875");
		System.out.println("시야 : 7");
	}

	@Override
	public void printUnitPopulation() {
		// TODO Auto-generated method stub
		System.out.println("현재 파이어뱃 수는: " + this.firebatNum + "마리 입니다.");
	}
}

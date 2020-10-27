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
	public int getUnitNum() {	// 마린생성시 호출, 마린수 +1
		this.marineNum ++;
		System.out.println("현재 마린 수는: " + marineNum + "마리 입니다.");
		return this.marineNum;
	}
	public void getSound() {
		System.out.println("나는 마린 !!!!!!!!!!!!!");
	}
	public int getMakeTime() {	
		return UnitTime.MARINE_T; 
	}
}

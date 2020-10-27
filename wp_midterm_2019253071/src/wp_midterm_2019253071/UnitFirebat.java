package wp_midterm_2019253071;

import wp_midterm_2019253071.*;
public class UnitFirebat extends Unit{
	private int firebatNum;
	public UnitFirebat(){
		
	}
	public int getMineral() {	
		return UnitPrice.FIREBAT_M;
	}
	public int getGas() {	
		return UnitPrice.FIREBAT_G;
	}
	public int getPopulationNum() {	
		return 1;
	}
	public int getUnitNum() {	// 마린생성시 호출, 마린수 +1
		this.firebatNum ++;
		System.out.println("현재 파이어뱃 수는: " + firebatNum + "마리 입니다.");
		return this.firebatNum;
	}
	public void getSound() {
		System.out.println("나는 파이어뱃 !!!!!!!!!!!!!");
	}
	public int getMakeTime() {	
		return UnitTime.FIREBAT_T;
	}
}

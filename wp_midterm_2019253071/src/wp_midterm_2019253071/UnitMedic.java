package wp_midterm_2019253071;
import wp_midterm_2019253071.*;
public class UnitMedic extends Unit{
	private int medicNum;
	public UnitMedic(){
		
	}
	public int getMineral() {	
		return UnitPrice.MEDIC_M;
	}
	public int getGas() {	
		return UnitPrice.MEDIC_G;
	}
	public int getPopulationNum() {	
		return 2;
	}
	public int getUnitNum() {	// 마린생성시 호출, 마린수 +1
		this.medicNum ++;
		System.out.println("현재 메딕 수는: " + medicNum + "마리 입니다.");
		return this.medicNum;
	}
	public void getSound() {
		System.out.println("나는 메딕 !!!!!!!!!!!!!");
	}
	public int getMakeTime() {	
		return UnitTime.MEDIC_T;
	}
}

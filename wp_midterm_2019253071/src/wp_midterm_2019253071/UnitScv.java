package wp_midterm_2019253071;
import wp_midterm_2019253071.*;
public class UnitScv {
	private static int scvNum = 0;
	public UnitScv(){
		
	}
	public int getMineral() {	
		return UnitPrice.SCV_M;
	}

	public int getPopulationNum() {	
		return 1;
	}
	public int getUnitNum() {	// 마린생성시 호출, 마린수 +1
		this.scvNum ++;
		System.out.println("현재 SCV 수는: " + scvNum + "마리 입니다.");
		return this.scvNum;
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
}

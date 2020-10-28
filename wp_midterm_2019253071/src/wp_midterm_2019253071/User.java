package wp_midterm_2019253071;

public class User {

	private int mineral=0;	// 미네랄
	private int gas=0;		// 가스
	private int ppop;	// 현재 인구수
	private int mpop;	// 최대 인구수
	private boolean flag = false;
	public User(int mineral, int gas, int ppop, int mpop) {
		this.mineral = mineral;
		this.gas = gas;
		this.ppop = ppop;
		this.mpop = mpop;
	}
	public void gasOn() {
		flag = true;
	}
	public void gasOff() {
		flag = false;
	}
	public int getMineral() {
		return mineral;
	}
	public void setMineral(int mineral) {
		this.mineral = mineral;
	}
	public int getGas() {
		return gas;
	}
	public void setGas(int gas) {
		this.gas = gas;
	}
	public int getppop() {
		return ppop;
	}
	public void setppop(int ppop) {
		this.ppop = ppop;
	}
	public int getmpop() {
		return mpop;
	}
	public void setmpop(int mpop) {
		this.mpop = mpop;
	}

	public void addmpop(int addCount) {
		this.mpop += addCount;
		System.out.println("최대 인구수: " + this.mpop);
		System.out.println();
	}
	public void submpop(int subCount) {
		this.mpop -= subCount;
		System.out.println("최대 인구수: " + this.mpop);
		System.out.println();
	}
	public void addppop(int addCount) {
		this.ppop += addCount;
	}
	public void subppop(int subCount) {
		this.ppop -= subCount;
	}
	public void addResource(int scvUnitCount, int threadCount) {
		if(flag) {
		this.mineral += (scvUnitCount-3) * 8;
		this.gas += (3*8);
		}
		else {
			this.mineral += scvUnitCount * 8;

		}
		if(threadCount % 5 == 0) {
			System.out.println("=============== SCV Thread ===============");
			System.out.println("현재 미네랄은: " + this.getMineral() + "원 이고, 현재 가스는: " + this.getGas() + "원 입니다.");
		}
	}
	public boolean isepop(int unitCount) {
		if(this.getmpop() <= 200 && this.getppop() + unitCount <= this.getmpop()) 
			return true;
		else 
			return false;
	}
	public boolean isapop() {
		if(this.mpop <= 200) 
			return true;
			else
				return false;
	}
}

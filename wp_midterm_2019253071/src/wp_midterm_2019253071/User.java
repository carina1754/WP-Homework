package wp_midterm_2019253071;

public class User {

	private int mineral;	// �̳׶�
	private int gas;		// ����
	private int ppop;	// ���� �α���
	private int mpop;	// �ִ� �α���

	public User(int mineral, int gas, int ppop, int mpop) {
		this.mineral = mineral;
		this.gas = gas;
		this.ppop = ppop;
		this.mpop = mpop;
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
		System.out.println("�ִ� �α���: " + this.mpop);
		System.out.println();
	}
	public void addppop(int addCount) {
		this.ppop += addCount;
	}
	public void addResource(int scvUnitCount, int threadCount) {
		this.mineral += (scvUnitCount-3) * 8;
		this.gas += (3*8);
		if(threadCount % 5 == 0) {
			System.out.println("=============== SCV Thread ===============");
			System.out.println("���� �̳׶���: " + this.getMineral() + "�� �̰�, ���� ������: " + this.getGas() + "�� �Դϴ�.");
		}
	}
	
	/**
	 * ���� �α��� + �������� ������ �α����� �ִ� �α������� ������(�������� ������ ���� ��  ����)
	 * ex) ���� �α���: 16, ���� �α���: 1, �ִ� �α���: 20 ---> 16+1 < 20 (false)
	 * ���� �� ���� ���� �� ����.
	 * @return
	 */
	public boolean isepop(int unitCount) {
		if(this.mpop < 200) 
			return this.getppop() + unitCount > this.getppop();
		else 
			return false;
	}
	public boolean isapop() {
		if(this.mpop < 200) 
			return true;
			else
				return false;
	}
	/**
	 * ���� �׶��� �̳׶�, ����, �α��� ���
	 */
	public void showNowTerranInfo() {
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("���� �̳׶� \t ���� ���� \t ���� �α���");
		System.out.println(this.getMineral() + "\t" + this.getGas() + "\t" 
					+ this.getppop() + "/" + this.getmpop());
		System.out.println("--------------------------------------------------------------------------------");
	}

}

package building;

public class BuildingRefinery extends Building{

	private int RefineryNum =0;
	
	@Override
	public boolean isBuild() {
		// TODO Auto-generated method stub
		if(RefineryNum>0)
			return true;
		else
			return false;
	}

	@Override
	public int build() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("�����̳ʸ��� �����մϴ�.");
		Thread.sleep(BuildingTime.REFINERY_T*1000);
		System.out.println("�����̳ʸ��� " + BuildingPrice.REFINERY_M + "�� �ڿ� �����˴ϴ�...");
		return RefineryNum++;
	}

	@Override
	public int destory(int a) {
		// TODO Auto-generated method stub
		RefineryNum =-a;
		if(RefineryNum <= 0) {
			System.out.println("�����̳ʸ��� ������ 0���� �Դϴ�. ");
			return 0;
		}
		else
			return RefineryNum;
	}
	
}

package building;

public class BuildingBarrack extends Building{
	
	private int BarrackNum=0;
	
	@Override
	public boolean isBuild() {
		// TODO Auto-generated method stub
		if(BarrackNum>0)
			return true;
		else
			return false;
	}

	@Override
	public int build() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("�跰�� �����մϴ�.");
		Thread.sleep(BuildingTime.BARRACK_T*1000);
		System.out.println("�跰�� " + BuildingPrice.BARRACK_M + "�� �ڿ� �����˴ϴ�...");
		return BarrackNum++;
	}

	@Override
	public int destory(int a) {
		// TODO Auto-generated method stub
		BarrackNum =-a;
		if(BarrackNum <= 0) {
			System.out.println("�跰�� ������ 0���� �Դϴ�. ");
			return 0;
		}
		else
			return BarrackNum;
	}
	
}

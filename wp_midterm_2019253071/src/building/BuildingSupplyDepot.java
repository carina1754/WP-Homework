package building;

public class BuildingSupplyDepot extends Building{
	private int SupplyDepotNum=0;
	@Override
	public boolean isBuild() {
		// TODO Auto-generated method stub
		if(SupplyDepotNum>0)
			return true;
		else
			return false;
	}
	@Override
	public int build() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("���ö��� ������ �����մϴ�.");
		System.out.println("���ö��� ������ " + BuildingTime.SUPPLYDEPOT_T + "�� �ڿ� �����˴ϴ�...");
		Thread.sleep(BuildingTime.SUPPLYDEPOT_T*1000);
		System.out.println("�ִ� �α����� 10 ���� �Ǿ����ϴ�.");
		return SupplyDepotNum++;
	}

	@Override
	public int destory(int a) {
		// TODO Auto-generated method stub
		SupplyDepotNum =-a;
		if(SupplyDepotNum <= 0) {
			System.out.println("���ö��� ������ ������ 0���� �Դϴ�. ");
			return 0;
		}
		else
			return SupplyDepotNum;
	}

	
}

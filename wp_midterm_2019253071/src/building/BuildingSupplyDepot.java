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
		System.out.println("서플라이 디팟을 생성합니다.");
		System.out.println("서플라이 디팟이 " + BuildingTime.SUPPLYDEPOT_T + "초 뒤에 생성됩니다...");
		Thread.sleep(BuildingTime.SUPPLYDEPOT_T*1000);
		System.out.println("최대 인구수가 10 증가 되었습니다.");
		return SupplyDepotNum++;
	}

	@Override
	public int destory(int a) {
		// TODO Auto-generated method stub
		SupplyDepotNum =-a;
		if(SupplyDepotNum <= 0) {
			System.out.println("서플라이 디팟의 개수가 0이하 입니다. ");
			return 0;
		}
		else
			return SupplyDepotNum;
	}

	
}

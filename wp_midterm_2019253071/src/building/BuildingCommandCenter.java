package building;

public class BuildingCommandCenter extends Building{
	private int CommandCenterNum=0;
	@Override
	public boolean isBuild() {
		// TODO Auto-generated method stub
		if(CommandCenterNum>0)
			return true;
		else
			return false;
	}

	@Override
	public int build() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Ŀ�ǵ弾�͸� �����մϴ�.");
		Thread.sleep(BuildingTime.COMMANDCENTER_T*1);
		System.out.println("Ŀ�ǵ弾�Ͱ� " + BuildingPrice.COMMANDCENTER_M + "�� �ڿ� �����˴ϴ�...");
		return CommandCenterNum++;
	}

	@Override
	public int destory(int a) {
		// TODO Auto-generated method stub
		CommandCenterNum =-a;
		if(CommandCenterNum <= 0) {
			System.out.println("Ŀ�ǵ弾���� ������ 0���� �Դϴ�. ");
			return 0;
		}
		else
			return CommandCenterNum;
	}

}

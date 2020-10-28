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
		System.out.println("커맨드센터를 생성합니다.");
		Thread.sleep(BuildingTime.COMMANDCENTER_T*1);
		System.out.println("커맨드센터가 " + BuildingPrice.COMMANDCENTER_M + "초 뒤에 생성됩니다...");
		return CommandCenterNum++;
	}

	@Override
	public int destory(int a) {
		// TODO Auto-generated method stub
		CommandCenterNum =-a;
		if(CommandCenterNum <= 0) {
			System.out.println("커맨드센터의 개수가 0이하 입니다. ");
			return 0;
		}
		else
			return CommandCenterNum;
	}

}

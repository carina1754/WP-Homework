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
		System.out.println("배럭을 생성합니다.");
		Thread.sleep(BuildingTime.BARRACK_T*1000);
		System.out.println("배럭이 " + BuildingPrice.BARRACK_M + "초 뒤에 생성됩니다...");
		return BarrackNum++;
	}

	@Override
	public int destory(int a) {
		// TODO Auto-generated method stub
		BarrackNum =-a;
		if(BarrackNum <= 0) {
			System.out.println("배럭의 개수가 0이하 입니다. ");
			return 0;
		}
		else
			return BarrackNum;
	}
	
}

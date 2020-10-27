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
		System.out.println("리파이너리를 생성합니다.");
		Thread.sleep(BuildingTime.REFINERY_T*1000);
		System.out.println("리파이너리가 " + BuildingPrice.REFINERY_M + "초 뒤에 생성됩니다...");
		return RefineryNum++;
	}

	@Override
	public int destory(int a) {
		// TODO Auto-generated method stub
		RefineryNum =-a;
		if(RefineryNum <= 0) {
			System.out.println("리파이너리의 개수가 0이하 입니다. ");
			return 0;
		}
		else
			return RefineryNum;
	}
	
}

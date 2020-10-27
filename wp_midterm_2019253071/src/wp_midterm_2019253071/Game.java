package wp_midterm_2019253071;
import wp_midterm_2019253071.*;
import java.util.Scanner;

public class Game {
	public static final Scanner scan = new Scanner(System.in);
	private static final String makingSuffixStr = "초 뒤에 생성됩니다...";

	public static int MAXP = 200;
	public int MINP = 10;
	public static int mineral = 50;
	public int gas = 0;
	public static int bc=0;
	public static int cc=1;
	public static int sc=1;
	public static int rc=0;
	public static int scvma=7;
	public static int scvga=7;
	public static int scvu=0;

	static User user = new User(50,0,7,10);
	static UnitMarine marine = new UnitMarine();
	static UnitScv scv = new UnitScv();
	static UnitMedic medic = new UnitMedic();
	static UnitFirebat firebat = new UnitFirebat();
	
	public static void showInit() throws InterruptedException {
		System.out.println("┌--------------------------------------------------------------------------------┐");
		System.out.println("│                                                                                │");
		System.out.println("│                   starcraft                                                    │");               
		System.out.println("│                                     Created By An Jung Su on 2020.10.29        │");
		System.out.println("└--------------------------------------------------------------------------------┘");
		
		System.out.println("스타크래프트 게임을 시작합니다...");
		Thread.sleep(1000);
		System.out.println("당신의 종족은 테란입니다.....");
		Thread.sleep(1000);
		System.out.println("초기 미네랄은 50, 가스는 0이 주어집니다.");
		Thread.sleep(1000);
		System.out.println("초기 SCV는 7마리, 초기 인구수는 10, 최대 인구수는 200입니다.");
	}
	
	public static int setMainMenu() {
		System.out.println("메뉴을 선택해주세요 ......... ");
		System.out.println("1. 건물 건설, 2. 유닛 조회, 3. 유닛 생성, 4. 유닛 삭제, 5. 종료");
		return scan.nextInt();
	}
	
	public static int setBuildingMenu() {
		System.out.println("건물을 선택해주세요 ......... ");
		System.out.println("1. 커맨드센터, 2. 서플라이디팟, 3. 배럭, 4. 리파이너리, 5. 뒤로가기");
		return scan.nextInt();
	}
	
	public static int produceBarrackUnitMenu() throws InterruptedException {
		System.out.println();
		System.out.println("배럭을 선택하셨습니다... ");
		Thread.sleep(1);
		System.out.println("뽑고자 하는 유닛을 선택해주세요!");
		Thread.sleep(1);
		System.out.println("1. 마린, 2. 메딕, 3. 파이어벳");
		return scan.nextInt();
	}
	
	public static int produceCommandCenterUnitMenu() throws InterruptedException {
		System.out.println();
		System.out.println("커맨드 센터를 선택하셨습니다... ");
		Thread.sleep(1);
		System.out.println("뽑고자 하는 유닛을 선택해주세요!");
		Thread.sleep(1);
		System.out.println("1. SCV");
		return scan.nextInt();
	}
	
	public static int produceUnitBuildMenu() throws InterruptedException {
		System.out.println();
		System.out.println("");
		Thread.sleep(1);
		System.out.println("견물을 선택하세요.");
		Thread.sleep(1);
		System.out.println("1. 커맨드센터, 2. 배럭");
		return scan.nextInt();
	}
	
	public static void addSupplydepotPopulationCount() throws InterruptedException {
		if(user.isapop()){
			if(user.getMineral() < 100) {
				System.out.println("미네랄이 부족합니다... ");
				System.out.println("현재 미네랄: " + user.getMineral());
				System.out.println();
			}
			System.out.println("서플라이 디팟이 " + BuildingTime.SUPPLYDEPOT_T + makingSuffixStr);
			Thread.sleep(2000);
			
			System.out.println("최대 인구수가 10 증가 되었습니다.");
			user.addmpop(10);
		}
		else {
			System.out.println("인구수를 초과합니다. 설치할 수 있는 서플라이 디팟을 초과합니다.");
		}
	}

	public static void main(String args[]) throws InterruptedException {
	
	showInit();
	UnitScv.setUnitNum(7);
	int menu = setMainMenu();
	
	SourceThread sourcethread = new SourceThread(user, scv.getUnitNum());
	Thread scvThread = new Thread(sourcethread);
	scvThread.start();
	
	while(true) {
		
	if(menu == 1) {
		
		int buildmenu = setBuildingMenu();
		
		switch (buildmenu) {
		case 1:
			System.out.println("커맨드센터가 이미 건설되어 있습니다.");
			break;
		
		case 2:
			if (user.getMineral() < BuildingPrice.SUPPLYDEPOT_M) {
				System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
				break;
			}
			else if(user.isapop()) {
				System.out.println("서플라이 디팟을 생성합니다.");
				addSupplydepotPopulationCount();
				Thread.sleep(BuildingTime.SUPPLYDEPOT_T*1000);
				break;
			}
			else
				System.out.println("서플라이 디팟을 건설할 수 없습니다.");
			break;
		
		case 3:
			if(bc==1) {
				System.out.println("이미 배럭이 건설되어 있습니다. 유닛을 생성하세요.");
				break;					
			}
			else if(bc==0) {
				if(user.getMineral() < BuildingPrice.BARRACK_M) {
				System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
				break;
				}
				else {
					user.setMineral(user.getMineral() - BuildingPrice.BARRACK_M);
					System.out.println("배럭이 " + BuildingPrice.BARRACK_M + makingSuffixStr);
					Thread.sleep(BuildingTime.BARRACK_T*1000);
					bc++;
					break;
				}
			}
		case 4:
			if(mineral>=100&&rc==0) {
				System.out.println("리파이너리를 상성합니다.");
				user.setMineral(user.getMineral() - BuildingPrice.REFINERY_M);
				Thread.sleep(BuildingTime.REFINERY_T*1000);
				rc++;
				break;
				}
				if(rc == 1) {
					System.out.println("더이상 지을 곳이 없습니다.");
					break;
					}
		}
	}
	
	else if(menu == 2)
		System.out.println("현재 인구수는 : " + user.getppop() + "/" + user.getmpop() + " 입니다.");
	
	else if(menu == 3) {
		int pmenu = produceUnitBuildMenu();
		if(pmenu == 1) {
			int cmenu = produceCommandCenterUnitMenu();
			if(cmenu == 1) {
				if(user.getMineral() < 50) {
					System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
				
				} else if(user.isepop(1)) {
					addSupplydepotPopulationCount();
				
				} else {
					user.setMineral(user.getMineral() - UnitPrice.SCV_M);
					System.out.println("SCV가 " + UnitTime.SCV_T + makingSuffixStr);
					Thread.sleep(UnitTime.SCV_T*1000);

					//marine.printMarineInfo();	// 전략 패턴(???)
					user.addppop(1);
				}
				
			}
		}
		
		else if(pmenu == 2) {
		if(bc==1) {
		int bmenu = produceBarrackUnitMenu();
		if(bmenu == 1) {
			if(user.getMineral() < UnitPrice.MARINE_M) {
				System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
			
			} else if(user.isepop(1)) {
				addSupplydepotPopulationCount();
			
			} else {
				user.setMineral(user.getMineral() - UnitPrice.MARINE_M);
				System.out.println("마린이 " + UnitTime.MARINE_T + makingSuffixStr);
				Thread.sleep(UnitTime.MARINE_T*1000);

				//marine.printMarineInfo();	// 전략 패턴(???)
				user.addppop(1);
			}
			
		}
		
		else if(bmenu == 2) {
			if(user.getMineral() < UnitPrice.FIREBAT_M && user.getGas() < UnitPrice.FIREBAT_G) {
				System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
			
			} else if(user.isepop(1)) {
				addSupplydepotPopulationCount();
			
			} else {
				user.setMineral(user.getMineral() - UnitPrice.FIREBAT_M);
				user.setGas(user.getGas() - UnitPrice.FIREBAT_G);
				System.out.println("파이어뱃이 " + UnitTime.FIREBAT_T + makingSuffixStr);
				Thread.sleep(UnitTime.FIREBAT_T*1000);

				//marine.printMarineInfo();	// 전략 패턴(???)
				user.addppop(1);
			}
		}
		else if(bmenu == 3) {
			if(user.getMineral() < UnitPrice.MEDIC_M && user.getGas() < UnitPrice.MEDIC_G) {
				System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
			
			} else if(user.isepop(1)) {
				addSupplydepotPopulationCount();
			} else {
				user.setMineral(user.getMineral() - UnitPrice.MEDIC_M);
				user.setGas(user.getGas() - UnitPrice.MEDIC_G);
				System.out.println("메딕이 " + UnitTime.MEDIC_T + makingSuffixStr);
				Thread.sleep(UnitTime.MEDIC_T*1000);

				//marine.printMarineInfo();	// 전략 패턴(???)
				user.addppop(1);
				}
			}
		}
		
		else if(bc==0)
			System.out.println("배럭이 존재하지 않습니다. SCV로 건설하세요.");
		}
	}
	
	else if(menu == 4) {
		System.out.println("삭제할 유닛을 골라주세요.");
		System.out.println("1. 마린, 2. 메딕, 3. 파이어벳");
		System.out.println("삭제할 유닛의 수를 입력해 주세요");
		
	}
	
	else if(menu == 5) {
		System.out.println("게임을 종료합니다.");
		break;
	}
	
	else
		System.out.println("다시 입력해 주세요.");
	}
}
}


package wp_midterm_2019253071;
import wp_midterm_2019253071.*;
import java.util.Scanner;

import building.BuildingBarrack;
import building.BuildingCommandCenter;
import building.BuildingPrice;
import building.BuildingRefinery;
import building.BuildingSupplyDepot;
import building.BuildingTime;
import thread.SourceThread;
import unit.UnitFirebat;
import unit.UnitMarine;
import unit.UnitMedic;
import unit.UnitPrice;
import unit.UnitScv;
import unit.UnitTime;

public class Game {
	public static final Scanner scan = new Scanner(System.in);

	static User user = new User(50,0,7,10);
	
	static UnitMarine marine = new UnitMarine();
	static UnitScv scv = new UnitScv();
	static UnitMedic medic = new UnitMedic();
	static UnitFirebat firebat = new UnitFirebat();
	
	static BuildingSupplyDepot supplydepot = new BuildingSupplyDepot();
	static BuildingBarrack barrack = new BuildingBarrack();
	static BuildingCommandCenter commandcenter = new BuildingCommandCenter();
	static BuildingRefinery refinery = new BuildingRefinery();
	
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
	
	public static int removeMenu() {
		System.out.println("삭제할 것을 선택해주세요 ......... ");
		System.out.println("1. 건물, 2. 유닛, 3. 뒤로가기");
		return scan.nextInt();
	}
	
	public static int removeUnitMenu() {
		System.out.println("삭제할 유닛을 선택해주세요 ......... ");
		System.out.println("1. SCV, 2. 마린, 3. 파이어뱃, 4. 메딕, 5. 뒤로가기");
		return scan.nextInt();
	}
	
	public static int removeBuildingMenu() {
		System.out.println("삭제할 건물을 선택해주세요 ......... ");
		System.out.println("1. 커맨드센터, 2. 서플라이 디팟, 3. 배럭, 4. 리파이너리, 5. 뒤로가기");
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

	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws InterruptedException {
	
	showInit();
	UnitScv.setUnitNum(7);
	
	SourceThread sourcethread = new SourceThread(user, scv.getUnitNum());
	Thread scvThread = new Thread(sourcethread);
	scvThread.start();
	while(true) {
		
		int menu = setMainMenu();
		
	if(menu == 1) {
		
		int buildmenu = setBuildingMenu();
		
		switch (buildmenu) {
		case 1:
			if(commandcenter.isBuild()) { 
				System.out.println("이미 커맨드센터가 건설되어 있습니다. SCV를 생성하세요.");
				break;
			}
			else if (user.getMineral() < BuildingPrice.COMMANDCENTER_M) {
				System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
				break;
			}
			else if(user.isapop()) {
				user.setMineral(user.getMineral() - BuildingPrice.COMMANDCENTER_M);
				commandcenter.build();
				break;
			}
			else {
				System.out.println("커맨드센터를 건설할 수 없습니다.");
				break;
			}
			
		case 2:
			if (user.getMineral() < BuildingPrice.SUPPLYDEPOT_M) {
				System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
				break;
			}
			else if(user.isapop()&&commandcenter.isBuild()) {
				user.setMineral(user.getMineral() - BuildingPrice.SUPPLYDEPOT_M);
				supplydepot.build();
				user.addmpop(10);
				break;
			}
			else if(supplydepot.isBuild()&&user.getmpop()>=200) {
				System.out.println("인구수를 초과합니다. 설치할 수 있는 서플라이 디팟을 초과합니다.");
				break;
			}
			else {
				System.out.println("서플라이 디팟을 건설할 수 없습니다. 커맨드센터를 건설해 주세요.");
				break;
			}

		case 3:
			if(barrack.isBuild()) {
				System.out.println("이미 배럭이 건설되어 있습니다. 유닛을 생성하세요.");
				break;					
			}
			if(user.getMineral() < BuildingPrice.BARRACK_M) {
				System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
				break;
			}
			else if(!barrack.isBuild()&&commandcenter.isBuild()) {
					user.setMineral(user.getMineral() - BuildingPrice.BARRACK_M);
					barrack.build();
					break;
				}
			else {
				System.out.println("배럭을 건설할 수 없습니다. 커맨드센터를 건설해 주세요.");
				break;
			}
			
		case 4:
			if(refinery.isBuild()) {
				System.out.println("이미 리파이너리가 건설되어 있습니다. 유닛을 생성하세요.");
				break;					
			}
			else if (user.getMineral() < BuildingPrice.REFINERY_M) {
				System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
				break;
			}
			else if(!refinery.isBuild() && commandcenter.isBuild()) {
				user.setMineral(user.getMineral() - BuildingPrice.REFINERY_M);
				refinery.build();
				user.gasOn();
				break;
				}
			else {
				System.out.println("리파이너리를 건설할 수 없습니다. 커맨드센터를 건설해 주세요.");
				break;
			}
		}
	}
	
	else if(menu == 2) {
		System.out.println("현재 인구수는 : " + user.getppop() + "/" + user.getmpop() + " 입니다.");
	}
	
	else if(menu == 3) {
		int pmenu = produceUnitBuildMenu();
		if(pmenu == 1) {
			int cmenu = produceCommandCenterUnitMenu();
			if(cmenu == 1) {
				if(user.getMineral() < UnitPrice.SCV_M) {
					System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
				} 
				else if(!user.isepop(1)) {
					System.out.println("인구수가 부족합니다. 서플라이 디팟을 건설하세요.");
				} 
				else {
					user.setMineral(user.getMineral() - UnitPrice.SCV_M);
					scv.addUnitNum();
					user.addppop(1);
					sourcethread.addUnitcount();
					System.out.println("현재 인구수는 : " + user.getppop() + "/" + user.getmpop() + " 입니다.");
				} 
			}
		}
		
		else if(pmenu == 2) {
		if(barrack.isBuild()) {
		int bmenu = produceBarrackUnitMenu();
		if(bmenu == 1) {
			if(user.getMineral() < UnitPrice.MARINE_M) {
				System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
			} 
			else if(!user.isepop(1)) {
				System.out.println("인구수가 부족합니다. 서플라이 디팟을 건설하세요.");
			} 
			else {
				user.setMineral(user.getMineral() - UnitPrice.MARINE_M);
				marine.addUnitNum();
				user.addppop(1);
				System.out.println("현재 인구수는 : " + user.getppop() + "/" + user.getmpop() + " 입니다.");
			}
		}
		
		else if(bmenu == 2) {
			if(user.getMineral() < UnitPrice.FIREBAT_M && user.getGas() < UnitPrice.FIREBAT_G) {
				System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
			} 
			else if(!user.isepop(1)) {
				System.out.println("인구수가 부족합니다. 서플라이 디팟을 건설하세요.");
			} 
			else {
				user.setMineral(user.getMineral() - UnitPrice.FIREBAT_M);
				user.setGas(user.getGas() - UnitPrice.FIREBAT_G);
				firebat.addUnitNum();
				user.addppop(1);
				System.out.println("현재 인구수는 : " + user.getppop() + "/" + user.getmpop() + " 입니다.");
			}
		}

		else if(bmenu == 3) {
			if(user.getMineral() < UnitPrice.MEDIC_M && user.getGas() < UnitPrice.MEDIC_G) {
				System.out.println("SCV가 열심히 돈을 벌고있으니 기다려주세요...");
			} 
			else if(!user.isepop(1)) {
				System.out.println("인구수가 부족합니다. 서플라이 디팟을 건설하세요.");
			} 
			else {
				user.setMineral(user.getMineral() - UnitPrice.MEDIC_M);
				user.setGas(user.getGas() - UnitPrice.MEDIC_G);
				medic.addUnitNum();
				user.addppop(1);
				System.out.println("현재 인구수는 : " + user.getppop() + "/" + user.getmpop() + " 입니다.");
				}
			}
		}
		
		else
			System.out.println("배럭이 존재하지 않습니다. SCV로 건설하세요.");
		}
	}
	
	else if(menu == 4) {
		int rmenu = removeMenu();
		switch(rmenu) {
		case 1:
			int rbmenu = removeBuildingMenu();
			switch(rbmenu) {
			case 1:
				if(!commandcenter.isBuild()) {
					System.out.println("커맨드센터가 없습니다.");
					break;
				}
				else if(commandcenter.isBuild()){	
					commandcenter.destory(1);
					System.out.println("삭제가 완료되었습니다.");
					break;
				}
				else {
					System.out.println("다시 입력해 주세요.");
					break;
				}
				
			case 2:
				if(!supplydepot.isBuild()) {
					System.out.println("서플라이 디팟이 없습니다.");
					break;
				}
				else if(supplydepot.isBuild()) {
					int min = (int) Math.ceil(user.getppop()/10);
					System.out.println("서플라이 디팟을 얼마나 삭제할 것인가요? 최소로 가질 수 있는 개수 : " + min);
					while(true) {
						System.out.println("개수입력 : ");
						int des = scan.nextInt();
						if(des<min) {
							supplydepot.destory(des);
							des = 10*des;
							user.submpop(des);
							System.out.println("삭제가 완료되었습니다.");
							break;
						}
					}
				}
					else {
						System.out.println("다시 입력해 주세요.");
						break;
					}

			case 3:
				if(!barrack.isBuild()) {
					System.out.println("배럭이 없습니다.");
					break;
				}
				else if(barrack.isBuild()) {
				barrack.destory(1);
				System.out.println("삭제가 완료되었습니다.");
				break;
				}
				else {
					System.out.println("다시 입력해 주세요.");
					break;
				}
			}
			case 4:
			if(!refinery.isBuild()) {
				System.out.println("리파이너리가 없습니다.");
				break;
			}
			else if(refinery.isBuild()){	
				refinery.destory(1);
				System.out.println("삭제가 완료되었습니다.");
				user.gasOff();
				break;
			}
			else {
				System.out.println("다시 입력해 주세요.");
				break;
			}
		case 2:
			int rumenu = removeUnitMenu();
			switch(rumenu) {
			case 1:
				scv.killUnit();
				user.subppop(1);
				sourcethread.subUnitcount();
				System.out.println("삭제가 완료되었습니다.");
				break;
			case 2:
				marine.killUnit();
				user.subppop(1);
				System.out.println("삭제가 완료되었습니다.");
				break;
			case 3:
				firebat.killUnit();
				user.subppop(1);
				System.out.println("삭제가 완료되었습니다.");
				break;
			case 4:
				medic.killUnit();
				user.subppop(1);
				System.out.println("삭제가 완료되었습니다.");
				break;
			}
		}
	}
	
	else if(menu == 5) {
		System.out.println("게임을 종료합니다.");
		break;
	}
	
	else
		System.out.println("다시 입력해 주세요.");
	}
	System.exit(0);
}
}


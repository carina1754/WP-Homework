package wp_midterm_2019253071;
import wp_midterm_2019253071.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import building.BuildingBarrack;
import building.BuildingCommandCenter;
import building.BuildingPrice;
import building.BuildingRefinery;
import building.BuildingSupplyDepot;
import building.BuildingTime;
import javazoom.jl.decoder.JavaLayerException;
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
	
	static String mineral = "/music/미네랄.wav";
	static String gas = "/music/가스.wav";
	static String cbuild = "/music/건물완료.wav";
	static String dbuild = "/music/건물파괴.wav";
	static String supply = "/music/서플 디팟.wav";
	static String nbuild = "/music/TSCErr00.wav";
	static String start = "/music/start.wav";
	public static void showInit() throws InterruptedException {
		System.out.println("┌--------------------------------------------------------------------------------┐");
		System.out.println("│                                                                                │");
		System.out.println("│                                    STARCRAFT                                   │");               
		System.out.println("│                                        Made By An Jung Su on 2020.10.28        │");
		System.out.println("└--------------------------------------------------------------------------------┘");

		System.out.println("초기 미네랄은 50, 가스는 0이 주어집니다.");
		Thread.sleep(1000);
		System.out.println("초기 SCV는 7마리, 초기 인구수는 10, 최대 인구수는 200입니다.");
	}
	
	public static void Sound(String input) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		 AudioInputStream barracksoundpack = AudioSystem.getAudioInputStream(UnitFirebat.class.getResourceAsStream(input));
		 Clip barracksound = AudioSystem.getClip();
          barracksound.stop();
          barracksound.open(barracksoundpack);
          barracksound.start();
	}

	public static int setMainMenu() {
		System.out.println();
		System.out.println("메뉴을 선택해주세요.");
		System.out.println("1. 건물 건설, 2. 유닛 조회, 3. 유닛 생성, 4. 유닛 삭제, 5. 종료");
		return scan.nextInt();
	}
	
	public static int setBuildingMenu() {
		System.out.println();
		System.out.println("건물을 선택해주세요.");
		System.out.println("1. 커맨드센터, 2. 서플라이디팟, 3. 배럭, 4. 리파이너리, 5. 뒤로가기");
		return scan.nextInt();
	}
	
	public static int removeMenu() {
		System.out.println();
		System.out.println("삭제할 것을 선택해주세요.");
		System.out.println("1. 건물, 2. 유닛, 3. 뒤로가기");
		return scan.nextInt();
	}
	
	public static int removeUnitMenu() {
		System.out.println();
		System.out.println("삭제할 유닛을 선택해주세요.");
		System.out.println("1. SCV, 2. 마린, 3. 파이어뱃, 4. 메딕, 5. 뒤로가기");
		return scan.nextInt();
	}
	
	public static int removeBuildingMenu() {
		System.out.println();
		System.out.println("삭제할 건물을 선택해주세요.");
		System.out.println("1. 커맨드센터, 2. 서플라이 디팟, 3. 배럭, 4. 리파이너리, 5. 뒤로가기");
		return scan.nextInt();
	}
	
	public static int produceBarrackUnitMenu() throws InterruptedException {
		System.out.println();
		System.out.println("배럭을 선택하셨습니다.");
		System.out.println("뽑고자 하는 유닛을 선택해주세요!");
		System.out.println("1. 마린, 2. 메딕, 3. 파이어벳");
		return scan.nextInt();
	}
	
	public static int produceCommandCenterUnitMenu() throws InterruptedException {
		System.out.println();
		System.out.println("커맨드 센터를 선택하셨습니다.");
		System.out.println("뽑고자 하는 유닛을 선택해주세요!");
		System.out.println("1. SCV");
		return scan.nextInt();
	}
	
	public static int produceUnitBuildMenu() throws InterruptedException {
		System.out.println();
		System.out.println("견물을 선택하세요.");
		System.out.println("1. 커맨드센터, 2. 배럭");
		return scan.nextInt();
	}

	public static void main(String args[]) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
	
	showInit();
	UnitScv.setUnitNum(7);
	
	SourceThread sourcethread = new SourceThread(user, scv.getUnitNum());
	Thread scvThread = new Thread(sourcethread);
	scvThread.start();
	Sound(start);
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
				System.out.println("자원이 부족합니다.");
				Sound(mineral);
				break;
			}
			else if(user.isapop()) {
				user.setMineral(user.getMineral() - BuildingPrice.COMMANDCENTER_M);
				commandcenter.build();
				Sound(cbuild);
				break;
			}
			else {
				System.out.println("커맨드센터를 건설할 수 없습니다.");
				Sound(nbuild);
				break;
			}
			
		case 2:
			if (user.getMineral() < BuildingPrice.SUPPLYDEPOT_M) {
				System.out.println("자원이 부족합니다.");
				Sound(mineral);
				break;
			}
			else if(user.isapop()&&commandcenter.isBuild()) {
				user.setMineral(user.getMineral() - BuildingPrice.SUPPLYDEPOT_M);
				supplydepot.build();
				user.addmpop(10);
				Sound(cbuild);
				break;
			}
			else if(supplydepot.isBuild()&&user.getmpop()>=200) {
				System.out.println("인구수를 초과합니다. 설치할 수 있는 서플라이 디팟을 초과합니다.");
				Sound(nbuild);
				break;
			}
			else {
				System.out.println("서플라이 디팟을 건설할 수 없습니다. 커맨드센터를 건설해 주세요.");
				Sound(nbuild);
				break;
			}

		case 3:
			if(barrack.isBuild()) {
				System.out.println("이미 배럭이 건설되어 있습니다. 유닛을 생성하세요.");
				Sound(nbuild);
				break;					
			}
			if(user.getMineral() < BuildingPrice.BARRACK_M) {
				System.out.println("자원이 부족합니다.");
				Sound(mineral);
				break;
			}
			else if(!barrack.isBuild()&&commandcenter.isBuild()) {
					user.setMineral(user.getMineral() - BuildingPrice.BARRACK_M);
					barrack.build();
					Sound(cbuild);
					break;
				}
			else {
				System.out.println("배럭을 건설할 수 없습니다. 커맨드센터를 건설해 주세요.");
				Sound(nbuild);
				break;
			}
			
		case 4:
			if(refinery.isBuild()) {
				System.out.println("이미 리파이너리가 건설되어 있습니다. 유닛을 생성하세요.");
				Sound(nbuild);
				break;					
			}
			else if (user.getMineral() < BuildingPrice.REFINERY_M) {
				System.out.println("자원이 부족합니다.");
				Sound(mineral);
				break;
			}
			else if(!refinery.isBuild() && commandcenter.isBuild()) {
				user.setMineral(user.getMineral() - BuildingPrice.REFINERY_M);
				refinery.build();
				Sound(cbuild);
				user.gasOn();
				break;
				}
			else {
				System.out.println("리파이너리를 건설할 수 없습니다. 커맨드센터를 건설해 주세요.");
				Sound(nbuild);
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
					System.out.println("자원이 부족합니다.");
					Sound(mineral);
				} 
				else if(!user.isepop(1)) {
					System.out.println("인구수가 부족합니다. 서플라이 디팟을 건설하세요.");
					Sound(supply);
				} 
				else {
					user.setMineral(user.getMineral() - UnitPrice.SCV_M);
					scv.addUnitNum();
					user.addppop(1);
					scv.getSound();
					scv.printUnitInfo();
					sourcethread.addUnitcount();
					scv.printUnitPopulation(user.getppop(), user.getmpop());
				} 
			}
		}
		
		else if(pmenu == 2) {
		if(barrack.isBuild()) {
		int bmenu = produceBarrackUnitMenu();
		if(bmenu == 1) {
			if(user.getMineral() < UnitPrice.MARINE_M) {
				System.out.println("자원이 부족합니다.");
				Sound(mineral);
			} 
			else if(!user.isepop(1)) {
				System.out.println("인구수가 부족합니다. 서플라이 디팟을 건설하세요.");
				Sound(supply);
			} 
			else {
				user.setMineral(user.getMineral() - UnitPrice.MARINE_M);
				marine.addUnitNum();
				user.addppop(1);
				marine.getSound();
				marine.printUnitInfo();
				marine.printUnitPopulation(user.getppop(), user.getmpop());
			}
		}
		
		else if(bmenu == 2) {
			if(user.getMineral() < UnitPrice.FIREBAT_M) {
				System.out.println("자원이 부족합니다.");
				Sound(mineral);
			}
			else if(user.getGas() < UnitPrice.FIREBAT_G) {
				System.out.println("자원이 부족합니다.");
				Sound(gas);
			}
			else {
			if(!user.isepop(1)) {
				System.out.println("인구수가 부족합니다. 서플라이 디팟을 건설하세요.");
				Sound(supply);
			} 
			else {
				user.setMineral(user.getMineral() - UnitPrice.FIREBAT_M);
				user.setGas(user.getGas() - UnitPrice.FIREBAT_G);
				firebat.addUnitNum();
				user.addppop(1);
				firebat.getSound();
				firebat.printUnitInfo();
				firebat.printUnitPopulation(user.getppop(), user.getmpop());
			}
			}
		}

		else if(bmenu == 3) {
			if(user.getMineral() < UnitPrice.MEDIC_M) {
				System.out.println("자원이 부족합니다.");
				Sound(mineral);
			} 
			else if(user.getGas() < UnitPrice.MEDIC_G) {
				System.out.println("자원이 부족합니다.");
				Sound(gas);
			}
			else {
			if(!user.isepop(1)) {
				System.out.println("인구수가 부족합니다. 서플라이 디팟을 건설하세요.");
				Sound(supply);
			} 
			else {
				user.setMineral(user.getMineral() - UnitPrice.MEDIC_M);
				user.setGas(user.getGas() - UnitPrice.MEDIC_G);
				medic.addUnitNum();
				user.addppop(1);
				medic.getSound();
				medic.printUnitInfo();
				medic.printUnitPopulation(user.getppop(), user.getmpop());
			}
			}
			}
		}
		else
			System.out.println("배럭이 존재하지 않습니다. SCV로 건설하세요.");
		}
	}
	else if(menu == 4) {
		int rmenu = removeMenu();
		if(rmenu==1) {
			int rbmenu = removeBuildingMenu();
			switch(rbmenu) {
			case 1:
				if(!commandcenter.isBuild()) {
					System.out.println("커맨드센터가 없습니다.");
				}
				else if(commandcenter.isBuild()){	
					commandcenter.destory(1);
					Sound(dbuild);
					System.out.println("커맨드센터의 삭제가 완료되었습니다.");
				}
				
			case 2:
				if(!supplydepot.isBuild()) {
					System.out.println("서플라이 디팟이 없습니다."); 
					Sound(supply);
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
							Sound(dbuild);
							System.out.println("서플라이 디팟의 삭제가 완료되었습니다.");
							break;
						}
						else {
							System.out.println("현재 인구수 만큼의 서플라이를 유지해야 합니다.");
							break;
						}
					}
				}
			case 3:
				if(!barrack.isBuild()) {
					System.out.println("배럭이 없습니다.");
					break;
				}
				else if(barrack.isBuild()) {
				barrack.destory(1);
				System.out.println("배럭의 삭제가 완료되었습니다.");
				break;
				}
			case 4:
				if(!refinery.isBuild()) {
				System.out.println("리파이너리가 없습니다.");
				break;
				}
				else if(refinery.isBuild()){	
				refinery.destory(1);
				Sound(dbuild);
				System.out.println("리파이너리의 삭제가 완료되었습니다.");
				user.gasOff();
				break;
				}
			default:
				System.out.println("잘못입력하였습니다.");
				break;
			}
		}
		else if (rmenu==2) {
			int rumenu = removeUnitMenu();
			
			switch(rumenu) {
			case 1:
				if(scv.getUnitNum()>0) {
				scv.killUnit();
				user.subppop(1);
				sourcethread.subUnitcount();
				scv.getdSound();
				System.out.println("SCV의 삭제가 완료되었습니다.");
				scv.printUnitPopulation(user.getppop(), user.getmpop());
				break;
				}				
				else {
					System.out.println("SCV가 없습니다.");
					break;
				}
			case 2:
				if(marine.getUnitNum()>0) {
				marine.killUnit();
				user.subppop(1);
				marine.getdSound();
				System.out.println("마린의 삭제가 완료되었습니다.");
				marine.printUnitPopulation(user.getppop(), user.getmpop());
				break;
				}			
				else {
					System.out.println("마린이 없습니다.");
					break;
				}
			case 3:
				if(firebat.getUnitNum()>0) {
				firebat.killUnit();
				user.subppop(1);
				firebat.getdSound();
				System.out.println("파이어뱃의 삭제가 완료되었습니다.");
				firebat.printUnitPopulation(user.getppop(), user.getmpop());
				break;
				}				
				else {
					System.out.println("파이어뱃이 없습니다.");
					break;
				}
			case 4:
				if(medic.getUnitNum()>0) {
				medic.killUnit();
				user.subppop(1);
				System.out.println("메딕의 삭제가 완료되었습니다.");
				medic.getdSound();
				medic.printUnitPopulation(user.getppop(), user.getmpop());
				break;
				}
				else {
					System.out.println("메딕이 없습니다.");
					break;
				}
			default:
				System.out.println("잘못입력하였습니다.");
				break;
			}
		}
		
		else
			System.out.println("잘못입력하였습니다.");
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


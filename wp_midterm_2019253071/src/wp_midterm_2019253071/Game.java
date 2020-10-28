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
	
	static String mineral = "/music/�̳׶�.wav";
	static String gas = "/music/����.wav";
	static String cbuild = "/music/�ǹ��Ϸ�.wav";
	static String dbuild = "/music/�ǹ��ı�.wav";
	static String supply = "/music/���� ����.wav";
	static String nbuild = "/music/TSCErr00.wav";
	static String start = "/music/start.wav";
	public static void showInit() throws InterruptedException {
		System.out.println("��--------------------------------------------------------------------------------��");
		System.out.println("��                                                                                ��");
		System.out.println("��                                    STARCRAFT                                   ��");               
		System.out.println("��                                        Made By An Jung Su on 2020.10.28        ��");
		System.out.println("��--------------------------------------------------------------------------------��");

		System.out.println("�ʱ� �̳׶��� 50, ������ 0�� �־����ϴ�.");
		Thread.sleep(1000);
		System.out.println("�ʱ� SCV�� 7����, �ʱ� �α����� 10, �ִ� �α����� 200�Դϴ�.");
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
		System.out.println("�޴��� �������ּ���.");
		System.out.println("1. �ǹ� �Ǽ�, 2. ���� ��ȸ, 3. ���� ����, 4. ���� ����, 5. ����");
		return scan.nextInt();
	}
	
	public static int setBuildingMenu() {
		System.out.println();
		System.out.println("�ǹ��� �������ּ���.");
		System.out.println("1. Ŀ�ǵ弾��, 2. ���ö��̵���, 3. �跰, 4. �����̳ʸ�, 5. �ڷΰ���");
		return scan.nextInt();
	}
	
	public static int removeMenu() {
		System.out.println();
		System.out.println("������ ���� �������ּ���.");
		System.out.println("1. �ǹ�, 2. ����, 3. �ڷΰ���");
		return scan.nextInt();
	}
	
	public static int removeUnitMenu() {
		System.out.println();
		System.out.println("������ ������ �������ּ���.");
		System.out.println("1. SCV, 2. ����, 3. ���̾��, 4. �޵�, 5. �ڷΰ���");
		return scan.nextInt();
	}
	
	public static int removeBuildingMenu() {
		System.out.println();
		System.out.println("������ �ǹ��� �������ּ���.");
		System.out.println("1. Ŀ�ǵ弾��, 2. ���ö��� ����, 3. �跰, 4. �����̳ʸ�, 5. �ڷΰ���");
		return scan.nextInt();
	}
	
	public static int produceBarrackUnitMenu() throws InterruptedException {
		System.out.println();
		System.out.println("�跰�� �����ϼ̽��ϴ�.");
		System.out.println("�̰��� �ϴ� ������ �������ּ���!");
		System.out.println("1. ����, 2. �޵�, 3. ���̾");
		return scan.nextInt();
	}
	
	public static int produceCommandCenterUnitMenu() throws InterruptedException {
		System.out.println();
		System.out.println("Ŀ�ǵ� ���͸� �����ϼ̽��ϴ�.");
		System.out.println("�̰��� �ϴ� ������ �������ּ���!");
		System.out.println("1. SCV");
		return scan.nextInt();
	}
	
	public static int produceUnitBuildMenu() throws InterruptedException {
		System.out.println();
		System.out.println("�߹��� �����ϼ���.");
		System.out.println("1. Ŀ�ǵ弾��, 2. �跰");
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
				System.out.println("�̹� Ŀ�ǵ弾�Ͱ� �Ǽ��Ǿ� �ֽ��ϴ�. SCV�� �����ϼ���.");
				break;
			}
			else if (user.getMineral() < BuildingPrice.COMMANDCENTER_M) {
				System.out.println("�ڿ��� �����մϴ�.");
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
				System.out.println("Ŀ�ǵ弾�͸� �Ǽ��� �� �����ϴ�.");
				Sound(nbuild);
				break;
			}
			
		case 2:
			if (user.getMineral() < BuildingPrice.SUPPLYDEPOT_M) {
				System.out.println("�ڿ��� �����մϴ�.");
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
				System.out.println("�α����� �ʰ��մϴ�. ��ġ�� �� �ִ� ���ö��� ������ �ʰ��մϴ�.");
				Sound(nbuild);
				break;
			}
			else {
				System.out.println("���ö��� ������ �Ǽ��� �� �����ϴ�. Ŀ�ǵ弾�͸� �Ǽ��� �ּ���.");
				Sound(nbuild);
				break;
			}

		case 3:
			if(barrack.isBuild()) {
				System.out.println("�̹� �跰�� �Ǽ��Ǿ� �ֽ��ϴ�. ������ �����ϼ���.");
				Sound(nbuild);
				break;					
			}
			if(user.getMineral() < BuildingPrice.BARRACK_M) {
				System.out.println("�ڿ��� �����մϴ�.");
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
				System.out.println("�跰�� �Ǽ��� �� �����ϴ�. Ŀ�ǵ弾�͸� �Ǽ��� �ּ���.");
				Sound(nbuild);
				break;
			}
			
		case 4:
			if(refinery.isBuild()) {
				System.out.println("�̹� �����̳ʸ��� �Ǽ��Ǿ� �ֽ��ϴ�. ������ �����ϼ���.");
				Sound(nbuild);
				break;					
			}
			else if (user.getMineral() < BuildingPrice.REFINERY_M) {
				System.out.println("�ڿ��� �����մϴ�.");
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
				System.out.println("�����̳ʸ��� �Ǽ��� �� �����ϴ�. Ŀ�ǵ弾�͸� �Ǽ��� �ּ���.");
				Sound(nbuild);
				break;
			}
		}
	}
	
	else if(menu == 2) {
		System.out.println("���� �α����� : " + user.getppop() + "/" + user.getmpop() + " �Դϴ�.");
	}
	
	else if(menu == 3) {

		int pmenu = produceUnitBuildMenu();
		if(pmenu == 1) {
			int cmenu = produceCommandCenterUnitMenu();
			if(cmenu == 1) {
				if(user.getMineral() < UnitPrice.SCV_M) {
					System.out.println("�ڿ��� �����մϴ�.");
					Sound(mineral);
				} 
				else if(!user.isepop(1)) {
					System.out.println("�α����� �����մϴ�. ���ö��� ������ �Ǽ��ϼ���.");
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
				System.out.println("�ڿ��� �����մϴ�.");
				Sound(mineral);
			} 
			else if(!user.isepop(1)) {
				System.out.println("�α����� �����մϴ�. ���ö��� ������ �Ǽ��ϼ���.");
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
				System.out.println("�ڿ��� �����մϴ�.");
				Sound(mineral);
			}
			else if(user.getGas() < UnitPrice.FIREBAT_G) {
				System.out.println("�ڿ��� �����մϴ�.");
				Sound(gas);
			}
			else {
			if(!user.isepop(1)) {
				System.out.println("�α����� �����մϴ�. ���ö��� ������ �Ǽ��ϼ���.");
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
				System.out.println("�ڿ��� �����մϴ�.");
				Sound(mineral);
			} 
			else if(user.getGas() < UnitPrice.MEDIC_G) {
				System.out.println("�ڿ��� �����մϴ�.");
				Sound(gas);
			}
			else {
			if(!user.isepop(1)) {
				System.out.println("�α����� �����մϴ�. ���ö��� ������ �Ǽ��ϼ���.");
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
			System.out.println("�跰�� �������� �ʽ��ϴ�. SCV�� �Ǽ��ϼ���.");
		}
	}
	else if(menu == 4) {
		int rmenu = removeMenu();
		if(rmenu==1) {
			int rbmenu = removeBuildingMenu();
			switch(rbmenu) {
			case 1:
				if(!commandcenter.isBuild()) {
					System.out.println("Ŀ�ǵ弾�Ͱ� �����ϴ�.");
				}
				else if(commandcenter.isBuild()){	
					commandcenter.destory(1);
					Sound(dbuild);
					System.out.println("Ŀ�ǵ弾���� ������ �Ϸ�Ǿ����ϴ�.");
				}
				
			case 2:
				if(!supplydepot.isBuild()) {
					System.out.println("���ö��� ������ �����ϴ�."); 
					Sound(supply);
				}
				else if(supplydepot.isBuild()) {
					int min = (int) Math.ceil(user.getppop()/10);
					System.out.println("���ö��� ������ �󸶳� ������ ���ΰ���? �ּҷ� ���� �� �ִ� ���� : " + min);
					while(true) {
						System.out.println("�����Է� : ");
						int des = scan.nextInt();
						if(des<min) {
							supplydepot.destory(des);
							des = 10*des;
							user.submpop(des);
							Sound(dbuild);
							System.out.println("���ö��� ������ ������ �Ϸ�Ǿ����ϴ�.");
							break;
						}
						else {
							System.out.println("���� �α��� ��ŭ�� ���ö��̸� �����ؾ� �մϴ�.");
							break;
						}
					}
				}
			case 3:
				if(!barrack.isBuild()) {
					System.out.println("�跰�� �����ϴ�.");
					break;
				}
				else if(barrack.isBuild()) {
				barrack.destory(1);
				System.out.println("�跰�� ������ �Ϸ�Ǿ����ϴ�.");
				break;
				}
			case 4:
				if(!refinery.isBuild()) {
				System.out.println("�����̳ʸ��� �����ϴ�.");
				break;
				}
				else if(refinery.isBuild()){	
				refinery.destory(1);
				Sound(dbuild);
				System.out.println("�����̳ʸ��� ������ �Ϸ�Ǿ����ϴ�.");
				user.gasOff();
				break;
				}
			default:
				System.out.println("�߸��Է��Ͽ����ϴ�.");
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
				System.out.println("SCV�� ������ �Ϸ�Ǿ����ϴ�.");
				scv.printUnitPopulation(user.getppop(), user.getmpop());
				break;
				}				
				else {
					System.out.println("SCV�� �����ϴ�.");
					break;
				}
			case 2:
				if(marine.getUnitNum()>0) {
				marine.killUnit();
				user.subppop(1);
				marine.getdSound();
				System.out.println("������ ������ �Ϸ�Ǿ����ϴ�.");
				marine.printUnitPopulation(user.getppop(), user.getmpop());
				break;
				}			
				else {
					System.out.println("������ �����ϴ�.");
					break;
				}
			case 3:
				if(firebat.getUnitNum()>0) {
				firebat.killUnit();
				user.subppop(1);
				firebat.getdSound();
				System.out.println("���̾���� ������ �Ϸ�Ǿ����ϴ�.");
				firebat.printUnitPopulation(user.getppop(), user.getmpop());
				break;
				}				
				else {
					System.out.println("���̾���� �����ϴ�.");
					break;
				}
			case 4:
				if(medic.getUnitNum()>0) {
				medic.killUnit();
				user.subppop(1);
				System.out.println("�޵��� ������ �Ϸ�Ǿ����ϴ�.");
				medic.getdSound();
				medic.printUnitPopulation(user.getppop(), user.getmpop());
				break;
				}
				else {
					System.out.println("�޵��� �����ϴ�.");
					break;
				}
			default:
				System.out.println("�߸��Է��Ͽ����ϴ�.");
				break;
			}
		}
		
		else
			System.out.println("�߸��Է��Ͽ����ϴ�.");
	}
	
	else if(menu == 5) {
		System.out.println("������ �����մϴ�.");
		break;
	}
	
	else
		System.out.println("�ٽ� �Է��� �ּ���.");
	}
	
	System.exit(0);
}
}


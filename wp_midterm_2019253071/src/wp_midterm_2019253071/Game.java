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
		System.out.println("��--------------------------------------------------------------------------------��");
		System.out.println("��                                                                                ��");
		System.out.println("��                   starcraft                                                    ��");               
		System.out.println("��                                     Created By An Jung Su on 2020.10.29        ��");
		System.out.println("��--------------------------------------------------------------------------------��");
		
		System.out.println("��Ÿũ����Ʈ ������ �����մϴ�...");
		Thread.sleep(1000);
		System.out.println("����� ������ �׶��Դϴ�.....");
		Thread.sleep(1000);
		System.out.println("�ʱ� �̳׶��� 50, ������ 0�� �־����ϴ�.");
		Thread.sleep(1000);
		System.out.println("�ʱ� SCV�� 7����, �ʱ� �α����� 10, �ִ� �α����� 200�Դϴ�.");
	}
	
	public static int setMainMenu() {
		System.out.println("�޴��� �������ּ��� ......... ");
		System.out.println("1. �ǹ� �Ǽ�, 2. ���� ��ȸ, 3. ���� ����, 4. ���� ����, 5. ����");
		return scan.nextInt();
	}
	
	public static int setBuildingMenu() {
		System.out.println("�ǹ��� �������ּ��� ......... ");
		System.out.println("1. Ŀ�ǵ弾��, 2. ���ö��̵���, 3. �跰, 4. �����̳ʸ�, 5. �ڷΰ���");
		return scan.nextInt();
	}
	
	public static int removeMenu() {
		System.out.println("������ ���� �������ּ��� ......... ");
		System.out.println("1. �ǹ�, 2. ����, 3. �ڷΰ���");
		return scan.nextInt();
	}
	
	public static int removeUnitMenu() {
		System.out.println("������ ������ �������ּ��� ......... ");
		System.out.println("1. SCV, 2. ����, 3. ���̾��, 4. �޵�, 5. �ڷΰ���");
		return scan.nextInt();
	}
	
	public static int removeBuildingMenu() {
		System.out.println("������ �ǹ��� �������ּ��� ......... ");
		System.out.println("1. Ŀ�ǵ弾��, 2. ���ö��� ����, 3. �跰, 4. �����̳ʸ�, 5. �ڷΰ���");
		return scan.nextInt();
	}
	
	public static int produceBarrackUnitMenu() throws InterruptedException {
		System.out.println();
		System.out.println("�跰�� �����ϼ̽��ϴ�... ");
		Thread.sleep(1);
		System.out.println("�̰��� �ϴ� ������ �������ּ���!");
		Thread.sleep(1);
		System.out.println("1. ����, 2. �޵�, 3. ���̾");
		return scan.nextInt();
	}
	
	public static int produceCommandCenterUnitMenu() throws InterruptedException {
		System.out.println();
		System.out.println("Ŀ�ǵ� ���͸� �����ϼ̽��ϴ�... ");
		Thread.sleep(1);
		System.out.println("�̰��� �ϴ� ������ �������ּ���!");
		Thread.sleep(1);
		System.out.println("1. SCV");
		return scan.nextInt();
	}
	
	public static int produceUnitBuildMenu() throws InterruptedException {
		System.out.println();
		System.out.println("");
		Thread.sleep(1);
		System.out.println("�߹��� �����ϼ���.");
		Thread.sleep(1);
		System.out.println("1. Ŀ�ǵ弾��, 2. �跰");
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
				System.out.println("�̹� Ŀ�ǵ弾�Ͱ� �Ǽ��Ǿ� �ֽ��ϴ�. SCV�� �����ϼ���.");
				break;
			}
			else if (user.getMineral() < BuildingPrice.COMMANDCENTER_M) {
				System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
				break;
			}
			else if(user.isapop()) {
				user.setMineral(user.getMineral() - BuildingPrice.COMMANDCENTER_M);
				commandcenter.build();
				break;
			}
			else {
				System.out.println("Ŀ�ǵ弾�͸� �Ǽ��� �� �����ϴ�.");
				break;
			}
			
		case 2:
			if (user.getMineral() < BuildingPrice.SUPPLYDEPOT_M) {
				System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
				break;
			}
			else if(user.isapop()&&commandcenter.isBuild()) {
				user.setMineral(user.getMineral() - BuildingPrice.SUPPLYDEPOT_M);
				supplydepot.build();
				user.addmpop(10);
				break;
			}
			else if(supplydepot.isBuild()&&user.getmpop()>=200) {
				System.out.println("�α����� �ʰ��մϴ�. ��ġ�� �� �ִ� ���ö��� ������ �ʰ��մϴ�.");
				break;
			}
			else {
				System.out.println("���ö��� ������ �Ǽ��� �� �����ϴ�. Ŀ�ǵ弾�͸� �Ǽ��� �ּ���.");
				break;
			}

		case 3:
			if(barrack.isBuild()) {
				System.out.println("�̹� �跰�� �Ǽ��Ǿ� �ֽ��ϴ�. ������ �����ϼ���.");
				break;					
			}
			if(user.getMineral() < BuildingPrice.BARRACK_M) {
				System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
				break;
			}
			else if(!barrack.isBuild()&&commandcenter.isBuild()) {
					user.setMineral(user.getMineral() - BuildingPrice.BARRACK_M);
					barrack.build();
					break;
				}
			else {
				System.out.println("�跰�� �Ǽ��� �� �����ϴ�. Ŀ�ǵ弾�͸� �Ǽ��� �ּ���.");
				break;
			}
			
		case 4:
			if(refinery.isBuild()) {
				System.out.println("�̹� �����̳ʸ��� �Ǽ��Ǿ� �ֽ��ϴ�. ������ �����ϼ���.");
				break;					
			}
			else if (user.getMineral() < BuildingPrice.REFINERY_M) {
				System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
				break;
			}
			else if(!refinery.isBuild() && commandcenter.isBuild()) {
				user.setMineral(user.getMineral() - BuildingPrice.REFINERY_M);
				refinery.build();
				user.gasOn();
				break;
				}
			else {
				System.out.println("�����̳ʸ��� �Ǽ��� �� �����ϴ�. Ŀ�ǵ弾�͸� �Ǽ��� �ּ���.");
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
					System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
				} 
				else if(!user.isepop(1)) {
					System.out.println("�α����� �����մϴ�. ���ö��� ������ �Ǽ��ϼ���.");
				} 
				else {
					user.setMineral(user.getMineral() - UnitPrice.SCV_M);
					scv.addUnitNum();
					user.addppop(1);
					sourcethread.addUnitcount();
					System.out.println("���� �α����� : " + user.getppop() + "/" + user.getmpop() + " �Դϴ�.");
				} 
			}
		}
		
		else if(pmenu == 2) {
		if(barrack.isBuild()) {
		int bmenu = produceBarrackUnitMenu();
		if(bmenu == 1) {
			if(user.getMineral() < UnitPrice.MARINE_M) {
				System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
			} 
			else if(!user.isepop(1)) {
				System.out.println("�α����� �����մϴ�. ���ö��� ������ �Ǽ��ϼ���.");
			} 
			else {
				user.setMineral(user.getMineral() - UnitPrice.MARINE_M);
				marine.addUnitNum();
				user.addppop(1);
				System.out.println("���� �α����� : " + user.getppop() + "/" + user.getmpop() + " �Դϴ�.");
			}
		}
		
		else if(bmenu == 2) {
			if(user.getMineral() < UnitPrice.FIREBAT_M && user.getGas() < UnitPrice.FIREBAT_G) {
				System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
			} 
			else if(!user.isepop(1)) {
				System.out.println("�α����� �����մϴ�. ���ö��� ������ �Ǽ��ϼ���.");
			} 
			else {
				user.setMineral(user.getMineral() - UnitPrice.FIREBAT_M);
				user.setGas(user.getGas() - UnitPrice.FIREBAT_G);
				firebat.addUnitNum();
				user.addppop(1);
				System.out.println("���� �α����� : " + user.getppop() + "/" + user.getmpop() + " �Դϴ�.");
			}
		}

		else if(bmenu == 3) {
			if(user.getMineral() < UnitPrice.MEDIC_M && user.getGas() < UnitPrice.MEDIC_G) {
				System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
			} 
			else if(!user.isepop(1)) {
				System.out.println("�α����� �����մϴ�. ���ö��� ������ �Ǽ��ϼ���.");
			} 
			else {
				user.setMineral(user.getMineral() - UnitPrice.MEDIC_M);
				user.setGas(user.getGas() - UnitPrice.MEDIC_G);
				medic.addUnitNum();
				user.addppop(1);
				System.out.println("���� �α����� : " + user.getppop() + "/" + user.getmpop() + " �Դϴ�.");
				}
			}
		}
		
		else
			System.out.println("�跰�� �������� �ʽ��ϴ�. SCV�� �Ǽ��ϼ���.");
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
					System.out.println("Ŀ�ǵ弾�Ͱ� �����ϴ�.");
					break;
				}
				else if(commandcenter.isBuild()){	
					commandcenter.destory(1);
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					break;
				}
				else {
					System.out.println("�ٽ� �Է��� �ּ���.");
					break;
				}
				
			case 2:
				if(!supplydepot.isBuild()) {
					System.out.println("���ö��� ������ �����ϴ�.");
					break;
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
							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
							break;
						}
					}
				}
					else {
						System.out.println("�ٽ� �Է��� �ּ���.");
						break;
					}

			case 3:
				if(!barrack.isBuild()) {
					System.out.println("�跰�� �����ϴ�.");
					break;
				}
				else if(barrack.isBuild()) {
				barrack.destory(1);
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				break;
				}
				else {
					System.out.println("�ٽ� �Է��� �ּ���.");
					break;
				}
			}
			case 4:
			if(!refinery.isBuild()) {
				System.out.println("�����̳ʸ��� �����ϴ�.");
				break;
			}
			else if(refinery.isBuild()){	
				refinery.destory(1);
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				user.gasOff();
				break;
			}
			else {
				System.out.println("�ٽ� �Է��� �ּ���.");
				break;
			}
		case 2:
			int rumenu = removeUnitMenu();
			switch(rumenu) {
			case 1:
				scv.killUnit();
				user.subppop(1);
				sourcethread.subUnitcount();
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				break;
			case 2:
				marine.killUnit();
				user.subppop(1);
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				break;
			case 3:
				firebat.killUnit();
				user.subppop(1);
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				break;
			case 4:
				medic.killUnit();
				user.subppop(1);
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				break;
			}
		}
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


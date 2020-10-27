package wp_midterm_2019253071;
import wp_midterm_2019253071.*;
import java.util.Scanner;

public class Game {
	public static final Scanner scan = new Scanner(System.in);
	private static final String makingSuffixStr = "�� �ڿ� �����˴ϴ�...";

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
	
	public static void addSupplydepotPopulationCount() throws InterruptedException {
		if(user.isapop()){
			if(user.getMineral() < 100) {
				System.out.println("�̳׶��� �����մϴ�... ");
				System.out.println("���� �̳׶�: " + user.getMineral());
				System.out.println();
			}
			System.out.println("���ö��� ������ " + BuildingTime.SUPPLYDEPOT_T + makingSuffixStr);
			Thread.sleep(2000);
			
			System.out.println("�ִ� �α����� 10 ���� �Ǿ����ϴ�.");
			user.addmpop(10);
		}
		else {
			System.out.println("�α����� �ʰ��մϴ�. ��ġ�� �� �ִ� ���ö��� ������ �ʰ��մϴ�.");
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
			System.out.println("Ŀ�ǵ弾�Ͱ� �̹� �Ǽ��Ǿ� �ֽ��ϴ�.");
			break;
		
		case 2:
			if (user.getMineral() < BuildingPrice.SUPPLYDEPOT_M) {
				System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
				break;
			}
			else if(user.isapop()) {
				System.out.println("���ö��� ������ �����մϴ�.");
				addSupplydepotPopulationCount();
				Thread.sleep(BuildingTime.SUPPLYDEPOT_T*1000);
				break;
			}
			else
				System.out.println("���ö��� ������ �Ǽ��� �� �����ϴ�.");
			break;
		
		case 3:
			if(bc==1) {
				System.out.println("�̹� �跰�� �Ǽ��Ǿ� �ֽ��ϴ�. ������ �����ϼ���.");
				break;					
			}
			else if(bc==0) {
				if(user.getMineral() < BuildingPrice.BARRACK_M) {
				System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
				break;
				}
				else {
					user.setMineral(user.getMineral() - BuildingPrice.BARRACK_M);
					System.out.println("�跰�� " + BuildingPrice.BARRACK_M + makingSuffixStr);
					Thread.sleep(BuildingTime.BARRACK_T*1000);
					bc++;
					break;
				}
			}
		case 4:
			if(mineral>=100&&rc==0) {
				System.out.println("�����̳ʸ��� ���մϴ�.");
				user.setMineral(user.getMineral() - BuildingPrice.REFINERY_M);
				Thread.sleep(BuildingTime.REFINERY_T*1000);
				rc++;
				break;
				}
				if(rc == 1) {
					System.out.println("���̻� ���� ���� �����ϴ�.");
					break;
					}
		}
	}
	
	else if(menu == 2)
		System.out.println("���� �α����� : " + user.getppop() + "/" + user.getmpop() + " �Դϴ�.");
	
	else if(menu == 3) {
		int pmenu = produceUnitBuildMenu();
		if(pmenu == 1) {
			int cmenu = produceCommandCenterUnitMenu();
			if(cmenu == 1) {
				if(user.getMineral() < 50) {
					System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
				
				} else if(user.isepop(1)) {
					addSupplydepotPopulationCount();
				
				} else {
					user.setMineral(user.getMineral() - UnitPrice.SCV_M);
					System.out.println("SCV�� " + UnitTime.SCV_T + makingSuffixStr);
					Thread.sleep(UnitTime.SCV_T*1000);

					//marine.printMarineInfo();	// ���� ����(???)
					user.addppop(1);
				}
				
			}
		}
		
		else if(pmenu == 2) {
		if(bc==1) {
		int bmenu = produceBarrackUnitMenu();
		if(bmenu == 1) {
			if(user.getMineral() < UnitPrice.MARINE_M) {
				System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
			
			} else if(user.isepop(1)) {
				addSupplydepotPopulationCount();
			
			} else {
				user.setMineral(user.getMineral() - UnitPrice.MARINE_M);
				System.out.println("������ " + UnitTime.MARINE_T + makingSuffixStr);
				Thread.sleep(UnitTime.MARINE_T*1000);

				//marine.printMarineInfo();	// ���� ����(???)
				user.addppop(1);
			}
			
		}
		
		else if(bmenu == 2) {
			if(user.getMineral() < UnitPrice.FIREBAT_M && user.getGas() < UnitPrice.FIREBAT_G) {
				System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
			
			} else if(user.isepop(1)) {
				addSupplydepotPopulationCount();
			
			} else {
				user.setMineral(user.getMineral() - UnitPrice.FIREBAT_M);
				user.setGas(user.getGas() - UnitPrice.FIREBAT_G);
				System.out.println("���̾���� " + UnitTime.FIREBAT_T + makingSuffixStr);
				Thread.sleep(UnitTime.FIREBAT_T*1000);

				//marine.printMarineInfo();	// ���� ����(???)
				user.addppop(1);
			}
		}
		else if(bmenu == 3) {
			if(user.getMineral() < UnitPrice.MEDIC_M && user.getGas() < UnitPrice.MEDIC_G) {
				System.out.println("SCV�� ������ ���� ���������� ��ٷ��ּ���...");
			
			} else if(user.isepop(1)) {
				addSupplydepotPopulationCount();
			} else {
				user.setMineral(user.getMineral() - UnitPrice.MEDIC_M);
				user.setGas(user.getGas() - UnitPrice.MEDIC_G);
				System.out.println("�޵��� " + UnitTime.MEDIC_T + makingSuffixStr);
				Thread.sleep(UnitTime.MEDIC_T*1000);

				//marine.printMarineInfo();	// ���� ����(???)
				user.addppop(1);
				}
			}
		}
		
		else if(bc==0)
			System.out.println("�跰�� �������� �ʽ��ϴ�. SCV�� �Ǽ��ϼ���.");
		}
	}
	
	else if(menu == 4) {
		System.out.println("������ ������ ����ּ���.");
		System.out.println("1. ����, 2. �޵�, 3. ���̾");
		System.out.println("������ ������ ���� �Է��� �ּ���");
		
	}
	
	else if(menu == 5) {
		System.out.println("������ �����մϴ�.");
		break;
	}
	
	else
		System.out.println("�ٽ� �Է��� �ּ���.");
	}
}
}


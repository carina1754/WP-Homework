package unit;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class UnitMarine extends Unit{
	
	private int marineNum=0;

	public int getMineral() {	
		return UnitPrice.MARINE_M;
	}
	public int addUnitNum() throws InterruptedException {	// ���������� ȣ��, ������ +1
		System.out.println("������ " + UnitTime.MARINE_T + "�� �ڿ� �����˴ϴ�.");
		Thread.sleep(UnitTime.MARINE_T*1000);
		this.marineNum ++;
		return this.marineNum;
	}
	public int getUnitNum(){
		return marineNum;
	}
	public void getSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		 AudioInputStream marrinesoundpack = AudioSystem.getAudioInputStream(UnitFirebat.class.getResourceAsStream("/music/TMaWht00.wav"));
		 Clip marinesound = AudioSystem.getClip();
           marinesound.stop();
           marinesound.open(marrinesoundpack);
           marinesound.start();
		System.out.println("������ �����Ǿ����ϴ�.");
	}
	public void getdSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		 AudioInputStream marrinesoundpack = AudioSystem.getAudioInputStream(UnitFirebat.class.getResourceAsStream("/music/TMaDth00.wav"));
		 Clip marinesound = AudioSystem.getClip();
          marinesound.stop();
          marinesound.open(marrinesoundpack);
          marinesound.start();
	}
	public int getMakeTime() {	
		return UnitTime.MARINE_T; 
	}
	
	@Override
	public void killUnit() {
		// TODO Auto-generated method stub
		this.marineNum --;
	}
	@Override
	public void printUnitInfo() {
		// TODO Auto-generated method stub
		System.out.println("����� : 40");
		System.out.println("���ݷ� : 6");
		System.out.println("���� : 0");
		System.out.println("���� ��� : ����, ����");
		System.out.println("���� �ӵ� : 15");
		System.out.println("��Ÿ� : 4");
		System.out.println("�̵��ӵ� : 1.875");
		System.out.println("�þ� : 7");
	}
	@Override
	public void printUnitPopulation(int ppop, int mpop) {
		// TODO Auto-generated method stub
		System.out.println("���� �α����� : " + ppop + "/" + mpop+ " �Դϴ�.");
	}
}

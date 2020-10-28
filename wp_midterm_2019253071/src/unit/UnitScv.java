package unit;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class UnitScv extends Unit{

	private static int scvNum = 0;

	public int getMineral() {	
		return UnitPrice.SCV_M;
	}
	
	public int addUnitNum() throws InterruptedException {
		System.out.println("SCV�� " + UnitTime.SCV_T + "�� �ڿ� �����˴ϴ�.");
		Thread.sleep(UnitTime.SCV_T*1000);
		scvNum ++;
		return scvNum;
	}
	public int getUnitNum(){
		return scvNum;
	}
	public void getSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		 AudioInputStream scvsoundpack = AudioSystem.getAudioInputStream(UnitFirebat.class.getResourceAsStream("/music/TSCWht00.wav"));
		 Clip scvsound = AudioSystem.getClip();
           scvsound.stop();
           scvsound.open(scvsoundpack);
           scvsound.start();
		System.out.println("SCV�� �����Ǿ����ϴ�.");
	}
	public void getdSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		 AudioInputStream scvsoundpack = AudioSystem.getAudioInputStream(UnitFirebat.class.getResourceAsStream("/music/TSCDth00.wav"));
		 Clip scvsound = AudioSystem.getClip();
          scvsound.stop();
          scvsound.open(scvsoundpack);
          scvsound.start();
		System.out.println("SCV�� �����Ǿ����ϴ�.");
	}
	public int getMakeTime() {	
		return UnitTime.SCV_T;
	}
	public static void setUnitNum(int i) {
		scvNum =+ i;
	}
	@Override
	public void killUnit() {
		// TODO Auto-generated method stub
		scvNum--;
	}
	@Override
	public void printUnitInfo() {
		// TODO Auto-generated method stub
		System.out.println("����� : 60");
		System.out.println("���ݷ� : 5");
		System.out.println("���� : 0");
		System.out.println("���� ��� : ����");
		System.out.println("���� �ӵ� : 7");
		System.out.println("��Ÿ� : 1");
		System.out.println("�̵��ӵ� : 1.875");
		System.out.println("�þ� : 7");
	}
	@Override
	public void printUnitPopulation(int ppop, int mpop) {
		// TODO Auto-generated method stub
		System.out.println("���� �α����� : " + ppop + "/" + mpop+ " �Դϴ�.");
	}
}

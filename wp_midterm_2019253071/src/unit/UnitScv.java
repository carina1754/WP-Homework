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
		System.out.println("SCV가 " + UnitTime.SCV_T + "초 뒤에 생성됩니다.");
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
		System.out.println("SCV가 생성되었습니다.");
	}
	public void getdSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		 AudioInputStream scvsoundpack = AudioSystem.getAudioInputStream(UnitFirebat.class.getResourceAsStream("/music/TSCDth00.wav"));
		 Clip scvsound = AudioSystem.getClip();
          scvsound.stop();
          scvsound.open(scvsoundpack);
          scvsound.start();
		System.out.println("SCV가 생성되었습니다.");
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
		System.out.println("생명력 : 60");
		System.out.println("공격력 : 5");
		System.out.println("방어력 : 0");
		System.out.println("공격 대상 : 지상");
		System.out.println("공걱 속도 : 7");
		System.out.println("사거리 : 1");
		System.out.println("이동속도 : 1.875");
		System.out.println("시야 : 7");
	}
	@Override
	public void printUnitPopulation(int ppop, int mpop) {
		// TODO Auto-generated method stub
		System.out.println("현재 인구수는 : " + ppop + "/" + mpop+ " 입니다.");
	}
}

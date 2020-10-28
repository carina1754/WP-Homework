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
	public int addUnitNum() throws InterruptedException {	// 마린생성시 호출, 마린수 +1
		System.out.println("마린이 " + UnitTime.MARINE_T + "초 뒤에 생성됩니다.");
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
		System.out.println("마린이 생성되었습니다.");
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
		System.out.println("생명력 : 40");
		System.out.println("공격력 : 6");
		System.out.println("방어력 : 0");
		System.out.println("공격 대상 : 지상, 공중");
		System.out.println("공걱 속도 : 15");
		System.out.println("사거리 : 4");
		System.out.println("이동속도 : 1.875");
		System.out.println("시야 : 7");
	}
	@Override
	public void printUnitPopulation(int ppop, int mpop) {
		// TODO Auto-generated method stub
		System.out.println("현재 인구수는 : " + ppop + "/" + mpop+ " 입니다.");
	}
}

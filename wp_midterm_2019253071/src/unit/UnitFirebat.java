package unit;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class UnitFirebat extends Unit{
	
	private int firebatNum=0;

	public int getMineral() {	
		return UnitPrice.FIREBAT_M;
	}

	public int getGas() {	
		return UnitPrice.FIREBAT_G;
	}
	public int getUnitNum(){
		return firebatNum;
	}
	public int addUnitNum() throws InterruptedException {	// 마린생성시 호출, 마린수 +1
		System.out.println("파이어뱃이 " + UnitTime.FIREBAT_T +"초 뒤에 생성됩니다.");
		Thread.sleep(UnitTime.FIREBAT_T*1000);
		this.firebatNum ++;
		return this.firebatNum;
	}
	public void getSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
			 AudioInputStream firebatsoundpack = AudioSystem.getAudioInputStream(UnitFirebat.class.getResourceAsStream("/music/tfbWht00.wav"));
			 Clip firebatsound = AudioSystem.getClip();
	            firebatsound.stop();
	            firebatsound.open(firebatsoundpack);
	            firebatsound.start();
		System.out.println("파이어뱃이 생성되었습니다.");
	}
	public void getdSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		 AudioInputStream firebatsoundpack = AudioSystem.getAudioInputStream(UnitFirebat.class.getResourceAsStream("/music/TFbDth00.wav"));
		 Clip firebatsound = AudioSystem.getClip();
           firebatsound.stop();
           firebatsound.open(firebatsoundpack);
           firebatsound.start();
	}	
	public int getMakeTime() {	
		return UnitTime.FIREBAT_T;
	}

	@Override
	public void killUnit() {
		// TODO Auto-generated method stub
		this.firebatNum --;
	}

	@Override
	public void printUnitInfo() {
		// TODO Auto-generated method stub
		System.out.println("생명력 : 50");
		System.out.println("공격력 : 8*2");
		System.out.println("방어력 : 1");
		System.out.println("공격 대상 : 지상");
		System.out.println("공걱 속도 : 22");
		System.out.println("사거리 : 1.5");
		System.out.println("이동속도 : 1.875");
		System.out.println("시야 : 7");
	}

	@Override
	public void printUnitPopulation(int ppop, int mpop) {
		// TODO Auto-generated method stub
		System.out.println("현재 인구수는 : " + ppop + "/" + mpop+ " 입니다.");
	}
}

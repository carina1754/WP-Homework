package unit;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class UnitMedic extends Unit{

	private int medicNum=0;

	public int getMineral() {	
		return UnitPrice.MEDIC_M;
	}
	public int getGas() {	
		return UnitPrice.MEDIC_G;
	}
	public int getUnitNum(){
		return medicNum;
	}
	public int addUnitNum() throws InterruptedException {	// 마린생성시 호출, 마린수 +1
		System.out.println("메딕이 " + UnitTime.MEDIC_T +"초 뒤에 생성됩니다.");
		Thread.sleep(UnitTime.MEDIC_T*1000);
		medicNum++;
		return medicNum;
	}
	public void getSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		 AudioInputStream medicsoundpack = AudioSystem.getAudioInputStream(UnitFirebat.class.getResourceAsStream("/music/TMdWht00.wav"));
		 Clip medicsound = AudioSystem.getClip();
           medicsound.stop();
           medicsound.open(medicsoundpack);
           medicsound.start();
		System.out.println("메딕이 생성되었습니다.");
	}
	public void getdSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		 AudioInputStream medicsoundpack = AudioSystem.getAudioInputStream(UnitFirebat.class.getResourceAsStream("/music/TMdDth00.wav"));
		 Clip medicsound = AudioSystem.getClip();
          medicsound.stop();
          medicsound.open(medicsoundpack);
          medicsound.start();
	}
	public int getMakeTime() {	
		return UnitTime.MEDIC_T;
	}
	
	@Override
	public void killUnit() {
		// TODO Auto-generated method stub
		medicNum --;
	}
	@Override
	public void printUnitInfo() {
		// TODO Auto-generated method stub
		System.out.println("생명력 : 60");
		System.out.println("공격력 : 0");
		System.out.println("방어력 : 1");
		System.out.println("초기 에너지 : 50");
		System.out.println("최대 에너지 : 200");
		System.out.println("이동속도 : 1.875");
		System.out.println("시야 : 9");
	}
	@Override
	public void printUnitPopulation(int ppop, int mpop) {
		// TODO Auto-generated method stub
		System.out.println("현재 인구수는 : " + ppop + "/" + mpop+ " 입니다.");
	}
}

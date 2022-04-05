package test.unit.reflection;

public class Youtube implements Player {
	
	@Override
	public void play() {
		System.out.println("유튜브가 동영상을 실행한다.");
	}
}

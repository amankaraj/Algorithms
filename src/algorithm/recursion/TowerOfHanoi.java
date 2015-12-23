package algorithm.recursion;

public class TowerOfHanoi {
	
	public static void towerHanoi(char start, char end, char using, int count){
		if(count == 0) return;
		towerHanoi(start, using, end, count-1);
		System.out.println(start + " to " + end);
		towerHanoi(using, end, start, count-1);
		
	}

	public static void main(String[] args) {
		towerHanoi('A', 'C', 'B', 3);
	}

}

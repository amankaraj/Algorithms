package algorithm.backtrack;

public class NQueens {
	
	private static boolean queenCheck(int data[],int index){
		for(int i = 0; i < index; i++){
			if(data[index] == data[i])
				return false;
			
			if(data[index] + index == data[i] - i ||
					data[index] - index == data[i] - i)
				return false;
				
		}
		return true;
	}
	public static boolean nqueenUtil(int index, int data[]){
		if(index == data.length)
			return true;
		
		for(int i = 0; i < data.length; i++){
			data[index] = i;
			if(queenCheck(data, index) && nqueenUtil(index+1, data)){
				return true;
			}
		}
		return false;
	}

	public static void nqueen(int n){
		int[] data = new int[n];
		nqueenUtil(0, data );
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + "  ");
		}
	}
	public static void main(String[] args) {
		nqueen(20);

	}

}

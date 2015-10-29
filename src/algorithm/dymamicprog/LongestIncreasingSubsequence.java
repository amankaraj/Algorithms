package algorithm.dymamicprog;

public class LongestIncreasingSubsequence {
	
	public static int[] LIS(int[] input){
		
		int[] count = new int[input.length];
		int[] seq = new int[input.length];
		int maxIndex = 0;
		
		for(int i = 0; i < input.length; i++){
			count[i] = 1;
			seq[i] = i;
		}
		
		for(int i = 1; i < input.length; i++){
			for (int j = 0; j < i; j++){
				if(count[i] <= count[j] && input[i] > input[j]){
					count[i] = 1 + count[j];
					seq[i] = j;
					if(count[maxIndex] < count[i])
						maxIndex = i;
				}
			}
		}
		
		int[] sequence = new int[count[maxIndex]];
		int index = count[maxIndex]-1;
		while(true){
			sequence[index--] = input[maxIndex];
			if (seq[maxIndex] == maxIndex)
				break;
			maxIndex = seq[maxIndex];
		}
		
		for(int i = 0; i < sequence.length; i++){
			System.out.print(sequence[i] + " ");
		}
		System.out.println();
		return sequence;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
	    LIS(arr);

	}

}

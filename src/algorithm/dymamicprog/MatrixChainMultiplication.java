package algorithm.dymamicprog;


public class MatrixChainMultiplication {
	
	public static int matrixMultiplyMin(int array[]){
		
		int matrixLength = array.length - 1;
		int valueMatrix[][] = new int[matrixLength+1][matrixLength+1];
		
		for(int i = 1; i <= matrixLength; i++) 
			valueMatrix[i][i] = 0;
		
		for(int len = 2; len <= matrixLength; len++){
		
			for(int i = 1; i <= matrixLength-len + 1; i++){
				int j = i + len - 1;
				
				valueMatrix[i][j] = Integer.MAX_VALUE;
				for(int k = i; k < j; k++){
					int val = valueMatrix[i][k] + valueMatrix[k+1][j] + array[i-1]*array[k]*array[j];
					if(valueMatrix[i][j] > val)
						valueMatrix[i][j] = val;
				}
			}
		}
		
		return valueMatrix[1][matrixLength];
	}

	public static void main(String[] args) {
		int array[] = {5,4,6,2};
		System.out.println(matrixMultiplyMin(array));

	}

}

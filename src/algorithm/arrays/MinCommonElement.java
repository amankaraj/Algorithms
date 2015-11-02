package algorithm.arrays;

import java.util.HashSet;

public class MinCommonElement {
	
	public static int minCommonElement(int[] A, int[] B){
		
		 if(A.length > B.length){
				int temp[] = A;
				A = B;
				B = temp;
			}
			HashSet<Integer> set = new HashSet<>();
			for(int i = 0; i < A.length;i++){
				set.add(A[i]);
			}
			
			int minVal = Integer.MAX_VALUE;
			for(int i = 0; i < B.length;i++){
				if(B[i] < minVal && set.contains(B[i])){
					minVal = B[i];
				}
			}
			
			return (minVal == Integer.MAX_VALUE) ? -1 : minVal;
	}

	public static void main(String[] args) {
		int arr[] = {4,2,7,4};
		int arrr[] = {1,4,2};
		
		System.out.println(minCommonElement(arr, arrr)); 

	}

}

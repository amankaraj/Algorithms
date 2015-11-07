package algorithm.dymamicprog;

public class FIbonacci {
	static int dp[] = new int[100];
	public static int fibonacciMemoization(int n){
		if(n == 0) return 0;
		if(n == 1 || n == 2) return 1;
		
		if(dp[n] == 0){
			dp[n] = fibonacciMemoization(n-1) + fibonacciMemoization(n-2);
		}
		return dp[n];
	}
	
	public static int fibonacciBottomUp(int n){
		if(n == 0) return 0;
		if(n == 1 || n == 2) return 1;
		
		int prev = 1;
		int curr = 1;
		for(int i = 3; i <= n; i++){
			curr = prev + curr;
			prev = curr - prev;
		}
		
		return curr;
	}
	public static void main(String[] args) {
		System.out.println(fibonacciBottomUp(10));
		System.out.println(fibonacciMemoization(10));
	}

}

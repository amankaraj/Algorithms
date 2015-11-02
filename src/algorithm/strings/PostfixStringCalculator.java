package algorithm.strings;

import java.util.Stack;

public class PostfixStringCalculator {
	
	public static int oper(int a, int b, char operation){
		if(operation == '+') return a + b;
		return a * b;
	}
	public static int solution(String S) {
		
		try {
			if(S == null) return 0;
			Stack<Integer> solStack = new Stack<>();
			int index = 0;
			while(index < S.length()){
				if(S.charAt(index) == '+' || S.charAt(index) == '*'){
					int result = oper(solStack.pop(), solStack.pop(), S.charAt(index));
					solStack.push(result);
				}else{
					solStack.push(S.charAt(index)-48);
				}
				index++;
			}
			
			return solStack.pop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return -1;
		}
    }
	
	public static void main(String[] args) {
	System.out.println(solution("13+62*7+*"));
	}

}

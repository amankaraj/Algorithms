package algorithm.general;

import java.util.Stack;

public class SortStack {

	//The idea is to keep the final stack in sorted order. Always.
	//Assume that we have already filled AuxStack with desired data.
	public static Stack<Integer> sortStack(Stack<Integer> stack){
		
		Stack<Integer> auxStack = new Stack<>();
		while(!stack.isEmpty()){
			auxStack.push(stack.pop());
		}
		while(!auxStack.isEmpty()){
			Integer top = auxStack.pop();
			while(!stack.isEmpty() && top < stack.peek()){
				auxStack.push(stack.pop());
			}
			//At this point only elements smaller than top would be present in stack.
			stack.push(top);
			while(!auxStack.isEmpty() && stack.peek() < auxStack.peek()){
				stack.push(auxStack.pop());
			}
		}
		return stack;
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(4);
		stack.push(1);
		stack.push(5);
		stack.push(7);
		stack.push(2);

		stack = sortStack(stack);
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

}

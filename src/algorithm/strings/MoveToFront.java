package algorithm.strings;

/*
 * Functions to perform the Move to Front encoding and decoding.
 * moveToFrontEncode and moveToFrontDecode.
 */
public class MoveToFront {
	
	/*
	 * LinkList to store the symbol key.
	 * Since every time we bring the characters to front, LinkList is the best storage option.
	 */
	static class LinkListNode{
		char val;
		LinkListNode next;
		
		
		public LinkListNode(char val) {
			super();
			this.val = val;
		}


		@Override
		public String toString() {
			return "LinkListNode [val=" + val + ", next=" + next + "]";
		}
		
		
	}
	
	static class Result{
		LinkListNode symKey;
		int count;
		
		public Result(LinkListNode symKey, int count) {
			super();
			this.symKey = symKey;
			this.count = count;
		}
		
		
	}
	
	private static LinkListNode createSymKey(){
		char c = 'a';
		LinkListNode symKey = new LinkListNode(c);
		LinkListNode head = symKey;
		
		while(c++ < 'z'){
			LinkListNode current = new LinkListNode(c);
			symKey.next = current;
			symKey = current;
		}
		
		return head;
	}
	private static Result findIndOrganizeSymbol(char c, LinkListNode symbolKey){
		
		if(symbolKey == null) return new Result(symbolKey, -1);
		
		LinkListNode head = symbolKey;
		int count = 1;
		
		if(symbolKey.val == c) return new Result(symbolKey, 0);
		while(symbolKey.next != null && symbolKey.next.val != c){
			symbolKey = symbolKey.next; 
			count++;
		}
		
		if(symbolKey.next == null) return new Result(symbolKey, -1);
		//If code reaches here, it means that symbolKey.next.val == c
		LinkListNode val = symbolKey.next;
		symbolKey.next = symbolKey.next.next;
		symbolKey = val;
		symbolKey.next = head;
		
		return new Result(symbolKey, count);
	}
	
	private static LinkListNode reorderSymKey(int key, LinkListNode symbolKey){
		
		if(symbolKey == null) return symbolKey;
		
		LinkListNode head = symbolKey;
		
		if(key == 0) return symbolKey;
		
		while(symbolKey.next != null && key > 1){
			key--;
			symbolKey = symbolKey.next; 
		}
		
		if(symbolKey.next == null) return null;
		LinkListNode val = symbolKey.next;
		symbolKey.next = symbolKey.next.next;
		symbolKey = val;
		symbolKey.next = head;
		
		return symbolKey;
	}
	
	public static int[] moveToFrontEncode(String input, LinkListNode symbolKey){
		if(input  == null || input.equals("")) return new int[0];
		
		int encodeArray[] = new int[input.length()];
		for(int i = 0; i < input.length(); i++){
			Result result = findIndOrganizeSymbol(input.charAt(i), symbolKey);
			encodeArray[i] = result.count;
			symbolKey = result.symKey;
		}
		
		return encodeArray;
	}
	
	public static  String moveToFrontDecode(int[] input, LinkListNode symbolKey){
		if(input  == null || input.length == 0) return "";
		
		StringBuilder resultString = new StringBuilder();
		for(int i = 0; i < input.length; i++){
			symbolKey = reorderSymKey(input[i], symbolKey);
			resultString.append(symbolKey.val);
		}
		
		return resultString.toString();
	}

	public static void main(String[] args) {
		System.out.println(moveToFrontDecode(moveToFrontEncode("broood", createSymKey()), createSymKey()));
	}

}

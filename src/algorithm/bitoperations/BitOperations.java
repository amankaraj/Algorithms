package algorithm.bitoperations;

public class BitOperations {
	
	/**To check if two integers have opposite sign, 
	 * we can just compute XOR operation.
	 * Note that a XOR operation would make any same bit 0
	 * and different bit 1.
	 */
	public boolean haveOppositeSign(int A, int B){
		return ((A^B) < 0);//True if a and b have opposite sign.
	}
	
	
	/**Performing an AND operation of a number with its predecessor,
	 * Would turn the rightmost One into Zero.
	 * 
	 * If a number is a power of two, there will be only one set bit.
	 * @param A
	 * @return
	 */
	public boolean isPowerTwo(int A){
		return ((A&(A-1)) == 0) ? true : false;
	}
	
	/**Brian Kernighan's way
	 * 
	 * Performing an AND operation of a number with its predecessor,
	 * Would turn the rightmost One into Zero.
	 * So after every iteration we are removing the rightmost 1.
	 * Increment the counter each time.
	 * Return when 0.
	 * @param A
	 * @return
	 */
	public static int countSetBits(int A){
		int count = 0;
		while(A != 0){
			A  &= (A-1);
			count++;
		}
		return count;
	}
	
	/**The below code would swap the values in A and B 
	 * without use of extra variables.
	 * The code work as follow:
	 *  After operation1: A would contain the XOR of A and B.
	 *  After operation2: B would contain the XOR of (A^B)^B = A.
	 *  After operation3: A would contain the XOR of (A^B) and new B(which is A)
	 *  so (A^B)^A = B.
	 * @param A
	 * @param B
	 */
	public static void swapValues(Integer A, Integer B){
		A = A ^ B;
		B = A ^ B;
		A = A ^ B;
	}

	//Swapping sequence of bits.
	
	/**Define a new variable = 0;
	 * 1. Take out the rightmost bit from original.
	 * 2. Add this bit to new.
	 * 3. Leftshift new/ rightshift original.
	 * 4. Repeat upto the point where A is zero.
	 * 5. Leftshift all remaining bits.
	 * @param A
	 * @return
	 */
	public static int reverseBitsNaive(int A){
		int revA = Integer.MAX_VALUE;
		int count = 32;
		while(A != 0){
			revA = (revA << 1) | (A & 1);
			A = A >> 1;
			count--;
		}
		return revA<<count;
	}
	
	/**Compute modulo(a%b)  by any power of 2 without a division operator.
	 * The trick is to set all the bits apart from the the bit for 
	 * power less than 2 as 0. The remaining bits would be the result of mod operation.
	 * @param A
	 * @param divisor
	 * @return
	 */
	public static int computeModuloDivisionPowerofTwo(int A, int power){
		return (A & ((1 << power) - 1));
	}
	
	
	public static void main(String args[]){
		System.out.println(computeModuloDivisionPowerofTwo(13, 3));
	}
}

package Easy;

public class PalindromeNumber {

	public static boolean isPalindromeMyCode(int x){
		//My code
		
		long result = 0;
		int temp = x;
		while(temp != 0){
			result = result*10 + (temp%10);
			if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
				return false;
			temp = temp/10;
		}
		
		return ((int)result == x );
	}
	
	public static void main(String[] args) {
		int x = -2147447412;
		System.out.println(isPalindromeMyCode(x));
	}
}

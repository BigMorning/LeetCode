package Easy;

public class PalindromeNumber {

	public static boolean isPalindromeMyCode(int x){
		//My code
		
		long result = 0;
		int temp = x;
		while(temp != 0){
			result = result*10 + (temp%10);
			temp = temp/10;
		}
		
		return ((int)result == x );
	}
	
	public static boolean isPalindrome(int x){
		if(x < 0)
			return false;
		int d = 1;
		while(x/d >= 10)
			d = d*10;
		while(x > 0){
			int u = x/d;
			int v = x % 10;
			if(u != v)
				return false;
			x = x%d/10;
			d = d/100;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int x = 12321;
		System.out.println(isPalindrome(x));
	}
}

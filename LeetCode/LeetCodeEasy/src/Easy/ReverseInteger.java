package Easy;


public class ReverseInteger {

	public static int reverseInteger(int x){
	
		int temp = x;
		long result = 0;
		while(temp != 0){
			result = result*10 + (temp%10);
			if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
				return 0;
			temp = temp/10;
		}
		return (int)result;


	}
	
	public static void main(String[] args) {
		int len = reverseInteger(1534236469);
		System.out.println(len);
	}
}

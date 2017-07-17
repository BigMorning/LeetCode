package Easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
	public static int romanToInt(String s){
		int curr = 0;
		int prev = 0;
		int num = 0;
		for(int i=0; i<s.length(); i++){
			switch(s.charAt(i)){
				case 'M':
					curr = 1000;
					break;
				case 'D':
					curr = 500;
					break;
				case 'C':
					curr = 100;
					break;
				case 'L':
					curr = 50;
					break;
				case 'X':
					curr = 10;
					break;
				case 'V':
					curr = 5;
					break;
				case 'I':
					curr = 1;
					break;
			}
			if(prev < curr){
				num = num + (curr - prev*2);
			}
			else{
				num = num + curr;
			}
			prev = curr;
		}

		return num;

			
	}
	
	public static int romanToIntHashMap(String s){
		if(s == null || s.length() == 0)
			return -1;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int len = s.length();
		int result = map.get(s.charAt(len-1));
		for(int i = len-2; i>=0; i--){
			if(map.get(s.charAt(i)) >= map.get(s.charAt(i+1)))
				result = result + map.get(s.charAt(i));
			else
				result = result - map.get(s.charAt(i));
		}
		return result;
	}
	public static void main(String[] args) {
		String s = "MCMXCVI";
		System.out.println(romanToInt(s));
	}
}

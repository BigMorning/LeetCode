package Easy;

public class LongestCommonPrefix {

	public static String longestCommonPrefixMyCode(String[] s){
        if(s.length == 0)
            return null;
		//System.out.println(commenPrefix);
		for(int i=0; i<=s[0].length(); i++){
			for(int j=1; j<s.length; j++){
					if(s[j].length() < i)
						return s[j].substring(0, i-1);
					else{
						if(!s[j].substring(0, i).equals(s[0].substring(0, i))){
							return s[0].substring(0, i-1);
					}	
				}
			}
			
		}
		return s[0];
	}
	
	public static String LongestCommonPrefixHorizontalSacnning(String[] strs){
		/*
		 * Horizontal scanning
		 * LCP(S_1,..., S_N) = LCP(LCP(LCP(S_1, S_2), S_3),..., S_N)
		 * Time Complexity: O(S), S is sum of all characters in all strings;
		 * Space Complexity: O(1)
		 */
		
		if(strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i<strs.length; i++){
			while(strs[i].indexOf(prefix) !=0){
				prefix = prefix.substring(0, prefix.length() - 1);
				if(prefix.isEmpty())
					return "";
			}
		}
		return prefix;
	}
	
	public static String LongestCommonPrefixVerticalScanning(String[] strs){
		/*
		 * Vertical scanning
		 * Time complexity: O(S), S is the sum of all characters in all strings
		 */
		if(strs == null || strs.length == 0)
			return "";
		for(int i=0; i<strs[0].length(); i++){
			char c = strs[0].charAt(i);
			for(int j=1; j<strs.length; j++){
				if(i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
	
	public static String LongestCommonPrefixDivideAndConquer(String[] strs){
		/*
		 * Divide and conquer
		 * LCP(S_1,...,S_N) = LCP(LCP(S_1, S_K), LCP(S_K+1, S_N))
		 * 
		 */
		if(strs == null || strs.length == 0)
			return "";
		return longestCommonPrefix(strs, 0, strs.length - 1);
		
	}
	public static String longestCommonPrefix(String[] strs, int l, int r){
		if(l ==  r)
			return strs[l];
		else{
			int mid = (l+r)/2;
			String lcpLeft = longestCommonPrefix(strs, l, mid);
			String lcpRight = longestCommonPrefix(strs, mid+1, r);
			return commonPrefix(lcpLeft, lcpRight);
		}
	}
	
	public static String commonPrefix(String left, String right){
		int min = Math.min(left.length(), right.length());
		for (int i=0; i<min; i++){
			if(left.charAt(i) != right.charAt(i))
				return left.substring(0, i);
		}
		return left.substring(0, min);
	}
	
	
	public static void main(String[] args) {
		
		//String ss = "ABCDE";
		//String commonPrefix = ss.substring(0, ss.length());
		String[] s = {"abcd", "abe", "a"};
		
		String commonPrefix = LongestCommonPrefixDivideAndConquer(s);
		System.out.println(commonPrefix);
	}

}

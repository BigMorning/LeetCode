package Easy;
import java.util.Stack;

public class ValidParentheses {
	
	public static boolean isValidMyCode(String s){
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<s.length(); i++){
			if(stack.isEmpty() || s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
				stack.push(s.charAt(i));
			else if(!s.isEmpty() && ((s.charAt(i)==')'&&stack.peek()=='(') || (s.charAt(i)==']'&&stack.peek()=='[') 
					|| (s.charAt(i)=='}'&&stack.peek()=='{'))){
				stack.pop();
			}
			else{
				return false;
			}
				
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
	
	public static boolean isValidLeetCode(String s){
		char[] stack = new char[s.length()];
		int head = 0;
		for(char c: s.toCharArray() ){
			switch(c){
			case '(':
			case '[':
			case '{':
				stack[head++] = c;
				break;
			case ')':
				if(head == 0 || stack[--head]!='(')
					return false;
				break;
			case ']':
				if(head == 0 || stack[--head]!='[')
					return false;
				break;
			case '}':
				if(head == 0 || stack[--head]!='{')
					return false;
				break;
			}
		}
		return (head == 0);
	}
	
	public static void main(String[] args) {
		String s = "[(]";
		System.out.println(isValidLeetCode(s));
		
	}
}

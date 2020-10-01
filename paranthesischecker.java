
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    String input=sc.next();
		    if(checkIfBalanced(input))
		        System.out.println("balanced");
		    else
		       System.out.println("not balanced");
		}
	}
	
	public static boolean checkIfBalanced(String input) {

        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;
                
                if (ch == ')' && stack.peek() != '(') return false;
                else if (ch == ']' && stack.peek() != '[') return false;
                else if (ch == '}' && stack.peek() != '{') return false;
                else stack.pop();           
            }
        }

        return stack.isEmpty();
    }
}
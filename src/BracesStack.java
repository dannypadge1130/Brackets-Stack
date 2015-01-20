import java.util.HashMap;
import java.util.Stack;

public class BracesStack {

  public static final HashMap<Character, Character> brackets = new HashMap<Character,Character>();
  static {
	  brackets.put('{', '}');
	  brackets.put('[', ']');
	  brackets.put('(', ')');
  }
  
  public static void main(String[] args) {
  	System.out.println(isBalanced("[](){}")); //true
  	System.out.println(isBalanced("{{[]}}")); //true
  	System.out.println(isBalanced("{][{}")); //false
  	System.out.println(isBalanced("(){}][")); //false
  	System.out.println(isBalanced("{((((())))){}[][]}")); //true
  	System.out.println(isBalanced("{({[]})}")); //true
  	System.out.println(isBalanced("{(((((((()))))]}")); //false
  }	
	
   public static boolean isBalanced(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("String length should be greater than 0");
        }
        
        if ((str.length() % 2) != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < str.length(); i++) {
        	
        	if(!stack.empty()) {
        		char topOfStack = stack.pop();
        		if(!brackets.containsKey(topOfStack) || (str.charAt(i) != brackets.get(topOfStack))) {
        			stack.push(topOfStack);
        			stack.push(str.charAt(i));
        		}
        	} else {
        		stack.push(str.charAt(i));
        	}
        }
        
        return stack.empty();
        
    } 
}
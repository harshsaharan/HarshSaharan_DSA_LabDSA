package com.harshsaharan.main;
import java.util.*;

public class question1 {
	
	 public static boolean isBalanced(String s) {
	        Stack<Character> stack = new Stack<>();

	        for (char c : s.toCharArray()) {
	            if (c == '(' || c == '[' || c == '{') {
	                stack.push(c);
	            } else if (c == ')' || c == ']' || c == '}') {
	                if (stack.isEmpty())
	                    return false;

	                char top = stack.pop();
	                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{'))
	                    return false;
	            }
	        }

	        return stack.isEmpty();
	 }
	 
	 public static void main(String[] args) {
	        
	        Scanner sc = new Scanner(System.in);

	        String inputStrings = sc.nextLine();

	        if (isBalanced(inputStrings)) {
	            System.out.println("The entered String has Balanced Brackets");
	        } else {
	            System.out.println("The entered Strings do not contain Balanced Brackets");
	        }
	 }

}

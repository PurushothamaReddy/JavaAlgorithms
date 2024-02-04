package com.passion.coding.miscellaneous;

import com.sun.deploy.util.StringUtils;

import java.util.Stack;

public class CheckBalancedParentesisMain {

    public static void main(String[] args) {
        String checkBalancedExpr1 = checkBalancedParentesis("a*(b+c)-(d*e)");
        System.out.println("a*(b+c)-(d*e) : " + checkBalancedExpr1);
        String checkBalancedExpr2 = checkBalancedParentesis("(a*(b-c)*{)d+e}");
        System.out.println("(a*(b-c)*{d+e} : " + checkBalancedExpr2);
    }

    public static String checkBalancedParentesis(String expr) {
        if (expr.isEmpty())
            return "Balanced";

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expr.length(); i++) {
            char current = expr.charAt(i);
            if (current == '{' || current == '(' || current == '[') {
                stack.push(current);
            }
            else if (current == '}' || current == ')' || current == ']') {
                if (stack.isEmpty())
                    return "Not Balanced";
                char last = stack.peek();
                if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
                    stack.pop();
                else
                    return "Not Balanced";
            }
        }
        return stack.isEmpty() ? "Balanced" : "Not Balanced";
    }


    public static String checkBalancedParentesisP(String expr) {
        if (expr.isEmpty())
            return "Balanced";
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<expr.length();i++){
            char curr= expr.charAt(i);
            if(curr == '{' || curr == '(' || curr == '[' ) {
                stack.push(curr);
            }
            else if(curr == '}' || curr == ')' || curr == ']' ){
                if(stack.isEmpty()){
                    return "Not balanced";
                }
                char prev= stack.peek();
                if((prev == '{' && curr == '}') || (prev == '(' && curr == ')') || (prev == '[' && curr == ']')){
                    stack.pop();
                }
            }

        }
        return stack.isEmpty()? "Balanced":"Not balanced";
    }

    public static String isBalanced(final String str) {
        if(str == null || str.isEmpty()){
            return "Balanced";
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char current= str.charAt(i);
            if(current =='{' || current== '[' || current=='('){
                stack.push(current);
            } else if (current =='}' || current== ']' || current==')') {
                if(stack.isEmpty()){
                    return "Not Balanced";
                }
                char prev = stack.peek();
                if((prev == '{' && current == '}') || (prev == '(' && current == ')') || (prev == '[' && current == ']')){
                    stack.pop();
                }
            }
        }
        return stack.isEmpty()? "Balanced":"Not Balanced";
    }

}
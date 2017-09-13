package cn.itcast.algorithm.stackandqueue;

import java.util.Stack;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月29日 上午10:05:54
 * 输入一个字符串，字符串中只包含：( ) [] {}这些括号中的一个或者几个，判断输入的字符串是否合法
 * 比如()[]{}、{[]}()等合法
 * 思路：
 * 如果遇到左括号就压栈，遇到右括号就弹出栈顶元素进行比较，成功继续判断下一个；不匹配，直接输出false
 * 
 * 从这里也可以看出栈的一些作用，栈可以做逆序、对称方面的操作
 */
public class ValidParentheses {

	public static void main(String[] args) {
		ValidParentheses test = new ValidParentheses();
		String input = "(){}[]";
		boolean res = test.isValidParentheses(input);
		System.out.println(res);
	}
	
	public boolean isValidParentheses(String input){
		char[] chars = input.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < chars.length; i++) {
			if(chars[i]=='('||chars[i]=='['||chars[i]=='{'){
				stack.push(chars[i]);
			}else{
				try {
					char pop = stack.peek();
					switch (pop) {
					case '(':
						if(chars[i]==')'){
							stack.pop();
						}else{
							return false;
						}
						break;
					case '[':
						if(chars[i]==']'){
							stack.pop();
						}else{
							return false;
						}
						break;
					case '{':
						if(chars[i]=='}'){
							stack.pop();
						}else{
							return false;
						}
						break;

					default:
						return false;
					}
				} catch (Exception e) {
					return false;
				}
				/*
				if(pop=='('){
					if(chars[i]==')'){
						stack.pop();
					}else{
						return false;
					}
				}
				if(pop=='['){
					if(chars[i]==']'){
						stack.pop();
					}else{
						return false;
					}
				}
				if(pop=='{'){
					if(chars[i]=='}'){
						stack.pop();
					}else{
						return false;
					}
				}
				*/
			}
		}
		return stack.isEmpty();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

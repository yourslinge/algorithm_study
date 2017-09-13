package cn.itcast.algorithm.stackandqueue;

import java.util.Stack;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月29日 上午10:05:54
 * 输入一个字符串，字符串中只包含：( ) 中的一个或者几个，判断输入的字符串中最长的合法长度
 * 比如等合法
 * 思路：
 * 如果遇到左括号就压栈，遇到右括号就弹出栈顶元素进行比较，成功继续判断下一个；不匹配，结束本次判断，重置长度计数器
 * 由于本题只存在一种形式的括号，所以，在判断长度时，只会根据左右括号的多少来判断长度计数器是否需重置为0，也是判断最长值的时候
 * 
 * 总结：栈可以用来做匹配问题
 */
public class LongestValidParentheses {

	public static void main(String[] args) {
		LongestValidParentheses test = new LongestValidParentheses();
		String input = ")(()))()()(";
		int res = test.isValidParentheses01(input);
		System.out.println(res);
	}
	
	public int isValidParentheses(String input){
		char[] chars = input.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		int maxLen = 0;
		int counterLen = 0;
		for (int i = 0; i < chars.length; i++) {
			if(chars[i]=='('){
				stack.push(chars[i]);
			}else{
				//适用try-catch的原因是假如第一次stack为空呢
				try {
					char pop = stack.peek();
					if(chars[i]==')'){
						counterLen+=1;
						stack.pop();
					}
					maxLen = Math.max(maxLen, counterLen);
				} catch (Exception e) {
					counterLen = 0;
					maxLen = Math.max(maxLen, counterLen);
				}	
			}
		}
		return maxLen;
	}
	public int isValidParentheses01(String input){
		char[] chars = input.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		int maxLen = 0;
		int counterLen = 0;
		for (int i = 0; i < chars.length; i++) {
			if(chars[i]=='('){
				stack.push(chars[i]);
			}else{
				if(!stack.isEmpty()){
					if(chars[i]==')'){
						stack.pop();
						counterLen +=1;
					}
				}else{
					counterLen = 0;
				}
				maxLen = Math.max(maxLen, counterLen);
			}
		}
		return maxLen;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

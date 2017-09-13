package cn.itcast.algorithm.string;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月26日 下午7:34:13
 */
public class Palindrome {

	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		String str = "A man, a plan, a canal: Panama";
		char[] chars = str.toCharArray();
		boolean res = palindrome.isPalidrome(chars);
		System.out.println(res);
		System.out.println(0+'0');
		
		
	}
	
	public boolean isPalidrome(char[] chars){
		int first = 0;
		int last = chars.length-1;
		while(first<last){
			if(('a'<=chars[first]&&chars[first]<='z')||('A'<=chars[first]&&chars[first]<='Z')){
				if(('a'<=chars[last]&&chars[last]<='z')||('A'<=chars[last]&&chars[last]<='Z')){
					
					if(!(chars[first]+"").equalsIgnoreCase(chars[last]+"")){
						return false;
					}
					first++;
					last--;
				}else{
					last--;
					continue;
				}
			}else{
				first++;
				continue;
			}
		}
		return true;
	}
}

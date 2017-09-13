package cn.itcast.algorithm.string;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月27日 下午7:48:06
 * 二进制数相加，有一个进位carray（=0或1），每次相同位置相加的时候，必须加上进位
 * 而且，每次相加也有一个本地值val，代表相加后的本次结果
 * 
 */
public class AddBinary {

	public static void main(String[] args) {
		AddBinary test = new AddBinary();
		String s1 = "11";
		String s2 = "1010";
		String res = test.calBinary(s1, s2);
		System.out.println(res);
	}
	
	public String reverse(String str){
		char[] chars = str.toCharArray();
		int length = chars.length;
		int first = 0, last = length-1;
		while(first<last){
			char temp = chars[first];
			chars[first] = chars[last];
			chars[last] = temp;
			first++;
			last--;
		}
		return new String(chars);
	}
	
	public String calBinary(String s1,String s2){
		StringBuilder sb = new StringBuilder();
		s1 = reverse(s1);
		s2 = reverse(s2);
		System.out.println(s2);
		int size = s1.length()>s2.length()?s1.length():s2.length();
		int carry = 0;
		for(int i = 0; i<size; i++){
			int as1 = i<s1.length()?s1.charAt(i)-'0':0;
			int as2 = i<s2.length()?s2.charAt(i)-'0':0;
			int val = (as1+as2+carry)%2;
			carry = (as1+as2+carry)/2;
			sb.append(val);
		}
		if(carry==1) sb.append('1');  // 考虑最后一次会进位
		return sb.reverse().toString();
	}
}

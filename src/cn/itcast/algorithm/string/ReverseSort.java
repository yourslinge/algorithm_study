package cn.itcast.algorithm.string;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年4月2日 上午10:59:15
 */
public class ReverseSort {

	public static String reverseSort(String str){
	    char[] arrChars = str.toCharArray();
		int length = arrChars.length;
		int first = 0, last = length-1;
//		for(int i = 0;i < length/2;i++){
//			char temp =arrChars[i];
//			arrChars[i] = arrChars[length-1-i];
//			arrChars[length-1-i] = temp;
//		}
		while(first<last){
			char temp =arrChars[first];
			arrChars[first] = arrChars[last];
			arrChars[last] = temp;
			first++;
			last--;
		}
		return new String(arrChars);
	}
	
	public static void main(String[] args) {
		String str = "pig dog";
		str = reverseSort(str);
		System.out.println("reverse:"+str);
	}
}

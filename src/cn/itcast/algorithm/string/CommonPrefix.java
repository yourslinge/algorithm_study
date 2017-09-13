package cn.itcast.algorithm.string;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月27日 下午4:54:58
 */
public class CommonPrefix {

	public static void main(String[] args) {
		CommonPrefix prefix = new CommonPrefix();
		String[] strs = {"abcd","abcff","abcdef","abcd"};
		String res = prefix.calCommonPrefix(strs);
		if(res!=null) System.out.println(res);
	}
	
	public String calCommonPrefix(String[] strs){
		int strsLen = strs.length;
		String str0 = strs[0];
		int length = str0.length();
		for(int index = 0; index<length; index++){//控制str0的长度
			for(int i = 1; i<strsLen; i++){//控制strs数组的元素
				//str0中的元素要与strs数组中的每个元素进行比较
				if(str0.charAt(index)!=strs[i].charAt(index)) return str0.substring(0, index);
			}
		}
		return null;
	}
}

package cn.itcast.algorithm.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月9日 下午2:51:20
 * 给定一个字符串，求这个字符串的最长的不重复的字串
 * 思路：遇到重复字符时，就从上一个重复字符的位置+1出，开始新的搜索，记录上一次搜索的字符串长度
 * 本longCharacter()方法：分析可以看出少算了一次从k--x之间，因为这不需要算？为什么呢？有那样就在于，从某个字符开始
 * 一直遍历到整个字符串结束了？就代表该字符串到结尾是最长的啦。仔细品味下
 * 必然有本例：r--x--|x 结束，那么从x+1的位置k--x之间算最长，肯定没有r--x--|x长
 */
public class LongestCharacter {

	//方式一：使用Map做缓存，可能会出现运行超时，因为每次重新搜索，还会遍历map，删除之前的元素
	public String longCharacter(String str){
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		int length = str.length();
		int start = 0; //记录每次搜索的起始位置
		int index = 0; //记录最大不重复字符串的起始位置,用来返回不重复字符串
		int maxLen = 1;// 记录最大不重复字符串的长度
		int position = 0; //记录重复的一个字节的位置
		char[] chars = str.toCharArray();
		for(int i = 0; i<length; i++){
			if(map.get(chars[i])==null){
				map.put(chars[i], i);
			}else{
				position = map.get(chars[i]);
				map.put(chars[i], i);
				// 记录最大不重复字符串的起始位置、长度等信息，并更新下一次搜索的位置
				if(maxLen<(i-start)){
					maxLen = i-start;
					index = start;
					start = position+1;
				}
				//在map中，将新position之前的元素都删除，避免与下一次搜索的结果产生误差
				// 千万注意啊，这里的j<position,而不是<=，为什么呢？map.put(chars[i], i)已经将重复的元素覆盖了啊
				for(int j = index; j<position; j++){
					map.remove(chars[j]);
				}
			}
		}
		
		return str.substring(index, index+maxLen);
//		return maxLen+""+index;
	}
	//方法二：节省了时间
	public int longCharacter01(String str){
		char[] chars = str.toCharArray();
		int length = chars.length;
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		int start = 0;
		int max_len = 1;
		for(int i = 0; i<length; i++){
			if(arr[chars[i]-'a']>=start){
				max_len = Math.max(i-start, max_len);
				start = arr[chars[i]-'a']+1;
			}
			arr[chars[i]-'a'] = i;//记录下标
		}
		return Math.max(length-start,max_len);//假设所有字符串都不重复，abcdefg
	}
	
	public static void main(String[] args) {
		LongestCharacter test = new LongestCharacter();
		String str = "qpxrjxkltzyx";
//		String res = test.longCharacter(str);
		int res = test.longCharacter01(str);
		System.out.println(res);
//		System.out.println(str.substring(3, 3+8));
	}
}

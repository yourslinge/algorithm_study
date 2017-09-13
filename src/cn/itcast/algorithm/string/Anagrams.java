package cn.itcast.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月27日 下午2:09:37
 */
public class Anagrams {

	public static void main(String[] args) {
		Anagrams anagrams = new Anagrams();
		String[] strs = {"tea","and","ate","eat","dna"};
//		char[] chars = strs[0].toCharArray();
//		anagrams.bubbleSort(chars);
//		String str = new String(chars);
//		System.out.println(str);
//		System.out.println(chars);
		
		
		String[] res = anagrams.isAnagrams(strs);
		for (String string : res) {
			System.out.println(string);
		}
	}
	public String[] isAnagrams(String[] strs){
		int length = strs.length;
		int counter = 0;
		String[] res = new String[length+1];
		Map<String,Integer> anagramsMap = new HashMap<String,Integer>();
		for(int i = 0; i<length; i++){
			char[] chars = strs[i].toCharArray();
			bubbleSort(chars);
			String newStr = new String(chars);
			if(anagramsMap.get(newStr)==null){
				anagramsMap.put(newStr, i);//(aet,0)-->tea,第一个字符串数组中的元素
			}else{
				//大于等于0是因为数组最小下标为0
				if(anagramsMap.get(newStr)>=0){//如果再次存在(aet)话，必定要将aet对应的值tea输出，也即是输出
												//判断条件的值，不输出的话，就会少一个元素，因为上面的if就是为了
												//在map中存储判断条件的值，要不然接下来，怎么判断呢？
					res[counter++] = strs[anagramsMap.get(newStr)]; // 记录条件值
					anagramsMap.put(newStr, -1);//再将此设置为-1,下次就不会再次输出判断条件的值啦
				}
				res[counter++] = strs[i];
			}
			/**
			 if(){
			      本if中的语句，是用来在map中，存储第一次出现的newStr，以及newStr对应的原始字符串str[i]的位置i
			 
			 }else{
			      对于，下次在map中出现相同newStr的字符串，证明这个字符串满足回文构造词的条件，将其存储下来。但是，这里
			      明显有一个问题，那么第一次，出现newStr并存储进map的字符串位置，其所对应的字符串，是判定条件，但也符合
			      回文构造词的要求，也应将其打印出来，要不然就会漏掉一个元素。
			 }
			 */
		}
		return res;
	}
	
	
	public void bubbleSort(char[] chars){
		int length = chars.length;
		for(int i = 0;i < length-1; i++){
			for(int j = 0; j < length -i-1; j++){
				if(chars[j] > chars[j+1]){
					char temp = chars[j];
					chars[j] = chars[j+1];
					chars[j+1] = temp;
				}
			}
		}
	}
	
	
}

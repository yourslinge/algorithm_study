package cn.itcast.algorithm.string;

import org.junit.Test;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年4月2日 上午8:41:00
*/
public class StringDemo {
	/**
	 * 一个字符串str，把字符串str前面任意的部分挪到后面去形成的字符串叫做str的旋转词。
	 * 比如str="1234"，str的旋转词有 1234、2341、3412、4123.
	 * 问题：
	 * 	  给定两个字符串a和b，请判断a和b是否互为旋转词。
	 * 
	 * 思路：
	 *   1.判断a和b的长度是否相等
	 *   2.如果a和b长度相等，生成a+b的大字符串
	 *   3.用KMP算法判断大字符串中是否含有b
	 *   4.kmp算法算出的匹配的第一个索引值应该小于a的长度
	 */
	@Test
	public void testOne(){
		// 方式1
		/*
		String a = "1234";
		String b = "1423";
		String ab = a + a;
		int[] next = KMPalgorithm.next(b);
		int res = KMPalgorithm.pattern(ab, b, next);
		System.out.println(res);
		*/
		//方式2
		String a = "1234";
		String b = "1423";
		String ab = a + a;
		boolean res = ab.contains(b)?true:false;
		System.out.println(res);
	}
	
	
	/**
	 * 给定一个字符串str，请在"单词间"做逆序调整。
	 * 举例：
	 * pig loves dog => dog loves pig
	 * 思路：
	 *   1.实现将字符串局部所有字符都逆序的函数f
	 *   2.利用f将字符串所有字符逆序
	 *   3.找到逆序后的字符串中每一个单词的区域，利用f将每一个单词的区域逆序
	 */
	@Test
	public void testTwo(){
		String str = "pig loves dog";
		str = ReverseSort.reverseSort(str);
		String[] splited = str.split(" ");
		StringBuilder builder = new StringBuilder();
		for(int i = 0;i<splited.length;i++){
			builder.append(ReverseSort.reverseSort(splited[i])+" ");
		}
		System.out.println(builder.toString());
	}
	/**
	 * 给定一个字符串str，和一个整数i，i代表str中的一个位置，将str[0..i]移到右侧，str[i+1..N-1]移到左侧
	 * 举例：
	 *   str="ABCDE"，i=2，将str调整为"DEABC"
	 * 要求：时间复杂度为O(N)，额外空间复杂度为O(1)（就是不要用额外空间，进行辅助调整）
	 * 思路：
	 *   1.将str[0..i]部分的字符逆序
	 *   2.将str[i+1..N-1]部分的字符逆序
	 *   3.将str整体的字符逆序
	 */
	@Test
	public void testThree(){
		String str = "ABCDE";
		int i = 2;
		String str1 = str.substring(0, i+1);
		String str2 = str.substring(i+1);
		str1 = ReverseSort.reverseSort(str1);
		str2 = ReverseSort.reverseSort(str2);
		str = str1+str2;
		str = ReverseSort.reverseSort(str);
		System.out.println(str);
	}
	/**
	 * 给定一个字符串类型的数组strs，请找到一种拼接顺序，是的将所有字符串拼接起来组成的大字符串是所有可能性中
	 * 字典顺序最小的，并返回这个大字符串
	 * 举例：
	 *   strs=["abc","de"]。可以拼接成"abcde"、"deabc"，但是前者字典顺序更小
	 *   strs=["b","ba"]。可以拼接成"bba"、"bab"，但是后者字典顺序更小
	 *   思路：
	 *     如果str1+str2<str2+str1，则将str1放在前面，否则，str2放在前面
	 */
	
	
	@Test
	public void testFour(){
		String[] strs = {"a","b","ba","bc"};
		int length = strs.length;
		
		
		for(int i = 0;i<length-1;i++){
			for(int j = i+1;j<length;j++){
				if( (strs[i]+strs[j]).compareTo(strs[j]+strs[i]) > 0){
					String temp = strs[i];
					strs[i] = strs[j];
					strs[j] = temp;
				}
			}
		}
		for (String string : strs) {
			System.out.println(string);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

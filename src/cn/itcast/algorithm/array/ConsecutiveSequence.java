package cn.itcast.algorithm.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月28日 上午10:46:43
 * 要求：给定一个无序的整型数组，找到其中最大的连续序列的长度
 *      比如[100,4,200,1,3,2]-->[1,2,3,4] 长度为4
 * 思路：
 * 	        用一个set记录每个元素，对每个元素，以该元素为中心，往左右扩张（是指该元素加1或者减1），直到不连续为止，记录下最长的长度。
 */
public class ConsecutiveSequence {

	public static void main(String[] args) {
		ConsecutiveSequence test = new ConsecutiveSequence();
		int[] arr = {100,4,200,1,3,2};
		int res = test.findLongestConsecutiveSequence(arr);
		System.out.println(res);
	}
	
	public int findLongestConsecutiveSequence(int[] arr){
		int length = arr.length;
		if(length <=1){
			return length;
		}
		int res = 0; //记录长度
		// 记录数组元素
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < length; i++) {
			set.add(arr[i]);
		}
		// 遍历元素
		for(int i = 0; i<length; i++){
			int tempLen = 1,tempNum;
			//先求比当前元素arr[i]大的所有连续元素
			tempNum = arr[i]+1;
			while(set.contains(tempNum)){
				set.remove(tempNum);
				tempNum++;
				tempLen++;
			}
			//再求比当前元素arr[i]小的所有连续元素
			tempNum = arr[i]-1;
			while(set.contains(tempNum)){
				set.remove(tempNum);
				tempNum--;
				tempLen++;
			}
			res = Math.max(res, tempLen);
		}
		return res;
	}
}

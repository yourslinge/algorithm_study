package cn.itcast.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月28日 下午8:29:44
 * 给定一个整型数组，要求数组中的3个元素a+b+c=0
 * 要求;a<=b<=c;且每个输出的结果是独一无二的
 */
public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum test = new ThreeSum();
		int[] arr = {-1,0,1,2,-1,-4};
		Set<String> set = test.calThreeSum(arr, 0);
		for (String string : set) {
			System.out.println(string);
		}
	}
	
	public Set<String> calThreeSum(int[] arr,int value){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		Arrays.sort(arr);//要求:a<=b<=c;
		Set<String> set = new HashSet<String>();//使用set就是为了对结果中重复的进行去重
		int length = arr.length;
		for(int i = 0; i<length; i++){
			map.put(arr[i], i);
//			System.out.println(arr[i]);
		}
		for(int i = 0; i<length;i++){
			for(int j=i+1; j<length;j++){
				int remain = value - arr[i] - arr[j];
				if(map.containsKey(remain)&&map.get(remain)>j){
					set.add(arr[i]+","+arr[j]+","+remain);
				}
			}
		}
		return set;
		
	}
}

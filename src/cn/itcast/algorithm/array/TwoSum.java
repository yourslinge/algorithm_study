package cn.itcast.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月28日 下午2:42:41
 * 给定一个整型数组，求 数组中两个元素相加的和为target，要求不要出现重复元素
 */
public class TwoSum {

	public static void main(String[] args) {
		TwoSum test = new TwoSum();
//		int[] arr = {2,7,11,15,1,8,9,0};
//		test.claTwoSum(arr, 9);
		int[] arr = {2,7,11,15,1,7,7,2,8,9,0};
		test.claTwoSumWithDuplicates(arr, 9);
		
	}
	
	public void claTwoSum(int[] arr, int target){
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int length = arr.length;
		for(int i = 0;i < length; i++){
			map.put(arr[i], i);
		}
		for(int i = 0;i < length; i++){
			int remain = target-arr[i];
			if(map.get(remain)!=null){
				map.remove(arr[i]);
				map.remove(remain);
				System.out.println(arr[i]+","+remain);
			}
		}
	}
	/**
	 * 将数组中重复元素的下标都打印出来
	 * @param arr
	 * @param target
	 */
	public void claTwoSumWithDuplicates(int[] arr, int target){
		Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		int length = arr.length;
		// 其实直接使用map储存元素及其下标，就已经可以达到去重的目的啦，因为相同元素会覆盖的
		for(int i = 0;i < length; i++){
			if(map.containsKey(arr[i])){
				map.get(arr[i]).add(i);
			}else{
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(arr[i], list);
			}
		}
		for(int i = 0;i < length; i++){
			int remain = target-arr[i];
			ArrayList<Integer> resList = map.get(remain);
			if(resList!=null){
				System.out.print(i+",");
				for(Integer data : resList){
					System.out.print("("+data+")");
				}
				System.out.println();
				map.remove(arr[i]);
				map.remove(remain);
			}
		}
	}
}

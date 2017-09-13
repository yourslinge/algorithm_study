package cn.itcast.algorithm.array;

import java.util.Arrays;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月24日 下午2:06:29
 * 清除“有序 ”数组中的重复元素，确保元素最多只出现两次,并返回数组的长度
 */
public class RemoveDuplicates02 {

	public static void main(String[] args) {
		RemoveDuplicates02 lesson = new RemoveDuplicates02();
		int[] arr = {1,1,1,2,3,3,3,3,4};
		int length = lesson.removeDuplicates(arr);
		System.out.println(length);
		System.out.println(Arrays.toString(arr));
	}
	
	public int removeDuplicates(int[] arr){
		int oriArrLength = arr.length;
		if(oriArrLength<=2){
			return oriArrLength;
		}
		int index = 2;
		for(int i = 2; i < oriArrLength; i++){
			if(arr[i] != arr[index-2]){
				arr[index++] = arr[i];
			}
		}
		return index;
	}
}

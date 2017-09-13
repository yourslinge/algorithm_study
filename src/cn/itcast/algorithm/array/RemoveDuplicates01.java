package cn.itcast.algorithm.array;

import java.util.Arrays;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月23日 下午9:22:08
 * 清除“有序 ”数组中的重复元素，确保元素只出现一次,并返回数组的长度
 * 比如:A=[1,1,2]  操作后：A=[1,2],长度为2
 * 分析：
 *  从要求中可以看出，每个元素只出现一次，加上数组已经是有序的啦，所以可以从数组下标为1开始判断，
 *  从编写的代码中可以看出，实际上定义了两个指针，i用来遍历数组中的每个元素；index用来表示重复元素
 *  所在的位置和最终的长度，便于覆盖arr[index++] = arr[i]
 *  
 * 备注：数组中，用双下标是非常好的解题思路，比如RemoveDuplicates02、RemoveElement
 */
public class RemoveDuplicates01 {

	public static void main(String[] args) {
		RemoveDuplicates01 lesson = new RemoveDuplicates01();
		int[] arr = {1,1,2};
		int length = lesson.removeDuplicates(arr);
		
		System.out.println(length);
		System.out.println(Arrays.toString(arr));
	}
	
	public int removeDuplicates(int[] arr){
		int oriArrLength = arr.length;
		if(oriArrLength<0) return 0;
		int index = 1;
		for(int i=1; i<oriArrLength; i++){
			if(arr[i]!=arr[index-1]){
//				arr[index++] = arr[i];
			}
		}
		return index;
	}
}

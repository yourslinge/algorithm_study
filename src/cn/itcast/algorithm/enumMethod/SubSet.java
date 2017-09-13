package cn.itcast.algorithm.enumMethod;

import java.util.Arrays;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月3日 下午8:04:58
 * 将一个数组中的某些元素拿出来组成新的数组，要求不重复
 */
public class SubSet {

	public static void main(String[] args) {
		SubSet test = new SubSet();
		int[] arr = {1,2,3,3};
		int[][] res = test.subSetsWithDuplicates(arr);
		int length = res.length;
		for(int i=0; i<length; i++){
			System.out.println(Arrays.toString(res[i]));
		}
	}
	
	public int[][] subSets(int[] arr){
		int length = arr.length;
		//length*2：代表arr中的每个元素都可选或不选，+2：意思是arr本身以及空数组
		int[][] set = new int[length*2+2][length];
		int count = length;
		int index = 0;
		for(int i=0; i<length; i++){
			set[i][0] = arr[i];
			for(int j=i+1; j<length; j++){
				set[count][0] = arr[i];
				set[count][1] = arr[j];
				count++;
			}
		}
		set[count] = arr;
		return set;
	}
	public int[][] subSetsWithDuplicates(int[] arr){
		Arrays.sort(arr);
		int length = arr.length;
		//length*2：代表arr中的每个元素都可选或不选，+2：意思是arr本身以及空数组
		int[][] set = new int[length*2+2][length];
		int count = 0;
		int index = 0;
		int temp = Integer.MIN_VALUE;
		for(int i=0; i<length;i++){
			if(arr[i]!=temp){
				temp = arr[i];
				set[count++][0] = arr[i];
			}
		}
		int newLen = count;
		for(int i=0; i<newLen; i++){
			for(int j=i+1; j<newLen; j++){
				set[count][0] = set[i][0];
				set[count][1] = set[j][0];
				count++;
			}
		}
		set[count] = arr;
		return set;
	}
}

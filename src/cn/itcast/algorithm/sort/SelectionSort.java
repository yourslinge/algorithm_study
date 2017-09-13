package cn.itcast.algorithm.sort;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年4月3日 下午1:11:44
 * 时间复杂度为：O(n*n)
 * 选择排序原理
 * 每一次从待排序的数据元素中选出最小(或最大)的一个元素，存放在"该次遍历起始下标所在位置"，比如：第一次遍历从下标0开始，则选
 * 出的元素放在0位置；第二次遍历从下标1开始，则选出的元素放在1位置；
 * 重复上述，直到数组中的元素全部遍历了一遍（除最后一个元素）。
 */
public class SelectionSort {

	public static void selectionSort(int[] arr){
		int length = arr.length;
		for(int i = 0; i<length-1;i++){
			for(int j = i+1;j<length;j++){
				if(arr[i] > arr[j]){ // 将最小的放在前面
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int arr[]={2,4,7,9,8,6};
		selectionSort(arr);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
}

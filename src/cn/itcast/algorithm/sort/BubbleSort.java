package cn.itcast.algorithm.sort;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年4月3日 下午12:55:43
 * 时间复杂度为：O(n*n)
 * 冒泡排序原理： "相邻元素间进行比较"
 * 1.从头开始比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2.对每一对相邻元素做同样的工作，知道结尾。完成本次比较后，最大的元素会出现在最后。
 * 
 * 3.针对所有的元素重复以上的1、2步骤，除了最后一个。
 * 4.每次只会对越来越少的元素重复上面的步骤，比如第一次需从头到尾，第二次比第一次少比较一个元素。直到没有任何一对数字需要比较。
 * 重点：每次排序，都会将最大（小）的元素放在右边
 */
public class BubbleSort {

	public static void bubbleSort(int[] arr){
		int length = arr.length;
		for(int i = 0;i < length-1; i++){
			for(int j = 0 ; j < length-i-1; j++){//
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int arr[]={2,7,4,3,1};
		bubbleSort(arr);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
}

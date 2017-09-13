package cn.itcast.algorithm.sort;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年4月3日 下午1:33:51
 * 时间复杂度为：O(n*n)
 */
public class InsertSort {

	//体会数组中，使用多下标的好处
	public static void insertSort(int[] arr){
		int length = arr.length;
		
		for(int i = 1; i<length;i++){
			int currentValue = arr[i];
			int position = i; //指currentValue所处位置
			for(int j = i-1;j>=0;j--){
				if(arr[j]>currentValue){
					arr[j+1] = arr[j];
					position--;
				}else{
					break;
				}
			}
			arr[position] = currentValue;
		}
	}
	public static void insertSort01(int[] arr){
		int length = arr.length;
		
		for(int i = 0; i<length;i++){
			for(int j = i;j>0;j--){
				if(arr[j]<arr[j-1]){
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		
//		int[] arr = {6,5,3,1,8,7,2,4};
		int[] arr = {2,7,4,3,1};
		insertSort01(arr);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
}

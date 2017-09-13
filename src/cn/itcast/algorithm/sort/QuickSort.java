package cn.itcast.algorithm.sort;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年4月3日 下午3:24:24
 * 时间复杂度为：O(N*logN)
 *   通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
 *   则分别对这两部分继续进行排序，直到整个序列有序。
 *   
 *   一趟排序完成，左边就是比中轴小的，右边就是比中轴大的，然后再用分治法，分别对这两个独立的数组进行排序。
 */
public class QuickSort {

	public static void quickSort(int[] arr,int low,int high){
		if(low < high){
			//将arr数组进行一分为二
			int middle = getMiddle(arr,low,high); 
			//对低字段表进行递归排序
			quickSort(arr,low,middle-1);
			//对高字段表进行递归排序
			quickSort(arr,middle+1,high);
		}
	}
	public static int getMiddle(int[] arr,int low,int high){
		//数组的第一个作为中轴
		int key = arr[low];
		while(low < high){
			while(low<high&& arr[high]>=key){
				high--;
			}
			//比中轴小的记录移到低端
			arr[low] = arr[high];
			while(low<high&&arr[low]<=key){
				low++;
			}
			//比中轴大的记录移到高端
			arr[high] = arr[low];
		}
		//中轴记录到尾
		arr[low] = key;
		// 返回中轴的位置
		return low;
	}
	public static void main(String[] args) {
		int arr[]={54,35,48,36,27,12,44,44,8,14,26,17,28};
		quickSort(arr,0,arr.length-1);
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}
}

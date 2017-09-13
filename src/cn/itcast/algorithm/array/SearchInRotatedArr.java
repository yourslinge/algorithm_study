package cn.itcast.algorithm.array;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月24日 下午7:25:13
 * 一个有序的数组，以某个位置的轴，旋转，比如[1,2,3,4,5,6,7] -> [4,5,6,7,1,2,3]
 * 在这个旋转的数组中，查找某个元素，要求：时间复杂度为O(logn)，空间复杂度为O(1)
 * 已知排序的数组中使用二分查找的时间复杂度为O(logn)
 * 分析：
 *  首先将有序的那部分元素找出来；然后开始对这两部分开始判断
 */
public class SearchInRotatedArr {

	public static void main(String[] args) {
		SearchInRotatedArr lesson = new SearchInRotatedArr();
//		int[] arr = {4,5,6,7,1,2,3};
//		int position = lesson.searchInRotatedArr(arr, 2);
//		System.out.println("2 position:"+position);
		int[] arr = {4,4,5,5,6,7,8,8,1,2,2,3,3};
		int position = lesson.searchInRotatedArrWithDuplicates(arr, 2);
		System.out.println(position);
	}
	
	public int searchInRotatedArr(int[] arr,int value){
		int first = 0;
		int last = arr.length;
		while(first!=last){
			int mid = (first+last)/2;
			if(value==arr[mid]){
				return mid;
			}
			//只可以判断mid的一边是否有序
			if(arr[first]<=arr[mid]){//mid左边的元素是有序且顺序的，右边是判断不了的
				//判断value是不是在这个范围内
				if(arr[first]<=value&&value<arr[mid]){
					last = mid;
				}else{
					first = mid + 1;
				}
			}else{//mid右边的元素是有序且逆序的
				if(arr[mid]<value&&value<=arr[last-1]){
					first = mid + 1;
				}else{
					last = mid;
				}
			}
		}
		return -1;
	}
	public int searchInRotatedArrWithDuplicates(int[] arr,int value){
		int first = 0;
		int last = arr.length;
		while(first!=last){
			int mid = (first+last)/2;
			if(value==arr[mid]){
				return mid;
			}
			if(arr[first]<arr[mid]){//mid左边的元素是有序且顺序的
				//判断value是不是在这个范围内
				if(arr[first]<=value&&value<arr[mid]){
					last = mid;
				}else{
					first = mid + 1;
				}
			}else if(arr[first]>arr[mid]){//mid右边的元素是有序且逆序的
				if(arr[mid]<value&&value<=arr[last-1]){
					first = mid + 1;
				}else{
					last = mid;
				}
			}else{ //【1,3,1,1】
				first++;
			}
		}
		return -1;
	}
}

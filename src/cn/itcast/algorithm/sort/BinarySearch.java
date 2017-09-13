package cn.itcast.algorithm.sort;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月24日 下午3:59:38
 */
public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch bSearch = new BinarySearch();
//		int arr[] = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
//		int position = bSearch.binSearch(arr, 811);
//		System.out.println(position);
		int[] arr = {1,3,5,5,5,8,9};
		int first = bSearch.binSearchDuplicates(arr, 5);
		int second = bSearch.binSearchDuplicates01(arr, 5);
		System.out.println("first:"+first+"second:"+second);
	}
	
	public int binSearch(int[] arr,int value){
		int start = 0;
		int end = arr.length-1;
		int mid = 0;
		while(start<=end){
			mid = (end+start)/2;
			if(value == arr[mid]){
				return mid;
			}else if(value < arr[mid]){
				end = mid - 1;
			}else{
				start = mid + 1;
			}
		}
		return -1;
	}
	
	public int binSearchDuplicates(int[] arr,int value){
		int start = 0;
		int end = arr.length-1;
		int mid = 0;
		while(start < end){
			mid = (start+end)/2;
			if(arr[mid]<value){
				start = mid+1;
			}else{
				end = mid;
			}
		}
		if(arr[start]!=value){
			return -1;
		}else{
			return start;
		}
	}
	public int binSearchDuplicates01(int[] arr,int value){
		int start = 0;
		int end = arr.length-1;
		int mid = 0;
		while(start < end){
			mid = (start+end+1)/2;
			if(arr[mid]<=value){
				start = mid;
			}else{
				end = mid-1;
			}
		}
		if(arr[start]!=value){
			return -1;
		}else{
			return end;
		}
	}
}

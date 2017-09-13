package cn.itcast.algorithm.array;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月28日 上午8:29:24
 * 给定两个排序好的数组，找到两者所有元素中的第k大元素
 * 类似于合并两个数组并排序的方式，给两个数组分别指定头指针arr1数组的s1，arr2数组的s2，以及一个计算器k，
 * 该计数器的作用主要是用来判断是否已经达到第value大元素
 * 首先，判断arr1[s1]和arr2[s2]的大小，前者小，arr[s1]代表是当前第k大元素，然后s1++；
 * 反之，arr2[s2]代表是当前第k大元素，然后s2++；最后另k++
 * 
 */
public class MedianOfArr {

	public static void main(String[] args) {
		MedianOfArr test = new MedianOfArr();
		int[] arr1 = {1,3,4,5,6,9,10,34,56};
		int[] arr2 = {0,3,6,8,16,19,110};
		int res = test.findMeadianOfArr(arr1, arr2, 5);
		System.out.println(res);
	}
	
	public int findMeadianOfArr(int[] arr1,int[] arr2,int value){
		int s1 = 0, s2 = 0, k = 0, res = 0;//记录结果
		while(k!=value){
			if(arr1[s1]<=arr2[s2]){
				res = arr1[s1];
				s1++;
			}else{
				res = arr2[s2];
				s2++;
			}
			k++;
//			if(k==value){
//				return res;
//			}
			
		}
		return res;
	}
}

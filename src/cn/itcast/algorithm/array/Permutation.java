package cn.itcast.algorithm.array;

import java.util.Arrays;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月4日 下午7:36:09
 * 字典序简介：
 * 假设有数组2763541，求其下一个字典序序列
 * 1.找到最后一个正序，35
 * 2.找到3后面，比3大的最后一个数4
 * 3.交换3、4位置-->[2764531]
 * 4.将4后面的元素反序排序：2764135
 * 备注：如果原序列都是逆序，那么就将整个原序列翻转即可变成字典序
 */
public class Permutation {

	public void nextPermutation(int[] arr){
		int length = arr.length;
		int pos = -1;//记录正序的两个数的下标，-1肯定不会冲突的，因为数组下标最小为0
		// 注意此处的判断循环的条件 i>0，不能写成i>=0;因为每次i会与i-1比较，如果i=0,i-1就会越界啦
		// 以后写数组等涉及越界的操作，使用for循环时，一定要先将边界值带入，模拟是否出错
		for(int i=length-1;i>0;i--){
			if(arr[i]>arr[i-1]){
				pos = i-1;
				break;//找到一个，就可以退出，返回了
			}
		}
		System.out.println(pos);
		if(pos>=0){
			for(int i=length-1;i>pos;i--){
				if(arr[i]>arr[pos]){
					swap(arr, pos, i,true);//交换两个数
					System.out.println(Arrays.toString(arr));
					swap(arr, pos+1, length-1, false);//翻转数
					System.out.println(Arrays.toString(arr));
					break; // 一旦找到比arr[pos]大的元素，就可以跳出循环啦
				}
			}
			
		}else{//全部翻转
			swap(arr, 0, length-1, false);
			System.out.println(Arrays.toString(arr));
		}
	}
	public void swap(int[] arr,int first,int last,boolean flag){
		if(flag){
			int temp = arr[first];
			arr[first] = arr[last];
			arr[last] = temp;
		}else{
			// 将数组中first到last区间内的元素逆序，下面的程序是做数组的逆序
			while(first<last){
				int temp = arr[first];
				arr[first] = arr[last];
				arr[last] = temp;
				
				first++;
				last--;
			}
		}
	}
	
	public static void main(String[] args) {
		Permutation test = new Permutation();
//		int[] arr = {2,7,6,3,5,4,1};
		int[] arr = {5,4,3,2,1};
		test.nextPermutation(arr);
//		for (int i : arr) {
//			System.out.println(i);
//		}
	}
}

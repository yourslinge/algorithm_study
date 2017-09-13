package cn.itcast.algorithm.array;

import java.util.Arrays;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月5日 下午2:15:23
 * 将n*n的数组顺时针旋转90度，可先按对角线翻转一次，再按水平线翻转一次
 * 比如：
 * 1,2   4,2   3,1 
 * 3,4   3,1   4,2
 */
public class RotateMatrix {

	
	public void rotate(int[][] arr){
		int length = arr.length;
		// 先对角线翻转，注意，对角线上的元素是不用做交换的（3,2）
		for(int i=0; i<length-1;i++){ //i控制行
			for(int j=0; j<length-1-i; j++){//j控制列
				swap(arr,i,j);
			}
		}
		for(int i=0; i<length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("==========================");
		
		// 后水平线旋转
		for(int i=0; i<length; i++){//控制每一列元素的角标
			//对每一列角标的各行进行交换
			int first = 0;
			int last = length-1;
			while(first<last){
				//swap(arr,arr[first][i], arr[last][i]);
				int temp = arr[first][i];
				arr[first][i] = arr[last][i];
				arr[last][i] = temp;
				first++;
				last--;
			}
		}
		for(int i=0; i<length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		
	}
	
	public void swap(int[][] arr,int i,int j){
		int length = arr.length;
		int temp = arr[i][j];
	    arr[i][j] = arr[length-1-j][length-1-i];
	    arr[length-1-j][length-1-i] = temp;
	}
	
	
	public static void main(String[] args) {
		RotateMatrix test = new RotateMatrix();
		int[][] arr = {{1,2},{3,4}};
		test.rotate(arr);
	}
}

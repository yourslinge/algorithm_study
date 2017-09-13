package cn.itcast.algorithm.netbase;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月11日 下午1:59:29
 * 给定一个整型数组，判断通过几次相邻元素相加的操作，可以变成回文数
 * 相邻元素相加之和，插入相邻元素之前的位置
 */
public class Lesson01 {
	
	public static int times(int[] arr, int n){
		Arrays.sort(arr);
		int head = 0;
		int tail = n-1;
		int time = 0;
		int counter = 0;
		while(head<tail-1){
			if(counter++==0){
				time += arr[tail]-arr[head]-arr[++head];
				tail--;
			}else{
				time += arr[head]-arr[head-2] +arr[++head]+arr[head-2];
			}
			head++;
		}
		return time;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n;i++){
				arr[i] = sc.nextInt();
			}
			System.out.println(times(arr, n));
		}
		sc.close();
	}
}

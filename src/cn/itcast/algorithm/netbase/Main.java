package cn.itcast.algorithm.netbase;

import java.util.Scanner;
/**
 * @author lenovo-
 */
public class Main {

	public int reverseSort(int[] arr, int n,int m){
		int start = 0;
		int counter = 0;
		for(int i = 0;i<m;i++){
			if(arr[start]<n){
				counter++;
				if(start!=arr[start]){
					start = arr[start];
				}else{
					start = start+1;
				}
			}
		}
		return counter+1;
	}
	public static void main(String[] args) {
		Main test = new Main();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr = new int[n-1];
			for(int i=0; i<n-1;i++){
				arr[i] = sc.nextInt();
			}
			int str = test.reverseSort(arr, n,m);
			System.out.println(str);
		}
	}
}

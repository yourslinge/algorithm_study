package cn.itcast.algorithm.greedy;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月10日 上午10:21:48
 * 给定一个整型数组，其中下标代表天，对应的元素代表改天证券的价格
 */
public class SellStock {

	// 只给你一次买入卖出，你能获得的最大利益
	public int maxProfitWithOne(int[] arr){
		int length = arr.length;
		int min = arr[0];
		int max = 0;
		int profit = 0;
		for(int i = 1; i<length; i++){
			profit = Math.max(profit,arr[i] - min);
			min = Math.min(min, arr[i]);
		}
		return profit;
	}
	// 多次买入卖出，你能获得的最大利益
	public int maxProfitWithMany(int[] arr){
		int length = arr.length;
		int sum = 0;
		for(int i = 1; i<length; i++){
			int diff = arr[i] - arr[i-1];
			if(diff>0) sum += diff;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
	}
}

package cn.itcast.algorithm.stackandqueue;

import java.util.Arrays;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月30日 上午10:31:16
 * 求矩形的最大面积问题，矩形的宽度为1，矩形的高度用一个整型数组表示，代表每个小矩形的高度，求这些矩形所能组成的最大面积
 * 比如[2,1,5,6,2,3],所能组成的最大面积为10
 */
public class LargerScale {

	public static void main(String[] args) {
		LargerScale test = new LargerScale();
		int[] height = {2,1,5,6,2,3};
//		int res = test.calLargerScale(height);
		int res = test.calLargerScale01(height);
		System.out.println(res);
	}
	//暴力破解法，必须先排序，或者在这中间做一点改变
	public int calLargerScale(int[] height){
		int length = height.length;
		Arrays.sort(height);
		int maxScale = 0;
		int nowScale = 0;
		for(int i = 0; i<length; i++){
			for(int j = i+1; j<length; j++){
				if(height[i]>=height[j]){
					nowScale = height[j]*(j-i+1);
				}else{
					nowScale = height[i]*(j-i+1);
				}
				maxScale = Math.max(nowScale, maxScale);
			}
		}
		return maxScale;
	}
	//从每一个元素开始，向左右遍历，直到遇到比这个元素小的，停止，计算面积
	public int calLargerScale01(int[] height){
		int length = height.length;
		int maxScale = 0;
		int nowScale = 0;
		for(int i = 0; i<length; i++){
			int value = height[i];
			int j = i-1;
			while(j>=0){
				if(height[j]<=height[i]){
					nowScale = height[j]*(i-j+1);
					maxScale = Math.max(nowScale, maxScale);
					break;
				}else{
					j--;
				}
			}
			j = i+1;
			while(j<length){
				if(height[j]<=height[i]){
					nowScale = height[j]*(j-i+1);
					maxScale = Math.max(nowScale, maxScale);
					break;
				}else{
					j++;
				}
			}
		}
		return maxScale;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
package cn.itcast.algorithm.dynamic;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月3日 下午2:49:01
 * 求一个数组的最大子序列中的值相加最大
 * 比如[-2,1,-3,4,-1,2,1,-5,4]  [4,-1,2,1]  sum=6
 * 参考13.2
 */
public class MaxSubArray {

	public static void main(String[] args) {
		MaxSubArray test = new MaxSubArray();
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int res = test.maxSum(arr);
		System.out.println(res);
	}
	
	public int maxSum(int[] arr){
		int length = arr.length;
		int[] f = new int[length];
		int max = 0;
		for(int i=0; i<length; i++){
			if(i==0){
				f[i] = arr[i];
				max = f[i];
			}else{
				f[i] = Math.max(f[i-1]+arr[i], arr[i]);
				max = Math.max(max, f[i]);
			}
		}
		return max;
	}
	public int maxSum01(int[] arr){
		int length = arr.length;
		int f = 0;
		int max = 0;
		for(int i=0; i<length; i++){
			f = Math.max(f+arr[i], arr[i]);
			max = Math.max(max, f);
		}
		return max;
	}
}

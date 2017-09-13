package cn.itcast.algorithm.greedy;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月10日 上午10:42:39
 * 给定一个整型数组，其中(i,arr[i])表示(i,0)到(i,arr[i])的一条直线，该线代表木板的长度，宽度不计。找到两条线，
 * 使这两条线之间装水最多
 * 解释：
 * 当左端线段L小于右端线段R时，我们把L右移，这时舍弃的是L与右端其他线段（R-1, R-2, ...）组成的木桶，
 * 这些木桶是没必要判断的，因为这些木桶的容积肯定都没有L和R组成的木桶容积大。
 */
public class ContainWater {

	public int mostWater(int[] arr){
		int start = 0;
		int end = arr.length-1;
		int max = Integer.MIN_VALUE;
		while(start<end){
			max = Math.min(arr[start], arr[end])*(end-start);
			if(arr[start]<=arr[end]){
				start++;
			}else{
				end--;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		
	}
}

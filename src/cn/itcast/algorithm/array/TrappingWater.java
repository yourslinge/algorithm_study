package cn.itcast.algorithm.array;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月5日 上午9:28:50
 * 给定一个整数数组，代表木板高度，每个木板的宽度均为1，将这些木板按数组中顺序竖起，问能装多少水
 * 思路：
 * 求每个木板的左右两边高度最高的木板max_left、max_right,则该块木板能装Math.min(max_left,max_right)-该木板的高度;
 */
public class TrappingWater {

	public int water(int[] arr){
		int length = arr.length;
		int water = 0;
		//备注：第0、length-1块木板都没有意义，以为其左边或者右边都没有木板，怎么装水
		for(int i=1;i<length-1;i++){
			int maxLeft = returnLen(arr, 0, i-1);
			int maxRight = returnLen(arr, i+1, length-1);
			int temp = Math.min(maxLeft, maxRight)-arr[i];
			// 由我们returnLen()方法，可以看出如果两边均有一边的均小于当前木板长度，那算出来就是负数啦，比如第一块木板
			if(temp>=0){
				water +=temp;
			}
		}
		return water;
	}
	/**
	 * 搜寻区间[first,last]的最大值 
	 */
	public int returnLen(int[] arr,int first,int last){
		int length = arr.length;
		int max = arr[first];
		for(int i=first+1; i<=last;i++){
			if(arr[i]>=max){
				max = arr[i];
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		TrappingWater test = new TrappingWater();
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		int res = test.water(arr);
		System.out.println(res);
	}
}

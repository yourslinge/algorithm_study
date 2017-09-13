package cn.itcast.algorithm.greedy;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月8日 下午8:14:49
 * 一个整数数组，每个元素代表你可以向上爬的最大步数。
 * 用贪婪算法：每一个台阶，你都选择最大的步数前进，只要能到，那么代表你肯定可以到达
 */
public class JumpGame {

	public boolean canReach(int[] arr){
		int length = arr.length;
		int step = arr[0];
		for(int i = 1; i<length; i++){
			// 看step和遍历完元素，能不能完成，完成代表你可以到达
			// 这个过程可以缩短，就是如果step大于剩下要遍历的元素个数，那么就可以提前结束，代表你可以到达，不用遍历下去了
			if(step>0){
				step--;
				step = Math.max(step, arr[i]);
				if(step>length-i-1){
					return true;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	// 使用动态规划，f[i]表示，从0出发，走到arr[i]时,还剩余的最大步数
	public boolean canReachDynamic(int[] arr){
		int length = arr.length;
		int[] f = new int[length];
		f[0] = 0;
		for(int i = 1; i<length; i++){
			f[i] = Math.max(f[i-1], arr[i-1])-1;
			if(f[i]<0) {
				return false;
			}
		}
		return f[length-1]>=0;
	}
	
	public static void main(String[] args) {
		JumpGame test = new JumpGame();
//		int[] arr = {2,3,1,1,4};
		int[] arr = {3,2,1,0,4};
		boolean res = test.canReach(arr);
		System.out.println(res);
	}
}

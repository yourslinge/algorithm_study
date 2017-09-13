package cn.itcast.algorithm.array;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月6日 下午3:26:01
 * 有N个煤气站，组成一个环形，每个煤气站储存了gas[i]数量的煤气.你开车携带一个不限量的煤气罐装煤气，从煤气站i到下一个站，
 * 需要消耗cost[i]数量的煤气。开始时，你的煤气罐是空的
 * 求：你从哪一个煤气站开始，可以沿着环形跑一圈
 * sum来判断从当前站出发是否可行；total来判断是否具有可行解，也即是总的煤气储量减去跑一圈的消耗量是否大于0；
 * j代表从哪个煤气站开始的
 */
public class GasStation {

	public int returnStart(int[] gas,int[] cost){
		int gasLen = gas.length;
		int costLen = cost.length;
		int sum =0, total = 0, j=-1;
		for(int i = 0; i<gasLen; i++){
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if(sum<0){//说明从当前煤气站出发失败
				j = i;
				sum = 0;
			}
		}
		return total>=0?j+1:-1;
	}
	
	public static void main(String[] args) {
		
	}
}

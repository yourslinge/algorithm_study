package cn.itcast.algorithm.array;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月5日 下午6:25:42
 * 每次可以向上爬1步或者两步，问爬上n阶台阶需要多少步
 */
public class ClimbStairs {

	public int times(int n){
		int[] f = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		f[2] = 2;  // 爬到第二级台阶有两种方法：①从初始0台阶爬2步到第1级台阶
		                              //  ②从初始0台阶爬1步到第一级台阶，再从第1级台阶爬1步到第2级台阶
		for(int i=3; i<=n; i++){
			f[i] = f[i-1]+f[i-2];//
		}
		return f[n];
	}
	
	public static void main(String[] args) {
		ClimbStairs test = new ClimbStairs();
		int res = test.times(3);
		System.out.println(res);
	}
}

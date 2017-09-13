package cn.itcast.algorithm.greedy;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月8日 下午8:14:49
 * 一个整数数组，每个元素代表你可以向上爬的最大步数。
 * 用贪婪算法：每一个台阶，你都选择最大的步数前进，只要能到，那么代表你肯定可以到达
 * 求到达的最短路径int[] arr = {2,3,1,1,4};，从0跳1步到1，再从1跳3到最后。只需两次
 * 对于第一个元素2，它所能走的范围是[1,2]
 * 对于第二个元素3，它所能走的范围是[3,4]，为什么区间以3开始呢？你看，元素2可以到达[1,2],元素3可以到达[2,4];
 * 但是我们已经在元素2的范围选择最大的了，即1对于的元素3，所以该区间没有用了
 * 对于第三个元素1，它所能走的范围是[3,3]
 * 因为元素3、1，通过元素2都可以达到，所以从元素3、1中选择一个能够最远达到的距离4(元素3最远可以跑到4，元素1最远可以跑到3)；
 * 
 */
public class JumpGameII {

	public int canReach(int[] arr){
		int length = arr.length;
		int left = 0;
		int right = 0;
		int step = 0;
		while(left<=right){
			step++;
			int oldRight = right; //记录当前区间的right
			for(int i=left; i<=oldRight; i++){
				int newRight = i+arr[i];
				//注意
				if(newRight>=length-1) return step; 
				if(newRight>right) right = newRight;//更新right，形成新区间的right
			}
			left = oldRight+1;//更新left，形成新区间的right
		}
		return 0;//返回0，代表不可达
	}
	
	public static void main(String[] args) {
		JumpGameII test = new JumpGameII();
		int[] arr = {2,3,1,1,4};
//		int[] arr = {3,2,1,0,4};
		int res = test.canReach(arr);
		System.out.println(res);
	}
}

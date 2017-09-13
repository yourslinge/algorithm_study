package cn.itcast.algorithm.dynamic;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月3日 下午1:11:56
 * 给一个三角形，找到从头到尾的最小路径，每次移动的到相邻的下一行元素
 * [
 *     [2]        0
 *    [3,4]       1
 *   [6,5,7]      2
 * 	[4,1,8,3]     3
 * ]
 * 最小路径为2+3+5+1=11
 * 定义f(i,j)，表示从(i,j)出发所需的最小路径值，先从第2层开始往最底层3层算，倒着算
 */
public class TriangleMin {

	public static void main(String[] args) {
		TriangleMin test = new TriangleMin();
		int[][] arr = new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};
		int res = test.minPath(arr);
		System.out.println(res);
//		System.out.println(arr[3][3]);
		
	}
	
	public int minPath(int[][] arr){
		int length = arr.length;
		for(int i=length-2; i>=0;--i){
			for(int j=0;j<i+1; ++j){
				arr[i][j] += Math.min(arr[i+1][j], arr[i+1][j+1]);
			}
		}
		return arr[0][0];
	}
}

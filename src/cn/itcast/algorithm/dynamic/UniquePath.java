package cn.itcast.algorithm.dynamic;

import java.util.Arrays;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月9日 上午9:41:59
 * 给一个m*n的网格，起点在(0,0),终点为(m-1,n-1),每次只能向下或者向右移动，求到终点的所有路径
 */
public class UniquePath {

	public int paths(int m, int n){
		int[][] f = new int[m][n];
		for(int i = 0; i<m; i++){//控制行
			f[i][0] = 1;// (0,0)->(1,0)(2,0)..(i,0)只存在一条路，一直向下走
			for(int j = 1; j<n; j++){//控制列
				if(i==0){
					f[i][j] = 1;//(0,0)->(0，1)(0,2)..(0,j)只存在一条路，一直向右走
				}else{
					f[i][j] = f[i][j-1]+f[i-1][j];
				}
			}
		}
		return f[m-1][n-1];
	}
	// 给定一个网格，网格中的每个整数代表消耗的能量，求从(0,0)-->(m-1,n-1)选择哪条路线，消耗的能量最少
	//当前消耗的最小能量=前面的最小能量+当前消耗的能量：f[i][0] = arr[i][0]+f[i-1][0];
	public int[][] minPaths(int[][] arr){
		int m = arr.length;
		int n = arr[0].length;
		int[][] f = new int[m][m];
		// 每一行每一行的算值
		for(int i = 0; i<m; i++){
			if(i==0){
				f[0][0] = arr[0][0];
			}else{
				f[i][0] = arr[i][0]+f[i-1][0];
			}
			for(int j = 1; j<n; j++){
				if(i==0){
					f[i][j] = arr[i][j]+f[i][j-1];
				}else{
					f[i][j] = Math.min(f[i][j-1],f[i-1][j])+arr[i][j];
				}
			}
		}
//		return f[m-1][n-1];
		return f;
	}
	
	public static void main(String[] args) {
		UniquePath test = new UniquePath();
//		int m = 2,n =2;
//		int res = test.paths(m, n);
//		System.out.println(res);
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] res = test.minPaths(arr);
		for(int i = 0; i<3;i++){
			System.out.println(Arrays.toString(res[i]));
			
		}
	}
}

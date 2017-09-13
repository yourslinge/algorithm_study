package cn.itcast.algorithm.netbase;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月11日 下午1:59:29
 */
public class Lesson02 {
	
	public static int times(int n){
		int m = (int) Math.sqrt(n);
		boolean bool = Math.sqrt(n)%m==0?true:false;// 为了防止类似于18的操作，他的开根号，不是整数
		int times = 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i<=m; i++){
			map.put(i*i, i);
		}
		if(!bool){
			map.remove(m*m);
		}
		for(int i = 0; i<=m; i++){
			if(i==0&&map.containsKey(n)){
				times += 4;
				map.remove(n);
				map.remove(0);
				continue;
			}
			if(map.containsKey(n-i*i)){
				map.remove(i*i);
				map.remove(n-i*i);
				if(i*i*2==n){// 半径的平方为18时，只有(3,3)(3,-3)(-3,3)(-3,-3),四种，即x==y 4种；反之，8种
					times +=4;
				}else{
					times +=8;
				}
			}
		}
		
		return times;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(times(n));
		}
		sc.close();
	}
}

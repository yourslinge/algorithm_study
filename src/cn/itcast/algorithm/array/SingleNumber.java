package cn.itcast.algorithm.array;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月5日 下午8:28:12
 * 1.一个数组中保存了整型的数，除了其中一个数只出现一次外，其他数均出现两次,请找到这个仅出现1次的数
 * 异或：相同为0，不同为1，两个相同的数异或为0
 * 上述1的解题代码和思路可以延伸到：一个数组中只有一个数出现一次，其他数均出现偶数次
 * 
 * 2.一个数组中保存了整型的数，除了其中一个数只出现一次外，其他数均出现三次,请找到这个仅出现1次的数
 * 二进制模拟三进制
 * 上述2的解题代码和思路可以延伸到：一个数组中只有一个数出现一次，其他数均出现3的倍数次
 * 
 */
public class SingleNumber {

	public int findOneInTwice(int[] arr){
		int x = 0;
		for (int i : arr) {
			x^=i;
		}
		return x;
	}
	public int findOneInThree(int[] arr){
		//one 记录到目前为止 二进制1 出现1次的有哪些二进制位
		//two 记录到目前为止 二进制1 出现2次的有哪些二进制位
		//当one和two的某个相同位置上均出现1时，代表该位上1出现了3次，此时需清零
		int one = 0, two = 0, three = 0;
		for (int x : arr) {
			two |= (one&x);
			one ^= x;
			three = ~(one&two);
			one &= three;
			two &= three;
		}
		return one;
	}
	public static void main(String[] args) {
		SingleNumber test = new SingleNumber();
		int[] arr = {1,1,1,1,2,4,4,4,4,5,5,5,5};
		int res = test.findOneInTwice(arr);
		System.out.println(res);
//		int[] arr1 = {1,1,1,2,2,2,4,5,5,5,6,6,6,7,7,7};
//		int res1 = test.findOneInThree(arr1);
//		System.out.println(res1);
	}
}

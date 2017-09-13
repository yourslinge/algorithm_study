package cn.itcast.algorithm.string;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年7月27日 下午8:15:48
 * f[j][i]:表示区间[j,i]是否为回文，j<=i的，所以j应该从0~i,i则是字符串的长度
 */
public class LongPalindrome {

	public static void main(String[] args) {
		LongPalindrome test = new LongPalindrome();
		String str = "acghnacdbcgcbdcahjkhgca";
		String res = test.longPalindrome(str);
		System.out.println(res);
	}
	
	public String longPalindrome(String str){
		int length = str.length();
		int max_len = 1,start = 0;
		boolean[][] f = new boolean[length][length];
		for(int i=0; i<length; i++){
			f[i][i] = true;
			for(int j = 0; j<i; j++){
				f[j][i] = (str.charAt(j)==str.charAt(i)&&(i-j<2||f[j+1][i-1]));
				if(f[j][i]&&max_len<(i-j+1)){
					max_len = i-j+1;
					start = j;
				}
			}
		}
		return str.substring(start, max_len);
	}
}

package cn.itcast.algorithm.string;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年4月2日 上午9:08:03
 * KMP为的是解决2字符串匹配问题的算法，检查一个字符串是否为另一个的子串，sub = "abc" , str = "aabcd" 
 * str里包含了一个sub，KMP算法可以以O(M+N)的复杂度找到子串在str的位置。
 */
public class KMPalgorithm {
	//KMP中的核心算法，获得记录跳转状态的next数组
	public static int[] next(String sub) {
		int[] a = new int[sub.length()];
		char[] c = sub.toCharArray();
		int length = sub.length();
		int i, j;
		a[0] = -1;
		i = 0;
		for (j = 1; j < length; j++) {
			i = a[j - 1];
			while (i >= 0 && c[j] != c[i + 1]) {
				i = a[i];
			}
			if (c[j] == c[i + 1]) {
				a[j] = i + 1;
			} else {
				a[j] = -1;
			}
		}
		return a;
	}
	/**
	 * 
	 * @param str 主字符串
	 * @param sub 需要判定的字符串
	 * @param next
	 */
	public static int pattern(String str,String sub,int[] next) {
        char[] ch1 = str.toCharArray();
        char[] ch2 = sub.toCharArray();
        int i = 0,j = 0;  //i控制ch1,j控制ch2;
        for(;i<ch1.length; ) {
            if(ch1[i]==ch2[j]) {//匹配就自动递增，往后匹配。
                if(j==ch2.length-1) {
                    return i-ch2.length+1;
                }
                j++;
                i++;
            }
            else if(j==0) {
                 i++;
            }
            else {
                j = next[j-1]+1;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		String sub = "agctaagctagctg";
        String str = "gdsaadfdgffccsdagctagcagctagctgbaccfaddddaabcga";
        int[] next = next(sub);
//        for (int i : next) {
//			System.out.print(i+" ");
//		}
        int res = pattern(str,sub,next);
        System.out.print(res);
	}
	
}

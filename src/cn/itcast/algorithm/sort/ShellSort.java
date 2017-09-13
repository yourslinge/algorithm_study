package cn.itcast.algorithm.sort;

import java.util.Arrays;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年4月3日 下午3:08:10
 * 时间复杂度为：N(N*logN)
 */
public class ShellSort {

	 /** 
     * 对于n个整数排序，将这列数按d1增量分组，对各个分组进行直接插入排序，然后缩小增量，重新分组，对分组排序，
     * 直到增量值为1时停止。 
     * 希尔排序是插入排序算法的一种。又称 缩小增量排序 时间复杂度为O(nlog n)  
     * 不稳定排序方式 
     * @param nums 待排序数组 
     * @return 输出有序数组 
     */  
    public static void sort(int[] nums) {  
        int len = nums.length / 2;  
        while (len >=1) {  
            for (int i = 0; i < len; i++) {  
                // 直接插入排序对分组进行排序  
                for (int k = i; k < nums.length-len; k +=len) {  
                    int j = k + len;  
                    int temp = nums[j];  
  
                    while (k >= 0 && nums[k] > temp) {  
                        nums[j] = nums[k];  
                        k -= len;  
                        j -= len;  
                    }  
  
                    nums[j] = temp;  
                }  
            }  
            len = len/2;  
        }  
    }
    public static void main(String[] args) {  
    	  
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };  
        sort(nums);  
        System.out.println(Arrays.toString(nums));  
    }  
}

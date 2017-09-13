package cn.itcast.algorithm.sort;

import java.util.Arrays;

/**
 * @author linge E-mail:
 * @version Created on 2017年4月3日 下午3:32:19 
 * 时间复杂度为：O(N*logN)
 * 初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个 堆，这时堆的根节点的数最大。
 * [13, 78, 65, 49, 76, 64, 27, 49, 38, 34, 12, 97]
 * [12, 76, 65, 49, 34, 64, 27, 49, 38, 13, 78, 97]
 * [13, 49, 65, 49, 34, 64, 27, 12, 38, 76, 78, 97]
 * [38, 49, 64, 49, 34, 13, 27, 12, 65, 76, 78, 97]
 * [12, 49, 38, 49, 34, 13, 27, 64, 65, 76, 78, 97]
 * [27, 49, 38, 12, 34, 13, 49, 64, 65, 76, 78, 97]
 * [13, 34, 38, 12, 27, 49, 49, 64, 65, 76, 78, 97]
 * [27, 34, 13, 12, 38, 49, 49, 64, 65, 76, 78, 97]
 * [12, 27, 13, 34, 38, 49, 49, 64, 65, 76, 78, 97]
 * [13, 12, 27, 34, 38, 49, 49, 64, 65, 76, 78, 97]
 * [12, 13, 27, 34, 38, 49, 49, 64, 65, 76, 78, 97]
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64 };
		int arrayLength = a.length;
		// 循环建堆
		for (int i = 0; i < arrayLength - 1; i++) {
			// 建堆
			buildMaxHeap(a, arrayLength - 1 - i);
			// 交换堆顶和最后一个元素
			swap(a, 0, arrayLength - 1 - i);
			System.out.println(Arrays.toString(a));
		}
	}

	// 对data数组从0到lastIndex建大顶堆
	public static void buildMaxHeap(int[] data, int lastIndex) {
		// 从lastIndex处节点（最后一个节点）的父节点开始
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// k保存正在判断的节点
			int k = i;
			// 如果当前k节点的子节点存在
			while (k * 2 + 1 <= lastIndex) {
				// k节点的左子节点的索引
				int biggerIndex = 2 * k + 1;
				// 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
				if (biggerIndex < lastIndex) {
					// 若果右子节点的值较大
					if (data[biggerIndex] < data[biggerIndex + 1]) {
						// biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}
				}
				// 如果k节点的值小于其较大的子节点的值
				if (data[k] < data[biggerIndex]) {
					// 交换他们
					swap(data, k, biggerIndex);
					// 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}

	// 交换
	private static void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}

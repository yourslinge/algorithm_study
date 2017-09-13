package cn.itcast.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月2日 下午7:04:08
 * 判断两棵二叉树是否相同：①节点值相等；②树结构相同；
 * 思路：
 *  用任意一种遍历算法来遍历两棵树，判断结构和节点值
 */
public class SameTree {
	public class TreeNode{
		int data;
		TreeNode leftChild;
		TreeNode rightChild;
		public TreeNode(int newData){
			this.data = newData;
			leftChild = null;
			rightChild = null;
		}
	}
	
	public TreeNode createBinaryTree(int[] arr){
		List<TreeNode> list = new LinkedList<TreeNode>();
		for(int i = 0;i < arr.length;i++){
			list.add(new TreeNode(arr[i]));
		}
		for(int parentIndex = 0;parentIndex<list.size()/2 -1;parentIndex++){
			list.get(parentIndex).leftChild = list.get(parentIndex*2+1);
			list.get(parentIndex).rightChild = list.get(parentIndex*2+2);
		}
		
		int lastParentIndex = list.size()/2 - 1;
		list.get(lastParentIndex).leftChild = list.get(lastParentIndex*2 + 1);
		if(list.size() % 2 == 1){
			list.get(lastParentIndex).rightChild = list.get(lastParentIndex*2 + 2);
		}
		return list.get(0);
	}
	public boolean isSame(TreeNode root1,TreeNode root2){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root1);
		stack.push(root2);
		while(stack.isEmpty() == false){
			TreeNode node2 = stack.pop();
			TreeNode node1 = stack.pop();
			if(node2.data==node1.data){
				if(node1.rightChild!=null&&node2.rightChild!=null){
					stack.push(node1.rightChild);
					stack.push(node2.rightChild);
				}else if(node1.rightChild!=null&&node2.rightChild==null){
					return false;
				}else if(node1.rightChild==null&&node2.rightChild!=null){
					return false;
				}
				if(node1.leftChild!=null&&node2.leftChild!=null){
					stack.push(node1.leftChild);
					stack.push(node2.leftChild);
				}else if(node1.leftChild!=null&&node2.leftChild==null){
					return false;
				}else if(node1.leftChild==null&&node2.leftChild!=null){
					return false;
				}
				
			}else{
				return false;
			}
		}
		
		
		return true;
	}
	
	public static void main(String[] args) {
		SameTree tree = new SameTree();
		int[] arr1 = {1,2,3,4,5,6,7,8,9};
		int[] arr2 = {1,2,3,4,5,6,7,8};
		TreeNode root1 = tree.createBinaryTree(arr1);
		TreeNode root2 = tree.createBinaryTree(arr2);
		boolean res = tree.isSame(root1, root2);
		System.out.println(res);
	}
}

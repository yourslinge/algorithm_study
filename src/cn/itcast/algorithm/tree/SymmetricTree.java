package cn.itcast.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import cn.itcast.algorithm.tree.SameTree.TreeNode;

/**
 * @author linge E-mail:
 * @version 
 * Created on 2017年8月2日 下午8:04:30
 * 判断二叉树是否为对称树,对称树的前提是这个二叉树肯定是满二叉树
 * 如              1
 *     2      2
 *   3   4  4   3   为对称树
 * 做法：除去二叉树头节点，可以将二叉树看成是头节点、左子树和右子树三部分组成的，
 *      分别对左右子树进行判断，用SameTree中判断的方法
 */
public class SymmetricTree {
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
	
	public boolean isSymmetic(TreeNode root1,TreeNode root2){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root1);
		stack.push(root2);
		while(stack.isEmpty()==false){
			TreeNode node2 = stack.pop();
			TreeNode node1 = stack.pop();
			if(node2.data==node1.data){
				if(node1.rightChild!=null&&node2.leftChild!=null){
					stack.push(node1.rightChild);
					stack.push(node2.leftChild);
				}else if(node1.rightChild!=null&&node2.leftChild==null){
					return false;
				}else if(node1.rightChild==null&&node2.leftChild!=null){
					return false;
				}
				
				if(node1.leftChild!=null&&node2.rightChild!=null){
					stack.push(node1.leftChild);
					stack.push(node2.rightChild);
				}else if(node1.leftChild!=null&&node2.rightChild==null){
					return false;
				}else if(node1.leftChild==null&&node2.rightChild!=null){
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		SymmetricTree tree = new SymmetricTree();
		int[] arr = {1,2,2,3,4,4,3};
		TreeNode root = tree.createBinaryTree(arr);
		boolean res = tree.isSymmetic(root.leftChild, root.rightChild );
		System.out.println(res);
	}
	
	
	
	
	
}

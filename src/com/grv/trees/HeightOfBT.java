package com.grv.trees;

public class HeightOfBT {

	
	public int getHeight(BinaryTreeNode root){
		
		if(root==null) return 0;
		

			int leftHeight= getHeight(root.left);
			int rightHeight= getHeight(root.right);

		
		if(leftHeight>rightHeight) return leftHeight+1;
		else return rightHeight+1;
		
	}

}

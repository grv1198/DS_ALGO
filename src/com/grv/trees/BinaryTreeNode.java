package com.grv.trees;

public class BinaryTreeNode {
 int data;

 BinaryTreeNode left;
 BinaryTreeNode right;
 int numOfChildren;

	public BinaryTreeNode(int data) {
		this.data = data;
	}

	public BinaryTreeNode() {

	}
	public int getData() {
	return data;
}
public void setData(int data) {
	this.data = data;
}
public BinaryTreeNode getLeft() {
	return left;
}
public void setLeft(BinaryTreeNode left) {
	this.left = left;
}
public BinaryTreeNode getRight() {
	return right;
}
public void setRight(BinaryTreeNode right) {
	this.right = right;
}

public int getNumOfChildren(){
	return numOfChildren;
}

public void setNumOfChildren(int n){

this.numOfChildren=n;
}


public Boolean isLeaf(){
 return numOfChildren>0;	
	
}

}

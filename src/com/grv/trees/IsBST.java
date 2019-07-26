package com.grv.trees;

public class IsBST {


    public Boolean checkBST(BinaryTreeNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public Boolean isBSTUtil(BinaryTreeNode node, int min, int max) {

    //base case
        if(node==null)
            return true;


        if(node.getData() <= min || node.getData()>max){
            return  false;
        }

        return isBSTUtil(node.getLeft(), min, node.getData())&& isBSTUtil(node.getRight(), node.getData(), max);

    }


}

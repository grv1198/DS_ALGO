package com.grv.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderFastRecursive {

    public List<List<Integer>> levelOrder(BinaryTreeNode root) {


        List<List<Integer>> res = new ArrayList<>();

        levelOrder(root, res, 0);
        return res;
    }

    private void levelOrder(BinaryTreeNode curr, List<List<Integer>> res, int level) {
        if(curr == null) return;


        if(res.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            res.add(newLevel);
        }


        List<Integer> levelList = res.get(level);
        levelList.add(curr.data);


        levelOrder(curr.left, res, level+1);
        levelOrder(curr.right, res, level+1);
    }
}

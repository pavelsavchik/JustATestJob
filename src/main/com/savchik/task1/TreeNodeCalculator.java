package main.com.savchik.task1;

import java.util.ArrayList;

import java.util.List;

public class TreeNodeCalculator {
    public static void main(String[] args) {
        TreeNode parent = new TreeNode();

        List<TreeNode> children = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            children.add(new TreeNode());
        }

        parent.addChild(
                children.get(0).addChild(
                        children.get(2)
                ).addChild(
                        children.get(3).addChild(
                                children.get(4).addChild(
                                        children.get(5)
                                )
                        )
                )
        ).addChild(
                children.get(6).addChild(
                        children.get(7).addChild(
                                children.get(8)
                        )
                ).addChild(
                        children.get(9)
                )
        );

        //Something like fast tests
        //Need to run with -ea parameter to enable asserts
        assert calculateTreeHeight(parent) == 5;
        assert calculateTreeHeight(children.get(6)) == 3;
        assert calculateTreeHeight(children.get(9)) == 1;
        assert calculateTreeHeight(children.get(4)) == 2;
        assert calculateTreeHeight(null) == 0;

        System.out.println("I'm tree. I'm good.");
    }

    public static int calculateTreeHeight(TreeNode parentNode) {
        if (parentNode == null) {
            return 0;
        }

        int maxChildHeight = 0;

        for (int i = 0; i < parentNode.getChildren().size(); i++) {
            int currentChildHeight = calculateTreeHeight(parentNode.getChild(i));
            maxChildHeight = Math.max(currentChildHeight, maxChildHeight);
        }

        return maxChildHeight + 1;
    }
}

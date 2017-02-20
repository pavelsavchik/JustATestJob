package main.com.savchik.task1;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private List<TreeNode> children;

    public TreeNode() {
        this.children = new ArrayList<>();
    }

    public TreeNode addChild(TreeNode child) {
        children.add(child);
        return this;
    }

    public List<TreeNode> getChildren() {
        return this.children;
    }

    public TreeNode getChild(int index) {
        if(index < this.children.size()) {
            return this.children.get(index);
        } else {
            return null;
        }
    }
}

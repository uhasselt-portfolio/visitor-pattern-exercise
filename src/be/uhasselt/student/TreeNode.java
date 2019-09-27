package be.uhasselt.student;

import java.util.ArrayList;

/**
 * @author Michiel Swaanen
 */
public class TreeNode {

    private ArrayList<TreeNode> children;
    private TreeNode parent;
    private String name;
    private int level;

    public TreeNode(String name) {
        this.children = new ArrayList<>();
        this.parent = null;
        this.name = name;
        this.level = 1;
    }

    /**
     * Set a node as parent
     * @param parent the parent of the node
     */
    private void setParent(TreeNode parent) {
        this.parent = parent;
        this.level = parent.getLevel() + 1;
    }

    /**
     * Set the underlying nodes (children)
     * @param children the children of the node
     */
    public void addChildren(TreeNode... children) {
        for(TreeNode child : children) {
            child.setParent(this);
            this.children.add(child);
        }
    }

    public ArrayList<TreeNode> getChildren() {
        return this.children;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }
}

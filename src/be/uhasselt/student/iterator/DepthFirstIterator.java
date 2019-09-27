package be.uhasselt.student.iterator;

import be.uhasselt.student.TreeNode;
import be.uhasselt.student.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michiel Swaanen
 */
public class DepthFirstIterator implements Iterator {

    private TreeNode root;

    public DepthFirstIterator(TreeNode root) {
        this.root = root;
    }

    /**
     * @see Iterator
     * @return list of nodes, sorted using the depth-first pattern
     */
    @Override
    public ArrayList<TreeNode> iterate() {
        ArrayList<TreeNode> tree = new ArrayList<>(List.of(this.root));
        ArrayList<TreeNode> nodeCollection = new ArrayList<>();
        depthFirstAlgorithm(nodeCollection, tree);
        return nodeCollection;
    }

    /**
     * @see Iterator
     * @param visitor Which visitor (action) do you want to apply when visit() is used
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * Depth-first algorithm (Recursive)
     * @link https://nl.wikipedia.org/wiki/Depth-first_search
     * @param collection the list to contain the depth-first algorithm
     * @param tree the list with nodes
     */
    private void depthFirstAlgorithm(ArrayList<TreeNode> collection, ArrayList<TreeNode> tree) {
        for (TreeNode node : tree) {
            collection.add(node);
            if(node.getChildren().size() >= 1)
                depthFirstAlgorithm(collection, node.getChildren());
        }
    }
}

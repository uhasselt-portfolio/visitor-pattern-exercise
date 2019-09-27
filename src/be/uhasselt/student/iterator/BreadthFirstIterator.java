package be.uhasselt.student.iterator;

import be.uhasselt.student.TreeNode;
import be.uhasselt.student.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michiel Swaanen
 */
public class BreadthFirstIterator implements Iterator {

    private TreeNode root;

    public BreadthFirstIterator(TreeNode root) {
        this.root = root;
    }

    /**
     * @see Iterator
     * @return list of nodes, sorted using the breadth-first pattern
     */
    @Override
    public ArrayList<TreeNode> iterate() {
        ArrayList<TreeNode> tree = new ArrayList<>(List.of(this.root));
        ArrayList<TreeNode> nodeCollection = new ArrayList<>();
        breadthFirstAlgorithm(nodeCollection, tree);
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
     * Breadth-first algorithm (Recursive)
     * @link https://nl.wikipedia.org/wiki/Breadth-first_search
     * @param collection the list to contain the breadth-first sorted elements
     * @param tree the list with the nodes
     */
    private void breadthFirstAlgorithm(ArrayList<TreeNode> collection, ArrayList<TreeNode> tree) {
        collection.addAll(tree);

        ArrayList<TreeNode> nextChildren = new ArrayList<>();

        for(TreeNode node : tree)
            nextChildren.addAll(node.getChildren());

        if(nextChildren.size() >= 1)
            breadthFirstAlgorithm(collection, nextChildren);
    }
}

package be.uhasselt.student.visitor;

import be.uhasselt.student.iterator.BreadthFirstIterator;
import be.uhasselt.student.iterator.DepthFirstIterator;
import be.uhasselt.student.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michiel Swaanen
 */
public class ConsoleExportVisitor implements Visitor {

    /**
     * @see Visitor
     * @param bi Specify an instance of the Breadth-first algorithm
     */
    @Override
    public void visit(BreadthFirstIterator bi) {
        ArrayList<TreeNode> list = bi.iterate();
        System.out.println("\n --- Breadth-first file export visitor --- \n");
        print(list);
    }

    /**
     * @see Visitor
     * @param di Specify an instance of the Depth-first algorithm
     */
    @Override
    public void visit(DepthFirstIterator di) {
        ArrayList<TreeNode> list = di.iterate();
        System.out.println("\n --- Depth-first console export visitor --- \n");
        print(list);
    }

    /**
     * Print the list to the console
     * @param list the list with a specific pattern applied
     */
    private void print(List<TreeNode> list) {
        String indent = "   ";
        for (TreeNode node: list) {
            System.out.println(indent.repeat(node.getLevel()) + node.getLevel() + ". " + node.getName());
        }
    }
}

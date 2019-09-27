package be.uhasselt.student.visitor;

import be.uhasselt.student.iterator.BreadthFirstIterator;
import be.uhasselt.student.iterator.DepthFirstIterator;
import be.uhasselt.student.TreeNode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Michiel Swaanen
 */
public class FileExportVisitor implements Visitor {

    /**
     * @see Visitor
     * @param bi Specify an instance of the Breadth-first algorithm
     */
    @Override
    public void visit(BreadthFirstIterator bi) {
        ArrayList<TreeNode> list = bi.iterate();
        System.out.println("\n --- Breadth-first file export visitor --- \n");
        write(list);
    }

    /**
     * @see Visitor
     * @param di Specify an instance of the Depth-first algorithm
     */
    @Override
    public void visit(DepthFirstIterator di) {
        ArrayList<TreeNode> list = di.iterate();
        System.out.println("\n --- Depth-first file export visitor --- \n");
        write(list);
    }

    /**
     * Write the list to a file
     * @param list the list with a specific pattern applied
     */
    private void write(ArrayList<TreeNode> list) {
        String indent = "   ";
        try(FileWriter fw = new FileWriter("export.txt", true)) {
            for (TreeNode node : list)
                fw.write(indent.repeat(node.getLevel()) + node.getLevel() + ". " + node.getName() + "\n");
        } catch(IOException e) {
            System.out.println("File error");
        }
    }
}

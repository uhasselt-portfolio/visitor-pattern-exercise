package be.uhasselt.student;

import be.uhasselt.student.iterator.BreadthFirstIterator;
import be.uhasselt.student.iterator.DepthFirstIterator;
import be.uhasselt.student.visitor.ConsoleExportVisitor;
import be.uhasselt.student.visitor.FileExportVisitor;

/**
 * @author Michiel Swaanen
 */
public class Main {

    public static void main(String[] args) {
	    TreeNode root = new TreeNode("Bob");

	    TreeNode child1 = new TreeNode("Bob - Child 1");
	    TreeNode child2 = new TreeNode("Bob - Child 2");
	    TreeNode child3 = new TreeNode("Bob - Child 3");

	    root.addChildren(child1, child2, child3);

	    //-----------------------------------

	    TreeNode child1Child1 = new TreeNode("Bob - Child 1 - Child 1");
	    TreeNode child1Child2 = new TreeNode("Bob - Child 1 - Child 2");

	    TreeNode child3Child1 = new TreeNode("Bob - Child 3 - Child 1");

		child1.addChildren(child1Child1, child1Child2);
		child3.addChildren(child3Child1);

		//-----------------------------------

		TreeNode childChildChild1 = new TreeNode("Bob - Child 1 - Child 1 - Child 1");

		child1Child1.addChildren(childChildChild1);

		//-----------------------------------

        /** Visitors **/
        ConsoleExportVisitor console = new ConsoleExportVisitor();
        FileExportVisitor file = new FileExportVisitor();

        /** Iterators (Visited) **/
        BreadthFirstIterator bi = new BreadthFirstIterator(root);
        DepthFirstIterator di = new DepthFirstIterator(root);

        /** Execution **/
        bi.accept(console);
        bi.accept(file);

        di.accept(console);
        di.accept(file);

    }
}

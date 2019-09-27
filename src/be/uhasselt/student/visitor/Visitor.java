package be.uhasselt.student.visitor;

import be.uhasselt.student.iterator.BreadthFirstIterator;
import be.uhasselt.student.iterator.DepthFirstIterator;

/**
 * @author Michiel Swaanen
 */
public interface Visitor {

    /**
     * Specify the code for the breadth-first iterator inside this function
     * @param bi Specify an instance of the Breadth-first algorithm
     */
    void visit(BreadthFirstIterator bi);

    /**
     * Specify the code for the depth-first iterator inside this function
     * @param di Specify an instance of the Depth-first algorithm
     */
    void visit(DepthFirstIterator di);

}

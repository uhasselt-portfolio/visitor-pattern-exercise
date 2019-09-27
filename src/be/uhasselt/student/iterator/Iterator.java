package be.uhasselt.student.iterator;

import be.uhasselt.student.TreeNode;
import be.uhasselt.student.visitor.Visitor;

import java.util.ArrayList;

/**
 * @author Michiel Swaanen
 */
public interface Iterator {

    /**
     * Iterates through the 'old' list and uses the underlying algorithm to position the element inside the new list
     * @return list of nodes, positioned by the underlying pattern
     */
    ArrayList<TreeNode> iterate();

    /**
     * The right version of visit() will be called
     * @param visitor Which visitor (action) do you want to apply when visit() is used
     */
    void accept(Visitor visitor);
}

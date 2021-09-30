import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.recursion.*;
import uk.ac.soton.ecs.comp1206.labtestlibrary.datastructure.Tree;

public class MinTree implements MinimumInTree{

    public static void main(String[] args){
        Tree tree = new Tree( 24,
                new Tree( 45,
                        null ,
                        new Tree(8, null , null) ) ,
                new Tree ( 17,
                        new Tree (74 , null , null ) ,
                        null ) );
        MinTree minTree = new MinTree();
        System.out.println("Minimum is: " + minTree.findMin(tree));
    }

    public int findMin(Tree tree){
		int smallest = tree.getVal();
		try {
            smallest = findMin(tree.left(), smallest);
        } catch (Exception e) {

        }
		try {
		    smallest = findMin(tree.right(), smallest);
        } catch (Exception e) {

        }
        return smallest;
    }

	public int findMin(Tree tree, int smallest) {
        if (tree.getVal() < smallest) {
            smallest = tree.getVal();
        }
        try {
            smallest = findMin(tree.left(), smallest);
        } catch (Exception e) {

        }
        try {
            smallest = findMin(tree.right(), smallest);
        }  catch (Exception e) {

        }
        return smallest;
    }
}
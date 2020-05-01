public class testBST {
    public static void printPostorder(BinarySearchTree.BinaryNode<Integer> node)
    {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }


    public static void printPreorder(BinarySearchTree.BinaryNode<Integer> node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }


    public static void printInorder(BinarySearchTree.BinaryNode<Integer> node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }


    public static void main(String[] args)
    {
        BetterBST<Integer> tree = new BetterBST<Integer>();
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);



        tree.prettyPrint();
        System.out.println("\n------------------------------------\n");
        System.out.println(tree.imbalance());

        System.out.println("\n------------------------------------\n");
        System.out.println(tree.height());

        System.out.println("\n------------------------------------\n");
        tree.mirror().prettyPrint();

        System.out.println("\n------------------------------------\n");
        System.out.println(tree.smallestGreaterThan(3));

    }
}

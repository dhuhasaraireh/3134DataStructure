public class TestPrintReversedLinkedLIst {
    public static void main(String[] args)
    {
        /* Start with the empty list. */
        LinkedList<Rectangle> list = new LinkedList<>();
        Rectangle B1 = new Rectangle(1, 1);
        Rectangle B2 = new Rectangle(2, 1);
        Rectangle B3 = new Rectangle(3, 1);
        Rectangle B4 = new Rectangle(4, 1);
        Rectangle B5 = new Rectangle(5, 1);
        Rectangle B6 = new Rectangle(6, 1);
        Rectangle B7 = new Rectangle(7, 1);
        Rectangle B8 = new Rectangle(8, 1);

        //
        // ******INSERTION******
        //

        // Insert the values
        list = list.insert(list, B1);
        list = list.insert(list, B2);
        list = list.insert(list, B3);
        list = list.insert(list, B4);
        list = list.insert(list, B5);
        list = list.insert(list, B6);
        list = list.insert(list, B7);
        list = list.insert(list, B8);

        list.printList(list);
        System.out.println("------------------------------------");
        list.printreverse(list);
        System.out.println("------------------------------------");
        System.out.println(list.length(list));
        System.out.println("------------------------------------");
        list.printL(list);



    }
}

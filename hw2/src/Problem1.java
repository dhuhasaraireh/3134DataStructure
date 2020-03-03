import java.util.*;

public class Problem1{
    public static void printLots(List L, List<Integer> P) {
        if(P.isEmpty() || L.isEmpty()) {
            System.out.println("Nothing in the list.");
        } else {
            for(int i=0; i<P.size(); i++) {
                Integer index_object = P.get(i);
                int index = index_object.intValue();
                System.out.println(L.get(index));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> P = new ArrayList<>();
        P.add(1);
        P.add(3);
        P.add(4);
        P.add(5);
        ArrayList<Rectangle > L = new ArrayList<>();
        Rectangle B0 = new Rectangle(1, 1);
        Rectangle B1 = new Rectangle(2, 1);
        Rectangle B2 = new Rectangle(3, 1);
        Rectangle B3 = new Rectangle(4, 1);
        Rectangle B4 = new Rectangle(5, 1);
        Rectangle B5 = new Rectangle(6, 1);
        Rectangle B6 = new Rectangle(7, 1);
        Rectangle B7 = new Rectangle(8, 1);

       L.add(B0);
       L.add(B1);
       L.add(B2);
       L.add(B3);
       L.add(B4);
       L.add(B5);
       L.add(B6);
       L.add(B7);

        printLots(L, P);





    }

}


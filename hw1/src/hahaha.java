public class hahaha {
    public static void main(String[] args) {
        Rectangle B0 = new Rectangle(1,1);
        Rectangle B1 = new Rectangle(2,1);
        Rectangle B2 = new Rectangle(1,3);
        Rectangle B3 = new Rectangle(3,2);
        Rectangle B4 = new Rectangle(2,4);
        Rectangle B5 = new Rectangle(3,3);
        Rectangle B6 = new Rectangle(1,5);
        Rectangle B7 = new Rectangle(5,2);

        Rectangle x = new Rectangle(1.5,1.5);
        Rectangle[] A = new Rectangle[] {B0, B1, B2, B3, B4, B5, B6, B7};

        GenericMethods G = new GenericMethods();
        int index1 = G.binarySearch(A, x);
        int index2 = G.linearSearch(A,x);
        System.out.println(index1);
        System.out.println(index2);


    }
}

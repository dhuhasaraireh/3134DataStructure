public class MyStructure {
    public static void main(String[] args) {
        Rectangle B0 = new Rectangle(1,1);
        Rectangle B1 = new Rectangle(2,1);
        Rectangle B2 = new Rectangle(3,1);
        Rectangle B3 = new Rectangle(4,1);
        Rectangle B4 = new Rectangle(5,1);
        Rectangle B5 = new Rectangle(6,1);
        Rectangle B6 = new Rectangle(7,1);
        Rectangle B7 = new Rectangle(8,1);
        MyStack<Rectangle> S = new MyStack<Rectangle>();

        S.push(B0);
        S.push(B1);
        S.push(B2);
        S.push(B3);
        S.push(B4);
        S.push(B5);
        S.push(B6);
        S.push(B7);

        while(S.isEmpty()==false) {
            System.out.println(S.size());
            System.out.println(S.pop().getLength());
        }

        System.out.println(S.peek());




    }
}

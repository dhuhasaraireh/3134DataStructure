public class TestTwoStacks {
    public static void main(String[] args) {
        TwoStacks<Rectangle> S = new TwoStacks<>(5);
        Rectangle B1 = new Rectangle(1, 1);
        Rectangle B2 = new Rectangle(2, 1);
        Rectangle B3 = new Rectangle(3, 1);
        Rectangle B4 = new Rectangle(4, 1);
        Rectangle B5 = new Rectangle(5, 1);
        Rectangle B6 = new Rectangle(6, 1);
        Rectangle B7 = new Rectangle(7, 1);
        Rectangle B8 = new Rectangle(8, 1);

        S.push1(B1);
        S.push1(B2);
        S.push1(B3);
        S.push1(B4);
        S.pop1();
        S.push2(B5);
        S.push2(B6);
        S.pop1();
        S.push2(B7);
        S.pop1();
        S.push1(B8);


        System.out.println(S.peek1());
        System.out.println(S.peek2());


        while(S.isEmpty1()==false) {
            System.out.println(S.pop1().getLength());
        }

        while(S.isEmpty2()==false) {
            System.out.println(S.pop2().getLength());
        }






















    }
}

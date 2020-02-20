public class MyQueueMain {
    public static void main(String[] args) {
        Rectangle B0 = new Rectangle(1,1);
        Rectangle B1 = new Rectangle(2,1);
        Rectangle B2 = new Rectangle(3,1);
        Rectangle B3 = new Rectangle(4,1);
        Rectangle B4 = new Rectangle(5,1);
        Rectangle B5 = new Rectangle(6,1);
        Rectangle B6 = new Rectangle(7,1);
        Rectangle B7 = new Rectangle(8,1);

        TwoStackQueue<Rectangle> Q= new TwoStackQueue<Rectangle>();
        Q.enqueue(B0);
        Q.enqueue(B1);
        Q.enqueue(B2);
        Q.enqueue(B3);
        Q.enqueue(B4);
        Q.enqueue(B5);
        Q.enqueue(B6);
        Q.enqueue(B7);


    }
}

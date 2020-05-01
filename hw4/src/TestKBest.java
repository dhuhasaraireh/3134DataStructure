import java.util.*;
public class TestKBest {
    public static void main( String [ ] args ) {
        KBestCounter<Integer> counter = new KBestCounter<>(3);
        counter.count(5);
        counter.count(6);
        counter.count(2);
        counter.count(1);
        counter.count(0);
        counter.count(27);

        System.out.println(counter.kbest().toString());
        System.out.println(counter.kbest().toString());
        System.out.println(counter.kbest().toString());


    }
}

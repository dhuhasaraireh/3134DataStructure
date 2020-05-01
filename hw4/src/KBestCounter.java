import sun.misc.Queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class KBestCounter<T extends Comparable<? super T>> implements KBest<T> {
    private PriorityQueue<T> queue;
    private int limit;

    KBestCounter(int k) {
        this.queue = new PriorityQueue<T>();
        this.limit = k;
    }

    public void count(T x) {
        queue.add(x);
        if(queue.size()>limit) {
            queue.poll();
        }
    }


    public List<T> kbest() {
        ArrayList<T>  arr = new ArrayList<T>();
        PriorityQueue<T> copy = new PriorityQueue<T>(this.queue);
        Iterator<T> itr = copy.iterator();
        while(itr.hasNext()) {
            arr.add(itr.next());
        }
        return arr;
    }

}
public class TwoStackQueue<T> implements TwoStackQueueInterface<T> {
    private MyStack<T> S1 = new MyStack<T>();
    private MyStack<T> S2 = new MyStack<T>();

    /**
     * All the items are stored in Stack1
     * @return size of Queue
     */
    public int size(){
        return S1.size();
    }


    /**
     * All the items are stored in Stack1
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return S1.isEmpty();
    }


    /**
     *  Adds an item x to the queue.
     * @param x
     */
    public void enqueue(T x) {
        S1.push(x);
    }


    /**
     *Removes an item from the queue.
     * The items are popped in the same order in which they are pushed.
     * @return the first element in the Queue
     */
    public T dequeue() {
        if(S1.isEmpty()==true) {
            throw new NullPointerException();
        }
        while(S1.isEmpty()==false) {
            S2.push(S1.pop());
        }
        T old = S2.pop();
        while(S2.isEmpty()==false) {
            S1.push(S2.pop());
        }
        return old;
    }


}

public class TwoStacks<T> {
    private T[] A;
    private int size1;
    private int size2;
    private int array_capacity;

    public TwoStacks(int capacity) {
        A = (T[]) new Object[capacity];
        array_capacity = capacity;
        size1 = 0;
        size2 = 0;
    }


    public T peek1() {
        return A[size1-1];
    }

    public T peek2() {
        return A[array_capacity-size2];
    }

    public T pop1() {
        if(size1==0) {
            NullPointerException err = new NullPointerException("Stack Under flow");
            throw err;
        }
        size1 = size1-1;
        T item = A[size1];
        return item;
    }

    public T pop2() {
        if(size2==0) {
            NullPointerException err = new NullPointerException("Stack Under flow");
            throw err;
        }
        T item=  A[array_capacity-size2];
        size2=size2-1;
        return item;
    }

    public void push1(T item) {
        if(size1+size2==array_capacity) {
            StackOverflowError exp = new StackOverflowError("Stack Overflow Error.");
            throw  exp;
        }
        A[size1] = item;
        size1 = size1+1;
    }


    public void push2(T item) {
        if(size1+size2==array_capacity) {
            StackOverflowError exp = new StackOverflowError("Stack Overflow Error.");
            throw  exp;
        }
        size2 = size2+1;
        A[array_capacity-size2] = item;
    }

    public int getSize1() {
        return size1;
    }


    public int getSize2() {
        return size2;
    }


    public boolean isEmpty1() {
        if(size1 == 0) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isEmpty2() {
        if(size2 == 0) {
            return true;
        } else {
            return false;
        }
    }

}



public class MyStack<T> implements MyStackInterface<T>{
    /**
     * Implement a stack in a class called MyStack that uses an array to
     store data and resizes the array when necessary. All methods should run in constant time,
     except when the array must be resized (this is still amortized constant time).
     */
    private static final int DEFAULT_CAPACITY = 10;
    private T [ ] theItems;
    private int theSize;

    /**
     * Construct an empty Stack.
     */
    public MyStack() {doClear();}


    /**
     * Change the size of this collection to zero.
     */
    public void clear( )
    {
        doClear( );
    }


    private void doClear( )
    {
        theSize = 0;
        ensureCapacity( DEFAULT_CAPACITY );
    }

    /**
     * Returns the number of items in this collection.
     * @return the number of items in this collection.
     */
    public int size( )
    {
        return theSize;
    }


    /**
     * Returns true if this collection is empty.
     * @return true if this collection is empty.
     */
    public boolean isEmpty( )
    {
        return size( ) == 0;
    }


    /**
     *  This method returns the element present at the top of the stack and then removes it.
     * @return  the element present at the top of the stack
     */
    public T pop() {
        if(theSize==0) {
            throw new NullPointerException("Stack underflow!!");
        }
        T old = theItems[theSize-1];
        theSize = theSize-1;
        return old;
    }

    /**
     *The method returns the element at the top of the Stack else
     *  returns NULL if the Stack is empty.
     * @return the element at the top of the Stack or  NULL if the Stack is empty.
     */
    public T peek() {
        if(theSize==0) {
            return null;
        } else {
            return theItems[theSize-1];
        }
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity( int newCapacity )
    {
        if( newCapacity < theSize )
            return;

        T [ ] old = theItems;
        theItems = (T []) new Object[ newCapacity ];
        for( int i = 0; i < size( ); i++ )
            theItems[ i ] = old[ i ];
    }


    /**
     * The method accepts one parameter element of type Stack
     * and refers to the elieement to be pushed into the stack.
     * @param x
     */
    public void push(T x) {
        if( theItems.length == size( ) )
            ensureCapacity(size( ) * 2 + 1 );
        theItems[theSize] = x;
        theSize = theSize+1;
    }

}

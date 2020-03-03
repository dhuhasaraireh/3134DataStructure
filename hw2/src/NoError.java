public class NoError implements BalanceError {
    BalanceError p;

    public NoError()
    {
        p=null;
    }

    public String toString()
    {
        return "Correct";
    }
}

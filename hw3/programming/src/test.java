public class test {

    public static void main(String args[]) {
        ExpressionTree t = new ExpressionTree("1 2 * 3 4 * +");
        System.out.println(t.eval());
        System.out.println(t.infix());
        System.out.println(t.postfix());
        System.out.println(t.prefix());

    }

}
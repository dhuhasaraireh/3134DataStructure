import java.lang.*;
import java.util.ArrayList;
import java.util.LinkedList;
public class ExpressionTree implements ExpressionTreeInterface {
    /**
     * Expression Node
     * @param <String>
     */
    private static class ExpressionNode<String> {
        public String element;
        public ExpressionNode<String> left;
        public ExpressionNode<String> right;

        ExpressionNode( String theElement )
        {
            element = theElement;
            left = null;
            right = null;
        }

        ExpressionNode( String theElement, ExpressionNode<String> lt, ExpressionNode<String> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }

        public boolean isOperator() {
            if(this.element.equals("+") || this.element.equals("-") || this.element.equals("*") || this.element.equals("/")) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isOperand() {
            if(this.isOperator()==false) {
                return true;
            } else {
                return false;
            }

        }
    }

    /**
     * Use the root to represent the tree.
     */
    private ExpressionNode<String> root;
    private String str;

    /**
     * constructor
     * @param expression
     */
    public ExpressionTree(String expression) {
        if(valid(expression) == true) {
            root= make_root(expression);
            str = expression;
        } else {
            throw new IllegalArgumentException("the input is invalid");
        }

    }


    /**
     * Use the stack to build the tree.
     * @param s
     * @return the root of the tree
     */
    private ExpressionNode<String> make_root(String s) {
        LinkedList<ExpressionNode<String>> stack = new LinkedList<>();
        String[] l = s.split(" ");
        for(int i=0; i<l.length; i++) {
            ExpressionNode<String> node = new ExpressionNode<String>(l[i]);
            if(node.isOperator()==false) {
                stack.push(node);
            } else {
                ExpressionNode<String> node_right = stack.pop();
                ExpressionNode<String> node_left = stack.pop();
                node.left = node_left;
                node.right = node_right;
                stack.push(node);
            }
         }
        return stack.pop();
    }




    private void postfix_helper( ExpressionNode<String> t, ArrayList<String> l)
    {
        if( t != null )
        {
            postfix_helper( t.left, l);
            postfix_helper( t.right, l);
            l.add(t.element);
        }

    }

    public String postfix() {
        ArrayList<String> l = new ArrayList<>();
        this.postfix_helper(this.root, l);
        String s = "";
        for(int i=0; i<l.size(); i++) {
            s = s.concat(l.get(i));
            s = s.concat(" ");
        }
        s = s.trim();
        return s;
    }


    private void prefix_helper( ExpressionNode<String> t, ArrayList<String> l)
    {
        if( t != null )
        {
            l.add(t.element);
            prefix_helper( t.left, l);
            prefix_helper( t.right, l);
        }

    }

    public String prefix() {
        ArrayList<String> l = new ArrayList<>();
        this.prefix_helper(this.root, l);
        String s = "";
        for(int i=0; i<l.size(); i++) {
            s = s.concat(l.get(i));
            s = s.concat(" ");
        }
        s = s.trim();
        return s;
    }


    private void infix_helper( ExpressionNode<String> t, ArrayList<String> l)
    {
        if( t != null )
        {
            l.add("(");
            infix_helper( t.left, l);
            l.add(t.element);
            infix_helper( t.right, l);
            l.add(")");
        }

    }

    public String infix() {
        ArrayList<String> l = new ArrayList<>();
        this.infix_helper(this.root, l);
        String s = "";
        for(int i=0; i<l.size(); i++) {
            s = s.concat(l.get(i));
            s = s.concat(" ");
        }
        s = s.trim();
        return s;
    }


    public boolean valid(String s) {
        String[] l = s.split(" ");
        if(l[l.length-1].equals("+") || l[l.length-1].equals("-") || l[l.length-1].equals("*") || l[l.length-1].equals("/")) {
            int count = 0;
            for(int i=0; i<l.length; i++) {
                if(l[i].equals("+") || l[i].equals("-") || l[i].equals("*") || l[i].equals("/")) {
                    count = count-2;
                    if(count<0) {
                        return false;
                    } else {
                        count = count +1;
                    }
                } else {
                    count = count+1;
                }
            }
            if(count!=1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public int eval() {
        ExpressionNode<String> fake_root = make_root(this.str);
        ExpressionNode<String> result = eval_helper(fake_root);
        int i = Integer.valueOf(result.element);
        return i;
    }

    private ExpressionNode<String> eval_helper(ExpressionNode<String> t) {
        if(t!=null) {
            t.left = eval_helper(t.left);
            t.right = eval_helper(t.right);
            if(t.element.equals("-")){
                Integer lt = Integer.valueOf(t.left.element);
                Integer rt = Integer.valueOf(t.right.element);
                Integer result = lt-rt;
                String ele = result.toString();
                ExpressionNode<String> node = new ExpressionNode<>(ele);
                return node;
            } else if (t.element.equals("+")) {
                Integer lt = Integer.valueOf(t.left.element);
                Integer rt = Integer.valueOf(t.right.element);
                Integer result = lt + rt;
                String ele = result.toString();
                ExpressionNode<String> node = new ExpressionNode<>(ele);
                return node;
            } else if(t.element.equals("*")) {
                Integer lt = Integer.valueOf(t.left.element);
                Integer rt = Integer.valueOf(t.right.element);
                Integer result = lt*rt;
                String ele = result.toString();
                ExpressionNode<String> node = new ExpressionNode<>(ele);
                return node;
            } else if(t.element.equals("/")) {
                Integer lt = Integer.valueOf(t.left.element);
                Integer rt = Integer.valueOf(t.right.element);
                Integer result = lt/rt;
                String ele = result.toString();
                ExpressionNode<String> node = new ExpressionNode<>(ele);
                return node;
            } else {
                return t;
            }
        }
        return t;
    }


}

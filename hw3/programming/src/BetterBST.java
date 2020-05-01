import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BetterBST<T extends Comparable<? super T>> extends BinarySearchTree<T> {
    public int height() {
        return helper_height(this.root);
    }

    private int helper_height(BinaryNode<T> node)
    {
        if (node == null)
            return -1;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = helper_height(node.left);
            int rDepth = helper_height(node.right);

            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }


    private BinaryNode<T> copy_root(BinaryNode<T> node) {
        if(node == null) {
            return null;
        }
        BinaryNode<T> left = null;
        BinaryNode<T> right = null;
        if (node.left != null) {
            left = copy_root(node.left);
        }
        if (node.right != null) {
            right = copy_root(node.right);
        }
        return new BinaryNode<T>(node.data, left, right);
    }



    public T smallestGreaterThan(T t){
        if(t==null) {
            return null;
        }
        if(this.root==null) {
            return null;
        }
        ArrayList<T> l = new ArrayList<>();
        addTolist(l, this.root);
        for(int i=0; i<l.size(); i++) {
            if(t.compareTo(l.get(i))<0) {
                return l.get(i);
            }
        }
        return null;
    }

    private void addTolist(ArrayList<T> l, BinaryNode<T> node) {
        if(node!=null) {
            addTolist(l, node.left);
            l.add(node.data);
            addTolist(l, node.right);
        }
    }



    public BetterBST<T> mirror(){
        BinaryNode<T> root_node = copy_root(this.root);
        BinaryNode<T> result = helper_mirror(root_node);
        BetterBST<T> t = new BetterBST<T>();
        t.root = result;
        return t;
    }

    private BinaryNode<T> helper_mirror(BinaryNode<T> root_node) {
        if (root_node == null) {
            return null;
        }
        BinaryNode<T> right = helper_mirror(root_node.right);
        BinaryNode<T> left = helper_mirror(root_node.left);
        root_node.left = right;
        root_node.right = left;
        return root_node;
    }

    public T imbalance(){
        ArrayList<T> l = new ArrayList<T>();
        helper_imbalance(l, this.root);
        if(this.root==null) {
            return null;
        }
        if(l==null) {
            return null;
        }
        if(l.size()==0){
            return null;
        }
        return l.get(0);
    }

    private void helper_imbalance(ArrayList<T> l, BinaryNode<T> node) {
        if(node!=null) {
            helper_imbalance(l, node.left);
            helper_imbalance(l, node.right);
            BetterBST<T> lt = new BetterBST<T>();
            lt.root=node.left;
            BetterBST<T> rt = new BetterBST<T>();
            rt.root=node.right;
            if(Math.abs(lt.height()-rt.height())>1) {
                l.add(node.data);
            }
        }
    }

    private void helper_prettyPrint(BinaryNode<T> root) {
        if (root == null) {
            return;
        }

        int[] size = new int[1];
        size[0] = 0;
        int height_x = height_x(root, size) - 1;
        int total = 2 * (int) Math.pow(2, height_x) - 1;
        Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
        queue.offer(root);

        for (int i = 0; i <= height_x; i++) {
            int front = (int) (Math.pow(2, (height_x - i))) - 1;
            int num = (int) (Math.pow(2, i));
            int interval = num > 1 ? (total - front * 2 - num) / (num - 1) : 0;

            for (int j = 0; j < num; j++) {
                BinaryNode<T> peek = queue.poll();

                if (j == 0) {
                    print(front, size, peek);
                } else {
                    print(interval, size, peek);
                }

                if (peek == null) {
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    queue.offer(peek.left);
                    queue.offer(peek.right);
                }
            }

            System.out.println();
        }
    }

    private int height_x(BinaryNode<T> root, int[] size) {
        if (root == null) {
            return 0;
        }

        size[0] = Math.max(size[0], root.data.toString().length());
        return Math.max(height_x(root.left, size), height_x(root.right, size)) + 1;
    }

    private void print(int count, int[] size, BinaryNode<T> root) {
        for (int i = 0; i < count * size[0]; i++) {
            System.out.print(" ");
        }

        if (root != null) {
            for (int j = 0; j < size[0] - root.data.toString().length(); j++) {
                System.out.print(" ");
            }

            System.out.print(root.data);
        } else {
            for (int j = 0; j < size[0]; j++) {
                System.out.print(" ");
            }
        }
    }

    public void prettyPrint() {
        helper_prettyPrint(this.root);
    }



}
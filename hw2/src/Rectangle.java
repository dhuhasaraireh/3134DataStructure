import java.util.Queue;

public class Rectangle implements RectangleInterface, Comparable<Rectangle> {
    private double width;
    private double length;
    Rectangle(double width, double length) {
        this.length= java.lang.Math.max(width, length);
        this.width= java.lang.Math.min(width, length);
    }

    public double getLength() {
        return this.length;
    }


    public double getWidth(){
        return this.width;
    }

    public int compareTo(Rectangle R) {
        double perimeter1 = this.getLength()+this.getWidth();
        double perimeter2 = R.getLength() + R.getWidth();
        if(perimeter1==perimeter2) {
            return 0;
        } else if(perimeter1>perimeter2) {
            return 1;
        } else {
            return -1;
        }

    }

    public String toString() {
        return Double.toString(length);
    }
}

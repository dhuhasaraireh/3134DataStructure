import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class TestHW2
{
    public static boolean open(char x) {
        if (x == '[') {
            return true;
        } else if (x == '(') {
            return true;
        } else if (x == '{') {
            return true;
        } else {
            return false;
        }
    }


    public static boolean close(char x) {
        if (x == ']') {
            return true;
        } else if (x == ')') {
            return true;
        } else if (x == '}') {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        SymbolBalance S1 = new SymbolBalance();
        S1.setFile("TestFiles/Test1.java");
        BalanceError p1 = S1.checkFile();
        if(p1==null) {
            System.out.println("Correct");
        } else {
            System.out.println(p1.toString());
        }

        SymbolBalance S2 = new SymbolBalance();
        S2.setFile("TestFiles/Test2.java");
        BalanceError p2 = S2.checkFile();
        if(p2==null) {
            System.out.println("Correct");
        } else {
            System.out.println(p2.toString());
        }



        SymbolBalance S3 = new SymbolBalance();
        S3.setFile("TestFiles/Test3.java");
        BalanceError p3 = S3.checkFile();
        if(p3==null) {
            System.out.println("Correct");
        } else {
            System.out.println(p3.toString());
        }


        SymbolBalance S4 = new SymbolBalance();
        S4.setFile("TestFiles/Test4.java");
        BalanceError p4 = S4.checkFile();
        if(p4==null) {
            System.out.println("Correct");
        } else {
            System.out.println(p4.toString());
        }


        SymbolBalance S5 = new SymbolBalance();
        S5.setFile("TestFiles/Test5.java");
        BalanceError p5 = S5.checkFile();
        if(p5==null) {
            System.out.println("Correct");
        } else {
            System.out.println(p5.toString());
        }


        SymbolBalance S6 = new SymbolBalance();
        S6.setFile("TestFiles/Test6.java");
        BalanceError p6 = S6.checkFile();
        if(p6==null) {
            System.out.println("Correct");
        } else {
            System.out.println(p6.toString());
        }

    }

}
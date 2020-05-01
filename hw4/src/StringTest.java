import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

public class StringTest {
    public static String changeWord(String s) {
        int n = s.length();
        String r = "";
        for(int i=0; i<n; i++) {
            if(Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                r = r+s.charAt(i);
            }
        }
        r = r.toLowerCase();
        return r;
    }


    public static String toString(ArrayList<Character> arr) {
        String s = "";
        int n=arr.size();
        for(int i=0; i<n; i++) {
            s =s+arr.get(i);
        }
        return s;
    }





    public static void main( String [ ] args ) {
        SpellChecker checker = new SpellChecker("TestFiles/words.txt");
        Set<String > set = checker.getSuggestions("have478");
        Iterator<String> itr = set.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("---------------------------------------------------------");
        List<String> l = checker.getIncorrectWords("TestFiles/test.txt");
        int n = l.size();
        for(int i=0; i<n; i++) {
            System.out.println(l.get(i));
        }



    }



}




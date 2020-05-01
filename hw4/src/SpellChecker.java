import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class SpellChecker implements SpellCheckerInterface {
    private BufferedReader reader;

    private void setFile(String filename) {
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private HashSet<String> dic;

    /**
     * Constructor of SpellChecker.
     * @param filename
     */
    SpellChecker(String filename) {
        dic = new HashSet<String>();
        makedic(filename);
    }

    /**
     * add words in the file to the HashSet data structure.
     * @param filename
     */
    private void makedic(String filename) {
        setFile(filename);
        try {
            String word = reader.readLine();
            while (word != null) {
                dic.add(word.toLowerCase());
                word = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Give the word with correct format.
     * @param s
     * @return remove punctuation
     */
    private String changeWord(String s) {
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

    /**
     * get the dictionary of this spell checker.
     * @return dic
     */
    public HashSet<String> getDic() {
        return this.dic;
    }

    /**
     * Incorrect
     * @param filename
     * @return a list of incorrect words.
     */
    public List<String> getIncorrectWords(String filename) {
        ArrayList<String> arr = FileToList(filename);
        int n = arr.size();
        ArrayList<String> result = new ArrayList<String>();
        for(int i=0; i<n; i++) {
            if(dic.contains(arr.get(i))==false) {
                result.add(arr.get(i));
            }
        }
        return result;
    }


    private ArrayList<String> FileToList(String filename) {
        ArrayList<String> arr = new ArrayList<String>();
        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(filename));
            String line = reader1.readLine();
            while(line != null) {
                String[] strList = line.split(" ");
                int n = strList.length;
                for(int i=0; i<n; i++) {
                    if(strList[i].equals("")==false) {
                        arr.add(changeWord(strList[i]));
                    }
                }
                line = reader1.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    /**
     * Arraylist of characters to a String.
     * @param arr
     * @return
     */
    private String toString(ArrayList<Character> arr) {
        String s = "";
        int n=arr.size();
        for(int i=0; i<n; i++) {
            s =s+arr.get(i);
        }
        return s;
    }


    /**
     * Valid String suggestions if add one character.
     * @param s
     * @return an ArrayList of correct suggestions.
     */
    private ArrayList<String> addOneChar(String s) {
        ArrayList<String> result = new ArrayList<>();
        int n =s.length();
        char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i=0; i<n+1; i++) {
            for(char item : letters) {
                ArrayList<Character> arr = new ArrayList<>();
                for(int j=0; j<n; j++) {
                    arr.add(s.charAt(j));
                }
                arr.add(i, item);
                String y = toString(arr);
                if(dic.contains(y)) {
                    result.add(y);
                }
            }
        }
        return result;

    }


    private boolean testContains(String s) {
        if(dic.contains(s)) {
            return true;
        } else {
            return false;
        }
    }


    private ArrayList<String> RemoveOneChar(String s) {
        int n = s.length();
        ArrayList<String> result =  new ArrayList<>();
        for(int j=0; j<n; j++) {
            ArrayList<Character> arr = new ArrayList<>();
            for(int i=0; i<n; i++) {
                arr.add(s.charAt(i));
            }
            arr.remove(j);
            String y = toString(arr);
            if(dic.contains(y)) {
                result.add(y);
            }
        }
        return result;
    }


    private ArrayList<String> SwapTwoChars(String s) {
        int n = s.length();
        ArrayList<String> result =  new ArrayList<>();
        for(int j=0; j<n-1; j++) {
            ArrayList<Character> arr = new ArrayList<>();
            for(int i=0; i<n; i++) {
                arr.add(s.charAt(i));
            }
            Character t = arr.get(j);
            arr.set(j, arr.get(j+1));
            arr.set(j+1, t);
            String str = toString(arr);
            if(dic.contains(str)) {
                result.add(str);
            }

        }
        return result;
    }


    public Set<String> getSuggestions(String word) {
        ArrayList<String> add = new ArrayList<>();
        ArrayList<String> remove = new ArrayList<>();
        ArrayList<String> swap = new ArrayList<>();
        swap = SwapTwoChars(word);
        add = addOneChar(word);
        remove = RemoveOneChar(word);
        HashSet<String> result = new HashSet<>();
        int n1 = add.size();
        int n2 = remove.size();
        int n3 = swap.size();
        for(int i=0; i<n1; i++) {
            result.add(add.get(i));
        }
        for(int i=0; i<n2; i++) {
            result.add(remove.get(i));
        }
        for(int i=0; i<n3; i++) {
            result.add(swap.get(i));
        }
        return result;

    }

}

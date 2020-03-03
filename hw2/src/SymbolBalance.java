import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SymbolBalance implements SymbolBalanceInterface {
    private BufferedReader reader;


    public void setFile(String filename) {
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void print() {
        try {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean open(char x) {
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


    public boolean close(char x) {
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


    public BalanceError checkFile() {
        int line_num = 0;
        MyStack<Character> S = new MyStack<>();
        try {
            boolean meet_a_comment = false;
            String line = reader.readLine();
            line_num = line_num + 1;
            boolean examine = true;
            while (line != null) {
                //loop through every char in this line to see what's the case?
                for (int i = 0; i < line.length(); i++) {
                    //change quote state ""
                    if (line.charAt(i) == '"') {
                        if(meet_a_comment==false) {
                            if(S.peek()==null) {
                                S.push('"');
                                examine = false;
                                continue;
                            }
                            char target = S.peek();
                            if(target == '"') {
                                S.pop();
                                examine = true;
                                continue;
                            } else {
                                S.push('"');
                                examine = false;
                                continue;
                            }
                        }
                    }


                    //change comment state
                    if (line.charAt(i) == '*') {
                        if(examine==true) {
                            if(i == line.length()-1) {
                                continue;
                            }
                            else {
                                if(line.charAt(i+1) == '/') {
                                    if(meet_a_comment == true) {
                                        meet_a_comment =false;
                                        S.pop();
                                    } else {
                                        MismatchError mismatchError = new MismatchError(line_num, line.charAt(i), S.peek());
                                        return mismatchError;
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    }


                    if(examine==false) {
                        continue;
                    }

                    if(meet_a_comment == true) {
                        continue;
                    }

                    // open: triger a push
                    if (open(line.charAt(i)) == true) {
                        S.push(line.charAt(i));
                    }

                    // close: test if equal to open
                    else if (close(line.charAt(i)) == true) {
                        if(S.peek()==null) {
                            EmptyStackError emptyStackError = new EmptyStackError(line_num);
                            return emptyStackError;
                        }
                        char target = S.pop();
                        char current  = line.charAt(i);
                        if(target == '{') {
                            if(current != '}') {
                                MismatchError mismatchError = new MismatchError(line_num,line.charAt(i),target);
                                return mismatchError;
                            }
                        } else if (target == '[') {
                            if(current != ']') {
                                MismatchError mismatchError = new MismatchError(line_num, line.charAt(i), target);
                                return mismatchError;
                            }
                        } else {
                            if(current != ')') {
                                MismatchError mismatchError = new MismatchError(line_num, line.charAt(i), target);
                                return mismatchError;
                            }
                        }

                    }

                    //comment /*
                    else if (line.charAt(i) == '/') {
                        // if '/' does not have next char, do nothing and continue to examine the next char
                        if(i == line.length()-1) {
                            continue;
                        }
                        else {
                            // comment
                            if(line.charAt(i+1) == '*') {
                                meet_a_comment = true;
                                S.push('*');
                                continue;
                            } else {
                                continue;
                            }

                        }
                    }


                    else {
                        continue;
                    }
                }

                //end for loop: end reading this line, go to next line.
                line = reader.readLine(); //line String
                line_num = line_num + 1;





            }
            //text is empty but stack is not empty
            if(S.peek() != null) {
                NonEmptyStackError nonEmptyStackError = new NonEmptyStackError(S.peek(), S.size());
                return nonEmptyStackError;
            }




            return null;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;



    }


}

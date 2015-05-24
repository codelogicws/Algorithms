package ws.codelogic.Math;

import ws.codelogic.collections.stack.Stack;
import ws.codelogic.collections.stack.StackFactory;

import java.util.ArrayList;

public class InfixToPostfix {

    private static final int MAXSTACKCAPACITY = 100000;
    private Stack<Character> signs;
    private StringBuffer newString;

    public String convert(String s) {
        init();
        for(int i=0;i<s.length();i++){
            sortCharacters(s.charAt(i));
        }
        insertLastSigns();
        return new String(newString);
    }

    private void sortCharacters(char current) {
        if(isPlusOrMinus(current)){
            addSign(current);
        }else{
            newString.append(current);
        }
    }

    private void init() {
        newString = new StringBuffer();
        signs = StackFactory.make(MAXSTACKCAPACITY);
    }

    private void insertLastSigns() {
        if(!signs.isEmpty()) newString.append(signs.pop());
    }

    private boolean isPlusOrMinus(char current) {
        return current == '-' || current == '+';
    }

    private void addSign(char current) {
        if(signs.isEmpty()) {
            signs.push(current);
        }else{
            newString.append(signs.pop());
            signs.push(current);
        }
    }

}

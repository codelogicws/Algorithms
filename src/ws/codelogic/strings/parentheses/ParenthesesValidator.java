package ws.codelogic.strings.parentheses;

import ws.codelogic.collections.stack.Stack;
import ws.codelogic.collections.stack.StackFactory;

import java.util.HashMap;

public class ParenthesesValidator {

    private Stack<Character> openBracketsSoFar;
    private final int parenthesesCapacity;
    private HashMap<Character, Character> parenthesesPairs;

    public ParenthesesValidator(int parenthesesCapacity){
        initBrackets();
        if(parenthesesCapacity < 0) throw new IllegalCapacity();
        this.parenthesesCapacity = parenthesesCapacity;
        openBracketsSoFar = StackFactory.make(parenthesesCapacity);
    }

    private void initBrackets() {
        parenthesesPairs = new HashMap<>();
        parenthesesPairs.put(')', '(');
        parenthesesPairs.put('}', '{');
        parenthesesPairs.put('>', '<');
        parenthesesPairs.put(']', '[');
    }

    public boolean isValid(String s) {
        for(int i=0;i<s.length();i++){

            char currentChar = s.charAt(i);

            if(isOpenParentheses(currentChar)) {
                checkForOverFlow();
                openBracketsSoFar.push(s.charAt(i));
            }else if(isClosedParentheses(currentChar)){
               if(openBracketsSoFar.isEmpty()) {
                   return false;
               }else if(parenthesesPairs.get(currentChar) != openBracketsSoFar.peek()){
                   return false;
               }
                openBracketsSoFar.pop();
            }

        }
        return openBracketsSoFar.size() == 0;
    }

    private void checkForOverFlow() {
        if(openBracketsSoFar.size() == parenthesesCapacity -1) throw new ParenthesesOverFlow();
    }

    private boolean isClosedParentheses(char toMatch) {
        for(char c : parenthesesPairs.keySet())
            if(c == toMatch) return true;
        return false;
    }

    private boolean isOpenParentheses(char toMatch) {
        for(char c : parenthesesPairs.values())
            if(c == toMatch) return true;
        return false;
    }

}

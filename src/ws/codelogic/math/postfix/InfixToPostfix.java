package ws.codelogic.math.postfix;

import ws.codelogic.collections.stack.Stack;
import ws.codelogic.collections.stack.StackFactory;
import java.util.HashMap;

class InfixToPostfix {

    private static final int MAX_STACK_CAPACITY = Integer.MAX_VALUE;
    private HashMap<Character, Integer> signPriority;
    private Stack<Character> signs;
    private StringBuffer newString;

    public String convert(String s) {
        init();
        verifyEquation(s);
        arrangeCharacters(s);
        insertLastSigns();
        return new String(newString);
    }

    private void verifyEquation(String s) {
        for(int i=0;i<s.length()-1;i++){
            if(isANonParenthesisSign(s.charAt(i)) && isANonParenthesisSign(s.charAt(i+1)))
                throw new MultipleSignsTogetherInvalidEquation();
            if(isNotValidCharacter(s.charAt(i)))
                throw new InvalidCharacterInvalidEquation();
        }
    }

    private boolean isNotValidCharacter(char c) {
        return !isASign(c) && !Character.isDigit(c);
    }

    private boolean isANonParenthesisSign(char c) {
        return isASign(c) && !isParenthesis(c);
    }

    private void arrangeCharacters(String s) {
        for(int i=0;i<s.length();i++){
            char current = s.charAt(i);
            if(isASign(current)) {
                addSign(current);
            }else if(isMoreThenOneDigitNumber(s, i)){
                newString.append('(');
                while(hasAnotherLetter(s, i)) newString.append(s.charAt(i++));
                newString.append(')');
            }else{
                newString.append(current);
            }
        }
    }

    private boolean hasAnotherLetter(String s, int i) {
        return i < s.length() && !isASign(s.charAt(i));
    }

    private boolean isMoreThenOneDigitNumber(String s, int i) {
        return hasAnotherLetter(s, i+1);
    }

    private boolean isASign(char current) {
        return signPriority.containsKey(current);
    }

    private void init() {
        signPriority = new HashMap<>();
        signPriority.put('*', 2);
        signPriority.put('/', 2);
        signPriority.put('+', 1);
        signPriority.put('-', 1);
        signPriority.put('(', 0);
        signPriority.put(')', 0);
        newString = new StringBuffer();
        signs = StackFactory.make(MAX_STACK_CAPACITY);
    }

    private void insertLastSigns() {
        int size = signs.size();
        for(int i=0;i<size;i++)
            newString.append(signs.pop());
    }

    private void addSign(char current) {
        if(current == ')') {
            char temp;
            while((temp = signs.pop()) != '('){
                newString.append(temp);
            }
        }else if(current == '(') {
            signs.push(current);
        }else if(signs.isEmpty()){
            signs.push(current);
        }else if(greaterPriorityThenSignInStack(current)){
            signs.push(current);
        }else{
            newString.append(signs.pop());
            signs.push(current);
        }
    }

    private boolean greaterPriorityThenSignInStack(char current) {
        return isHigherPriorityThenStack(current) || isParenthesis(current) || signs.isEmpty();
    }

    private boolean isHigherPriorityThenStack(char current) {
        return signPriority.get(current) > getCurrentPriority();
    }

    private boolean isParenthesis(char current) {
        return current == '(' || current == ')';
    }

    private Integer getCurrentPriority() {
        return signPriority.get(signs.peek());
    }

}

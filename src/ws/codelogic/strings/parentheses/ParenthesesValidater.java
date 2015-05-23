package ws.codelogic.strings.parentheses;

import ws.codelogic.collections.stack.Stack;
import ws.codelogic.collections.stack.StackFactory;

public class ParenthesesValidater {

    Stack<Character> stack;
    private final int parenthesesCapacity;
    char open = '(';
    char closed = ')';

    public ParenthesesValidater(int parenthesesCapacity){
        if(parenthesesCapacity < 0) throw new IllegalCapacity();
        this.parenthesesCapacity = parenthesesCapacity;
        stack = StackFactory.make(parenthesesCapacity);
    }

    public boolean isValid(String s) {
        for(int i=0;i<s.length();i++){

            if(isOpenParentheses(s, i)) {
                checkForOverFlow();
                stack.push(s.charAt(i));
            }else if(isClosedParentheses(s, i)){
               if(stack.isEmpty())
                   return false;
                stack.pop();
            }

        }
        if(stack.size() != 0)
            return false;
        return true;
    }

    private void checkForOverFlow() {
        if(stack.size() == parenthesesCapacity -1) throw new ParenthesesOverFlow();
    }

    private boolean isClosedParentheses(String s, int i) {
        return s.charAt(i) == closed;
    }

    private boolean isOpenParentheses(String s, int i) {
        return s.charAt(i) == open;
    }

}

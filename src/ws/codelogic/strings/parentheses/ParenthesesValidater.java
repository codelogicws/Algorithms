package ws.codelogic.strings.parentheses;

import ws.codelogic.collections.stack.Stack;
import ws.codelogic.collections.stack.StackFactory;

import java.util.HashSet;

public class ParenthesesValidater {

    Stack<Character> stack;
    private final int parenthesesCapacity;
    HashSet<Character> open;
    HashSet<Character> closed;

    public ParenthesesValidater(int parenthesesCapacity){
        initBrackets();
        if(parenthesesCapacity < 0) throw new IllegalCapacity();
        this.parenthesesCapacity = parenthesesCapacity;
        stack = StackFactory.make(parenthesesCapacity);
    }

    private void initBrackets() {
        open = new HashSet<Character>();
        closed = new HashSet<Character>();
        open.add('(');
        open.add('{');
        closed.add(')');
        closed.add('}');
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
        return closed.contains(s.charAt(i));
    }

    private boolean isOpenParentheses(String s, int i) {
        return open.contains(s.charAt(i));
    }

}

package ws.codelogic.strings.parentheses;

import ws.codelogic.collections.stack.Stack;
import ws.codelogic.collections.stack.StackFactory;

public class PredictLeftParentheses {

    private final static int PARENTHESESPAIRMAX = 20000;
    private Stack<Character> stack;
    private int rightParenthesesCount;

    public String insertLeft(String s){
        rightParenthesesCount = 0;
        stack = StackFactory.make(PARENTHESESPAIRMAX);
        for(int i=s.length()-1;i>=0;i--){
            char current = s.charAt(i);
            if(isStarOrForwardSlash(current)){
                stack.push('(');
                --rightParenthesesCount;
            }else if(current == ')')
                rightParenthesesCount++;
            stack.push(current);
        }
        addParentheses(rightParenthesesCount);
        s = stackToString();
        return s;
    }

    private String stackToString() {
        StringBuffer string = new StringBuffer();
        int size = stack.size();
        for(int i=0;i<size;i++){
            string.append(stack.pop());
        }
        return new String(string);
    }

    private boolean isStarOrForwardSlash(char current) {
        return current == '*' || current == '/';
    }

    private void addParentheses(int rightParenthesesCount) {
        for(int i=0;i<rightParenthesesCount;i++){
            stack.push('(');
        }
    }

}

package ws.codelogic.Math;

import ws.codelogic.collections.stack.Stack;
import ws.codelogic.collections.stack.StackFactory;
import java.util.HashMap;

public class InfixToPostfix {

    private static final int MAXSTACKCAPACITY = 100000;
    private HashMap<Character, Integer> signPriority;
    private Stack<Character> signs;
    private StringBuffer newString;

    public String convert(String s) {
        init();
        arrangeCharaters(s);
        insertLastSigns();
        return new String(newString);
    }

    private void arrangeCharaters(String s) {
        for(int i=0;i<s.length();i++){
            char current = s.charAt(i);
            if(isASign(current)) {
                addSign(current);
            }else if(i+1 < s.length() && !isASign(s.charAt(i+1))){
                newString.append('(');
                while(i < s.length() && !isASign(s.charAt(i)) ) newString.append(s.charAt(i++));
                newString.append(')');
            }else{
                newString.append(current);
            }
        }
    }

    private boolean isASign(char current) {
        for(char c : signPriority.keySet()){
            if(c == current) return true;
        }
        if(current == '(' || current == ')') return true;
        return false;
    }

    private void init() {
        signPriority = new HashMap<Character, Integer>();
        signPriority.put('*', 2);
        signPriority.put('/', 2);
        signPriority.put('+', 1);
        signPriority.put('-', 1);
        newString = new StringBuffer();
        signs = StackFactory.make(MAXSTACKCAPACITY);
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
        if(signs.isEmpty()) return true;
        if(current == '(' || current == ')') return true;
        return signPriority.get(current) > getCurrentPriority();
    }

    private Integer getCurrentPriority() {
        Integer answer = signPriority.get(signs.peek());
        if(answer == null) return 0;
        return answer;
    }


}

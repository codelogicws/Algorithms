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
        for(int i=0;i<s.length();i++){
            sortCharacters(s.charAt(i));
        }
        insertLastSigns();
        return new String(newString);
    }

    private void sortCharacters(char current) {
        if(isASign(current)) {
            assert current != '(';
            addSign(current);
        }else{
            newString.append(current);
        }
    }

    private boolean isASign(char current) {
        for(char c : signPriority.keySet()){
            if(c == current) return true;
        }
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
        if(signs.isEmpty()) {
            signs.push(current);
        }else if(current == '(') {
            System.out.println("Debug-InfixToPostfix: " + "got here (");
            signs.push(current);
        }else if(current == ')'){
            char temp;
            while((temp = signs.pop()) != '('){
                System.out.println("Debug-InfixToPostfix: " + temp);
                newString.append(temp);
            }
        }else if(greaterPriorityThenSignInStack(current)){
            signs.push(current);
        }else{
            newString.append(signs.pop());
            signs.push(current);
        }
    }

    private boolean greaterPriorityThenSignInStack(char current) {
        return (signPriority.get(current) > signPriority.get(signs.peek()) || current == '(' || current == ')');
    }

}

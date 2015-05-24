package ws.codelogic.strings.parentheses;

public class PredictLeftParentheses {

    private final static int PARENTHESESPAIRMAX = 20000;

    public String insertLeft(String s){
        int rightParenthesesCount = 0;
        for(int i=s.length()-1;i>=0;i--){
            char current = s.charAt(i);
            if(current == '*' || current == '/'){
                s = s.substring(0, i+1) + '(' + s.substring(i+1);
                --rightParenthesesCount;
            }
            if(current == ')')rightParenthesesCount++;
        }

        for(int i=0;i<rightParenthesesCount;i++){
            s = "(" + s;
        }

        return s;
    }

}

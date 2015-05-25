package ws.codelogic.math.postfix;

public class PostfixSolver {

    public int solve(String s) {
        Integer value1 = getNumericValue(s.charAt(0));
        Integer value2 = getNumericValue(s.charAt(1));
        return evaluate(value1, value2, s.charAt(2));
    }

    private int getNumericValue(char ch) {
        return Character.getNumericValue(ch);
    }

    private int evaluate(int value1, int value2, char sign) {
        int answer = 0;
        if(sign == '-'){
            answer = value1 - value2;
        }else if(sign == '+'){
            answer = value1 + value2;
        }
        return answer;
    }

}

package ws.codelogic.Math;

import java.util.ArrayList;

public class InfixToPostfix {

    public String convert(String s) {
        StringBuffer newString = new StringBuffer();
        ArrayList<Character> saveSign = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char current = s.charAt(i);
            if(current == '-' || current == '+'){
                saveSign.add(current);
            }else {
                newString.append(current);
            }
        }
        for(char c : saveSign){
            newString.append(c);
        }
        return new String(newString);
    }

}

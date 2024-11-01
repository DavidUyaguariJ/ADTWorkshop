package excerciseFour;

import javax.swing.*;
import java.util.*;

public class ExpressionsValidator {

    private String expression;
    private Map<Character, Character> dictionary;

    public ExpressionsValidator() {
        dictionary = new HashMap<>();
        dictionary.put('(', ')');
        dictionary.put('[', ']');
        dictionary.put('{', '}');
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression.replaceAll(" ","");
    }

    public void validateExpression() throws  Exception {
        if (this.expression == null || this.expression.length() % 2 != 0) {
            throw  new Exception("Expresión no balanceada");
        }

        Stack<Character> leftCharacters = new Stack<>();
        Queue<Character> rightCharacters = new LinkedList<>();

        char[] charArray = this.expression.toCharArray();
        int midpoint = charArray.length / 2;

        for (int i = 0; i < charArray.length; i++) {
            if (i < midpoint) {
                leftCharacters.push(charArray[i]);
            } else {
                rightCharacters.offer(charArray[i]);
            }
        }

        while (!leftCharacters.isEmpty() && !rightCharacters.isEmpty()) {
            char apertura = leftCharacters.pop();
            char cierre = rightCharacters.poll();
            if (!dictionary.containsKey(apertura) || dictionary.get(apertura) != cierre) {
                throw  new Exception("Expresión no balanceada");
            }
        }
        JOptionPane.showMessageDialog(null,"Expresion balanceada\n");
    }
}
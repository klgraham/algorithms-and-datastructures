package org.klgraham.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by klogram on 8/21/16.
 */
public class ExpressionEvaluation
{
    private final static Set<String> operators = new HashSet<>(Arrays.asList(new String[]{"+", "-", "*", "/"}));
    public static void main(String[] args)
    {
        Stack<Character> ops = new Stack<>();
        Stack<Double> values = new Stack<>();

        String expression = args[0];
        System.out.print(expression + " = ");
        for (Character c : expression.toCharArray())
        {
            if (c.toString().equals("(") || c.toString().equals(" "))
            {
                continue;
            }
            if (operators.contains(c.toString()))
            {
                ops.push(c);
            }
            else if (c.toString().equals(")"))
            {
                String operator = ops.pop().toString();
                double value = values.pop();
                switch (operator)
                {
                    case "+":
                        value += values.pop();
                        break;
                    case "-":
                        value -= values.pop();
                        break;
                    case "*":
                        value *= values.pop();
                        break;
                    case "/":
                        value /= values.pop();
                        break;
                    default:
                        throw new UnsupportedOperationException("The " + operator + " operator is not supported.");

                }
                values.push(value);
            }
            else
            {
                values.push(Double.parseDouble(c.toString()));
            }
        }
        System.out.println(values.pop());
    }
}

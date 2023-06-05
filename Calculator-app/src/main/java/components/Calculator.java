package components;

import common.Element;
import common.NumberElement;
import common.OperatorElement;

import java.util.List;
import java.util.Stack;

public class Calculator {

    private Parser parser;

    public Calculator() {
        this.parser = new Parser();
    }

    public int calculate(String input) {
        List<Element> elements = parser.parse(input);

        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (Element element : elements) {
            if (element instanceof NumberElement) {
                numbers.push(((NumberElement) element).getNumber());
            } else if (element instanceof OperatorElement) {
                char operator = ((OperatorElement) element).getOperator();

                if (operator == '(') {
                    operators.push(operator);
                } else if (operator == ')') {
                    while (operators.peek() != '(') {
                        numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                    }
                    operators.pop();
                } else {
                    while (!operators.empty() && prioritise(operator) <= prioritise(operators.peek())) {
                        numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                    }
                    operators.push(operator);
                }
            }
        }

        while (!operators.empty()) {
            numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    private int prioritise(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    private int applyOperator(char operator, int b, int a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }
}

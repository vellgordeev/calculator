package components;

import common.Element;
import common.NumberElement;
import common.OperatorElement;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Element> parse(String input) {
        List<Element> elements = new ArrayList<>();

        char[] chars = input.toCharArray();
        StringBuilder buffer = new StringBuilder();
        boolean isNegative = false;


        for (char c : chars) {
            if (Character.isDigit(c)) {
                buffer.append(c);
            } else {
                if (buffer.length() > 0) {
                    int number = Integer.parseInt(buffer.toString());
                    if (isNegative) {
                        elements.add(new NumberElement(-number));
                        isNegative = false;
                    } else {
                        elements.add(new NumberElement(number));
                    }
                    buffer.delete(0, buffer.length());
                }

                if (c == '-' && (elements.isEmpty() || elements.get(elements.size() - 1) instanceof OperatorElement)) {
                    isNegative = true;
                } else if (!Character.isWhitespace(c)) {
                    elements.add(new OperatorElement(c));
                }
            }
        }

        if (buffer.length() > 0) {
            int number = Integer.parseInt(buffer.toString());
            if (isNegative) {
                elements.add(new NumberElement(-number));
            } else {
                elements.add(new NumberElement(number));
            }
        }

        return elements;
    }
}

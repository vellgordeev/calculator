import components.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {


    @Test
    public void firstTest() {
        Calculator calculator = new Calculator();

        String expression = "(-15 + 10) / 5";

        assertEquals(-1, calculator.calculate(expression));
    }

    @Test
    public void longNumbersTest() {
        Calculator calculator = new Calculator();

        String expression = "(-15000000000 + 10) / 5";

        assertEquals(-2999999998L, calculator.calculate(expression));
    }

    @Test
    public void floatNumbersTest() {
        Calculator calculator = new Calculator();

        String expression = "(-15.5 + 10) / 5";

        assertEquals(-1.1, calculator.calculate(expression));
    }

    @Test
    public void doubleBracketTest() {
        Calculator calculator = new Calculator();

        String expression = "((-10 -5 + 10)) / 5";

        assertEquals(-1, calculator.calculate(expression));
    }

    @Test
    public void doubleBracket2Test() {
        Calculator calculator = new Calculator();

        String expression = "(-15 + 10) / (5+5)";

        assertEquals(-0.5d, calculator.calculate(expression));
    }

}

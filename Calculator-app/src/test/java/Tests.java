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
}

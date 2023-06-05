package common;

public class OperatorElement implements Element {

    private char operator;

    public OperatorElement(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return this.operator;
    }
}

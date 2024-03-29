package expression;

import java.util.List;

public class T1 extends UnaryOperations {

    public T1(MultiExpression exp1) {
        super(exp1);
    }

    @Override
    public int evaluate(int x) {
        return Integer.numberOfTrailingZeros(~expression.evaluate(x));
    }

    @Override
    public int evaluate(List<Integer> variables) {
        return Integer.numberOfTrailingZeros(~expression.evaluate(variables));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return Integer.numberOfTrailingZeros(~expression.evaluate(x, y, z));
    }

    @Override
    protected String getStringOperator() {
        return "t1";
    }

    @Override
    public int getPriorityOperator() {
        return Integer.MAX_VALUE / 2;
    }

    @Override
    public String toString() {
        return "t1" + "(" + expression.toString() + ")";
    }

    @Override
    public String toMiniString() {
        if (this.getPriorityOperator() <= expression.getPriorityOperator()) {
            return "t1 " + expression.toMiniString();
        } else {
            return "t1" + "(" + expression.toMiniString() + ")";
        }
    }
    
}

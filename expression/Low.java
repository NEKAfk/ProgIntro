package expression;

import java.util.List;

public class Low extends UnaryOperations {

    public Low(MultiExpression exp1) {
        super(exp1);
    }

    @Override
    public int evaluate(int x) {
        int res = expression.evaluate(x);
        return res == 0 ? 0 : 1 << Integer.numberOfTrailingZeros(res);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int res = expression.evaluate(x, y, z);
        return res == 0 ? 0 : 1 << Integer.numberOfTrailingZeros(res);
    }

    @Override
    public int evaluate(List<Integer> variables) {
        int res = expression.evaluate(variables);
        return res == 0 ? 0 : 1 << Integer.numberOfTrailingZeros(res);
    }

    @Override
    protected String getStringOperator() {
        return "low";
    }

    @Override
    public int getPriorityOperator() {
        return Integer.MAX_VALUE / 2;
    }

    @Override
    public String toString() {
        return "low" + "(" + expression.toString() + ")";
    }

    @Override
    public String toMiniString() {
        if (this.getPriorityOperator() <= expression.getPriorityOperator()) {
            return "low " + expression.toMiniString();
        } else {
            return "low" + "(" + expression.toMiniString() + ")";
        }
    }
    
}

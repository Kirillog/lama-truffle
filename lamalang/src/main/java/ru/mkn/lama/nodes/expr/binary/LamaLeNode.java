package ru.mkn.lama.nodes.expr.binary;

import com.oracle.truffle.api.dsl.Fallback;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import ru.mkn.lama.LamaException;
import ru.mkn.lama.nodes.expr.LamaBinaryExpression;

@NodeInfo(shortName = "<=")
public abstract class LamaLeNode extends LamaBinaryExpression {
    @Specialization
    protected boolean le(int left, int right) {
        return left <= right;
    }

    @Fallback
    protected Object typeError(Object left, Object right) {
        throw LamaException.typeError(this, left, right);
    }
}

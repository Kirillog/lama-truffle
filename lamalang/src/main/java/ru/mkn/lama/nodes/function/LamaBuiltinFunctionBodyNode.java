package ru.mkn.lama.nodes.function;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import ru.mkn.lama.LamaException;
import ru.mkn.lama.nodes.LamaNode;
import ru.mkn.lama.nodes.vars.LamaReadParameterNode;

@NodeChild(value = "arguments", type = LamaReadParameterNode[].class)
@GenerateNodeFactory
public abstract class LamaBuiltinFunctionBodyNode extends LamaNode {


    @Override
    public final Object executeGeneric(VirtualFrame frame) {
        try {
            return execute(frame);
        } catch (UnsupportedSpecializationException e) {
            throw LamaException.typeError(e.getNode(), e.getSuppliedValues());
        }
    }

    @Override
    public final boolean executeBoolean(VirtualFrame frame) throws UnexpectedResultException {
        return super.executeBoolean(frame);
    }

    @Override
    public final int executeInt(VirtualFrame frame) throws UnexpectedResultException {
        return super.executeInt(frame);
    }

    protected abstract Object execute(VirtualFrame frame);
}

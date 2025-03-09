package ru.mkn.lama.nodes.function;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import ru.mkn.lama.nodes.LamaNode;
import ru.mkn.lama.runtime.LamaFunctionObject;

import java.util.List;

public final class LamaFunctionCallNode extends LamaNode {
    private String name;

    @SuppressWarnings("FieldMayBeFinal")
    @Child
    private LamaNode targetFunction;

    @Children
    private final LamaNode[] callArguments;

    @SuppressWarnings("FieldMayBeFinal")
    @Child protected IndirectCallNode callNode;

    public LamaFunctionCallNode(String name, LamaNode targetFunction, List<LamaNode> callArguments) {
        this.name = name;
        this.targetFunction = targetFunction;
        this.callArguments = callArguments.toArray(new LamaNode[]{});
        this.callNode = Truffle.getRuntime().createIndirectCallNode();
    }

    @Override
    @ExplodeLoop
    public Object executeGeneric(VirtualFrame frame) {
        LamaFunctionObject function = (LamaFunctionObject) this.targetFunction.executeGeneric(frame);
        CompilerAsserts.compilationConstant(this.callArguments.length);

        Object[] argumentValues = new Object[this.callArguments.length];
        for (int i = 0; i < this.callArguments.length; i++) {
            argumentValues[i] = this.callArguments[i].executeGeneric(frame);
        }

        return callNode.call(function.callTarget, argumentValues);
    }
}
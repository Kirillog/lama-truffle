package ru.mkn.lama.nodes.expr.literal;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import ru.mkn.lama.nodes.LamaNode;

@NodeInfo(shortName = "const")
public class LamaBooleanLiteralNode extends LamaNode {

    private final int value;

    public LamaBooleanLiteralNode(int value) {
        this.value = value;
    }

    @Override
    public int executeInt(VirtualFrame frame) {
        return value;
    }
    @Override
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }
}

package ru.mkn.lama.nodes.vars;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.strings.TruffleString;
import ru.mkn.lama.nodes.LamaNode;

@NodeField(name = "name", type = TruffleString.class)
public abstract class LamaReadGlobalVariableNode extends LamaNode {


    public abstract TruffleString getName();

    @Specialization
    @CompilerDirectives.TruffleBoundary
    public Object read() {
        return currentLanguageContext().globalScope.get(getName());
    }
}

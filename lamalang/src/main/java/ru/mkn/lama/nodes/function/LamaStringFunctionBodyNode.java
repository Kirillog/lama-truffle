package ru.mkn.lama.nodes.function;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.Specialization;
import ru.mkn.lama.runtime.LamaArrayObject;
import ru.mkn.lama.runtime.LamaSExpObject;
import ru.mkn.lama.runtime.LamaStringObject;


public abstract class LamaStringFunctionBodyNode extends LamaBuiltinFunctionBodyNode {

    @Specialization
    @CompilerDirectives.TruffleBoundary
    public LamaStringObject string(Integer a) {
        return new LamaStringObject(a.toString());
    }

    @Specialization
    @CompilerDirectives.TruffleBoundary
    public LamaStringObject string(LamaArrayObject obj) {
        return new LamaStringObject(obj.toString());
    }

    @Specialization
    @CompilerDirectives.TruffleBoundary
    public LamaStringObject string(LamaStringObject obj) {
        return new LamaStringObject(obj.toString());
    }

    @Specialization
    @CompilerDirectives.TruffleBoundary
    public LamaStringObject string(LamaSExpObject obj) {
        return new LamaStringObject(obj.toString());
    }
}

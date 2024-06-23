package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KFunction;

@SinceKotlin(version = "1.7")
/* compiled from: Taobao */
public class FunInterfaceConstructorReference extends FunctionReference {
    private final Class funInterface;

    public FunInterfaceConstructorReference(Class cls) {
        super(1);
        this.funInterface = cls;
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FunInterfaceConstructorReference)) {
            return false;
        }
        return this.funInterface.equals(((FunInterfaceConstructorReference) obj).funInterface);
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public int hashCode() {
        return this.funInterface.hashCode();
    }

    @Override // kotlin.jvm.internal.FunctionReference
    public String toString() {
        return "fun interface " + this.funInterface.getName();
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference, kotlin.jvm.internal.FunctionReference, kotlin.jvm.internal.FunctionReference
    public KFunction getReflected() {
        throw new UnsupportedOperationException("Functional interface constructor does not support reflection");
    }
}

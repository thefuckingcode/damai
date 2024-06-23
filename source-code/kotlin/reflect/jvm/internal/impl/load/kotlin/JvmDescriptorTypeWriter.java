package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.lzy.okgo.cookie.SerializableCookie;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;

/* compiled from: typeSignatureMapping.kt */
public class JvmDescriptorTypeWriter<T> {
    private T jvmCurrentType;
    private int jvmCurrentTypeArrayLevel;
    private final JvmTypeFactory<T> jvmTypeFactory;

    public void writeArrayEnd() {
    }

    public void writeArrayType() {
        if (this.jvmCurrentType == null) {
            this.jvmCurrentTypeArrayLevel++;
        }
    }

    public void writeClass(T t) {
        Intrinsics.checkParameterIsNotNull(t, "objectType");
        writeJvmTypeAsIs(t);
    }

    /* access modifiers changed from: protected */
    public final void writeJvmTypeAsIs(T t) {
        Intrinsics.checkParameterIsNotNull(t, "type");
        if (this.jvmCurrentType == null) {
            if (this.jvmCurrentTypeArrayLevel > 0) {
                JvmTypeFactory<T> jvmTypeFactory2 = this.jvmTypeFactory;
                t = jvmTypeFactory2.createFromString(StringsKt.repeat("[", this.jvmCurrentTypeArrayLevel) + this.jvmTypeFactory.toString(t));
            }
            this.jvmCurrentType = t;
        }
    }

    public void writeTypeVariable(Name name, T t) {
        Intrinsics.checkParameterIsNotNull(name, SerializableCookie.NAME);
        Intrinsics.checkParameterIsNotNull(t, "type");
        writeJvmTypeAsIs(t);
    }
}

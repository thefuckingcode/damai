package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: util.kt */
public final class StringDefaultValue extends AnnotationDefaultValue {
    private final String value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringDefaultValue(String str) {
        super(null);
        Intrinsics.checkParameterIsNotNull(str, "value");
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}

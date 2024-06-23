package kotlin.reflect.jvm.internal.impl.descriptors;

/* compiled from: Taobao */
public enum ClassKind {
    CLASS,
    INTERFACE,
    ENUM_CLASS,
    ENUM_ENTRY,
    ANNOTATION_CLASS,
    OBJECT;

    public boolean isSingleton() {
        return this == OBJECT || this == ENUM_ENTRY;
    }
}

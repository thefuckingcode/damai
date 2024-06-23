package kotlin.reflect.jvm.internal.impl.renderer;

import tb.m40;

/* compiled from: Taobao */
public enum AnnotationArgumentsRenderingPolicy {
    NO_ARGUMENTS(false, false, 3, null),
    UNLESS_EMPTY(true, false, 2, null),
    ALWAYS_PARENTHESIZED(true, true);
    
    private final boolean includeAnnotationArguments;
    private final boolean includeEmptyAnnotationArguments;

    private AnnotationArgumentsRenderingPolicy(boolean z, boolean z2) {
        this.includeAnnotationArguments = z;
        this.includeEmptyAnnotationArguments = z2;
    }

    public final boolean getIncludeAnnotationArguments() {
        return this.includeAnnotationArguments;
    }

    public final boolean getIncludeEmptyAnnotationArguments() {
        return this.includeEmptyAnnotationArguments;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ AnnotationArgumentsRenderingPolicy(boolean z, boolean z2, int i, m40 m40) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }
}

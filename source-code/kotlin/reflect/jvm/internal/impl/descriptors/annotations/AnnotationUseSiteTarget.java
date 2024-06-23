package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import tb.gl1;
import tb.k21;
import tb.m40;

/* compiled from: Taobao */
public enum AnnotationUseSiteTarget {
    FIELD(null, 1, null),
    FILE(null, 1, null),
    PROPERTY(null, 1, null),
    PROPERTY_GETTER(gl1.TYPE_OPEN_URL_METHOD_GET),
    PROPERTY_SETTER("set"),
    RECEIVER(null, 1, null),
    CONSTRUCTOR_PARAMETER("param"),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD("delegate");
    
    @NotNull
    private final String renderName;

    private AnnotationUseSiteTarget(String str) {
        if (str == null) {
            String name = name();
            Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
            str = name.toLowerCase();
            k21.h(str, "(this as java.lang.String).toLowerCase()");
        }
        this.renderName = str;
    }

    @NotNull
    public final String getRenderName() {
        return this.renderName;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ AnnotationUseSiteTarget(String str, int i, m40 m40) {
        this((i & 1) != 0 ? null : str);
    }
}

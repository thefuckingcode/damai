package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import tb.ib2;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class a extends b {
    @NotNull
    private final Annotations c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(@NotNull ib2 ib2, @NotNull Annotations annotations) {
        super(ib2);
        k21.i(ib2, "delegate");
        k21.i(annotations, "annotations");
        this.c = annotations;
    }

    @Override // tb.r50, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.c;
    }

    @NotNull
    /* renamed from: p */
    public a n(@NotNull ib2 ib2) {
        k21.i(ib2, "delegate");
        return new a(ib2, getAnnotations());
    }
}

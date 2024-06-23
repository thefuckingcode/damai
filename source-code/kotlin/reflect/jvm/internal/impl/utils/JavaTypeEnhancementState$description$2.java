package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.jl1;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class JavaTypeEnhancementState$description$2 extends Lambda implements Function0<String[]> {
    final /* synthetic */ JavaTypeEnhancementState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JavaTypeEnhancementState$description$2(JavaTypeEnhancementState javaTypeEnhancementState) {
        super(0);
        this.this$0 = javaTypeEnhancementState;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final String[] invoke() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.this$0.d().getDescription());
        ReportLevel f = this.this$0.f();
        if (f != null) {
            arrayList.add(k21.r("under-migration:", f.getDescription()));
        }
        for (Map.Entry<String, ReportLevel> entry : this.this$0.g().entrySet()) {
            arrayList.add('@' + entry.getKey() + jl1.CONDITION_IF_MIDDLE + entry.getValue().getDescription());
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }
}

package kotlin.reflect.jvm.internal.calls;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.jl1;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "T", "", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class AnnotationConstructorCallerKt$createAnnotationInstance$toString$2 extends Lambda implements Function0<String> {
    final /* synthetic */ Class $annotationClass;
    final /* synthetic */ Map $values;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(Class cls, Map map) {
        super(0);
        this.$annotationClass = cls;
        this.$values = map;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        sb.append(this.$annotationClass.getCanonicalName());
        Appendable unused = CollectionsKt___CollectionsKt.X(this.$values.entrySet(), sb, AVFSCacheConstants.COMMA_SEP, jl1.BRACKET_START_STR, jl1.BRACKET_END_STR, 0, null, AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1.INSTANCE, 48, null);
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}

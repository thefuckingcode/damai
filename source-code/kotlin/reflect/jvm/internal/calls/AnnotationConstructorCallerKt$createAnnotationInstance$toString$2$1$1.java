package kotlin.reflect.jvm.internal.calls;

import com.alipay.sdk.m.n.a;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "T", "", "", "entry", "", "invoke", "(Ljava/util/Map$Entry;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1 extends Lambda implements Function1<Map.Entry<? extends String, ? extends Object>, CharSequence> {
    public static final AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1 INSTANCE = new AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1();

    AnnotationConstructorCallerKt$createAnnotationInstance$toString$2$1$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull Map.Entry<String, ? extends Object> entry) {
        String str;
        k21.i(entry, "entry");
        String key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof boolean[]) {
            str = Arrays.toString((boolean[]) value);
        } else if (value instanceof char[]) {
            str = Arrays.toString((char[]) value);
        } else if (value instanceof byte[]) {
            str = Arrays.toString((byte[]) value);
        } else if (value instanceof short[]) {
            str = Arrays.toString((short[]) value);
        } else if (value instanceof int[]) {
            str = Arrays.toString((int[]) value);
        } else if (value instanceof float[]) {
            str = Arrays.toString((float[]) value);
        } else if (value instanceof long[]) {
            str = Arrays.toString((long[]) value);
        } else if (value instanceof double[]) {
            str = Arrays.toString((double[]) value);
        } else if (value instanceof Object[]) {
            str = Arrays.toString((Object[]) value);
        } else {
            str = value.toString();
        }
        return key + a.h + str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends Object> entry) {
        return invoke((Map.Entry<String, ? extends Object>) entry);
    }
}

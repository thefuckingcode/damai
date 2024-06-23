package kotlin.reflect.jvm.internal.calls;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.z41;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "other", "", "invoke", "(Ljava/lang/Object;)Z", "equals"}, k = 3, mv = {1, 4, 1})
/* compiled from: Taobao */
public final class AnnotationConstructorCallerKt$createAnnotationInstance$2 extends Lambda implements Function1<Object, Boolean> {
    final /* synthetic */ Class $annotationClass;
    final /* synthetic */ List $methods;
    final /* synthetic */ Map $values;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnnotationConstructorCallerKt$createAnnotationInstance$2(Class cls, List list, Map map) {
        super(1);
        this.$annotationClass = cls;
        this.$methods = list;
        this.$values = map;
    }

    /* Return type fixed from 'boolean' to match base method */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(@Nullable Object obj) {
        boolean z;
        boolean z2;
        KClass a;
        Class cls = null;
        Annotation annotation = (Annotation) (!(obj instanceof Annotation) ? null : obj);
        if (!(annotation == null || (a = z41.a(annotation)) == null)) {
            cls = z41.b(a);
        }
        if (k21.d(cls, this.$annotationClass)) {
            List list = this.$methods;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Method method = (Method) it.next();
                    Object obj2 = this.$values.get(method.getName());
                    Object invoke = method.invoke(obj, new Object[0]);
                    if (obj2 instanceof boolean[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.BooleanArray");
                        z2 = Arrays.equals((boolean[]) obj2, (boolean[]) invoke);
                        continue;
                    } else if (obj2 instanceof char[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.CharArray");
                        z2 = Arrays.equals((char[]) obj2, (char[]) invoke);
                        continue;
                    } else if (obj2 instanceof byte[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.ByteArray");
                        z2 = Arrays.equals((byte[]) obj2, (byte[]) invoke);
                        continue;
                    } else if (obj2 instanceof short[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.ShortArray");
                        z2 = Arrays.equals((short[]) obj2, (short[]) invoke);
                        continue;
                    } else if (obj2 instanceof int[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.IntArray");
                        z2 = Arrays.equals((int[]) obj2, (int[]) invoke);
                        continue;
                    } else if (obj2 instanceof float[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.FloatArray");
                        z2 = Arrays.equals((float[]) obj2, (float[]) invoke);
                        continue;
                    } else if (obj2 instanceof long[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.LongArray");
                        z2 = Arrays.equals((long[]) obj2, (long[]) invoke);
                        continue;
                    } else if (obj2 instanceof double[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.DoubleArray");
                        z2 = Arrays.equals((double[]) obj2, (double[]) invoke);
                        continue;
                    } else if (obj2 instanceof Object[]) {
                        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
                        z2 = Arrays.equals((Object[]) obj2, (Object[]) invoke);
                        continue;
                    } else {
                        z2 = k21.d(obj2, invoke);
                        continue;
                    }
                    if (!z2) {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    return true;
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return false;
    }
}

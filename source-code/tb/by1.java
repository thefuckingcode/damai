package tb;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class by1 {
    @Nullable
    public static final yx1 a(@NotNull Annotation[] annotationArr, @NotNull en0 en0) {
        Annotation annotation;
        k21.i(annotationArr, "<this>");
        k21.i(en0, "fqName");
        int length = annotationArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i];
            if (k21.d(ReflectClassUtilKt.b(z41.b(z41.a(annotation))).b(), en0)) {
                break;
            }
            i++;
        }
        if (annotation == null) {
            return null;
        }
        return new yx1(annotation);
    }

    @NotNull
    public static final List<yx1> b(@NotNull Annotation[] annotationArr) {
        k21.i(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new yx1(annotation));
        }
        return arrayList;
    }
}

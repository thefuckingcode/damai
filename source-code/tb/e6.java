package tb;

import cn.damai.common.app.ShareperfenceConstants;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class e6 {
    @NotNull
    public static final Annotations a(@NotNull Annotations annotations, @NotNull Annotations annotations2) {
        k21.i(annotations, ShareperfenceConstants.FIRST);
        k21.i(annotations2, "second");
        if (annotations.isEmpty()) {
            return annotations2;
        }
        if (annotations2.isEmpty()) {
            return annotations;
        }
        return new CompositeAnnotations(annotations, annotations2);
    }
}

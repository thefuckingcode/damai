package tb;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.text.l;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public abstract class ib2 extends es2 implements SimpleTypeMarker, TypeArgumentListMarker {
    public ib2() {
        super(null);
    }

    @NotNull
    public abstract ib2 j(boolean z);

    @NotNull
    public abstract ib2 k(@NotNull Annotations annotations);

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = getAnnotations().iterator();
        while (it.hasNext()) {
            StringBuilder unused = l.g(sb, jl1.ARRAY_START_STR, DescriptorRenderer.c(DescriptorRenderer.DEBUG_TEXT, (AnnotationDescriptor) it.next(), null, 2, null), "] ");
        }
        sb.append(c());
        if (!b().isEmpty()) {
            Appendable unused2 = CollectionsKt___CollectionsKt.X(b(), sb, AVFSCacheConstants.COMMA_SEP, jl1.L, jl1.G, 0, null, null, 112, null);
        }
        if (d()) {
            sb.append("?");
        }
        String sb2 = sb.toString();
        k21.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}

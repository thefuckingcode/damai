package tb;

import com.huawei.hms.opendevice.c;
import java.util.Collection;
import java.util.List;
import kotlin.collections.m;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public abstract class y61 extends LazyJavaScope {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y61(@NotNull x61 x61) {
        super(x61, null, 2, null);
        k21.i(x61, c.a);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @NotNull
    public LazyJavaScope.a A(@NotNull JavaMethod javaMethod, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull g61 g61, @NotNull List<? extends ValueParameterDescriptor> list2) {
        k21.i(javaMethod, "method");
        k21.i(list, "methodTypeParameters");
        k21.i(g61, "returnType");
        k21.i(list2, "valueParameters");
        return new LazyJavaScope.a(g61, null, list2, list, false, m.g());
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    public void l(@NotNull og1 og1, @NotNull Collection<PropertyDescriptor> collection) {
        k21.i(og1, "name");
        k21.i(collection, "result");
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope
    @Nullable
    public ReceiverParameterDescriptor s() {
        return null;
    }
}

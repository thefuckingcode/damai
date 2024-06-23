package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.Nullable;
import tb.om;

/* compiled from: Taobao */
public interface VariableDescriptor extends ValueDescriptor {
    @Nullable
    om<?> getCompileTimeInitializer();

    boolean isConst();

    boolean isLateInit();

    boolean isVar();
}

package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface JavaPrimitiveType extends JavaType {
    @Nullable
    PrimitiveType getType();
}

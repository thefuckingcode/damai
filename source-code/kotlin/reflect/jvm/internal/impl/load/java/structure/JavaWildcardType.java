package kotlin.reflect.jvm.internal.impl.load.java.structure;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public interface JavaWildcardType extends JavaType {
    @Nullable
    JavaType getBound();

    boolean isExtends();
}

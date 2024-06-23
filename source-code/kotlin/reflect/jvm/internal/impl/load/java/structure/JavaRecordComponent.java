package kotlin.reflect.jvm.internal.impl.load.java.structure;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public interface JavaRecordComponent extends JavaMember {
    @NotNull
    JavaType getType();

    boolean isVararg();
}

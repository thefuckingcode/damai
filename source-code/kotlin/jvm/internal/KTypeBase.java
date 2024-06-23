package kotlin.jvm.internal;

import java.lang.reflect.Type;
import kotlin.SinceKotlin;
import kotlin.reflect.KType;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.4")
/* compiled from: Taobao */
public interface KTypeBase extends KType {
    @Nullable
    Type getJavaType();
}

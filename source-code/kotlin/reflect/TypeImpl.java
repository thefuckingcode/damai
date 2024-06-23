package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.ExperimentalStdlibApi;
import org.jetbrains.annotations.NotNull;

@ExperimentalStdlibApi
/* compiled from: Taobao */
interface TypeImpl extends Type {
    @NotNull
    String getTypeName();
}

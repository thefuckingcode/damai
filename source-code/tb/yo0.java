package tb;

import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.template.GXIExpression;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class yo0 {
    @NotNull
    public static final yo0 INSTANCE = new yo0();

    private yo0() {
    }

    @Nullable
    public final GXIExpression a(@Nullable Object obj) {
        return b(null, obj);
    }

    @Nullable
    public final GXIExpression b(@Nullable String str, @Nullable Object obj) {
        GXRegisterCenter.GXIExtensionExpression j;
        if (obj == null || (j = GXRegisterCenter.Companion.a().j()) == null) {
            return null;
        }
        return j.create(str, obj);
    }

    @Nullable
    public final Boolean c(@Nullable String str, @Nullable Object obj) {
        GXRegisterCenter.GXIExtensionExpression j = GXRegisterCenter.Companion.a().j();
        if (j == null) {
            return null;
        }
        return Boolean.valueOf(j.isTrue(str, obj));
    }

    @Nullable
    public final String d(@Nullable Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (o.L(str, "$", false, 2, null)) {
                String substring = str.substring(1, str.length());
                k21.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return null;
    }
}

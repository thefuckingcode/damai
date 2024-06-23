package com.alient.gaiax.container.util;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/alient/gaiax/container/util/UrlUtil;", "", "", "urlStr", "paramName", "getParamValue", "<init>", "()V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* compiled from: Taobao */
public final class UrlUtil {
    @NotNull
    public static final UrlUtil INSTANCE = new UrlUtil();

    private UrlUtil() {
    }

    @Nullable
    public final String getParamValue(@NotNull String str, @NotNull String str2) {
        k21.i(str, "urlStr");
        k21.i(str2, "paramName");
        int i = 0;
        if (!(str.length() > 0)) {
            return null;
        }
        int i2 = StringsKt__StringsKt.f0(str, "?", 0, false, 6, null);
        if (i2 >= 0) {
            str = str.substring(i2 + 1);
            k21.h(str, "(this as java.lang.String).substring(startIndex)");
        }
        Object[] array = StringsKt__StringsKt.z0(str, new String[]{"&"}, false, 0, 6, null).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr = (String[]) array;
        String r = k21.r(str2, "=");
        int length = strArr.length;
        while (i < length) {
            String str3 = strArr[i];
            i++;
            if (StringsKt__StringsKt.f0(str3, r, 0, false, 6, null) == 0) {
                int length2 = r.length();
                Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                String substring = str3.substring(length2);
                k21.h(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        return null;
    }
}

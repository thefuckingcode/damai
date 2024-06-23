package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import tb.k21;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class StringsKt__IndentKt extends h {
    private static final Function1<String, String> b(String str) {
        if (str.length() == 0) {
            return StringsKt__IndentKt$getIndentFunction$1.INSTANCE;
        }
        return new StringsKt__IndentKt$getIndentFunction$2(str);
    }

    private static final int c(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (!b.c(str.charAt(i))) {
                break;
            } else {
                i++;
            }
        }
        return i == -1 ? str.length() : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.String] */
    @NotNull
    public static final String d(@NotNull String str, @NotNull String str2) {
        String invoke;
        k21.i(str, "<this>");
        k21.i(str2, "newIndent");
        List<String> o0 = StringsKt__StringsKt.o0(str);
        ArrayList<String> arrayList = new ArrayList();
        for (T t : o0) {
            if (!o.y(t)) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(n.q(arrayList, 10));
        for (String str3 : arrayList) {
            arrayList2.add(Integer.valueOf(c(str3)));
        }
        Integer num = (Integer) k.g0(arrayList2);
        int i = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * o0.size());
        Function1<String, String> b = b(str2);
        int i2 = m.i(o0);
        ArrayList arrayList3 = new ArrayList();
        for (T t2 : o0) {
            int i3 = i + 1;
            if (i < 0) {
                m.p();
            }
            T t3 = t2;
            if ((i == 0 || i == i2) && (o.y(t3))) {
                t3 = null;
            } else {
                String U0 = q.U0(t3, intValue);
                if (!(U0 == null || (invoke = b.invoke(U0)) == 0)) {
                    t3 = invoke;
                }
            }
            if (t3 != null) {
                arrayList3.add(t3);
            }
            i = i3;
        }
        String sb = ((StringBuilder) CollectionsKt___CollectionsKt.X(arrayList3, new StringBuilder(length), StringUtils.LF, null, null, 0, null, null, 124, null)).toString();
        k21.h(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    @NotNull
    public static String e(@NotNull String str) {
        k21.i(str, "<this>");
        return d(str, "");
    }
}

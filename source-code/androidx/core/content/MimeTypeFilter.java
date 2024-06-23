package androidx.core.content;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import tb.jl1;

/* compiled from: Taobao */
public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    public static boolean matches(@Nullable String str, @NonNull String str2) {
        if (str == null) {
            return false;
        }
        return mimeTypeAgainstFilter(str.split("/"), str2.split("/"));
    }

    @NonNull
    public static String[] matchesMany(@Nullable String[] strArr, @NonNull String str) {
        if (strArr == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        String[] split = str.split("/");
        for (String str2 : strArr) {
            if (mimeTypeAgainstFilter(str2.split("/"), split)) {
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static boolean mimeTypeAgainstFilter(@NonNull String[] strArr, @NonNull String[] strArr2) {
        if (strArr2.length != 2) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        } else if (strArr2[0].isEmpty() || strArr2[1].isEmpty()) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
        } else if (strArr.length != 2) {
            return false;
        } else {
            if (!jl1.MUL.equals(strArr2[0]) && !strArr2[0].equals(strArr[0])) {
                return false;
            }
            if (jl1.MUL.equals(strArr2[1]) || strArr2[1].equals(strArr[1])) {
                return true;
            }
            return false;
        }
    }

    @Nullable
    public static String matches(@Nullable String str, @NonNull String[] strArr) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("/");
        for (String str2 : strArr) {
            if (mimeTypeAgainstFilter(split, str2.split("/"))) {
                return str2;
            }
        }
        return null;
    }

    @Nullable
    public static String matches(@Nullable String[] strArr, @NonNull String str) {
        if (strArr == null) {
            return null;
        }
        String[] split = str.split("/");
        for (String str2 : strArr) {
            if (mimeTypeAgainstFilter(str2.split("/"), split)) {
                return str2;
            }
        }
        return null;
    }
}

package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import tb.d80;
import tb.k21;
import tb.u91;

/* compiled from: Taobao */
public final class SignatureBuildingComponents {
    @NotNull
    public static final SignatureBuildingComponents INSTANCE = new SignatureBuildingComponents();

    private SignatureBuildingComponents() {
    }

    /* access modifiers changed from: private */
    public final String c(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return u91.LEVEL_L + str + d80.TokenSEM;
    }

    @NotNull
    public final String[] b(@NotNull String... strArr) {
        k21.i(strArr, "signatures");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    @NotNull
    public final Set<String> d(@NotNull String str, @NotNull String... strArr) {
        k21.i(str, "internalName");
        k21.i(strArr, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + '.' + str2);
        }
        return linkedHashSet;
    }

    @NotNull
    public final Set<String> e(@NotNull String str, @NotNull String... strArr) {
        k21.i(str, "name");
        k21.i(strArr, "signatures");
        String h = h(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return d(h, strArr2);
    }

    @NotNull
    public final Set<String> f(@NotNull String str, @NotNull String... strArr) {
        k21.i(str, "name");
        k21.i(strArr, "signatures");
        String i = i(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return d(i, strArr2);
    }

    @NotNull
    public final String g(@NotNull String str) {
        k21.i(str, "name");
        return k21.r("java/util/function/", str);
    }

    @NotNull
    public final String h(@NotNull String str) {
        k21.i(str, "name");
        return k21.r("java/lang/", str);
    }

    @NotNull
    public final String i(@NotNull String str) {
        k21.i(str, "name");
        return k21.r("java/util/", str);
    }

    @NotNull
    public final String j(@NotNull String str, @NotNull List<String> list, @NotNull String str2) {
        k21.i(str, "name");
        k21.i(list, PushConstants.PARAMS);
        k21.i(str2, "ret");
        return str + '(' + CollectionsKt___CollectionsKt.Z(list, "", null, null, 0, null, new SignatureBuildingComponents$jvmDescriptor$1(this), 30, null) + ')' + c(str2);
    }

    @NotNull
    public final String k(@NotNull String str, @NotNull String str2) {
        k21.i(str, "internalName");
        k21.i(str2, "jvmDescriptor");
        return str + '.' + str2;
    }
}

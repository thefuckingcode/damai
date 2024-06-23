package org.jetbrains.anko.collections;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\b\u001a-\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\b\u001a3\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\bH\b\u001a3\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\bH\b\u001a1\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\f\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e*\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\u000fH\b\u001a1\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\u000f\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e*\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\fH\b¨\u0006\u0011"}, d2 = {"forEachByIndex", "", "T", "", "f", "Lkotlin/Function1;", "forEachReversedByIndex", "forEachReversedWithIndex", "Lkotlin/Function2;", "", "forEachWithIndex", "toAndroidPair", "Landroid/util/Pair;", "F", "S", "Lkotlin/Pair;", "toKotlinPair", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Collections.kt */
public final class CollectionsKt {
    public static final <T> void forEachByIndex(List<? extends T> list, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        int size = list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                function1.invoke((Object) list.get(i));
                if (i != size) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final <T> void forEachWithIndex(List<? extends T> list, Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        int size = list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                function2.invoke(Integer.valueOf(i), (Object) list.get(i));
                if (i != size) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final <T> void forEachReversedByIndex(List<? extends T> list, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        for (int size = list.size() - 1; size >= 0; size--) {
            function1.invoke((Object) list.get(size));
        }
    }

    public static final <T> void forEachReversedWithIndex(List<? extends T> list, Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        for (int size = list.size() - 1; size >= 0; size--) {
            function2.invoke(Integer.valueOf(size), (Object) list.get(size));
        }
    }

    @Deprecated(message = "Use the Android KTX version", replaceWith = @ReplaceWith(expression = "toKotlinPair()", imports = {"androidx.core.util.toKotlinPair"}))
    public static final <F, S> Pair<F, S> toKotlinPair(android.util.Pair<F, S> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "$receiver");
        return TuplesKt.to(pair.first, pair.second);
    }

    @Deprecated(message = "Use the Android KTX version", replaceWith = @ReplaceWith(expression = "toAndroidPair()", imports = {"androidx.core.util.toAndroidPair"}))
    public static final <F, S> android.util.Pair<F, S> toAndroidPair(Pair<? extends F, ? extends S> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "$receiver");
        return new android.util.Pair<>(pair.getFirst(), pair.getSecond());
    }
}

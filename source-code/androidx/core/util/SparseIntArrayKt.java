package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.r11;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u001d\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\n\u001a\u0015\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0002\u001a\u0015\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\b\u001a\u0015\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0001H\b\u001a\u001d\u0010\r\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001H\b\u001a&\u0010\u000f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\bø\u0001\u0000\u001a\r\u0010\u0010\u001a\u00020\u0003*\u00020\u0000H\b\u001a\r\u0010\u0011\u001a\u00020\u0003*\u00020\u0000H\b\u001a\u001a\u0010\u0012\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0012\u0010\u0013\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000\u001aH\u0010\u0018\u001a\u00020\u0006*\u00020\u000026\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0014H\bø\u0001\u0000\u001a\n\u0010\u001a\u001a\u00020\u0019*\u00020\u0000\u001a\n\u0010\u001b\u001a\u00020\u0019*\u00020\u0000\"\u0018\u0010\u001e\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001f"}, d2 = {"Landroid/util/SparseIntArray;", "", "key", "", "contains", "value", "Ltb/ur2;", "set", "other", "plus", "containsKey", "containsValue", "defaultValue", "getOrDefault", "Lkotlin/Function0;", "getOrElse", "isEmpty", "isNotEmpty", "remove", "putAll", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEach", "Ltb/r11;", "keyIterator", "valueIterator", "getSize", "(Landroid/util/SparseIntArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class SparseIntArrayKt {
    public static final boolean contains(@NotNull SparseIntArray sparseIntArray, int i) {
        k21.i(sparseIntArray, "$this$contains");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(@NotNull SparseIntArray sparseIntArray, int i) {
        k21.i(sparseIntArray, "$this$containsKey");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(@NotNull SparseIntArray sparseIntArray, int i) {
        k21.i(sparseIntArray, "$this$containsValue");
        return sparseIntArray.indexOfValue(i) >= 0;
    }

    public static final void forEach(@NotNull SparseIntArray sparseIntArray, @NotNull Function2<? super Integer, ? super Integer, ur2> function2) {
        k21.i(sparseIntArray, "$this$forEach");
        k21.i(function2, "action");
        int size = sparseIntArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(sparseIntArray.keyAt(i)), Integer.valueOf(sparseIntArray.valueAt(i)));
        }
    }

    public static final int getOrDefault(@NotNull SparseIntArray sparseIntArray, int i, int i2) {
        k21.i(sparseIntArray, "$this$getOrDefault");
        return sparseIntArray.get(i, i2);
    }

    public static final int getOrElse(@NotNull SparseIntArray sparseIntArray, int i, @NotNull Function0<Integer> function0) {
        k21.i(sparseIntArray, "$this$getOrElse");
        k21.i(function0, "defaultValue");
        int indexOfKey = sparseIntArray.indexOfKey(i);
        return indexOfKey >= 0 ? sparseIntArray.valueAt(indexOfKey) : function0.invoke().intValue();
    }

    public static final int getSize(@NotNull SparseIntArray sparseIntArray) {
        k21.i(sparseIntArray, "$this$size");
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(@NotNull SparseIntArray sparseIntArray) {
        k21.i(sparseIntArray, "$this$isEmpty");
        return sparseIntArray.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull SparseIntArray sparseIntArray) {
        k21.i(sparseIntArray, "$this$isNotEmpty");
        return sparseIntArray.size() != 0;
    }

    @NotNull
    public static final r11 keyIterator(@NotNull SparseIntArray sparseIntArray) {
        k21.i(sparseIntArray, "$this$keyIterator");
        return new SparseIntArrayKt$keyIterator$1(sparseIntArray);
    }

    @NotNull
    public static final SparseIntArray plus(@NotNull SparseIntArray sparseIntArray, @NotNull SparseIntArray sparseIntArray2) {
        k21.i(sparseIntArray, "$this$plus");
        k21.i(sparseIntArray2, "other");
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray.size() + sparseIntArray2.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(@NotNull SparseIntArray sparseIntArray, @NotNull SparseIntArray sparseIntArray2) {
        k21.i(sparseIntArray, "$this$putAll");
        k21.i(sparseIntArray2, "other");
        int size = sparseIntArray2.size();
        for (int i = 0; i < size; i++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i), sparseIntArray2.valueAt(i));
        }
    }

    public static final boolean remove(@NotNull SparseIntArray sparseIntArray, int i, int i2) {
        k21.i(sparseIntArray, "$this$remove");
        int indexOfKey = sparseIntArray.indexOfKey(i);
        if (indexOfKey < 0 || i2 != sparseIntArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(indexOfKey);
        return true;
    }

    public static final void set(@NotNull SparseIntArray sparseIntArray, int i, int i2) {
        k21.i(sparseIntArray, "$this$set");
        sparseIntArray.put(i, i2);
    }

    @NotNull
    public static final r11 valueIterator(@NotNull SparseIntArray sparseIntArray) {
        k21.i(sparseIntArray, "$this$valueIterator");
        return new SparseIntArrayKt$valueIterator$1(sparseIntArray);
    }
}

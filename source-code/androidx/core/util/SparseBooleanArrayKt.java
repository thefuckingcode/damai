package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import tb.k21;
import tb.lc;
import tb.r11;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u001d\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\n\u001a\u0015\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0002\u001a\u0015\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\b\u001a\u0015\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\b\u001a\u001d\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0003H\b\u001a&\u0010\u000f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\bø\u0001\u0000\u001a\r\u0010\u0010\u001a\u00020\u0003*\u00020\u0000H\b\u001a\r\u0010\u0011\u001a\u00020\u0003*\u00020\u0000H\b\u001a\u001a\u0010\u0012\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0013\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000\u001aH\u0010\u0018\u001a\u00020\u0006*\u00020\u000026\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0014H\bø\u0001\u0000\u001a\n\u0010\u001a\u001a\u00020\u0019*\u00020\u0000\u001a\n\u0010\u001c\u001a\u00020\u001b*\u00020\u0000\"\u0018\u0010\u001f\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0002\u0007\n\u0005\b20\u0001¨\u0006 "}, d2 = {"Landroid/util/SparseBooleanArray;", "", "key", "", "contains", "value", "Ltb/ur2;", "set", "other", "plus", "containsKey", "containsValue", "defaultValue", "getOrDefault", "Lkotlin/Function0;", "getOrElse", "isEmpty", "isNotEmpty", "remove", "putAll", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEach", "Ltb/r11;", "keyIterator", "Ltb/lc;", "valueIterator", "getSize", "(Landroid/util/SparseBooleanArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class SparseBooleanArrayKt {
    public static final boolean contains(@NotNull SparseBooleanArray sparseBooleanArray, int i) {
        k21.i(sparseBooleanArray, "$this$contains");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(@NotNull SparseBooleanArray sparseBooleanArray, int i) {
        k21.i(sparseBooleanArray, "$this$containsKey");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(@NotNull SparseBooleanArray sparseBooleanArray, boolean z) {
        k21.i(sparseBooleanArray, "$this$containsValue");
        return sparseBooleanArray.indexOfValue(z) >= 0;
    }

    public static final void forEach(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull Function2<? super Integer, ? super Boolean, ur2> function2) {
        k21.i(sparseBooleanArray, "$this$forEach");
        k21.i(function2, "action");
        int size = sparseBooleanArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i)), Boolean.valueOf(sparseBooleanArray.valueAt(i)));
        }
    }

    public static final boolean getOrDefault(@NotNull SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        k21.i(sparseBooleanArray, "$this$getOrDefault");
        return sparseBooleanArray.get(i, z);
    }

    public static final boolean getOrElse(@NotNull SparseBooleanArray sparseBooleanArray, int i, @NotNull Function0<Boolean> function0) {
        k21.i(sparseBooleanArray, "$this$getOrElse");
        k21.i(function0, "defaultValue");
        int indexOfKey = sparseBooleanArray.indexOfKey(i);
        return indexOfKey >= 0 ? sparseBooleanArray.valueAt(indexOfKey) : function0.invoke().booleanValue();
    }

    public static final int getSize(@NotNull SparseBooleanArray sparseBooleanArray) {
        k21.i(sparseBooleanArray, "$this$size");
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(@NotNull SparseBooleanArray sparseBooleanArray) {
        k21.i(sparseBooleanArray, "$this$isEmpty");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull SparseBooleanArray sparseBooleanArray) {
        k21.i(sparseBooleanArray, "$this$isNotEmpty");
        return sparseBooleanArray.size() != 0;
    }

    @NotNull
    public static final r11 keyIterator(@NotNull SparseBooleanArray sparseBooleanArray) {
        k21.i(sparseBooleanArray, "$this$keyIterator");
        return new SparseBooleanArrayKt$keyIterator$1(sparseBooleanArray);
    }

    @NotNull
    public static final SparseBooleanArray plus(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull SparseBooleanArray sparseBooleanArray2) {
        k21.i(sparseBooleanArray, "$this$plus");
        k21.i(sparseBooleanArray2, "other");
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray.size() + sparseBooleanArray2.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull SparseBooleanArray sparseBooleanArray2) {
        k21.i(sparseBooleanArray, "$this$putAll");
        k21.i(sparseBooleanArray2, "other");
        int size = sparseBooleanArray2.size();
        for (int i = 0; i < size; i++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i), sparseBooleanArray2.valueAt(i));
        }
    }

    public static final boolean remove(@NotNull SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        k21.i(sparseBooleanArray, "$this$remove");
        int indexOfKey = sparseBooleanArray.indexOfKey(i);
        if (indexOfKey < 0 || z != sparseBooleanArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i);
        return true;
    }

    public static final void set(@NotNull SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        k21.i(sparseBooleanArray, "$this$set");
        sparseBooleanArray.put(i, z);
    }

    @NotNull
    public static final lc valueIterator(@NotNull SparseBooleanArray sparseBooleanArray) {
        k21.i(sparseBooleanArray, "$this$valueIterator");
        return new SparseBooleanArrayKt$valueIterator$1(sparseBooleanArray);
    }
}

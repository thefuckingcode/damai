package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import tb.fa1;
import tb.k21;
import tb.r11;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u001d\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\n\u001a\u0015\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0002\u001a\u0015\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\b\u001a\u0015\u0010\f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\b\u001a\u001d\u0010\u000e\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0005H\b\u001a&\u0010\u0010\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\bø\u0001\u0000\u001a\r\u0010\u0011\u001a\u00020\u0003*\u00020\u0000H\b\u001a\r\u0010\u0012\u001a\u00020\u0003*\u00020\u0000H\b\u001a\u001c\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u001a\u0014\u0010\u0014\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0007\u001aH\u0010\u0019\u001a\u00020\u0007*\u00020\u000026\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0015H\bø\u0001\u0000\u001a\f\u0010\u001b\u001a\u00020\u001a*\u00020\u0000H\u0007\u001a\f\u0010\u001d\u001a\u00020\u001c*\u00020\u0000H\u0007\"\u0018\u0010 \u001a\u00020\u0001*\u00020\u00008Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u0002\u0007\n\u0005\b20\u0001¨\u0006!"}, d2 = {"Landroid/util/SparseLongArray;", "", "key", "", "contains", "", "value", "Ltb/ur2;", "set", "other", "plus", "containsKey", "containsValue", "defaultValue", "getOrDefault", "Lkotlin/Function0;", "getOrElse", "isEmpty", "isNotEmpty", "remove", "putAll", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEach", "Ltb/r11;", "keyIterator", "Ltb/fa1;", "valueIterator", "getSize", "(Landroid/util/SparseLongArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class SparseLongArrayKt {
    @RequiresApi(18)
    public static final boolean contains(@NotNull SparseLongArray sparseLongArray, int i) {
        k21.i(sparseLongArray, "$this$contains");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsKey(@NotNull SparseLongArray sparseLongArray, int i) {
        k21.i(sparseLongArray, "$this$containsKey");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(@NotNull SparseLongArray sparseLongArray, long j) {
        k21.i(sparseLongArray, "$this$containsValue");
        return sparseLongArray.indexOfValue(j) >= 0;
    }

    @RequiresApi(18)
    public static final void forEach(@NotNull SparseLongArray sparseLongArray, @NotNull Function2<? super Integer, ? super Long, ur2> function2) {
        k21.i(sparseLongArray, "$this$forEach");
        k21.i(function2, "action");
        int size = sparseLongArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(sparseLongArray.keyAt(i)), Long.valueOf(sparseLongArray.valueAt(i)));
        }
    }

    @RequiresApi(18)
    public static final long getOrDefault(@NotNull SparseLongArray sparseLongArray, int i, long j) {
        k21.i(sparseLongArray, "$this$getOrDefault");
        return sparseLongArray.get(i, j);
    }

    @RequiresApi(18)
    public static final long getOrElse(@NotNull SparseLongArray sparseLongArray, int i, @NotNull Function0<Long> function0) {
        k21.i(sparseLongArray, "$this$getOrElse");
        k21.i(function0, "defaultValue");
        int indexOfKey = sparseLongArray.indexOfKey(i);
        return indexOfKey >= 0 ? sparseLongArray.valueAt(indexOfKey) : function0.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(@NotNull SparseLongArray sparseLongArray) {
        k21.i(sparseLongArray, "$this$size");
        return sparseLongArray.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(@NotNull SparseLongArray sparseLongArray) {
        k21.i(sparseLongArray, "$this$isEmpty");
        return sparseLongArray.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(@NotNull SparseLongArray sparseLongArray) {
        k21.i(sparseLongArray, "$this$isNotEmpty");
        return sparseLongArray.size() != 0;
    }

    @RequiresApi(18)
    @NotNull
    public static final r11 keyIterator(@NotNull SparseLongArray sparseLongArray) {
        k21.i(sparseLongArray, "$this$keyIterator");
        return new SparseLongArrayKt$keyIterator$1(sparseLongArray);
    }

    @RequiresApi(18)
    @NotNull
    public static final SparseLongArray plus(@NotNull SparseLongArray sparseLongArray, @NotNull SparseLongArray sparseLongArray2) {
        k21.i(sparseLongArray, "$this$plus");
        k21.i(sparseLongArray2, "other");
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray.size() + sparseLongArray2.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    @RequiresApi(18)
    public static final void putAll(@NotNull SparseLongArray sparseLongArray, @NotNull SparseLongArray sparseLongArray2) {
        k21.i(sparseLongArray, "$this$putAll");
        k21.i(sparseLongArray2, "other");
        int size = sparseLongArray2.size();
        for (int i = 0; i < size; i++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i), sparseLongArray2.valueAt(i));
        }
    }

    @RequiresApi(18)
    public static final boolean remove(@NotNull SparseLongArray sparseLongArray, int i, long j) {
        k21.i(sparseLongArray, "$this$remove");
        int indexOfKey = sparseLongArray.indexOfKey(i);
        if (indexOfKey < 0 || j != sparseLongArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void set(@NotNull SparseLongArray sparseLongArray, int i, long j) {
        k21.i(sparseLongArray, "$this$set");
        sparseLongArray.put(i, j);
    }

    @RequiresApi(18)
    @NotNull
    public static final fa1 valueIterator(@NotNull SparseLongArray sparseLongArray) {
        k21.i(sparseLongArray, "$this$valueIterator");
        return new SparseLongArrayKt$valueIterator$1(sparseLongArray);
    }
}

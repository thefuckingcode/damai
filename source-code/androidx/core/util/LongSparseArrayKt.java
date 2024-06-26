package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import tb.fa1;
import tb.k21;
import tb.ur2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a!\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n\u001a0\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\n¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0002\u001a!\u0010\f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\b\u001a(\u0010\r\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\b¢\u0006\u0004\b\r\u0010\u000e\u001a0\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a9\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0019\u0010\u0015\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\b\u001a\u0019\u0010\u0016\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\b\u001a/\u0010\u0017\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a&\u0010\u0019\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u001aT\u0010\u001e\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u001aH\bø\u0001\u0000\u001a\u0018\u0010 \u001a\u00020\u001f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u001a\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\"$\u0010&\u001a\u00020#\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018Ç\u0002@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010%\u0002\u0007\n\u0005\b20\u0001¨\u0006'"}, d2 = {"T", "Landroid/util/LongSparseArray;", "", "key", "", "contains", "value", "Ltb/ur2;", "set", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)V", "other", "plus", "containsKey", "containsValue", "(Landroid/util/LongSparseArray;Ljava/lang/Object;)Z", "defaultValue", "getOrDefault", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(Landroid/util/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "remove", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Z", "putAll", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEach", "Ltb/fa1;", "keyIterator", "", "valueIterator", "", "getSize", "(Landroid/util/LongSparseArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class LongSparseArrayKt {
    @RequiresApi(16)
    public static final <T> boolean contains(@NotNull LongSparseArray<T> longSparseArray, long j) {
        k21.i(longSparseArray, "$this$contains");
        return longSparseArray.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsKey(@NotNull LongSparseArray<T> longSparseArray, long j) {
        k21.i(longSparseArray, "$this$containsKey");
        return longSparseArray.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsValue(@NotNull LongSparseArray<T> longSparseArray, T t) {
        k21.i(longSparseArray, "$this$containsValue");
        return longSparseArray.indexOfValue(t) >= 0;
    }

    @RequiresApi(16)
    public static final <T> void forEach(@NotNull LongSparseArray<T> longSparseArray, @NotNull Function2<? super Long, ? super T, ur2> function2) {
        k21.i(longSparseArray, "$this$forEach");
        k21.i(function2, "action");
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Long.valueOf(longSparseArray.keyAt(i)), longSparseArray.valueAt(i));
        }
    }

    @RequiresApi(16)
    public static final <T> T getOrDefault(@NotNull LongSparseArray<T> longSparseArray, long j, T t) {
        k21.i(longSparseArray, "$this$getOrDefault");
        T t2 = longSparseArray.get(j);
        return t2 != null ? t2 : t;
    }

    @RequiresApi(16)
    public static final <T> T getOrElse(@NotNull LongSparseArray<T> longSparseArray, long j, @NotNull Function0<? extends T> function0) {
        k21.i(longSparseArray, "$this$getOrElse");
        k21.i(function0, "defaultValue");
        T t = longSparseArray.get(j);
        return t != null ? t : (T) function0.invoke();
    }

    @RequiresApi(16)
    public static final <T> int getSize(@NotNull LongSparseArray<T> longSparseArray) {
        k21.i(longSparseArray, "$this$size");
        return longSparseArray.size();
    }

    @RequiresApi(16)
    public static final <T> boolean isEmpty(@NotNull LongSparseArray<T> longSparseArray) {
        k21.i(longSparseArray, "$this$isEmpty");
        return longSparseArray.size() == 0;
    }

    @RequiresApi(16)
    public static final <T> boolean isNotEmpty(@NotNull LongSparseArray<T> longSparseArray) {
        k21.i(longSparseArray, "$this$isNotEmpty");
        return longSparseArray.size() != 0;
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> fa1 keyIterator(@NotNull LongSparseArray<T> longSparseArray) {
        k21.i(longSparseArray, "$this$keyIterator");
        return new LongSparseArrayKt$keyIterator$1(longSparseArray);
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> LongSparseArray<T> plus(@NotNull LongSparseArray<T> longSparseArray, @NotNull LongSparseArray<T> longSparseArray2) {
        k21.i(longSparseArray, "$this$plus");
        k21.i(longSparseArray2, "other");
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray.size() + longSparseArray2.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    @RequiresApi(16)
    public static final <T> void putAll(@NotNull LongSparseArray<T> longSparseArray, @NotNull LongSparseArray<T> longSparseArray2) {
        k21.i(longSparseArray, "$this$putAll");
        k21.i(longSparseArray2, "other");
        int size = longSparseArray2.size();
        for (int i = 0; i < size; i++) {
            longSparseArray.put(longSparseArray2.keyAt(i), longSparseArray2.valueAt(i));
        }
    }

    @RequiresApi(16)
    public static final <T> boolean remove(@NotNull LongSparseArray<T> longSparseArray, long j, T t) {
        k21.i(longSparseArray, "$this$remove");
        int indexOfKey = longSparseArray.indexOfKey(j);
        if (indexOfKey < 0 || !k21.d(t, longSparseArray.valueAt(indexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(16)
    public static final <T> void set(@NotNull LongSparseArray<T> longSparseArray, long j, T t) {
        k21.i(longSparseArray, "$this$set");
        longSparseArray.put(j, t);
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull LongSparseArray<T> longSparseArray) {
        k21.i(longSparseArray, "$this$valueIterator");
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }
}

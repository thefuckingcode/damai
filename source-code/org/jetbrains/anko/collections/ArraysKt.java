package org.jetbrains.anko.collections;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\b\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0005H\b\u001a\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0007H\b\u001a2\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t0\fH\b¢\u0006\u0002\u0010\r\u001a2\u0010\u000e\u001a\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t0\fH\b¢\u0006\u0002\u0010\r\u001a8\u0010\u000f\u001a\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t0\u0010H\b¢\u0006\u0002\u0010\u0011\u001a8\u0010\u0012\u001a\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t0\u0010H\b¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, d2 = {"asSequence", "Lkotlin/sequences/Sequence;", "T", "Landroid/util/SparseArray;", "", "Landroid/util/SparseBooleanArray;", "", "Landroid/util/SparseIntArray;", "forEachByIndex", "", "", "f", "Lkotlin/Function1;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachReversedByIndex", "forEachReversedWithIndex", "Lkotlin/Function2;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "forEachWithIndex", "commons-base_release"}, k = 2, mv = {1, 1, 11})
/* compiled from: Arrays.kt */
public final class ArraysKt {
    @Deprecated(message = "Use the native Kotlin version", replaceWith = @ReplaceWith(expression = "forEach(f)", imports = {}))
    public static final <T> void forEachByIndex(T[] tArr, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        int length = tArr.length - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                function1.invoke(tArr[i]);
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Deprecated(message = "Use the native Kotlin version", replaceWith = @ReplaceWith(expression = "forEachIndexed(f)", imports = {}))
    public static final <T> void forEachWithIndex(T[] tArr, Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(tArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        int length = tArr.length - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                function2.invoke(Integer.valueOf(i), tArr[i]);
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final <T> void forEachReversedByIndex(T[] tArr, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        for (int length = tArr.length - 1; length >= 0; length--) {
            function1.invoke(tArr[length]);
        }
    }

    public static final <T> void forEachReversedWithIndex(T[] tArr, Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(tArr, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        for (int length = tArr.length - 1; length >= 0; length--) {
            function2.invoke(Integer.valueOf(length), tArr[length]);
        }
    }

    public static final <T> Sequence<T> asSequence(SparseArray<T> sparseArray) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$receiver");
        return new SparseArraySequence(sparseArray);
    }

    public static final <T> Sequence<Boolean> asSequence(SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$receiver");
        return new SparseBooleanArraySequence(sparseBooleanArray);
    }

    public static final <T> Sequence<Integer> asSequence(SparseIntArray sparseIntArray) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$receiver");
        return new SparseIntArraySequence(sparseIntArray);
    }
}

package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.w11;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public class m extends l {
    @NotNull
    public static final <T> Collection<T> f(@NotNull T[] tArr) {
        k21.i(tArr, "<this>");
        return new d(tArr, false);
    }

    @NotNull
    public static <T> List<T> g() {
        return EmptyList.INSTANCE;
    }

    @NotNull
    public static w11 h(@NotNull Collection<?> collection) {
        k21.i(collection, "<this>");
        return new w11(0, collection.size() - 1);
    }

    public static <T> int i(@NotNull List<? extends T> list) {
        k21.i(list, "<this>");
        return list.size() - 1;
    }

    @NotNull
    public static <T> List<T> j(@NotNull T... tArr) {
        k21.i(tArr, "elements");
        return tArr.length > 0 ? h.d(tArr) : g();
    }

    @NotNull
    public static <T> List<T> k(@Nullable T t) {
        return t != null ? l.e(t) : g();
    }

    @NotNull
    public static <T> List<T> l(@NotNull T... tArr) {
        k21.i(tArr, "elements");
        return ArraysKt___ArraysKt.s(tArr);
    }

    @NotNull
    public static <T> List<T> m(@NotNull T... tArr) {
        k21.i(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new d(tArr, true));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> List<T> n(@NotNull List<? extends T> list) {
        k21.i(list, "<this>");
        int size = list.size();
        if (size == 0) {
            return g();
        }
        if (size != 1) {
            return list;
        }
        return l.e(list.get(0));
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void o() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static void p() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}

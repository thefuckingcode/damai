package tb;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.collections.m;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class v41 {
    @NotNull
    private static final en0 a;
    @NotNull
    private static final en0 b;
    @NotNull
    private static final en0 c;
    @NotNull
    private static final List<en0> d;
    @NotNull
    private static final en0 e;
    @NotNull
    private static final en0 f = new en0("javax.annotation.CheckForNull");
    @NotNull
    private static final List<en0> g;
    @NotNull
    private static final en0 h;
    @NotNull
    private static final en0 i;
    @NotNull
    private static final en0 j;
    @NotNull
    private static final en0 k;
    @NotNull
    private static final List<en0> l = m.j(u41.JETBRAINS_READONLY_ANNOTATION, u41.READONLY_ANNOTATION);
    @NotNull
    private static final List<en0> m = m.j(u41.JETBRAINS_MUTABLE_ANNOTATION, u41.MUTABLE_ANNOTATION);

    static {
        en0 en0 = new en0("org.jspecify.annotations.Nullable");
        a = en0;
        en0 en02 = new en0("org.jspecify.annotations.NullnessUnspecified");
        b = en02;
        en0 en03 = new en0("org.jspecify.annotations.DefaultNonNull");
        c = en03;
        List<en0> list = m.j(u41.JETBRAINS_NULLABLE_ANNOTATION, new en0("androidx.annotation.Nullable"), new en0("android.support.annotation.Nullable"), new en0("android.annotation.Nullable"), new en0("com.android.annotations.Nullable"), new en0("org.eclipse.jdt.annotation.Nullable"), new en0("org.checkerframework.checker.nullness.qual.Nullable"), new en0("javax.annotation.Nullable"), new en0("javax.annotation.CheckForNull"), new en0("edu.umd.cs.findbugs.annotations.CheckForNull"), new en0("edu.umd.cs.findbugs.annotations.Nullable"), new en0("edu.umd.cs.findbugs.annotations.PossiblyNull"), new en0("io.reactivex.annotations.Nullable"));
        d = list;
        en0 en04 = new en0("javax.annotation.Nonnull");
        e = en04;
        List<en0> list2 = m.j(u41.JETBRAINS_NOT_NULL_ANNOTATION, new en0("edu.umd.cs.findbugs.annotations.NonNull"), new en0("androidx.annotation.NonNull"), new en0("android.support.annotation.NonNull"), new en0("android.annotation.NonNull"), new en0("com.android.annotations.NonNull"), new en0("org.eclipse.jdt.annotation.NonNull"), new en0("org.checkerframework.checker.nullness.qual.NonNull"), new en0("lombok.NonNull"), new en0("io.reactivex.annotations.NonNull"));
        g = list2;
        en0 en05 = new en0("org.checkerframework.checker.nullness.compatqual.NullableDecl");
        h = en05;
        en0 en06 = new en0("org.checkerframework.checker.nullness.compatqual.NonNullDecl");
        i = en06;
        en0 en07 = new en0("androidx.annotation.RecentlyNullable");
        j = en07;
        en0 en08 = new en0("androidx.annotation.RecentlyNonNull");
        k = en08;
        Set<T> unused = f0.j(f0.j(f0.j(f0.j(f0.j(f0.j(f0.j(f0.i(f0.j(f0.i(new LinkedHashSet(), list), en04), list2), en05), en06), en07), en08), en0), en02), en03);
    }

    @NotNull
    public static final en0 a() {
        return k;
    }

    @NotNull
    public static final en0 b() {
        return j;
    }

    @NotNull
    public static final en0 c() {
        return i;
    }

    @NotNull
    public static final en0 d() {
        return h;
    }

    @NotNull
    public static final en0 e() {
        return f;
    }

    @NotNull
    public static final en0 f() {
        return e;
    }

    @NotNull
    public static final en0 g() {
        return c;
    }

    @NotNull
    public static final en0 h() {
        return a;
    }

    @NotNull
    public static final en0 i() {
        return b;
    }

    @NotNull
    public static final List<en0> j() {
        return m;
    }

    @NotNull
    public static final List<en0> k() {
        return g;
    }

    @NotNull
    public static final List<en0> l() {
        return d;
    }

    @NotNull
    public static final List<en0> m() {
        return l;
    }
}

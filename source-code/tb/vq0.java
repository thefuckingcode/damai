package tb;

import com.alipay.sdk.m.k.b;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class vq0 {
    @NotNull
    private final String a;
    @NotNull
    private final String b;
    private final int c;
    @NotNull
    private final String d;
    @NotNull
    private final String e;
    @NotNull
    private final String f;
    @NotNull
    private final String g;
    @NotNull
    private String h = "";

    public vq0(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        k21.i(str, "id");
        k21.i(str2, b.l);
        k21.i(str3, "layer");
        k21.i(str4, "css");
        k21.i(str5, "dataBind");
        k21.i(str6, "js");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
    }

    @NotNull
    public final String a() {
        return this.b;
    }

    @NotNull
    public final String b() {
        return this.e;
    }

    @NotNull
    public final String c() {
        return this.f;
    }

    @NotNull
    public final String d() {
        return this.a;
    }

    @NotNull
    public final String e() {
        return this.g;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k21.d(vq0.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.gaiax.template.GXTemplate");
        vq0 vq0 = (vq0) obj;
        return k21.d(this.a, vq0.a) && k21.d(this.b, vq0.b) && this.c == vq0.c;
    }

    @NotNull
    public final String f() {
        return this.d;
    }

    @NotNull
    public final String g() {
        return this.h;
    }

    public final int h() {
        return this.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
    }

    public final void i(@NotNull String str) {
        k21.i(str, "<set-?>");
        this.h = str;
    }

    @NotNull
    public String toString() {
        return "GXTemplate(id='" + this.a + "', biz='" + this.b + "', version=" + this.c + ')';
    }
}

package tb;

import com.alibaba.fastjson.JSONObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class wo0 {
    @NotNull
    private final wq0 a;
    @NotNull
    private final up0 b;
    @NotNull
    private final JSONObject c;

    public wo0(@NotNull wq0 wq0, @NotNull up0 up0, @NotNull JSONObject jSONObject) {
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "gxNode");
        k21.i(jSONObject, "templateData");
        this.a = wq0;
        this.b = up0;
        this.c = jSONObject;
    }

    @NotNull
    public final up0 a() {
        return this.b;
    }

    @NotNull
    public final wq0 b() {
        return this.a;
    }

    @NotNull
    public final JSONObject c() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wo0)) {
            return false;
        }
        wo0 wo0 = (wo0) obj;
        return k21.d(this.a, wo0.a) && k21.d(this.b, wo0.b) && k21.d(this.c, wo0.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    @NotNull
    public String toString() {
        return "GXDirtyText(gxTemplateContext=" + this.a + ", gxNode=" + this.b + ", templateData=" + this.c + ')';
    }
}

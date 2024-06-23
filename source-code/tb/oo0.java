package tb;

import com.alibaba.fastjson.JSONObject;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.k;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
public final class oo0 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final oo0 g = new oo0();
    @NotNull
    private StringBuilder a = new StringBuilder();
    @NotNull
    private String b = "";
    @NotNull
    private StringBuilder c = new StringBuilder();
    @NotNull
    private StringBuilder d = new StringBuilder();
    @NotNull
    private final JSONObject e = new JSONObject();
    private int f;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @NotNull
        public final oo0 a() {
            return oo0.g;
        }
    }

    private final void b(JSONObject jSONObject, char c2) {
        int i = this.f;
        if (i == 0) {
            d(c2);
        } else if (i == 1) {
            c(jSONObject, c2);
        } else if (i == 2) {
            f(c2);
        }
    }

    private final void c(JSONObject jSONObject, char c2) {
        if (c2 == ':') {
            this.f = 2;
        } else if (c2 == '}') {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putAll(this.e);
            jSONObject.put((Object) this.b, (Object) jSONObject2);
            this.e.clear();
            this.f = 0;
        } else {
            this.c.append(c2);
        }
    }

    private final void d(char c2) {
        if ('{' == c2) {
            this.f = 1;
            String sb = this.a.toString();
            k21.h(sb, "selectorName.toString()");
            String obj = StringsKt__StringsKt.T0(sb).toString();
            Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
            String substring = obj.substring(1);
            k21.h(substring, "(this as java.lang.String).substring(startIndex)");
            this.b = substring;
            StringBuilder unused = k.f(this.a);
            return;
        }
        this.a.append(c2);
    }

    private final void f(char c2) {
        if (';' == c2) {
            JSONObject jSONObject = this.e;
            String sb = this.c.toString();
            k21.h(sb, "propertyName.toString()");
            String obj = StringsKt__StringsKt.T0(sb).toString();
            String sb2 = this.d.toString();
            k21.h(sb2, "valueName.toString()");
            jSONObject.put((Object) obj, (Object) StringsKt__StringsKt.T0(sb2).toString());
            StringBuilder unused = k.f(this.c);
            StringBuilder unused2 = k.f(this.d);
            this.f = 1;
            return;
        }
        this.d.append(c2);
    }

    @NotNull
    public final JSONObject e(@NotNull String str) {
        k21.i(str, "css");
        JSONObject jSONObject = new JSONObject();
        int length = str.length() - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                b(jSONObject, str.charAt(i));
                if (i2 > length) {
                    break;
                }
                i = i2;
            }
        }
        return jSONObject;
    }
}

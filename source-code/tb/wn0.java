package tb;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.gaiax.template.animation.GXIAnimation;
import com.alibaba.gaiax.template.animation.GXPropAnimationSet;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class wn0 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final String a;
    private final boolean b;
    @Nullable
    private final GXIExpression c;
    @NotNull
    private final GXIAnimation d;
    @Nullable
    private final GXIExpression e;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }

        @Nullable
        public final wn0 a(@Nullable String str, @NotNull JSONObject jSONObject) {
            String str2;
            GXPropAnimationSet a;
            GXIExpression b;
            Object a2;
            k21.i(jSONObject, "data");
            String string = jSONObject.getString("type");
            if (string == null) {
                return null;
            }
            if ((o.w(k61.TAG, string, true)) || (o.w("PROP", string, true)) || !((b = yo0.INSTANCE.b(str, string)) == null || (a2 = GXIExpression.a.a(b, null, 1, null)) == null || (string = a2.toString()) == null)) {
                str2 = string;
            } else {
                str2 = "";
            }
            boolean booleanValue = jSONObject.getBooleanValue("trigger");
            GXIExpression b2 = jSONObject.containsKey("state") ? yo0.INSTANCE.b(str, jSONObject.getString("state")) : null;
            GXIExpression b3 = yo0.INSTANCE.b(str, jSONObject);
            if (o.w(k61.TAG, str2, true)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("lottieAnimator");
                if (jSONObject2 != null) {
                    jSONObject = jSONObject2;
                }
                mp0 a3 = mp0.Companion.a(str, jSONObject);
                if (a3 != null) {
                    return new wn0(str2, booleanValue, b2, a3, b3);
                }
                return null;
            } else if (!(o.w("PROP", str2, true)) || (a = GXPropAnimationSet.Companion.a(jSONObject.getJSONObject("propAnimatorSet"))) == null) {
                return null;
            } else {
                return new wn0(str2, booleanValue, b2, a, b3);
            }
        }
    }

    public wn0(@NotNull String str, boolean z, @Nullable GXIExpression gXIExpression, @NotNull GXIAnimation gXIAnimation, @Nullable GXIExpression gXIExpression2) {
        k21.i(str, "type");
        k21.i(gXIAnimation, "gxAnimation");
        this.a = str;
        this.b = z;
        this.c = gXIExpression;
        this.d = gXIAnimation;
        this.e = gXIExpression2;
    }

    public final void a(@NotNull wq0 wq0, @NotNull up0 up0, @NotNull JSONObject jSONObject) {
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "gxNode");
        k21.i(jSONObject, "gxTemplateData");
        GXIExpression gXIExpression = this.c;
        Object value = gXIExpression == null ? null : gXIExpression.value(jSONObject);
        if (this.b && k21.d(yo0.INSTANCE.c(wq0.k().m(), value), Boolean.TRUE)) {
            this.d.executeAnimation(this.c, this.e, wq0, up0, jSONObject);
        } else if (!this.b) {
            this.d.executeAnimation(this.c, this.e, wq0, up0, jSONObject);
        }
    }

    @NotNull
    public final String b() {
        return this.a;
    }
}

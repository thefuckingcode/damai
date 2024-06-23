package tb;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.GXViewExtKt;
import com.alibaba.gaiax.render.view.basic.GXText;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.m70;

/* compiled from: Taobao */
public final class bp0 {
    @NotNull
    public static final bp0 INSTANCE = new bp0();

    private bp0() {
    }

    private final CharSequence b(wq0 wq0, String str, View view, no0 no0, xq0 xq0, JSONObject jSONObject) {
        CharSequence b;
        JSONObject d = xq0.d(jSONObject);
        Object obj = d == null ? null : d.get("value");
        if ((obj instanceof String) && (b = gp0.INSTANCE.b(view, xq0, jSONObject, (String) obj)) != null) {
            return b;
        }
        Object c = c(wq0, str, view, no0, xq0, jSONObject);
        if (c != null) {
            if (c instanceof CharSequence) {
                return (CharSequence) c;
            }
            return c.toString();
        } else if (obj != null) {
            return obj.toString();
        } else {
            return null;
        }
    }

    private final Object c(wq0 wq0, String str, View view, no0 no0, xq0 xq0, JSONObject jSONObject) {
        String str2;
        GXTemplateEngine.GXIDataListener b;
        CharSequence onTextProcess;
        Object obj;
        GXTemplateEngine.g j = wq0.j();
        if ((j == null ? null : j.b()) != null) {
            JSONObject d = xq0.d(jSONObject);
            GXTemplateEngine.i iVar = new GXTemplateEngine.i();
            if (d == null || (obj = d.get("value")) == null) {
                str2 = null;
            } else {
                str2 = obj.toString();
            }
            iVar.m(str2);
            iVar.g(view);
            iVar.e(str);
            iVar.f(wq0.l());
            iVar.k(no0);
            iVar.l(d);
            iVar.d(Integer.valueOf(wq0.e()));
            iVar.j(xq0.h(jSONObject));
            GXTemplateEngine.g j2 = wq0.j();
            if (!(j2 == null || (b = j2.b()) == null || (onTextProcess = b.onTextProcess(iVar)) == null)) {
                return onTextProcess;
            }
        }
        return null;
    }

    @Nullable
    public final ob2<m70> a(@NotNull wq0 wq0, @NotNull up0 up0, @NotNull xq0 xq0, @NotNull sq0 sq0, @NotNull JSONObject jSONObject) {
        no0 i;
        ob2<m70> ob2;
        m70 b;
        m70 c;
        m70 a;
        m70 d;
        k21.i(wq0, "gxTemplateContext");
        k21.i(up0, "gxNode");
        k21.i(xq0, "gxTemplateNode");
        k21.i(sq0, "gxStretchNode");
        k21.i(jSONObject, "templateData");
        m70 m70 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        r9 = null;
        ob2<m70> ob22 = null;
        if ((!xq0.E() && !xq0.B()) || !up0.B()) {
            return null;
        }
        Context c2 = wq0.c();
        String o = xq0.o();
        if (xq0.e() == null || (i = xq0.i()) == null) {
            return null;
        }
        cp0 a2 = i.a();
        uq0 b2 = i.b();
        r61 b3 = sq0.b();
        if (b3 == null && (b3 = sq0.c()) == null) {
            return null;
        }
        op0 op0 = op0.INSTANCE;
        GXText b4 = op0.b(c2);
        b4.setTextStyle(i);
        CharSequence b5 = b(wq0, o, b4, i, xq0, jSONObject);
        if (b5 == null) {
            op0.d(b4);
            return null;
        }
        b4.setText(b5);
        Integer m = b2.m();
        float e = b3.e();
        float d2 = b3.d();
        ob2<m70> u = a2.u();
        m70 a3 = u == null ? null : u.a();
        boolean z = true;
        if (sq0.b() == null && (a3 instanceof m70.c)) {
            m70.c cVar = (m70.c) a3;
            if (!(d2 == cVar.b())) {
                d2 = cVar.b();
            }
        }
        if (m == null || m.intValue() == 1) {
            b4.setSingleLine(true);
            b4.measure(0, 0);
            float measuredWidth = (float) b4.getMeasuredWidth();
            float measuredHeight = (float) b4.getMeasuredHeight();
            ob2<m70> u2 = i.a().u();
            if (u2 != null) {
                m70 = u2.b();
            }
            boolean z2 = m70 == null || (i.a().u().b() instanceof m70.a) || (i.a().u().b() instanceof m70.d);
            boolean z3 = i.a().p() != null && (!(i.a().p().b() instanceof m70.a) || !(i.a().p().b() instanceof m70.d));
            if (z2 && z3) {
                if (measuredWidth < e) {
                    measuredWidth = e;
                }
                e = 0.0f;
            }
            ox1<m70> r = a2.r();
            float b6 = (r == null || (d = r.d()) == null) ? 0.0f : d.b();
            ox1<m70> r2 = a2.r();
            if (d2 == b6 + ((r2 != null && (a = r2.a()) != null) ? a.b() : 0.0f)) {
                d2 = 0.0f;
            }
            if (!(d2 == 0.0f)) {
                measuredHeight = d2;
            }
            ox1<m70> r3 = a2.r();
            float b7 = (r3 == null || (c = r3.c()) == null) ? 0.0f : c.b();
            ox1<m70> r4 = a2.r();
            float b8 = b7 + ((r4 == null || (b = r4.b()) == null) ? 0.0f : b.b());
            if (e == 0.0f) {
                ob2 = new ob2<>(new m70.c(measuredWidth), new m70.c(measuredHeight));
            } else {
                if (e != b8) {
                    z = false;
                }
                if (z) {
                    ob2 = new ob2<>(new m70.c(measuredWidth), new m70.c(measuredHeight));
                } else if (measuredWidth >= e) {
                    ob22 = new ob2<>(new m70.c(e), new m70.c(measuredHeight));
                } else {
                    ob2 = new ob2<>(new m70.c(measuredWidth), new m70.c(measuredHeight));
                }
            }
            ob22 = ob2;
        } else if (m.intValue() == 0) {
            GXViewExtKt.i(b4, m);
            if (e == 0.0f) {
                GXRegisterCenter.GXIExtensionCompatibility d3 = GXRegisterCenter.Companion.a().d();
                if (d3 == null || !d3.isPreventFitContentThrowException()) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("If lines = 0 or lines > 1, you must set text width");
                }
            } else if (e > 0.0f) {
                b4.measure(View.MeasureSpec.makeMeasureSpec((int) e, Integer.MIN_VALUE), 0);
                ob22 = new ob2<>(new m70.c(e), new m70.c((float) b4.getMeasuredHeight()));
            }
        } else if (m.intValue() > 1) {
            GXViewExtKt.i(b4, m);
            if (e == 0.0f) {
                GXRegisterCenter.GXIExtensionCompatibility d4 = GXRegisterCenter.Companion.a().d();
                if (d4 == null || !d4.isPreventFitContentThrowException()) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("If lines = 0 or lines > 1, you must set text width");
                }
            } else if (e > 0.0f) {
                b4.measure(View.MeasureSpec.makeMeasureSpec((int) e, Integer.MIN_VALUE), 0);
                ob22 = new ob2<>(new m70.c((float) b4.getMeasuredWidth()), new m70.c((float) b4.getMeasuredHeight()));
            }
        }
        op0.d(b4);
        return ob22;
    }
}

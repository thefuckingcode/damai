package com.alibaba.android.bindingx.core.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.bindingx.core.BindingXCore;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.alibaba.android.bindingx.core.internal.OrientationDetector;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tb.ag0;
import tb.f91;
import tb.jl1;

/* compiled from: Taobao */
public class b extends AbstractEventHandler implements OrientationDetector.OnOrientationChangedListener {
    private p A = new p(0.0d, 0.0d, 1.0d);
    private p B = new p(0.0d, 1.0d, 1.0d);
    private a C = new a(0.0d, 0.0d, 0.0d);
    private boolean n = false;
    private double o;
    private double p;
    private double q;
    private double r;
    private double s;
    private double t;
    private OrientationDetector u;
    private k v;
    private k w;
    private k x;
    private String y;
    private LinkedList<Double> z = new LinkedList<>();

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        double a;
        double b;
        double c;

        a(double d, double d2, double d3) {
            this.a = d;
            this.b = d2;
            this.c = d3;
        }
    }

    public b(Context context, PlatformManager platformManager, Object... objArr) {
        super(context, platformManager, objArr);
        if (context != null) {
            this.u = OrientationDetector.f(context);
        }
    }

    private boolean i(double d, double d2, double d3) {
        if (!(this.v == null || this.w == null)) {
            this.z.add(Double.valueOf(d));
            if (this.z.size() > 5) {
                this.z.removeFirst();
            }
            l(this.z, 360);
            LinkedList<Double> linkedList = this.z;
            double doubleValue = (linkedList.get(linkedList.size() - 1).doubleValue() - this.o) % 360.0d;
            l a2 = this.v.a(d, d2, d3, doubleValue);
            l a3 = this.w.a(d, d2, d3, doubleValue);
            this.A.b(0.0d, 0.0d, 1.0d);
            this.A.a(a2);
            this.B.b(0.0d, 1.0d, 1.0d);
            this.B.a(a3);
            double degrees = Math.toDegrees(Math.acos(this.A.a)) - 90.0d;
            double degrees2 = Math.toDegrees(Math.acos(this.B.b)) - 90.0d;
            if (Double.isNaN(degrees) || Double.isNaN(degrees2) || Double.isInfinite(degrees) || Double.isInfinite(degrees2)) {
                return false;
            }
            a aVar = this.C;
            aVar.a = (double) Math.round(degrees);
            aVar.b = (double) Math.round(degrees2);
        }
        return true;
    }

    private boolean j(double d, double d2, double d3) {
        if (this.x != null) {
            this.z.add(Double.valueOf(d));
            if (this.z.size() > 5) {
                this.z.removeFirst();
            }
            l(this.z, 360);
            LinkedList<Double> linkedList = this.z;
            l a2 = this.x.a(d, d2, d3, (linkedList.get(linkedList.size() - 1).doubleValue() - this.o) % 360.0d);
            if (Double.isNaN(a2.a) || Double.isNaN(a2.b) || Double.isNaN(a2.c) || Double.isInfinite(a2.a) || Double.isInfinite(a2.b) || Double.isInfinite(a2.c)) {
                return false;
            }
            a aVar = this.C;
            aVar.a = a2.a;
            aVar.b = a2.b;
            aVar.c = a2.c;
        }
        return true;
    }

    private void k(String str, double d, double d2, double d3, Object... objArr) {
        if (this.c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("state", str);
            hashMap.put("alpha", Double.valueOf(d));
            hashMap.put("beta", Double.valueOf(d2));
            hashMap.put("gamma", Double.valueOf(d3));
            hashMap.put("token", this.g);
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Map)) {
                hashMap.putAll((Map) objArr[0]);
            }
            this.c.callback(hashMap);
            f91.a(">>>>>>>>>>>fire event:(" + str + "," + d + "," + d2 + "," + d3 + jl1.BRACKET_END_STR);
        }
    }

    private void l(List<Double> list, int i) {
        int size = list.size();
        if (size > 1) {
            for (int i2 = 1; i2 < size; i2++) {
                int i3 = i2 - 1;
                if (!(list.get(i3) == null || list.get(i2) == null)) {
                    if (list.get(i2).doubleValue() - list.get(i3).doubleValue() < ((double) ((-i) / 2))) {
                        double d = (double) i;
                        list.set(i2, Double.valueOf(list.get(i2).doubleValue() + ((Math.floor(list.get(i3).doubleValue() / d) + 1.0d) * d)));
                    }
                    if (list.get(i2).doubleValue() - list.get(i3).doubleValue() > ((double) (i / 2))) {
                        list.set(i2, Double.valueOf(list.get(i2).doubleValue() - ((double) i)));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    public void e(@NonNull Map<String, Object> map) {
        k("exit", ((Double) map.get("alpha")).doubleValue(), ((Double) map.get("beta")).doubleValue(), ((Double) map.get("gamma")).doubleValue(), new Object[0]);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    public void f(String str, @NonNull Map<String, Object> map) {
        k("interceptor", ((Double) map.get("alpha")).doubleValue(), ((Double) map.get("beta")).doubleValue(), ((Double) map.get("gamma")).doubleValue(), Collections.singletonMap("interceptor", str));
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityPause() {
        OrientationDetector orientationDetector = this.u;
        if (orientationDetector != null) {
            orientationDetector.q();
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityResume() {
        OrientationDetector orientationDetector = this.u;
        if (orientationDetector != null) {
            orientationDetector.p(1);
        }
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onBindExpression(@NonNull String str, @Nullable Map<String, Object> map, @Nullable ag0 ag0, @NonNull List<Map<String, Object>> list, @Nullable BindingXCore.JavaScriptCallback javaScriptCallback) {
        String str2;
        super.onBindExpression(str, map, ag0, list, javaScriptCallback);
        if (map != null) {
            String str3 = (String) map.get("sceneType");
            str2 = TextUtils.isEmpty(str3) ? "2d" : str3.toLowerCase();
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2) || (!"2d".equals(str2) && !"3d".equals(str2))) {
            str2 = "2d";
        }
        this.y = str2;
        f91.a("[ExpressionOrientationHandler] sceneType is " + str2);
        if ("2d".equals(str2)) {
            this.v = new k(null, Double.valueOf(90.0d), null);
            this.w = new k(Double.valueOf(0.0d), null, Double.valueOf(90.0d));
        } else if ("3d".equals(str2)) {
            this.x = new k(null, null, null);
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onCreate(@NonNull String str, @NonNull String str2) {
        OrientationDetector orientationDetector = this.u;
        if (orientationDetector == null) {
            return false;
        }
        orientationDetector.a(this);
        return this.u.p(1);
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onDestroy() {
        super.onDestroy();
        OrientationDetector orientationDetector = this.u;
        if (orientationDetector != null) {
            orientationDetector.n(this);
            this.u.q();
        }
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onDisable(@NonNull String str, @NonNull String str2) {
        b();
        if (this.u == null) {
            return false;
        }
        k("end", this.r, this.s, this.t, new Object[0]);
        return this.u.n(this);
    }

    @Override // com.alibaba.android.bindingx.core.internal.OrientationDetector.OnOrientationChangedListener
    public void onOrientationChanged(double d, double d2, double d3) {
        char c;
        double d4;
        boolean z2;
        double round = (double) Math.round(d);
        double round2 = (double) Math.round(d2);
        double round3 = (double) Math.round(d3);
        if (round != this.r || round2 != this.s || round3 != this.t) {
            if (!this.n) {
                this.n = true;
                c = 0;
                k("start", round, round2, round3, new Object[0]);
                this.o = round;
                this.p = round2;
                d4 = round3;
                this.q = d4;
            } else {
                d4 = round3;
                c = 0;
            }
            if ("2d".equals(this.y)) {
                z2 = i(round, round2, d4);
            } else {
                z2 = "3d".equals(this.y) ? j(round, round2, d4) : false;
            }
            if (z2) {
                a aVar = this.C;
                double d5 = aVar.a;
                double d6 = aVar.b;
                double d7 = aVar.c;
                this.r = round;
                this.s = round2;
                this.t = d4;
                try {
                    if (f91.a) {
                        Locale locale = Locale.getDefault();
                        Object[] objArr = new Object[6];
                        objArr[c] = Double.valueOf(round);
                        objArr[1] = Double.valueOf(round2);
                        objArr[2] = Double.valueOf(d4);
                        objArr[3] = Double.valueOf(d5);
                        objArr[4] = Double.valueOf(d6);
                        objArr[5] = Double.valueOf(d7);
                        f91.a(String.format(locale, "[OrientationHandler] orientation changed. (alpha:%f,beta:%f,gamma:%f,x:%f,y:%f,z:%f)", objArr));
                    }
                    JSMath.applyOrientationValuesToScope(this.d, round, round2, d4, this.o, this.p, this.q, d5, d6, d7);
                    if (!d(this.j, this.d)) {
                        c(this.a, this.d, "orientation");
                    }
                } catch (Exception e) {
                    f91.c("runtime error", e);
                }
            }
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onStart(@NonNull String str, @NonNull String str2) {
    }
}

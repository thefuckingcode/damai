package com.alibaba.android.bindingx.core.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.bindingx.core.BindingXCore;
import com.alibaba.android.bindingx.core.BindingXEventType;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.alibaba.android.bindingx.core.internal.PhysicsAnimationDriver;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tb.ag0;
import tb.f91;
import tb.jl1;

/* compiled from: Taobao */
public class e extends AbstractEventHandler implements PhysicsAnimationDriver.OnAnimationEndListener, PhysicsAnimationDriver.OnAnimationUpdateListener {
    private n n;

    public e(Context context, PlatformManager platformManager, Object... objArr) {
        super(context, platformManager, objArr);
    }

    private void i(String str, double d, double d2, Object... objArr) {
        if (this.c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("state", str);
            hashMap.put("position", Double.valueOf(d));
            hashMap.put("velocity", Double.valueOf(d2));
            hashMap.put("token", this.g);
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Map)) {
                hashMap.putAll((Map) objArr[0]);
            }
            this.c.callback(hashMap);
            f91.a(">>>>>>>>>>>fire event:(" + str + ",position:" + d + ",velocity:" + d2 + jl1.BRACKET_END_STR);
        }
    }

    private Map<String, Object> j(Map<String, Object> map, double d, double d2) {
        if (map == null) {
            return Collections.emptyMap();
        }
        Map<String, Object> f = o.f(map, "eventConfig");
        if (f.get("initialVelocity") == null) {
            if (f.isEmpty()) {
                f = new HashMap<>();
            }
            f.put("initialVelocity", Double.valueOf(d2));
        }
        if (f.get("fromValue") == null) {
            if (f.isEmpty()) {
                f = new HashMap<>();
            }
            f.put("fromValue", Double.valueOf(d));
        }
        return f;
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    public void e(@NonNull Map<String, Object> map) {
        i("exit", ((Double) map.get("p")).doubleValue(), ((Double) map.get("v")).doubleValue(), new Object[0]);
        n nVar = this.n;
        if (nVar != null) {
            nVar.a();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    public void f(String str, @NonNull Map<String, Object> map) {
        n nVar = this.n;
        if (nVar != null) {
            i("interceptor", nVar.b(), this.n.c(), Collections.singletonMap("interceptor", str));
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityPause() {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityResume() {
    }

    @Override // com.alibaba.android.bindingx.core.internal.PhysicsAnimationDriver.OnAnimationEndListener
    public void onAnimationEnd(@NonNull PhysicsAnimationDriver physicsAnimationDriver, double d, double d2) {
        if (f91.a) {
            f91.e(String.format(Locale.getDefault(), "animation end, [value: %f, velocity: %f]", Double.valueOf(d), Double.valueOf(d2)));
        }
        i("end", this.n.b(), this.n.c(), new Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.internal.PhysicsAnimationDriver.OnAnimationUpdateListener
    public void onAnimationUpdate(@NonNull PhysicsAnimationDriver physicsAnimationDriver, double d, double d2) {
        if (f91.a) {
            f91.e(String.format(Locale.getDefault(), "animation update, [value: %f, velocity: %f]", Double.valueOf(d), Double.valueOf(d2)));
        }
        try {
            JSMath.applySpringValueToScope(this.d, d, d2);
            if (!d(this.j, this.d)) {
                c(this.a, this.d, BindingXEventType.TYPE_SPRING);
            }
        } catch (Exception e) {
            f91.c("runtime error", e);
        }
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onBindExpression(@NonNull String str, @Nullable Map<String, Object> map, @Nullable ag0 ag0, @NonNull List<Map<String, Object>> list, @Nullable BindingXCore.JavaScriptCallback javaScriptCallback) {
        double d;
        double d2;
        super.onBindExpression(str, map, ag0, list, javaScriptCallback);
        n nVar = this.n;
        if (nVar != null) {
            double c = nVar.c();
            double b = this.n.b();
            this.n.a();
            d = c;
            d2 = b;
        } else {
            d2 = 0.0d;
            d = 0.0d;
        }
        n nVar2 = new n();
        this.n = nVar2;
        nVar2.h(this);
        this.n.g(this);
        this.n.i(j(this.m, d2, d));
        i("start", this.n.b(), this.n.c(), new Object[0]);
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onCreate(@NonNull String str, @NonNull String str2) {
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onDisable(@NonNull String str, @NonNull String str2) {
        b();
        n nVar = this.n;
        if (nVar == null) {
            return true;
        }
        i("end", nVar.b(), this.n.c(), new Object[0]);
        this.n.g(null);
        this.n.h(null);
        this.n.a();
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onStart(@NonNull String str, @NonNull String str2) {
    }
}

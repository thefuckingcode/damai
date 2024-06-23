package com.alibaba.android.bindingx.core.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.bindingx.core.BindingXCore;
import com.alibaba.android.bindingx.core.PlatformManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tb.ag0;
import tb.f91;
import tb.jl1;

/* compiled from: Taobao */
public class g extends AbstractEventHandler implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private float n;
    private float o;
    private double p;
    private double q;
    private GestureDetector r;
    private VelocityTracker s;
    private int t;

    public g(Context context, PlatformManager platformManager, Object... objArr) {
        super(context, platformManager, objArr);
        this.r = new GestureDetector(context, this, new Handler(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper()));
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.t = viewConfiguration.getScaledMaximumFlingVelocity();
        viewConfiguration.getScaledMinimumFlingVelocity();
    }

    private void i(String str, double d, double d2, float f, float f2, Object... objArr) {
        if (this.c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("state", str);
            double nativeToWeb = this.h.e().nativeToWeb(d, new Object[0]);
            double nativeToWeb2 = this.h.e().nativeToWeb(d2, new Object[0]);
            hashMap.put("deltaX", Double.valueOf(nativeToWeb));
            hashMap.put("deltaY", Double.valueOf(nativeToWeb2));
            if ("end".equals(str)) {
                hashMap.put("velocityX", Float.valueOf(f));
                hashMap.put("velocityY", Float.valueOf(f2));
            }
            hashMap.put("token", this.g);
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Map)) {
                hashMap.putAll((Map) objArr[0]);
            }
            this.c.callback(hashMap);
            f91.a(">>>>>>>>>>>fire event:(" + str + "," + nativeToWeb + "," + nativeToWeb2 + jl1.BRACKET_END_STR);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    public void e(@NonNull Map<String, Object> map) {
        i("exit", ((Double) map.get("internal_x")).doubleValue(), ((Double) map.get("internal_y")).doubleValue(), 0.0f, 0.0f, new Object[0]);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler
    public void f(String str, @NonNull Map<String, Object> map) {
        i("interceptor", ((Double) map.get("internal_x")).doubleValue(), ((Double) map.get("internal_y")).doubleValue(), 0.0f, 0.0f, Collections.singletonMap("interceptor", str));
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityPause() {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onActivityResume() {
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onBindExpression(@NonNull String str, @Nullable Map<String, Object> map, @Nullable ag0 ag0, @NonNull List<Map<String, Object>> list, @Nullable BindingXCore.JavaScriptCallback javaScriptCallback) {
        super.onBindExpression(str, map, ag0, list, javaScriptCallback);
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onCreate(@NonNull String str, @NonNull String str2) {
        View findViewBy = this.h.g().findViewBy(str, TextUtils.isEmpty(this.f) ? this.e : this.f);
        if (findViewBy == null) {
            f91.b("[ExpressionTouchHandler] onCreate failed. sourceView not found:" + str);
            return false;
        }
        findViewBy.setOnTouchListener(this);
        f91.a("[ExpressionTouchHandler] onCreate success. {source:" + str + ",type:" + str2 + "}");
        return true;
    }

    @Override // com.alibaba.android.bindingx.core.internal.AbstractEventHandler, com.alibaba.android.bindingx.core.IEventHandler
    public void onDestroy() {
        super.onDestroy();
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
        this.j = null;
        this.c = null;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public boolean onDisable(@NonNull String str, @NonNull String str2) {
        View findViewBy = this.h.g().findViewBy(str, TextUtils.isEmpty(this.f) ? this.e : this.f);
        if (findViewBy != null) {
            findViewBy.setOnTouchListener(null);
        }
        f91.a("remove touch listener success.[" + str + "," + str2 + jl1.ARRAY_END_STR);
        return true;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float f3;
        float f4;
        if (motionEvent == null) {
            f4 = this.n;
            f3 = this.o;
        } else {
            float rawX = motionEvent.getRawX();
            f3 = motionEvent.getRawY();
            f4 = rawX;
        }
        if (motionEvent2 == null) {
            return false;
        }
        float rawX2 = motionEvent2.getRawX() - f4;
        float rawY = motionEvent2.getRawY() - f3;
        try {
            if (f91.a) {
                f91.a(String.format(Locale.getDefault(), "[TouchHandler] pan moved. (x:%f,y:%f)", Float.valueOf(rawX2), Float.valueOf(rawY)));
            }
            JSMath.applyXYToScope(this.d, (double) rawX2, (double) rawY, this.h.e());
            if (!d(this.j, this.d)) {
                c(this.a, this.d, "pan");
            }
        } catch (Exception e) {
            f91.c("runtime error", e);
        }
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onStart(@NonNull String str, @NonNull String str2) {
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            if (this.s == null) {
                this.s = VelocityTracker.obtain();
            }
            this.s.addMovement(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.n = motionEvent.getRawX();
                this.o = motionEvent.getRawY();
                i("start", 0.0d, 0.0d, 0.0f, 0.0f, new Object[0]);
            } else if (actionMasked == 1) {
                this.n = 0.0f;
                this.o = 0.0f;
                b();
                this.s.computeCurrentVelocity(1000, (float) this.t);
                i("end", this.p, this.q, this.s.getXVelocity(), this.s.getYVelocity(), new Object[0]);
                this.p = 0.0d;
                this.q = 0.0d;
                VelocityTracker velocityTracker = this.s;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.s = null;
                }
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    this.n = 0.0f;
                    this.o = 0.0f;
                    b();
                    i("cancel", this.p, this.q, 0.0f, 0.0f, new Object[0]);
                    VelocityTracker velocityTracker2 = this.s;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.s = null;
                    }
                }
            } else if (this.n == 0.0f && this.o == 0.0f) {
                this.n = motionEvent.getRawX();
                this.o = motionEvent.getRawY();
                i("start", 0.0d, 0.0d, 0.0f, 0.0f, new Object[0]);
            } else {
                this.p = (double) (motionEvent.getRawX() - this.n);
                this.q = (double) (motionEvent.getRawY() - this.o);
            }
        } catch (Exception e) {
            f91.c("runtime error ", e);
        }
        return this.r.onTouchEvent(motionEvent);
    }
}

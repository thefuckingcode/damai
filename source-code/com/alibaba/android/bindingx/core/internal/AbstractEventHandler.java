package com.alibaba.android.bindingx.core.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.bindingx.core.BindingXCore;
import com.alibaba.android.bindingx.core.BindingXPropertyInterceptor;
import com.alibaba.android.bindingx.core.IEventHandler;
import com.alibaba.android.bindingx.core.IHandlerCleanable;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.youku.arch.v3.core.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tb.ag0;
import tb.f91;
import tb.jl1;
import tb.pb;

/* compiled from: Taobao */
public abstract class AbstractEventHandler implements IEventHandler {
    protected volatile Map<String, List<j>> a;
    protected volatile Map<String, ag0> b;
    protected BindingXCore.JavaScriptCallback c;
    protected final Map<String, Object> d = new HashMap(64);
    protected String e;
    protected String f;
    protected String g;
    protected PlatformManager h;
    protected IHandlerCleanable i;
    protected volatile ag0 j;
    protected Object[] k;
    private Cache<String, i> l = new Cache<>(16);
    protected Map<String, Object> m;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class Cache<K, V> extends LinkedHashMap<K, V> {
        private int maxSize;

        Cache(int i) {
            super(4, 0.75f, true);
            this.maxSize = Math.max(i, 4);
        }

        /* access modifiers changed from: protected */
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry entry) {
            return size() > this.maxSize;
        }
    }

    public AbstractEventHandler(Context context, PlatformManager platformManager, Object... objArr) {
        this.h = platformManager;
        this.e = (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof String)) ? null : (String) objArr[0];
    }

    private void a() {
        Map<String, JSFunctionInterface> b2 = pb.a().b();
        if (b2 != null && !b2.isEmpty()) {
            this.d.putAll(b2);
        }
    }

    private void g(@NonNull String str, @NonNull List<Map<String, Object>> list) {
        Map<String, Object> map;
        if (this.a == null) {
            this.a = new HashMap();
        }
        for (Map<String, Object> map2 : list) {
            String h2 = o.h(map2, "element");
            String h3 = o.h(map2, "instanceId");
            String h4 = o.h(map2, "property");
            ag0 e2 = o.e(map2, DXTraceUtil.TYPE_EXPRESSION_STRING);
            Object obj = map2.get(Constants.CONFIG);
            if (obj != null && (obj instanceof Map)) {
                try {
                    map = o.n(new JSONObject((Map) obj));
                } catch (Exception e3) {
                    f91.c("parse config failed", e3);
                }
                if (!TextUtils.isEmpty(h2) || TextUtils.isEmpty(h4) || e2 == null) {
                    f91.b("skip illegal binding args[" + h2 + "," + h4 + "," + e2 + jl1.ARRAY_END_STR);
                } else {
                    j jVar = new j(h2, h3, e2, h4, str, map);
                    List<j> list2 = this.a.get(h2);
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList(4);
                        this.a.put(h2, arrayList);
                        arrayList.add(jVar);
                    } else if (!list2.contains(jVar)) {
                        list2.add(jVar);
                    }
                }
            }
            map = null;
            if (!TextUtils.isEmpty(h2)) {
            }
            f91.b("skip illegal binding args[" + h2 + "," + h4 + "," + e2 + jl1.ARRAY_END_STR);
        }
    }

    private void h(@NonNull Map<String, Object> map) {
        if (!(this.b == null || this.b.isEmpty())) {
            for (Map.Entry<String, ag0> entry : this.b.entrySet()) {
                String key = entry.getKey();
                ag0 value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    performInterceptIfNeeded(key, value, map);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        f91.a("all expression are cleared");
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
        this.j = null;
    }

    /* access modifiers changed from: protected */
    public void c(@Nullable Map<String, List<j>> map, @NonNull Map<String, Object> map2, @NonNull String str) throws IllegalArgumentException, JSONException {
        Map<String, Object> map3 = map2;
        h(map3);
        if (map == null) {
            f91.b("expression args is null");
        } else if (map.isEmpty()) {
            f91.b("no expression need consumed");
        } else {
            int i2 = 2;
            if (f91.a) {
                f91.a(String.format(Locale.getDefault(), "consume expression with %d tasks. event type is %s", Integer.valueOf(map.size()), str));
            }
            LinkedList linkedList = new LinkedList();
            for (List<j> list : map.values()) {
                for (j jVar : list) {
                    if (!str.equals(jVar.e)) {
                        f91.a("skip expression with wrong event type.[expected:" + str + ",found:" + jVar.e + jl1.ARRAY_END_STR);
                    } else {
                        linkedList.clear();
                        Object[] objArr = this.k;
                        if (objArr != null && objArr.length > 0) {
                            Collections.addAll(linkedList, objArr);
                        }
                        String str2 = TextUtils.isEmpty(jVar.b) ? this.e : jVar.b;
                        if (!TextUtils.isEmpty(str2)) {
                            linkedList.add(str2);
                        }
                        ag0 ag0 = jVar.c;
                        if (ag0.c(ag0)) {
                            i iVar = this.l.get(ag0.b);
                            if (iVar == null) {
                                iVar = i.a(ag0);
                                if (iVar != null) {
                                    if (!TextUtils.isEmpty(ag0.b)) {
                                        this.l.put(ag0.b, iVar);
                                    }
                                }
                            }
                            Object c2 = iVar.c(map3);
                            if (c2 == null) {
                                f91.b("failed to execute expression,expression result is null");
                            } else if ((!(c2 instanceof Double) || !Double.isNaN(((Double) c2).doubleValue())) && (!(c2 instanceof Float) || !Float.isNaN(((Float) c2).floatValue()))) {
                                View findViewBy = this.h.g().findViewBy(jVar.a, linkedList.toArray());
                                BindingXPropertyInterceptor c3 = BindingXPropertyInterceptor.c();
                                String str3 = jVar.d;
                                PlatformManager.IDeviceResolutionTranslator e2 = this.h.e();
                                Map<String, Object> map4 = jVar.f;
                                Object[] objArr2 = new Object[i2];
                                objArr2[0] = jVar.a;
                                objArr2[1] = str2;
                                c3.d(findViewBy, str3, c2, e2, map4, objArr2);
                                if (findViewBy == null) {
                                    f91.b("failed to execute expression,target view not found.[ref:" + jVar.a + jl1.ARRAY_END_STR);
                                    map3 = map2;
                                    i2 = 2;
                                } else {
                                    i2 = 2;
                                    this.h.h().synchronouslyUpdateViewOnUIThread(findViewBy, jVar.d, c2, this.h.e(), jVar.f, jVar.a, str2);
                                    map3 = map2;
                                }
                            } else {
                                f91.b("failed to execute expression,expression result is NaN");
                            }
                        }
                    }
                }
                map3 = map2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean d(ag0 ag0, @NonNull Map<String, Object> map) {
        boolean z = false;
        if (ag0.c(ag0)) {
            i a2 = i.a(ag0);
            if (a2 == null) {
                return false;
            }
            try {
                z = ((Boolean) a2.c(map)).booleanValue();
            } catch (Exception e2) {
                f91.c("evaluateExitExpression failed. ", e2);
            }
        }
        if (z) {
            b();
            try {
                e(map);
            } catch (Exception e3) {
                f91.c("execute exit expression failed: ", e3);
            }
            f91.a("exit = true,consume finished");
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public abstract void e(@NonNull Map<String, Object> map);

    /* access modifiers changed from: protected */
    public abstract void f(String str, @NonNull Map<String, Object> map);

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onBindExpression(@NonNull String str, @Nullable Map<String, Object> map, @Nullable ag0 ag0, @NonNull List<Map<String, Object>> list, @Nullable BindingXCore.JavaScriptCallback javaScriptCallback) {
        b();
        g(str, list);
        this.c = javaScriptCallback;
        this.j = ag0;
        if (!this.d.isEmpty()) {
            this.d.clear();
        }
        a();
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    @CallSuper
    public void onDestroy() {
        this.l.clear();
        BindingXPropertyInterceptor.c().b();
    }

    @Override // com.alibaba.android.bindingx.core.IEventInterceptor
    public void performInterceptIfNeeded(@NonNull String str, @NonNull ag0 ag0, @NonNull Map<String, Object> map) {
        i a2;
        if (ag0.c(ag0) && (a2 = i.a(ag0)) != null) {
            boolean z = false;
            try {
                z = ((Boolean) a2.c(map)).booleanValue();
            } catch (Exception e2) {
                f91.c("evaluate interceptor [" + str + "] expression failed. ", e2);
            }
            if (z) {
                f(str, map);
            }
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setAnchorInstanceId(String str) {
        this.f = str;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setExtensionParams(Object[] objArr) {
        this.k = objArr;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setGlobalConfig(@Nullable Map<String, Object> map) {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setHandlerCleaner(IHandlerCleanable iHandlerCleanable) {
        this.i = iHandlerCleanable;
    }

    @Override // com.alibaba.android.bindingx.core.IEventInterceptor
    public void setInterceptors(@Nullable Map<String, ag0> map) {
        this.b = map;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setOriginalParams(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            this.m = Collections.emptyMap();
        } else {
            this.m = map;
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setToken(String str) {
        this.g = str;
    }
}

package com.alibaba.android.bindingx.core;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.alibaba.android.bindingx.core.internal.g;
import com.alibaba.android.bindingx.core.internal.o;
import com.taobao.weex.bridge.WXBridgeManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
import tb.ag0;
import tb.f91;
import tb.jl1;

/* compiled from: Taobao */
public class BindingXCore implements IHandlerCleanable {
    private static final Map<String, ObjectCreator<IEventHandler, Context, PlatformManager>> d = new HashMap(4);
    private Map<String, Map<String, IEventHandler>> a;
    private final Map<String, ObjectCreator<IEventHandler, Context, PlatformManager>> b = new HashMap(8);
    private final PlatformManager c;

    /* compiled from: Taobao */
    public interface JavaScriptCallback {
        void callback(Object obj);
    }

    /* compiled from: Taobao */
    public interface ObjectCreator<Type, ParamA, ParamB> {
        Type createWith(@NonNull ParamA parama, @NonNull ParamB paramb, Object... objArr);
    }

    /* compiled from: Taobao */
    class a implements ObjectCreator<IEventHandler, Context, PlatformManager> {
        a(BindingXCore bindingXCore) {
        }

        /* renamed from: a */
        public IEventHandler createWith(@NonNull Context context, @NonNull PlatformManager platformManager, Object... objArr) {
            return new g(context, platformManager, objArr);
        }
    }

    /* compiled from: Taobao */
    class b implements ObjectCreator<IEventHandler, Context, PlatformManager> {
        b(BindingXCore bindingXCore) {
        }

        /* renamed from: a */
        public IEventHandler createWith(@NonNull Context context, @NonNull PlatformManager platformManager, Object... objArr) {
            return new com.alibaba.android.bindingx.core.internal.c(context, platformManager, objArr);
        }
    }

    /* compiled from: Taobao */
    class c implements ObjectCreator<IEventHandler, Context, PlatformManager> {
        c(BindingXCore bindingXCore) {
        }

        /* renamed from: a */
        public IEventHandler createWith(@NonNull Context context, @NonNull PlatformManager platformManager, Object... objArr) {
            return new com.alibaba.android.bindingx.core.internal.d(context, platformManager, objArr);
        }
    }

    /* compiled from: Taobao */
    class d implements ObjectCreator<IEventHandler, Context, PlatformManager> {
        d(BindingXCore bindingXCore) {
        }

        /* renamed from: a */
        public IEventHandler createWith(@NonNull Context context, @NonNull PlatformManager platformManager, Object... objArr) {
            return new com.alibaba.android.bindingx.core.internal.b(context, platformManager, objArr);
        }
    }

    /* compiled from: Taobao */
    class e implements ObjectCreator<IEventHandler, Context, PlatformManager> {
        e(BindingXCore bindingXCore) {
        }

        /* renamed from: a */
        public IEventHandler createWith(@NonNull Context context, @NonNull PlatformManager platformManager, Object... objArr) {
            return new com.alibaba.android.bindingx.core.internal.f(context, platformManager, objArr);
        }
    }

    /* compiled from: Taobao */
    class f implements ObjectCreator<IEventHandler, Context, PlatformManager> {
        f(BindingXCore bindingXCore) {
        }

        /* renamed from: a */
        public IEventHandler createWith(@NonNull Context context, @NonNull PlatformManager platformManager, Object... objArr) {
            return new com.alibaba.android.bindingx.core.internal.e(context, platformManager, objArr);
        }
    }

    public BindingXCore(@NonNull PlatformManager platformManager) {
        this.c = platformManager;
        i("pan", new a(this));
        i(BindingXEventType.TYPE_PINCH, new b(this));
        i("rotation", new c(this));
        i("orientation", new d(this));
        i(BindingXEventType.TYPE_TIMING, new e(this));
        i(BindingXEventType.TYPE_SPRING, new f(this));
    }

    @Nullable
    private IEventHandler a(@NonNull Context context, @Nullable String str, @NonNull String str2) {
        IEventHandler iEventHandler = null;
        if (!this.b.isEmpty() && this.c != null) {
            ObjectCreator<IEventHandler, Context, PlatformManager> objectCreator = this.b.get(str2);
            if (objectCreator == null) {
                objectCreator = d.get(str2);
            }
            if (objectCreator != null) {
                iEventHandler = objectCreator.createWith(context, this.c, str);
            }
            if (iEventHandler != null) {
                iEventHandler.setHandlerCleaner(this);
            }
        }
        return iEventHandler;
    }

    private String h() {
        return UUID.randomUUID().toString();
    }

    public String b(@Nullable Context context, @Nullable String str, @NonNull Map<String, Object> map, @NonNull JavaScriptCallback javaScriptCallback, Object... objArr) {
        Map<String, Object> map2;
        String h = o.h(map, "eventType");
        String h2 = o.h(map, "instanceId");
        f91.d(map);
        Object obj = map.get(WXBridgeManager.OPTIONS);
        if (obj != null && (obj instanceof Map)) {
            try {
                map2 = o.n(new JSONObject((Map) obj));
            } catch (Exception e2) {
                f91.c("parse external config failed.\n", e2);
            }
            return c(o.h(map, "anchor"), h2, h, map2, o.e(map, "exitExpression"), o.g(map), o.c(map), javaScriptCallback, context, str, map, objArr);
        }
        map2 = null;
        return c(o.h(map, "anchor"), h2, h, map2, o.e(map, "exitExpression"), o.g(map), o.c(map), javaScriptCallback, context, str, map, objArr);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String c(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, Object> map, @Nullable ag0 ag0, @Nullable List<Map<String, Object>> list, @Nullable Map<String, ag0> map2, @Nullable JavaScriptCallback javaScriptCallback, @Nullable Context context, @Nullable String str4, @Nullable Map<String, Object> map3, @Nullable Object... objArr) {
        String str5;
        Map<String, Map<String, IEventHandler>> map4;
        Map<String, IEventHandler> map5;
        Map<String, IEventHandler> map6;
        IEventHandler iEventHandler = null;
        if (TextUtils.isEmpty(str3) || list == null) {
            f91.b("doBind failed,illegal argument.[" + str3 + "," + list + jl1.ARRAY_END_STR);
            return null;
        }
        if (!(this.a == null || TextUtils.isEmpty(str) || (map6 = this.a.get(str)) == null)) {
            iEventHandler = map6.get(str3);
        }
        IEventHandler iEventHandler2 = iEventHandler;
        if (iEventHandler2 == null) {
            if (f91.a) {
                f91.a("binding not enabled,try auto enable it.[sourceRef:" + str + ",eventType:" + str3 + jl1.ARRAY_END_STR);
            }
            String d2 = d(context, str4, str, str2, str3, map, map3, objArr);
            if (!(TextUtils.isEmpty(d2) || (map4 = this.a) == null || (map5 = map4.get(d2)) == null)) {
                iEventHandler2 = map5.get(str3);
            }
            str5 = d2;
        } else {
            str5 = str;
        }
        if (iEventHandler2 != null) {
            iEventHandler2.setOriginalParams(map3);
            iEventHandler2.onBindExpression(str3, map, ag0, list, javaScriptCallback);
            if (f91.a) {
                f91.a("createBinding success.[exitExp:" + ag0 + ",args:" + list + jl1.ARRAY_END_STR);
            }
            iEventHandler2.setInterceptors(map2);
        } else if (f91.a) {
            f91.b("internal error.binding failed for ref:" + str + ",type:" + str3);
        }
        return str5;
    }

    @Override // com.alibaba.android.bindingx.core.IHandlerCleanable
    public void cleanHandlerByToken(@NonNull String str) {
        Map<String, Map<String, IEventHandler>> map = this.a;
        if (map != null) {
            map.remove(str);
        }
    }

    public String d(@Nullable Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Map<String, Object> map, @Nullable Map<String, Object> map2, @Nullable Object... objArr) {
        IEventHandler iEventHandler;
        if (TextUtils.isEmpty(str4)) {
            f91.b("[doPrepare] failed. can not found eventType");
            return null;
        } else if (context == null) {
            f91.b("[doPrepare] failed. context or wxInstance is null");
            return null;
        } else {
            if (TextUtils.isEmpty(str2)) {
                str2 = h();
            }
            if (this.a == null) {
                this.a = new HashMap();
            }
            Map<String, IEventHandler> map3 = this.a.get(str2);
            if (map3 == null || (iEventHandler = map3.get(str4)) == null) {
                if (map3 == null) {
                    map3 = new HashMap<>(4);
                    this.a.put(str2, map3);
                }
                IEventHandler a2 = a(context, str, str4);
                if (a2 != null) {
                    a2.setAnchorInstanceId(str3);
                    a2.setToken(str2);
                    a2.setGlobalConfig(map);
                    a2.setExtensionParams(objArr);
                    if (a2.onCreate(str2, str4)) {
                        a2.onStart(str2, str4);
                        map3.put(str4, a2);
                        if (f91.a) {
                            f91.a("enableBinding success.[token:" + str2 + ",type:" + str4 + jl1.ARRAY_END_STR);
                        }
                    } else {
                        if (f91.a) {
                            f91.b("expression enabled failed. [token:" + str2 + ",type:" + str4 + jl1.ARRAY_END_STR);
                        }
                        return null;
                    }
                } else {
                    f91.b("unknown eventType: " + str4);
                    return null;
                }
            } else {
                if (f91.a) {
                    f91.a("you have already enabled binding,[token:" + str2 + ",type:" + str4 + jl1.ARRAY_END_STR);
                }
                iEventHandler.setExtensionParams(objArr);
                iEventHandler.onStart(str2, str4);
                if (f91.a) {
                    f91.a("enableBinding success.[token:" + str2 + ",type:" + str4 + jl1.ARRAY_END_STR);
                }
            }
            return str2;
        }
    }

    public void e() {
        Map<String, Map<String, IEventHandler>> map = this.a;
        if (map != null) {
            try {
                for (Map<String, IEventHandler> map2 : map.values()) {
                    if (map2 != null && !map2.isEmpty()) {
                        for (IEventHandler iEventHandler : map2.values()) {
                            if (iEventHandler != null) {
                                iEventHandler.onDestroy();
                            }
                        }
                    }
                }
                this.a.clear();
                this.a = null;
            } catch (Exception e2) {
                f91.c("release failed", e2);
            }
        }
    }

    public void f(@Nullable String str, @Nullable String str2) {
        f91.a("disable binding [" + str + "," + str2 + jl1.ARRAY_END_STR);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            f91.a("disable binding failed(0x1) [" + str + "," + str2 + jl1.ARRAY_END_STR);
            return;
        }
        Map<String, Map<String, IEventHandler>> map = this.a;
        if (map == null || map.isEmpty()) {
            f91.a("disable binding failed(0x2) [" + str + "," + str2 + jl1.ARRAY_END_STR);
            return;
        }
        Map<String, IEventHandler> map2 = this.a.get(str);
        if (map2 == null || map2.isEmpty()) {
            f91.a("disable binding failed(0x3) [" + str + "," + str2 + jl1.ARRAY_END_STR);
            return;
        }
        IEventHandler iEventHandler = map2.get(str2);
        if (iEventHandler == null) {
            f91.a("disable binding failed(0x4) [" + str + "," + str2 + jl1.ARRAY_END_STR);
        } else if (iEventHandler.onDisable(str, str2)) {
            this.a.remove(str);
            f91.a("disable binding success[" + str + "," + str2 + jl1.ARRAY_END_STR);
        } else {
            f91.a("disabled failed(0x4) [" + str + "," + str2 + jl1.ARRAY_END_STR);
        }
    }

    public void g(@Nullable Map<String, Object> map) {
        if (map != null) {
            f(o.h(map, "token"), o.h(map, "eventType"));
        }
    }

    public void i(String str, ObjectCreator<IEventHandler, Context, PlatformManager> objectCreator) {
        if (!TextUtils.isEmpty(str) && objectCreator != null) {
            this.b.put(str, objectCreator);
        }
    }
}

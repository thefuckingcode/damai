package com.alibaba.poplayerconsole;

import android.os.Handler;
import android.os.Message;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVCallMethodContext;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.utils.Monitor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tb.cr1;
import tb.jl1;

/* compiled from: Taobao */
public final class a {
    private static final Set<String> a = new HashSet();

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static final class b implements Handler.Callback {
        private final Handler.Callback a;

        /* access modifiers changed from: package-private */
        /* renamed from: com.alibaba.poplayerconsole.a$b$a  reason: collision with other inner class name */
        /* compiled from: Taobao */
        public class C0098a extends WVCallBackContext {
            final /* synthetic */ WVCallMethodContext a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0098a(b bVar, IWVWebView iWVWebView, String str, String str2, String str3, WVCallMethodContext wVCallMethodContext) {
                super(iWVWebView, str, str2, str3);
                this.a = wVCallMethodContext;
            }

            @Override // android.taobao.windvane.jsbridge.WVCallBackContext
            public void error(String str) {
                cr1.a(LogCache.d(this.a, str));
                super.error(str);
            }

            @Override // android.taobao.windvane.jsbridge.WVCallBackContext
            public void success(String str) {
                cr1.b(LogCache.d(this.a, str), new Object[0]);
                super.success(str);
            }
        }

        private boolean a(WVCallMethodContext wVCallMethodContext) {
            cr1.b(LogCache.d(wVCallMethodContext, null), new Object[0]);
            if (((WVApiPlugin) wVCallMethodContext.classinstance).execute(wVCallMethodContext.methodName, TextUtils.isEmpty(wVCallMethodContext.params) ? "{}" : wVCallMethodContext.params, new C0098a(this, wVCallMethodContext.webview, wVCallMethodContext.token, wVCallMethodContext.objectName, wVCallMethodContext.methodName, wVCallMethodContext))) {
                return true;
            }
            WVJsBridge.startCall(2, wVCallMethodContext);
            return true;
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return this.a.handleMessage(message);
            }
            WVCallMethodContext wVCallMethodContext = (WVCallMethodContext) message.obj;
            if (wVCallMethodContext == null) {
                return false;
            }
            if (a.a.contains(wVCallMethodContext.objectName) || a.a.contains(jl1.MUL)) {
                return a(wVCallMethodContext);
            }
            return this.a.handleMessage(message);
        }

        private b(Handler.Callback callback) {
            this.a = callback;
        }
    }

    private static Field b(Class<?> cls, Class<?> cls2) throws NoSuchFieldException {
        Field[] declaredFields = cls2.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getType() == cls) {
                return field;
            }
        }
        throw new NoSuchFieldException(String.format("Can't find %s in class %s", cls.getName(), cls2.getName()));
    }

    private static Field[] c(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields.length != 0) {
                arrayList.addAll(Arrays.asList(declaredFields));
            }
            cls = cls.getSuperclass();
        } while (cls != null);
        return (Field[]) arrayList.toArray(new Field[0]);
    }

    public static Map<String, Monitor.a> d() throws IllegalArgumentException, IllegalAccessException {
        HashMap hashMap = new HashMap();
        PopLayer reference = PopLayer.getReference();
        if (reference == null) {
            return hashMap;
        }
        e(reference, hashMap, new ArrayList(), null);
        return hashMap;
    }

    private static void e(Object obj, Map<String, Monitor.a> map, List<Object> list, String str) throws IllegalArgumentException, IllegalAccessException {
        if (!list.contains(obj)) {
            list.add(obj);
            Field[] c = c(obj.getClass());
            for (Field field : c) {
                Monitor.TargetField targetField = (Monitor.TargetField) field.getAnnotation(Monitor.TargetField.class);
                if (targetField != null) {
                    field.setAccessible(true);
                    String name = targetField.name();
                    Object obj2 = Modifier.isStatic(field.getModifiers()) ? field.get(null) : field.get(obj);
                    if (((Monitor.TargetClass) field.getType().getAnnotation(Monitor.TargetClass.class)) == null) {
                        Monitor.a aVar = new Monitor.a(obj, name, obj2);
                        if (!TextUtils.isEmpty(str)) {
                            name = str + name;
                        }
                        map.put(name, aVar);
                    } else {
                        e(obj2, map, list, TextUtils.isEmpty(str) ? targetField.prefix() : str + targetField.prefix());
                    }
                }
            }
        }
    }

    static void f(String... strArr) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
        a.clear();
        for (String str : strArr) {
            a.add(str);
        }
        WVJsBridge instance = WVJsBridge.getInstance();
        Field b2 = b(Handler.class, WVJsBridge.class);
        b2.setAccessible(true);
        Handler handler = (Handler) b2.get(WVJsBridge.getInstance());
        Field declaredField = Handler.class.getDeclaredField("mCallback");
        declaredField.setAccessible(true);
        if (!(declaredField.get(handler) instanceof b)) {
            declaredField.set(handler, new b(instance));
        }
    }
}

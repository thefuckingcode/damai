package com.alibaba.gaiax.studio.third.socket.websocket;

import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import com.alibaba.gaiax.studio.third.socket.websocket.util.Logable;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.HashMap;
import java.util.Map;
import tb.a91;
import tb.ez2;
import tb.i91;
import tb.ip1;

/* compiled from: Taobao */
public class a {
    private static WebSocketEngine a;
    private static com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.a b;
    private static b c;
    private static final Object d = new HashMap();
    private static Map<String, b> e;
    private static Logable f;

    private static void a() {
        if (a == null || b == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new WebSocketEngine();
                }
                if (b == null) {
                    b = new com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.a();
                }
            }
        }
    }

    private static void b() {
        if (e == null) {
            synchronized (d) {
                if (e == null) {
                    e = new HashMap();
                }
            }
        }
    }

    public static Map<String, b> c() {
        b();
        return e;
    }

    public static b d() {
        return c;
    }

    public static Logable e() {
        if (f == null) {
            f = new a91();
        }
        return f;
    }

    public static b f(String str) {
        b();
        if (e.containsKey(str)) {
            return e.get(str);
        }
        return null;
    }

    public static b g(String str, ez2 ez2) {
        a();
        b();
        synchronized (d) {
            if (e.containsKey(str)) {
                Log.e("WebSocketHandler", "WebSocketManager exists!do not start again!");
                return e.get(str);
            }
            b bVar = new b(ez2, a, b);
            e.put(str, bVar);
            return bVar;
        }
    }

    public static void h(Context context) {
        if (ip1.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
                context.registerReceiver(new NetworkChangedReceiver(), intentFilter);
            } catch (Exception e2) {
                i91.c("WebSocketHandler", "网络监听广播注册失败：", e2);
            }
        } else {
            i91.b("WebSocketHandler", "未获取到网络状态权限，广播监听器无法注册");
        }
    }

    public static b i(String str) {
        b();
        if (!e.containsKey(str)) {
            return null;
        }
        b bVar = e.get(str);
        synchronized (d) {
            e.remove(str);
        }
        return bVar;
    }
}

package com.taobao.android.riverlogger.inspector;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.riverlogger.remote.RemoteChannel;
import com.taobao.android.riverlogger.remote.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class Inspector {
    private static final ConcurrentHashMap<String, String> a;
    private static final ConcurrentHashMap<String, ConcurrentLinkedQueue<a>> b = new ConcurrentHashMap<>();
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static boolean d = false;
    private static final ConcurrentLinkedQueue<IConnectionListener> e = new ConcurrentLinkedQueue<>();
    private static final ConcurrentHashMap<String, ConcurrentLinkedQueue<a>> f = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Set<String>> g = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    public interface IConnectionListener {
        void connected(boolean z);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public static class a {
        public String a;
        public InspectorAgent b;

        a(InspectorAgent inspectorAgent, String str) {
            this.b = inspectorAgent;
            this.a = str;
        }
    }

    static {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        a = concurrentHashMap;
        concurrentHashMap.put("os", "Android");
    }

    private static void a(a aVar, boolean z) {
        for (Map.Entry<String, InspectorCommandHandler> entry : aVar.b.getCommands().entrySet()) {
            ConcurrentHashMap<String, ConcurrentLinkedQueue<a>> concurrentHashMap = f;
            ConcurrentLinkedQueue<a> putIfAbsent = concurrentHashMap.putIfAbsent(entry.getKey(), new ConcurrentLinkedQueue<>());
            if (putIfAbsent == null) {
                putIfAbsent = concurrentHashMap.get(entry.getKey());
            }
            putIfAbsent.add(new a(entry.getValue(), entry.getKey(), aVar.a));
        }
        if (z && d) {
            aVar.b.connectionChanged(true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0016  */
    private static a b(@NonNull String str, @Nullable Set<String> set) {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = f.get(str);
        if (concurrentLinkedQueue == null) {
            return null;
        }
        Iterator<a> it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (set == null || set.contains(next.b)) {
                return next;
            }
            while (it.hasNext()) {
            }
        }
        return null;
    }

    public static void c(@NonNull String str, int i, @Nullable String str2, @NonNull JSONObject jSONObject) {
        a b2;
        if (str2 != null) {
            Set<String> set = g.get(str2);
            if (!(set == null || (b2 = b(str, set)) == null)) {
                b2.a.handle(jSONObject, new b(str, i, str2, jSONObject));
                return;
            }
        } else {
            a b3 = b(str, null);
            if (b3 != null) {
                b3.a.handle(jSONObject, new b(str, i, str2, jSONObject));
                return;
            }
        }
        RemoteChannel c2 = b.c();
        if (c2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", -70550);
                jSONObject3.put("message", String.format("Method \"%s\" not found", str));
                jSONObject2.put("error", jSONObject3);
            } catch (JSONException unused) {
            }
            c2.d(i, jSONObject2);
        }
    }

    public static void d(@NonNull InspectorAgent inspectorAgent, @NonNull String str) {
        if (inspectorAgent != null && str != null) {
            a aVar = new a(inspectorAgent, str);
            if (c.get()) {
                a(aVar, true);
                return;
            }
            ConcurrentHashMap<String, ConcurrentLinkedQueue<a>> concurrentHashMap = b;
            ConcurrentLinkedQueue<a> putIfAbsent = concurrentHashMap.putIfAbsent(str, new ConcurrentLinkedQueue<>());
            if (putIfAbsent == null) {
                putIfAbsent = concurrentHashMap.get(str);
            }
            putIfAbsent.add(aVar);
        }
    }

    public static void e(@NonNull String str, @NonNull String str2) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            a.put(str, str2);
            f();
        }
    }

    private static void f() {
        RemoteChannel c2 = b.c();
        if (c2 != null) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : a.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException unused) {
                }
            }
            c2.k("Dev.clientInfo", null, jSONObject, null);
        }
    }

    public static void g(boolean z) {
        if (z != d) {
            d = z;
            if (z) {
                if (c.compareAndSet(false, true)) {
                    for (ConcurrentLinkedQueue<a> concurrentLinkedQueue : b.values()) {
                        Iterator<a> it = concurrentLinkedQueue.iterator();
                        while (it.hasNext()) {
                            a(it.next(), false);
                        }
                    }
                }
                f();
            }
            InspectorNativeAgent.setConnectedNative(z);
            for (ConcurrentLinkedQueue<a> concurrentLinkedQueue2 : b.values()) {
                Iterator<a> it2 = concurrentLinkedQueue2.iterator();
                while (it2.hasNext()) {
                    it2.next().b.connectionChanged(z);
                }
            }
            Iterator<IConnectionListener> it3 = e.iterator();
            while (it3.hasNext()) {
                it3.next().connected(z);
            }
        }
    }
}

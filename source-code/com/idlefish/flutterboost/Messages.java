package com.idlefish.flutterboost;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.ad1;
import tb.bd1;
import tb.cd1;
import tb.dd1;
import tb.ed1;
import tb.fd1;
import tb.xc1;
import tb.yc1;
import tb.zc1;

/* compiled from: Taobao */
public class Messages {

    /* compiled from: Taobao */
    public static class FlutterRouterApi {
        private final BinaryMessenger a;

        /* compiled from: Taobao */
        public interface Reply<T> {
            void reply(T t);
        }

        public FlutterRouterApi(BinaryMessenger binaryMessenger) {
            this.a = binaryMessenger;
        }

        public void A(a aVar, Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.sendEventToFlutter", new StandardMessageCodec()).send(aVar.k(), new dd1(reply));
        }

        public void s(Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onBackPressed", new StandardMessageCodec()).send(null, new zc1(reply));
        }

        public void t(a aVar, Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onBackground", new StandardMessageCodec()).send(aVar.k(), new cd1(reply));
        }

        public void u(a aVar, Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onContainerHide", new StandardMessageCodec()).send(aVar.k(), new ed1(reply));
        }

        public void v(a aVar, Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onContainerShow", new StandardMessageCodec()).send(aVar.k(), new yc1(reply));
        }

        public void w(a aVar, Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onForeground", new StandardMessageCodec()).send(aVar.k(), new fd1(reply));
        }

        public void x(a aVar, Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onNativeResult", new StandardMessageCodec()).send(aVar.k(), new ad1(reply));
        }

        public void y(a aVar, Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.pushRoute", new StandardMessageCodec()).send(aVar.k(), new xc1(reply));
        }

        public void z(a aVar, Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.removeRoute", new StandardMessageCodec()).send(aVar.k(), new bd1(reply));
        }
    }

    /* compiled from: Taobao */
    public interface NativeRouterApi {
        b getStackFromHost();

        void popRoute(a aVar, Result<Void> result);

        void pushFlutterRoute(a aVar);

        void pushNativeRoute(a aVar);

        void saveStackToHost(b bVar);

        void sendEventToNative(a aVar);
    }

    /* compiled from: Taobao */
    public interface Result<T> {
        void success(T t);
    }

    /* compiled from: Taobao */
    public static class a {
        private String a;
        private String b;
        private Map<Object, Object> c;
        private Boolean d;
        private String e;

        static a a(Map<String, Object> map) {
            a aVar = new a();
            aVar.a = (String) map.get("pageName");
            aVar.b = (String) map.get("uniqueId");
            aVar.c = (Map) map.get("arguments");
            aVar.d = (Boolean) map.get("opaque");
            aVar.e = (String) map.get("key");
            return aVar;
        }

        public Map<Object, Object> b() {
            return this.c;
        }

        public String c() {
            return this.e;
        }

        public Boolean d() {
            return this.d;
        }

        public String e() {
            return this.a;
        }

        public String f() {
            return this.b;
        }

        public void g(Map<Object, Object> map) {
            this.c = map;
        }

        public void h(String str) {
            this.e = str;
        }

        public void i(String str) {
            this.a = str;
        }

        public void j(String str) {
            this.b = str;
        }

        /* access modifiers changed from: package-private */
        public Map<String, Object> k() {
            HashMap hashMap = new HashMap();
            hashMap.put("pageName", this.a);
            hashMap.put("uniqueId", this.b);
            hashMap.put("arguments", this.c);
            hashMap.put("opaque", this.d);
            hashMap.put("key", this.e);
            return hashMap;
        }
    }

    /* compiled from: Taobao */
    public static class b {
        private List<Object> a;
        private Map<Object, Object> b;

        static b a(Map<String, Object> map) {
            b bVar = new b();
            bVar.a = (List) map.get("containers");
            bVar.b = (Map) map.get("routes");
            return bVar;
        }

        /* access modifiers changed from: package-private */
        public Map<String, Object> b() {
            HashMap hashMap = new HashMap();
            hashMap.put("containers", this.a);
            hashMap.put("routes", this.b);
            return hashMap;
        }
    }

    /* access modifiers changed from: private */
    public static Map<String, Object> b(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", null);
        return hashMap;
    }
}

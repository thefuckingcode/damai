package com.idlefish.flutterboost;

import android.content.Intent;
import android.util.Log;
import android.util.SparseArray;
import com.idlefish.flutterboost.Messages;
import com.idlefish.flutterboost.c;
import com.idlefish.flutterboost.containers.FlutterViewContainer;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import tb.am0;
import tb.ml0;
import tb.nl0;
import tb.ol0;
import tb.pl0;
import tb.ql0;
import tb.rl0;
import tb.sl0;
import tb.tl0;
import tb.ul0;
import tb.vl0;
import tb.wl0;
import tb.yl0;

/* compiled from: Taobao */
public class b implements Messages.NativeRouterApi, FlutterPlugin, ActivityAware {
    private static final String h = "b";
    public static final /* synthetic */ int i = 0;
    private FlutterEngine a;
    private Messages.FlutterRouterApi b;
    private FlutterBoostDelegate c;
    private Messages.b d;
    private SparseArray<String> e;
    private int f = 1000;
    private HashMap<String, LinkedList<EventListener>> g = new HashMap<>();

    private void l() {
        FlutterEngine flutterEngine = this.a;
        if (flutterEngine == null || !flutterEngine.getDartExecutor().isExecutingDart()) {
            throw new RuntimeException("The engine is not ready for use. The message may be drop silently by the engine. You should check 'DartExecutor.isExecutingDart()' first!");
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void o(Void r0) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean p(int i2, int i3, Intent intent) {
        if (this.b != null) {
            l();
            Messages.a aVar = new Messages.a();
            String str = this.e.get(i2);
            this.e.remove(i2);
            if (str == null) {
                return true;
            }
            aVar.i(str);
            if (intent != null) {
                aVar.g(yl0.a(intent.getExtras()));
            }
            this.b.x(aVar, vl0.a);
            return true;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void q(Void r0) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void r(Void r0) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void s(Void r0) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void t(Void r0) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void u(Void r0) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void v(Void r0) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void w(Void r0) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void x(Messages.FlutterRouterApi.Reply reply, Void r1) {
        if (reply != null) {
            reply.reply(null);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void y(Messages.FlutterRouterApi.Reply reply, Void r1) {
        if (reply != null) {
            reply.reply(null);
        }
    }

    public void A() {
        if (this.b != null) {
            l();
            this.b.t(new Messages.a(), wl0.a);
            String str = h;
            Log.v(str, "## onBackground: " + this.b);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void B(FlutterViewContainer flutterViewContainer) {
        String uniqueId = flutterViewContainer.getUniqueId();
        am0.h().b(uniqueId, flutterViewContainer);
        I(uniqueId, flutterViewContainer.getUrl(), flutterViewContainer.getUrlParams(), ql0.a);
        G(uniqueId);
    }

    public void C(FlutterViewContainer flutterViewContainer) {
        String str = h;
        Log.v(str, "#onContainerCreated: " + flutterViewContainer.getUniqueId());
        am0.h().c(flutterViewContainer.getUniqueId(), flutterViewContainer);
        if (am0.h().e() == 1) {
            FlutterBoost.h().d(0);
        }
    }

    public void D(FlutterViewContainer flutterViewContainer) {
        String uniqueId = flutterViewContainer.getUniqueId();
        J(uniqueId, tl0.a);
        am0.h().k(uniqueId);
        if (am0.h().e() == 0) {
            FlutterBoost.h().d(2);
        }
    }

    public void E(FlutterViewContainer flutterViewContainer) {
        F(flutterViewContainer.getUniqueId());
    }

    public void F(String str) {
        if (this.b != null) {
            l();
            Messages.a aVar = new Messages.a();
            aVar.j(str);
            this.b.u(aVar, pl0.a);
            String str2 = h;
            Log.v(str2, "## onContainerHide: " + str);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void G(String str) {
        if (this.b != null) {
            l();
            Messages.a aVar = new Messages.a();
            aVar.j(str);
            this.b.v(aVar, ul0.a);
            String str2 = h;
            Log.v(str2, "## onContainerShow: " + str);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void H() {
        if (this.b != null) {
            l();
            this.b.w(new Messages.a(), rl0.a);
            String str = h;
            Log.v(str, "## onForeground: " + this.b);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void I(String str, String str2, Map<String, Object> map, Messages.FlutterRouterApi.Reply<Void> reply) {
        if (this.b != null) {
            l();
            Messages.a aVar = new Messages.a();
            aVar.j(str);
            aVar.i(str2);
            aVar.g(map);
            this.b.y(aVar, new ml0(reply));
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void J(String str, Messages.FlutterRouterApi.Reply<Void> reply) {
        if (this.b != null) {
            l();
            Messages.a aVar = new Messages.a();
            aVar.j(str);
            this.b.z(aVar, new ol0(reply));
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void K(FlutterBoostDelegate flutterBoostDelegate) {
        this.c = flutterBoostDelegate;
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public Messages.b getStackFromHost() {
        if (this.d == null) {
            return Messages.b.a(new HashMap());
        }
        String str = h;
        Log.v(str, "#getStackFromHost: " + this.d);
        return this.d;
    }

    public Messages.FlutterRouterApi m() {
        return this.b;
    }

    public FlutterBoostDelegate n() {
        return this.c;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addActivityResultListener(new nl0(this));
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        d.o(flutterPluginBinding.getBinaryMessenger(), this);
        this.a = flutterPluginBinding.getFlutterEngine();
        this.b = new Messages.FlutterRouterApi(flutterPluginBinding.getBinaryMessenger());
        this.e = new SparseArray<>();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.a = null;
        this.b = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void popRoute(Messages.a aVar, Messages.Result<Void> result) {
        if (this.c != null) {
            if (!this.c.popRoute(new c.b().i(aVar.e()).k(aVar.f()).f(aVar.b()).g())) {
                String f2 = aVar.f();
                if (f2 != null) {
                    FlutterViewContainer d2 = am0.h().d(f2);
                    if (d2 != null) {
                        d2.finishContainer(aVar.b());
                    }
                    result.success(null);
                    return;
                }
                throw new RuntimeException("Oops!! The unique id is null!");
            }
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void pushFlutterRoute(Messages.a aVar) {
        if (this.c != null) {
            this.c.pushFlutterRoute(new c.b().i(aVar.e()).k(aVar.f()).h(aVar.d().booleanValue()).f(aVar.b()).g());
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void pushNativeRoute(Messages.a aVar) {
        if (this.c != null) {
            int i2 = this.f + 1;
            this.f = i2;
            SparseArray<String> sparseArray = this.e;
            if (sparseArray != null) {
                sparseArray.put(i2, aVar.e());
            }
            this.c.pushNativeRoute(new c.b().i(aVar.e()).f(aVar.b()).j(this.f).g());
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void saveStackToHost(Messages.b bVar) {
        this.d = bVar;
        String str = h;
        Log.v(str, "#saveStackToHost: " + this.d);
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void sendEventToNative(Messages.a aVar) {
        String c2 = aVar.c();
        Map<Object, Object> b2 = aVar.b();
        if (b2 == null) {
            b2 = new HashMap<>();
        }
        LinkedList<EventListener> linkedList = this.g.get(c2);
        if (linkedList != null) {
            for (EventListener eventListener : linkedList) {
                eventListener.onEvent(c2, b2);
            }
        }
    }

    public void z() {
        if (this.b != null) {
            l();
            this.b.s(sl0.a);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }
}

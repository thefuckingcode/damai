package tb;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.layermanager.e;
import com.alibaba.poplayer.trigger.Event;
import com.alibaba.poplayer.trigger.app.AppConfigItem;
import com.alibaba.poplayer.trigger.b;
import com.alibaba.poplayer.trigger.d;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Taobao */
public class c7 extends b<Event, AppConfigItem, o6> {
    public static final String APP_SCHEME = "poplayerapp://";
    private MutableContextWrapper i = new MutableContextWrapper(null);
    private ArrayList<dz0<AppConfigItem>> j = new ArrayList<>();
    private p8 k;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static c7 a = new c7();
    }

    public static c7 A() {
        return a.a;
    }

    private void B(Event event) {
        this.i.setBaseContext((Context) eu2.c(this.e));
        this.b.b(-1);
        this.c.clear();
        this.c.add(event);
        F(event);
        C(event);
    }

    private void C(Event event) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uri", event.uri);
            jSONObject.put("param", event.param);
            Iterator<dz0<AppConfigItem>> it = this.j.iterator();
            while (it.hasNext()) {
                dz0<AppConfigItem> next = it.next();
                if (next.e() != null && (next.e() instanceof PopLayerBaseView)) {
                    ((PopLayerBaseView) next.e()).onReceiveEvent("PopLayer.AttachPageInfo", jSONObject.toString());
                }
            }
        } catch (Throwable th) {
            cr1.c("notifyPageInfo.error", th);
        }
    }

    private void F(Event event) {
        if (!this.j.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<dz0<AppConfigItem>> it = this.j.iterator();
            while (it.hasNext()) {
                dz0<AppConfigItem> next = it.next();
                if (!((o6) g()).y(next.r(), event)) {
                    arrayList.add(next);
                }
            }
            cr1.b("requestsSurvivalSupervise.find dirty request size : %s.", Integer.valueOf(arrayList.size()));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                q((dz0) it2.next());
            }
        }
    }

    private Event y(String str, String str2, String str3) {
        String str4;
        Event event = new Event(1, str, str2, str3, 2);
        int indexOf = event.uri.indexOf(63);
        boolean z = true;
        boolean z2 = -1 == indexOf;
        String substring = z2 ? event.uri : event.uri.substring(0, indexOf);
        int i2 = event.uri.startsWith(APP_SCHEME) ? 1 : 2;
        if (i2 != event.source) {
            z = false;
        }
        if (!z2 || !z) {
            if (z) {
                substring = event.uri;
            }
            Event event2 = new Event(2, substring, event.param, str3, i2);
            str4 = str;
            event = event2;
        } else {
            str4 = str;
        }
        event.originUri = str4;
        return event;
    }

    private ArrayList<dz0<AppConfigItem>> z(Event event, String str, String str2) {
        tu2<AppConfigItem> tu2;
        if (str2 == null || str == null) {
            tu2 = ((o6) this.a).h(event);
        } else {
            tu2 = ((o6) this.a).x(event, str, str2);
        }
        ArrayList<dz0<AppConfigItem>> arrayList = new ArrayList<>();
        if (!tu2.a.isEmpty()) {
            Iterator<T> it = tu2.a.iterator();
            while (it.hasNext()) {
                arrayList.add(new dz0<>(1, event, (AppConfigItem) it.next(), null, this));
            }
        }
        if (2 == event.source && !tu2.b.isEmpty()) {
            this.b.c(event, tu2.b);
        }
        return arrayList;
    }

    public void D() {
        x(this.g, this.h);
    }

    public void E(String str) {
        if (!TextUtils.isEmpty(str)) {
            dz0<AppConfigItem> dz0 = null;
            Iterator<dz0<AppConfigItem>> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                dz0<AppConfigItem> next = it.next();
                if (str.equals(next.r().uuid) && next.r().autoClose) {
                    dz0 = next;
                    break;
                }
            }
            if (dz0 != null) {
                q(dz0);
            }
        }
    }

    @Override // com.alibaba.poplayer.trigger.b
    public void a(Event event) {
        ArrayList<dz0<AppConfigItem>> z;
        if (event != null && (z = z(event, this.g, this.h)) != null && !z.isEmpty()) {
            t(this.f, z);
            Iterator<dz0<AppConfigItem>> it = z.iterator();
            while (it.hasNext()) {
                dz0<AppConfigItem> next = it.next();
                if (!k(this.j, next)) {
                    this.j.add(next);
                    if (next.r().autoClose) {
                        this.k.a(next.r());
                    }
                } else {
                    cr1.b("AppTrigger.drop exist request.{%s}", next.r().toString());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.poplayer.trigger.b
    public void j() {
        this.a = new o6(PopLayer.getReference().getConfigAdapter(1));
        this.b = new d(this);
        this.k = new p8(this);
        this.c = new ArrayList();
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.poplayer.trigger.b
    public boolean k(ArrayList<dz0<AppConfigItem>> arrayList, dz0<AppConfigItem> dz0) {
        if (!(arrayList == null || arrayList.isEmpty() || dz0 == null)) {
            Iterator<dz0<AppConfigItem>> it = arrayList.iterator();
            while (it.hasNext()) {
                dz0<AppConfigItem> next = it.next();
                if (next.r().uuid.equals(dz0.r().uuid) && next.i() != PopRequest.Status.REMOVED) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.alibaba.poplayer.layermanager.PopRequest.PopRequestStatusCallBack, com.alibaba.poplayer.trigger.b
    public void onReady(PopRequest popRequest) {
        PopLayerBaseView popLayerBaseView;
        if (popRequest instanceof dz0) {
            dz0 dz0 = (dz0) popRequest;
            if (dz0.e() == null) {
                popLayerBaseView = q61.b().a(this.i, dz0.r().type);
                if (popLayerBaseView == null) {
                    cr1.b("createLayerAndAddRequest fail.Create layer Fail.", new Object[0]);
                    p(popRequest);
                    cr1.b("createLayerAndAddRequest fail.Removed.", new Object[0]);
                    return;
                }
                dz0.n(popLayerBaseView);
                popLayerBaseView.setPopRequest(dz0);
            } else {
                popLayerBaseView = (PopLayerBaseView) dz0.e();
            }
            try {
                popLayerBaseView.init(this.i, dz0);
            } catch (Throwable th) {
                cr1.c("PopLayerView init fail.", th);
            }
            e.f().b(popRequest);
            try {
                popLayerBaseView.onViewAdded(this.i);
            } catch (Throwable th2) {
                cr1.c("PopLayerView onViewAdded fail.", th2);
            }
            try {
                PopLayer.getReference().onPopped(popRequest.b(), this.i, popRequest.e());
            } catch (Throwable th3) {
                cr1.c("PopLayerView onLayerPopped notify fail.", th3);
            }
            if (hn1.a(dz0.r())) {
                ((PopLayerBaseView) dz0.e()).displayMe();
            }
        }
    }

    @Override // com.alibaba.poplayer.trigger.b
    public void q(PopRequest popRequest) {
        r(popRequest, true, true);
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            if (this.j.get(i2) == popRequest) {
                this.j.remove(i2);
                return;
            }
        }
    }

    public void x(String str, String str2) {
        Event y = y(str, str2, this.f);
        if (y.source == 1) {
            this.c.add(y);
        } else {
            B(y);
        }
        a(y);
    }
}

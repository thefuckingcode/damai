package tb;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.trigger.Event;
import com.alibaba.poplayer.trigger.b;
import com.alibaba.poplayer.trigger.d;
import com.alibaba.poplayer.trigger.page.PageConfigItem;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
public class fo1 extends b<Event, PageConfigItem, sn1> {
    public static final String PAGE_SCHEME = "poplayer://";
    public static final String TAG = "fo1";

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a {
        private static fo1 a = new fo1();
    }

    public static fo1 A() {
        return a.a;
    }

    private Event z(String str, String str2, String str3) {
        String str4;
        Event event = new Event(2, str, str2, str3, 2);
        int indexOf = event.uri.indexOf(63);
        boolean z = true;
        boolean z2 = -1 == indexOf;
        String substring = z2 ? event.uri : event.uri.substring(0, indexOf);
        int i = event.uri.startsWith(PAGE_SCHEME) ? 1 : 2;
        if (i != event.source) {
            z = false;
        }
        if (!z2 || !z) {
            if (z) {
                substring = event.uri;
            }
            Event event2 = new Event(2, substring, event.param, str3, i);
            str4 = str;
            event = event2;
        } else {
            str4 = str;
        }
        event.originUri = str4;
        return event;
    }

    public void B() {
        x(this.g, this.h);
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.poplayer.trigger.b
    public void a(Event event) {
        if (TextUtils.isEmpty(event.attachActivityKeyCode) || !event.attachActivityKeyCode.equals(this.f)) {
            cr1.b("%s activeAccept Useless event,eventKeyCode:%s,curKeyCode:%s.", TAG, event.attachActivityKeyCode, this.f);
            return;
        }
        tu2 g = ((sn1) this.a).g(event);
        cr1.b(TAG + " " + "findValidConfigs:started Count:{%s},unstarted Count:{%s}.", Integer.valueOf(g.a.size()), Integer.valueOf(g.b.size()));
        if (!g.a.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = g.a.iterator();
            while (it.hasNext()) {
                arrayList.add(new dz0(2, event, (PageConfigItem) it.next(), PopLayer.getReference().internalGetCurrentActivity(), this));
            }
            t(this.f, arrayList);
        }
        if (2 == event.source && !g.b.isEmpty()) {
            this.b.c(event, g.b);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.alibaba.poplayer.trigger.b
    public void j() {
        this.a = new sn1(PopLayer.getReference().getConfigAdapter(2));
        this.c = new ArrayList();
        this.b = new d(this);
    }

    @Override // com.alibaba.poplayer.trigger.b
    public void n(Activity activity, String str) {
        this.b.b(-1);
        c(false, str, false);
    }

    public void x(String str, String str2) {
        Event z = z(str, str2, this.f);
        cr1.b(TAG + " create Event:{%s}.", z.toString());
        if (z.source == 1) {
            this.c.add(z);
        } else {
            this.c.clear();
            this.c.add(z);
        }
        a(z);
    }

    public void y(String str) {
        this.d.remove(str);
    }
}

package tb;

import android.content.Context;
import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import com.taobao.android.ultron.datamodel.IDMContext;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public abstract class va implements ISubscriber {
    protected jn2 a;
    protected Context b;
    protected IPresenter c;
    protected IDMContext d;
    protected IDMComponent e;
    protected boolean f = false;
    protected int g = 200;
    private long h = 0;
    private String i = "";

    private <T> T d(String str, int i2) {
        List list;
        jn2 jn2 = this.a;
        if (jn2 == null) {
            return null;
        }
        Object e2 = jn2.e(str);
        if (e2 instanceof Object[]) {
            list = Arrays.asList((Object[]) e2);
        } else {
            list = e2 instanceof List ? (List) e2 : null;
        }
        if (list == null || i2 >= list.size()) {
            return null;
        }
        return (T) list.get(i2);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f = true;
    }

    /* access modifiers changed from: protected */
    public JSONObject b() {
        JSONObject fields;
        IDMEvent e2 = e();
        if (e2 == null || (fields = e2.getFields()) == null) {
            return null;
        }
        return fields;
    }

    /* access modifiers changed from: protected */
    public <T> T c(String str) {
        jn2 jn2 = this.a;
        if (jn2 == null) {
            return null;
        }
        return (T) jn2.e(str);
    }

    /* access modifiers changed from: protected */
    public IDMEvent e() {
        jn2 jn2 = this.a;
        if (jn2 == null) {
            return null;
        }
        Object c2 = jn2.c();
        if (c2 instanceof IDMEvent) {
            return (IDMEvent) c2;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public <T> T f(int i2) {
        return (T) d(kn2.KEY_VIEW_PARAMS, i2);
    }

    /* access modifiers changed from: protected */
    public boolean g() {
        JSONObject b2 = b();
        if (b2 != null && b2.getBooleanValue("request")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void h(jn2 jn2);

    @Override // com.alibaba.android.ultron.trade.event.base.ISubscriber
    public final void handleEvent(jn2 jn2) {
        if (jn2 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.h >= ((long) this.g) || !this.f || !this.i.equals(jn2.d())) {
                this.h = currentTimeMillis;
                this.i = jn2.d();
                this.a = jn2;
                this.b = jn2.b();
                IPresenter f2 = jn2.f();
                this.c = f2;
                if (this.b != null && f2 != null) {
                    this.d = f2.getDataContext();
                    IDMComponent a2 = jn2.a();
                    this.e = a2;
                    if (a2 != null) {
                        a2.updateModifiedCount();
                    }
                    h(jn2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean i(IDMComponent iDMComponent, Map<String, ? extends Object> map) {
        if (!(map == null || map.isEmpty() || iDMComponent == null)) {
            try {
                for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                    iDMComponent.getFields().put(entry.getKey(), entry.getValue());
                    tr2.b("BaseSubscriber", "writeDataBackToComponent:", entry.getKey(), String.valueOf(entry.getValue()));
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean j(Map<String, ? extends Object> map) {
        return i(this.e, map);
    }

    /* access modifiers changed from: protected */
    public boolean k(IDMEvent iDMEvent, Map<String, ? extends Object> map) {
        JSONObject fields;
        if (map == null || map.isEmpty() || iDMEvent == null || (fields = iDMEvent.getFields()) == null) {
            return false;
        }
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            fields.put(entry.getKey(), entry.getValue());
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean l(Map<String, ? extends Object> map) {
        return k(e(), map);
    }
}

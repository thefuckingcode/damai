package tb;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.alibaba.android.ultron.vfw.event.OnDynamicEventListener;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class kn2 implements OnDynamicEventListener {
    public static final String KEY_COMPONENT = "component";
    public static final String KEY_EXTRA_PARAMS = "extraParams";
    public static final String KEY_VIEW = "view";
    public static final String KEY_VIEW_PARAMS = "viewParams";
    private Context a;
    private IPresenter b;
    private jn2 c;
    private boolean d = false;
    private Map<String, List<ISubscriber>> e = new HashMap();
    private IDMComponent f;
    private String g;

    public kn2(IPresenter iPresenter) {
        if (iPresenter != null) {
            this.b = iPresenter;
            this.a = iPresenter.getContext();
            return;
        }
        throw new IllegalArgumentException("presenter can not be null");
    }

    private void c(IDMComponent iDMComponent) {
        Map<String, List<IDMEvent>> eventMap;
        if (!(iDMComponent == null || (eventMap = iDMComponent.getEventMap()) == null)) {
            IDMEvent iDMEvent = null;
            for (IDMEvent iDMEvent2 : eventMap.get(this.g)) {
                if (iDMEvent2 != null && "autoJumpOpenUrl".equals(iDMEvent2.getType())) {
                    iDMEvent = iDMEvent2;
                }
            }
            if (iDMEvent != null) {
                jn2 i = d().l("autoJumpOpenUrl").m("autoJump", "true").k(iDMEvent).i(iDMComponent);
                i.p(this.g);
                h(i);
                this.f = null;
                this.g = null;
            }
        }
    }

    private List<ISubscriber> j(String str) {
        List<ISubscriber> list = this.e.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        this.e.put(str, arrayList);
        return arrayList;
    }

    public void a(String str, ISubscriber iSubscriber) {
        if (str != null && iSubscriber != null) {
            List<ISubscriber> j = j(str);
            if (!j.contains(iSubscriber)) {
                j.add(iSubscriber);
            }
        }
    }

    public void b(Map<String, ISubscriber> map) {
        if (!(map == null || map.isEmpty())) {
            for (Map.Entry<String, ISubscriber> entry : map.entrySet()) {
                if (entry != null) {
                    a(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public jn2 d() {
        return new jn2().j(this.a).n(this.b);
    }

    public void e(hn2 hn2) {
        if (!(this.f == null || this.g == null || hn2 == null || hn2.a() == null)) {
            for (IDMComponent iDMComponent : hn2.a()) {
                if (!(iDMComponent == null || iDMComponent.getKey() == null || !iDMComponent.getKey().equals(this.f.getKey()))) {
                    c(iDMComponent);
                    return;
                }
            }
        }
    }

    public void f() {
        this.d = true;
        this.a = null;
        Map<String, List<ISubscriber>> map = this.e;
        if (map != null) {
            map.clear();
        }
    }

    public void g() {
        this.c = null;
    }

    public void h(jn2 jn2) {
        String d2 = jn2.d();
        if (!(d2 == null || this.d)) {
            List<ISubscriber> list = this.e.get(d2);
            if (list == null) {
                tr2.b("TradeEventHandler", "事件未找到", d2);
                return;
            }
            for (ISubscriber iSubscriber : list) {
                if (iSubscriber != null) {
                    iSubscriber.handleEvent(jn2);
                }
            }
        }
    }

    public jn2 i() {
        return this.c;
    }

    public void k(int i, int i2, Intent intent) {
        jn2 jn2 = this.c;
        if (jn2 != null && "openUrl".equalsIgnoreCase(jn2.d())) {
            h(d().l("openUrlResult").i(jn2.a()).m(fl1.KEY_REQUEST_CODE, Integer.valueOf(i)).m(fl1.KEY_RESULT_CODE, Integer.valueOf(i2)).m(fl1.KEY_RESULT_DATA, intent).m(fl1.KEY_OPEN_URL_EVENT, jn2));
        } else if (jn2 != null && "autoJumpOpenUrl".equalsIgnoreCase(jn2.d())) {
            h(d().l("autoJumpOpenUrlResult").i(jn2.a()).m(fl1.KEY_REQUEST_CODE, Integer.valueOf(i)).m(fl1.KEY_RESULT_CODE, Integer.valueOf(i2)).m(fl1.KEY_RESULT_DATA, intent).m(fl1.KEY_OPEN_URL_EVENT, jn2));
        }
        g();
    }

    public void l(String str, ISubscriber iSubscriber) {
        if (str != null && iSubscriber != null) {
            List<ISubscriber> j = j(str);
            j.clear();
            j.add(iSubscriber);
        }
    }

    public void m(IDMComponent iDMComponent, String str) {
        this.f = iDMComponent;
        this.g = str;
    }

    public void n(jn2 jn2) {
        this.c = jn2;
    }

    @Override // com.alibaba.android.ultron.vfw.event.OnDynamicEventListener
    public void onReceiveEvent(View view, String str, Object obj, Object obj2, Object obj3, ArrayList arrayList) {
        Object obj4;
        if (obj instanceof List) {
            List list = (List) obj;
            if (!list.isEmpty()) {
                obj4 = list.get(0);
                if ((obj4 instanceof String) && (obj3 instanceof Map) && view != null) {
                    Object obj5 = ((Map) obj3).get(p80.TAG_DINAMICX_VIEW_COMPONENT);
                    if (!(obj5 instanceof IDMComponent)) {
                        tr2.b("TradeEventHandler", "eventmap is null");
                        return;
                    }
                    IDMComponent iDMComponent = (IDMComponent) obj5;
                    int status = iDMComponent.getStatus();
                    tr2.b("TradeEventHandler", "onReceiveEvent", "component", iDMComponent.getType(), iDMComponent.getTag(), "status:", String.valueOf(status));
                    List<IDMEvent> list2 = iDMComponent.getEventMap() != null ? iDMComponent.getEventMap().get((String) obj4) : null;
                    if (status != 1) {
                        if (list2 == null) {
                            tr2.b("TradeEventHandler", "send event directly: ", String.valueOf(obj4));
                            jn2 l = d().l(String.valueOf(obj4));
                            l.m(KEY_VIEW_PARAMS, arrayList);
                            l.m(KEY_EXTRA_PARAMS, obj);
                            l.i(iDMComponent);
                            l.p((String) obj4);
                            l.k(null);
                            h(l);
                            return;
                        }
                        for (int i = 0; i < list2.size(); i++) {
                            IDMEvent iDMEvent = list2.get(i);
                            if (iDMEvent != null) {
                                String type = iDMEvent.getType();
                                tr2.b("TradeEventHandler", "onReceiveEvent", "eventType", type);
                                if (!TextUtils.isEmpty(type)) {
                                    jn2 l2 = d().l(type);
                                    l2.m(KEY_VIEW_PARAMS, arrayList);
                                    l2.m(KEY_EXTRA_PARAMS, obj);
                                    l2.i(iDMComponent);
                                    l2.p((String) obj4);
                                    l2.k(iDMEvent);
                                    h(l2);
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (obj instanceof String) {
            obj4 = obj;
        } else {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    obj4 = objArr[0];
                }
            }
            obj4 = null;
        }
        if (obj4 instanceof String) {
        }
    }
}

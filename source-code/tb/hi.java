package tb;

import cn.damai.category.discountticket.util.CityListener;
import cn.damai.message.observer.Action;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class hi {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CATEGORY_CITY_CHANGED_EVENT = "category_city_changed";
    private static hi c;
    private br a;
    private List<WeakReference<CityListener>> b = new ArrayList();

    /* compiled from: Taobao */
    public class a implements Action<String> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public void call(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "681701552")) {
                ipChange.ipc$dispatch("681701552", new Object[]{this, str});
                return;
            }
            for (int i = 0; i < hi.this.b.size(); i++) {
                CityListener cityListener = (CityListener) ((WeakReference) hi.this.b.get(i)).get();
                if (cityListener != null) {
                    cityListener.onCityChanged(str);
                }
            }
        }
    }

    public hi() {
        br brVar = new br();
        this.a = brVar;
        brVar.b(CATEGORY_CITY_CHANGED_EVENT, new a());
    }

    public static synchronized hi c() {
        synchronized (hi.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "661510683")) {
                return (hi) ipChange.ipc$dispatch("661510683", new Object[0]);
            }
            if (c == null) {
                c = new hi();
            }
            return c;
        }
    }

    public synchronized void b(CityListener cityListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "232042250")) {
            ipChange.ipc$dispatch("232042250", new Object[]{this, cityListener});
            return;
        }
        if (cityListener != null) {
            this.b.add(new WeakReference<>(cityListener));
        }
    }
}

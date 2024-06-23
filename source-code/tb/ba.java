package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
public abstract class ba<T, E> implements RequestListener<T, E> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final za2<T> a = new za2<>();
    private final HashMap<String, a> b = new HashMap<>();
    private final HashMap<String, List<RequestListener<T, E>>> c = new HashMap<>();

    private synchronized void a(String str, RequestListener<T, E> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1281031199")) {
            ipChange.ipc$dispatch("-1281031199", new Object[]{this, str, requestListener});
        } else if (requestListener != null) {
            List<RequestListener<T, E>> list = this.c.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.c.put(str, list);
            }
            if (!list.contains(requestListener)) {
                list.add(requestListener);
            }
        }
    }

    private synchronized void f(kl1<E> kl1, @Nullable RequestListener<T, E> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-70585304")) {
            ipChange.ipc$dispatch("-70585304", new Object[]{this, kl1, requestListener});
            return;
        }
        k(kl1);
        String b2 = kl1.b();
        a<T, E> e = e(kl1);
        if (e != null) {
            this.b.put(b2, e);
            a(b2, requestListener);
            e.c(this);
        }
    }

    private String g(kl1<E> kl1) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1044730429")) {
            return kl1 == null ? "" : kl1.getClass().getSimpleName();
        }
        return (String) ipChange.ipc$dispatch("1044730429", new Object[]{this, kl1});
    }

    public static void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1822376625")) {
            ipChange.ipc$dispatch("1822376625", new Object[]{str});
            return;
        }
        s72.f(str);
    }

    private void j(kl1<E> kl1, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1727214531")) {
            ipChange.ipc$dispatch("1727214531", new Object[]{this, kl1, str, str2});
        } else if (kl1 != null) {
            i("onFail " + g(kl1) + " code=" + str + " msg=" + str2);
        }
    }

    private void k(kl1<E> kl1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-474137297")) {
            ipChange.ipc$dispatch("-474137297", new Object[]{this, kl1});
        } else if (AppConfig.v()) {
            i("fetch " + g(kl1) + " url=" + kl1.d());
        }
    }

    private void l(kl1<E> kl1, RequestListener<T, E> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-90243784")) {
            ipChange.ipc$dispatch("-90243784", new Object[]{this, kl1, requestListener});
        } else if (AppConfig.v()) {
            i("load " + g(kl1) + " url=" + kl1.d());
        }
    }

    private void m(kl1<E> kl1, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-571932801")) {
            ipChange.ipc$dispatch("-571932801", new Object[]{this, kl1, t});
        } else if (AppConfig.v()) {
            i("load " + g(kl1) + " 命中缓存数据直接返回 " + t.getClass().getSimpleName() + " data hash=" + t.hashCode());
        }
    }

    private void n(kl1<E> kl1, @Nullable RequestListener<T, E> requestListener) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "40730202")) {
            ipChange.ipc$dispatch("40730202", new Object[]{this, kl1, requestListener});
        } else if (AppConfig.v()) {
            if (requestListener != null) {
                str = requestListener.getClass().getSimpleName() + "Listener入池等待";
            } else {
                str = "";
            }
            i("load " + g(kl1) + " 请求已存在" + str);
        }
    }

    private void o(kl1<E> kl1, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1950562476")) {
            ipChange.ipc$dispatch("-1950562476", new Object[]{this, kl1, t});
        } else if (AppConfig.v() && kl1 != null && t != null) {
            i("onSuccess " + g(kl1) + " T=" + t.getClass().getSimpleName() + " data hash=" + t.hashCode());
        }
    }

    public synchronized void b(kl1 kl1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119382355")) {
            ipChange.ipc$dispatch("119382355", new Object[]{this, kl1});
        } else if (kl1 != null) {
            String b2 = kl1.b();
            a aVar = this.b.get(b2);
            if (aVar != null) {
                aVar.a();
            }
            this.c.remove(b2);
        }
    }

    public void c(kl1[] kl1Arr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1399263352")) {
            ipChange.ipc$dispatch("-1399263352", new Object[]{this, kl1Arr});
        } else if (kl1Arr != null && kl1Arr.length > 0) {
            for (kl1 kl1 : kl1Arr) {
                b(kl1);
            }
        }
    }

    public synchronized void d(List<kl1<?>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1619470171")) {
            ipChange.ipc$dispatch("1619470171", new Object[]{this, list});
            return;
        }
        if (!f92.d(list)) {
            this.a.a(list);
        }
    }

    public abstract a<T, E> e(@NonNull kl1<E> kl1);

    public synchronized void h(kl1<E> kl1, @Nullable RequestListener<T, E> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1967020928")) {
            ipChange.ipc$dispatch("-1967020928", new Object[]{this, kl1, requestListener});
        } else if (kl1 != null) {
            l(kl1, requestListener);
            String b2 = kl1.b();
            if (this.b.get(b2) != null) {
                n(kl1, requestListener);
                a(b2, requestListener);
            } else if (!kl1.e() || requestListener == null) {
                f(kl1, requestListener);
            } else {
                T b3 = this.a.b(kl1);
                if (b3 != null) {
                    m(kl1, b3);
                    requestListener.onSuccess(kl1, b3);
                } else {
                    f(kl1, requestListener);
                }
            }
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public synchronized void onFail(kl1<E> kl1, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1855892214")) {
            ipChange.ipc$dispatch("-1855892214", new Object[]{this, kl1, str, str2});
            return;
        }
        j(kl1, str, str2);
        String b2 = kl1.b();
        this.b.remove(b2);
        List<RequestListener<T, E>> list = this.c.get(b2);
        this.c.remove(b2);
        if (!f92.d(list)) {
            for (RequestListener<T, E> requestListener : list) {
                requestListener.onFail(kl1, str, str2);
            }
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public synchronized void onSuccess(kl1<E> kl1, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278978323")) {
            ipChange.ipc$dispatch("-278978323", new Object[]{this, kl1, t});
            return;
        }
        o(kl1, t);
        String b2 = kl1.b();
        this.b.remove(b2);
        this.a.d(kl1, t);
        List<RequestListener<T, E>> list = this.c.get(b2);
        this.c.remove(b2);
        if (!f92.d(list)) {
            for (RequestListener<T, E> requestListener : list) {
                requestListener.onSuccess(kl1, t);
            }
        }
    }

    public synchronized void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1704074774")) {
            ipChange.ipc$dispatch("-1704074774", new Object[]{this});
            return;
        }
        this.a.e();
    }

    public synchronized void q(kl1 kl1) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-428479695")) {
            ipChange.ipc$dispatch("-428479695", new Object[]{this, kl1});
        } else if (kl1 != null) {
            this.c.remove(kl1.b());
        }
    }
}

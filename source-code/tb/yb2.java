package tb;

import android.text.TextUtils;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.interceptor.Callback;
import anetwork.channel.interceptor.Interceptor;
import com.taobao.slide.core.b;
import com.taobao.slide.task.UpdateTask;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: Taobao */
public class yb2 implements Interceptor {
    private b a;

    /* compiled from: Taobao */
    class a implements Callback {
        final /* synthetic */ Interceptor.Chain a;

        a(Interceptor.Chain chain) {
            this.a = chain;
        }

        @Override // anetwork.channel.interceptor.Callback
        public void onDataReceiveSize(int i, int i2, pd pdVar) {
            this.a.callback().onDataReceiveSize(i, i2, pdVar);
        }

        @Override // anetwork.channel.interceptor.Callback
        public void onFinish(DefaultFinishEvent defaultFinishEvent) {
            this.a.callback().onFinish(defaultFinishEvent);
        }

        @Override // anetwork.channel.interceptor.Callback
        public void onResponseCode(int i, Map<String, List<String>> map) {
            List<String> b2;
            if (!(map == null || (b2 = yb2.b(map, "A-SLIDER-P")) == null || b2.isEmpty())) {
                String d = uk.d(b2.get(0));
                if (!TextUtils.isEmpty(d)) {
                    hj2.b(new UpdateTask(yb2.this.a, false, false, d));
                }
            }
            this.a.callback().onResponseCode(i, map);
        }
    }

    public yb2(b bVar) {
        this.a = bVar;
    }

    public static List<String> b(Map<String, List<String>> map, String str) {
        if (map != null && !map.isEmpty() && !TextUtils.isEmpty(str)) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    @Override // anetwork.channel.interceptor.Interceptor
    public Future intercept(Interceptor.Chain chain) {
        boolean z;
        anet.channel.request.a request = chain.request();
        Callback callback = chain.callback();
        try {
            if (UpdateTask.isAllow() && !TextUtils.isEmpty(request.h())) {
                String[] probeHosts = this.a.b().getProbeHosts();
                int length = probeHosts.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (request.h().contains(probeHosts[i])) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
            z = false;
            if (z) {
                String format = String.format("%s=%s&%s=%s", "appKey", this.a.b().getAppKey(), "ver", this.a.f());
                if (!TextUtils.isEmpty(format)) {
                    request = chain.request().u().I("A-SLIDER-Q", uk.e(format)).J();
                }
                callback = new a(chain);
            }
        } catch (Throwable th) {
            o22.d("SlideInterceptor", "intercept", th, new Object[0]);
        }
        return chain.proceed(request, callback);
    }
}

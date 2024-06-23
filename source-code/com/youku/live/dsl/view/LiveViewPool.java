package com.youku.live.dsl.view;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.thread.ILiveThreadFactory;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class LiveViewPool {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MAX_POOL_NUM = 5;
    private Context mContext;
    private ConcurrentHashMap<String, Vector<View>> viewMap;

    /* compiled from: Taobao */
    public static class CachedView<T extends View> {
        private boolean inUse = false;
        private View view = null;

        CachedView(T t) {
            this.view = t;
        }

        public View getView() {
            return this.view;
        }

        /* access modifiers changed from: package-private */
        public boolean inUse() {
            return this.inUse;
        }
    }

    /* compiled from: Taobao */
    private static class Holder {
        private static LiveViewPool instance = new LiveViewPool();

        private Holder() {
        }
    }

    public static LiveViewPool getInstance(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-353273093")) {
            return (LiveViewPool) ipChange.ipc$dispatch("-353273093", new Object[]{context});
        }
        if (context instanceof Application) {
            Holder.instance.setContext(context);
        } else {
            Holder.instance.setContext(context.getApplicationContext());
        }
        return Holder.instance;
    }

    private void setContext(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-447628630")) {
            ipChange.ipc$dispatch("-447628630", new Object[]{this, context});
            return;
        }
        this.mContext = context;
    }

    public CachedView getView(String str) {
        Vector<View> vector;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2010212042")) {
            return (CachedView) ipChange.ipc$dispatch("2010212042", new Object[]{this, str});
        }
        CachedView cachedView = null;
        if (TextUtils.isEmpty(str) || (vector = this.viewMap.get(str)) == null) {
            return null;
        }
        Enumeration<View> elements = vector.elements();
        while (elements.hasMoreElements()) {
            CachedView cachedView2 = (CachedView) elements.nextElement();
            if (!cachedView2.inUse()) {
                cachedView2.inUse = true;
                cachedView = cachedView2;
            }
        }
        return cachedView;
    }

    public void put(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1466949538")) {
            ipChange.ipc$dispatch("-1466949538", new Object[]{this, iArr});
        } else if (iArr != null && iArr.length > 0) {
            for (int i : iArr) {
                put(i);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.youku.live.dsl.view.LiveViewPool$CachedView, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void putView(int i, View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1193056698")) {
            ipChange.ipc$dispatch("1193056698", new Object[]{this, Integer.valueOf(i), view, Boolean.valueOf(z)});
        } else if (i > 0 && view != null) {
            CachedView cachedView = new CachedView(view);
            cachedView.view = view;
            cachedView.inUse = z;
            ConcurrentHashMap<String, Vector<View>> concurrentHashMap = this.viewMap;
            Vector<View> vector = concurrentHashMap.get(i + "");
            if (vector == null) {
                vector = new Vector<>();
            }
            if (vector.size() < 5) {
                vector.addElement(new CachedView(view));
                ConcurrentHashMap<String, Vector<View>> concurrentHashMap2 = this.viewMap;
                concurrentHashMap2.put(i + "", vector);
            }
        }
    }

    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-774916008")) {
            ipChange.ipc$dispatch("-774916008", new Object[]{this});
            return;
        }
        ConcurrentHashMap<String, Vector<View>> concurrentHashMap = this.viewMap;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            for (Map.Entry<String, Vector<View>> entry : this.viewMap.entrySet()) {
                Vector<View> value = entry.getValue();
                if (value != null && value.size() > 0) {
                    Enumeration<View> elements = value.elements();
                    while (elements.hasMoreElements()) {
                        value.removeElement((CachedView) elements.nextElement());
                    }
                }
            }
            this.viewMap.clear();
            this.viewMap = null;
            this.mContext = null;
        }
    }

    public void returnView(CachedView cachedView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1495720438")) {
            ipChange.ipc$dispatch("1495720438", new Object[]{this, cachedView});
            return;
        }
        cachedView.inUse = false;
    }

    private LiveViewPool() {
        this.mContext = null;
        this.viewMap = null;
        this.viewMap = new ConcurrentHashMap<>();
    }

    public void put(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-462981197")) {
            ipChange.ipc$dispatch("-462981197", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mContext != null && i > 0) {
            AnonymousClass1 r0 = new Runnable() {
                /* class com.youku.live.dsl.view.LiveViewPool.AnonymousClass1 */
                private static transient /* synthetic */ IpChange $ipChange;

                public void run() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-808282393")) {
                        ipChange.ipc$dispatch("-808282393", new Object[]{this});
                    } else if (LiveViewPool.this.mContext != null) {
                        View inflate = LayoutInflater.from(LiveViewPool.this.mContext).inflate(i, (ViewGroup) null);
                        ConcurrentHashMap concurrentHashMap = LiveViewPool.this.viewMap;
                        Vector vector = (Vector) concurrentHashMap.get(i + "");
                        if (vector == null) {
                            vector = new Vector();
                        }
                        if (vector.size() < 5) {
                            vector.addElement(new CachedView(inflate));
                            ConcurrentHashMap concurrentHashMap2 = LiveViewPool.this.viewMap;
                            concurrentHashMap2.put(i + "", vector);
                        }
                    }
                }
            };
            ILiveThreadFactory iLiveThreadFactory = (ILiveThreadFactory) Dsl.getService(ILiveThreadFactory.class);
            if (iLiveThreadFactory != null) {
                iLiveThreadFactory.excute(r0);
            }
        }
    }
}

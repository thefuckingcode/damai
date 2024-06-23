package com.alibaba.pictures.piclocation;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.pictures.piclocation.listener.LocateGpsPicListener;
import com.alibaba.pictures.piclocation.listener.LocateRegionPicListener;
import com.alibaba.pictures.piclocation.mtop.LocationRequestDelegate;
import com.alibaba.pictures.piclocation.mtop.RegionRequestHandler;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.m40;
import tb.m81;
import tb.nz1;

/* compiled from: Taobao */
public final class LocateQueueManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static boolean i = true;
    @Nullable
    private static LocateQueueManager j;
    private final AtomicBoolean a;
    private long b;
    private final List<LocateGpsPicListener> c;
    private final List<LocateRegionPicListener> d;
    private LocationInterface e;
    private boolean f;
    private Handler g;
    @Nullable
    private LocationRequestDelegate h;

    /* compiled from: Taobao */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        @Nullable
        public final LocateQueueManager a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "836604349")) {
                return (LocateQueueManager) ipChange.ipc$dispatch("836604349", new Object[]{this});
            }
            if (LocateQueueManager.j == null) {
                LocateQueueManager.j = new LocateQueueManager(null);
            }
            return LocateQueueManager.j;
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    /* compiled from: Taobao */
    public static final class b implements RegionRequestHandler {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LocateQueueManager a;
        final /* synthetic */ m81 b;

        b(LocateQueueManager locateQueueManager, m81 m81) {
            this.a = locateQueueManager;
            this.b = m81;
        }

        @Override // com.alibaba.pictures.piclocation.mtop.RegionRequestHandler
        public void onRequestRegionDataFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1432701791")) {
                ipChange.ipc$dispatch("1432701791", new Object[]{this});
                return;
            }
            this.a.a.set(false);
            m81 m81 = this.b;
            m81.c = "";
            m81.d = "";
            m81.f = "";
            m81.g = LocationDataStatus.GETFAILED;
            this.a.l(m81);
        }

        @Override // com.alibaba.pictures.piclocation.mtop.RegionRequestHandler
        public void onRequestRegionDataSuccess(@NotNull nz1 nz1) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-143814019")) {
                ipChange.ipc$dispatch("-143814019", new Object[]{this, nz1});
                return;
            }
            k21.i(nz1, "regionPicResponse");
            this.a.a.set(false);
            throw null;
        }
    }

    /* compiled from: Taobao */
    public static final class c extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LocateQueueManager a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(LocateQueueManager locateQueueManager, Looper looper) {
            super(looper);
            this.a = locateQueueManager;
        }

        public void handleMessage(@NotNull Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1365401431")) {
                ipChange.ipc$dispatch("1365401431", new Object[]{this, message});
                return;
            }
            k21.i(message, "msg");
            Object obj = message.obj;
            if (obj instanceof LocateGpsPicListener) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.pictures.piclocation.listener.LocateGpsPicListener");
                LocateGpsPicListener locateGpsPicListener = (LocateGpsPicListener) obj;
                if (message.what == locateGpsPicListener.hashCode()) {
                    if (!this.a.n()) {
                        LocationDataStatus locationDataStatus = LocationDataStatus.NOPERMISSION;
                        locateGpsPicListener.onFailed(locationDataStatus.getCode(), locationDataStatus.getDes());
                    } else {
                        LocationDataStatus locationDataStatus2 = LocationDataStatus.TIMEOUT;
                        locateGpsPicListener.onFailed(locationDataStatus2.getCode(), locationDataStatus2.getDes());
                    }
                    this.a.c.remove(locateGpsPicListener);
                } else {
                    return;
                }
            }
            Object obj2 = message.obj;
            if (obj2 instanceof LocateRegionPicListener) {
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type com.alibaba.pictures.piclocation.listener.LocateRegionPicListener");
                LocateRegionPicListener locateRegionPicListener = (LocateRegionPicListener) obj2;
                if (message.what == locateRegionPicListener.hashCode()) {
                    LocationDataStatus locationDataStatus3 = LocationDataStatus.TIMEOUT;
                    locateRegionPicListener.onFailed(locationDataStatus3.getCode(), locationDataStatus3.getDes());
                    this.a.d.remove(locateRegionPicListener);
                } else {
                    return;
                }
            }
            this.a.u();
        }
    }

    private LocateQueueManager() {
        this.a = new AtomicBoolean(false);
        this.c = new ArrayList(4);
        this.d = new ArrayList(4);
        this.f = true;
        this.g = new c(this, Looper.getMainLooper());
    }

    private final void j(m81 m81) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1384459916")) {
            ipChange.ipc$dispatch("-1384459916", new Object[]{this, m81});
        } else if (this.h == null) {
            m81.c = "";
            m81.d = "";
            m81.g = LocationDataStatus.NOTINIT;
            l(m81);
        } else if (this.a.compareAndSet(false, true)) {
            LocationRequestDelegate locationRequestDelegate = this.h;
            k21.f(locationRequestDelegate);
            locationRequestDelegate.requestRegionData(m81, new b(this, m81));
        }
    }

    private final void k(m81 m81) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "498234988")) {
            ipChange.ipc$dispatch("498234988", new Object[]{this, m81});
        } else if (m81 != null) {
            List<LocateGpsPicListener> list = this.c;
            if (!(list == null || list.size() == 0)) {
                Iterator it = Collections.synchronizedCollection(this.c).iterator();
                while (it.hasNext()) {
                    LocateGpsPicListener locateGpsPicListener = (LocateGpsPicListener) it.next();
                    it.remove();
                    if (locateGpsPicListener != null) {
                        this.g.post(new LocateQueueManager$doLocationListenerCallback$1(m81, locateGpsPicListener));
                        this.g.removeMessages(locateGpsPicListener.hashCode());
                    }
                }
            }
            u();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void l(m81 m81) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "390802317")) {
            ipChange.ipc$dispatch("390802317", new Object[]{this, m81});
        } else if (m81 != null) {
            List<LocateRegionPicListener> list = this.d;
            if (!(list == null || list.size() == 0)) {
                Iterator it = Collections.synchronizedCollection(this.d).iterator();
                while (it.hasNext()) {
                    LocateRegionPicListener locateRegionPicListener = (LocateRegionPicListener) it.next();
                    it.remove();
                    if (locateRegionPicListener != null) {
                        this.g.post(new LocateQueueManager$doRegionListenerCallback$1(m81, locateRegionPicListener));
                        this.g.removeMessages(locateRegionPicListener.hashCode());
                    }
                }
            }
            u();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1983561923")) {
            return ((Boolean) ipChange.ipc$dispatch("-1983561923", new Object[]{this})).booleanValue();
        } else if (this.c.size() != 0) {
            return false;
        } else {
            if (this.d.size() != 0 && !this.a.get()) {
                return false;
            }
            LocationInterface locationInterface = this.e;
            if (locationInterface != null) {
                k21.f(locationInterface);
                locationInterface.stop();
            }
            return true;
        }
    }

    public final void h(@NotNull LocateGpsPicListener locateGpsPicListener, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1581664106")) {
            ipChange.ipc$dispatch("-1581664106", new Object[]{this, locateGpsPicListener, Long.valueOf(j2)});
            return;
        }
        k21.i(locateGpsPicListener, "listener");
        if (j2 >= 0) {
            Message message = new Message();
            message.what = locateGpsPicListener.hashCode();
            message.obj = locateGpsPicListener;
            this.g.sendMessageDelayed(message, j2);
        }
        this.c.add(locateGpsPicListener);
    }

    public final void i(@NotNull LocateRegionPicListener locateRegionPicListener, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-392467978")) {
            ipChange.ipc$dispatch("-392467978", new Object[]{this, locateRegionPicListener, Long.valueOf(j2)});
            return;
        }
        k21.i(locateRegionPicListener, "listener");
        if (j2 >= 0) {
            Message message = new Message();
            message.what = locateRegionPicListener.hashCode();
            message.obj = locateRegionPicListener;
            this.g.sendMessageDelayed(message, j2);
        }
        this.d.add(locateRegionPicListener);
    }

    public final long m() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "870482962")) {
            return this.b;
        }
        return ((Long) ipChange.ipc$dispatch("870482962", new Object[]{this})).longValue();
    }

    public final boolean n() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1451658715")) {
            return this.f;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1451658715", new Object[]{this})).booleanValue();
    }

    public final void o(@Nullable m81 m81) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1682723604")) {
            ipChange.ipc$dispatch("-1682723604", new Object[]{this, m81});
        } else if (m81 == null) {
        } else {
            if (m81.a != 0.0d || m81.b != 0.0d) {
                this.b = System.currentTimeMillis();
                List<LocateGpsPicListener> list = this.c;
                if (!(list == null || list.size() == 0)) {
                    k(m81);
                }
                t(m81);
            }
        }
    }

    public final void p(int i2, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1176470254")) {
            ipChange.ipc$dispatch("1176470254", new Object[]{this, Integer.valueOf(i2), str});
            return;
        }
        k21.i(str, SocialConstants.PARAM_APP_DESC);
        this.b = 0;
        List<LocateGpsPicListener> list = this.c;
        if (!(list == null || list.size() == 0)) {
            Iterator<LocateGpsPicListener> it = this.c.iterator();
            while (it.hasNext()) {
                LocateGpsPicListener next = it.next();
                if (next != null) {
                    next.onFailed(i2, str);
                    this.g.removeMessages(next.hashCode());
                    it.remove();
                }
            }
        }
        u();
    }

    public final void q(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1632342343")) {
            ipChange.ipc$dispatch("1632342343", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.f = z;
    }

    public final void r(@Nullable LocationInterface locationInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1917895942")) {
            ipChange.ipc$dispatch("1917895942", new Object[]{this, locationInterface});
            return;
        }
        this.e = locationInterface;
    }

    public final void s(@Nullable LocationRequestDelegate locationRequestDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-701948599")) {
            ipChange.ipc$dispatch("-701948599", new Object[]{this, locationRequestDelegate});
            return;
        }
        this.h = locationRequestDelegate;
    }

    public final void t(@NotNull m81 m81) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "476711526")) {
            ipChange.ipc$dispatch("476711526", new Object[]{this, m81});
            return;
        }
        k21.i(m81, "info");
        List<LocateRegionPicListener> list = this.d;
        if (list != null && list.size() != 0 && !this.a.get()) {
            j(m81);
        }
    }

    public /* synthetic */ LocateQueueManager(m40 m40) {
        this();
    }
}

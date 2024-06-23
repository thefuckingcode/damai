package tb;

import android.content.Context;
import com.taobao.phenix.builder.ChainBuilders;
import com.taobao.phenix.cache.disk.DiskCache;
import com.taobao.phenix.chain.ImageDecodingListener;
import com.taobao.phenix.decode.EncodedDataInspector;
import com.taobao.phenix.loader.LocalSchemeHandler;
import com.taobao.phenix.request.ImageFlowMonitor;
import com.taobao.phenix.request.a;
import com.taobao.phenix.strategy.ModuleStrategySupplier;
import com.taobao.rxm.schedule.SchedulerSupplier;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
public class tp1 implements ChainBuilders {
    private static tp1 v;
    public static boolean w;
    private final ec1 a = new ec1();
    private final yb b = new yb();
    private final w80 c = new w80();
    private final ae d = new ae();
    private final oh0 e = new oh0();
    private final sy0 f = new sy0();
    private final f42 g = new f42();
    private final x80 h = new x80();
    private final jj1 i = new jj1(this);
    private Context j;
    private boolean k;
    private boolean l = true;
    private boolean m = true;
    private ge n;
    private EncodedDataInspector o;
    private ImageFlowMonitor p;
    private ModuleStrategySupplier q;
    private boolean r;
    private List<LocalSchemeHandler> s;
    private ImageDecodingListener t;
    private boolean u = false;

    private tp1() {
    }

    private ef1 l(String str) {
        ModuleStrategySupplier moduleStrategySupplier = this.q;
        if (moduleStrategySupplier != null) {
            return moduleStrategySupplier.get(str);
        }
        return null;
    }

    public static synchronized tp1 o() {
        tp1 tp1;
        synchronized (tp1.class) {
            if (v == null) {
                v = new tp1();
            }
            tp1 = v;
        }
        return tp1;
    }

    public yb a() {
        return this.b;
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public Context applicationContext() {
        return this.j;
    }

    public synchronized void b() {
        cs1.d(this.j, "Phenix.with(Context) hasn't been called before chain producer building");
        this.i.a();
        this.k = true;
        vr2.f("Initialize", "Phenix chain producer build complete", new Object[0]);
    }

    public ae c() {
        return this.d;
    }

    @Deprecated
    public void d(cq1 cq1) {
        if (cq1 != null) {
            cq1.cancel();
        }
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public w80 diskCacheBuilder() {
        return this.c;
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public x80 diskCacheKVBuilder() {
        return this.h;
    }

    public void e() {
        if (this.k) {
            this.a.build().clear();
            for (DiskCache diskCache : this.c.build().getAll()) {
                if (diskCache.open(this.j)) {
                    diskCache.clear();
                }
            }
            vr2.i("UserAction", "clear all phenix cache", new Object[0]);
        }
    }

    public r02 f(String str, String str2, int i2, boolean z) {
        String str3;
        int i3;
        boolean z2 = true;
        cs1.b(!j22.b(), "fetchDiskCache must be called in non-main thread");
        r02 r02 = null;
        if (!this.k) {
            return null;
        }
        if (z) {
            str3 = str2;
            i3 = i2;
        } else {
            a aVar = new a(str2, this.n, this.r);
            if (aVar.G().n()) {
                return null;
            }
            str3 = aVar.D();
            i3 = aVar.C();
        }
        l(str);
        DiskCache diskCache = diskCacheBuilder().build().get(17);
        if (diskCache != null && diskCache.open(this.j)) {
            r02 = diskCache.get(str3, i3);
        }
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(z);
        if (r02 == null) {
            z2 = false;
        }
        objArr[3] = Boolean.valueOf(z2);
        vr2.l("UserAction", str2, "fetch disk cache, module=%s, catalog=%d, direct=%b, result=%B", objArr);
        return r02;
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public oh0 fileLoaderBuilder() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public ge g() {
        return this.n;
    }

    public EncodedDataInspector h() {
        return this.o;
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public sy0 httpLoaderBuilder() {
        return this.f;
    }

    public List<LocalSchemeHandler> i() {
        return this.s;
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public boolean isGenericTypeCheckEnabled() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public ImageDecodingListener j() {
        return this.t;
    }

    public ImageFlowMonitor k() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public jj1 m() {
        return this.i;
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public ec1 memCacheBuilder() {
        return this.a;
    }

    public SchedulerSupplier n() {
        return this.i.c();
    }

    public boolean p() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return this.m;
    }

    public vp1 s(String str) {
        return u(null, str, o().g());
    }

    @Override // com.taobao.phenix.builder.ChainBuilders
    public f42 schedulerBuilder() {
        return this.g;
    }

    public vp1 t(String str, String str2) {
        return u(str, str2, o().g());
    }

    public vp1 u(String str, String str2, ge geVar) {
        return new vp1(l(str), str2, geVar);
    }

    public vp1 v(String str, ge geVar) {
        return u(null, str, geVar);
    }

    public boolean w(LocalSchemeHandler localSchemeHandler) {
        synchronized (this) {
            if (this.s == null) {
                this.s = new CopyOnWriteArrayList();
            }
        }
        return this.s.add(localSchemeHandler);
    }

    public void x(ImageDecodingListener imageDecodingListener) {
        this.t = imageDecodingListener;
    }

    public void y(ImageFlowMonitor imageFlowMonitor) {
        this.p = imageFlowMonitor;
        vr2.f("Initialize", "setup image flow monitor=%s", imageFlowMonitor);
    }

    public synchronized tp1 z(Context context) {
        cs1.d(context, "Phenix with context must not be null.");
        if (this.j == null) {
            this.j = context.getApplicationContext();
        }
        return this;
    }
}

package com.uploader.implement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.uploader.export.ITaskListener;
import com.uploader.export.IUploaderDependency;
import com.uploader.export.IUploaderManager;
import com.uploader.export.IUploaderTask;
import com.uploader.implement.a.d;
import com.uploader.implement.a.g;
import com.uploader.implement.a.i;
import com.uploader.implement.d.c;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import tb.i13;

/* compiled from: Taobao */
public class UploaderManager implements IUploaderManager, d {
    private int a;
    private ArrayList<i> b;
    private ArrayList<Pair<Integer, String>> c;
    private SparseArray<ArrayList<Pair<i, com.uploader.implement.d.b>>> d;
    private ArrayList<Pair<i, com.uploader.implement.d.b>> e;
    private com.uploader.implement.b.a.b f;
    private BroadcastReceiver g;
    private volatile Handler h;
    private volatile boolean i;
    private Runnable j;
    private boolean k;
    private String l;
    private final int m;
    private c n;
    private final byte[] o;
    private final int p;

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class a implements Runnable {
        final UploaderManager a;
        final int b;
        final Object[] c;

        a(int i, @NonNull UploaderManager uploaderManager, Object... objArr) {
            this.b = i;
            this.a = uploaderManager;
            this.c = objArr;
        }

        public void run() {
            int i = this.b;
            if (i == 1) {
                UploaderManager uploaderManager = this.a;
                Object[] objArr = this.c;
                uploaderManager.d((IUploaderTask) objArr[0], (ITaskListener) objArr[1], (Handler) objArr[2]);
            } else if (i == 2) {
                this.a.c((IUploaderTask) this.c[0]);
            } else if (i == 3) {
                this.a.b();
            } else if (i == 4) {
                this.a.i((g) this.c[0]);
            } else if (i == 5) {
                this.a.j();
            }
        }
    }

    /* access modifiers changed from: private */
    /* compiled from: Taobao */
    public static class b extends BroadcastReceiver {
        private final WeakReference<UploaderManager> a;

        b(UploaderManager uploaderManager) {
            this.a = new WeakReference<>(uploaderManager);
        }

        public void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                try {
                    intent.getBooleanExtra("noConnectivity", false);
                    intent.getStringExtra("extraInfo");
                    UploaderManager uploaderManager = this.a.get();
                    if (uploaderManager != null) {
                        uploaderManager.k();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    UploaderManager() {
        this(0);
    }

    private int a(String str) {
        if (str == null) {
            str = "";
        }
        int size = this.c.size() - 1;
        while (true) {
            if (size < 0) {
                size = -1;
                break;
            } else if (((String) this.c.get(size).second).equals(str)) {
                break;
            } else {
                size--;
            }
        }
        if (size < 0) {
            ArrayList<Pair<Integer, String>> arrayList = this.c;
            int i2 = this.a + 1;
            this.a = i2;
            arrayList.add(new Pair<>(Integer.valueOf(i2), str));
            size = this.c.size() - 1;
        }
        return ((Integer) this.c.get(size).first).intValue();
    }

    private void f(i iVar, @Nullable ArrayList<Pair<i, com.uploader.implement.d.b>> arrayList) {
        int G = iVar.G();
        if (this.f == null) {
            this.f = new com.uploader.implement.b.a.b(this.n, this.h.getLooper());
        }
        c cVar = new c(this.n, this.f, this.h.getLooper());
        if (arrayList == null) {
            arrayList = new ArrayList<>(2);
            this.d.append(G, arrayList);
        }
        Pair<i, com.uploader.implement.d.b> create = Pair.create(iVar, cVar);
        arrayList.add(create);
        this.e.add(create);
        iVar.h(this);
        iVar.m(cVar);
        if (a.d(4)) {
            a.a(4, "UploaderManager", this.m + " startAction task:" + iVar.F().hashCode());
        }
    }

    private Handler g() {
        Handler handler = this.h;
        if (handler != null) {
            return handler;
        }
        if (a.d(2)) {
            a.a(2, "UploaderManager", this.m + " doRetrieve and register");
        }
        HandlerThread handlerThread = new HandlerThread("[aus]");
        handlerThread.start();
        Handler handler2 = new Handler(handlerThread.getLooper());
        this.h = handler2;
        return handler2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void j() {
        boolean z;
        String str;
        boolean equals;
        NetworkInfo b2 = i13.b(this.n.c.getApplicationContext());
        if (b2 != null) {
            z = b2.isConnected();
            str = b2.getExtraInfo();
        } else {
            str = null;
            z = false;
        }
        boolean z2 = this.k;
        String str2 = this.l;
        boolean z3 = true;
        if (z2 == z) {
            if (str2 != null) {
                equals = str2.equals(str);
            } else if (str != null) {
                equals = str.equals(str2);
            } else {
                z3 = false;
            }
            z3 = true ^ equals;
        }
        if (a.d(8)) {
            a.a(8, "UploaderManager", this.m + " doNetworkChanged, extraInfo(new|old):" + str + "|" + str2 + " isConnected(new|old):" + z + "|" + z2 + " changed:" + z3);
        }
        if (z3) {
            this.k = z;
            this.l = str;
            if (!z) {
                com.uploader.implement.b.a.b bVar = this.f;
                if (bVar != null) {
                    bVar.e();
                    return;
                }
                return;
            }
            int size = this.e.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Pair<i, com.uploader.implement.d.b> pair = this.e.get(i3);
                ((i) pair.first).m((com.uploader.implement.d.b) pair.second);
                i2++;
            }
            int l2 = l();
            if (a.d(2)) {
                a.a(2, "UploaderManager", this.m + " restartedCount:" + i2 + " suppliedCount:" + l2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k() {
        synchronized (this.o) {
            Handler handler = this.h;
            if (handler != null) {
                handler.post(new a(5, this, new Object[0]));
            }
        }
    }

    private int l() {
        int i2 = 0;
        for (int size = this.b.size() - 1; size >= 0; size--) {
            i iVar = this.b.get(size);
            ArrayList<Pair<i, com.uploader.implement.d.b>> arrayList = this.d.get(iVar.G());
            if (arrayList == null) {
                if (this.d.size() < 2) {
                    this.b.remove(size);
                    f(iVar, arrayList);
                }
            } else if (arrayList.size() < 2) {
                this.b.remove(size);
                f(iVar, arrayList);
            }
            i2++;
        }
        if (a.d(2)) {
            a.a(2, "UploaderManager", this.m + " suppliedCount:" + i2);
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Handler handler = this.h;
        if (handler != null) {
            Context applicationContext = this.n.c.getApplicationContext();
            BroadcastReceiver broadcastReceiver = this.g;
            if (broadcastReceiver != null) {
                try {
                    applicationContext.unregisterReceiver(broadcastReceiver);
                } catch (Exception e2) {
                    if (a.d(16)) {
                        a.b(16, "UploaderManager", "doClean unregisterReceiver", e2);
                    }
                } catch (Throwable th) {
                    this.g = null;
                    throw th;
                }
                this.g = null;
            }
            handler.removeCallbacksAndMessages(null);
            handler.getLooper().quit();
            this.j = null;
            this.h = null;
            this.d = new SparseArray<>(2);
            this.e.trimToSize();
            this.c.trimToSize();
            this.b.trimToSize();
            com.uploader.implement.b.a.b bVar = this.f;
            if (bVar != null) {
                bVar.e();
                this.f = null;
            }
            if (a.d(2)) {
                a.a(2, "UploaderManager", this.m + " doClean and release");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(IUploaderTask iUploaderTask) {
        boolean z;
        int a2 = a(iUploaderTask.getBizType());
        int size = this.b.size() - 1;
        while (true) {
            if (size < 0) {
                z = false;
                break;
            } else if (this.b.get(size).F().equals(iUploaderTask)) {
                this.b.remove(size).p(null);
                z = true;
                break;
            } else {
                size--;
            }
        }
        if (!z) {
            ArrayList<Pair<i, com.uploader.implement.d.b>> arrayList = this.d.get(a2);
            if (arrayList != null) {
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    if (((i) arrayList.get(size2).first).F().equals(iUploaderTask)) {
                        Pair<i, com.uploader.implement.d.b> pair = arrayList.get(size2);
                        ((i) pair.first).p((com.uploader.implement.d.b) pair.second);
                        if (a.d(4)) {
                            a.a(4, "UploaderManager", this.m + " doCancel cancel concurrent task:" + iUploaderTask);
                            return;
                        }
                        return;
                    }
                }
            }
        } else if (a.d(4)) {
            a.a(4, "UploaderManager", this.m + " doCancel cancel waiting task:" + iUploaderTask);
        }
    }

    @Override // com.uploader.export.IUploaderManager
    public boolean cancelAsync(@NonNull IUploaderTask iUploaderTask) {
        boolean z = false;
        if (iUploaderTask == null) {
            if (a.d(8)) {
                a.a(8, "UploaderManager", this.m + " cancelAsync fail,task null");
            }
            return false;
        } else if (!this.i) {
            return false;
        } else {
            synchronized (this.o) {
                if (!this.i) {
                    return false;
                }
                Handler handler = this.h;
                if (handler != null) {
                    if (handler.post(new a(2, this, iUploaderTask))) {
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008c, code lost:
        if (r10 == false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0092, code lost:
        if (com.uploader.implement.a.d(4) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0094, code lost:
        com.uploader.implement.a.a(4, "UploaderManager", r8.m + " doUpload, remove count down, start, task:" + r9.hashCode());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b4, code lost:
        r8.b.add(0, r7);
        r7.r();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c0, code lost:
        if (com.uploader.implement.a.d(4) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c2, code lost:
        com.uploader.implement.a.a(4, "UploaderManager", r8.m + " doUpload, remove count down, wait, stopReason:" + r11 + " task:" + r9.hashCode());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007f A[SYNTHETIC] */
    public void d(IUploaderTask iUploaderTask, ITaskListener iTaskListener, Handler handler) {
        if (this.g == null) {
            Context applicationContext = this.n.c.getApplicationContext();
            b bVar = new b(this);
            this.g = bVar;
            this.n.c.registerReceiver(bVar, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
            NetworkInfo b2 = i13.b(applicationContext);
            if (b2 != null) {
                this.k = b2.isConnected();
                this.l = b2.getExtraInfo();
            }
        }
        int a2 = a(iUploaderTask.getBizType());
        ArrayList<Pair<i, com.uploader.implement.d.b>> arrayList = this.d.get(a2);
        i iVar = new i(this.n, iUploaderTask, a2, iTaskListener, handler);
        boolean z = true;
        int i2 = 2;
        if (arrayList != null) {
            if (arrayList.size() == 2) {
                z = false;
                i2 = 1;
                synchronized (this.o) {
                    Handler handler2 = this.h;
                    if (handler2 != null) {
                        handler2.removeCallbacks(this.j);
                    } else {
                        return;
                    }
                }
            }
        } else if (this.d.size() == 2) {
            z = false;
            synchronized (this.o) {
            }
        }
        if (!i13.a(this.n.c.getApplicationContext())) {
            z = false;
            i2 = 3;
        } else {
            f(iVar, arrayList);
            i2 = 0;
        }
        synchronized (this.o) {
        }
    }

    /* access modifiers changed from: package-private */
    public void i(g gVar) {
        boolean z;
        i iVar = (i) gVar;
        int G = iVar.G();
        ArrayList<Pair<i, com.uploader.implement.d.b>> arrayList = this.d.get(G);
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    z = false;
                    break;
                } else if (((i) arrayList.get(size).first).equals(iVar)) {
                    z = this.e.remove(arrayList.remove(size));
                    break;
                }
            }
            if (z) {
                if (arrayList.size() == 0) {
                    this.d.remove(G);
                    if (a.d(4)) {
                        a.a(4, "UploaderManager", this.m + " onFinish remove concurrent task:" + iVar.F().hashCode());
                    }
                }
                if (i13.a(this.n.c.getApplicationContext())) {
                    l();
                    if (this.d.size() == 0 && this.b.size() == 0) {
                        synchronized (this.o) {
                            Handler handler = this.h;
                            if (a.d(8)) {
                                a.a(8, "UploaderManager", this.m + " start count down:" + 90000);
                            }
                            if (handler != null) {
                                a aVar = new a(3, this, new Object[0]);
                                this.j = aVar;
                                handler.postDelayed(aVar, 90000);
                            }
                        }
                    } else if (a.d(8)) {
                        a.a(8, "UploaderManager", this.m + " doFinish has more data");
                    }
                } else if (a.d(8)) {
                    a.a(8, "UploaderManager", this.m + " doFinish no network");
                }
            } else if (a.d(8)) {
                a.a(8, "UploaderManager", this.m + " doFinish !removed");
            }
        } else if (a.d(8)) {
            a.a(8, "UploaderManager", this.m + " doFinish no concurrent");
        }
    }

    @Override // com.uploader.export.IUploaderManager
    public boolean initialize(@NonNull Context context, @NonNull IUploaderDependency iUploaderDependency) {
        if (context == null) {
            if (a.d(16)) {
                a.a(16, "UploaderManager", this.m + " initialize fail, context null");
            }
            return false;
        } else if (this.i) {
            if (a.d(4)) {
                a.a(4, "UploaderManager", this.m + " initialize, is initialized !");
            }
            return false;
        } else {
            synchronized (this.o) {
                if (this.i) {
                    if (a.d(4)) {
                        a.a(4, "UploaderManager", this.m + " initialize, is initialized !");
                    }
                    return false;
                } else if (this.p != iUploaderDependency.getEnvironment().getInstanceType()) {
                    if (a.d(16)) {
                        a.a(16, "UploaderManager", this.m + " initialize, FAILED! environment not equals instance in instanceType");
                    }
                    return false;
                } else {
                    this.n = new c(context, iUploaderDependency);
                    this.i = true;
                    if (a.d(4)) {
                        a.a(4, "UploaderManager", this.m + " initialize !!!");
                    }
                    return true;
                }
            }
        }
    }

    @Override // com.uploader.export.IUploaderManager
    public boolean isInitialized() {
        return this.i;
    }

    @Override // com.uploader.export.IUploaderManager
    public boolean uploadAsync(@NonNull IUploaderTask iUploaderTask, @NonNull ITaskListener iTaskListener, Handler handler) {
        if (iUploaderTask == null) {
            if (a.d(8)) {
                a.a(8, "UploaderManager", this.m + " uploadAsync fail,task null");
            }
            return false;
        }
        synchronized (this.o) {
            if (!this.i) {
                return false;
            }
            return g().post(new a(1, this, iUploaderTask, iTaskListener, handler));
        }
    }

    UploaderManager(int i2) {
        this.a = 0;
        this.i = false;
        this.o = new byte[0];
        this.d = new SparseArray<>(2);
        this.e = new ArrayList<>();
        this.c = new ArrayList<>();
        this.b = new ArrayList<>();
        this.m = hashCode();
        this.p = i2;
    }

    @Override // com.uploader.implement.a.d
    public void a(g gVar) {
        synchronized (this.o) {
            Handler handler = this.h;
            if (handler != null) {
                handler.post(new a(4, this, gVar));
            }
        }
    }
}

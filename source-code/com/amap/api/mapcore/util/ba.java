package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* compiled from: Taobao */
public class ba {
    public static String a = "";
    public static boolean b = false;
    public static String d = "";
    private static volatile ba k;
    List<az> c = new Vector();
    b e = null;
    public be f;
    bg g;
    bd h = null;
    private Context i;
    private boolean j = true;
    private a l;
    private bj m;
    private bp n;
    private ExecutorService o = null;
    private ExecutorService p = null;
    private ExecutorService q = null;
    private boolean r = true;

    /* compiled from: Taobao */
    public interface a {
        void a();

        void a(az azVar);

        void b(az azVar);

        void c(az azVar);
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            try {
                message.getData();
                Object obj = message.obj;
                if (obj instanceof az) {
                    az azVar = (az) obj;
                    bx.a("OfflineMapHandler handleMessage CitObj  name: " + azVar.getCity() + " complete: " + azVar.getcompleteCode() + " status: " + azVar.getState());
                    if (ba.this.l != null) {
                        ba.this.l.a(azVar);
                        return;
                    }
                    return;
                }
                bx.a("Do not callback by CityObject! ");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private ba(Context context) {
        this.i = context;
    }

    public static void f() {
        k = null;
        b = true;
    }

    private void h() {
        try {
            bk a2 = this.n.a("000001");
            if (a2 != null) {
                this.n.c("000001");
                a2.c("100000");
                this.n.a(a2);
            }
        } catch (Throwable th) {
            hd.c(th, "OfflineDownloadManager", "changeBadCase");
        }
    }

    private void i() {
        String str;
        if (!"".equals(eq.c(this.i))) {
            File file = new File(eq.c(this.i) + "offlinemapv4.png");
            if (!file.exists()) {
                str = bx.a(this.i, "offlinemapv4.png");
            } else {
                str = bx.c(file);
            }
            if (str != null) {
                try {
                    h(str);
                } catch (JSONException e2) {
                    if (file.exists()) {
                        file.delete();
                    }
                    hd.c(e2, "MapDownloadManager", "paseJson io");
                    e2.printStackTrace();
                }
            }
        }
    }

    private void j() {
        Iterator<bk> it = this.n.a().iterator();
        while (it.hasNext()) {
            bk next = it.next();
            if (!(next == null || next.d() == null || next.f().length() < 1)) {
                int i2 = next.l;
                if (!(i2 == 4 || i2 == 7 || i2 < 0)) {
                    next.l = 3;
                }
                az i3 = i(next.d());
                if (i3 != null) {
                    String e2 = next.e();
                    if (e2 == null || !a(d, e2)) {
                        i3.a(next.l);
                        i3.setCompleteCode(next.h());
                    } else {
                        i3.a(7);
                    }
                    if (next.e().length() > 0) {
                        i3.setVersion(next.e());
                    }
                    List<String> b2 = this.n.b(next.f());
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : b2) {
                        stringBuffer.append(str);
                        stringBuffer.append(";");
                    }
                    i3.a(stringBuffer.toString());
                    be beVar = this.f;
                    if (beVar != null) {
                        beVar.a(i3);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void k() throws AMapException {
        if (!eq.d(this.i)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    public void g() {
        synchronized (this) {
            this.l = null;
        }
    }

    /* access modifiers changed from: protected */
    public void b() throws AMapException {
        if (this.f != null) {
            bh bhVar = new bh(this.i, "");
            bhVar.a(this.i);
            List<OfflineMapProvince> list = (List) bhVar.c();
            if (this.c != null) {
                this.f.a(list);
            }
            List<az> list2 = this.c;
            if (list2 != null) {
                synchronized (list2) {
                    Iterator<OfflineMapProvince> it = this.f.a().iterator();
                    while (it.hasNext()) {
                        Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                        while (it2.hasNext()) {
                            OfflineMapCity next = it2.next();
                            for (az azVar : this.c) {
                                if (next.getPinyin().equals(azVar.getPinyin())) {
                                    String version = azVar.getVersion();
                                    if (azVar.getState() != 4 || d.length() <= 0 || !a(d, version)) {
                                        azVar.setCity(next.getCity());
                                        azVar.setUrl(next.getUrl());
                                        azVar.t();
                                        azVar.setAdcode(next.getAdcode());
                                        azVar.setVersion(next.getVersion());
                                        azVar.setSize(next.getSize());
                                        azVar.setCode(next.getCode());
                                        azVar.setJianpin(next.getJianpin());
                                        azVar.setPinyin(next.getPinyin());
                                    } else {
                                        azVar.j();
                                        azVar.setUrl(next.getUrl());
                                        azVar.t();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void c(String str) {
        az i2 = i(str);
        if (i2 == null) {
            a aVar = this.l;
            if (aVar != null) {
                try {
                    aVar.c(i2);
                } catch (Throwable th) {
                    hd.c(th, "OfflineDownloadManager", "remove");
                }
            }
        } else {
            d(i2);
            a(i2, true);
        }
    }

    public void d() {
        synchronized (this.c) {
            Iterator<az> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                az next = it.next();
                if (next.c().equals(next.c)) {
                    next.g();
                    break;
                }
            }
        }
    }

    public void e() {
        ExecutorService executorService = this.o;
        if (executorService != null && !executorService.isShutdown()) {
            this.o.shutdownNow();
        }
        ExecutorService executorService2 = this.q;
        if (executorService2 != null && !executorService2.isShutdown()) {
            this.q.shutdownNow();
        }
        bd bdVar = this.h;
        if (bdVar != null) {
            if (bdVar.isAlive()) {
                this.h.interrupt();
            }
            this.h = null;
        }
        b bVar = this.e;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
            this.e = null;
        }
        bj bjVar = this.m;
        if (bjVar != null) {
            bjVar.b();
        }
        be beVar = this.f;
        if (beVar != null) {
            beVar.g();
        }
        f();
        this.j = true;
        g();
    }

    private void f(final az azVar) throws AMapException {
        k();
        if (azVar != null) {
            if (this.q == null) {
                long j2 = (long) 1;
                this.q = new ThreadPoolExecutor(1, 2, j2, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ed("AMapOfflineDownload"), new ThreadPoolExecutor.AbortPolicy());
            }
            try {
                this.q.execute(new Runnable() {
                    /* class com.amap.api.mapcore.util.ba.AnonymousClass3 */

                    public void run() {
                        try {
                            if (ba.this.j) {
                                ba.this.k();
                                bb bbVar = (bb) new bc(ba.this.i, ba.d).c();
                                if (bbVar != null) {
                                    ba.this.j = false;
                                    if (bbVar.a()) {
                                        ba.this.b();
                                    }
                                }
                            }
                            azVar.setVersion(ba.d);
                            azVar.f();
                        } catch (AMapException e) {
                            e.printStackTrace();
                        } catch (Throwable th) {
                            hd.c(th, "OfflineDownloadManager", "startDownloadRunnable");
                        }
                    }
                });
            } catch (Throwable th) {
                hd.c(th, "startDownload", "downloadExcecRunnable");
            }
        } else {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
    }

    public static void g(String str) {
        a = str;
    }

    public static ba a(Context context) {
        if (k == null) {
            synchronized (ba.class) {
                if (k == null && !b) {
                    k = new ba(context.getApplicationContext());
                }
            }
        }
        return k;
    }

    private void h(String str) throws JSONException {
        be beVar;
        List<OfflineMapProvince> a2 = bx.a(str, this.i.getApplicationContext());
        if (a2 != null && a2.size() != 0 && (beVar = this.f) != null) {
            beVar.a(a2);
        }
    }

    public void d(String str) throws AMapException {
        az i2 = i(str);
        if (str == null || str.length() < 1 || i2 == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        f(i2);
    }

    public void c(az azVar) {
        be beVar = this.f;
        if (beVar != null) {
            beVar.a(azVar);
        }
        b bVar = this.e;
        if (bVar != null) {
            Message obtainMessage = bVar.obtainMessage();
            obtainMessage.obj = azVar;
            this.e.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a  */
    private az i(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        synchronized (this.c) {
            for (az azVar : this.c) {
                if (str.equals(azVar.getCity()) || str.equals(azVar.getPinyin())) {
                    return azVar;
                }
                while (r2.hasNext()) {
                }
            }
            return null;
        }
    }

    public void d(az azVar) {
        bj bjVar = this.m;
        if (bjVar != null) {
            bjVar.a(azVar);
        }
    }

    public String f(String str) {
        az i2;
        if (str == null || (i2 = i(str)) == null) {
            return "";
        }
        return i2.getAdcode();
    }

    public void a() {
        this.n = bp.a(this.i.getApplicationContext());
        h();
        b bVar = new b(this.i.getMainLooper());
        this.e = bVar;
        this.f = new be(this.i, bVar);
        this.m = bj.a(1);
        g(eq.c(this.i));
        try {
            i();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this.c) {
            Iterator<OfflineMapProvince> it = this.f.a().iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    OfflineMapCity next = it2.next();
                    if (next != null) {
                        this.c.add(new az(this.i, next));
                    }
                }
            }
        }
        bd bdVar = new bd(this.i);
        this.h = bdVar;
        bdVar.start();
    }

    public void c() {
        synchronized (this.c) {
            for (az azVar : this.c) {
                if (azVar.c().equals(azVar.c) || azVar.c().equals(azVar.b)) {
                    d(azVar);
                    azVar.g();
                }
            }
        }
    }

    public void e(String str) throws AMapException {
        az j2 = j(str);
        if (j2 != null) {
            f(j2);
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    private az j(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        synchronized (this.c) {
            for (az azVar : this.c) {
                if (str.equals(azVar.getCode())) {
                    return azVar;
                }
            }
            return null;
        }
    }

    public void e(az azVar) {
        bj bjVar = this.m;
        if (bjVar != null) {
            bjVar.b(azVar);
        }
    }

    public boolean b(String str) {
        return i(str) != null;
    }

    public void a(ArrayList<bk> arrayList) {
        j();
        a aVar = this.l;
        if (aVar != null) {
            try {
                aVar.a();
            } catch (Throwable th) {
                hd.c(th, "OfflineDownloadManager", "verifyCallBack");
            }
        }
    }

    public void b(az azVar) {
        try {
            bj bjVar = this.m;
            if (bjVar != null) {
                bjVar.a(azVar, this.i, null);
            }
        } catch (gb e2) {
            e2.printStackTrace();
        }
    }

    public void a(final String str) {
        if (str == null) {
            try {
                a aVar = this.l;
                if (aVar != null) {
                    aVar.b(null);
                }
            } catch (Throwable th) {
                hd.c(th, "OfflineDownloadManager", "checkUpdate");
            }
        } else {
            if (this.o == null) {
                long j2 = (long) 1;
                this.o = new ThreadPoolExecutor(1, 2, j2, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ed("AMapOfflineCheckUpdate"), new ThreadPoolExecutor.AbortPolicy());
            }
            this.o.execute(new Runnable() {
                /* class com.amap.api.mapcore.util.ba.AnonymousClass1 */

                public void run() {
                    az i = ba.this.i(str);
                    if (i != null) {
                        try {
                            if (!i.c().equals(i.c)) {
                                if (!i.c().equals(i.e)) {
                                    String pinyin = i.getPinyin();
                                    if (pinyin.length() > 0) {
                                        String d = ba.this.n.d(pinyin);
                                        if (d == null) {
                                            d = i.getVersion();
                                        }
                                        if (ba.d.length() > 0 && d != null && ba.this.a((ba) ba.d, d)) {
                                            i.j();
                                        }
                                    }
                                }
                            }
                            if (ba.this.l != null) {
                                synchronized (ba.this) {
                                    try {
                                        ba.this.l.b(i);
                                    } catch (Throwable th) {
                                        hd.c(th, "OfflineDownloadManager", "checkUpdatefinally");
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            if (ba.this.l != null) {
                                synchronized (ba.this) {
                                    ba.this.l.b(i);
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            hd.c(th2, "OfflineDownloadManager", "checkUpdatefinally");
                        }
                    }
                    ba.this.k();
                    bb bbVar = (bb) new bc(ba.this.i, ba.d).c();
                    if (ba.this.l != null) {
                        if (bbVar == null) {
                            if (ba.this.l != null) {
                                synchronized (ba.this) {
                                    try {
                                        ba.this.l.b(i);
                                    } catch (Throwable th3) {
                                        hd.c(th3, "OfflineDownloadManager", "checkUpdatefinally");
                                    }
                                }
                                return;
                            }
                            return;
                        } else if (bbVar.a()) {
                            ba.this.b();
                        }
                    }
                    if (ba.this.l != null) {
                        synchronized (ba.this) {
                            try {
                                ba.this.l.b(i);
                            } catch (Throwable th4) {
                                hd.c(th4, "OfflineDownloadManager", "checkUpdatefinally");
                            }
                        }
                        return;
                    }
                    return;
                    throw th;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean a(String str, String str2) {
        for (int i2 = 0; i2 < str2.length(); i2++) {
            try {
                if (str.charAt(i2) > str2.charAt(i2)) {
                    return true;
                }
                if (str.charAt(i2) < str2.charAt(i2)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void a(az azVar) {
        a(azVar, false);
    }

    private void a(final az azVar, final boolean z) {
        if (this.g == null) {
            this.g = new bg(this.i);
        }
        if (this.p == null) {
            long j2 = (long) 1;
            this.p = new ThreadPoolExecutor(1, 2, j2, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ed("AMapOfflineRemove"), new ThreadPoolExecutor.AbortPolicy());
        }
        try {
            this.p.execute(new Runnable() {
                /* class com.amap.api.mapcore.util.ba.AnonymousClass2 */

                public void run() {
                    try {
                        if (!azVar.c().equals(azVar.a)) {
                            if (azVar.getState() != 7) {
                                if (azVar.getState() != -1) {
                                    ba.this.g.a(azVar);
                                    if (ba.this.l != null) {
                                        ba.this.l.c(azVar);
                                        return;
                                    }
                                    return;
                                }
                            }
                            ba.this.g.a(azVar);
                            if (z && ba.this.l != null) {
                                ba.this.l.c(azVar);
                            }
                        } else if (ba.this.l != null) {
                            ba.this.l.c(azVar);
                        }
                    } catch (Throwable th) {
                        hd.c(th, "requestDelete", "removeExcecRunnable");
                    }
                }
            });
        } catch (Throwable th) {
            hd.c(th, "requestDelete", "removeExcecRunnable");
        }
    }

    public void a(a aVar) {
        this.l = aVar;
    }
}

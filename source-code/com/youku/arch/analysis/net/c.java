package com.youku.arch.analysis.net;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.arch.ntk.a.e;
import com.youku.arch.probe.plugins.b;
import com.youku.arch.probe.plugins.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class c {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final double[] a = {1.0d, 0.8d, 0.64d, 0.51d, 0.41d, 0.32d, 0.26d, 0.21d, 0.17d, 0.14d, 0.11d, 0.09d, 0.07d, 0.06d, 0.05d};
    private volatile long b;
    private Context c;
    private volatile List<e> d;
    private volatile e e;
    private long f;

    /* compiled from: Taobao */
    private static class a {
        private static final c a = new c(null);
    }

    private c() {
        this.d = new ArrayList();
    }

    /* synthetic */ c(SmartEvaluator$1 smartEvaluator$1) {
        this();
    }

    public static c a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-339016233") ? (c) ipChange.ipc$dispatch("-339016233", new Object[0]) : a.a;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050 A[SYNTHETIC, Splitter:B:24:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    private void a(Context context, String str) {
        Throwable th;
        FileWriter fileWriter;
        IOException e2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-958240663")) {
            ipChange.ipc$dispatch("-958240663", new Object[]{this, context, str});
            return;
        }
        try {
            fileWriter = new FileWriter(new File(context.getFilesDir().getAbsolutePath(), "NetQuality.log"));
            try {
                fileWriter.write(str);
                try {
                    fileWriter.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (IOException e4) {
                e2 = e4;
                try {
                    e2.printStackTrace();
                    if (fileWriter == null) {
                        fileWriter.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            fileWriter = null;
            e2 = e6;
            e2.printStackTrace();
            if (fileWriter == null) {
            }
        } catch (Throwable th3) {
            fileWriter = null;
            th = th3;
            if (fileWriter != null) {
            }
            throw th;
        }
    }

    private void a(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-106466377")) {
            ipChange.ipc$dispatch("-106466377", new Object[]{this, aVar});
            return;
        }
        synchronized (this) {
            if (this.e != null) {
                if (aVar.f) {
                    if (aVar.a() == 1) {
                        this.e.c++;
                    }
                    if (aVar.a() != 0) {
                        this.e.b++;
                    }
                    if (aVar.e == 1) {
                        this.e.d++;
                    }
                } else {
                    if (aVar.a() == 1) {
                        this.e.f++;
                    }
                    if (aVar.a() != 0) {
                        this.e.e++;
                    }
                    if (aVar.e == 1) {
                        this.e.g++;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1426511943")) {
            ipChange.ipc$dispatch("1426511943", new Object[]{this});
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(this.c.getFilesDir().getAbsolutePath(), "NetQuality.log")));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                synchronized (this) {
                    this.d = JSON.parseArray(sb2, e.class);
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.f = d();
        synchronized (this) {
            Iterator<e> it = this.d.iterator();
            while (it.hasNext()) {
                e next = it.next();
                long j = this.f;
                long j2 = next.a;
                if (j - j2 > 2592000) {
                    it.remove();
                } else if (j == j2) {
                    this.e = next;
                }
            }
            if (this.e == null) {
                this.e = new e();
                this.e.a = this.f;
                this.d.add(this.e);
            }
        }
    }

    private long d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1426541722")) {
            return ((Long) ipChange.ipc$dispatch("1426541722", new Object[]{this})).longValue();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return currentTimeMillis - (currentTimeMillis % 86400);
    }

    public a b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686475704")) {
            return (a) ipChange.ipc$dispatch("686475704", new Object[]{this});
        }
        a aVar = new a();
        if (com.youku.arch.probe.plugins.c.b) {
            com.youku.arch.probe.plugins.c.a(b.c).a(com.youku.arch.probe.plugins.c.a(d.c).a(aVar));
            aVar.b();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.b > DateUtils.MILLIS_PER_MINUTE) {
                this.b = currentTimeMillis;
                a(aVar);
            }
            b.a().b();
        }
        AdapterForTLog.loge("speedtest", "NetQuality:" + aVar.toString());
        return aVar;
    }
}

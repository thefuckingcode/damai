package cn.damai.homepage.util;

import android.os.Handler;
import android.os.Message;
import cn.damai.commonbusiness.util.b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import tb.cu2;
import tb.g91;
import tb.rx0;

/* compiled from: Taobao */
public class ZipDownLoadManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnZipDownLoadListsner a;
    private String b;
    private String c;
    private Handler d = new a();

    /* compiled from: Taobao */
    public interface OnZipDownLoadListsner {
        void onFailure();

        void onSuccess(String str);
    }

    /* compiled from: Taobao */
    public class a extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-450196471")) {
                ipChange.ipc$dispatch("-450196471", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            if (ZipDownLoadManager.this.a == null) {
                return;
            }
            if (message.what == 1) {
                ZipDownLoadManager.this.a.onSuccess(ZipDownLoadManager.this.c);
            } else {
                ZipDownLoadManager.this.a.onFailure();
            }
        }
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1119003677")) {
            ipChange.ipc$dispatch("-1119003677", new Object[]{this});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        new Thread(new Runnable() {
            /* class cn.damai.homepage.util.ZipDownLoadManager.AnonymousClass2 */
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARNING: Removed duplicated region for block: B:35:0x00ab A[SYNTHETIC, Splitter:B:35:0x00ab] */
            public void run() {
                Throwable th;
                Exception e;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2004989559")) {
                    ipChange.ipc$dispatch("-2004989559", new Object[]{this});
                    return;
                }
                File file = null;
                try {
                    File file2 = new File(ZipDownLoadManager.this.c);
                    if (file2.exists()) {
                        cu2.b(file2, true);
                    }
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    File file3 = new File(file2, "temp.zip");
                    try {
                        URLConnection openConnection = new URL(ZipDownLoadManager.this.b).openConnection();
                        openConnection.setReadTimeout(10000);
                        b.a(openConnection.getInputStream(), file3);
                        b.e(file3, ZipDownLoadManager.this.c);
                        ZipDownLoadManager.this.d.sendEmptyMessage(1);
                        try {
                            if (file3.exists()) {
                                file3.delete();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        file = file3;
                        try {
                            g91.b("ZipDownLoadManager", e.getMessage());
                            ZipDownLoadManager.this.d.sendEmptyMessage(0);
                            rx0.e(ZipDownLoadManager.this.b, e.getMessage());
                            if (file != null && file.exists()) {
                                file.delete();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (file != null) {
                                try {
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        file = file3;
                        if (file != null) {
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    g91.b("ZipDownLoadManager", e.getMessage());
                    ZipDownLoadManager.this.d.sendEmptyMessage(0);
                    rx0.e(ZipDownLoadManager.this.b, e.getMessage());
                    if (file != null) {
                    }
                }
            }
        }).start();
        long currentTimeMillis2 = System.currentTimeMillis();
        g91.b("ZipDownLoadManager", "下载耗时：" + (currentTimeMillis2 - currentTimeMillis));
    }

    public ZipDownLoadManager e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2084366814")) {
            return (ZipDownLoadManager) ipChange.ipc$dispatch("2084366814", new Object[]{this});
        }
        i();
        return this;
    }

    public ZipDownLoadManager f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1474548805")) {
            return (ZipDownLoadManager) ipChange.ipc$dispatch("1474548805", new Object[]{this, str});
        }
        this.c = str;
        return this;
    }

    public ZipDownLoadManager g(OnZipDownLoadListsner onZipDownLoadListsner) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-959265642")) {
            return (ZipDownLoadManager) ipChange.ipc$dispatch("-959265642", new Object[]{this, onZipDownLoadListsner});
        }
        this.a = onZipDownLoadListsner;
        return this;
    }

    public ZipDownLoadManager h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1599003074")) {
            return (ZipDownLoadManager) ipChange.ipc$dispatch("1599003074", new Object[]{this, str});
        }
        this.b = str;
        return this;
    }
}

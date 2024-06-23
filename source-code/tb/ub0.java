package tb;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.downloader.adpater.BizPriManager;
import com.taobao.downloader.adpater.FileCacheManager;
import com.taobao.downloader.adpater.Monitor;
import com.taobao.downloader.adpater.impl.SimpleTaskManager;
import com.taobao.downloader.request.DownloadListener;
import com.taobao.downloader.wrapper.ListenerWrapper;
import com.uc.webview.export.extension.UCCore;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: Taobao */
public class ub0 {
    private static volatile ub0 b;
    private Class<?> a;

    private ub0() {
        try {
            Class<?> cls = Class.forName("com.taobao.downloader.TbDownloader");
            this.a = cls;
            Method declaredMethod = cls.getDeclaredMethod("initDownLoad", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cm.h == null) {
            cm.h = new db2();
        }
        if (cm.g == null) {
            cm.g = new SimpleTaskManager();
        }
        if (cm.f == null) {
            cm.f = new eb2();
        }
    }

    public static ub0 c() {
        if (b == null) {
            synchronized (ub0.class) {
                if (b == null) {
                    b = new ub0();
                }
            }
        }
        return b;
    }

    public static void e(Context context) {
        if (context == null) {
            m90.e("Downloader", UCCore.LEGACY_EVENT_INIT, "context is null");
            return;
        }
        cm.a = context.getApplicationContext();
    }

    public void a(int i) {
        cm.g.modifyTask(i, 2);
    }

    public int b(sb0 sb0, DownloadListener downloadListener) {
        FileCacheManager fileCacheManager;
        m90.c("Downloader", "download", "start download");
        if (!(sb0 == null || !TextUtils.isEmpty(sb0.b.f) || (fileCacheManager = cm.f) == null)) {
            sb0.b.f = fileCacheManager.getTmpCache();
        }
        if (sb0 == null || !sb0.a()) {
            if (downloadListener != null) {
                downloadListener.onFinish(false);
            }
            of1.a(Monitor.POINT_ADD, "paramerror", null, null);
            return -100;
        }
        BizPriManager bizPriManager = cm.e;
        if (bizPriManager != null) {
            io1 io1 = sb0.b;
            io1.b = bizPriManager.getPriBy(io1);
        }
        jj2 jj2 = new jj2();
        int a2 = nz0.a();
        jj2.b = a2;
        m90.c("Downloader", "download", "assign taskId", Integer.valueOf(a2));
        jj2.c = sb0.b;
        jj2.e = sb0.a;
        jj2.d = new ListenerWrapper(sb0, downloadListener);
        ArrayList arrayList = new ArrayList();
        for (u21 u21 : sb0.a) {
            lb2 lb2 = new lb2();
            lb2.e = u21;
            io1 io12 = sb0.b;
            lb2.f = io12;
            lb2.g = io12.f;
            arrayList.add(lb2);
        }
        cm.g.addTask(arrayList, jj2);
        return jj2.b;
    }

    public String d(String str, u21 u21) {
        return xh0.b(str, u21);
    }
}

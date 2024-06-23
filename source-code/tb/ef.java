package tb;

import com.taobao.android.dinamic.property.DAttrConstant;
import com.taobao.downloader.adpater.Monitor;
import com.taobao.downloader.request.DownloadListener;

/* compiled from: Taobao */
public class ef {
    private int a;
    private boolean b;
    private String c;
    private String d;
    private String e;
    private sb0 f;
    private DownloadListener g;

    public ef(String str, sb0 sb0, DownloadListener downloadListener) {
        this.e = str;
        this.f = sb0;
        this.g = downloadListener;
    }

    public void a(lb2 lb2) {
        if (lb2 != null) {
            try {
                boolean z = true;
                if (lb2.a) {
                    m90.c("Callback", "onDownloadFinish", "task", lb2);
                    this.g.onDownloadFinish(lb2.e.a, lb2.d);
                } else {
                    m90.c("Callback", "onDownloadError", "task", lb2);
                    this.g.onDownloadError(lb2.e.a, lb2.b, lb2.c);
                    this.b = true;
                    this.c = String.valueOf(lb2.b);
                    this.d = lb2.e.a;
                }
                int i = this.a + 1;
                this.a = i;
                if (i == this.f.a.size()) {
                    m90.c(DAttrConstant.VIEW_EVENT_FINISH, "task", lb2);
                    if (this.b) {
                        of1.a(Monitor.POINT_ALL_CALLBACK, lb2.f.n + this.e, this.c, this.d);
                    } else {
                        of1.b(Monitor.POINT_ALL_CALLBACK, lb2.f.n + this.e);
                    }
                    DownloadListener downloadListener = this.g;
                    if (this.b) {
                        z = false;
                    }
                    downloadListener.onFinish(z);
                }
            } catch (Throwable th) {
                m90.d("Callback", "on callback", th, new Object[0]);
            }
        }
    }
}

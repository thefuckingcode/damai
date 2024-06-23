package tb;

import cn.damai.h5container.DMH5Fragment;
import com.uc.webview.export.DownloadListener;

/* compiled from: Taobao */
public final /* synthetic */ class xq implements DownloadListener {
    public final /* synthetic */ DMH5Fragment a;

    public /* synthetic */ xq(DMH5Fragment dMH5Fragment) {
        this.a = dMH5Fragment;
    }

    @Override // com.uc.webview.export.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        DMH5Fragment.m30webViewSetting$lambda1(this.a, str, str2, str3, str4, j);
    }
}

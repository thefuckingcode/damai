package cn.damai.h5container;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.WebView;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class DMH5Fragment$createWebViewChromeClient$1 extends DmWebChromeClient {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ DMH5Fragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DMH5Fragment$createWebViewChromeClient$1(DMH5Fragment dMH5Fragment) {
        super(dMH5Fragment);
        this.this$0 = dMH5Fragment;
    }

    @Override // com.uc.webview.export.WebChromeClient
    public void onProgressChanged(@Nullable WebView webView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "91551815")) {
            ipChange.ipc$dispatch("91551815", new Object[]{this, webView, Integer.valueOf(i)});
            return;
        }
        super.onProgressChanged(webView, i);
        this.this$0.updateProgress(i);
    }
}

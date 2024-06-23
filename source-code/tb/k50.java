package tb;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.taobao.monitor.impl.data.AbsWebView;

/* compiled from: Taobao */
public class k50 extends AbsWebView {
    public static final k50 INSTANCE = new k50();
    private String e;

    private k50() {
    }

    @Override // com.taobao.monitor.impl.data.AbsWebView
    public int d(View view) {
        WebView webView = (WebView) view;
        String url = webView.getUrl();
        if (TextUtils.equals(this.e, url)) {
            return webView.getProgress();
        }
        this.e = url;
        return 0;
    }

    @Override // com.taobao.monitor.impl.data.IWebView
    public boolean isWebView(View view) {
        return view instanceof WebView;
    }
}

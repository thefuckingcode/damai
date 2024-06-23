package cn.damai.h5container;

import android.content.Context;
import android.util.AttributeSet;
import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taomai.android.h5container.webview.TaoMaiUCWebView;
import com.uc.webview.export.WebSettings;
import tb.cq2;
import tb.d20;
import tb.gq2;

/* compiled from: Taobao */
public class DamaiWebView extends TaoMaiUCWebView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context context;
    private JSBridge mJSBridge;

    public DamaiWebView(Context context2) {
        super(context2);
        this.context = context2;
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1082290940")) {
            ipChange.ipc$dispatch("-1082290940", new Object[]{this});
            return;
        }
        this.mJSBridge = new JSBridge(this.context, this);
        String q = AppConfig.q();
        WebSettings settings = getSettings();
        settings.setUserAgentString(getSettings().getUserAgentString() + " DamaiApp Android v" + q + " ," + gq2.USER_AGENT);
        addJavascriptInterface(this.mJSBridge, "JSBridge");
    }

    public JSBridge getJSBridge() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1762204169")) {
            return this.mJSBridge;
        }
        return (JSBridge) ipChange.ipc$dispatch("-1762204169", new Object[]{this});
    }

    @Override // com.uc.webview.export.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1366394112")) {
            ipChange.ipc$dispatch("1366394112", new Object[]{this, str, str2, str3, str4, str5});
            return;
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebView, com.uc.webview.export.WebView, com.taomai.android.h5container.webview.TaoMaiUCWebView, android.taobao.windvane.webview.IWVWebView
    public void loadUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-348862537")) {
            ipChange.ipc$dispatch("-348862537", new Object[]{this, str});
            return;
        }
        DamaiCookieManager.getInstance().setDamaiCookie(str, d20.q());
        super.loadUrl(cq2.a(str));
    }

    public DamaiWebView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
        init();
    }

    public DamaiWebView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        init();
    }
}

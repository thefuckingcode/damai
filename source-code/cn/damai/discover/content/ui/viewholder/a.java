package cn.damai.discover.content.ui.viewholder;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import cn.damai.discover.content.bean.ContentDetail;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.n42;
import tb.xf2;
import tb.xs0;
import tb.ym2;

/* compiled from: Taobao */
public class a extends ym2<ContentDetail> {
    private static transient /* synthetic */ IpChange $ipChange;
    private WebView d;

    public a(Context context) {
        super(context);
    }

    private void e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1184573254")) {
            ipChange.ipc$dispatch("1184573254", new Object[]{this, str});
        } else if (!xf2.j(str)) {
            this.d.loadData(f(str), "text/html; charset=UTF-8", null);
        }
    }

    private String f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586871284")) {
            return (String) ipChange.ipc$dispatch("-586871284", new Object[]{this, str});
        } else if (xf2.j(str)) {
            return null;
        } else {
            int a = n42.a(xs0.a(), 12.0f);
            int a2 = n42.a(xs0.a(), 15.0f);
            return "<html>\n<head>\n<style type=\"text/css\">\n\t* {\n\t\tmargin: 0;\n\t\tpadding: 0;\n\t}\n\tbody {\n\t\twidth: 100%;\n\t}\n\timg {\n\t\twidth: 100%;\n\t}\n\tp,div {\n\t\tfont-size: " + a2 + "px;\n\t\tline-height: " + 1.6d + ";\n\t}\n\t.imgbox {\n\t\tpadding: " + a + "px 0;\n\t}\n\t.root {\n\t\twidth: 100%;\n\t\tdisplay: flex;\n\t\tflex-direction: column;\n\t}\n</style>\n</head>\n<body>\n<div class=\"root\">" + str + "</div>\n\n</body>\n\n</html>";
        }
    }

    @Override // tb.ym2
    public int a() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1223770602")) {
            return R$layout.live_content_detail_hybrid;
        }
        return ((Integer) ipChange.ipc$dispatch("-1223770602", new Object[]{this})).intValue();
    }

    @Override // tb.ym2
    @RequiresApi(api = 11)
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1225261341")) {
            ipChange.ipc$dispatch("-1225261341", new Object[]{this});
            return;
        }
        WebView webView = (WebView) this.b.findViewById(R$id.live_content_detail_hybrid);
        this.d = webView;
        WebSettings settings = webView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        settings.setJavaScriptEnabled(false);
        settings.setGeolocationEnabled(false);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(false);
        settings.setAppCacheEnabled(true);
        settings.setAppCacheMaxSize(12582912);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setBlockNetworkImage(false);
        settings.setNeedInitialFocus(true);
        settings.setDefaultFontSize(15);
        settings.setCacheMode(-1);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        this.d.setOverScrollMode(0);
        this.d.setHorizontalScrollBarEnabled(false);
        this.d.setVerticalScrollBarEnabled(false);
    }

    public void d(ContentDetail contentDetail) {
        ContentDetail.RichText richText;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "680158562")) {
            ipChange.ipc$dispatch("680158562", new Object[]{this, contentDetail});
        } else if (contentDetail == null || (richText = contentDetail.richContent) == null || xf2.j(richText.value)) {
            c(false);
        } else if (this.d != null) {
            e(contentDetail.richContent.value);
            c(true);
        }
    }
}

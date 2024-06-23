package com.taomai.android.h5container.webview;

import android.content.Context;
import android.taobao.windvane.webview.WVWebView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.uc.webview.export.cyclone.update.UpdateService;
import com.uc.webview.export.extension.UCCore;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k21;
import tb.xi2;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B%\b\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B\u001d\b\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0011B\u0013\b\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0006\u0010\b\u001a\u00020\u0002¨\u0006\u0013"}, d2 = {"Lcom/taomai/android/h5container/webview/TaoMaiWebView;", "Landroid/taobao/windvane/webview/WVWebView;", "Ltb/ur2;", UCCore.LEGACY_EVENT_INIT, "", "url", "loadUrl", "onResume", "doDestory", "Landroid/content/Context;", UpdateService.OPTION_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class TaoMaiWebView extends WVWebView {
    public TaoMaiWebView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void doDestory() {
        setVisibility(8);
        WebSettings settings = getSettings();
        k21.h(settings, "settings");
        settings.setJavaScriptEnabled(false);
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        removeAllViews();
        try {
            destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void init() {
        if (xi2.a()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        WebSettings settings = getSettings();
        k21.h(settings, "settings");
        StringBuilder sb = new StringBuilder();
        WebSettings settings2 = getSettings();
        k21.h(settings2, "settings");
        sb.append(settings2.getUserAgentString());
        sb.append(xi2.b());
        settings.setUserAgentString(sb.toString());
    }

    @Override // android.taobao.windvane.webview.WVWebView, android.taobao.windvane.webview.IWVWebView
    public void loadUrl(@NotNull String str) {
        k21.i(str, "url");
        super.loadUrl(str);
    }

    @Override // android.taobao.windvane.webview.WVWebView
    public void onResume() {
        super.onResume();
    }

    public TaoMaiWebView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TaoMaiWebView(@Nullable Context context) {
        super(context);
        init();
    }
}

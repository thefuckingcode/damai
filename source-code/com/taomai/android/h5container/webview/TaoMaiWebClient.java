package com.taomai.android.h5container.webview;

import android.app.Activity;
import android.content.Context;
import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVWebViewClient;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import com.taomai.android.h5container.TaoMaiH5Container;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.text.o;
import org.jetbrains.annotations.Nullable;
import tb.yl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/taomai/android/h5container/webview/TaoMaiWebClient;", "Landroid/taobao/windvane/webview/WVWebViewClient;", "Landroid/webkit/WebView;", "view", "", "url", "", "shouldOverrideUrlLoading", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class TaoMaiWebClient extends WVWebViewClient {
    public TaoMaiWebClient(@Nullable Context context) {
        super(context);
    }

    @Override // android.taobao.windvane.webview.WVWebViewClient, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
        TaoMaiH5Container.NavHandler b;
        Context context = this.mContext;
        String str2 = null;
        if (!(context instanceof Activity)) {
            context = null;
        }
        Activity activity = (Activity) context;
        if (!(activity == null || str == null || (b = TaoMaiH5Container.b()) == null)) {
            Objects.requireNonNull(webView, "null cannot be cast to non-null type android.taobao.windvane.webview.IWVWebView");
            if (b.shouldOverrideUrlLoading(activity, str, (IWVWebView) webView)) {
                WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
                if (copyBackForwardList != null) {
                    if (copyBackForwardList.getSize() != 0 || activity.isFinishing()) {
                        yl.a aVar = yl.Companion;
                        WebHistoryItem currentItem = copyBackForwardList.getCurrentItem();
                        if (currentItem != null) {
                            str2 = currentItem.getUrl();
                        }
                        if (aVar.c(str2) && !activity.isFinishing()) {
                            activity.finish();
                        }
                    } else {
                        activity.finish();
                        return true;
                    }
                }
                return true;
            }
        }
        if (str != null && !(o.L(str, "http", false, 2, null))) {
            TaoMaiH5Container.NavHandler b2 = TaoMaiH5Container.b();
            if (b2 == null) {
                return false;
            }
            if (activity != null) {
                b2.handleUrl(activity, str, true);
                return true;
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}

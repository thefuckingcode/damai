package tb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.taobao.windvane.webview.IWVWebView;
import com.taomai.android.h5container.TaoMaiH5Container;
import com.uc.webview.export.WebBackForwardList;
import com.uc.webview.export.WebHistoryItem;
import com.uc.webview.export.WebView;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.yl;

/* compiled from: Taobao */
public class bj2 extends WVUCWebViewClient {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bj2(@NotNull Context context) {
        super(context);
        k21.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    @Override // com.uc.webview.export.WebViewClient, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
    }

    @Override // com.uc.webview.export.WebViewClient, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.uc.webview.export.WebViewClient, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
        TaoMaiH5Container.NavHandler b;
        WeakReference<Context> weakReference = this.mContext;
        String str2 = null;
        Context context = weakReference != null ? weakReference.get() : null;
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

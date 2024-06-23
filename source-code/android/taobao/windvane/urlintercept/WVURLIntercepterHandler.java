package android.taobao.windvane.urlintercept;

import android.content.Context;
import android.taobao.windvane.urlintercept.WVURLInterceptData;
import android.taobao.windvane.webview.IWVWebView;

/* compiled from: Taobao */
public interface WVURLIntercepterHandler {
    boolean doURLIntercept(Context context, IWVWebView iWVWebView, String str, WVURLInterceptData.URLInfo uRLInfo);
}

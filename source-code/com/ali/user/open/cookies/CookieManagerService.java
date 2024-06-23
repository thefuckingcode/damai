package com.ali.user.open.cookies;

import com.ali.user.open.core.WebViewProxy;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.webview.DefaultWebViewProxy;

/* compiled from: Taobao */
public class CookieManagerService {
    private CookieManagerService() {
    }

    public static WebViewProxy getWebViewProxy() {
        WebViewProxy webViewProxy = KernelContext.mWebViewProxy;
        if (webViewProxy != null) {
            return webViewProxy;
        }
        return DefaultWebViewProxy.getInstance();
    }
}

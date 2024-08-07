package tb;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.alibaba.ut.IWebView;
import com.alibaba.ut.TrackerWebView;

/* compiled from: Taobao */
public class hw2 {
    public static IWebView a(Activity activity) {
        TrackerWebView trackerWebView = (TrackerWebView) activity.getClass().getAnnotation(TrackerWebView.class);
        WebView webView = trackerWebView != null ? (WebView) activity.findViewById(trackerWebView.value()) : null;
        if (webView != null) {
            return new ph2(webView);
        }
        return c(activity.getWindow().getDecorView());
    }

    private static boolean b(Class cls) {
        if (cls == null || "android.view.View".equalsIgnoreCase(cls.getName()) || cls.getSuperclass() == null) {
            return false;
        }
        if ("com.uc.webview.export.WebView".equalsIgnoreCase(cls.getName())) {
            return true;
        }
        return b(cls.getSuperclass());
    }

    private static IWebView c(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof WebView) {
            return new ph2((WebView) view);
        }
        if (b(view.getClass())) {
            return new lp2((com.uc.webview.export.WebView) view);
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            IWebView c = c(viewGroup.getChildAt(i));
            if (c != null) {
                return c;
            }
        }
        return null;
    }
}

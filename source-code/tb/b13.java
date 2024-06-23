package tb;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: Taobao */
public class b13 {
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a A[SYNTHETIC, Splitter:B:26:0x005a] */
    public static String a(Context context, String str) {
        Throwable th;
        InputStream inputStream;
        String readLine;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            inputStream = context.getAssets().open(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                do {
                    readLine = bufferedReader.readLine();
                    if (readLine != null && !readLine.matches("^\\s*\\/\\/.*")) {
                        sb.append(readLine);
                        continue;
                    }
                } while (readLine != null);
                bufferedReader.close();
                inputStream.close();
                String sb2 = sb.toString();
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.d(th2.TAG, e.toString());
                }
                return sb2;
            } catch (Throwable th2) {
                th = th2;
                try {
                    Log.d(th2.TAG, th.toString());
                    return null;
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            Log.d(th2.TAG, e2.toString());
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            Log.d(th2.TAG, th.toString());
            return null;
        }
    }

    public static void b(WebView webView) {
        if (webView != null && !TextUtils.isEmpty("TBAppLinkJsBridge.js")) {
            String a = a(webView.getContext(), "TBAppLinkJsBridge.js");
            webView.loadUrl("javascript:" + a);
        }
    }

    public static void c(WebView webView, String str) {
        if (webView != null && !TextUtils.isEmpty(str)) {
            webView.loadUrl("javascript:" + str);
        }
    }

    public static void d(WebView webView) {
        try {
            c(webView, String.format("window.applinkInfo ={sdkVersion:\"%s\",system:\"%s\",device:\"%s\",taoVersion:\"%s\"};", th2.SDKVERSION, String.valueOf("ANDROID " + Build.VERSION.SDK_INT), String.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL()), z03.b(webView.getContext())));
        } catch (Throwable th) {
            Log.d(th2.TAG, th.toString());
        }
    }
}

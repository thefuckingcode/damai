package com.ali.user.mobile.webview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.uc.webview.export.WebView;

/* compiled from: Taobao */
public class HtmlActivity extends WebViewActivity {
    /* access modifiers changed from: protected */
    public void closeWebView() {
        runOnUiThread(new Runnable() {
            /* class com.ali.user.mobile.webview.HtmlActivity.AnonymousClass1 */

            public void run() {
                HtmlActivity.this.finish();
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.ali.user.mobile.webview.WebViewActivity, com.ali.user.mobile.base.ui.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    @Override // com.ali.user.mobile.webview.WebViewActivity
    @SuppressLint({"NewApi"})
    public boolean overrideUrlLoading(WebView webView, String str) {
        Uri parse = Uri.parse(str);
        if (parse == null || parse.getScheme().equals("http") || parse.getScheme().equals("https") || parse.getScheme().equals("file")) {
            return false;
        }
        try {
            startActivity(new Intent("android.intent.action.VIEW", parse));
            closeWebView();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}

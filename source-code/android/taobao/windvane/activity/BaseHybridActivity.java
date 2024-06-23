package android.taobao.windvane.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.util.WVConstants;
import android.taobao.windvane.webview.ParamsParcelable;
import android.taobao.windvane.webview.WVViewController;
import android.taobao.windvane.webview.WVWebView;
import android.webkit.WebView;

@Deprecated
/* compiled from: Taobao */
public abstract class BaseHybridActivity extends Activity implements Handler.Callback {
    protected Handler mHandler;
    protected WVViewController mViewController;
    protected WebView mWebView;
    protected byte[] postData = null;
    protected String url = null;

    public boolean handleMessage(Message message) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        WebView webView = this.mWebView;
        if (webView != null && (webView instanceof WVWebView)) {
            ((WVWebView) webView).onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.url = intent.getStringExtra("URL");
        this.postData = intent.getByteArrayExtra("DATA");
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        WVViewController wVViewController = new WVViewController(this);
        this.mViewController = wVViewController;
        wVViewController.init((ParamsParcelable) intent.getParcelableExtra(WVConstants.INTENT_EXTRA_PARAMS));
        this.mWebView = this.mViewController.getWebview();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.mViewController.destroy();
        this.mViewController = null;
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onPause();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.onResume();
        }
        super.onResume();
    }
}

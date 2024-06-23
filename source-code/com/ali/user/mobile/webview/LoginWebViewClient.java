package com.ali.user.mobile.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.security.biz.R;
import com.uc.webview.export.SslErrorHandler;
import com.uc.webview.export.WebView;
import java.lang.ref.WeakReference;
import java.util.Properties;

/* compiled from: Taobao */
public class LoginWebViewClient extends WVUCWebViewClient {
    protected boolean firstAlert = true;
    protected boolean proceed = false;
    protected WeakReference<Activity> reference;

    public LoginWebViewClient(Activity activity) {
        super(activity);
        this.reference = new WeakReference<>(activity);
    }

    @Override // com.uc.webview.export.WebViewClient, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
        TLogAdapter.e("WebViewActivity", "已忽略证书校验的错误！");
        Properties properties = new Properties();
        if (webView.getUrl() != null) {
            properties.setProperty("url", webView.getUrl());
        }
        UserTrackAdapter.sendUT("Event_ReceivedSslError", properties);
        Activity activity = this.reference.get();
        if (this.firstAlert) {
            String string = webView.getContext().getResources().getString(R.string.aliuser_ssl_error_title);
            String string2 = webView.getContext().getResources().getString(R.string.aliuser_ssl_error_info);
            String string3 = webView.getContext().getResources().getString(R.string.aliuser_confirm);
            AnonymousClass1 r6 = new DialogInterface.OnClickListener() {
                /* class com.ali.user.mobile.webview.LoginWebViewClient.AnonymousClass1 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.proceed();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    LoginWebViewClient.this.proceed = true;
                }
            };
            String string4 = webView.getContext().getResources().getString(R.string.aliuser_cancel);
            AnonymousClass2 r8 = new DialogInterface.OnClickListener() {
                /* class com.ali.user.mobile.webview.LoginWebViewClient.AnonymousClass2 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.cancel();
                    LoginWebViewClient.this.proceed = false;
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            };
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).alert(string, string2, string3, r6, string4, r8);
                this.firstAlert = false;
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
            builder.setPositiveButton(string3, r6);
            builder.setNeutralButton(string4, r8);
            try {
                AlertDialog create = builder.create();
                create.setTitle(string);
                create.setMessage(string2);
                create.show();
                this.firstAlert = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.proceed) {
            sslErrorHandler.proceed();
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    /* access modifiers changed from: protected */
    public boolean overrideUrlLoading(WebView webView, String str) {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b  */
    @Override // com.uc.webview.export.WebViewClient, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean z;
        if (this.reference.get() != null) {
            try {
                z = overrideUrlLoading(webView, str);
            } catch (Exception e) {
                TLogAdapter.e("WebViewActivity", "webview内跳转地址有问题" + str, e);
            }
            if (!z) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        z = false;
        if (!z) {
        }
    }
}

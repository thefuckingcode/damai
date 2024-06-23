package com.ali.user.open.core.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ali.user.open.core.util.DialogHelper;

/* compiled from: Taobao */
public class BaseWebViewClient extends WebViewClient {
    protected boolean firstAlert = true;
    protected boolean proceed = false;

    public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.firstAlert) {
            AnonymousClass1 r7 = new DialogInterface.OnClickListener() {
                /* class com.ali.user.open.core.webview.BaseWebViewClient.AnonymousClass1 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.proceed();
                    BaseWebViewClient.this.proceed = true;
                }
            };
            AnonymousClass2 r9 = new DialogInterface.OnClickListener() {
                /* class com.ali.user.open.core.webview.BaseWebViewClient.AnonymousClass2 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.cancel();
                    BaseWebViewClient.this.proceed = false;
                }
            };
            if (webView.getContext() instanceof Activity) {
                DialogHelper.getInstance().alert((Activity) webView.getContext(), "SSL证书错误", "您的连接不是安全连接，是否继续访问?", "确定", r7, "取消", r9);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
            builder.setPositiveButton("确定", r7);
            builder.setNeutralButton("取消", r9);
            try {
                AlertDialog create = builder.create();
                create.setTitle("SSL证书错误");
                create.setMessage("您的连接不是安全连接，是否继续访问?");
                create.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.proceed) {
            sslErrorHandler.proceed();
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }
}

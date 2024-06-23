package com.taomai.android.h5container.webview;

import android.content.Context;
import android.net.Uri;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.WVWebChromeClient;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.m40;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J2\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J0\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b¨\u0006\u0013"}, d2 = {"Lcom/taomai/android/h5container/webview/TaoMaiWebChromeClient;", "Landroid/taobao/windvane/webview/WVWebChromeClient;", "Landroid/webkit/WebView;", "webView", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "filePathCallback", "Landroid/webkit/WebChromeClient$FileChooserParams;", "fileChooserParams", "", "onShowFileChooser", "handleOnShowFileChooser", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "Companion", "a", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public class TaoMaiWebChromeClient extends WVWebChromeClient {
    @NotNull
    public static final a Companion = new a(null);
    public static final int FILE_CHOOSER_REQUEST_CODE = 15;

    /* compiled from: Taobao */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(m40 m40) {
            this();
        }
    }

    public TaoMaiWebChromeClient(@Nullable Context context) {
        super(context);
    }

    public final boolean handleOnShowFileChooser(@Nullable WebView webView, @Nullable ValueCallback<Uri[]> valueCallback, @Nullable WebChromeClient.FileChooserParams fileChooserParams) {
        if (fileChooserParams == null || valueCallback == null) {
            return false;
        }
        try {
            PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new TaoMaiWebChromeClient$handleOnShowFileChooser$1(fileChooserParams, webView)).setTaskOnPermissionDenied(new TaoMaiWebChromeClient$handleOnShowFileChooser$2(valueCallback)).execute();
            return true;
        } catch (Throwable th) {
            TaoLog.e("TaoMaiWebChromeClient", th.getMessage());
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(@Nullable WebView webView, @Nullable ValueCallback<Uri[]> valueCallback, @Nullable WebChromeClient.FileChooserParams fileChooserParams) {
        return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }
}

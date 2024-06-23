package android.taobao.windvane.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;

/* compiled from: Taobao */
public class WVWebChromeClient extends WebChromeClient {
    private static final long MAX_QUOTA = 20971520;
    private static final String TAG = "WVWebChromeClient";
    public WebChromeClient extraWebChromeClient = null;
    protected Context mContext;
    public IWVWebView mWebView = null;

    /* renamed from: android.taobao.windvane.webview.WVWebChromeClient$1  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$webkit$ConsoleMessage$MessageLevel;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel = iArr;
            iArr[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 1;
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 2;
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 3;
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.LOG.ordinal()] = 4;
            $SwitchMap$android$webkit$ConsoleMessage$MessageLevel[ConsoleMessage.MessageLevel.TIP.ordinal()] = 5;
        }
    }

    public WVWebChromeClient() {
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (WVEventService.getInstance().onEvent(2001).isSuccess) {
            return true;
        }
        String message = consoleMessage.message();
        if (!TextUtils.isEmpty(message) && message.startsWith("hybrid://")) {
            TaoLog.e(TAG, "Call from console.log");
            if (this.mWebView != null) {
                WVJsBridge.getInstance().callMethod(this.mWebView, message);
                return true;
            }
        }
        if (message == null || !message.startsWith("wvNativeCallback")) {
            if (TaoLog.getLogStatus()) {
                int i = AnonymousClass1.$SwitchMap$android$webkit$ConsoleMessage$MessageLevel[consoleMessage.messageLevel().ordinal()];
                if (i == 1) {
                    TaoLog.d(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
                } else if (i == 2) {
                    TaoLog.e(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
                } else if (i != 3) {
                    TaoLog.d(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
                } else {
                    TaoLog.w(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
                }
            }
            WebChromeClient webChromeClient = this.extraWebChromeClient;
            if (webChromeClient != null) {
                return webChromeClient.onConsoleMessage(consoleMessage);
            }
            return super.onConsoleMessage(consoleMessage);
        }
        String substring = message.substring(message.indexOf("/") + 1);
        int indexOf = substring.indexOf("/");
        String substring2 = substring.substring(0, indexOf);
        String substring3 = substring.substring(indexOf + 1);
        ValueCallback<String> nativeCallback = WVNativeCallbackUtil.getNativeCallback(substring2);
        if (nativeCallback != null) {
            nativeCallback.onReceiveValue(substring3);
            WVNativeCallbackUtil.clearNativeCallback(substring2);
        } else {
            TaoLog.e(TAG, "NativeCallback failed: " + substring3);
        }
        return true;
    }

    @TargetApi(5)
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        if (j2 < MAX_QUOTA) {
            quotaUpdater.updateQuota(j2);
        } else {
            quotaUpdater.updateQuota(j);
        }
    }

    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(str, callback);
        callback.invoke(str, true, false);
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (TaoLog.getLogStatus()) {
            TaoLog.i(TAG, "onJsPrompt: %s; defaultValue: %s; url: %s", str2, str3, str);
        }
        if (webView instanceof IWVWebView) {
            if (WVEventService.getInstance().onEvent(2003, (IWVWebView) webView, str, str2, str3, jsPromptResult).isSuccess) {
                return true;
            }
        }
        if (str3 == null || !str3.equals("wv_hybrid:")) {
            WebChromeClient webChromeClient = this.extraWebChromeClient;
            if (webChromeClient != null) {
                return webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return false;
        }
        TaoLog.e(TAG, "Call from console.prompt");
        WVJsBridge.getInstance().callMethod((WVWebView) webView, str2);
        jsPromptResult.confirm("");
        return true;
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
    }

    public WVWebChromeClient(Context context) {
        this.mContext = context;
    }
}

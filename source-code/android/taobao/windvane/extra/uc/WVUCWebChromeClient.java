package android.taobao.windvane.extra.uc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.util.WVContextUtil;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.taobao.windvane.util.WVUrlUtil;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.widget.EditText;
import com.taobao.weex.ui.module.WXModalUIModule;
import com.uc.webview.export.GeolocationPermissions;
import com.uc.webview.export.JsPromptResult;
import com.uc.webview.export.JsResult;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebView;

/* compiled from: Taobao */
public class WVUCWebChromeClient extends WebChromeClient {
    public static final int FilePathCallbackID = 15;
    private static final String KEY_CANCEL = (EnvUtil.isCN() ? "取消" : WXModalUIModule.CANCEL);
    private static final String KEY_CONFIRM = (EnvUtil.isCN() ? "确定" : WXModalUIModule.OK);
    private static final String KEY_FROM = (EnvUtil.isCN() ? "来自于：" : "From: ");
    private static final String TAG = "WVUCWebChromeClient";
    protected Context mContext;
    public ValueCallback<Uri[]> mFilePathCallback = null;
    public IWVWebView mWebView = null;

    /* renamed from: android.taobao.windvane.extra.uc.WVUCWebChromeClient$13  reason: invalid class name */
    /* compiled from: Taobao */
    static /* synthetic */ class AnonymousClass13 {
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

    public WVUCWebChromeClient() {
    }

    @Override // com.uc.webview.export.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (WVEventService.getInstance().onEvent(2001).isSuccess) {
            return true;
        }
        String message = consoleMessage.message();
        if (message != null) {
            if (!TextUtils.isEmpty(message) && message.startsWith("hybrid://")) {
                TaoLog.d(TAG, "Call from console.log");
                if (this.mWebView != null) {
                    WVJsBridge.getInstance().callMethod(this.mWebView, message);
                    return true;
                }
            }
            if (message.startsWith("wvNativeCallback")) {
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
        }
        if (TaoLog.getLogStatus()) {
            int i = AnonymousClass13.$SwitchMap$android$webkit$ConsoleMessage$MessageLevel[consoleMessage.messageLevel().ordinal()];
            if (i == 1) {
                TaoLog.d(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
            } else if (i == 2) {
                TaoLog.e(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
                IWVWebView iWVWebView = this.mWebView;
                if (iWVWebView != null) {
                    ((WVUCWebView) iWVWebView).wvErrorManager.reportJSError(consoleMessage);
                    ((WVUCWebView) this.mWebView).pageTracker.onPageReceivedJSError();
                }
            } else if (i != 3) {
                TaoLog.d(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
            } else {
                TaoLog.w(TAG, "onConsoleMessage: %s at %s: %s", consoleMessage.message(), consoleMessage.sourceId(), String.valueOf(consoleMessage.lineNumber()));
            }
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // com.uc.webview.export.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, false);
        super.onGeolocationPermissionsShowPrompt(str, callback);
    }

    @Override // com.uc.webview.export.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
        if (webView.isDestroied()) {
            TaoLog.e(TAG, "cannot call [onJsAlert], for webview has been destroyed");
            return true;
        }
        Context realContext = WVContextUtil.getRealContext(webView.getContext());
        if (!(realContext instanceof Activity) || !((Activity) realContext).isFinishing()) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(realContext);
                String host = Uri.parse(str).getHost();
                builder.setTitle(KEY_FROM + host).setMessage(str2).setPositiveButton(KEY_CONFIRM, new DialogInterface.OnClickListener() {
                    /* class android.taobao.windvane.extra.uc.WVUCWebChromeClient.AnonymousClass5 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.confirm();
                    }
                });
                builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    /* class android.taobao.windvane.extra.uc.WVUCWebChromeClient.AnonymousClass6 */

                    public void onCancel(DialogInterface dialogInterface) {
                        jsResult.cancel();
                    }
                });
                AlertDialog create = builder.create();
                create.setCanceledOnTouchOutside(false);
                create.show();
            } catch (Throwable th) {
                TaoLog.e(TAG, th.getMessage());
                jsResult.confirm();
            }
            return true;
        }
        jsResult.confirm();
        return true;
    }

    @Override // com.uc.webview.export.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
        if (webView.isDestroied()) {
            TaoLog.e(TAG, "cannot call [onJsConfirm], for webview has been destroyed");
            return true;
        }
        Context realContext = WVContextUtil.getRealContext(webView.getContext());
        if (!(realContext instanceof Activity) || !((Activity) realContext).isFinishing()) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(realContext);
                String host = Uri.parse(str).getHost();
                builder.setTitle(KEY_FROM + host).setMessage(str2).setPositiveButton(KEY_CONFIRM, new DialogInterface.OnClickListener() {
                    /* class android.taobao.windvane.extra.uc.WVUCWebChromeClient.AnonymousClass8 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.confirm();
                    }
                }).setNeutralButton(KEY_CANCEL, new DialogInterface.OnClickListener() {
                    /* class android.taobao.windvane.extra.uc.WVUCWebChromeClient.AnonymousClass7 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsResult.cancel();
                    }
                });
                builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    /* class android.taobao.windvane.extra.uc.WVUCWebChromeClient.AnonymousClass9 */

                    public void onCancel(DialogInterface dialogInterface) {
                        jsResult.cancel();
                    }
                });
                AlertDialog create = builder.create();
                create.setCanceledOnTouchOutside(false);
                create.show();
            } catch (Throwable th) {
                TaoLog.e(TAG, th.getMessage());
                jsResult.confirm();
            }
            return true;
        }
        jsResult.confirm();
        return true;
    }

    @Override // com.uc.webview.export.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
        if (webView.isDestroied()) {
            TaoLog.e(TAG, "cannot call [onJsPrompt], for webview has been destroyed");
            return true;
        }
        Context realContext = WVContextUtil.getRealContext(webView.getContext());
        if ((realContext instanceof Activity) && ((Activity) realContext).isFinishing()) {
            jsPromptResult.confirm();
            return true;
        } else if (str3 == null || !str3.equals("wv_hybrid:")) {
            try {
                EditText editText = new EditText(realContext);
                editText.setText(str3);
                String host = Uri.parse(str).getHost();
                AlertDialog.Builder builder = new AlertDialog.Builder(realContext);
                AlertDialog create = builder.setTitle(KEY_FROM + host).setView(editText).setMessage(str2).setPositiveButton(KEY_CONFIRM, new DialogInterface.OnClickListener() {
                    /* class android.taobao.windvane.extra.uc.WVUCWebChromeClient.AnonymousClass12 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsPromptResult.confirm();
                    }
                }).setNegativeButton(KEY_CANCEL, new DialogInterface.OnClickListener() {
                    /* class android.taobao.windvane.extra.uc.WVUCWebChromeClient.AnonymousClass11 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        jsPromptResult.cancel();
                    }
                }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                    /* class android.taobao.windvane.extra.uc.WVUCWebChromeClient.AnonymousClass10 */

                    public void onCancel(DialogInterface dialogInterface) {
                        jsPromptResult.cancel();
                    }
                }).create();
                create.setCanceledOnTouchOutside(false);
                create.show();
            } catch (Throwable th) {
                TaoLog.e(TAG, th.getMessage());
                jsPromptResult.confirm();
            }
            return true;
        } else {
            WVJsBridge.getInstance().callMethod((IWVWebView) webView, str2);
            jsPromptResult.confirm("");
            return true;
        }
    }

    @Override // com.uc.webview.export.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        if (!WVUrlUtil.isCommonUrl(str)) {
            super.onReceivedTitle(webView, str);
            return;
        }
        TaoLog.i(TAG, "ignore default title : " + str);
    }

    @Override // com.uc.webview.export.WebChromeClient
    public boolean onShowFileChooser(final WebView webView, final ValueCallback<Uri[]> valueCallback, final WebChromeClient.FileChooserParams fileChooserParams) {
        TaoLog.d(TAG, " onShowFileChooser");
        if (!(fileChooserParams == null || valueCallback == null)) {
            this.mFilePathCallback = valueCallback;
            try {
                PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() {
                    /* class android.taobao.windvane.extra.uc.WVUCWebChromeClient.AnonymousClass4 */

                    public void run() {
                        TaoLog.d(WVUCWebChromeClient.TAG, " onShowFileChooser permission granted");
                        Intent createIntent = fileChooserParams.createIntent();
                        Context realContext = WVContextUtil.getRealContext(webView.getContext());
                        if (realContext instanceof Activity) {
                            ((Activity) realContext).startActivityForResult(Intent.createChooser(createIntent, "choose"), 15);
                        }
                    }
                }).setTaskOnPermissionDenied(new Runnable() {
                    /* class android.taobao.windvane.extra.uc.WVUCWebChromeClient.AnonymousClass3 */

                    public void run() {
                        TaoLog.d(WVUCWebChromeClient.TAG, " onShowFileChooser permission denied");
                        valueCallback.onReceiveValue(null);
                    }
                }).execute();
                return true;
            } catch (Throwable th) {
                TaoLog.e(TAG, th.getMessage());
                th.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.uc.webview.export.WebChromeClient
    public void openFileChooser(final ValueCallback<Uri> valueCallback) {
        TaoLog.d(TAG, " openFileChooser");
        if (this.mWebView == null) {
            TaoLog.e(TAG, "context is null");
        } else if (WVContextUtil.getRealContext(this.mContext) instanceof Application) {
            TaoLog.e(TAG, "context can not be application");
        } else {
            try {
                PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}).setTaskOnPermissionGranted(new Runnable() {
                    /* class android.taobao.windvane.extra.uc.WVUCWebChromeClient.AnonymousClass2 */

                    public void run() {
                        TaoLog.d(WVUCWebChromeClient.TAG, " openFileChooser permission granted");
                        WVUCWebChromeClient.super.openFileChooser(valueCallback);
                    }
                }).setTaskOnPermissionDenied(new Runnable() {
                    /* class android.taobao.windvane.extra.uc.WVUCWebChromeClient.AnonymousClass1 */

                    public void run() {
                        TaoLog.d(WVUCWebChromeClient.TAG, " openFileChooser permission denied");
                    }
                }).execute();
            } catch (Exception e) {
                TaoLog.e(TAG, e.getMessage());
            }
        }
    }

    public WVUCWebChromeClient(Context context) {
        this.mContext = context;
    }
}

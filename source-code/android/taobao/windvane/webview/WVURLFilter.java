package android.taobao.windvane.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.taobao.windvane.config.WVUrlMatchUtils;
import android.taobao.windvane.util.TaoLog;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import tb.ke1;

/* compiled from: Taobao */
public class WVURLFilter {
    private static final String TAG = "WVURLFilter";

    public static boolean doFilter(final String str, final Context context, final IWVWebView iWVWebView) {
        if (!iWVWebView.canUseGlobalUrlConfig() && !iWVWebView.canUseUrlConfig()) {
            return false;
        }
        if (WVUrlMatchUtils.getInstance().isAllowAllOpen(str)) {
            iWVWebView.setAllowAllOpen(true);
            return false;
        } else if (iWVWebView.allowAllOpen()) {
            return false;
        } else {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            if (!WVUrlMatchUtils.getInstance().isBrowserOpen(str)) {
                TaoLog.d(TAG, "doFilter() called with: url = [" + str + "] allow");
                return false;
            } else if (!(context instanceof Activity)) {
                return false;
            } else {
                Intent intent = new Intent("NON_WHITELIST_URL_VISIT");
                intent.putExtra("url", str);
                intent.putExtra("whitelistAvailable", 1);
                intent.putExtra("from", "windvane");
                if (context != null) {
                    LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(intent);
                }
                AlertDialog.Builder title = new AlertDialog.Builder(context).setTitle(PurchaseConstants.NORMAL_WARNING_TITLE);
                title.setMessage("下个页面不受我们控制哦，使用时请注意安全" + scheme + ke1.SCHEME_SLASH + host).setPositiveButton("浏览器打开", new DialogInterface.OnClickListener() {
                    /* class android.taobao.windvane.webview.WVURLFilter.AnonymousClass2 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            if (iWVWebView.getPageLoadedCount() <= 0) {
                                iWVWebView.back();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    /* class android.taobao.windvane.webview.WVURLFilter.AnonymousClass1 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (iWVWebView.getPageLoadedCount() > 0) {
                            iWVWebView.refresh();
                            return;
                        }
                        Context context = context;
                        if (context instanceof Activity) {
                            ((Activity) context).finish();
                        }
                    }
                }).setCancelable(false).create().show();
                StringBuilder sb = new StringBuilder();
                sb.append("doFilter() called with: url = [");
                sb.append(str);
                sb.append("] block");
                TaoLog.d(TAG, sb.toString());
                return true;
            }
        }
    }
}

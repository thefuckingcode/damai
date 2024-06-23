package mtopsdk.extra.antiattack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ali.user.mobile.utils.UTConstans;
import com.uc.webview.export.WebView;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: Taobao */
public class CheckCodeValidateActivity extends Activity {
    private static final String HTTP_REFER_KEY = "http_referer=";
    private static final String NATIVE_FLAG = "native=1";
    private static final String RESULT_BROADCAST_ACTION = "mtopsdk.extra.antiattack.result.notify.action";
    private static final String TAG = "mtopsdk.CheckActivity";
    private static final String TMD_NC_FLAG = "tmd_nc=1";
    String httpReferValue = "";
    WVUCWebView webView = null;

    private String dealWithLocationUrl(String str) throws MalformedURLException {
        String query = new URL(str).getQuery();
        StringBuilder sb = new StringBuilder(32);
        if (!TextUtils.isEmpty(query)) {
            String str2 = null;
            String[] split = query.split("&");
            for (String str3 : split) {
                if (str3.startsWith(HTTP_REFER_KEY)) {
                    this.httpReferValue = str3.substring(13);
                    str2 = str3;
                } else if (!str3.equalsIgnoreCase(NATIVE_FLAG)) {
                    sb.append(str3);
                    sb.append("&");
                }
            }
            sb.append(TMD_NC_FLAG);
            if (str2 != null) {
                sb.append("&");
                sb.append(str2);
            }
            return str.replace(query, sb.toString());
        }
        sb.append(str);
        if (!str.endsWith("?")) {
            sb.append("?");
        }
        sb.append(TMD_NC_FLAG);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void sendResult(String str) {
        LogTool.print(16, TAG, "sendResult: " + str, null);
        Intent intent = new Intent(RESULT_BROADCAST_ACTION);
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra(UTConstans.CustomEvent.UT_REG_RESULT, str);
        sendBroadcast(intent);
    }

    public void onBackPressed() {
        super.onBackPressed();
        sendResult("cancel");
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            setContentView(linearLayout);
            WVUCWebView wVUCWebView = new WVUCWebView(this);
            this.webView = wVUCWebView;
            linearLayout.addView(wVUCWebView, new ViewGroup.LayoutParams(-1, -1));
            this.webView.setWebViewClient(new WVUCWebViewClient(this) {
                /* class mtopsdk.extra.antiattack.CheckCodeValidateActivity.AnonymousClass1 */

                @Override // com.uc.webview.export.WebViewClient, android.taobao.windvane.extra.uc.WVUCWebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase(CheckCodeValidateActivity.this.httpReferValue)) {
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                    CheckCodeValidateActivity.this.sendResult("success");
                    CheckCodeValidateActivity.this.finish();
                    return true;
                }
            });
            String stringExtra = getIntent().getStringExtra("Location");
            LogTool.print(16, TAG, "origin load url. " + stringExtra, null);
            String dealWithLocationUrl = dealWithLocationUrl(stringExtra);
            LogTool.print(16, TAG, "load url. " + dealWithLocationUrl, null);
            this.webView.loadUrl(dealWithLocationUrl);
        } catch (Exception e) {
            LogTool.print(16, TAG, "onCreate failed.", e);
            sendResult("fail");
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        WVUCWebView wVUCWebView = this.webView;
        if (wVUCWebView != null) {
            try {
                wVUCWebView.setVisibility(8);
                this.webView.removeAllViews();
                this.webView.coreDestroy();
                this.webView = null;
            } catch (Exception e) {
                LogTool.print(16, TAG, "WVUCWebView onDestroy error.", e);
            }
        }
    }
}

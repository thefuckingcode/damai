package com.ali.user.open.core.webview;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebView;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.service.MemberExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
public class BridgeCallbackContext {
    public int requestId;
    public WebView webView;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void callback(String str) {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.getSettings().setSavePassword(false);
            this.webView.loadUrl(str);
        }
    }

    /* access modifiers changed from: private */
    public static String formatJsonString(String str) {
        return str.replace("\\", "\\\\");
    }

    public Activity getActivity() {
        return (Activity) this.webView.getContext();
    }

    public void onFailure(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            onFailure(jSONObject.toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void success(final String str) {
        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
            /* class com.ali.user.open.core.webview.BridgeCallbackContext.AnonymousClass1 */

            public void run() {
                String str;
                if (TextUtils.isEmpty(str)) {
                    str = String.format("javascript:window.HavanaBridge.onSuccess(%s);", Integer.valueOf(BridgeCallbackContext.this.requestId));
                } else {
                    str = String.format("javascript:window.HavanaBridge.onSuccess(%s,'%s');", Integer.valueOf(BridgeCallbackContext.this.requestId), BridgeCallbackContext.formatJsonString(str));
                }
                BridgeCallbackContext.this.callback(str);
            }
        });
    }

    public void onFailure(final String str) {
        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() {
            /* class com.ali.user.open.core.webview.BridgeCallbackContext.AnonymousClass2 */

            public void run() {
                String str;
                if (TextUtils.isEmpty(str)) {
                    str = String.format("javascript:window.HavanaBridge.onFailure(%s,'');", Integer.valueOf(BridgeCallbackContext.this.requestId));
                } else {
                    str = String.format("javascript:window.HavanaBridge.onFailure(%s,'%s');", Integer.valueOf(BridgeCallbackContext.this.requestId), BridgeCallbackContext.formatJsonString(str));
                }
                BridgeCallbackContext.this.callback(str);
            }
        });
    }
}

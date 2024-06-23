package com.alibaba.security.realidentity.jsbridge.a;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.common.d.b;
import com.alibaba.security.realidentity.activity.RPWebViewActivity;
import com.alibaba.security.realidentity.jsbridge.a;
import com.alibaba.security.realidentity.jsbridge.f;
import com.alibaba.security.realidentity.jsbridge.h;
import com.alibaba.security.realidentity.view.RPTopBar;
import org.json.JSONException;
import org.json.JSONObject;

@f(a = "setTitle,rpSetTitle")
/* compiled from: Taobao */
public class d extends a {
    private static boolean d() {
        return true;
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final String a() {
        return "setTitle";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean c() {
        return false;
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, h hVar) {
        try {
            final String string = new JSONObject(str).getString(a.e);
            Context context = this.ao;
            if (context == null || !(context instanceof RPWebViewActivity)) {
                a.b("SetTitleApi context is not RPWebViewActivity: " + this.ao);
                a(a.a(hVar, "context is not RPWebViewActivity"), false);
                return false;
            }
            ((RPWebViewActivity) context).runOnUiThread(new Runnable() {
                /* class com.alibaba.security.realidentity.jsbridge.a.d.AnonymousClass1 */

                public final void run() {
                    ((RPTopBar) ((RPWebViewActivity) d.this.ao).findViewById(R.id.topBar)).setTitle(string);
                }
            });
            hVar.b();
            a(new WVResult("success"), true);
            return true;
        } catch (JSONException e) {
            a.a("SetTitleApi json parse error", b.a(e));
            a.a(hVar);
            return false;
        }
    }
}

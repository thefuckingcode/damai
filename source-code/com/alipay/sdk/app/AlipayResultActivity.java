package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.l;
import com.taobao.weex.ui.module.WXModalUIModule;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: Taobao */
public class AlipayResultActivity extends Activity {
    public static final ConcurrentHashMap<String, a> a = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    public interface a {
        void a(int i, String str, String str2);
    }

    private void a(String str, Bundle bundle) {
        a remove = a.remove(str);
        if (remove == null) {
            finish();
            return;
        }
        try {
            remove.a(bundle.getInt("endCode"), bundle.getString(l.b), bundle.getString("result"));
        } finally {
            finish();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b9 A[ADDED_TO_REGION] */
    public void onCreate(Bundle bundle) {
        Throwable th;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            try {
                String stringExtra = intent.getStringExtra(Preloader.KEY_SESSION);
                Bundle bundleExtra = intent.getBundleExtra("result");
                String stringExtra2 = intent.getStringExtra("scene");
                com.alipay.sdk.m.s.a a2 = a.C0134a.a(stringExtra);
                if (a2 == null) {
                    finish();
                    return;
                }
                com.alipay.sdk.m.k.a.a(a2, b.l, "BSPSession", stringExtra + "|" + SystemClock.elapsedRealtime());
                if (TextUtils.equals("mqpSchemePay", stringExtra2)) {
                    a(stringExtra, bundleExtra);
                    return;
                }
                if ((TextUtils.isEmpty(stringExtra) || bundleExtra == null) && intent.getData() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(Base64.decode(intent.getData().getQuery(), 2), "UTF-8"));
                        JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                        stringExtra = jSONObject.getString(Preloader.KEY_SESSION);
                        com.alipay.sdk.m.k.a.a(a2, b.l, "BSPUriSession", stringExtra);
                        Bundle bundle2 = new Bundle();
                        try {
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                bundle2.putString(next, jSONObject2.getString(next));
                            }
                            bundleExtra = bundle2;
                        } catch (Throwable th2) {
                            th = th2;
                            bundleExtra = bundle2;
                            com.alipay.sdk.m.k.a.a(a2, b.l, "BSPResEx", th);
                            com.alipay.sdk.m.k.a.a(a2, b.l, b.s0, th);
                            if (!TextUtils.isEmpty(stringExtra)) {
                            }
                            com.alipay.sdk.m.k.a.b(this, a2, "", a2.d);
                            finish();
                            return;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        com.alipay.sdk.m.k.a.a(a2, b.l, "BSPResEx", th);
                        com.alipay.sdk.m.k.a.a(a2, b.l, b.s0, th);
                        if (!TextUtils.isEmpty(stringExtra)) {
                        }
                        com.alipay.sdk.m.k.a.b(this, a2, "", a2.d);
                        finish();
                        return;
                    }
                }
                if (!TextUtils.isEmpty(stringExtra) || bundleExtra == null) {
                    com.alipay.sdk.m.k.a.b(this, a2, "", a2.d);
                    finish();
                    return;
                }
                try {
                    com.alipay.sdk.m.k.a.a(a2, b.l, b.V, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.m.k.a.a(a2, b.l, b.W, bundleExtra.getInt("endCode", -1) + "|" + bundleExtra.getString(l.b, "-"));
                    OpenAuthTask.a(stringExtra, 9000, WXModalUIModule.OK, bundleExtra);
                } finally {
                    com.alipay.sdk.m.k.a.b(this, a2, "", a2.d);
                    finish();
                }
            } catch (Throwable th4) {
                com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) null, b.l, "BSPSerError", th4);
                com.alipay.sdk.m.k.a.a((com.alipay.sdk.m.s.a) null, b.l, b.r0, th4);
                finish();
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}

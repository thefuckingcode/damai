package com.taobao.android.ultron.common;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import tb.am2;
import tb.g6;
import tb.tr2;

/* compiled from: Taobao */
public class UltronSwitchActivity extends Activity {
    private boolean a() {
        Intent intent = getIntent();
        if (intent == null) {
            return true;
        }
        Uri data = intent.getData();
        if (!((am2.b(this, data)) && tr2.e(this, data)) || !g6.b(this, data)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a()) {
            Intent intent = new Intent();
            intent.setData(Uri.parse("http://m.taobao.com/index.htm"));
            intent.setAction("android.intent.action.VIEW");
            intent.setComponent(ComponentName.createRelative("com.taobao.taobao", "com.taobao.browser.BrowserActivity"));
            startActivity(intent);
            finish();
        }
    }
}

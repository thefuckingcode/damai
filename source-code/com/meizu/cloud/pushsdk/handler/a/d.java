package com.meizu.cloud.pushsdk.handler.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.a;
import com.meizu.cloud.pushsdk.notification.c;
import com.meizu.cloud.pushsdk.util.b;

/* compiled from: Taobao */
public class d extends a<String> {
    public d(Context context, a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 16;
    }

    /* access modifiers changed from: protected */
    public void a(String str, c cVar) {
        if (c() != null) {
            c().a(d(), str);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start RegisterMessageHandler match");
        return PushConstants.MZ_PUSH_ON_REGISTER_ACTION.equals(intent.getAction()) || (PushConstants.REGISTRATION_CALLBACK_INTENT.equals(intent.getAction()) && !TextUtils.isEmpty(intent.getStringExtra("registration_id")));
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public String c(Intent intent) {
        String stringExtra = intent.getStringExtra("registration_id");
        b.g(d(), stringExtra, d().getPackageName());
        b.a(d(), 0, d().getPackageName());
        return stringExtra;
    }
}

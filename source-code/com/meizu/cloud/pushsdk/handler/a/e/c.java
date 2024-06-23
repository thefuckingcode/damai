package com.meizu.cloud.pushsdk.handler.a.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.a.a;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.b;

/* compiled from: Taobao */
public class c extends a<RegisterStatus> {
    public c(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void e() {
        String mzPushServicePackageName = MzSystemUtils.getMzPushServicePackageName(d());
        if (b.l(d(), mzPushServicePackageName)) {
            b.c(d(), mzPushServicePackageName, false);
            if (TextUtils.isEmpty(b.k(d(), mzPushServicePackageName))) {
                String b = b();
                if (!TextUtils.isEmpty(b)) {
                    b.k(d(), mzPushServicePackageName, b);
                }
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 512;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void c(RegisterStatus registerStatus) {
        com.meizu.cloud.pushsdk.b.c.a.a().execute(new Runnable() {
            /* class com.meizu.cloud.pushsdk.handler.a.e.c.AnonymousClass1 */

            public void run() {
                c.this.e();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(RegisterStatus registerStatus, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (c() != null && registerStatus != null) {
            c().a(d(), registerStatus);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start RegisterStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_REGISTER_STATUS.equals(k(intent));
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public RegisterStatus c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_MESSAGE_VALUE);
        RegisterStatus a = !TextUtils.isEmpty(stringExtra) ? com.meizu.cloud.pushsdk.platform.message.a.a(stringExtra) : (RegisterStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_REGISTER_STATUS);
        if (!TextUtils.isEmpty(a.getPushId())) {
            b.g(d(), a.getPushId(), d().getPackageName());
            b.a(d(), (int) ((System.currentTimeMillis() / 1000) + ((long) a.getExpireTime())), d().getPackageName());
        }
        return a;
    }
}

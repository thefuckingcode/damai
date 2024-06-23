package com.meizu.cloud.pushsdk.handler.a.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.a.a;
import com.meizu.cloud.pushsdk.notification.c;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.b;

/* compiled from: Taobao */
public class f extends a<UnRegisterStatus> {
    public f(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 1024;
    }

    /* access modifiers changed from: protected */
    public void a(UnRegisterStatus unRegisterStatus, c cVar) {
        if (c() != null && unRegisterStatus != null) {
            c().a(d(), unRegisterStatus);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start UnRegisterStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_UNREGISTER_STATUS.equals(k(intent));
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public UnRegisterStatus c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_MESSAGE_VALUE);
        UnRegisterStatus b = !TextUtils.isEmpty(stringExtra) ? com.meizu.cloud.pushsdk.platform.message.a.b(stringExtra) : (UnRegisterStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_UNREGISTER_STATUS);
        if (b.isUnRegisterSuccess()) {
            b.g(d(), "", d().getPackageName());
        }
        return b;
    }
}

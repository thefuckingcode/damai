package com.meizu.cloud.pushsdk.handler.a.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.c;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.util.b;

/* compiled from: Taobao */
public class a extends com.meizu.cloud.pushsdk.handler.a.a<PushSwitchStatus> {
    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 256;
    }

    /* access modifiers changed from: protected */
    public void a(PushSwitchStatus pushSwitchStatus, c cVar) {
        if (c() != null && pushSwitchStatus != null) {
            c().a(d(), pushSwitchStatus);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start PushSwitchStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PUSH_STATUS.equals(k(intent));
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public PushSwitchStatus c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_MESSAGE_VALUE);
        PushSwitchStatus c = !TextUtils.isEmpty(stringExtra) ? com.meizu.cloud.pushsdk.platform.message.a.c(stringExtra) : (PushSwitchStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_STATUS);
        if ("200".equals(c.getCode())) {
            String g = g(intent);
            DebugLogger.e("AbstractMessageHandler", "PushSwitchStatusHandler update local " + g + " switch status " + c);
            b.a(d(), g, c.isSwitchNotificationMessage());
            b.b(d(), g, c.isSwitchThroughMessage());
        }
        return c;
    }
}

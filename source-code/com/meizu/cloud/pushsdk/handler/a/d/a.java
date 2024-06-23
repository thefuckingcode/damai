package com.meizu.cloud.pushsdk.handler.a.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.handler.d;
import com.meizu.cloud.pushsdk.notification.c;

/* compiled from: Taobao */
public class a extends com.meizu.cloud.pushsdk.handler.a.a<MessageV3> {
    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 131072;
    }

    /* access modifiers changed from: protected */
    public void a(MessageV3 messageV3, c cVar) {
        if (c() != null && messageV3 != null) {
            c().b(d(), MzPushMessage.fromMessageV3(messageV3));
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start NotificationArrivedHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_ARRIVED.equals(k(intent));
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public MessageV3 c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_MESSAGE_VALUE);
        return !TextUtils.isEmpty(stringExtra) ? d.a(stringExtra) : (MessageV3) intent.getParcelableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
    }
}

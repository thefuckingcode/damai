package com.meizu.cloud.pushsdk.handler.a.f;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.a;
import com.meizu.cloud.pushsdk.util.d;

/* compiled from: Taobao */
public class c extends com.meizu.cloud.pushsdk.handler.a.c {
    public c(Context context, a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.c, com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 8192;
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.c
    public void a(MessageV3 messageV3, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (cVar != null) {
            cVar.b(messageV3);
            a(messageV3);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.c, com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start ScheduleNotificationHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SCHEDULE_NOTIFICATION.equals(k(intent));
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.c
    /* renamed from: d */
    public void b(MessageV3 messageV3) {
        DebugLogger.e("AbstractMessageHandler", "ScheduleNotificationHandler don't repeat upload receiver push event");
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.c
    /* renamed from: e */
    public void c(MessageV3 messageV3) {
        d.a(d(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp(), messageV3.getDelayedReportMillis());
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.c
    /* renamed from: h */
    public int d(MessageV3 messageV3) {
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.handler.a.c
    /* renamed from: l */
    public MessageV3 c(Intent intent) {
        return (MessageV3) intent.getParcelableExtra(PushConstants.EXTRA_APP_PUSH_SCHEDULE_NOTIFICATION_MESSAGE);
    }
}

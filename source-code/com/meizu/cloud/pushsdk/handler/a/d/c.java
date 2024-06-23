package com.meizu.cloud.pushsdk.handler.a.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.handler.a.a;
import com.meizu.cloud.pushsdk.util.b;
import com.meizu.cloud.pushsdk.util.d;

/* compiled from: Taobao */
public class c extends a<MessageV3> {
    private Context a;

    public c(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
        this.a = context;
    }

    private void e(MessageV3 messageV3) {
        if (messageV3.getAdvertisementOption() != null && !TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage())) {
            b.a(this.a, messageV3.getAdvertisementOption().getAdPackage(), System.currentTimeMillis());
            d.e(this.a, messageV3.getAdvertisementOption().getAdInstallPackage(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 1048576;
    }

    /* access modifiers changed from: protected */
    public void a(MessageV3 messageV3, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (messageV3 != null) {
            e(messageV3);
            if (!TextUtils.isEmpty(messageV3.getTitle()) && !TextUtils.isEmpty(messageV3.getContent()) && c() != null) {
                c().c(d(), MzPushMessage.fromMessageV3(messageV3));
            }
            b(messageV3);
            a(this.a, messageV3);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start NotificationCloseMessageHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_CLOSE.equals(k(intent));
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void b(MessageV3 messageV3) {
        d.a(d(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public MessageV3 c(Intent intent) {
        return (MessageV3) intent.getParcelableExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
    }
}

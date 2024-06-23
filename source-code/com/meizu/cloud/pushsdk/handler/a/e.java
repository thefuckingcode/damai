package com.meizu.cloud.pushsdk.handler.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.a;
import com.meizu.cloud.pushsdk.handler.a.c.d;
import com.meizu.cloud.pushsdk.notification.c;

/* compiled from: Taobao */
public class e extends a<MessageV3> {
    public e(Context context, a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 8;
    }

    /* access modifiers changed from: protected */
    public void a(MessageV3 messageV3, c cVar) {
        if (c() != null && messageV3 != null && !TextUtils.isEmpty(messageV3.getThroughMessage())) {
            c().b(d(), messageV3.getThroughMessage());
            c().a(d(), messageV3.getThroughMessage(), d.a().a(messageV3.getTaskId()).b(messageV3.getSeqId()).c(messageV3.getPushTimestamp()).d(messageV3.getDeviceId()).a().b());
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start ThroughMessageHandler match");
        if (!a(1, g(intent))) {
            return false;
        }
        if (PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction())) {
            if ("message".equals(k(intent))) {
                return true;
            }
            if (TextUtils.isEmpty(k(intent))) {
                String stringExtra = intent.getStringExtra("message");
                if (!TextUtils.isEmpty(stringExtra) && !a(stringExtra)) {
                    return true;
                }
            }
        }
        return PushConstants.C2DM_INTENT.equals(intent.getAction());
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void b(MessageV3 messageV3) {
        if (messageV3 != null && !TextUtils.isEmpty(messageV3.getDeviceId()) && !TextUtils.isEmpty(messageV3.getTaskId())) {
            String b = b(messageV3.getThroughMessage());
            if (!TextUtils.isEmpty(b)) {
                com.meizu.cloud.pushsdk.util.d.c(d(), b, messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
            } else {
                com.meizu.cloud.pushsdk.util.d.c(d(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public MessageV3 c(Intent intent) {
        MessageV3 messageV3 = new MessageV3();
        if (PushConstants.C2DM_INTENT.equals(intent.getAction())) {
            c().a(d(), intent);
            return null;
        }
        messageV3.setThroughMessage(intent.getStringExtra("message"));
        messageV3.setTaskId(e(intent));
        messageV3.setDeviceId(d(intent));
        messageV3.setSeqId(f(intent));
        messageV3.setPushTimestamp(h(intent));
        messageV3.setUploadDataPackageName(g(intent));
        return messageV3;
    }
}

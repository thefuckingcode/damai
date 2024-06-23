package com.meizu.cloud.pushsdk.handler.a.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.a.a;
import com.meizu.cloud.pushsdk.notification.c;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.util.b;

/* compiled from: Taobao */
public class d extends a<SubAliasStatus> {
    public d(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    private void c(String str) {
        b.h(d(), d().getPackageName(), str);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 4096;
    }

    /* access modifiers changed from: protected */
    public void a(SubAliasStatus subAliasStatus, c cVar) {
        if (c() != null && subAliasStatus != null) {
            c().a(d(), subAliasStatus);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start SubScribeAliasStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBALIAS_STATUS.equals(k(intent));
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public SubAliasStatus c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_MESSAGE_VALUE);
        SubAliasStatus d = !TextUtils.isEmpty(stringExtra) ? com.meizu.cloud.pushsdk.platform.message.a.d(stringExtra) : (SubAliasStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_SUBALIAS_STATUS);
        if ("200".equals(d.getCode())) {
            c(d.getAlias());
        }
        return d;
    }
}

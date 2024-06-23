package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alipay.sdk.m.l.b;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.a.a;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
public class g extends c<UnRegisterStatus> {
    public g(Context context, a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, aVar, scheduledExecutorService);
    }

    public g(Context context, a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.g = z;
    }

    public g(Context context, String str, String str2, a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
    }

    /* access modifiers changed from: protected */
    public void a(UnRegisterStatus unRegisterStatus) {
        PlatformMessageSender.a(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), unRegisterStatus);
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c);
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra(b.h, this.c);
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra("strategy_type", g());
        return intent;
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 32;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public UnRegisterStatus b() {
        String str;
        UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
        unRegisterStatus.setCode("20001");
        if (TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else {
            if (TextUtils.isEmpty(this.c)) {
                str = "appKey not empty";
            }
            return unRegisterStatus;
        }
        unRegisterStatus.setMessage(str);
        return unRegisterStatus;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public UnRegisterStatus e() {
        UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
        if (TextUtils.isEmpty(com.meizu.cloud.pushsdk.util.b.a(this.a, this.d))) {
            unRegisterStatus.setCode("200");
            unRegisterStatus.setMessage("already unRegister PushId,don't unRegister frequently");
            unRegisterStatus.setIsUnRegisterSuccess(true);
        } else {
            c b = this.e.b(this.b, this.c, com.meizu.cloud.pushsdk.b.c.a(this.a));
            if (b.b()) {
                unRegisterStatus = new UnRegisterStatus((String) b.a());
                DebugLogger.e("Strategy", "network unRegisterStatus " + unRegisterStatus);
                if ("200".equals(unRegisterStatus.getCode())) {
                    com.meizu.cloud.pushsdk.util.b.g(this.a, "", this.d);
                }
            } else {
                com.meizu.cloud.pushsdk.c.b.a c = b.c();
                if (c.a() != null) {
                    DebugLogger.e("Strategy", "status code=" + c.b() + " data=" + c.a());
                }
                unRegisterStatus.setCode(String.valueOf(c.b()));
                unRegisterStatus.setMessage(c.c());
                DebugLogger.e("Strategy", "unRegisterStatus " + unRegisterStatus);
            }
        }
        return unRegisterStatus;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public UnRegisterStatus f() {
        return null;
    }
}

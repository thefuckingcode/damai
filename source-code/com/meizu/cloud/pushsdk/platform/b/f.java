package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.a.a;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.util.b;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
public class f extends c<PushSwitchStatus> {
    private String h;
    private int i;
    private boolean j;
    private final Map<String, Boolean> k;

    public f(Context context, a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public f(Context context, a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.g = z;
    }

    public f(Context context, String str, String str2, a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.i = 0;
        this.k = new HashMap();
    }

    public f(Context context, String str, String str2, String str3, a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.h = str3;
    }

    private c<String> b(PushSwitchStatus pushSwitchStatus) {
        boolean z;
        boolean z2;
        boolean z3;
        int i2 = this.i;
        if (i2 != 0) {
            if (i2 == 1) {
                pushSwitchStatus.setMessage("SWITCH_THROUGH_MESSAGE");
                if (r() != this.j || t()) {
                    f(true);
                    d(this.j);
                    return this.e.a(this.b, this.c, this.h, this.i, this.j);
                }
                z3 = p();
            } else if (i2 != 2) {
                if (i2 == 3) {
                    pushSwitchStatus.setMessage("SWITCH_ALL");
                    if (p() == this.j && r() == this.j && !t()) {
                        z3 = this.j;
                    } else {
                        f(true);
                        e(this.j);
                        return this.e.a(this.b, this.c, this.h, this.j);
                    }
                }
                return null;
            } else {
                pushSwitchStatus.setMessage("CHECK_PUSH");
                if (!q() || !s() || t()) {
                    f(true);
                    return this.e.c(this.b, this.c, this.h);
                }
                z2 = p();
            }
            pushSwitchStatus.setSwitchNotificationMessage(z3);
            z = this.j;
            pushSwitchStatus.setSwitchThroughMessage(z);
            return null;
        }
        pushSwitchStatus.setMessage("SWITCH_NOTIFICATION");
        if (p() != this.j || t()) {
            f(true);
            c(this.j);
            return this.e.a(this.b, this.c, this.h, this.i, this.j);
        }
        z2 = this.j;
        pushSwitchStatus.setSwitchNotificationMessage(z2);
        z = r();
        pushSwitchStatus.setSwitchThroughMessage(z);
        return null;
    }

    private void c(boolean z) {
        b.a(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), z);
    }

    private void d(boolean z) {
        b.b(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), z);
    }

    private void e(boolean z) {
        b.a(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), z);
        b.b(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), z);
    }

    private void f(boolean z) {
        Map<String, Boolean> map = this.k;
        map.put(this.d + JSMethod.NOT_SET + this.i, Boolean.valueOf(z));
    }

    private void o() {
        int i2 = this.i;
        if (i2 == 0 || i2 == 1) {
            PlatformMessageSender.a(this.a, i2, this.j, this.d);
        } else if (i2 == 3) {
            PlatformMessageSender.a(this.a, 0, this.j, this.d);
            PlatformMessageSender.a(this.a, 1, this.j, this.d);
        }
    }

    private boolean p() {
        return b.e(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName());
    }

    private boolean q() {
        return b.f(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName());
    }

    private boolean r() {
        return b.h(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName());
    }

    private boolean s() {
        return b.i(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName());
    }

    private boolean t() {
        Map<String, Boolean> map = this.k;
        Boolean bool = map.get(this.d + JSMethod.NOT_SET + this.i);
        boolean z = bool == null || bool.booleanValue();
        DebugLogger.e("Strategy", "isSyncPushStatus " + this.d + " switch type->" + this.i + " flag->" + z);
        return z;
    }

    public void a(int i2) {
        this.i = i2;
    }

    /* access modifiers changed from: protected */
    public void a(PushSwitchStatus pushSwitchStatus) {
        PlatformMessageSender.a(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), pushSwitchStatus);
    }

    public void a(String str) {
        this.h = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.h);
    }

    public void b(boolean z) {
        this.j = z;
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra(com.alipay.sdk.m.l.b.h, this.c);
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra(PushConstants.REGISTER_STATUS_PUSH_ID, this.h);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.i);
        intent.putExtra("strategy_params", this.j ? "1" : "0");
        return intent;
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 16;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public PushSwitchStatus b() {
        String str;
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setCode("20001");
        if (TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else if (TextUtils.isEmpty(this.c)) {
            str = "appKey not empty";
        } else {
            if (TextUtils.isEmpty(this.h)) {
                str = "pushId not empty";
            }
            return pushSwitchStatus;
        }
        pushSwitchStatus.setMessage(str);
        return pushSwitchStatus;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public PushSwitchStatus e() {
        PushSwitchStatus pushSwitchStatus = new PushSwitchStatus();
        pushSwitchStatus.setPushId(this.h);
        pushSwitchStatus.setCode("200");
        c<String> b = b(pushSwitchStatus);
        if (b != null) {
            if (b.b()) {
                PushSwitchStatus pushSwitchStatus2 = new PushSwitchStatus(b.a());
                DebugLogger.e("Strategy", "network pushSwitchStatus " + pushSwitchStatus2);
                if ("200".equals(pushSwitchStatus.getCode())) {
                    f(false);
                    DebugLogger.e("Strategy", "update local switch preference");
                    pushSwitchStatus.setSwitchNotificationMessage(pushSwitchStatus2.isSwitchNotificationMessage());
                    pushSwitchStatus.setSwitchThroughMessage(pushSwitchStatus2.isSwitchThroughMessage());
                    c(pushSwitchStatus2.isSwitchNotificationMessage());
                    d(pushSwitchStatus2.isSwitchThroughMessage());
                }
            } else {
                com.meizu.cloud.pushsdk.c.b.a c = b.c();
                if (c.a() != null) {
                    DebugLogger.e("Strategy", "status code=" + c.b() + " data=" + c.a());
                }
                pushSwitchStatus.setCode(String.valueOf(c.b()));
                pushSwitchStatus.setMessage(c.c());
                DebugLogger.e("Strategy", "pushSwitchStatus " + pushSwitchStatus);
            }
        }
        DebugLogger.e("Strategy", "enableRpc " + this.g + " isSupportRemoteInvoke " + this.f);
        if (this.g && !this.f) {
            o();
        }
        return pushSwitchStatus;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public PushSwitchStatus f() {
        int i2 = this.i;
        if (i2 == 0) {
            c(this.j);
            return null;
        } else if (i2 == 1) {
            d(this.j);
            return null;
        } else if (i2 != 2 && i2 != 3) {
            return null;
        } else {
            e(this.j);
            return null;
        }
    }
}

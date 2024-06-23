package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.b.c;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.a.a;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class b extends c<RegisterStatus> {
    private Handler h;
    private ScheduledExecutorService i;
    private int j;

    public b(Context context, a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, aVar, scheduledExecutorService);
        this.i = (ScheduledExecutorService) com.meizu.cloud.pushsdk.d.b.a.b.a();
        this.h = new Handler(context.getMainLooper()) {
            /* class com.meizu.cloud.pushsdk.platform.b.b.AnonymousClass1 */

            public void handleMessage(Message message) {
                if (message.what == 0) {
                    b.this.m();
                }
            }
        };
    }

    public b(Context context, a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.g = z;
    }

    public b(Context context, String str, String str2, a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.j = 0;
    }

    private boolean a(String str, String str2, int i2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str2.startsWith(str) || System.currentTimeMillis() / 1000 > ((long) i2);
    }

    /* access modifiers changed from: protected */
    public void a(long j2) {
        this.i.schedule(new Runnable() {
            /* class com.meizu.cloud.pushsdk.platform.b.b.AnonymousClass2 */

            public void run() {
                c.a(b.this.a);
                b.this.h.sendEmptyMessage(0);
            }
        }, j2, TimeUnit.SECONDS);
    }

    public void a(RegisterStatus registerStatus) {
        PlatformMessageSender.a(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), registerStatus);
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        DebugLogger.e("Strategy", "isBrandMeizu " + MzSystemUtils.isBrandMeizu(this.a));
        return !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c);
    }

    /* access modifiers changed from: protected */
    public boolean a(String str, int i2) {
        String a = c.a(this.a);
        boolean a2 = a(a, str, i2);
        return a2 ? a(a, com.meizu.cloud.pushsdk.platform.a.a(str), i2) : a2;
    }

    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra(com.alipay.sdk.m.l.b.h, this.c);
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra("strategy_type", g());
        return intent;
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public RegisterStatus b() {
        String str;
        RegisterStatus registerStatus = new RegisterStatus();
        registerStatus.setCode("20001");
        if (TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else {
            if (TextUtils.isEmpty(this.c)) {
                str = "appKey not empty";
            }
            return registerStatus;
        }
        registerStatus.setMessage(str);
        return registerStatus;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public RegisterStatus f() {
        return null;
    }

    /* renamed from: j */
    public RegisterStatus e() {
        RegisterStatus registerStatus = new RegisterStatus();
        String a = com.meizu.cloud.pushsdk.util.b.a(this.a, this.d);
        int b = com.meizu.cloud.pushsdk.util.b.b(this.a, this.d);
        if (!a(a, b)) {
            registerStatus.setCode("200");
            registerStatus.setMessage("already register PushId,don't register frequently");
            registerStatus.setPushId(a);
            registerStatus.setExpireTime((int) (((long) b) - (System.currentTimeMillis() / 1000)));
        } else {
            com.meizu.cloud.pushsdk.util.b.g(this.a, "", this.d);
            String a2 = c.a(this.a);
            if (!TextUtils.isEmpty(a2) || this.j >= 3) {
                this.j = 0;
                com.meizu.cloud.pushsdk.c.a.c a3 = this.e.a(this.b, this.c, a2);
                if (a3.b()) {
                    registerStatus = new RegisterStatus((String) a3.a());
                    DebugLogger.e("Strategy", "registerStatus " + registerStatus);
                    if (!TextUtils.isEmpty(registerStatus.getPushId())) {
                        com.meizu.cloud.pushsdk.util.b.g(this.a, registerStatus.getPushId(), this.d);
                        com.meizu.cloud.pushsdk.util.b.a(this.a, (int) ((System.currentTimeMillis() / 1000) + ((long) registerStatus.getExpireTime())), this.d);
                    }
                } else {
                    com.meizu.cloud.pushsdk.c.b.a c = a3.c();
                    if (c.a() != null) {
                        DebugLogger.e("Strategy", "status code=" + c.b() + " data=" + c.a());
                    }
                    registerStatus.setCode(String.valueOf(c.b()));
                    registerStatus.setMessage(c.c());
                    DebugLogger.e("Strategy", "registerStatus " + registerStatus);
                }
            } else {
                DebugLogger.i("Strategy", "after " + (this.j * 10) + " seconds start register");
                a((long) (this.j * 10));
                this.j = this.j + 1;
                registerStatus.setCode("20000");
                registerStatus.setMessage("deviceId is empty");
            }
        }
        return registerStatus;
    }
}

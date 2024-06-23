package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.notification.c.b;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
public class a extends c {
    private int[] h;
    private int i;
    private String j;

    public a(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.f = MinSdkChecker.isSupportSetDrawableSmallIcon();
    }

    public a(Context context, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, null, null, null, scheduledExecutorService);
        this.g = z;
    }

    public void a(int i2) {
        this.i = i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public void a(BasicPushStatus basicPushStatus) {
    }

    public void a(String str) {
        this.j = str;
    }

    public void a(int... iArr) {
        this.h = iArr;
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        int i2 = this.i;
        if (i2 == 0) {
            return true;
        }
        int[] iArr = this.h;
        if (iArr == null || iArr.length <= 0 || i2 != 1) {
            return i2 == 2 && !TextUtils.isEmpty(this.j);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public BasicPushStatus b() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.i);
        int i2 = this.i;
        if (i2 == 2) {
            intent.putExtra("strategy_params", this.j);
            return intent;
        } else if (i2 == 1) {
            return null;
        } else {
            return intent;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent[] d() {
        int[] iArr = this.h;
        if (iArr == null) {
            return null;
        }
        Intent[] intentArr = new Intent[iArr.length];
        for (int i2 = 0; i2 < this.h.length; i2++) {
            DebugLogger.i("Strategy", "send notifyId " + this.h[i2] + " to PushManagerService");
            Intent intent = new Intent();
            intent.putExtra("strategy_package_name", this.a.getPackageName());
            intent.putExtra("strategy_type", g());
            intent.putExtra("strategy_child_type", this.i);
            intent.putExtra("strategy_params", "" + this.h[i2]);
            intentArr[i2] = intent;
        }
        return intentArr;
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public BasicPushStatus e() {
        int i2 = this.i;
        if (i2 == 0) {
            if (!MinSdkChecker.isSupportSetDrawableSmallIcon()) {
                DebugLogger.e("Strategy", "android 6.0 blow so cancel all by context");
                b.a(this.a);
            }
            b.a(this.a, this.d);
            return null;
        } else if (i2 == 1) {
            int[] iArr = this.h;
            if (iArr == null) {
                return null;
            }
            for (int i3 : iArr) {
                DebugLogger.e("Strategy", "clear notifyId " + i3);
                b.a(this.a, this.d, i3);
            }
            return null;
        } else if (i2 != 2) {
            return null;
        } else {
            b.a(this.a, this.d, this.j);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public BasicPushStatus f() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 64;
    }
}

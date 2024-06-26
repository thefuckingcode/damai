package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alipay.sdk.m.l.b;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.a.a;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
public class e extends c<SubTagsStatus> {
    private String h;
    private int i;
    private String j;

    public e(Context context, a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public e(Context context, a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.g = z;
    }

    public e(Context context, String str, String str2, a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.i = 3;
    }

    public e(Context context, String str, String str2, String str3, a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.h = str3;
    }

    public void a(int i2) {
        this.i = i2;
    }

    /* access modifiers changed from: protected */
    public void a(SubTagsStatus subTagsStatus) {
        PlatformMessageSender.a(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), subTagsStatus);
    }

    public void a(String str) {
        this.j = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public boolean a() {
        return !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.h);
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public Intent c() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra(b.h, this.c);
        intent.putExtra("strategy_package_name", this.a.getPackageName());
        intent.putExtra(PushConstants.REGISTER_STATUS_PUSH_ID, this.h);
        intent.putExtra("strategy_type", g());
        intent.putExtra("strategy_child_type", this.i);
        intent.putExtra("strategy_params", this.j);
        return intent;
    }

    public void e(String str) {
        this.h = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.meizu.cloud.pushsdk.platform.b.c
    public int g() {
        return 4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public SubTagsStatus b() {
        String str;
        SubTagsStatus subTagsStatus = new SubTagsStatus();
        subTagsStatus.setCode("20001");
        if (TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else if (TextUtils.isEmpty(this.c)) {
            str = "appKey not empty";
        } else {
            if (TextUtils.isEmpty(this.h)) {
                str = "pushId not empty";
            }
            return subTagsStatus;
        }
        subTagsStatus.setMessage(str);
        return subTagsStatus;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public SubTagsStatus e() {
        StringBuilder sb;
        String str;
        SubTagsStatus subTagsStatus = new SubTagsStatus();
        int i2 = this.i;
        c e = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? null : this.e.e(this.b, this.c, this.h) : this.e.d(this.b, this.c, this.h) : this.e.b(this.b, this.c, this.h, this.j) : this.e.a(this.b, this.c, this.h, this.j);
        if (e == null) {
            DebugLogger.e("Strategy", "network anResponse is null");
            return null;
        }
        if (e.b()) {
            subTagsStatus = new SubTagsStatus((String) e.a());
            sb = new StringBuilder();
            str = "network subTagsStatus ";
        } else {
            com.meizu.cloud.pushsdk.c.b.a c = e.c();
            if (c.a() != null) {
                DebugLogger.e("Strategy", "status code=" + c.b() + " data=" + c.a());
            }
            subTagsStatus.setCode(String.valueOf(c.b()));
            subTagsStatus.setMessage(c.c());
            sb = new StringBuilder();
            str = "subTagsStatus ";
        }
        sb.append(str);
        sb.append(subTagsStatus);
        DebugLogger.e("Strategy", sb.toString());
        return subTagsStatus;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public SubTagsStatus f() {
        return null;
    }
}

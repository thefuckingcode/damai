package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.a.a;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.util.b;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: Taobao */
public class d extends c<SubAliasStatus> {
    private String h;
    private int i;
    private String j;
    private final Map<String, Boolean> k;

    public d(Context context, a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, null, null, null, aVar, scheduledExecutorService);
    }

    public d(Context context, a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.g = z;
    }

    public d(Context context, String str, String str2, a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
        this.k = new HashMap();
    }

    public d(Context context, String str, String str2, String str3, a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, str, str2, aVar, scheduledExecutorService);
        this.h = str3;
    }

    private void b(boolean z) {
        Map<String, Boolean> map = this.k;
        map.put(this.d + JSMethod.NOT_SET + this.i, Boolean.valueOf(z));
    }

    private void f(String str) {
        b.h(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), str);
    }

    private String o() {
        return b.g(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName());
    }

    private boolean p() {
        Map<String, Boolean> map = this.k;
        Boolean bool = map.get(this.d + JSMethod.NOT_SET + this.i);
        return bool == null || bool.booleanValue();
    }

    private boolean q() {
        return !this.f && PushConstants.PUSH_PACKAGE_NAME.equals(this.d);
    }

    public void a(int i2) {
        this.i = i2;
    }

    /* access modifiers changed from: protected */
    public void a(SubAliasStatus subAliasStatus) {
        PlatformMessageSender.a(this.a, !TextUtils.isEmpty(this.d) ? this.d : this.a.getPackageName(), subAliasStatus);
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
        if (this.i == 2) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("app_id", this.b);
        intent.putExtra(com.alipay.sdk.m.l.b.h, this.c);
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
        return 8;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public SubAliasStatus b() {
        String str;
        SubAliasStatus subAliasStatus = new SubAliasStatus();
        subAliasStatus.setCode("20001");
        if (TextUtils.isEmpty(this.b)) {
            str = "appId not empty";
        } else if (TextUtils.isEmpty(this.c)) {
            str = "appKey not empty";
        } else {
            if (TextUtils.isEmpty(this.h)) {
                str = "pushId not empty";
            }
            return subAliasStatus;
        }
        subAliasStatus.setMessage(str);
        return subAliasStatus;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0090  */
    /* renamed from: i */
    public SubAliasStatus e() {
        c cVar;
        SubAliasStatus subAliasStatus = new SubAliasStatus();
        subAliasStatus.setPushId(this.h);
        String str = "";
        subAliasStatus.setMessage(str);
        int i2 = this.i;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    subAliasStatus.setAlias(o());
                    subAliasStatus.setCode("200");
                }
                cVar = null;
                if (cVar != null) {
                    if (cVar.b()) {
                        subAliasStatus = new SubAliasStatus((String) cVar.a());
                        DebugLogger.e("Strategy", "network subAliasStatus " + subAliasStatus);
                        if ("200".equals(subAliasStatus.getCode())) {
                            b(false);
                        }
                    } else {
                        com.meizu.cloud.pushsdk.c.b.a c = cVar.c();
                        if (c.a() != null) {
                            DebugLogger.e("Strategy", "status code=" + c.b() + " data=" + c.a());
                        }
                        subAliasStatus.setCode(String.valueOf(c.b()));
                        subAliasStatus.setMessage(c.c());
                        DebugLogger.e("Strategy", "subAliasStatus " + subAliasStatus);
                    }
                }
                return subAliasStatus;
            } else if (!TextUtils.isEmpty(o()) || p()) {
                b(true);
                if (q()) {
                    f(str);
                }
                cVar = this.e.d(this.b, this.c, this.h, this.j);
                if (cVar != null) {
                }
                return subAliasStatus;
            } else {
                subAliasStatus.setCode("200");
            }
        } else if (!this.j.equals(o()) || p()) {
            b(true);
            if (q()) {
                f(this.j);
            }
            cVar = this.e.c(this.b, this.c, this.h, this.j);
            if (cVar != null) {
            }
            return subAliasStatus;
        } else {
            subAliasStatus.setCode("200");
            str = this.j;
        }
        subAliasStatus.setAlias(str);
        cVar = null;
        if (cVar != null) {
        }
        return subAliasStatus;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public SubAliasStatus f() {
        if (this.i != 2) {
            return null;
        }
        SubAliasStatus subAliasStatus = new SubAliasStatus();
        subAliasStatus.setCode("200");
        subAliasStatus.setPushId(this.h);
        subAliasStatus.setAlias(o());
        subAliasStatus.setMessage("check alias success");
        return subAliasStatus;
    }
}

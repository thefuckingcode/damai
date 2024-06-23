package com.alibaba.pictures.share.qqshare;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.tauth.Tencent;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class QQShareActivity$doQQZoneRequest$4 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Context $context;
    final /* synthetic */ Bundle $params;
    final /* synthetic */ QQShareActivity this$0;

    QQShareActivity$doQQZoneRequest$4(QQShareActivity qQShareActivity, Context context, Bundle bundle) {
        this.this$0 = qQShareActivity;
        this.$context = context;
        this.$params = bundle;
    }

    public final void run() {
        Tencent c;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1155413041")) {
            ipChange.ipc$dispatch("1155413041", new Object[]{this});
        } else if (!this.this$0.isFinishing() && (c = QQShareActivity.c(this.this$0)) != null) {
            c.shareToQzone((Activity) this.$context, this.$params, this.this$0.h());
        }
    }
}

package com.alibaba.pictures.share.apshare;

import android.content.Context;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class AlipayApi$share$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isTimeLine;
    final /* synthetic */ ShareContent $shareParams;
    final /* synthetic */ AlipayApi this$0;

    AlipayApi$share$1(AlipayApi alipayApi, Context context, ShareContent shareContent, boolean z) {
        this.this$0 = alipayApi;
        this.$context = context;
        this.$shareParams = shareContent;
        this.$isTimeLine = z;
    }

    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-698108614")) {
            ipChange.ipc$dispatch("-698108614", new Object[]{this});
            return;
        }
        AlipayApi alipayApi = this.this$0;
        AlipayApi.a(alipayApi, this.$context, AlipayApi.b(alipayApi), this.$shareParams, this.$isTimeLine);
    }
}

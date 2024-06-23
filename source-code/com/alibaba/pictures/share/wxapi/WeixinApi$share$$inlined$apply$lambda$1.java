package com.alibaba.pictures.share.wxapi;

import android.content.Context;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Ltb/ur2;", "run", "()V", "com/alibaba/pictures/share/wxapi/WeixinApi$share$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class WeixinApi$share$$inlined$apply$lambda$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Context $context$inlined;
    final /* synthetic */ boolean $isTimeLine$inlined;
    final /* synthetic */ ShareContent $shareParams$inlined;
    final /* synthetic */ ShareChannel $shareType$inlined;
    final /* synthetic */ WeixinApi this$0;

    WeixinApi$share$$inlined$apply$lambda$1(WeixinApi weixinApi, Context context, ShareChannel shareChannel, ShareContent shareContent, boolean z) {
        this.this$0 = weixinApi;
        this.$context$inlined = context;
        this.$shareType$inlined = shareChannel;
        this.$shareParams$inlined = shareContent;
        this.$isTimeLine$inlined = z;
    }

    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-394581677")) {
            ipChange.ipc$dispatch("-394581677", new Object[]{this});
            return;
        }
        WeixinApi weixinApi = this.this$0;
        WeixinApi.a(weixinApi, this.$context$inlined, WeixinApi.b(weixinApi), this.$shareParams$inlined, this.$isTimeLine$inlined);
    }
}

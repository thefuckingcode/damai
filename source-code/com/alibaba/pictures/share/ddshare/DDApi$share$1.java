package com.alibaba.pictures.share.ddshare;

import android.content.Context;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.alibaba.pictures.share.common.util.ShareUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.fj2;

/* compiled from: Taobao */
public final class DDApi$share$1 implements ShareManager.IApplyPermission.IPermissionListener {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ DDApi a;
    final /* synthetic */ Context b;
    final /* synthetic */ ShareContent c;
    final /* synthetic */ ShareChannel d;

    DDApi$share$1(DDApi dDApi, Context context, ShareContent shareContent, ShareChannel shareChannel) {
        this.a = dDApi;
        this.b = context;
        this.c = shareContent;
        this.d = shareChannel;
    }

    @Override // com.alibaba.pictures.share.ShareManager.IApplyPermission.IPermissionListener
    public void onPermissionDenied() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1666472555")) {
            ipChange.ipc$dispatch("-1666472555", new Object[]{this});
            return;
        }
        ShareUtil.n("保存图片异常，请授予存储权限");
    }

    @Override // com.alibaba.pictures.share.ShareManager.IApplyPermission.IPermissionListener
    public void onPermissionGranted() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "955312799")) {
            ipChange.ipc$dispatch("955312799", new Object[]{this});
            return;
        }
        fj2.INSTANCE.b(new DDApi$share$1$onPermissionGranted$1(this));
    }
}

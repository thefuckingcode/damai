package com.alibaba.pictures.share.common.util;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class ShareUtil$getShareBitmap$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final ShareUtil$getShareBitmap$1 INSTANCE = new ShareUtil$getShareBitmap$1();

    ShareUtil$getShareBitmap$1() {
    }

    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "785539144")) {
            ipChange.ipc$dispatch("785539144", new Object[]{this});
            return;
        }
        ShareUtil.n("图片生成失败，请重试");
    }
}

package com.alibaba.pictures.picpermission;

import com.alibaba.pictures.picpermission.manage.PicPermissionManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/ur2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class Permission$start$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Permission$start$1 INSTANCE = new Permission$start$1();

    Permission$start$1() {
    }

    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1084907353")) {
            ipChange.ipc$dispatch("1084907353", new Object[]{this});
            return;
        }
        PicPermissionManager.Companion.instance().start();
    }
}

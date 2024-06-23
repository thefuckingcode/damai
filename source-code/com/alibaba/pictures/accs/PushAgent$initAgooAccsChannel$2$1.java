package com.alibaba.pictures.accs;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.ICallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, d2 = {"com/alibaba/pictures/accs/PushAgent$initAgooAccsChannel$2$1", "Lcom/taobao/agoo/ICallback;", "Ltb/ur2;", "onSuccess", "", "p0", "p1", "onFailure", "accs_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class PushAgent$initAgooAccsChannel$2$1 extends ICallback {
    private static transient /* synthetic */ IpChange $ipChange;

    PushAgent$initAgooAccsChannel$2$1() {
    }

    @Override // com.taobao.agoo.ICallback
    public void onFailure(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-729203363")) {
            ipChange.ipc$dispatch("-729203363", new Object[]{this, str, str2});
            return;
        }
        PushAgent pushAgent = PushAgent.INSTANCE;
        String str3 = PushAgent.a;
        ALog.e(str3, "bindAlias fail, msg=" + str + ',' + str2, new Object[0]);
    }

    @Override // com.taobao.agoo.ICallback
    public void onSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1527239760")) {
            ipChange.ipc$dispatch("-1527239760", new Object[]{this});
            return;
        }
        PushAgent pushAgent = PushAgent.INSTANCE;
        ALog.d(PushAgent.a, "bindAlias success", new Object[0]);
    }
}

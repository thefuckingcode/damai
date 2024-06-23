package com.alibaba.pictures.accs;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.agoo.ICallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\b"}, d2 = {"com/alibaba/pictures/accs/PushAgent$unbindAccsUser$1", "Lcom/taobao/agoo/ICallback;", "Ltb/ur2;", "onSuccess", "", "s", "s1", "onFailure", "accs_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class PushAgent$unbindAccsUser$1 extends ICallback {
    private static transient /* synthetic */ IpChange $ipChange;

    PushAgent$unbindAccsUser$1() {
    }

    @Override // com.taobao.agoo.ICallback
    public void onFailure(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1204292353")) {
            ipChange.ipc$dispatch("1204292353", new Object[]{this, str, str2});
            return;
        }
        PushAgent pushAgent = PushAgent.INSTANCE;
        ALog.d(PushAgent.a, "onFailure: unbindAccsUser", new Object[0]);
        if (str == null) {
            str = "";
        }
        AppMonitorAdapter.commitAlarmFail("accs_agoo", "status", "", "10007", str);
    }

    @Override // com.taobao.agoo.ICallback
    public void onSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1873738580")) {
            ipChange.ipc$dispatch("1873738580", new Object[]{this});
            return;
        }
        PushAgent pushAgent = PushAgent.INSTANCE;
        ALog.d(PushAgent.a, "onSuccess: unbindAccsUser", new Object[0]);
    }
}

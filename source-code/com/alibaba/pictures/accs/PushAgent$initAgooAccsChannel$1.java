package com.alibaba.pictures.accs;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.IRegister;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.k21;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/alibaba/pictures/accs/PushAgent$initAgooAccsChannel$1", "Lcom/taobao/agoo/IRegister;", "", "deviceToken", "Ltb/ur2;", "onSuccess", "errorCode", "errorMsg", "onFailure", "accs_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Taobao */
public final class PushAgent$initAgooAccsChannel$1 extends IRegister {
    private static transient /* synthetic */ IpChange $ipChange;

    PushAgent$initAgooAccsChannel$1() {
    }

    @Override // com.taobao.agoo.IRegister, com.taobao.agoo.ICallback
    public void onFailure(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "446257323")) {
            ipChange.ipc$dispatch("446257323", new Object[]{this, str, str2});
            return;
        }
        k21.i(str, "errorCode");
        k21.i(str2, "errorMsg");
        PushAgent pushAgent = PushAgent.INSTANCE;
        ALog.i(PushAgent.a, "onFailure", "errorcode", str, "errormsg", str2);
    }

    @Override // com.taobao.agoo.IRegister
    public void onSuccess(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "219790408")) {
            ipChange.ipc$dispatch("219790408", new Object[]{this, str});
            return;
        }
        k21.i(str, "deviceToken");
        PushAgent pushAgent = PushAgent.INSTANCE;
        ALog.i(PushAgent.a, "onSuccess", "devicetoken", str);
    }
}

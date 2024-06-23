package cn.damai.h5container;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d20;
import tb.ys2;

/* compiled from: Taobao */
public class UploaderEnvironmentImplDM extends ys2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public UploaderEnvironmentImplDM(Context context) {
        super(context);
    }

    @Override // tb.ys2, com.uploader.export.IUploaderEnvironment
    public String getUserId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "485421471")) {
            return d20.i();
        }
        return (String) ipChange.ipc$dispatch("485421471", new Object[]{this});
    }
}

package cn.damai.common.app.base;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.br;

/* compiled from: Taobao */
public abstract class a<V, M> {
    private static transient /* synthetic */ IpChange $ipChange;
    public Context mContext;
    protected br mDMMessage;
    public M mModel;
    public V mView;

    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1454207818")) {
            ipChange.ipc$dispatch("1454207818", new Object[]{this});
        }
    }

    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "186011042")) {
            ipChange.ipc$dispatch("186011042", new Object[]{this});
        }
    }

    public void setMessageCenter(br brVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "820369727")) {
            ipChange.ipc$dispatch("820369727", new Object[]{this, brVar});
            return;
        }
        this.mDMMessage = brVar;
    }

    public void setVM(V v, M m) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "49510340")) {
            ipChange.ipc$dispatch("49510340", new Object[]{this, v, m});
            return;
        }
        this.mView = v;
        this.mModel = m;
        onStart();
    }
}

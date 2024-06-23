package cn.damai.discover.main.bean;

import cn.damai.tetris.component.discover.bean.NoteBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ReadContent {
    private static transient /* synthetic */ IpChange $ipChange;
    public String id;
    public NoteBean item;

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-321102384")) {
            return (this.item == null || this.id == null) ? false : true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-321102384", new Object[]{this})).booleanValue();
    }
}

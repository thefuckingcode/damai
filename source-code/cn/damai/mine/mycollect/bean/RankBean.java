package cn.damai.mine.mycollect.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class RankBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String bgPic;
    public String count;
    public String id;
    public String ipvuv;
    public String name;
    public int pos;
    public String shortName;
    public int status;
    public String statusName;

    public boolean isEnableClick() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-160066675")) {
            return this.status == 3;
        }
        return ((Boolean) ipChange.ipc$dispatch("-160066675", new Object[]{this})).booleanValue();
    }
}

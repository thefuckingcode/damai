package cn.damai.tetris.component.drama.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.f92;
import tb.p3;

/* compiled from: Taobao */
public class AnchorList {
    private static transient /* synthetic */ IpChange $ipChange;
    public HashMap<Integer, AnchorBean> id2BeanMap = new HashMap<>();
    public AnchorBean mSelect;
    public List<AnchorBean> result;

    public AnchorBean first() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "397697058")) {
            return (AnchorBean) ipChange.ipc$dispatch("397697058", new Object[]{this});
        } else if (!f92.d(this.result)) {
            return this.result.get(0);
        } else {
            return null;
        }
    }

    public void sectionIdBindAptId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "845738551")) {
            ipChange.ipc$dispatch("845738551", new Object[]{this});
            return;
        }
        this.id2BeanMap.clear();
        p3 a = p3.a();
        if (!f92.d(this.result)) {
            for (AnchorBean anchorBean : this.result) {
                this.id2BeanMap.put(Integer.valueOf(a.b(anchorBean.sectionId)), anchorBean);
            }
        }
    }

    public boolean setSelectBean(AnchorBean anchorBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1642518700")) {
            return ((Boolean) ipChange.ipc$dispatch("-1642518700", new Object[]{this, anchorBean})).booleanValue();
        }
        AnchorBean anchorBean2 = this.mSelect;
        if (anchorBean2 == anchorBean) {
            return false;
        }
        if (anchorBean2 != null) {
            anchorBean2.isSelect = false;
        }
        this.mSelect = anchorBean;
        if (anchorBean != null) {
            anchorBean.isSelect = true;
        }
        return true;
    }
}

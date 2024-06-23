package cn.damai.user.repertoite.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
public class RepertoireDetailBean extends BaseOutDo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public RepertoireDetailDataBean data;

    public void setData(RepertoireDetailDataBean repertoireDetailDataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-23143358")) {
            ipChange.ipc$dispatch("-23143358", new Object[]{this, repertoireDetailDataBean});
            return;
        }
        this.data = repertoireDetailDataBean;
    }

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public RepertoireDetailDataBean getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "246109542")) {
            return this.data;
        }
        return (RepertoireDetailDataBean) ipChange.ipc$dispatch("246109542", new Object[]{this});
    }
}

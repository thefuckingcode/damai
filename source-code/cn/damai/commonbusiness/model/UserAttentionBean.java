package cn.damai.commonbusiness.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class UserAttentionBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private DataBean data;

    /* compiled from: Taobao */
    public static class DataBean {
        private static transient /* synthetic */ IpChange $ipChange;
        private int status;

        public int getStatus() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-388508490")) {
                return this.status;
            }
            return ((Integer) ipChange.ipc$dispatch("-388508490", new Object[]{this})).intValue();
        }

        public void setStatus(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1615299756")) {
                ipChange.ipc$dispatch("1615299756", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.status = i;
        }
    }

    public DataBean getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "773517698")) {
            return this.data;
        }
        return (DataBean) ipChange.ipc$dispatch("773517698", new Object[]{this});
    }

    public void setData(DataBean dataBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175538674")) {
            ipChange.ipc$dispatch("1175538674", new Object[]{this, dataBean});
            return;
        }
        this.data = dataBean;
    }
}

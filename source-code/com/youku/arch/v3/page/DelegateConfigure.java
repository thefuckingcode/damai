package com.youku.arch.v3.page;

import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class DelegateConfigure implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DelegatesBean> delegates;

    /* compiled from: Taobao */
    public static class DelegatesBean implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        @JSONField(name = "class")
        private String classX;
        private String desc;
        private boolean enable;
        private String tag;

        public String getClassX() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "997208265")) {
                return this.classX;
            }
            return (String) ipChange.ipc$dispatch("997208265", new Object[]{this});
        }

        public String getDesc() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-423553414")) {
                return this.desc;
            }
            return (String) ipChange.ipc$dispatch("-423553414", new Object[]{this});
        }

        public String getTag() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-847021049")) {
                return this.tag;
            }
            return (String) ipChange.ipc$dispatch("-847021049", new Object[]{this});
        }

        public boolean isEnable() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-103293900")) {
                return this.enable;
            }
            return ((Boolean) ipChange.ipc$dispatch("-103293900", new Object[]{this})).booleanValue();
        }

        public void setClassX(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-546406859")) {
                ipChange.ipc$dispatch("-546406859", new Object[]{this, str});
                return;
            }
            this.classX = str;
        }

        public void setDesc(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-538010716")) {
                ipChange.ipc$dispatch("-538010716", new Object[]{this, str});
                return;
            }
            this.desc = str;
        }

        public void setEnable(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "484033836")) {
                ipChange.ipc$dispatch("484033836", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            this.enable = z;
        }

        public void setTag(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "930699343")) {
                ipChange.ipc$dispatch("930699343", new Object[]{this, str});
                return;
            }
            this.tag = str;
        }
    }

    public List<DelegatesBean> getDelegates() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1587496260")) {
            return this.delegates;
        }
        return (List) ipChange.ipc$dispatch("-1587496260", new Object[]{this});
    }

    public void setDelegates(List<DelegatesBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1616516648")) {
            ipChange.ipc$dispatch("1616516648", new Object[]{this, list});
            return;
        }
        this.delegates = list;
    }
}

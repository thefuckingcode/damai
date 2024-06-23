package cn.damai.mine.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class UserCenterDynamicMenu implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<DynamicMenuItem> itemList;

    /* compiled from: Taobao */
    public static class DynamicMenuItem implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String bubbleText;
        public String iconUrl;
        public String targetUrl;
        public String title;

        public String getBubbleText() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1440640249")) {
                return this.bubbleText;
            }
            return (String) ipChange.ipc$dispatch("-1440640249", new Object[]{this});
        }

        public String getIconUrl() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "240357374")) {
                return this.iconUrl;
            }
            return (String) ipChange.ipc$dispatch("240357374", new Object[]{this});
        }

        public String getTargetUrl() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-878488410")) {
                return this.targetUrl;
            }
            return (String) ipChange.ipc$dispatch("-878488410", new Object[]{this});
        }

        public String getTitle() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-782674336")) {
                return this.title;
            }
            return (String) ipChange.ipc$dispatch("-782674336", new Object[]{this});
        }

        public void setTitle(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-296700394")) {
                ipChange.ipc$dispatch("-296700394", new Object[]{this, str});
                return;
            }
            this.title = str;
        }
    }

    public List<DynamicMenuItem> getItemList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "425959929")) {
            return this.itemList;
        }
        return (List) ipChange.ipc$dispatch("425959929", new Object[]{this});
    }
}

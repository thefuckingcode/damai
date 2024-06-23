package cn.damai.search.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class SearchEggs implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String backgroundPic;
    public String comboDispatchId;
    public String comboDispatchSystem;
    public long currentTime;
    public List<SearchEggHeader> header;
    public List<ProjectItemBean> projectInfo;
    public String type;
    public String url;

    /* compiled from: Taobao */
    public static class SearchEggHeader implements Serializable {
        public String pic;
        public String url;
    }

    public boolean isTypeJumpPage() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-463030263")) {
            return TextUtils.equals("2", this.type);
        }
        return ((Boolean) ipChange.ipc$dispatch("-463030263", new Object[]{this})).booleanValue();
    }

    public boolean isTypeShowList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-215671317")) {
            return TextUtils.equals("1", this.type);
        }
        return ((Boolean) ipChange.ipc$dispatch("-215671317", new Object[]{this})).booleanValue();
    }

    public boolean isValidType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1449389724")) {
            return isTypeJumpPage() || isTypeShowList();
        }
        return ((Boolean) ipChange.ipc$dispatch("1449389724", new Object[]{this})).booleanValue();
    }
}

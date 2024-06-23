package cn.damai.commonbusiness.notice.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class NoticeItem implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ArrayList<ItemContent> contentList;
    @Nullable
    private String title;

    @Nullable
    public final ArrayList<ItemContent> getContentList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-116239958")) {
            return this.contentList;
        }
        return (ArrayList) ipChange.ipc$dispatch("-116239958", new Object[]{this});
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1414013327")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("-1414013327", new Object[]{this});
    }

    public final void setContentList(@Nullable ArrayList<ItemContent> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-500023986")) {
            ipChange.ipc$dispatch("-500023986", new Object[]{this, arrayList});
            return;
        }
        this.contentList = arrayList;
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1606627365")) {
            ipChange.ipc$dispatch("1606627365", new Object[]{this, str});
            return;
        }
        this.title = str;
    }
}

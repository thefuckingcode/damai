package cn.damai.commonbusiness.notice.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
public final class NoticeListBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ArrayList<NoticeItem> detailList;
    @Nullable
    private ArrayList<String> noticeList;

    @Nullable
    public final ArrayList<NoticeItem> getDetailList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "464941427")) {
            return this.detailList;
        }
        return (ArrayList) ipChange.ipc$dispatch("464941427", new Object[]{this});
    }

    @Nullable
    public final ArrayList<String> getNoticeList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-808118644")) {
            return this.noticeList;
        }
        return (ArrayList) ipChange.ipc$dispatch("-808118644", new Object[]{this});
    }

    public final void setDetailList(@Nullable ArrayList<NoticeItem> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1880140093")) {
            ipChange.ipc$dispatch("1880140093", new Object[]{this, arrayList});
            return;
        }
        this.detailList = arrayList;
    }

    public final void setNoticeList(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1069983556")) {
            ipChange.ipc$dispatch("1069983556", new Object[]{this, arrayList});
            return;
        }
        this.noticeList = arrayList;
    }

    @NotNull
    public final ArrayList<ItemContent> subItemContentList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "146635234")) {
            return (ArrayList) ipChange.ipc$dispatch("146635234", new Object[]{this});
        }
        ArrayList<ItemContent> arrayList = new ArrayList<>();
        ArrayList<NoticeItem> arrayList2 = this.detailList;
        if (arrayList2 != null) {
            for (T t : arrayList2) {
                ArrayList<ItemContent> contentList = t.getContentList();
                if (contentList != null) {
                    int i = 0;
                    for (T t2 : contentList) {
                        if (i == 0) {
                            t2.setRootTitle(t.getTitle());
                        }
                        arrayList.add(t2);
                        i++;
                    }
                }
            }
        }
        return arrayList;
    }
}

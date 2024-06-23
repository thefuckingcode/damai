package cn.damai.discover.main.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class ReadModel {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<ReadContent> contentList;
    public String type;

    public ReadContent getFirstReadContent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1605044537")) {
            return (ReadContent) ipChange.ipc$dispatch("-1605044537", new Object[]{this});
        } else if (!f92.d(this.contentList)) {
            return this.contentList.get(0);
        } else {
            return null;
        }
    }

    public boolean isNoteRecommend() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1167480846")) {
            return TextUtils.equals("2", this.type);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1167480846", new Object[]{this})).booleanValue();
    }
}

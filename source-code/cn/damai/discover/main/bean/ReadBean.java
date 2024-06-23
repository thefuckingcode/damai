package cn.damai.discover.main.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class ReadBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public String errorCode;
    public List<ReadModel> model;
    public String success;

    public ReadContent getFirstReadCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "780778014")) {
            return (ReadContent) ipChange.ipc$dispatch("780778014", new Object[]{this});
        }
        ReadModel firstReadModel = getFirstReadModel();
        if (firstReadModel != null) {
            return firstReadModel.getFirstReadContent();
        }
        return null;
    }

    public ReadModel getFirstReadModel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1217502316")) {
            return (ReadModel) ipChange.ipc$dispatch("-1217502316", new Object[]{this});
        } else if (!f92.d(this.model)) {
            return this.model.get(0);
        } else {
            return null;
        }
    }

    public boolean isNoteRecommendValid() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "156059063")) {
            return ((Boolean) ipChange.ipc$dispatch("156059063", new Object[]{this})).booleanValue();
        }
        ReadModel firstReadModel = getFirstReadModel();
        if (firstReadModel != null) {
            boolean isNoteRecommend = firstReadModel.isNoteRecommend();
            ReadContent firstReadContent = firstReadModel.getFirstReadContent();
            return isNoteRecommend && firstReadContent != null && firstReadContent.isValid();
        }
    }

    public boolean success() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1125723492")) {
            return TextUtils.equals("true", this.success);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1125723492", new Object[]{this})).booleanValue();
    }
}

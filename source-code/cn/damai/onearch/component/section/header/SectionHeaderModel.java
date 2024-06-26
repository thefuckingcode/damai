package cn.damai.onearch.component.section.header;

import cn.damai.onearch.component.section.header.SectionHeaderContract;
import cn.damai.onearch.view.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;

/* compiled from: Taobao */
public class SectionHeaderModel extends AbsModel<IItem<ItemValue>, Object> implements SectionHeaderContract.Model<IItem<ItemValue>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private String title;

    @Override // cn.damai.onearch.component.section.header.SectionHeaderContract.Model
    public String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1897117666")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("-1897117666", new Object[]{this});
    }

    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseModelImpl(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1784660164")) {
            ipChange.ipc$dispatch("1784660164", new Object[]{this, iItem});
            return;
        }
        this.title = iItem.getProperty().getData().getString("title");
    }
}

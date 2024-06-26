package cn.damai.search.component.feed;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.onearch.view.AbsModel;
import cn.damai.search.component.bean.ProjectItemBeanWrap;
import cn.damai.search.component.bean.SearchYouKuArchProjectBean;
import cn.damai.search.component.feed.ProjectFeedContract;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import tb.g62;
import tb.s41;

/* compiled from: Taobao */
public class ProjectFeedModel extends AbsModel<IItem<ItemValue>, Object> implements ProjectFeedContract.Model<IItem<ItemValue>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ProjectItemBeanWrap mBean;

    @Override // cn.damai.search.component.feed.ProjectFeedContract.Model
    public ProjectItemBeanWrap getBean() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1487290430")) {
            return this.mBean;
        }
        return (ProjectItemBeanWrap) ipChange.ipc$dispatch("1487290430", new Object[]{this});
    }

    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseModelImpl(IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1383147642")) {
            ipChange.ipc$dispatch("-1383147642", new Object[]{this, iItem});
            return;
        }
        try {
            ProjectItemBean a = g62.a((SearchYouKuArchProjectBean) s41.d(iItem.getProperty().getData(), SearchYouKuArchProjectBean.class));
            if (a != null) {
                this.mBean = new ProjectItemBeanWrap(a);
            } else {
                this.mBean = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.mBean = null;
        }
    }
}

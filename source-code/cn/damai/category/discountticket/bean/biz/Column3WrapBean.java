package cn.damai.category.discountticket.bean.biz;

import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.q80;
import tb.xf2;

/* compiled from: Taobao */
public class Column3WrapBean {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PROJECT_COUNT_PER_ROW = 3;
    public List<ProjectItemBean> list;

    private int getProjectCount() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "633689292")) {
            return xf2.e(this.list);
        }
        return ((Integer) ipChange.ipc$dispatch("633689292", new Object[]{this})).intValue();
    }

    public static List<Column3WrapBean> toAdapterList(List<ProjectItemBean> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "685334243")) {
            return (List) ipChange.ipc$dispatch("685334243", new Object[]{list2});
        }
        Column3WrapBean column3WrapBean = null;
        if (list2 == null || list2.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list2.size(); i++) {
            if (i % 3 == 0) {
                column3WrapBean = new Column3WrapBean();
                column3WrapBean.list = new ArrayList();
                arrayList.add(column3WrapBean);
            }
            column3WrapBean.list.add(list2.get(i));
        }
        return arrayList;
    }

    public List<ProjectItemBean> supply(List<ProjectItemBean> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-416576224")) {
            return (List) ipChange.ipc$dispatch("-416576224", new Object[]{this, list2});
        }
        int projectCount = getProjectCount();
        if (projectCount < 3) {
            if (this.list == null) {
                this.list = new ArrayList();
            }
            if (!q80.b(list2)) {
                int min = Math.min(3 - projectCount, list2.size());
                for (int i = 0; i < min; i++) {
                    this.list.add(list2.get(i));
                }
                if (this.list.size() > 0) {
                    for (int i2 = 0; i2 < this.list.size(); i2++) {
                        list2.remove(this.list.get(i2));
                    }
                }
            }
        }
        return list2;
    }
}

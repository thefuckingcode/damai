package cn.damai.projectfilter.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.f92;

/* compiled from: Taobao */
public class FilterGroupBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DATE_TYPE = "dateType";
    public static final String GROUP_ID = "groupId";
    public boolean isSingleSelected;
    public List<FilterBean> lineitem;
    public String name;
    public String option;

    public static List<FilterBean> extractFast(List<FilterGroupBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454053623")) {
            return (List) ipChange.ipc$dispatch("454053623", new Object[]{list});
        } else if (f92.d(list)) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (FilterGroupBean filterGroupBean : list) {
                String str = filterGroupBean.option;
                List<FilterBean> list2 = filterGroupBean.lineitem;
                if (!f92.d(list2)) {
                    for (FilterBean filterBean : list2) {
                        filterBean.option = str;
                        arrayList.add(filterBean);
                    }
                }
            }
            return arrayList;
        }
    }

    public static void itemBindOption(List<FilterGroupBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1998365734")) {
            ipChange.ipc$dispatch("-1998365734", new Object[]{list});
        } else if (f92.g(list)) {
            for (FilterGroupBean filterGroupBean : list) {
                String str = filterGroupBean.option;
                List<FilterBean> list2 = filterGroupBean.lineitem;
                if (f92.g(list2)) {
                    for (FilterBean filterBean : list2) {
                        filterBean.option = str;
                    }
                }
            }
        }
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1967285938")) {
            return !f92.d(this.lineitem) && !TextUtils.isEmpty(this.option);
        }
        return ((Boolean) ipChange.ipc$dispatch("-1967285938", new Object[]{this})).booleanValue();
    }
}

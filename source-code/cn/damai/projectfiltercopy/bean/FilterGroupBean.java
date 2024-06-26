package cn.damai.projectfiltercopy.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.e92;

/* compiled from: Taobao */
public class FilterGroupBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DATE_TYPE = "dateType";
    public static final String GROUP_ID = "groupId";
    public boolean isSingleSelected;
    public List<FilterBean> lineItem;
    public String name;
    public String option;

    public static List<FilterBean> extractFast(List<FilterGroupBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "289802658")) {
            return (List) ipChange.ipc$dispatch("289802658", new Object[]{list});
        } else if (e92.d(list)) {
            return null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (FilterGroupBean filterGroupBean : list) {
                String str = filterGroupBean.option;
                List<FilterBean> list2 = filterGroupBean.lineItem;
                if (!e92.d(list2)) {
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
        if (AndroidInstantRuntime.support(ipChange, "2100526853")) {
            ipChange.ipc$dispatch("2100526853", new Object[]{list});
        } else if (e92.f(list)) {
            for (FilterGroupBean filterGroupBean : list) {
                String str = filterGroupBean.option;
                List<FilterBean> list2 = filterGroupBean.lineItem;
                if (e92.f(list2)) {
                    for (FilterBean filterBean : list2) {
                        filterBean.option = str;
                    }
                }
            }
        }
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1326770819")) {
            return !e92.d(this.lineItem) && !TextUtils.isEmpty(this.option);
        }
        return ((Boolean) ipChange.ipc$dispatch("1326770819", new Object[]{this})).booleanValue();
    }
}

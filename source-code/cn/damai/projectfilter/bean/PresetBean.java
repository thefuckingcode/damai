package cn.damai.projectfilter.bean;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.calendar.bean.CalendarBean;
import cn.damai.tetris.v2.common.ContainerArg;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.f92;
import tb.lk1;
import tb.s41;

/* compiled from: Taobao */
public class PresetBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final List<String> SKIP_OVER_RIDE_KEYS;
    public String categoryId;
    public String dateType;
    public String firstLevelSelection;
    public String groupId;
    public String secondLevelSelection;
    public String sortType;

    static {
        ArrayList arrayList = new ArrayList();
        SKIP_OVER_RIDE_KEYS = arrayList;
        arrayList.add("categoryId");
        arrayList.add("groupId");
        arrayList.add("dateType");
        arrayList.add("sortType");
        arrayList.add("firstLevelSelection");
        arrayList.add("secondLevelSelection");
    }

    @NonNull
    public static PresetBean filterPresetFromArg(ContainerArg containerArg) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "776799287")) {
            return (PresetBean) ipChange.ipc$dispatch("776799287", new Object[]{containerArg});
        }
        PresetBean presetBean = null;
        if (containerArg != null) {
            try {
                if (!TextUtils.isEmpty(containerArg.args)) {
                    presetBean = (PresetBean) s41.a(containerArg.args, PresetBean.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return presetBean == null ? new PresetBean() : presetBean;
    }

    @Nullable
    public CalendarBean obtainPresetDate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1953382504")) {
            return (CalendarBean) ipChange.ipc$dispatch("1953382504", new Object[]{this});
        } else if (TextUtils.isEmpty(this.dateType)) {
            return null;
        } else {
            int j = lk1.j(this.dateType, -1);
            if (j == 0) {
                return CalendarBean.defaultAllTime();
            }
            if (j == 4) {
                return CalendarBean.to30Days();
            }
            if (j == 9) {
                return CalendarBean.friday2SunDay();
            }
            if (j != 10) {
                return null;
            }
            return CalendarBean.to7days();
        }
    }

    public FilterBean obtainPresetGroupId(List<FilterBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-642682468")) {
            return (FilterBean) ipChange.ipc$dispatch("-642682468", new Object[]{this, list});
        } else if (TextUtils.isEmpty(this.groupId) || !f92.g(list)) {
            return null;
        } else {
            for (FilterBean filterBean : list) {
                if (TextUtils.equals("groupId", filterBean.option) && TextUtils.equals(this.groupId, filterBean.value)) {
                    return filterBean;
                }
            }
            return null;
        }
    }

    @Nullable
    public SortBean obtainPresetSort(List<SortBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1832406568")) {
            return (SortBean) ipChange.ipc$dispatch("-1832406568", new Object[]{this, list});
        } else if (TextUtils.isEmpty(this.sortType) || !f92.g(list)) {
            return null;
        } else {
            for (SortBean sortBean : list) {
                if (TextUtils.equals(this.sortType, sortBean.value)) {
                    return sortBean;
                }
            }
            return null;
        }
    }
}

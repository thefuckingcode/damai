package cn.damai.projectfiltercopy.bean;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarBean;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.channel.params.PageArgument;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.e92;
import tb.jk1;
import tb.pn1;

/* compiled from: Taobao */
public class PresetBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final List<String> SKIP_OVER_RIDE_KEYS;
    public String dateType;
    public String firstLevelSelection;
    public String groupId;
    public String secondLevelSelection;
    public String sortType;

    static {
        ArrayList arrayList = new ArrayList();
        SKIP_OVER_RIDE_KEYS = arrayList;
        arrayList.add("groupId");
        arrayList.add("dateType");
        arrayList.add("sortType");
        arrayList.add("firstLevelSelection");
        arrayList.add("secondLevelSelection");
    }

    public static PresetBean presetFromBundle(Bundle bundle) {
        JSONObject parseArg2Json;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1946311707")) {
            return (PresetBean) ipChange.ipc$dispatch("1946311707", new Object[]{bundle});
        }
        PresetBean presetBean = new PresetBean();
        try {
            PageArgument b = pn1.INSTANCE.b(bundle);
            if (!(b == null || (parseArg2Json = b.parseArg2Json()) == null)) {
                presetBean.groupId = parseArg2Json.getString("groupId");
                presetBean.dateType = parseArg2Json.getString("dateType");
                presetBean.sortType = parseArg2Json.getString("sortType");
                presetBean.firstLevelSelection = parseArg2Json.getString("firstLevelSelection");
                presetBean.secondLevelSelection = parseArg2Json.getString("secondLevelSelection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return presetBean;
    }

    @Nullable
    public CalendarBean obtainPresetDate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-789039362")) {
            return (CalendarBean) ipChange.ipc$dispatch("-789039362", new Object[]{this});
        } else if (TextUtils.isEmpty(this.dateType)) {
            return null;
        } else {
            int e = jk1.e(this.dateType, -1);
            if (e == 0) {
                return CalendarBean.defaultAllTime();
            }
            if (e == 4) {
                return CalendarBean.to30Days();
            }
            if (e == 9) {
                return CalendarBean.friday2SunDay();
            }
            if (e != 10) {
                return null;
            }
            return CalendarBean.to7days();
        }
    }

    public FilterBean obtainPresetGroupId(List<FilterBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1399539260")) {
            return (FilterBean) ipChange.ipc$dispatch("1399539260", new Object[]{this, list});
        } else if (TextUtils.isEmpty(this.groupId) || !e92.f(list)) {
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
        if (AndroidInstantRuntime.support(ipChange, "-1552847058")) {
            return (SortBean) ipChange.ipc$dispatch("-1552847058", new Object[]{this, list});
        } else if (TextUtils.isEmpty(this.sortType) || !e92.f(list)) {
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

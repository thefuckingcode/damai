package cn.damai.projectfiltercopy.bean;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.e92;
import tb.jk1;
import tb.nl;
import tb.wm2;

/* compiled from: Taobao */
public class FilterReqParamBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId;
    public String comboDispatchId;
    public String dateType;
    public String endDate;
    public String firstLevelSelection;
    public String groupId;
    public String itemId;
    public List<Map<String, String>> optionParam = new ArrayList();
    public String secondLevelSelection;
    public List<String> skipOverrideKeyList;
    public String sortType;
    public String startDate;

    public void assembleFilter(HashMap<String, List<FilterBean>> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "650031830")) {
            ipChange.ipc$dispatch("650031830", new Object[]{this, hashMap});
        } else if (e92.g(hashMap)) {
            for (String str : hashMap.keySet()) {
                List<FilterBean> list = hashMap.get(str);
                StringBuilder sb = new StringBuilder();
                if (e92.f(list)) {
                    for (FilterBean filterBean : list) {
                        sb.append("|");
                        sb.append(filterBean.value);
                    }
                    sb.deleteCharAt(0);
                }
                if (sb.length() > 0) {
                    HashMap hashMap2 = new HashMap(1);
                    hashMap2.put(str, sb.toString());
                    this.optionParam.add(hashMap2);
                }
            }
        }
    }

    @NonNull
    public CategoryRequestNewParams createReqParams() {
        Double[] dMCoordinates;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1575186022")) {
            return (CategoryRequestNewParams) ipChange.ipc$dispatch("-1575186022", new Object[]{this});
        }
        CategoryRequestNewParams categoryRequestNewParams = new CategoryRequestNewParams();
        categoryRequestNewParams.dateType = jk1.e(this.dateType, 0);
        categoryRequestNewParams.startDate = this.startDate;
        categoryRequestNewParams.endDate = this.endDate;
        categoryRequestNewParams.firstLevelSelection = this.firstLevelSelection;
        categoryRequestNewParams.secondLevelSelection = this.secondLevelSelection;
        categoryRequestNewParams.currentCityId = this.cityId;
        categoryRequestNewParams.sortType = jk1.e(this.sortType, 10);
        if (e92.f(this.optionParam)) {
            categoryRequestNewParams.optionParam = wm2.INSTANCE.k(this.optionParam);
        } else {
            categoryRequestNewParams.optionParam = null;
        }
        categoryRequestNewParams.groupId = this.groupId;
        categoryRequestNewParams.itemId = this.itemId;
        categoryRequestNewParams.comboDispatchId = this.comboDispatchId;
        if (TextUtils.equals("4", this.sortType) && (dMCoordinates = nl.INSTANCE.a().getDMCoordinates()) != null) {
            categoryRequestNewParams.longitude = String.valueOf(dMCoordinates[0]);
            categoryRequestNewParams.latitude = String.valueOf(dMCoordinates[1]);
        }
        return categoryRequestNewParams;
    }
}

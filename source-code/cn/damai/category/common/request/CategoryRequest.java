package cn.damai.category.common.request;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.d20;

/* compiled from: Taobao */
public class CategoryRequest extends DMBaseMtopRequest implements Serializable, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 4326435736917912092L;
    public String apiVersion = "1.2";
    public String categoryId;
    public String channel = "10001";
    public String cityName;
    public int cityOption;
    public String currentCityId = d20.c();
    public int dateType;
    public String dmChannel = AppConfig.p();
    public String endDate;
    public String latitude;
    public String longitude;
    public int pageIndex = 1;
    public String pageSize = "15";
    public List<String> projectIdList = new ArrayList();
    public String returnItemOption = "4";
    public int sortType = 3;
    public String startDate;
    public String subcategoryId;
    public String userId = d20.E();

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1619816055")) {
            return "mtop.damai.wireless.search.project.classify";
        }
        return (String) ipChange.ipc$dispatch("1619816055", new Object[]{this});
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "51433110")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("51433110", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-897496686")) {
            return false;
        }
        return ((Boolean) ipChange.ipc$dispatch("-897496686", new Object[]{this})).booleanValue();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-507414518")) {
            return this.apiVersion;
        }
        return (String) ipChange.ipc$dispatch("-507414518", new Object[]{this});
    }

    @Override // java.lang.Object
    public CategoryRequest clone() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1342703731")) {
            return (CategoryRequest) ipChange.ipc$dispatch("-1342703731", new Object[]{this});
        }
        try {
            return (CategoryRequest) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}

package cn.damai.tetris.componentplugin.bean;

import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.Util;
import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.d20;

/* compiled from: Taobao */
public class CategoryRequestNewParams extends TetrisParams {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 912092;
    public String apiVersion = "1.2";
    public String categoryId;
    public String channel = "10001";
    public String cityId = d20.c();
    public String cityName;
    public int cityOption;
    public String comboDamaiCityId = d20.c();
    public String currentCityId = d20.c();
    public int dateType;
    public String dmChannel = AppConfig.p();
    public String endDate;
    public String firstLevelSelection;
    public String groupId;
    public String latitude;
    public String longitude;
    public String optionParam;
    public int pageIndex = 1;
    public String pageSize = "15";
    public List<String> projectIdList = new ArrayList();
    public String returnItemOption = "4";
    public String secondLevelSelection;
    public int sortType = 3;
    public String startDate;
    public String subcategoryId;

    public CategoryRequestNewParams() {
    }

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "989575822")) {
            return "category_drama_new";
        }
        return (String) ipChange.ipc$dispatch("989575822", new Object[]{this});
    }

    public CategoryRequestNewParams(int i, int i2, String str, String str2, int i3, String str3, int i4) {
        double[] dMCoordinates;
        this.cityOption = i;
        this.dateType = i2;
        this.startDate = str;
        this.endDate = str2;
        this.sortType = i3;
        this.pageIndex = i4;
        this.groupId = str3;
        if (i3 == 4 && (dMCoordinates = Util.getDMCoordinates()) != null) {
            this.longitude = String.valueOf(dMCoordinates[0]);
            this.latitude = String.valueOf(dMCoordinates[1]);
        }
    }
}

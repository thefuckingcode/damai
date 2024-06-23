package cn.damai.projectfiltercopy.bean;

import java.io.Serializable;
import tb.nl;

/* compiled from: Taobao */
public class CategoryRequestNewParams implements Serializable {
    private static final long serialVersionUID = 912092;
    public int cityOption;
    public String comboDispatchId;
    public String currentCityId = nl.INSTANCE.a().getCityId();
    public int dateType;
    public String endDate;
    public String firstLevelSelection;
    public String groupId;
    public String itemId;
    public String latitude;
    public String longitude;
    public String optionParam;
    public int pageIndex = 1;
    public String pageSize = "15";
    public String secondLevelSelection;
    public int sortType = 3;
    public String startDate;
}

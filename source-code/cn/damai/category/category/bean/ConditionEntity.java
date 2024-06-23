package cn.damai.category.category.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.d20;

/* compiled from: Taobao */
public class ConditionEntity implements Serializable {
    private static final long serialVersionUID = -919527383148736839L;
    public String currentCityId = d20.c();
    public int dateType;
    public String endDate;
    public String latitude;
    public String longitude;
    public List<String> projectIdList = new ArrayList();
    public int sortType = 3;
    public String startDate;
}

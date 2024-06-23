package cn.damai.homepage.show.request;

import cn.damai.tetris.request.TetrisParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.d20;

/* compiled from: Taobao */
public class ShowRequest extends TetrisParams implements Cloneable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 4326435736917912092L;
    public String apiVersion = "1.2";
    public String categoryId;
    public String channel = "10001";
    public String cityId = d20.c();
    public String cityName;
    public int cityOption;
    public String currentCityId = d20.c();
    public int dateType = 0;
    public String dmChannel;
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

    @Override // cn.damai.tetris.request.TetrisParams
    public String getPatternName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1105415030")) {
            return "category";
        }
        return (String) ipChange.ipc$dispatch("-1105415030", new Object[]{this});
    }
}

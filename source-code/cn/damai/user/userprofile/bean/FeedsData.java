package cn.damai.user.userprofile.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class FeedsData implements Serializable {
    public String circleId;
    public String circleName;
    public List<FeedMergeDataDO> feedMergeDataList;
    public String nextRow;
    public List<FeedProjectDO> projects;
}

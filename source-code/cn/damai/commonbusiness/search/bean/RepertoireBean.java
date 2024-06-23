package cn.damai.commonbusiness.search.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class RepertoireBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String artsDesc;
    public String backgroundPic;
    public long childRepertoireType;
    public String childRepertoireTypeName;
    public String focusComment;
    public int followStatus;
    public String repertoireId;
    public String repertoireName;
    public String repertoirePic;
    public storyPicsBean storyPics;
    public String summary;

    /* compiled from: Taobao */
    public static class storyPicsBean implements Serializable {
        public List<String> pics;
    }

    public boolean isFollowState() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-849033061")) {
            return this.followStatus != 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("-849033061", new Object[]{this})).booleanValue();
    }
}

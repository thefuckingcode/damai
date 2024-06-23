package cn.damai.issue.net;

import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class EvaluteSuccessRenderResponse implements Serializable {
    private static final long serialVersionUID = 1;
    public EvaSuccessActivityInfo activityInfo;
    public CommentSuccessInfo commentInfo;
    public CommentProjectDO projectDO;
    public DMShareMessage.YYMemberIntegrate vipScore;

    /* compiled from: Taobao */
    public static class CommentProjectDO implements Serializable {
        private static final long serialVersionUID = 1;
        public String cityName;
        public String itemScore;
        public String projectId;
        public String projectName;
        public String projectPoster;
        public String showTime;
    }

    /* compiled from: Taobao */
    public static class CommentSuccessInfo implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final long serialVersionUID = 1;
        public String userCommentTotal;

        public String getUserCommentTotal() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1521189620")) {
                return this.userCommentTotal;
            }
            return (String) ipChange.ipc$dispatch("1521189620", new Object[]{this});
        }
    }

    /* compiled from: Taobao */
    public static class EvaSuccessActivityInfo implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final long serialVersionUID = 1;
        public String activityDes;
        public String activityName;
        public String activityUrl;
        public String banner;
        public String popBanner;

        public String getActivityDes() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1411160119")) {
                return this.activityDes;
            }
            return (String) ipChange.ipc$dispatch("1411160119", new Object[]{this});
        }

        public String getActivityName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "498205884")) {
                return this.activityName;
            }
            return (String) ipChange.ipc$dispatch("498205884", new Object[]{this});
        }

        public String getActivityUrl() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1107064556")) {
                return this.activityUrl;
            }
            return (String) ipChange.ipc$dispatch("-1107064556", new Object[]{this});
        }

        public String getBanner() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1670895122")) {
                return this.banner;
            }
            return (String) ipChange.ipc$dispatch("-1670895122", new Object[]{this});
        }

        public String getPopBanner() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "34340817")) {
                return this.popBanner;
            }
            return (String) ipChange.ipc$dispatch("34340817", new Object[]{this});
        }
    }
}

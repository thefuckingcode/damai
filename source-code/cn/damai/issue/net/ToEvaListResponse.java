package cn.damai.issue.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class ToEvaListResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public String commentGiftIcon;
    public String commentGiftLink;
    public String hasMore;
    public String pagingKey;
    public List<EvaluateInfo> performCardInfoList;

    /* compiled from: Taobao */
    public static class EvaluateInfo implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final long serialVersionUID = 1;
        public long beginTime;
        public CommentInfo commentInfo;
        public String isDisplayComment;
        public String itemType;
        public String localeName;
        public String localeStoreName;
        public String performId;
        public String projectId;
        public String projectImage;
        public String projectName;
        public String storeId;
        public String ticketNum;
        public String timeTitle;
        public String venueName;

        public long getBeginTime() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-150315733")) {
                return this.beginTime;
            }
            return ((Long) ipChange.ipc$dispatch("-150315733", new Object[]{this})).longValue();
        }

        public CommentInfo getCommentInfo() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-197352101")) {
                return this.commentInfo;
            }
            return (CommentInfo) ipChange.ipc$dispatch("-197352101", new Object[]{this});
        }

        public String getIsDisplayComment() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "683957226")) {
                return this.isDisplayComment;
            }
            return (String) ipChange.ipc$dispatch("683957226", new Object[]{this});
        }

        public String getLocaleName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1627753448")) {
                return this.localeName;
            }
            return (String) ipChange.ipc$dispatch("1627753448", new Object[]{this});
        }

        public String getPerformId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "855197327")) {
                return this.performId;
            }
            return (String) ipChange.ipc$dispatch("855197327", new Object[]{this});
        }

        public String getProjectId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-496398265")) {
                return this.projectId;
            }
            return (String) ipChange.ipc$dispatch("-496398265", new Object[]{this});
        }

        public String getProjectImage() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1854653659")) {
                return this.projectImage;
            }
            return (String) ipChange.ipc$dispatch("-1854653659", new Object[]{this});
        }

        public String getProjectName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-226479753")) {
                return this.projectName;
            }
            return (String) ipChange.ipc$dispatch("-226479753", new Object[]{this});
        }

        public String getTicketNum() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1418273779")) {
                return this.ticketNum;
            }
            return (String) ipChange.ipc$dispatch("-1418273779", new Object[]{this});
        }

        public String getTimeTitle() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "639947838")) {
                return this.timeTitle;
            }
            return (String) ipChange.ipc$dispatch("639947838", new Object[]{this});
        }

        public String getVenueName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1145645261")) {
                return this.venueName;
            }
            return (String) ipChange.ipc$dispatch("1145645261", new Object[]{this});
        }

        public boolean isScriptmurderShop() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-465051927")) {
                return "1".equals(this.itemType);
            }
            return ((Boolean) ipChange.ipc$dispatch("-465051927", new Object[]{this})).booleanValue();
        }

        public void setLocaleName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1105833206")) {
                ipChange.ipc$dispatch("1105833206", new Object[]{this, str});
                return;
            }
            this.localeName = str;
        }

        public void setProjectId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-173681905")) {
                ipChange.ipc$dispatch("-173681905", new Object[]{this, str});
                return;
            }
            this.projectId = str;
        }

        public void setTicketNum(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1312948233")) {
                ipChange.ipc$dispatch("1312948233", new Object[]{this, str});
                return;
            }
            this.ticketNum = str;
        }
    }

    public String getHasMore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "129746419")) {
            return this.hasMore;
        }
        return (String) ipChange.ipc$dispatch("129746419", new Object[]{this});
    }

    public String getPagingKey() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1281722409")) {
            return this.pagingKey;
        }
        return (String) ipChange.ipc$dispatch("-1281722409", new Object[]{this});
    }

    public List<EvaluateInfo> getPerformCardInfoList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1257687576")) {
            return this.performCardInfoList;
        }
        return (List) ipChange.ipc$dispatch("-1257687576", new Object[]{this});
    }

    public void setHasMore(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1889081885")) {
            ipChange.ipc$dispatch("-1889081885", new Object[]{this, str});
            return;
        }
        this.hasMore = str;
    }

    public void setPagingKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251073407")) {
            ipChange.ipc$dispatch("1251073407", new Object[]{this, str});
            return;
        }
        this.pagingKey = str;
    }

    public void setPerformCardInfoList(List<EvaluateInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1582932348")) {
            ipChange.ipc$dispatch("1582932348", new Object[]{this, list});
            return;
        }
        this.performCardInfoList = list;
    }
}

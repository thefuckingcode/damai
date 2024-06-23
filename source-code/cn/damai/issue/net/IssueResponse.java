package cn.damai.issue.net;

import cn.damai.comment.bean.CommentGradeBean;
import cn.damai.comment.bean.CommentsVideoBean;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.StoreInfo;
import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
public class IssueResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    private boolean canEnterActivity;
    private CommentsDOBean commentsDO;
    private List<JSONObject> hotScriptInfoList;
    private UserDOBeanX userDO;

    /* compiled from: Taobao */
    public static class CommentsDOBean implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final long serialVersionUID = 1;
        private String commentId;
        private int commentType;
        private DmInfo dmInfo;
        private String gmtCreate;
        private long gmtCreateTime;
        private String gmtDisplay;
        private List<CommentGradeBean> gradeDOList;
        private boolean isOwner;
        private PraiseInfoBean praiseInfo;
        private int replyTotal;
        private StoreInfo storeInfo;
        private long targetId;
        private int targetType;
        private List<TextDOListBean> textDOList;
        private String url;
        private UserDOBean userDO;
        private CommentsVideoBean video;

        /* compiled from: Taobao */
        public static class PraiseInfoBean implements Serializable {
            private static transient /* synthetic */ IpChange $ipChange = null;
            private static final long serialVersionUID = 1;
            private boolean hasPraised;
            private int praiseCount;

            public int getPraiseCount() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-379404467")) {
                    return this.praiseCount;
                }
                return ((Integer) ipChange.ipc$dispatch("-379404467", new Object[]{this})).intValue();
            }

            public boolean isHasPraised() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-761964925")) {
                    return this.hasPraised;
                }
                return ((Boolean) ipChange.ipc$dispatch("-761964925", new Object[]{this})).booleanValue();
            }

            public void setHasPraised(boolean z) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1450329295")) {
                    ipChange.ipc$dispatch("-1450329295", new Object[]{this, Boolean.valueOf(z)});
                    return;
                }
                this.hasPraised = z;
            }

            public void setPraiseCount(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2043426909")) {
                    ipChange.ipc$dispatch("2043426909", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                this.praiseCount = i;
            }
        }

        /* compiled from: Taobao */
        public static class TextDOListBean implements Serializable {
            private static transient /* synthetic */ IpChange $ipChange = null;
            private static final long serialVersionUID = 1;
            private int type;
            private String value;

            public int getType() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1979668938")) {
                    return this.type;
                }
                return ((Integer) ipChange.ipc$dispatch("1979668938", new Object[]{this})).intValue();
            }

            public String getValue() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "1983713688")) {
                    return this.value;
                }
                return (String) ipChange.ipc$dispatch("1983713688", new Object[]{this});
            }

            public void setType(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1151644952")) {
                    ipChange.ipc$dispatch("1151644952", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                this.type = i;
            }

            public void setValue(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-438017570")) {
                    ipChange.ipc$dispatch("-438017570", new Object[]{this, str});
                    return;
                }
                this.value = str;
            }
        }

        /* compiled from: Taobao */
        public static class UserDOBean implements Serializable {
            private static transient /* synthetic */ IpChange $ipChange = null;
            private static final long serialVersionUID = 1;
            private String havanaIdStr;
            private String headerImage;
            private String nickname;
            public PerformFilmVipDO performFilmVipDO;
            public boolean vip;

            public String getHavanaIdStr() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "906849030")) {
                    return this.havanaIdStr;
                }
                return (String) ipChange.ipc$dispatch("906849030", new Object[]{this});
            }

            public String getHeaderImage() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "896521493")) {
                    return this.headerImage;
                }
                return (String) ipChange.ipc$dispatch("896521493", new Object[]{this});
            }

            public String getNickname() {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-2008090307")) {
                    return this.nickname;
                }
                return (String) ipChange.ipc$dispatch("-2008090307", new Object[]{this});
            }

            public void setHavanaIdStr(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "42564912")) {
                    ipChange.ipc$dispatch("42564912", new Object[]{this, str});
                    return;
                }
                this.havanaIdStr = str;
            }

            public void setHeaderImage(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-277588735")) {
                    ipChange.ipc$dispatch("-277588735", new Object[]{this, str});
                    return;
                }
                this.headerImage = str;
            }

            public void setNickname(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2003585215")) {
                    ipChange.ipc$dispatch("-2003585215", new Object[]{this, str});
                    return;
                }
                this.nickname = str;
            }
        }

        public String getCommentId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-936853205")) {
                return this.commentId;
            }
            return (String) ipChange.ipc$dispatch("-936853205", new Object[]{this});
        }

        public int getCommentType() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1732025033")) {
                return this.commentType;
            }
            return ((Integer) ipChange.ipc$dispatch("1732025033", new Object[]{this})).intValue();
        }

        public DmInfo getDmInfo() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1100891670")) {
                return this.dmInfo;
            }
            return (DmInfo) ipChange.ipc$dispatch("1100891670", new Object[]{this});
        }

        public String getGmtCreate() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-853743557")) {
                return this.gmtCreate;
            }
            return (String) ipChange.ipc$dispatch("-853743557", new Object[]{this});
        }

        public long getGmtCreateTime() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "464340204")) {
                return this.gmtCreateTime;
            }
            return ((Long) ipChange.ipc$dispatch("464340204", new Object[]{this})).longValue();
        }

        public String getGmtDisplay() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-196274023")) {
                return this.gmtDisplay;
            }
            return (String) ipChange.ipc$dispatch("-196274023", new Object[]{this});
        }

        public List<CommentGradeBean> getGradeDOList() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1255482088")) {
                return this.gradeDOList;
            }
            return (List) ipChange.ipc$dispatch("-1255482088", new Object[]{this});
        }

        public PraiseInfoBean getPraiseInfo() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "328467986")) {
                return this.praiseInfo;
            }
            return (PraiseInfoBean) ipChange.ipc$dispatch("328467986", new Object[]{this});
        }

        public int getReplyTotal() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1978189620")) {
                return this.replyTotal;
            }
            return ((Integer) ipChange.ipc$dispatch("1978189620", new Object[]{this})).intValue();
        }

        public StoreInfo getStoreInfo() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1255885898")) {
                return this.storeInfo;
            }
            return (StoreInfo) ipChange.ipc$dispatch("-1255885898", new Object[]{this});
        }

        public long getTargetId() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-174186653")) {
                return this.targetId;
            }
            return ((Long) ipChange.ipc$dispatch("-174186653", new Object[]{this})).longValue();
        }

        public int getTargetType() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1952418723")) {
                return this.targetType;
            }
            return ((Integer) ipChange.ipc$dispatch("1952418723", new Object[]{this})).intValue();
        }

        public List<TextDOListBean> getTextDOList() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "563941026")) {
                return this.textDOList;
            }
            return (List) ipChange.ipc$dispatch("563941026", new Object[]{this});
        }

        public String getUrl() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1171679936")) {
                return this.url;
            }
            return (String) ipChange.ipc$dispatch("1171679936", new Object[]{this});
        }

        public UserDOBean getUserDO() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "697787922")) {
                return this.userDO;
            }
            return (UserDOBean) ipChange.ipc$dispatch("697787922", new Object[]{this});
        }

        public CommentsVideoBean getVideo() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1552786146")) {
                return this.video;
            }
            return (CommentsVideoBean) ipChange.ipc$dispatch("1552786146", new Object[]{this});
        }

        public boolean isIsOwner() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "599080502")) {
                return this.isOwner;
            }
            return ((Boolean) ipChange.ipc$dispatch("599080502", new Object[]{this})).booleanValue();
        }

        public void setCommentId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-942883157")) {
                ipChange.ipc$dispatch("-942883157", new Object[]{this, str});
                return;
            }
            this.commentId = str;
        }

        public void setCommentType(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1221735327")) {
                ipChange.ipc$dispatch("-1221735327", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.commentType = i;
        }

        public void setDmInfo(DmInfo dmInfo2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1635712700")) {
                ipChange.ipc$dispatch("1635712700", new Object[]{this, dmInfo2});
                return;
            }
            this.dmInfo = dmInfo2;
        }

        public void setGmtCreate(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1633515931")) {
                ipChange.ipc$dispatch("1633515931", new Object[]{this, str});
                return;
            }
            this.gmtCreate = str;
        }

        public void setGmtCreateTime(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "898751808")) {
                ipChange.ipc$dispatch("898751808", new Object[]{this, Long.valueOf(j)});
                return;
            }
            this.gmtCreateTime = j;
        }

        public void setGmtDisplay(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "395556453")) {
                ipChange.ipc$dispatch("395556453", new Object[]{this, str});
                return;
            }
            this.gmtDisplay = str;
        }

        public void setGradeDOList(List<CommentGradeBean> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1324897204")) {
                ipChange.ipc$dispatch("-1324897204", new Object[]{this, list});
                return;
            }
            this.gradeDOList = list;
        }

        public void setIsOwner(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1354241698")) {
                ipChange.ipc$dispatch("1354241698", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            this.isOwner = z;
        }

        public void setPraiseInfo(PraiseInfoBean praiseInfoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "207192882")) {
                ipChange.ipc$dispatch("207192882", new Object[]{this, praiseInfoBean});
                return;
            }
            this.praiseInfo = praiseInfoBean;
        }

        public void setReplyTotal(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "254213102")) {
                ipChange.ipc$dispatch("254213102", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.replyTotal = i;
        }

        public void setStoreInfo(StoreInfo storeInfo2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1671316678")) {
                ipChange.ipc$dispatch("-1671316678", new Object[]{this, storeInfo2});
                return;
            }
            this.storeInfo = storeInfo2;
        }

        public void setTargetId(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-194035647")) {
                ipChange.ipc$dispatch("-194035647", new Object[]{this, Long.valueOf(j)});
                return;
            }
            this.targetId = j;
        }

        public void setTargetType(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-544684705")) {
                ipChange.ipc$dispatch("-544684705", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.targetType = i;
        }

        public void setTextDOList(List<TextDOListBean> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1325521514")) {
                ipChange.ipc$dispatch("1325521514", new Object[]{this, list});
                return;
            }
            this.textDOList = list;
        }

        public void setUrl(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-914079562")) {
                ipChange.ipc$dispatch("-914079562", new Object[]{this, str});
                return;
            }
            this.url = str;
        }

        public void setUserDO(UserDOBean userDOBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-768393062")) {
                ipChange.ipc$dispatch("-768393062", new Object[]{this, userDOBean});
                return;
            }
            this.userDO = userDOBean;
        }

        public void setVideo(CommentsVideoBean commentsVideoBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1294979454")) {
                ipChange.ipc$dispatch("1294979454", new Object[]{this, commentsVideoBean});
                return;
            }
            this.video = commentsVideoBean;
        }
    }

    /* compiled from: Taobao */
    public static class UserDOBeanX implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final long serialVersionUID = 1;
        private String havanaIdStr;
        private String headerImage;
        private String nickname;
        private PerformFilmVipDO performFilmVipDO;
        private boolean vip;
        private int vipLevel;
        private String vipLevelIcon;

        public String getHavanaIdStr() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1009040145")) {
                return this.havanaIdStr;
            }
            return (String) ipChange.ipc$dispatch("-1009040145", new Object[]{this});
        }

        public String getHeaderImage() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1019367682")) {
                return this.headerImage;
            }
            return (String) ipChange.ipc$dispatch("-1019367682", new Object[]{this});
        }

        public String getNickname() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1159426060")) {
                return this.nickname;
            }
            return (String) ipChange.ipc$dispatch("-1159426060", new Object[]{this});
        }

        public PerformFilmVipDO getPerformFilmVipDO() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1279868600")) {
                return this.performFilmVipDO;
            }
            return (PerformFilmVipDO) ipChange.ipc$dispatch("1279868600", new Object[]{this});
        }

        public int getVipLevel() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1117294970")) {
                return this.vipLevel;
            }
            return ((Integer) ipChange.ipc$dispatch("-1117294970", new Object[]{this})).intValue();
        }

        public String getVipLevelIcon() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2046519174")) {
                return this.vipLevelIcon;
            }
            return (String) ipChange.ipc$dispatch("2046519174", new Object[]{this});
        }

        public boolean isVip() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1272091807")) {
                return this.vip;
            }
            return ((Boolean) ipChange.ipc$dispatch("-1272091807", new Object[]{this})).booleanValue();
        }

        public void setHavanaIdStr(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "779542631")) {
                ipChange.ipc$dispatch("779542631", new Object[]{this, str});
                return;
            }
            this.havanaIdStr = str;
        }

        public void setHeaderImage(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "459388984")) {
                ipChange.ipc$dispatch("459388984", new Object[]{this, str});
                return;
            }
            this.headerImage = str;
        }

        public void setNickname(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1464797334")) {
                ipChange.ipc$dispatch("-1464797334", new Object[]{this, str});
                return;
            }
            this.nickname = str;
        }

        public void setPerformFilmVipDO(PerformFilmVipDO performFilmVipDO2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1274980836")) {
                ipChange.ipc$dispatch("1274980836", new Object[]{this, performFilmVipDO2});
                return;
            }
            this.performFilmVipDO = performFilmVipDO2;
        }

        public void setVip(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "82939253")) {
                ipChange.ipc$dispatch("82939253", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            this.vip = z;
        }

        public void setVipLevel(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "634376668")) {
                ipChange.ipc$dispatch("634376668", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            this.vipLevel = i;
        }

        public void setVipLevelIcon(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-584533992")) {
                ipChange.ipc$dispatch("-584533992", new Object[]{this, str});
                return;
            }
            this.vipLevelIcon = str;
        }
    }

    public CommentsDOBean getCommentsDO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1203768482")) {
            return this.commentsDO;
        }
        return (CommentsDOBean) ipChange.ipc$dispatch("-1203768482", new Object[]{this});
    }

    public List<JSONObject> getHotScriptInfoList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "117096905")) {
            return this.hotScriptInfoList;
        }
        return (List) ipChange.ipc$dispatch("117096905", new Object[]{this});
    }

    public UserDOBeanX getUserDO() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1266654578")) {
            return this.userDO;
        }
        return (UserDOBeanX) ipChange.ipc$dispatch("-1266654578", new Object[]{this});
    }

    public boolean isCanEnterActivity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1253424527")) {
            return this.canEnterActivity;
        }
        return ((Boolean) ipChange.ipc$dispatch("1253424527", new Object[]{this})).booleanValue();
    }

    public void setCanEnterActivity(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1773347985")) {
            ipChange.ipc$dispatch("-1773347985", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.canEnterActivity = z;
    }

    public void setCommentsDO(CommentsDOBean commentsDOBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1709532232")) {
            ipChange.ipc$dispatch("1709532232", new Object[]{this, commentsDOBean});
            return;
        }
        this.commentsDO = commentsDOBean;
    }

    public void setHotScriptInfoList(List<JSONObject> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "522396859")) {
            ipChange.ipc$dispatch("522396859", new Object[]{this, list});
            return;
        }
        this.hotScriptInfoList = list;
    }

    public void setUserDO(UserDOBeanX userDOBeanX) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1878240304")) {
            ipChange.ipc$dispatch("-1878240304", new Object[]{this, userDOBeanX});
            return;
        }
        this.userDO = userDOBeanX;
    }
}

package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class CommentsResultBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CommentsResultBean> CREATOR = new Parcelable.Creator<CommentsResultBean>() {
        /* class cn.damai.comment.bean.CommentsResultBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CommentsResultBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "255031403")) {
                return new CommentsResultBean(parcel);
            }
            return (CommentsResultBean) ipChange.ipc$dispatch("255031403", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CommentsResultBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "602842948")) {
                return new CommentsResultBean[i];
            }
            return (CommentsResultBean[]) ipChange.ipc$dispatch("602842948", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private CommentConfigBean config;
    private List<CommentContentLabelBean> contentLabelInfo;
    private String damaiCommentInfoUrl;
    private List<CommentsItemBean> data;
    private List<CommentsItemBean> hotComments;
    private String itemScore;
    private String itemScoreDesc;
    private int itemStar;
    private CommentsItemBean mainComment;
    private CommentPerformInfoBean performInfo;
    private CommentProjectInfoBean projectInfo;
    private CommentRepertoireInfoBean repertoireInfo;
    private List<CommentStatScoreBean> statScoreInfo;
    private int total;

    public CommentsResultBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1463005224")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1463005224", new Object[]{this})).intValue();
    }

    public CommentConfigBean getConfig() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1588560644")) {
            return this.config;
        }
        return (CommentConfigBean) ipChange.ipc$dispatch("-1588560644", new Object[]{this});
    }

    public List<CommentContentLabelBean> getContentLabelInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1007395718")) {
            return this.contentLabelInfo;
        }
        return (List) ipChange.ipc$dispatch("1007395718", new Object[]{this});
    }

    public String getDamaiCommentInfoUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1724048454")) {
            return this.damaiCommentInfoUrl;
        }
        return (String) ipChange.ipc$dispatch("-1724048454", new Object[]{this});
    }

    public List<CommentsItemBean> getData() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "662197287")) {
            return this.data;
        }
        return (List) ipChange.ipc$dispatch("662197287", new Object[]{this});
    }

    public List<CommentsItemBean> getHotComments() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2110609960")) {
            return this.hotComments;
        }
        return (List) ipChange.ipc$dispatch("2110609960", new Object[]{this});
    }

    public String getItemScore() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1761139807")) {
            return this.itemScore;
        }
        return (String) ipChange.ipc$dispatch("1761139807", new Object[]{this});
    }

    public String getItemScoreDesc() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1449042576")) {
            return this.itemScoreDesc;
        }
        return (String) ipChange.ipc$dispatch("1449042576", new Object[]{this});
    }

    public int getItemStar() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-143048360")) {
            return this.itemStar;
        }
        return ((Integer) ipChange.ipc$dispatch("-143048360", new Object[]{this})).intValue();
    }

    public CommentsItemBean getMainComment() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "59068384")) {
            return this.mainComment;
        }
        return (CommentsItemBean) ipChange.ipc$dispatch("59068384", new Object[]{this});
    }

    public CommentPerformInfoBean getPerformInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-587289824")) {
            return this.performInfo;
        }
        return (CommentPerformInfoBean) ipChange.ipc$dispatch("-587289824", new Object[]{this});
    }

    public CommentProjectInfoBean getProjectInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1659146720")) {
            return this.projectInfo;
        }
        return (CommentProjectInfoBean) ipChange.ipc$dispatch("-1659146720", new Object[]{this});
    }

    public CommentRepertoireInfoBean getRepertoireInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-61359754")) {
            return this.repertoireInfo;
        }
        return (CommentRepertoireInfoBean) ipChange.ipc$dispatch("-61359754", new Object[]{this});
    }

    public List<CommentStatScoreBean> getStatScoreInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-97605325")) {
            return this.statScoreInfo;
        }
        return (List) ipChange.ipc$dispatch("-97605325", new Object[]{this});
    }

    public int getTotal() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1144141231")) {
            return this.total;
        }
        return ((Integer) ipChange.ipc$dispatch("1144141231", new Object[]{this})).intValue();
    }

    public void setConfig(CommentConfigBean commentConfigBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "82481992")) {
            ipChange.ipc$dispatch("82481992", new Object[]{this, commentConfigBean});
            return;
        }
        this.config = commentConfigBean;
    }

    public void setContentLabelInfo(List<CommentContentLabelBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1342031098")) {
            ipChange.ipc$dispatch("-1342031098", new Object[]{this, list});
            return;
        }
        this.contentLabelInfo = list;
    }

    public void setDamaiCommentInfoUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-231205124")) {
            ipChange.ipc$dispatch("-231205124", new Object[]{this, str});
            return;
        }
        this.damaiCommentInfoUrl = str;
    }

    public void setData(List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1199821691")) {
            ipChange.ipc$dispatch("-1199821691", new Object[]{this, list});
            return;
        }
        this.data = list;
    }

    public void setHotComments(List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-55258820")) {
            ipChange.ipc$dispatch("-55258820", new Object[]{this, list});
            return;
        }
        this.hotComments = list;
    }

    public void setItemScore(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1090521591")) {
            ipChange.ipc$dispatch("1090521591", new Object[]{this, str});
            return;
        }
        this.itemScore = str;
    }

    public void setItemScoreDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "101983206")) {
            ipChange.ipc$dispatch("101983206", new Object[]{this, str});
            return;
        }
        this.itemScoreDesc = str;
    }

    public void setItemStar(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "771250506")) {
            ipChange.ipc$dispatch("771250506", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.itemStar = i;
    }

    public void setMainComment(CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1577350070")) {
            ipChange.ipc$dispatch("-1577350070", new Object[]{this, commentsItemBean});
            return;
        }
        this.mainComment = commentsItemBean;
    }

    public void setPerformInfo(CommentPerformInfoBean commentPerformInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "319364760")) {
            ipChange.ipc$dispatch("319364760", new Object[]{this, commentPerformInfoBean});
            return;
        }
        this.performInfo = commentPerformInfoBean;
    }

    public void setProjectInfo(CommentProjectInfoBean commentProjectInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1599747880")) {
            ipChange.ipc$dispatch("1599747880", new Object[]{this, commentProjectInfoBean});
            return;
        }
        this.projectInfo = commentProjectInfoBean;
    }

    public void setRepertoireInfo(CommentRepertoireInfoBean commentRepertoireInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1025002856")) {
            ipChange.ipc$dispatch("1025002856", new Object[]{this, commentRepertoireInfoBean});
            return;
        }
        this.repertoireInfo = commentRepertoireInfoBean;
    }

    public void setStatScoreInfo(List<CommentStatScoreBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-125202287")) {
            ipChange.ipc$dispatch("-125202287", new Object[]{this, list});
            return;
        }
        this.statScoreInfo = list;
    }

    public void setTotal(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1637305029")) {
            ipChange.ipc$dispatch("-1637305029", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.total = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1847500787")) {
            ipChange.ipc$dispatch("1847500787", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeTypedList(this.data);
        parcel.writeTypedList(this.hotComments);
        parcel.writeTypedList(this.contentLabelInfo);
        parcel.writeTypedList(this.statScoreInfo);
        parcel.writeParcelable(this.mainComment, i);
        parcel.writeParcelable(this.config, i);
        parcel.writeInt(this.total);
        parcel.writeParcelable(this.projectInfo, i);
        parcel.writeParcelable(this.repertoireInfo, i);
        parcel.writeParcelable(this.performInfo, i);
    }

    protected CommentsResultBean(Parcel parcel) {
        Parcelable.Creator<CommentsItemBean> creator = CommentsItemBean.CREATOR;
        this.data = parcel.createTypedArrayList(creator);
        this.hotComments = parcel.createTypedArrayList(creator);
        this.contentLabelInfo = parcel.createTypedArrayList(CommentContentLabelBean.CREATOR);
        this.statScoreInfo = parcel.createTypedArrayList(CommentStatScoreBean.CREATOR);
        this.mainComment = (CommentsItemBean) parcel.readParcelable(CommentsItemBean.class.getClassLoader());
        this.config = (CommentConfigBean) parcel.readParcelable(CommentConfigBean.class.getClassLoader());
        this.total = parcel.readInt();
        this.projectInfo = (CommentProjectInfoBean) parcel.readParcelable(CommentProjectInfoBean.class.getClassLoader());
        this.repertoireInfo = (CommentRepertoireInfoBean) parcel.readParcelable(CommentRepertoireInfoBean.class.getClassLoader());
        this.performInfo = (CommentPerformInfoBean) parcel.readParcelable(CommentPerformInfoBean.class.getClassLoader());
    }
}

package cn.damai.issue.net;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.comment.bean.DmInfo;
import cn.damai.comment.bean.StoreInfo;
import cn.damai.commonbusiness.scriptmurder.bean.ScriptBean;
import cn.damai.tetris.component.brand.bean.ProjectDO;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class IssueRenderResponse implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<IssueRenderResponse> CREATOR = new Parcelable.Creator<IssueRenderResponse>() {
        /* class cn.damai.issue.net.IssueRenderResponse.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public IssueRenderResponse createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "663607723")) {
                return new IssueRenderResponse(parcel);
            }
            return (IssueRenderResponse) ipChange.ipc$dispatch("663607723", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public IssueRenderResponse[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1771136556")) {
                return new IssueRenderResponse[i];
            }
            return (IssueRenderResponse[]) ipChange.ipc$dispatch("-1771136556", new Object[]{this, Integer.valueOf(i)});
        }
    };
    List<String> IconTitle;
    public String associatedScriptNum;
    public String associatedStoreNum;
    private List<String> categoryTags;
    private ArrayList<CommentGradeText> commentGradeTexts;
    List<DmInfo> dmInfoList;
    private List<CommentGradeTagBean> gradeTags;
    String itemType;
    private NoticeInfo noticeInfo;
    public ProjectDO projectDO;
    public ScriptBean scriptInfo;
    StoreInfo storeInfo;

    public IssueRenderResponse() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "55281872")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("55281872", new Object[]{this})).intValue();
    }

    public List<String> getCategoryTags() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-239624852")) {
            return this.categoryTags;
        }
        return (List) ipChange.ipc$dispatch("-239624852", new Object[]{this});
    }

    public ArrayList<CommentGradeText> getCommentGradeTexts() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "967365892")) {
            return this.commentGradeTexts;
        }
        return (ArrayList) ipChange.ipc$dispatch("967365892", new Object[]{this});
    }

    public List<DmInfo> getDmInfoList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1035770506")) {
            return this.dmInfoList;
        }
        return (List) ipChange.ipc$dispatch("1035770506", new Object[]{this});
    }

    public List<CommentGradeTagBean> getGradeTags() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-908065")) {
            return this.gradeTags;
        }
        return (List) ipChange.ipc$dispatch("-908065", new Object[]{this});
    }

    public List<String> getIconTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1150589970")) {
            return this.IconTitle;
        }
        return (List) ipChange.ipc$dispatch("-1150589970", new Object[]{this});
    }

    public String getItemType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1539468357")) {
            return this.itemType;
        }
        return (String) ipChange.ipc$dispatch("-1539468357", new Object[]{this});
    }

    public NoticeInfo getNoticeInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "415739700")) {
            return this.noticeInfo;
        }
        return (NoticeInfo) ipChange.ipc$dispatch("415739700", new Object[]{this});
    }

    public StoreInfo getStoreInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "45575295")) {
            return this.storeInfo;
        }
        return (StoreInfo) ipChange.ipc$dispatch("45575295", new Object[]{this});
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1208429876")) {
            ipChange.ipc$dispatch("1208429876", new Object[]{this, parcel});
            return;
        }
        this.categoryTags = parcel.createStringArrayList();
        this.gradeTags = parcel.createTypedArrayList(CommentGradeTagBean.CREATOR);
        this.noticeInfo = (NoticeInfo) parcel.readParcelable(NoticeInfo.class.getClassLoader());
        this.commentGradeTexts = parcel.createTypedArrayList(CommentGradeText.CREATOR);
        this.itemType = (String) parcel.readValue(String.class.getClassLoader());
        this.storeInfo = (StoreInfo) parcel.readSerializable();
        ArrayList arrayList = new ArrayList();
        this.dmInfoList = arrayList;
        parcel.readList(arrayList, DmInfo.class.getClassLoader());
        this.IconTitle = parcel.createStringArrayList();
    }

    public void setCategoryTags(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42772512")) {
            ipChange.ipc$dispatch("-42772512", new Object[]{this, list});
            return;
        }
        this.categoryTags = list;
    }

    public void setCommentGradeTexts(ArrayList<CommentGradeText> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1201782324")) {
            ipChange.ipc$dispatch("1201782324", new Object[]{this, arrayList});
            return;
        }
        this.commentGradeTexts = arrayList;
    }

    public void setDmInfoList(List<DmInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1227633790")) {
            ipChange.ipc$dispatch("-1227633790", new Object[]{this, list});
            return;
        }
        this.dmInfoList = list;
    }

    public void setGradeTags(List<CommentGradeTagBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738856859")) {
            ipChange.ipc$dispatch("-738856859", new Object[]{this, list});
            return;
        }
        this.gradeTags = list;
    }

    public void setIconTitle(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2019257546")) {
            ipChange.ipc$dispatch("-2019257546", new Object[]{this, list});
            return;
        }
        this.IconTitle = list;
    }

    public void setItemType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-361206653")) {
            ipChange.ipc$dispatch("-361206653", new Object[]{this, str});
            return;
        }
        this.itemType = str;
    }

    public void setNoticeInfo(NoticeInfo noticeInfo2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-34834824")) {
            ipChange.ipc$dispatch("-34834824", new Object[]{this, noticeInfo2});
            return;
        }
        this.noticeInfo = noticeInfo2;
    }

    public void setStoreInfo(StoreInfo storeInfo2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "19274641")) {
            ipChange.ipc$dispatch("19274641", new Object[]{this, storeInfo2});
            return;
        }
        this.storeInfo = storeInfo2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-666274309")) {
            ipChange.ipc$dispatch("-666274309", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeStringList(this.categoryTags);
        parcel.writeTypedList(this.gradeTags);
        parcel.writeParcelable(this.noticeInfo, i);
        parcel.writeTypedList(this.commentGradeTexts);
        parcel.writeValue(this.itemType);
        parcel.writeSerializable(this.storeInfo);
        parcel.writeList(this.dmInfoList);
        parcel.writeStringList(this.IconTitle);
    }

    protected IssueRenderResponse(Parcel parcel) {
        this.categoryTags = parcel.createStringArrayList();
        this.gradeTags = parcel.createTypedArrayList(CommentGradeTagBean.CREATOR);
        this.noticeInfo = (NoticeInfo) parcel.readParcelable(NoticeInfo.class.getClassLoader());
        this.commentGradeTexts = parcel.createTypedArrayList(CommentGradeText.CREATOR);
        this.itemType = (String) parcel.readValue(String.class.getClassLoader());
        this.storeInfo = (StoreInfo) parcel.readSerializable();
        ArrayList arrayList = new ArrayList();
        this.dmInfoList = arrayList;
        parcel.readList(arrayList, DmInfo.class.getClassLoader());
        this.IconTitle = parcel.createStringArrayList();
    }
}

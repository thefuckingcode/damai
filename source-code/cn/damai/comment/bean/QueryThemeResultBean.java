package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class QueryThemeResultBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<QueryThemeResultBean> CREATOR = new Parcelable.Creator<QueryThemeResultBean>() {
        /* class cn.damai.comment.bean.QueryThemeResultBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public QueryThemeResultBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-582527477")) {
                return new QueryThemeResultBean(parcel);
            }
            return (QueryThemeResultBean) ipChange.ipc$dispatch("-582527477", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public QueryThemeResultBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1077753302")) {
                return new QueryThemeResultBean[i];
            }
            return (QueryThemeResultBean[]) ipChange.ipc$dispatch("-1077753302", new Object[]{this, Integer.valueOf(i)});
        }
    };
    List<String> IconTitle;
    List<QueryThemeCliqueInfoBean> cliqueInfos;
    Long themeId;
    String themeName;

    public QueryThemeResultBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2081224763")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-2081224763", new Object[]{this})).intValue();
    }

    public List<QueryThemeCliqueInfoBean> getCliqueInfos() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-313994338")) {
            return this.cliqueInfos;
        }
        return (List) ipChange.ipc$dispatch("-313994338", new Object[]{this});
    }

    public List<String> getIconTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-389256743")) {
            return this.IconTitle;
        }
        return (List) ipChange.ipc$dispatch("-389256743", new Object[]{this});
    }

    public Long getThemeId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-276948276")) {
            return this.themeId;
        }
        return (Long) ipChange.ipc$dispatch("-276948276", new Object[]{this});
    }

    public String getThemeName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1838895559")) {
            return this.themeName;
        }
        return (String) ipChange.ipc$dispatch("1838895559", new Object[]{this});
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925423327")) {
            ipChange.ipc$dispatch("925423327", new Object[]{this, parcel});
            return;
        }
        this.themeId = (Long) parcel.readValue(Long.class.getClassLoader());
        this.themeName = parcel.readString();
        this.cliqueInfos = parcel.createTypedArrayList(QueryThemeCliqueInfoBean.CREATOR);
        this.IconTitle = parcel.createStringArrayList();
    }

    public void setCliqueInfos(List<QueryThemeCliqueInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091419270")) {
            ipChange.ipc$dispatch("2091419270", new Object[]{this, list});
            return;
        }
        this.cliqueInfos = list;
    }

    public void setIconTitle(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "107236011")) {
            ipChange.ipc$dispatch("107236011", new Object[]{this, list});
            return;
        }
        this.IconTitle = list;
    }

    public void setThemeId(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-506789004")) {
            ipChange.ipc$dispatch("-506789004", new Object[]{this, l});
            return;
        }
        this.themeId = l;
    }

    public void setThemeName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-794017393")) {
            ipChange.ipc$dispatch("-794017393", new Object[]{this, str});
            return;
        }
        this.themeName = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-949280858")) {
            ipChange.ipc$dispatch("-949280858", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeValue(this.themeId);
        parcel.writeString(this.themeName);
        parcel.writeTypedList(this.cliqueInfos);
        parcel.writeStringList(this.IconTitle);
    }

    protected QueryThemeResultBean(Parcel parcel) {
        this.themeId = (Long) parcel.readValue(Long.class.getClassLoader());
        this.themeName = parcel.readString();
        this.cliqueInfos = parcel.createTypedArrayList(QueryThemeCliqueInfoBean.CREATOR);
        this.IconTitle = parcel.createStringArrayList();
    }
}

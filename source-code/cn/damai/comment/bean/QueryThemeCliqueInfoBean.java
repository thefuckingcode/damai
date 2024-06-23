package cn.damai.comment.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
public class QueryThemeCliqueInfoBean implements Parcelable, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<QueryThemeCliqueInfoBean> CREATOR = new Parcelable.Creator<QueryThemeCliqueInfoBean>() {
        /* class cn.damai.comment.bean.QueryThemeCliqueInfoBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public QueryThemeCliqueInfoBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1186160949")) {
                return new QueryThemeCliqueInfoBean(parcel);
            }
            return (QueryThemeCliqueInfoBean) ipChange.ipc$dispatch("-1186160949", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public QueryThemeCliqueInfoBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-183744634")) {
                return new QueryThemeCliqueInfoBean[i];
            }
            return (QueryThemeCliqueInfoBean[]) ipChange.ipc$dispatch("-183744634", new Object[]{this, Integer.valueOf(i)});
        }
    };
    long id;
    String name;

    public QueryThemeCliqueInfoBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1216686441")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1216686441", new Object[]{this})).intValue();
    }

    public boolean equals(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1333767670")) {
            return ((Boolean) ipChange.ipc$dispatch("-1333767670", new Object[]{this, obj})).booleanValue();
        } else if (!(obj instanceof QueryThemeCliqueInfoBean) || this.id != ((QueryThemeCliqueInfoBean) obj).id) {
            return false;
        } else {
            return true;
        }
    }

    public long getId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1603537180")) {
            return this.id;
        }
        return ((Long) ipChange.ipc$dispatch("-1603537180", new Object[]{this})).longValue();
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1942608224")) {
            return this.name;
        }
        return (String) ipChange.ipc$dispatch("-1942608224", new Object[]{this});
    }

    public void readFromParcel(Parcel parcel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1176651341")) {
            ipChange.ipc$dispatch("1176651341", new Object[]{this, parcel});
            return;
        }
        this.id = parcel.readLong();
        this.name = parcel.readString();
    }

    public void setId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1615368672")) {
            ipChange.ipc$dispatch("1615368672", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.id = j;
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-384069570")) {
            ipChange.ipc$dispatch("-384069570", new Object[]{this, str});
            return;
        }
        this.name = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-698052844")) {
            ipChange.ipc$dispatch("-698052844", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
    }

    protected QueryThemeCliqueInfoBean(Parcel parcel) {
        this.id = parcel.readLong();
        this.name = parcel.readString();
    }
}

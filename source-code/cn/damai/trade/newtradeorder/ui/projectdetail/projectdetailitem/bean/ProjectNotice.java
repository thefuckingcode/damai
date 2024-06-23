package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class ProjectNotice implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectNotice> CREATOR = new Parcelable.Creator<ProjectNotice>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectNotice.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ProjectNotice createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-271181653")) {
                return new ProjectNotice(parcel);
            }
            return (ProjectNotice) ipChange.ipc$dispatch("-271181653", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ProjectNotice[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "483229692")) {
                return new ProjectNotice[i];
            }
            return (ProjectNotice[]) ipChange.ipc$dispatch("483229692", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String content;
    public String imageUrl;
    public String name;

    public ProjectNotice() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-156795972")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-156795972", new Object[]{this})).intValue();
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "931213230")) {
            return !TextUtils.isEmpty(this.content);
        }
        return ((Boolean) ipChange.ipc$dispatch("931213230", new Object[]{this})).booleanValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-997443441")) {
            ipChange.ipc$dispatch("-997443441", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.name);
        parcel.writeString(this.content);
        parcel.writeString(this.imageUrl);
    }

    protected ProjectNotice(Parcel parcel) {
        this.name = parcel.readString();
        this.content = parcel.readString();
        this.imageUrl = parcel.readString();
    }
}

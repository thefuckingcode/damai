package cn.damai.homepage.bean;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.lk1;

/* compiled from: Taobao */
public class TabExtra implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<TabExtra> CREATOR = new Parcelable.Creator<TabExtra>() {
        /* class cn.damai.homepage.bean.TabExtra.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public TabExtra createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-534437093")) {
                return new TabExtra(parcel);
            }
            return (TabExtra) ipChange.ipc$dispatch("-534437093", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public TabExtra[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1763351888")) {
                return new TabExtra[i];
            }
            return (TabExtra[]) ipChange.ipc$dispatch("1763351888", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String categoryId;
    public String groupId;
    public int type;

    public TabExtra(String str, String str2, String str3) {
        this.type = lk1.j(str, -1);
        this.categoryId = str2;
        this.groupId = str3;
    }

    public static TabExtra fromIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1292410171")) {
            return new TabExtra(intent.getStringExtra("type"), intent.getStringExtra("id"), intent.getStringExtra("groupId"));
        }
        return (TabExtra) ipChange.ipc$dispatch("-1292410171", new Object[]{intent});
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "535061471")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("535061471", new Object[]{this})).intValue();
    }

    public boolean isValidExtra() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1913874455")) {
            return this.type >= 0;
        }
        return ((Boolean) ipChange.ipc$dispatch("1913874455", new Object[]{this})).booleanValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-810665268")) {
            ipChange.ipc$dispatch("-810665268", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.type);
        parcel.writeString(this.categoryId);
        parcel.writeString(this.groupId);
    }

    protected TabExtra(Parcel parcel) {
        this.type = parcel.readInt();
        this.categoryId = parcel.readString();
        this.groupId = parcel.readString();
    }

    public TabExtra() {
    }
}

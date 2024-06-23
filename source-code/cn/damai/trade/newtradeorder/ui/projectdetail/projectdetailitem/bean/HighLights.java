package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class HighLights implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<HighLights> CREATOR = new Parcelable.Creator<HighLights>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.HighLights.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public HighLights createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1822863765")) {
                return new HighLights(parcel);
            }
            return (HighLights) ipChange.ipc$dispatch("1822863765", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public HighLights[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-2049804560")) {
                return new HighLights[i];
            }
            return (HighLights[]) ipChange.ipc$dispatch("-2049804560", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private List<String> content;
    private String title;

    public HighLights() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1173384610")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1173384610", new Object[]{this})).intValue();
    }

    public List<String> getContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1261385526")) {
            return this.content;
        }
        return (List) ipChange.ipc$dispatch("1261385526", new Object[]{this});
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-991876882")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("-991876882", new Object[]{this});
    }

    public void setContent(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-449807378")) {
            ipChange.ipc$dispatch("-449807378", new Object[]{this, list});
            return;
        }
        this.content = list;
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807955272")) {
            ipChange.ipc$dispatch("1807955272", new Object[]{this, str});
            return;
        }
        this.title = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-550203543")) {
            ipChange.ipc$dispatch("-550203543", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.title);
        parcel.writeStringList(this.content);
    }

    protected HighLights(Parcel parcel) {
        this.title = parcel.readString();
        this.content = parcel.createStringArrayList();
    }
}

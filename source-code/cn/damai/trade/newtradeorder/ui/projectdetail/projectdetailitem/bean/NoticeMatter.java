package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.commonbusiness.servicenotice.TicketNoteList;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class NoticeMatter implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<NoticeMatter> CREATOR = new Parcelable.Creator<NoticeMatter>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.NoticeMatter.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public NoticeMatter createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1855811295")) {
                return new NoticeMatter(parcel);
            }
            return (NoticeMatter) ipChange.ipc$dispatch("-1855811295", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public NoticeMatter[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1569711408")) {
                return new NoticeMatter[i];
            }
            return (NoticeMatter[]) ipChange.ipc$dispatch("1569711408", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private List<TicketNoteList> noticeList;
    private String title;

    public NoticeMatter() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1746752388")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1746752388", new Object[]{this})).intValue();
    }

    public List<TicketNoteList> getNoticeList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1926835337")) {
            return this.noticeList;
        }
        return (List) ipChange.ipc$dispatch("-1926835337", new Object[]{this});
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1394540372")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("1394540372", new Object[]{this});
    }

    public void setNoticeList(List<TicketNoteList> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1420865589")) {
            ipChange.ipc$dispatch("1420865589", new Object[]{this, list});
            return;
        }
        this.noticeList = list;
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1522521182")) {
            ipChange.ipc$dispatch("-1522521182", new Object[]{this, str});
            return;
        }
        this.title = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "679518159")) {
            ipChange.ipc$dispatch("679518159", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.title);
        parcel.writeTypedList(this.noticeList);
    }

    protected NoticeMatter(Parcel parcel) {
        this.title = parcel.readString();
        this.noticeList = parcel.createTypedArrayList(TicketNoteList.CREATOR);
    }
}

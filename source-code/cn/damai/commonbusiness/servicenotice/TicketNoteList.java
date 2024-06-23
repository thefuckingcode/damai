package cn.damai.commonbusiness.servicenotice;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class TicketNoteList implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<TicketNoteList> CREATOR = new a();
    private String noteTitle;
    private List<TicketNote> ticketNoteList;

    /* compiled from: Taobao */
    public class a implements Parcelable.Creator<TicketNoteList> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        /* renamed from: a */
        public TicketNoteList createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "370734379")) {
                return new TicketNoteList(parcel);
            }
            return (TicketNoteList) ipChange.ipc$dispatch("370734379", new Object[]{this, parcel});
        }

        /* renamed from: b */
        public TicketNoteList[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1732070368")) {
                return new TicketNoteList[i];
            }
            return (TicketNoteList[]) ipChange.ipc$dispatch("1732070368", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public TicketNoteList() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-547024502")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-547024502", new Object[]{this})).intValue();
    }

    public String getNoteTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "169272500")) {
            return this.noteTitle;
        }
        return (String) ipChange.ipc$dispatch("169272500", new Object[]{this});
    }

    public List<TicketNote> getTicketNoteList() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1216338229")) {
            return this.ticketNoteList;
        }
        return (List) ipChange.ipc$dispatch("-1216338229", new Object[]{this});
    }

    public void setNoteTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1012724670")) {
            ipChange.ipc$dispatch("-1012724670", new Object[]{this, str});
            return;
        }
        this.noteTitle = str;
    }

    public void setTicketNoteList(List<TicketNote> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043318943")) {
            ipChange.ipc$dispatch("-2043318943", new Object[]{this, list});
            return;
        }
        this.ticketNoteList = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-479250303")) {
            ipChange.ipc$dispatch("-479250303", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.noteTitle);
        parcel.writeTypedList(this.ticketNoteList);
    }

    protected TicketNoteList(Parcel parcel) {
        this.noteTitle = parcel.readString();
        this.ticketNoteList = parcel.createTypedArrayList(TicketNote.CREATOR);
    }
}

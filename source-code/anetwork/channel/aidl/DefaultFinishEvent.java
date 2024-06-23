package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.request.a;
import anet.channel.statist.RequestStatistic;
import anetwork.channel.NetworkEvent$FinishEvent;
import anetwork.channel.statist.StatisticData;
import tb.fe0;
import tb.jl1;

/* compiled from: Taobao */
public class DefaultFinishEvent implements Parcelable, NetworkEvent$FinishEvent {
    public static final Parcelable.Creator<DefaultFinishEvent> CREATOR = new Parcelable.Creator<DefaultFinishEvent>() {
        /* class anetwork.channel.aidl.DefaultFinishEvent.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public DefaultFinishEvent createFromParcel(Parcel parcel) {
            return DefaultFinishEvent.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DefaultFinishEvent[] newArray(int i) {
            return new DefaultFinishEvent[i];
        }
    };
    int code;
    Object context;
    String desc;
    public final a request;
    public final RequestStatistic rs;
    StatisticData statisticData;

    public DefaultFinishEvent(int i) {
        this(i, null, null, null);
    }

    static DefaultFinishEvent readFromParcel(Parcel parcel) {
        DefaultFinishEvent defaultFinishEvent = new DefaultFinishEvent(0);
        try {
            defaultFinishEvent.code = parcel.readInt();
            defaultFinishEvent.desc = parcel.readString();
            defaultFinishEvent.statisticData = (StatisticData) parcel.readSerializable();
        } catch (Throwable unused) {
        }
        return defaultFinishEvent;
    }

    public int describeContents() {
        return 0;
    }

    public Object getContext() {
        return this.context;
    }

    @Override // anetwork.channel.NetworkEvent$FinishEvent
    public String getDesc() {
        return this.desc;
    }

    @Override // anetwork.channel.NetworkEvent$FinishEvent
    public int getHttpCode() {
        return this.code;
    }

    @Override // anetwork.channel.NetworkEvent$FinishEvent
    public StatisticData getStatisticData() {
        return this.statisticData;
    }

    public void setContext(Object obj) {
        this.context = obj;
    }

    public String toString() {
        return "DefaultFinishEvent [" + "code=" + this.code + ", desc=" + this.desc + ", context=" + this.context + ", statisticData=" + this.statisticData + jl1.ARRAY_END_STR;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.code);
        parcel.writeString(this.desc);
        StatisticData statisticData2 = this.statisticData;
        if (statisticData2 != null) {
            parcel.writeSerializable(statisticData2);
        }
    }

    public DefaultFinishEvent(int i, String str, RequestStatistic requestStatistic) {
        this(i, str, null, requestStatistic);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultFinishEvent(int i, String str, a aVar) {
        this(i, str, aVar, aVar != null ? aVar.r : null);
    }

    private DefaultFinishEvent(int i, String str, a aVar, RequestStatistic requestStatistic) {
        this.statisticData = new StatisticData();
        this.code = i;
        this.desc = str == null ? fe0.b(i) : str;
        this.request = aVar;
        this.rs = requestStatistic;
    }
}

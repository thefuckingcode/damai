package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.util.ALog;
import anetwork.channel.Response;
import anetwork.channel.statist.StatisticData;
import java.util.List;
import java.util.Map;
import tb.fe0;
import tb.jl1;

/* compiled from: Taobao */
public class NetworkResponse implements Parcelable, Response {
    public static final Parcelable.Creator<NetworkResponse> CREATOR = new Parcelable.Creator<NetworkResponse>() {
        /* class anetwork.channel.aidl.NetworkResponse.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public NetworkResponse createFromParcel(Parcel parcel) {
            return NetworkResponse.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public NetworkResponse[] newArray(int i) {
            return new NetworkResponse[i];
        }
    };
    private static final String TAG = "anet.NetworkResponse";
    byte[] bytedata;
    private Map<String, List<String>> connHeadFields;
    private String desc;
    private Throwable error;
    private StatisticData statisticData;
    int statusCode;

    public NetworkResponse() {
    }

    public static NetworkResponse readFromParcel(Parcel parcel) {
        NetworkResponse networkResponse = new NetworkResponse();
        try {
            networkResponse.statusCode = parcel.readInt();
            networkResponse.desc = parcel.readString();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                networkResponse.bytedata = bArr;
                parcel.readByteArray(bArr);
            }
            networkResponse.connHeadFields = parcel.readHashMap(NetworkResponse.class.getClassLoader());
            try {
                networkResponse.statisticData = (StatisticData) parcel.readSerializable();
            } catch (Throwable unused) {
                ALog.f(TAG, "[readFromParcel] source.readSerializable() error", null, new Object[0]);
            }
        } catch (Exception e) {
            ALog.j(TAG, "[readFromParcel]", null, e, new Object[0]);
        }
        return networkResponse;
    }

    public int describeContents() {
        return 0;
    }

    @Override // anetwork.channel.Response
    public byte[] getBytedata() {
        return this.bytedata;
    }

    @Override // anetwork.channel.Response
    public Map<String, List<String>> getConnHeadFields() {
        return this.connHeadFields;
    }

    @Override // anetwork.channel.Response
    public String getDesc() {
        return this.desc;
    }

    @Override // anetwork.channel.Response
    public Throwable getError() {
        return this.error;
    }

    @Override // anetwork.channel.Response
    public StatisticData getStatisticData() {
        return this.statisticData;
    }

    @Override // anetwork.channel.Response
    public int getStatusCode() {
        return this.statusCode;
    }

    public void setBytedata(byte[] bArr) {
        this.bytedata = bArr;
    }

    public void setConnHeadFields(Map<String, List<String>> map) {
        this.connHeadFields = map;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setError(Throwable th) {
        this.error = th;
    }

    public void setStatisticData(StatisticData statisticData2) {
        this.statisticData = statisticData2;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
        this.desc = fe0.b(i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NetworkResponse [");
        sb.append("statusCode=");
        sb.append(this.statusCode);
        sb.append(", desc=");
        sb.append(this.desc);
        sb.append(", connHeadFields=");
        sb.append(this.connHeadFields);
        sb.append(", bytedata=");
        byte[] bArr = this.bytedata;
        sb.append(bArr != null ? new String(bArr) : "");
        sb.append(", error=");
        sb.append(this.error);
        sb.append(", statisticData=");
        sb.append(this.statisticData);
        sb.append(jl1.ARRAY_END_STR);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.statusCode);
        parcel.writeString(this.desc);
        byte[] bArr = this.bytedata;
        int length = bArr != null ? bArr.length : 0;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeByteArray(this.bytedata);
        }
        parcel.writeMap(this.connHeadFields);
        StatisticData statisticData2 = this.statisticData;
        if (statisticData2 != null) {
            parcel.writeSerializable(statisticData2);
        }
    }

    public NetworkResponse(int i) {
        this.statusCode = i;
        this.desc = fe0.b(i);
    }
}

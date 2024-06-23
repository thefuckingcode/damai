package cn.damai.commonbusiness.seatbiz.seat.qilin.bean;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.NcovSkuActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class SeatPreloadExtra implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<SeatPreloadExtra> CREATOR = new Parcelable.Creator<SeatPreloadExtra>() {
        /* class cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatPreloadExtra.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public SeatPreloadExtra createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "199008619")) {
                return new SeatPreloadExtra(parcel);
            }
            return (SeatPreloadExtra) ipChange.ipc$dispatch("199008619", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public SeatPreloadExtra[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1828293508")) {
                return new SeatPreloadExtra[i];
            }
            return (SeatPreloadExtra[]) ipChange.ipc$dispatch("1828293508", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String cityId;
    public long itemId;
    public long performId;
    public int type;

    public SeatPreloadExtra() {
    }

    @Nullable
    public static SeatPreloadExtra obtainExtra(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1525865986")) {
            return (SeatPreloadExtra) ipChange.ipc$dispatch("-1525865986", new Object[]{intent});
        } else if (intent != null) {
            return obtainExtra(intent.getExtras());
        } else {
            return null;
        }
    }

    public static void putPreloadExtraIfNeed(@Nullable SeatPreloadExtra seatPreloadExtra, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1567468701")) {
            ipChange.ipc$dispatch("-1567468701", new Object[]{seatPreloadExtra, bundle});
        } else if (seatPreloadExtra != null && seatPreloadExtra.isValid() && bundle != null) {
            bundle.putParcelable(NcovSkuActivity.KEY_SEAT_PRELOAD_EXTRA, seatPreloadExtra);
        }
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1080753848")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1080753848", new Object[]{this})).intValue();
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1489297102")) {
            return (TextUtils.isEmpty(this.cityId) || this.performId == 0 || this.itemId == 0) ? false : true;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1489297102", new Object[]{this})).booleanValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1838648595")) {
            ipChange.ipc$dispatch("1838648595", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.type);
        parcel.writeLong(this.itemId);
        parcel.writeLong(this.performId);
        parcel.writeString(this.cityId);
    }

    public SeatPreloadExtra(int i, long j, long j2, String str) {
        this.type = i;
        this.itemId = j;
        this.performId = j2;
        this.cityId = str;
    }

    @Nullable
    public static SeatPreloadExtra obtainExtra(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "696668369")) {
            return (SeatPreloadExtra) ipChange.ipc$dispatch("696668369", new Object[]{bundle});
        } else if (bundle != null) {
            return (SeatPreloadExtra) bundle.getParcelable(NcovSkuActivity.KEY_SEAT_PRELOAD_EXTRA);
        } else {
            return null;
        }
    }

    protected SeatPreloadExtra(Parcel parcel) {
        this.type = parcel.readInt();
        this.itemId = parcel.readLong();
        this.performId = parcel.readLong();
        this.cityId = parcel.readString();
    }
}

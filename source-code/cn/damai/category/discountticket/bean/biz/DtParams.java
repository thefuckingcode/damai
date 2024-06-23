package cn.damai.category.discountticket.bean.biz;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import cn.damai.category.discountticket.bean.HeaderData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class DtParams implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final Parcelable.Creator<DtParams> CREATOR = new Parcelable.Creator<DtParams>() {
        /* class cn.damai.category.discountticket.bean.biz.DtParams.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public DtParams createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1526760747")) {
                return new DtParams(parcel);
            }
            return (DtParams) ipChange.ipc$dispatch("1526760747", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public DtParams[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "62437156")) {
                return new DtParams[i];
            }
            return (DtParams[]) ipChange.ipc$dispatch("62437156", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public static final int TYPE_DISCOUNT_ACTIVITY = 6;
    public static final int TYPE_FROM_CATEGORY_FRAGMENT = 8;
    public static final int TYPE_MORE_DISCOUNT_ACTIVITY = 7;
    @Nullable
    public String cityId;
    @Nullable
    public HeaderData extra;
    @Nullable
    public String specBPageName;
    public int type;

    public DtParams() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1883212712")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1883212712", new Object[]{this})).intValue();
    }

    public boolean isTypeFormCategoryFragment() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1443804904")) {
            return this.type == 8;
        }
        return ((Boolean) ipChange.ipc$dispatch("1443804904", new Object[]{this})).booleanValue();
    }

    public boolean isTypeMoreDiscountActivity() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1281063051")) {
            return this.type == 7;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1281063051", new Object[]{this})).booleanValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890614819")) {
            ipChange.ipc$dispatch("1890614819", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeInt(this.type);
        parcel.writeParcelable(this.extra, i);
        parcel.writeString(this.cityId);
        parcel.writeString(this.specBPageName);
    }

    protected DtParams(Parcel parcel) {
        this.type = parcel.readInt();
        this.extra = (HeaderData) parcel.readParcelable(HeaderData.class.getClassLoader());
        this.cityId = parcel.readString();
        this.specBPageName = parcel.readString();
    }

    public DtParams(int i) {
        this(i, null, null, null);
    }

    public DtParams(int i, @Nullable String str) {
        this(i, null, null, str);
    }

    public DtParams(int i, HeaderData headerData, String str) {
        this(i, headerData, str, null);
    }

    public DtParams(int i, HeaderData headerData, @Nullable String str, @Nullable String str2) {
        this.type = i;
        this.extra = headerData;
        this.cityId = str;
        this.specBPageName = str2;
    }
}

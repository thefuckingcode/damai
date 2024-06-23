package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class PromotionBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<PromotionBean> CREATOR = new Parcelable.Creator<PromotionBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.PromotionBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public PromotionBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1638853995")) {
                return new PromotionBean(parcel);
            }
            return (PromotionBean) ipChange.ipc$dispatch("1638853995", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public PromotionBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "102808120")) {
                return new PromotionBean[i];
            }
            return (PromotionBean[]) ipChange.ipc$dispatch("102808120", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String content;
    private String tag;

    public PromotionBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1384031778")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1384031778", new Object[]{this})).intValue();
    }

    public String getContent() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "530853907")) {
            return this.content;
        }
        return (String) ipChange.ipc$dispatch("530853907", new Object[]{this});
    }

    public String getTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1607819316")) {
            return this.tag;
        }
        return (String) ipChange.ipc$dispatch("1607819316", new Object[]{this});
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1955315651")) {
            ipChange.ipc$dispatch("1955315651", new Object[]{this, str});
            return;
        }
        this.content = str;
    }

    public void setTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278660670")) {
            ipChange.ipc$dispatch("-278660670", new Object[]{this, str});
            return;
        }
        this.tag = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "407511725")) {
            ipChange.ipc$dispatch("407511725", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.tag);
        parcel.writeString(this.content);
    }

    protected PromotionBean(Parcel parcel) {
        this.tag = parcel.readString();
        this.content = parcel.readString();
    }
}

package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
public class RealNameVerifyResultBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<RealNameVerifyResultBean> CREATOR = new Parcelable.Creator<RealNameVerifyResultBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.RealNameVerifyResultBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public RealNameVerifyResultBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "2070606645")) {
                return new RealNameVerifyResultBean(parcel);
            }
            return (RealNameVerifyResultBean) ipChange.ipc$dispatch("2070606645", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public RealNameVerifyResultBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1775888144")) {
                return new RealNameVerifyResultBean[i];
            }
            return (RealNameVerifyResultBean[]) ipChange.ipc$dispatch("-1775888144", new Object[]{this, Integer.valueOf(i)});
        }
    };
    public String accountVerifyCode;
    public String accountVerifyMsg;
    public String faceVerifyCode;
    public String faceVerifyEnable;
    public String faceVerifyMsg;
    public List<RealNameVerifyRiskBean> materialDetail;
    public String mobile;
    public String verification;

    /* compiled from: Taobao */
    public static class RealNameVerifyRiskBean implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<RealNameVerifyRiskBean> CREATOR = new Parcelable.Creator<RealNameVerifyRiskBean>() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.RealNameVerifyResultBean.RealNameVerifyRiskBean.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Parcelable.Creator
            public RealNameVerifyRiskBean createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1085272053")) {
                    return new RealNameVerifyRiskBean(parcel);
                }
                return (RealNameVerifyRiskBean) ipChange.ipc$dispatch("-1085272053", new Object[]{this, parcel});
            }

            @Override // android.os.Parcelable.Creator
            public RealNameVerifyRiskBean[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-1308804366")) {
                    return new RealNameVerifyRiskBean[i];
                }
                return (RealNameVerifyRiskBean[]) ipChange.ipc$dispatch("-1308804366", new Object[]{this, Integer.valueOf(i)});
            }
        };
        public String code;
        public String display;
        public String intercept;
        public String materialType;
        public String security;
        public String suggestion;
        public String text;
        public String type;

        public RealNameVerifyRiskBean() {
        }

        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-363183039")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("-363183039", new Object[]{this})).intValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2087916886")) {
                ipChange.ipc$dispatch("-2087916886", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.code);
            parcel.writeString(this.display);
            parcel.writeString(this.intercept);
            parcel.writeString(this.materialType);
            parcel.writeString(this.security);
            parcel.writeString(this.suggestion);
            parcel.writeString(this.text);
            parcel.writeString(this.type);
        }

        protected RealNameVerifyRiskBean(Parcel parcel) {
            this.code = parcel.readString();
            this.display = parcel.readString();
            this.intercept = parcel.readString();
            this.materialType = parcel.readString();
            this.security = parcel.readString();
            this.suggestion = parcel.readString();
            this.text = parcel.readString();
            this.type = parcel.readString();
        }
    }

    public RealNameVerifyResultBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1706910834")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1706910834", new Object[]{this})).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1229319527")) {
            ipChange.ipc$dispatch("-1229319527", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.accountVerifyCode);
        parcel.writeString(this.accountVerifyMsg);
        parcel.writeString(this.faceVerifyCode);
        parcel.writeString(this.faceVerifyEnable);
        parcel.writeString(this.faceVerifyMsg);
        parcel.writeString(this.mobile);
        parcel.writeString(this.verification);
        parcel.writeTypedList(this.materialDetail);
    }

    protected RealNameVerifyResultBean(Parcel parcel) {
        this.accountVerifyCode = parcel.readString();
        this.accountVerifyMsg = parcel.readString();
        this.faceVerifyCode = parcel.readString();
        this.faceVerifyEnable = parcel.readString();
        this.faceVerifyMsg = parcel.readString();
        this.mobile = parcel.readString();
        this.verification = parcel.readString();
        this.materialDetail = parcel.createTypedArrayList(RealNameVerifyRiskBean.CREATOR);
    }
}

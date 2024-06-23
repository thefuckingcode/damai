package cn.damai.commonbusiness.faceverify.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class CertificateTypeBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<CertificateTypeBean> CREATOR = new Parcelable.Creator<CertificateTypeBean>() {
        /* class cn.damai.commonbusiness.faceverify.bean.CertificateTypeBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public CertificateTypeBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1169671455")) {
                return new CertificateTypeBean(parcel);
            }
            return (CertificateTypeBean) ipChange.ipc$dispatch("1169671455", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public CertificateTypeBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1876810512")) {
                return new CertificateTypeBean[i];
            }
            return (CertificateTypeBean[]) ipChange.ipc$dispatch("1876810512", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private List<ResultBean> result;

    /* compiled from: Taobao */
    public static class ResultBean implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<ResultBean> CREATOR = new Parcelable.Creator<ResultBean>() {
            /* class cn.damai.commonbusiness.faceverify.bean.CertificateTypeBean.ResultBean.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Parcelable.Creator
            public ResultBean createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "637021035")) {
                    return new ResultBean(parcel);
                }
                return (ResultBean) ipChange.ipc$dispatch("637021035", new Object[]{this, parcel});
            }

            @Override // android.os.Parcelable.Creator
            public ResultBean[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "2062588656")) {
                    return new ResultBean[i];
                }
                return (ResultBean[]) ipChange.ipc$dispatch("2062588656", new Object[]{this, Integer.valueOf(i)});
            }
        };
        private String identifyCode;
        private String identufyName;

        public ResultBean() {
        }

        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "953527298")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("953527298", new Object[]{this})).intValue();
        }

        public String getIdentifyCode() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "100153753")) {
                return this.identifyCode;
            }
            return (String) ipChange.ipc$dispatch("100153753", new Object[]{this});
        }

        public String getIdentufyName() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "903042115")) {
                return this.identufyName;
            }
            return (String) ipChange.ipc$dispatch("903042115", new Object[]{this});
        }

        public void setIdentifyCode(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-792319899")) {
                ipChange.ipc$dispatch("-792319899", new Object[]{this, str});
                return;
            }
            this.identifyCode = str;
        }

        public void setIdentufyName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1672584453")) {
                ipChange.ipc$dispatch("-1672584453", new Object[]{this, str});
                return;
            }
            this.identufyName = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2120736009")) {
                ipChange.ipc$dispatch("2120736009", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeString(this.identifyCode);
            parcel.writeString(this.identufyName);
        }

        protected ResultBean(Parcel parcel) {
            this.identifyCode = parcel.readString();
            this.identufyName = parcel.readString();
        }
    }

    public CertificateTypeBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1399045795")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-1399045795", new Object[]{this})).intValue();
    }

    public List<ResultBean> getResult() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-68441185")) {
            return this.result;
        }
        return (List) ipChange.ipc$dispatch("-68441185", new Object[]{this});
    }

    public void setResult(List<ResultBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1508886771")) {
            ipChange.ipc$dispatch("-1508886771", new Object[]{this, list});
            return;
        }
        this.result = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "400115982")) {
            ipChange.ipc$dispatch("400115982", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeList(this.result);
    }

    protected CertificateTypeBean(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.result = arrayList;
        parcel.readList(arrayList, ResultBean.class.getClassLoader());
    }
}

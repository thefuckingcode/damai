package cn.damai.commonbusiness.faceverify.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
public class FaceVerifyTokenBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<FaceVerifyTokenBean> CREATOR = new Parcelable.Creator<FaceVerifyTokenBean>() {
        /* class cn.damai.commonbusiness.faceverify.bean.FaceVerifyTokenBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public FaceVerifyTokenBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1380476731")) {
                return new FaceVerifyTokenBean(parcel);
            }
            return (FaceVerifyTokenBean) ipChange.ipc$dispatch("1380476731", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public FaceVerifyTokenBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1381664304")) {
                return new FaceVerifyTokenBean[i];
            }
            return (FaceVerifyTokenBean[]) ipChange.ipc$dispatch("-1381664304", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String faceVerifyStatus;
    private String resultToken;
    private String verifyToken;

    public FaceVerifyTokenBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-751747121")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-751747121", new Object[]{this})).intValue();
    }

    public String getFaceVerifyStatus() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "2121283221")) {
            return this.faceVerifyStatus;
        }
        return (String) ipChange.ipc$dispatch("2121283221", new Object[]{this});
    }

    public String getResultToken() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1619432037")) {
            return this.resultToken;
        }
        return (String) ipChange.ipc$dispatch("1619432037", new Object[]{this});
    }

    public String getVerifyToken() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-228216439")) {
            return this.verifyToken;
        }
        return (String) ipChange.ipc$dispatch("-228216439", new Object[]{this});
    }

    public void setFaceVerifyStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "163475689")) {
            ipChange.ipc$dispatch("163475689", new Object[]{this, str});
            return;
        }
        this.faceVerifyStatus = str;
    }

    public void setResultToken(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "657801649")) {
            ipChange.ipc$dispatch("657801649", new Object[]{this, str});
            return;
        }
        this.resultToken = str;
    }

    public void setVerifyToken(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-784726259")) {
            ipChange.ipc$dispatch("-784726259", new Object[]{this, str});
            return;
        }
        this.verifyToken = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1290355492")) {
            ipChange.ipc$dispatch("-1290355492", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.faceVerifyStatus);
        parcel.writeString(this.verifyToken);
        parcel.writeString(this.resultToken);
    }

    protected FaceVerifyTokenBean(Parcel parcel) {
        this.faceVerifyStatus = parcel.readString();
        this.verifyToken = parcel.readString();
        this.resultToken = parcel.readString();
    }
}

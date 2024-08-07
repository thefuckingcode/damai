package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import android.os.Parcel;
import android.os.Parcelable;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
public class ProjectDynamicIpCardBean implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<ProjectDynamicIpCardBean> CREATOR = new Parcelable.Creator<ProjectDynamicIpCardBean>() {
        /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDynamicIpCardBean.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public ProjectDynamicIpCardBean createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1152611399")) {
                return new ProjectDynamicIpCardBean(parcel);
            }
            return (ProjectDynamicIpCardBean) ipChange.ipc$dispatch("-1152611399", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public ProjectDynamicIpCardBean[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-227982160")) {
                return new ProjectDynamicIpCardBean[i];
            }
            return (ProjectDynamicIpCardBean[]) ipChange.ipc$dispatch("-227982160", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String bgPic;
    private String categoryName;
    private String ipId;
    private String ipPic;
    private Moments moments;
    private String note;
    private String title;

    /* compiled from: Taobao */
    public static class Moments implements Parcelable {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<Moments> CREATOR = new Parcelable.Creator<Moments>() {
            /* class cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDynamicIpCardBean.Moments.AnonymousClass1 */
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Parcelable.Creator
            public Moments createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "-639285989")) {
                    return new Moments(parcel);
                }
                return (Moments) ipChange.ipc$dispatch("-639285989", new Object[]{this, parcel});
            }

            @Override // android.os.Parcelable.Creator
            public Moments[] newArray(int i) {
                IpChange ipChange = $ipChange;
                if (!AndroidInstantRuntime.support(ipChange, "237976464")) {
                    return new Moments[i];
                }
                return (Moments[]) ipChange.ipc$dispatch("237976464", new Object[]{this, Integer.valueOf(i)});
            }
        };
        private ArrayList<PicInfo> picVOList;
        private ArrayList<VideoInfo> videoVOList;

        public Moments() {
        }

        public int describeContents() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1386566623")) {
                return 0;
            }
            return ((Integer) ipChange.ipc$dispatch("1386566623", new Object[]{this})).intValue();
        }

        public ArrayList<PicInfo> getPicVOList() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "1512629696")) {
                return this.picVOList;
            }
            return (ArrayList) ipChange.ipc$dispatch("1512629696", new Object[]{this});
        }

        public ArrayList<VideoInfo> getVideoVOList() {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-510961681")) {
                return this.videoVOList;
            }
            return (ArrayList) ipChange.ipc$dispatch("-510961681", new Object[]{this});
        }

        public void setPicVOList(ArrayList<PicInfo> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2029684488")) {
                ipChange.ipc$dispatch("-2029684488", new Object[]{this, arrayList});
                return;
            }
            this.picVOList = arrayList;
        }

        public void setVideoVOList(ArrayList<VideoInfo> arrayList) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "148504489")) {
                ipChange.ipc$dispatch("148504489", new Object[]{this, arrayList});
                return;
            }
            this.videoVOList = arrayList;
        }

        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "954944204")) {
                ipChange.ipc$dispatch("954944204", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            parcel.writeTypedList(this.picVOList);
            parcel.writeTypedList(this.videoVOList);
        }

        protected Moments(Parcel parcel) {
            this.picVOList = parcel.createTypedArrayList(PicInfo.CREATOR);
            this.videoVOList = parcel.createTypedArrayList(VideoInfo.CREATOR);
        }
    }

    public ProjectDynamicIpCardBean() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2111204240")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("-2111204240", new Object[]{this})).intValue();
    }

    public String getBgPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1401330189")) {
            return this.bgPic;
        }
        return (String) ipChange.ipc$dispatch("1401330189", new Object[]{this});
    }

    public String getCategoryName() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1116475497")) {
            return this.categoryName;
        }
        return (String) ipChange.ipc$dispatch("-1116475497", new Object[]{this});
    }

    public String getIpId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1918040080")) {
            return this.ipId;
        }
        return (String) ipChange.ipc$dispatch("1918040080", new Object[]{this});
    }

    public String getIpPic() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-857294101")) {
            return this.ipPic;
        }
        return (String) ipChange.ipc$dispatch("-857294101", new Object[]{this});
    }

    public Moments getMoments() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-346814622")) {
            return this.moments;
        }
        return (Moments) ipChange.ipc$dispatch("-346814622", new Object[]{this});
    }

    public String getNote() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1187481760")) {
            return this.note;
        }
        return (String) ipChange.ipc$dispatch("-1187481760", new Object[]{this});
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1297364512")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("-1297364512", new Object[]{this});
    }

    public void setBgPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1312036855")) {
            ipChange.ipc$dispatch("-1312036855", new Object[]{this, str});
            return;
        }
        this.bgPic = str;
    }

    public void setCategoryName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "146879015")) {
            ipChange.ipc$dispatch("146879015", new Object[]{this, str});
            return;
        }
        this.categoryName = str;
    }

    public void setIpId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-963056434")) {
            ipChange.ipc$dispatch("-963056434", new Object[]{this, str});
            return;
        }
        this.ipId = str;
    }

    public void setIpPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1685054187")) {
            ipChange.ipc$dispatch("1685054187", new Object[]{this, str});
            return;
        }
        this.ipPic = str;
    }

    public void setMoments(Moments moments2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1884189244")) {
            ipChange.ipc$dispatch("1884189244", new Object[]{this, moments2});
            return;
        }
        this.moments = moments2;
    }

    public void setNote(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1550014334")) {
            ipChange.ipc$dispatch("1550014334", new Object[]{this, str});
            return;
        }
        this.note = str;
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "927773334")) {
            ipChange.ipc$dispatch("927773334", new Object[]{this, str});
            return;
        }
        this.title = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1360010843")) {
            ipChange.ipc$dispatch("1360010843", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.ipId);
        parcel.writeString(this.bgPic);
        parcel.writeString(this.categoryName);
        parcel.writeString(this.ipPic);
        parcel.writeString(this.note);
        parcel.writeString(this.title);
        parcel.writeParcelable(this.moments, i);
    }

    protected ProjectDynamicIpCardBean(Parcel parcel) {
        this.ipId = parcel.readString();
        this.bgPic = parcel.readString();
        this.categoryName = parcel.readString();
        this.ipPic = parcel.readString();
        this.note = parcel.readString();
        this.title = parcel.readString();
        this.moments = (Moments) parcel.readParcelable(Moments.class.getClassLoader());
    }
}

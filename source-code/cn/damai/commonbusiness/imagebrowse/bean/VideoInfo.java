package cn.damai.commonbusiness.imagebrowse.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.youkuplayer.data.PlayParam;
import java.io.Serializable;

/* compiled from: Taobao */
public class VideoInfo implements Parcelable {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final Parcelable.Creator<VideoInfo> CREATOR = new Parcelable.Creator<VideoInfo>() {
        /* class cn.damai.commonbusiness.imagebrowse.bean.VideoInfo.AnonymousClass1 */
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Parcelable.Creator
        public VideoInfo createFromParcel(Parcel parcel) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1182640597")) {
                return new VideoInfo(parcel);
            }
            return (VideoInfo) ipChange.ipc$dispatch("-1182640597", new Object[]{this, parcel});
        }

        @Override // android.os.Parcelable.Creator
        public VideoInfo[] newArray(int i) {
            IpChange ipChange = $ipChange;
            if (!AndroidInstantRuntime.support(ipChange, "-1296732300")) {
                return new VideoInfo[i];
            }
            return (VideoInfo[]) ipChange.ipc$dispatch("-1296732300", new Object[]{this, Integer.valueOf(i)});
        }
    };
    private String picUrl;
    private ProjectInfo projectInfo;
    private String sourceLabel;
    private String title;
    private VideoType type = VideoType.VIDEO_VID;
    private boolean useNativePlayer;
    private String vid;
    private String videoId;
    private String videoThumbnailType;
    private String videoUrl;

    /* compiled from: Taobao */
    public static class ProjectInfo implements Serializable {
        public String id;
        public String name;
        public String priceStr;
        public String showTime;
        public String subTitle;
        public String venueCity;
        public String venueName;
        public String verticalPic;
    }

    /* compiled from: Taobao */
    public enum VideoType {
        VIDEO_VID,
        VIDEO_URL
    }

    public VideoInfo() {
    }

    public int describeContents() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1771032192")) {
            return 0;
        }
        return ((Integer) ipChange.ipc$dispatch("1771032192", new Object[]{this})).intValue();
    }

    public String getPicUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1184350403")) {
            return this.picUrl;
        }
        return (String) ipChange.ipc$dispatch("1184350403", new Object[]{this});
    }

    public ProjectInfo getProjectInfo() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "66167492")) {
            return this.projectInfo;
        }
        return (ProjectInfo) ipChange.ipc$dispatch("66167492", new Object[]{this});
    }

    public String getSourceLabel() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1057677009")) {
            return this.sourceLabel;
        }
        return (String) ipChange.ipc$dispatch("1057677009", new Object[]{this});
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1505893936")) {
            return this.title;
        }
        return (String) ipChange.ipc$dispatch("-1505893936", new Object[]{this});
    }

    public VideoType getType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1478803153")) {
            return this.type;
        }
        return (VideoType) ipChange.ipc$dispatch("-1478803153", new Object[]{this});
    }

    public String getValidId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "298511599")) {
            return this.type == VideoType.VIDEO_VID ? this.vid : this.videoUrl;
        }
        return (String) ipChange.ipc$dispatch("298511599", new Object[]{this});
    }

    public String getVid() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-6227895")) {
            return this.vid;
        }
        return (String) ipChange.ipc$dispatch("-6227895", new Object[]{this});
    }

    public String getVideoId() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1060010030")) {
            return this.videoId;
        }
        return (String) ipChange.ipc$dispatch("1060010030", new Object[]{this});
    }

    public String getVideoThumbnailType() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1728442185")) {
            return this.videoThumbnailType;
        }
        return (String) ipChange.ipc$dispatch("1728442185", new Object[]{this});
    }

    public String getVideoUrl() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "981954034")) {
            return this.videoUrl;
        }
        return (String) ipChange.ipc$dispatch("981954034", new Object[]{this});
    }

    public boolean isUseNativePlayer() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-1368151993")) {
            return this.useNativePlayer;
        }
        return ((Boolean) ipChange.ipc$dispatch("-1368151993", new Object[]{this})).booleanValue();
    }

    public String logString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2125894077")) {
            return (String) ipChange.ipc$dispatch("2125894077", new Object[]{this});
        } else if (this.type == VideoType.VIDEO_VID) {
            return this.vid;
        } else {
            String str = this.videoUrl;
            return str.substring(str.lastIndexOf("/") + 1, this.videoUrl.indexOf("?"));
        }
    }

    public void readFromParcel(Parcel parcel) {
        VideoType videoType;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "679542148")) {
            ipChange.ipc$dispatch("679542148", new Object[]{this, parcel});
            return;
        }
        this.title = parcel.readString();
        this.picUrl = parcel.readString();
        this.videoThumbnailType = parcel.readString();
        this.vid = parcel.readString();
        this.videoUrl = parcel.readString();
        this.sourceLabel = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt == -1) {
            videoType = null;
        } else {
            videoType = VideoType.values()[readInt];
        }
        this.type = videoType;
        if (parcel.readByte() == 0) {
            z = false;
        }
        this.useNativePlayer = z;
        this.videoId = parcel.readString();
        this.projectInfo = (ProjectInfo) parcel.readSerializable();
    }

    public void setPicUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "960032123")) {
            ipChange.ipc$dispatch("960032123", new Object[]{this, str});
            return;
        }
        this.picUrl = str;
    }

    public void setProjectInfo(ProjectInfo projectInfo2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "512292444")) {
            ipChange.ipc$dispatch("512292444", new Object[]{this, projectInfo2});
            return;
        }
        this.projectInfo = projectInfo2;
    }

    public void setSourceLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "423264965")) {
            ipChange.ipc$dispatch("423264965", new Object[]{this, str});
            return;
        }
        this.sourceLabel = str;
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1241671514")) {
            ipChange.ipc$dispatch("-1241671514", new Object[]{this, str});
            return;
        }
        this.title = str;
    }

    public void setType(VideoType videoType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "435286621")) {
            ipChange.ipc$dispatch("435286621", new Object[]{this, videoType});
            return;
        }
        this.type = videoType;
    }

    public void setUseNativePlayer(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1155804767")) {
            ipChange.ipc$dispatch("1155804767", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.useNativePlayer = z;
    }

    public void setVid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1225483341")) {
            ipChange.ipc$dispatch("1225483341", new Object[]{this, str});
            return;
        }
        this.vid = str;
    }

    public void setVideoId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1179286280")) {
            ipChange.ipc$dispatch("1179286280", new Object[]{this, str});
            return;
        }
        this.videoId = str;
    }

    public void setVideoThumbnailType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2000093621")) {
            ipChange.ipc$dispatch("2000093621", new Object[]{this, str});
            return;
        }
        this.videoThumbnailType = str;
    }

    public void setVideoUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "493476140")) {
            ipChange.ipc$dispatch("493476140", new Object[]{this, str});
            return;
        }
        this.videoUrl = str;
    }

    @Nullable
    public PlayParam toPlayVideoInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "266359354")) {
            return (PlayParam) ipChange.ipc$dispatch("266359354", new Object[]{this});
        }
        PlayParam playParam = new PlayParam();
        if (!TextUtils.isEmpty(getVid())) {
            playParam.setVid(getVid());
            playParam.setDisableAd(true);
        } else if (!TextUtils.isEmpty(getVideoUrl())) {
            playParam.setUrl(getVideoUrl());
        }
        return playParam;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1195162037")) {
            ipChange.ipc$dispatch("-1195162037", new Object[]{this, parcel, Integer.valueOf(i)});
            return;
        }
        parcel.writeString(this.title);
        parcel.writeString(this.picUrl);
        parcel.writeString(this.videoThumbnailType);
        parcel.writeString(this.vid);
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.sourceLabel);
        VideoType videoType = this.type;
        parcel.writeInt(videoType == null ? -1 : videoType.ordinal());
        parcel.writeByte(this.useNativePlayer ? (byte) 1 : 0);
        parcel.writeString(this.videoId);
        parcel.writeSerializable(this.projectInfo);
    }

    protected VideoInfo(Parcel parcel) {
        VideoType videoType;
        this.title = parcel.readString();
        this.picUrl = parcel.readString();
        this.videoThumbnailType = parcel.readString();
        this.vid = parcel.readString();
        this.videoUrl = parcel.readString();
        this.sourceLabel = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt == -1) {
            videoType = null;
        } else {
            videoType = VideoType.values()[readInt];
        }
        this.type = videoType;
        this.useNativePlayer = parcel.readByte() != 0;
        this.videoId = parcel.readString();
        this.projectInfo = (ProjectInfo) parcel.readSerializable();
    }
}

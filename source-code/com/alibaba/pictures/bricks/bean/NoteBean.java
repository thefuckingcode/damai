package com.alibaba.pictures.bricks.bean;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.pictures.bricks.bean.ContentDetailItem;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashSet;
import java.util.List;

/* compiled from: Taobao */
public class NoteBean extends Extra {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TYPE_SHOW_LOOK_COMMENT = "32";
    public static final String TYPE_SHOW_PRIVILEGE = "62";
    public static final String TYPE_SHOW_SCAN_COMMENT = "65";
    public BaseUserDO baseUserDO;
    public String content;
    public ContentInfo contentInfo;
    public String contentLabels;
    public ExRelatedInfo extraRelatedInfo;
    public boolean focus;
    public int focusCount = 0;
    public String goDnaUrl;
    public String headImg;
    public String id;
    public List<String> imgList;
    public String ipvuv;
    public String isFeature;
    public float localPicWhRatio = -1.0f;
    public boolean mySelf;
    public String nickname;
    public String pic;
    public ContentDetailItem.PraiseInfo praiseInfo;
    public boolean prohibitEditing;
    public ProjectInNote project;
    public String publishTime;
    public PublishUser publishUser;
    public RelatedInfo relatedInfo;
    @Nullable
    public String schema;
    public ContentShareInfo shareDO;
    public String similarity;
    public String sourceId;
    public String subType;

    private HashSet<String> getTypeCanShowPublish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1771943045")) {
            return (HashSet) ipChange.ipc$dispatch("-1771943045", new Object[]{this});
        }
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("32");
        hashSet.add("62");
        hashSet.add("65");
        return hashSet;
    }

    public boolean containsStrategy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "373587916")) {
            return ((Boolean) ipChange.ipc$dispatch("373587916", new Object[]{this})).booleanValue();
        }
        String str = this.contentLabels;
        return str != null && str.contains("strategy");
    }

    public String getContentInfoText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1459703492")) {
            return (String) ipChange.ipc$dispatch("1459703492", new Object[]{this});
        }
        ContentInfo contentInfo2 = this.contentInfo;
        if (contentInfo2 != null) {
            return contentInfo2.content;
        }
        return null;
    }

    @Nullable
    public String getPublishUserId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530309851")) {
            return (String) ipChange.ipc$dispatch("-1530309851", new Object[]{this});
        }
        BaseUserDO baseUserDO2 = this.baseUserDO;
        if (baseUserDO2 != null) {
            return baseUserDO2.havanaIdStr;
        }
        return null;
    }

    public int getRelateIconRid(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "814309458")) {
            return ((Integer) ipChange.ipc$dispatch("814309458", new Object[]{this, Boolean.valueOf(z)})).intValue();
        }
        RelatedInfo relatedInfo2 = this.relatedInfo;
        if (relatedInfo2 != null) {
            return relatedInfo2.getRelateIconRid(z);
        }
        return -1;
    }

    public String getRelateText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "325034860")) {
            return (String) ipChange.ipc$dispatch("325034860", new Object[]{this});
        }
        RelatedInfo relatedInfo2 = this.relatedInfo;
        return relatedInfo2 != null ? relatedInfo2.value : "";
    }

    public boolean isCanShowRelateUi() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337781628")) {
            return ((Boolean) ipChange.ipc$dispatch("-1337781628", new Object[]{this})).booleanValue();
        }
        RelatedInfo relatedInfo2 = this.relatedInfo;
        return relatedInfo2 != null && relatedInfo2.isValid();
    }

    public boolean isEnableEdit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2059250663")) {
            return ((Boolean) ipChange.ipc$dispatch("2059250663", new Object[]{this})).booleanValue();
        } else if (!this.mySelf || TextUtils.isEmpty(this.subType)) {
            return false;
        } else {
            return getTypeCanShowPublish().contains(this.subType);
        }
    }

    public boolean isFeature() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-2051105560")) {
            return TextUtils.equals("1", this.isFeature);
        }
        return ((Boolean) ipChange.ipc$dispatch("-2051105560", new Object[]{this})).booleanValue();
    }

    public boolean isHasVideoUnderReviewStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2103646301")) {
            return ((Boolean) ipChange.ipc$dispatch("2103646301", new Object[]{this})).booleanValue();
        }
        VideoInfo videoInfo = this.videoInfo;
        return videoInfo != null && videoInfo.isVideoUnderReviewStatus();
    }

    public boolean isPicNote() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "1294167426")) {
            return !TextUtils.isEmpty(this.pic);
        }
        return ((Boolean) ipChange.ipc$dispatch("1294167426", new Object[]{this})).booleanValue();
    }
}

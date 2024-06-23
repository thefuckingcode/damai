package com.alibaba.pictures.bricks.bean;

import android.text.TextUtils;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.bricks.component.artist.BaccountInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class IpDramaBrandArchBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BRAND = "brand";
    public static final String DRAMA = "drama";
    public static final String MUSIC_FESTIVAL = "music_festival";
    private static final long serialVersionUID = 1;
    public ArrayList<BaccountInfo> artistList;
    public String backgroundPic;
    public ArrayList<VideoAlbum> contentList;
    public String damaiId;
    public String fansCount;
    public String headPic;
    public List<String> moreInfo;
    public String name;
    public String performanceCount;
    public String schema;
    public String score;
    public String subType;
    public String tourInfos;
    public String type;
    public String vaccount;

    public String getIpBrandType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-229998177")) {
            return (String) ipChange.ipc$dispatch("-229998177", new Object[]{this});
        } else if ("11".equals(this.type)) {
            return "brand";
        } else {
            return "音乐节".equals(this.subType) ? "music_festival" : "drama";
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0088, code lost:
        if (r0.equals("体育") == false) goto L_0x003e;
     */
    public int getTagImageResourceRid() {
        IpChange ipChange = $ipChange;
        char c = 0;
        if (AndroidInstantRuntime.support(ipChange, "-2044648176")) {
            return ((Integer) ipChange.ipc$dispatch("-2044648176", new Object[]{this})).intValue();
        } else if (TextUtils.equals("11", this.type)) {
            return R$drawable.bricks_icon_ip_brand;
        } else {
            if (TextUtils.isEmpty(this.subType)) {
                return -1;
            }
            String str = this.subType;
            str.hashCode();
            switch (str.hashCode()) {
                case 662463:
                    break;
                case 665857:
                    if (str.equals("休闲")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 676275:
                    if (str.equals("剧场")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 768019:
                    if (str.equals("展览")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 888013:
                    if (str.equals("活动")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1225917:
                    if (str.equals("音乐")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 38036837:
                    if (str.equals("音乐节")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return R$drawable.bricks_icon_ip_sport;
                case 1:
                    return R$drawable.bricks_icon_ip_leisure;
                case 2:
                    return R$drawable.bricks_icon_ip_drama_venue;
                case 3:
                    return R$drawable.bricks_icon_ip_exhibition;
                case 4:
                    return R$drawable.bricks_icon_ip_activity;
                case 5:
                    return R$drawable.bricks_icon_ip_music;
                case 6:
                    return R$drawable.bricks_icon_music_festival;
                default:
                    return -1;
            }
        }
    }

    public boolean isShowVTag() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "92311902")) {
            return !TextUtils.isEmpty(this.vaccount) && !"0".equals(this.vaccount);
        }
        return ((Boolean) ipChange.ipc$dispatch("92311902", new Object[]{this})).booleanValue();
    }
}

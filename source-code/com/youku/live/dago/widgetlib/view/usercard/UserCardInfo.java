package com.youku.live.dago.widgetlib.view.usercard;

import java.io.Serializable;

/* compiled from: Taobao */
public class UserCardInfo implements Serializable {
    public static final int TYPE_MORMAL = 0;
    public static final int TYPE_SELF = 1;
    public static final int TYPE_VISITOR = 2;
    public String avatar;
    public String description;
    public boolean isFollower = false;
    public int isPugc = 0;
    public int localType = 0;
    public String nickName;
    public int userGender = 0;
    public int userLevel = 0;
    public long yid;
    public long ytid;
}

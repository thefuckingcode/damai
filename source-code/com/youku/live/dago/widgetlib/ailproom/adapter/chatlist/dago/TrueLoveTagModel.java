package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago;

import java.io.Serializable;

/* compiled from: Taobao */
public class TrueLoveTagModel implements Serializable {
    public int code;
    public Data data;
    public String msg;
    public boolean succ;

    /* compiled from: Taobao */
    public static class Data implements Serializable {
        public String groupIcon;
        public long groupId;
        public String groupImg;
        public String groupName;
        public int memberNum;
        public String weexUrl;
    }
}

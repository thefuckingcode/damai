package com.youku.live.dago.widgetlib.ailproom.config;

/* compiled from: Taobao */
public class ILRoomConfiguration {
    public ChatRoomConfiguration chatRoomConfiguration;
    public String licence;
    public LiveConfiguration liveConfiguration;
    public String mtopAppKey;
    public String roomId;

    public ILRoomConfiguration() {
        this.roomId = "";
        this.mtopAppKey = "";
        this.licence = "";
        this.chatRoomConfiguration = null;
        this.liveConfiguration = null;
        this.liveConfiguration = new LiveConfiguration();
        this.chatRoomConfiguration = new ChatRoomConfiguration();
    }
}

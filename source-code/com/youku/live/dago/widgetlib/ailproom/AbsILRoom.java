package com.youku.live.dago.widgetlib.ailproom;

import com.youku.live.dago.widgetlib.ailpchat.ChatRoom;
import com.youku.live.dago.widgetlib.ailpchat.MessageDelegate;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;
import com.youku.live.dago.widgetlib.ailproom.callback.ResultCallback;
import com.youku.live.dago.widgetlib.ailproom.config.ILRoomConfiguration;
import java.util.Map;

/* compiled from: Taobao */
public abstract class AbsILRoom {
    public ChatRoom chatRoom = null;
    public ILRoomConfiguration configuration = null;
    public LiveManager liveManager = null;
    public String roomId = "";
    public String sessionId = "";
    public String uniqueKey = "";

    public abstract void addMessageListener(MessageDelegate messageDelegate);

    public abstract void createRoom(ResultCallback resultCallback);

    public abstract void joinRoom(ILRoomConfiguration iLRoomConfiguration);

    public abstract void joinRoom(ILRoomConfiguration iLRoomConfiguration, ResultCallback resultCallback);

    public abstract void linkRoom(String str);

    public abstract void quitRoom();

    public abstract void quitRoomNative();

    public abstract void sendMessage(Map<String, Object> map, ResultCallback resultCallback);

    public abstract void setImListener(LiveManager.LiveChangeListener liveChangeListener);

    public abstract void switchRoom(String str);
}

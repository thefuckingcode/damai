package com.youku.live.messagechannel.callback;

import java.util.Map;

/* compiled from: Taobao */
public interface IMCChannelEventCallback {
    void onEvent(MCChannelEvent mCChannelEvent, String str, Map<String, Object> map);
}

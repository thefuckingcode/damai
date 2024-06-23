package com.youku.live.dago.widgetlib.protocol;

import android.view.View;
import com.youku.live.dago.widgetlib.interactive.gift.bean.GiftTrackBean;
import com.youku.live.dago.widgetlib.interactive.gift.callback.IGiftTrackCallback;

/* compiled from: Taobao */
public interface YKLGiftTrackProtocol {
    View getView();

    void insertGiftTrackInfo(GiftTrackBean giftTrackBean);

    void resume();

    void setCallback(IGiftTrackCallback iGiftTrackCallback);

    void setSize(int i, int i2);

    void setTrackCount(int i);

    void stop();
}

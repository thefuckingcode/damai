package com.youku.alixplayer.state;

import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.instances.Aliplayer;

/* compiled from: Taobao */
public interface IState {

    /* compiled from: Taobao */
    public interface IStateListener {
        void onEnter();

        void onOuter();
    }

    void addStateListener(IStateListener iStateListener);

    void enterAction(IAlixPlayer.State state);

    IAlixPlayer.State getState();

    void outerAction();

    void setAliplayer(Aliplayer aliplayer);
}

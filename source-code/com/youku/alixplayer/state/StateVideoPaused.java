package com.youku.alixplayer.state;

import com.youku.alixplayer.IAlixPlayer;

/* compiled from: Taobao */
public class StateVideoPaused extends AbsBaseState {
    @Override // com.youku.alixplayer.state.IState, com.youku.alixplayer.state.AbsBaseState
    public void enterAction(IAlixPlayer.State state) {
        super.enterAction(state);
        this.mAliplayer.pause();
    }

    @Override // com.youku.alixplayer.state.IState, com.youku.alixplayer.state.AbsBaseState
    public IAlixPlayer.State getState() {
        return IAlixPlayer.State.STATE_VIDEO_PAUSED;
    }
}

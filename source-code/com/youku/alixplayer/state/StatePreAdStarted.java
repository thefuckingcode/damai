package com.youku.alixplayer.state;

import com.youku.alixplayer.IAlixPlayer;

/* compiled from: Taobao */
public class StatePreAdStarted extends AbsBaseState {
    @Override // com.youku.alixplayer.state.IState, com.youku.alixplayer.state.AbsBaseState
    public void enterAction(IAlixPlayer.State state) {
        super.enterAction(state);
        if (state == IAlixPlayer.State.STATE_PRE_AD_PAUSED) {
            this.mAliplayer.start();
        }
    }

    @Override // com.youku.alixplayer.state.IState, com.youku.alixplayer.state.AbsBaseState
    public IAlixPlayer.State getState() {
        return IAlixPlayer.State.STATE_PRE_AD_STARTED;
    }
}

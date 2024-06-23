package com.youku.alixplayer.state;

import com.youku.alixplayer.IAlixPlayer;

/* compiled from: Taobao */
public class StatePostAdCompleted extends AbsBaseState {
    @Override // com.youku.alixplayer.state.IState, com.youku.alixplayer.state.AbsBaseState
    public IAlixPlayer.State getState() {
        return IAlixPlayer.State.STATE_POST_AD_COMPLETED;
    }
}

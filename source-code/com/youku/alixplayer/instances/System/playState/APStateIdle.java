package com.youku.alixplayer.instances.System.playState;

import com.youku.alixplayer.IAlixPlayer;

/* compiled from: Taobao */
public class APStateIdle extends APAbsBaseState {
    @Override // com.youku.alixplayer.instances.System.playState.APAbsBaseState, com.youku.alixplayer.instances.System.playState.APIState
    public IAlixPlayer.State getState() {
        return IAlixPlayer.State.STATE_IDLE;
    }
}

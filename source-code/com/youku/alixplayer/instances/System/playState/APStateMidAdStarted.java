package com.youku.alixplayer.instances.System.playState;

import com.youku.alixplayer.IAlixPlayer;

/* compiled from: Taobao */
public class APStateMidAdStarted extends APAbsBaseState {
    @Override // com.youku.alixplayer.instances.System.playState.APAbsBaseState, com.youku.alixplayer.instances.System.playState.APIState
    public void enterAction(IAlixPlayer.State state) {
        super.enterAction(state);
        if (state == IAlixPlayer.State.STATE_MID_AD_PAUSED) {
            this.mAndroidPlayer.start();
        }
    }

    @Override // com.youku.alixplayer.instances.System.playState.APAbsBaseState, com.youku.alixplayer.instances.System.playState.APIState
    public IAlixPlayer.State getState() {
        return IAlixPlayer.State.STATE_MID_AD_STARTED;
    }
}

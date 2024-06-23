package com.youku.alixplayer.state;

import android.util.Log;
import com.youku.alixplayer.IAlixPlayer;

/* compiled from: Taobao */
public class StateMidAdPaused extends AbsBaseState {
    @Override // com.youku.alixplayer.state.IState, com.youku.alixplayer.state.AbsBaseState
    public void enterAction(IAlixPlayer.State state) {
        super.enterAction(state);
        Log.d("StateMidAdPaused", "pause()");
        this.mAliplayer.pause();
    }

    @Override // com.youku.alixplayer.state.IState, com.youku.alixplayer.state.AbsBaseState
    public IAlixPlayer.State getState() {
        return IAlixPlayer.State.STATE_MID_AD_PAUSED;
    }
}

package com.youku.alixplayer.state;

import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.instances.Aliplayer;

/* compiled from: Taobao */
public class StateReleased extends AbsBaseState {
    @Override // com.youku.alixplayer.state.IState, com.youku.alixplayer.state.AbsBaseState
    public void enterAction(IAlixPlayer.State state) {
        super.enterAction(state);
        Aliplayer aliplayer = this.mAliplayer;
        if (aliplayer != null) {
            aliplayer.stop();
        }
    }

    @Override // com.youku.alixplayer.state.IState, com.youku.alixplayer.state.AbsBaseState
    public IAlixPlayer.State getState() {
        return IAlixPlayer.State.STATE_RELEASED;
    }
}

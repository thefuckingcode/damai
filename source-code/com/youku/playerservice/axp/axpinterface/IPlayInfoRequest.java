package com.youku.playerservice.axp.axpinterface;

import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playparams.PlayParams;
import java.util.List;

/* compiled from: Taobao */
public interface IPlayInfoRequest {

    /* compiled from: Taobao */
    public interface Callback {
        void onFinished(PlayParams playParams, List<PlayInfoResponse> list);
    }

    /* compiled from: Taobao */
    public enum State {
        IDLE,
        RUNNING,
        FINISHED
    }

    void cancel();

    List<PlayInfoResponse> getPlayInfoResponses();

    PlayParams getPlayParams();

    State getState();

    void request(PlayParams playParams);

    void setRequestCallback(Callback callback);
}

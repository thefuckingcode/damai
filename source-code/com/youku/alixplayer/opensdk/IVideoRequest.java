package com.youku.alixplayer.opensdk;

import android.content.Context;
import java.util.Map;

/* compiled from: Taobao */
public interface IVideoRequest {

    /* compiled from: Taobao */
    public interface Callback<Result, Extras> {
        void onFailure(VideoRequestError videoRequestError);

        void onStat(Map<String, String> map);

        void onSuccess(Result result, Extras extras);
    }

    /* compiled from: Taobao */
    public interface Factory {
        IVideoRequest create(Context context, PlayVideoInfo playVideoInfo, PlayerConfig playerConfig);
    }

    /* compiled from: Taobao */
    public enum State {
        IDLE,
        DOING,
        FINISH
    }

    void cancel();

    void request(PlayVideoInfo playVideoInfo, Map<String, String> map);

    void setVideoRequestListener(Callback callback);
}

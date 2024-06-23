package com.youku.playerservice.axp.axpinterface;

import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.interceptor.Interceptor;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playparams.PlayParams;
import java.util.Map;

/* compiled from: Taobao */
public interface IPlayerService extends IMultiPlayerProtocol, IPlayerProtocol, ISwitchStream {
    void addInterceptor(Interceptor interceptor);

    Quality getCurrentQuality();

    PlayInfo getPlayInfo();

    PlayParams getPlayParams();

    void playWithParams(PlayParams playParams);

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    void release();

    void requestWithParams(PlayParams playParams, IPlayInfoRequest.Callback callback);

    void requestWithUpdatePlayInfo(Map<String, String> map);

    void setMultiPlayerEventListener(MultiPlayerEventListener multiPlayerEventListener);

    void setPlayerEventListener(PlayerEventListener playerEventListener);

    void setPositionFrenquency(int i);

    @Override // com.youku.playerservice.axp.axpinterface.ISwitchStream
    /* synthetic */ void switchLanguage(String str);

    @Override // com.youku.playerservice.axp.axpinterface.ISwitchStream
    /* synthetic */ void switchQuality(Quality quality);

    @Override // com.youku.playerservice.axp.axpinterface.ISwitchStream
    /* synthetic */ void switchSceneId(String str);

    @Override // com.youku.playerservice.axp.axpinterface.ISwitchStream
    /* synthetic */ void switchTimeShifted(String str);
}

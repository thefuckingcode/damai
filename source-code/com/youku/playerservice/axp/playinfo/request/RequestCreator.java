package com.youku.playerservice.axp.playinfo.request;

import android.content.Context;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.vpm.constants.TableField;

/* compiled from: Taobao */
public class RequestCreator {
    public static IPlayInfoRequest create(Context context, PlayParams playParams, PlayerConfig playerConfig) {
        if (playParams.getPlayIdParams() != null && playParams.getPlayIdParams().getPlayInfoRequest() != null) {
            return playParams.getPlayIdParams().getPlayInfoRequest();
        }
        if (playParams.getPlayType() == PlayDefinition.PlayType.VOD) {
            if (!CacheRequest.hasCacheData(playParams)) {
                return new UpsWithCacheRequest(playerConfig);
            }
            CacheRequest cacheRequest = new CacheRequest(context, playerConfig);
            playParams.putString(TableField.PLAY_WAY, "local");
            return cacheRequest;
        } else if (playParams.getPlayType() == PlayDefinition.PlayType.LIVE) {
            return new LiveRequest(playerConfig);
        } else {
            return null;
        }
    }
}

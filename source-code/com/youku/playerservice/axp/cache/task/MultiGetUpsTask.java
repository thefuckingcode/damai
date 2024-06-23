package com.youku.playerservice.axp.cache.task;

import android.content.Context;
import android.text.TextUtils;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.cache.CacheManager;
import com.youku.playerservice.axp.cache.CachePool;
import com.youku.playerservice.axp.cache.CachePreloadResult;
import com.youku.playerservice.axp.cache.IMultiGetUpsCallback;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.request.MultiGetUpsRequest;
import com.youku.playerservice.axp.playparams.PlayIdParams;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.vpm.constants.TableField;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public class MultiGetUpsTask extends CacheTask {
    private IMultiGetUpsCallback mCallback;
    private Context mContext;
    private Map<String, String> mExtParams;
    private IPlayInfoRequest.Callback mPlayInfoRequestCallback = new IPlayInfoRequest.Callback() {
        /* class com.youku.playerservice.axp.cache.task.MultiGetUpsTask.AnonymousClass1 */

        @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest.Callback
        public void onFinished(PlayParams playParams, List<PlayInfoResponse> list) {
            ArrayList arrayList;
            if (list == null || list.size() <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(list.size());
                for (PlayInfoResponse playInfoResponse : list) {
                    if (MultiGetUpsTask.this.mVidList.contains(playInfoResponse.getUpsInfo().getSimpleVideoInfo().getVid())) {
                        arrayList.add(playInfoResponse);
                    }
                }
            }
            if (arrayList != null) {
                CachePool.getInstance().savePlayInfoResponseList(MultiGetUpsTask.this.mContext, arrayList);
            }
            if (MultiGetUpsTask.this.mCallback != null) {
                MultiGetUpsTask.this.mCallback.onResult(list);
            }
        }
    };
    private List<String> mVidList;

    public MultiGetUpsTask(Context context, List<String> list, Map<String, String> map, IMultiGetUpsCallback iMultiGetUpsCallback) {
        this.mContext = context;
        this.mVidList = list;
        this.mExtParams = map;
        this.mCallback = iMultiGetUpsCallback;
    }

    @Override // java.util.concurrent.Callable, com.youku.playerservice.axp.cache.task.CacheTask, com.youku.playerservice.axp.cache.task.CacheTask
    public CachePreloadResult call() {
        if (this.mVidList == null) {
            return null;
        }
        TLogUtil.loge(CacheManager.TAG_MULTIGET, "MultiGetUpsTask startwork vids:" + this.mVidList.toString());
        ArrayList arrayList = new ArrayList();
        String str = "";
        String str2 = this.mExtParams.containsKey(TableField.PLAYER_SOURCE) ? this.mExtParams.get(TableField.PLAYER_SOURCE) : str;
        for (String str3 : this.mVidList) {
            if (CachePool.getInstance().queryPlayInfoResponse(this.mContext, PlayDefinition.PlayInfoType.UPS, str3, str2) != null) {
                TLogUtil.loge(CacheManager.TAG_MULTIGET, "MultiGetUpsTask exist and ignore " + str3);
            } else {
                arrayList.add(str3);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        TLogUtil.loge(CacheManager.TAG_MEDIASOURCE, "MultiGetUpsTask request vids:" + arrayList.toString());
        MultiGetUpsRequest multiGetUpsRequest = new MultiGetUpsRequest(this.mContext);
        multiGetUpsRequest.setRequestCallback(this.mPlayInfoRequestCallback);
        if (this.mExtParams.containsKey("ccode")) {
            str = this.mExtParams.get("ccode");
        }
        int intValue = !TextUtils.isEmpty(this.mExtParams.get("requestQuality")) ? Integer.valueOf(this.mExtParams.get("requestQuality")).intValue() : 0;
        PlayIdParams playIdParams = new PlayIdParams(this.mVidList.get(0), str);
        playIdParams.putString(TableField.PLAYER_SOURCE, str2);
        playIdParams.setVids(arrayList);
        playIdParams.setRequestQuality(Quality.getQualityByCode(intValue));
        multiGetUpsRequest.request(PlayParams.createPlayParams(PlayDefinition.PlayType.VOD, PlayDefinition.PlayScene.LONG_VIDEO, playIdParams));
        return null;
    }
}

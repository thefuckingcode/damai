package com.youku.playerservice.axp.playinfo.request;

import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.cache.CachePool;
import com.youku.playerservice.axp.cache.ResultCode;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.vpm.constants.TableField;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class LiveWithCacheRequest implements IPlayInfoRequest {
    private static final String TAG = "LiveWithCacheRequest";
    private IPlayInfoRequest.Callback mCallback;
    protected volatile boolean mIsCancel;
    private final LiveRequest mLiveRequest;
    private PlayParams mPlayParams;
    private PlayerConfig mPlayerConfig;
    private List<PlayInfoResponse> mResponses;
    private IPlayInfoRequest.State mState = IPlayInfoRequest.State.IDLE;

    public LiveWithCacheRequest(PlayerConfig playerConfig) {
        this.mPlayerConfig = playerConfig;
        this.mLiveRequest = new LiveRequest(playerConfig);
    }

    private void reportResult(PlayInfoResponse playInfoResponse) {
        if (this.mCallback != null && !this.mIsCancel) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(playInfoResponse);
            this.mResponses = arrayList;
            this.mCallback.onFinished(this.mPlayParams, arrayList);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void cancel() {
        this.mIsCancel = true;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public List<PlayInfoResponse> getPlayInfoResponses() {
        return this.mResponses;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public PlayParams getPlayParams() {
        return this.mPlayParams;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public IPlayInfoRequest.State getState() {
        return this.mState;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void request(PlayParams playParams) {
        TLogUtil.playLog("request live liveId=" + playParams.getPlayIdParams().getPlayId());
        this.mState = IPlayInfoRequest.State.RUNNING;
        this.mPlayParams = playParams;
        if (!this.mIsCancel) {
            String playId = playParams.getPlayIdParams().getPlayId();
            ResultCode resultCode = new ResultCode();
            PlayInfoResponse queryPlayInfoResponse = CachePool.getInstance().queryPlayInfoResponse(this.mPlayerConfig.getContext(), PlayDefinition.PlayInfoType.LIVE, playId, "", resultCode);
            if (queryPlayInfoResponse != null) {
                this.mState = IPlayInfoRequest.State.FINISHED;
                playParams.putString("fastUrlType", "response");
                playParams.putString(TableField.USE_MIN_SET, "1");
                reportResult(queryPlayInfoResponse);
                return;
            }
            playParams.putString(TableField.USE_MIN_SET, resultCode.code);
            this.mLiveRequest.setRequestCallback(new IPlayInfoRequest.Callback() {
                /* class com.youku.playerservice.axp.playinfo.request.LiveWithCacheRequest.AnonymousClass1 */

                @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest.Callback
                public void onFinished(PlayParams playParams, List<PlayInfoResponse> list) {
                    LiveWithCacheRequest.this.mResponses = list;
                    LiveWithCacheRequest.this.mState = IPlayInfoRequest.State.FINISHED;
                    if (LiveWithCacheRequest.this.mCallback != null && !LiveWithCacheRequest.this.mIsCancel) {
                        LiveWithCacheRequest.this.mCallback.onFinished(playParams, list);
                    }
                }
            });
            this.mLiveRequest.request(playParams);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void setRequestCallback(IPlayInfoRequest.Callback callback) {
        this.mCallback = callback;
    }
}

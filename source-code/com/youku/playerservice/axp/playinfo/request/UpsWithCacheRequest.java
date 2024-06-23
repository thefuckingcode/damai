package com.youku.playerservice.axp.playinfo.request;

import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.cache.CachePool;
import com.youku.playerservice.axp.cache.ResultCode;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.vpm.constants.TableField;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
public class UpsWithCacheRequest implements IPlayInfoRequest {
    private IPlayInfoRequest.Callback mCallback;
    private volatile boolean mIsCancel;
    private PlayParams mPlayParams;
    private final PlayerConfig mPlayerConfig;
    private List<PlayInfoResponse> mResponses;
    private IPlayInfoRequest.State mState = IPlayInfoRequest.State.IDLE;
    private final UpsRequest mUpsRequest;

    public UpsWithCacheRequest(PlayerConfig playerConfig) {
        this.mPlayerConfig = playerConfig;
        this.mUpsRequest = new UpsRequest(playerConfig);
    }

    private void reportResult(PlayParams playParams, PlayInfoResponse playInfoResponse) {
        if (this.mCallback != null && !this.mIsCancel) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(playInfoResponse);
            this.mCallback.onFinished(playParams, arrayList);
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
        this.mState = IPlayInfoRequest.State.RUNNING;
        this.mPlayParams = playParams;
        if (!this.mIsCancel) {
            String playId = playParams.getPlayIdParams().getPlayId();
            String string = this.mPlayerConfig.getString(TableField.PLAYER_SOURCE);
            ResultCode resultCode = new ResultCode();
            PlayInfoResponse queryPlayInfoResponse = CachePool.getInstance().queryPlayInfoResponse(this.mPlayerConfig.getContext(), PlayDefinition.PlayInfoType.UPS, playId, string, resultCode);
            if (queryPlayInfoResponse != null) {
                ArrayList arrayList = new ArrayList();
                this.mResponses = arrayList;
                arrayList.add(queryPlayInfoResponse);
                this.mState = IPlayInfoRequest.State.FINISHED;
                playParams.putString("fastUrlType", "response");
                playParams.putString(TableField.USE_MIN_SET, "1");
                reportResult(playParams, queryPlayInfoResponse);
                return;
            }
            playParams.putString(TableField.USE_MIN_SET, resultCode.code);
            this.mUpsRequest.setRequestCallback(new IPlayInfoRequest.Callback() {
                /* class com.youku.playerservice.axp.playinfo.request.UpsWithCacheRequest.AnonymousClass1 */

                @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest.Callback
                public void onFinished(PlayParams playParams, List<PlayInfoResponse> list) {
                    UpsWithCacheRequest.this.mResponses = list;
                    UpsWithCacheRequest.this.mState = IPlayInfoRequest.State.FINISHED;
                    if (UpsWithCacheRequest.this.mCallback != null && !UpsWithCacheRequest.this.mIsCancel) {
                        UpsWithCacheRequest.this.mCallback.onFinished(playParams, list);
                    }
                }
            });
            this.mUpsRequest.request(playParams);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void setRequestCallback(IPlayInfoRequest.Callback callback) {
        this.mCallback = callback;
    }
}

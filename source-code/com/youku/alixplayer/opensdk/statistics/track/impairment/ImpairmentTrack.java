package com.youku.alixplayer.opensdk.statistics.track.impairment;

import android.text.TextUtils;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.opensdk.AlixPlayerContainer;
import com.youku.alixplayer.opensdk.YoukuVideoInfo;
import com.youku.alixplayer.opensdk.statistics.Track;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.media.arch.instruments.ConfigFetcher;
import tb.gl2;

/* compiled from: Taobao */
public class ImpairmentTrack {
    public static final String TAG = "Impairment";
    private boolean isloading;
    private ImpairmentCommit mCommit;
    protected int mDropCount;
    public double mImpairmentDuration = 0.0d;
    public int mImpairmentOrder = 0;
    private AlixPlayerContainer mPlayer;
    private StartLoadingCommit mStartLoadingCommit;
    private Track mTrack;

    public ImpairmentTrack(Track track) {
        this.mPlayer = track.getPlayerContainer();
        this.mTrack = track;
    }

    public double getDropCount() {
        return (double) this.mDropCount;
    }

    public double getImpairmentDuration() {
        return this.mImpairmentDuration;
    }

    public double getImpairmentFrequency() {
        return (double) this.mImpairmentOrder;
    }

    public void onDropVideoFrames(int i) {
        this.mDropCount++;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    public void onPlayLoadingEnd(String str, int i, int i2, Object obj) {
        double d;
        double impairmentDuration;
        Exception e;
        TLogUtil.loge("Impairment", "onPlayLoadingEnd ----> action:" + str + " arg1:" + i + " arg2:" + i2 + " isloading:" + this.isloading);
        if (this.isloading) {
            YoukuVideoInfo youkuVideoInfo = this.mTrack.getYoukuVideoInfo();
            double d2 = 0.0d;
            try {
                d = Double.parseDouble(this.mTrack.getPlayerInfoByKey(0)) / 1000.0d;
                try {
                    d2 = Double.parseDouble(this.mTrack.getPlayerInfoByKey(1)) / 1000.0d;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    TLogUtil.loge("Impairment", "loading end totaldownload size " + d + " totalConsumedSizeEnd " + d2 + " left " + (d - d2));
                    this.mStartLoadingCommit.cancel();
                    this.isloading = false;
                    this.mCommit.setDownLoadSizeEnd(d);
                    this.mCommit.setConsumedSizeSEnd(d2);
                    this.mCommit.onLoadingEnd();
                    impairmentDuration = this.mCommit.getImpairmentDuration();
                    if (impairmentDuration >= ((double) Integer.parseInt(ConfigFetcher.getInstance().getConfig("autoQualitySwitch", "impairmentTimeLimit", gl2.PERFORM_CANCEL)))) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                d = 0.0d;
                e.printStackTrace();
                TLogUtil.loge("Impairment", "loading end totaldownload size " + d + " totalConsumedSizeEnd " + d2 + " left " + (d - d2));
                this.mStartLoadingCommit.cancel();
                this.isloading = false;
                this.mCommit.setDownLoadSizeEnd(d);
                this.mCommit.setConsumedSizeSEnd(d2);
                this.mCommit.onLoadingEnd();
                impairmentDuration = this.mCommit.getImpairmentDuration();
                if (impairmentDuration >= ((double) Integer.parseInt(ConfigFetcher.getInstance().getConfig("autoQualitySwitch", "impairmentTimeLimit", gl2.PERFORM_CANCEL)))) {
                }
            }
            TLogUtil.loge("Impairment", "loading end totaldownload size " + d + " totalConsumedSizeEnd " + d2 + " left " + (d - d2));
            this.mStartLoadingCommit.cancel();
            this.isloading = false;
            this.mCommit.setDownLoadSizeEnd(d);
            this.mCommit.setConsumedSizeSEnd(d2);
            this.mCommit.onLoadingEnd();
            impairmentDuration = this.mCommit.getImpairmentDuration();
            if (impairmentDuration >= ((double) Integer.parseInt(ConfigFetcher.getInstance().getConfig("autoQualitySwitch", "impairmentTimeLimit", gl2.PERFORM_CANCEL)))) {
                this.mImpairmentDuration += impairmentDuration;
                this.mImpairmentOrder++;
                this.mTrack.getAdTrack().onEndLoading();
                this.mCommit.commit(youkuVideoInfo, (double) this.mImpairmentOrder, str, i, i2, obj);
            }
        } else if (i == 0) {
            TLogUtil.vpmLog("arg1==0 and return  isloading:" + this.isloading);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00f2  */
    public void onPlayLoadingStart(String str, int i, int i2, Object obj) {
        double d;
        Exception e;
        TLogUtil.loge("Impairment", "onPlayLoadingStart ----> action:" + str + " arg1:" + i + " arg2:" + i2 + " mTrack.isRealVideoStarted:" + this.mTrack.isRealVideoStarted());
        if (!this.mTrack.isRealVideoStarted()) {
            TLogUtil.loge("Impairment", "onPlayLoadingStart is not realVideoStarted ");
            this.isloading = false;
            return;
        }
        YoukuVideoInfo youkuVideoInfo = this.mTrack.getYoukuVideoInfo();
        StartLoadingCommit startLoadingCommit = this.mStartLoadingCommit;
        if (startLoadingCommit != null) {
            startLoadingCommit.cancel();
        }
        StartLoadingCommit startLoadingCommit2 = new StartLoadingCommit(this.mTrack);
        this.mStartLoadingCommit = startLoadingCommit2;
        startLoadingCommit2.commitDelayed(youkuVideoInfo, str, i, i2, obj);
        double d2 = 0.0d;
        try {
            d = Double.parseDouble(this.mTrack.getPlayerInfoByKey(0)) / 1000.0d;
            try {
                d2 = Double.parseDouble(this.mTrack.getPlayerInfoByKey(1)) / 1000.0d;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                TLogUtil.loge("Impairment", "loading start totaldownload size " + d + " totalConsumedSizeStart " + d2 + " left " + (d - d2));
                ImpairmentCommit impairmentCommit = new ImpairmentCommit(this.mTrack, (double) this.mPlayer.getPlayer().getCurrentPosition(Aliplayer.PositionType.NORMAL));
                impairmentCommit.setDownLoadSizeStart(d);
                impairmentCommit.setConsumedSizeStart(d2);
                String dimension = impairmentCommit.getDimension("URL");
                this.mTrack.getAdTrack().onStartLoading(3);
                if (this.mCommit != null) {
                }
                this.mCommit = impairmentCommit;
                this.isloading = true;
            }
        } catch (Exception e3) {
            e = e3;
            d = 0.0d;
            e.printStackTrace();
            TLogUtil.loge("Impairment", "loading start totaldownload size " + d + " totalConsumedSizeStart " + d2 + " left " + (d - d2));
            ImpairmentCommit impairmentCommit2 = new ImpairmentCommit(this.mTrack, (double) this.mPlayer.getPlayer().getCurrentPosition(Aliplayer.PositionType.NORMAL));
            impairmentCommit2.setDownLoadSizeStart(d);
            impairmentCommit2.setConsumedSizeStart(d2);
            String dimension2 = impairmentCommit2.getDimension("URL");
            this.mTrack.getAdTrack().onStartLoading(3);
            if (this.mCommit != null) {
            }
            this.mCommit = impairmentCommit2;
            this.isloading = true;
        }
        TLogUtil.loge("Impairment", "loading start totaldownload size " + d + " totalConsumedSizeStart " + d2 + " left " + (d - d2));
        ImpairmentCommit impairmentCommit22 = new ImpairmentCommit(this.mTrack, (double) this.mPlayer.getPlayer().getCurrentPosition(Aliplayer.PositionType.NORMAL));
        impairmentCommit22.setDownLoadSizeStart(d);
        impairmentCommit22.setConsumedSizeStart(d2);
        String dimension22 = impairmentCommit22.getDimension("URL");
        if (!TextUtils.isEmpty(dimension22) && (dimension22.contains("/ad/") || dimension22.contains("ccode=0902"))) {
            this.mTrack.getAdTrack().onStartLoading(3);
        }
        if (this.mCommit != null) {
            impairmentCommit22.setImpairmentInterval(impairmentCommit22.getStartTime() - this.mCommit.getEndTime());
        }
        this.mCommit = impairmentCommit22;
        this.isloading = true;
    }
}

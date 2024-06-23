package com.youku.vpm.track.impairment;

import android.text.TextUtils;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.media.arch.instruments.utils.RemoteLogger;
import com.youku.vpm.IVpmFullInfo;
import com.youku.vpm.track.Track;
import com.youku.vpm.utils.TLogUtil;
import tb.gl2;

/* compiled from: Taobao */
public class ImpairmentTrack {
    public static final String TAG = "Impairment";
    private boolean isloading;
    private ImpairmentReport mCommit;
    protected int mDropCount;
    public double mImpairmentDuration = 0.0d;
    public int mImpairmentOrder = 0;
    private Track mTrack;

    public ImpairmentTrack(Track track) {
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

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    public void onPlayLoadingEnd(String str, int i, int i2, Object obj) {
        double d;
        double impairmentDuration;
        Exception e;
        TLogUtil.loge("Impairment", "onPlayLoadingEnd ----> action:" + str + " arg1:" + i + " arg2:" + i2 + " isloading:" + this.isloading);
        if (this.isloading) {
            IVpmFullInfo vpmFullInfo = this.mTrack.getVpmFullInfo();
            double d2 = 0.0d;
            try {
                d = Double.parseDouble(this.mTrack.getPlayer().getPlayerInfoByKey(0)) / 1000.0d;
                try {
                    d2 = Double.parseDouble(this.mTrack.getPlayer().getPlayerInfoByKey(1)) / 1000.0d;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    TLogUtil.loge("Impairment", "loading end totaldownload size " + d + " totalConsumedSizeEnd " + d2 + " left " + (d - d2));
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
                this.isloading = false;
                this.mCommit.setDownLoadSizeEnd(d);
                this.mCommit.setConsumedSizeSEnd(d2);
                this.mCommit.onLoadingEnd();
                impairmentDuration = this.mCommit.getImpairmentDuration();
                if (impairmentDuration >= ((double) Integer.parseInt(ConfigFetcher.getInstance().getConfig("autoQualitySwitch", "impairmentTimeLimit", gl2.PERFORM_CANCEL)))) {
                }
            }
            TLogUtil.loge("Impairment", "loading end totaldownload size " + d + " totalConsumedSizeEnd " + d2 + " left " + (d - d2));
            this.isloading = false;
            this.mCommit.setDownLoadSizeEnd(d);
            this.mCommit.setConsumedSizeSEnd(d2);
            this.mCommit.onLoadingEnd();
            impairmentDuration = this.mCommit.getImpairmentDuration();
            if (impairmentDuration >= ((double) Integer.parseInt(ConfigFetcher.getInstance().getConfig("autoQualitySwitch", "impairmentTimeLimit", gl2.PERFORM_CANCEL)))) {
                this.mImpairmentDuration += impairmentDuration;
                this.mImpairmentOrder++;
                this.mTrack.getAdTrack().onEndLoading();
                this.mCommit.commit(vpmFullInfo, (double) this.mImpairmentOrder, str, i, i2, obj);
            }
        } else if (i == 0) {
            TLogUtil.vpmLog("arg1==0 and return  isloading:" + this.isloading);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00dd  */
    public void onPlayLoadingStart(String str, int i, int i2, Object obj) {
        double d;
        double d2;
        Exception e;
        RemoteLogger.log("Impairment", "onPlayLoadingStart ----> action:" + str + " arg1:" + i + " arg2:" + i2 + " mTrack.isRealVideoStarted:" + this.mTrack.isRealVideoStarted());
        if (!this.mTrack.isRealVideoStarted()) {
            RemoteLogger.log("Impairment", "onPlayLoadingStart is not realVideoStarted ");
            this.isloading = false;
            return;
        }
        IVpmFullInfo vpmFullInfo = this.mTrack.getVpmFullInfo();
        try {
            d2 = Double.parseDouble(this.mTrack.getPlayer().getPlayerInfoByKey(0)) / 1000.0d;
            try {
                d = Double.parseDouble(this.mTrack.getPlayer().getPlayerInfoByKey(1)) / 1000.0d;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                d = 0.0d;
                RemoteLogger.log("Impairment", "loading start totaldownload size " + d2 + " totalConsumedSizeStart " + d + " left " + (d2 - d));
                ImpairmentReport impairmentReport = new ImpairmentReport(this.mTrack, vpmFullInfo.getDouble("progress", 0.0d));
                impairmentReport.setDownLoadSizeStart(d2);
                impairmentReport.setConsumedSizeStart(d);
                String dimension = impairmentReport.getDimension("URL");
                this.mTrack.getAdTrack().onStartLoading(4);
                if (this.mCommit != null) {
                }
                this.mCommit = impairmentReport;
                this.isloading = true;
            }
        } catch (Exception e3) {
            e = e3;
            d2 = 0.0d;
            e.printStackTrace();
            d = 0.0d;
            RemoteLogger.log("Impairment", "loading start totaldownload size " + d2 + " totalConsumedSizeStart " + d + " left " + (d2 - d));
            ImpairmentReport impairmentReport2 = new ImpairmentReport(this.mTrack, vpmFullInfo.getDouble("progress", 0.0d));
            impairmentReport2.setDownLoadSizeStart(d2);
            impairmentReport2.setConsumedSizeStart(d);
            String dimension2 = impairmentReport2.getDimension("URL");
            this.mTrack.getAdTrack().onStartLoading(4);
            if (this.mCommit != null) {
            }
            this.mCommit = impairmentReport2;
            this.isloading = true;
        }
        RemoteLogger.log("Impairment", "loading start totaldownload size " + d2 + " totalConsumedSizeStart " + d + " left " + (d2 - d));
        ImpairmentReport impairmentReport22 = new ImpairmentReport(this.mTrack, vpmFullInfo.getDouble("progress", 0.0d));
        impairmentReport22.setDownLoadSizeStart(d2);
        impairmentReport22.setConsumedSizeStart(d);
        String dimension22 = impairmentReport22.getDimension("URL");
        if (!TextUtils.isEmpty(dimension22) && (dimension22.contains("/ad/") || dimension22.contains("ccode=0902"))) {
            this.mTrack.getAdTrack().onStartLoading(4);
        }
        if (this.mCommit != null) {
            impairmentReport22.setImpairmentInterval(impairmentReport22.getStartTime() - this.mCommit.getEndTime());
        }
        this.mCommit = impairmentReport22;
        this.isloading = true;
    }
}

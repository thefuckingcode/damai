package com.taobao.tao.remotebusiness.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.taobao.tao.remotebusiness.IRemoteCacheListener;
import com.taobao.tao.remotebusiness.IRemoteListener;
import com.taobao.tao.remotebusiness.IRemoteProcessListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.common.MtopEvent;
import mtopsdk.mtop.common.MtopHeaderEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopProgressEvent;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.MtopStatistics;

/* compiled from: Taobao */
public class HandlerMgr extends Handler {
    public static final int ON_CACHED = 4;
    public static final int ON_DATA_RECEIVED = 1;
    public static final int ON_FINISHED = 3;
    public static final int ON_HEADER = 2;
    private static final String TAG = "mtopsdk.HandlerMgr";
    private static volatile Handler mHandler;

    private HandlerMgr(Looper looper) {
        super(looper);
    }

    public static HandlerParam getHandlerMsg(MtopListener mtopListener, MtopEvent mtopEvent, MtopBusiness mtopBusiness) {
        return new HandlerParam(mtopListener, mtopEvent, mtopBusiness);
    }

    public static Handler instance() {
        if (mHandler == null) {
            synchronized (HandlerMgr.class) {
                if (mHandler == null) {
                    mHandler = new HandlerMgr(Looper.getMainLooper());
                }
            }
        }
        return mHandler;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x019c  */
    public void handleMessage(Message message) {
        long j;
        MtopStatistics.RbStatisticData rbStatisticData;
        MtopStatistics mtopStatistics;
        Handler handler;
        MtopStatistics mtopStat;
        final HandlerParam handlerParam = (HandlerParam) message.obj;
        String str = "";
        if (handlerParam == null) {
            TBSdkLog.e(TAG, str, "HandlerMsg is null.");
            return;
        }
        MtopBusiness mtopBusiness = handlerParam.mtopBusiness;
        if (mtopBusiness != null) {
            str = mtopBusiness.getSeqNo();
            if (handlerParam.mtopBusiness.isTaskCanceled()) {
                TBSdkLog.i(TAG, str, "The request of MtopBusiness is cancelled.");
                return;
            }
        }
        Object reqContext = handlerParam.mtopBusiness.getReqContext();
        int i = message.what;
        if (i == 1) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, str, "onReceive: ON_DATA_RECEIVED.");
            }
            try {
                ((IRemoteProcessListener) handlerParam.listener).onDataReceived((MtopProgressEvent) handlerParam.event, reqContext);
            } catch (Throwable th) {
                TBSdkLog.e(TAG, str, "listener onDataReceived callback error.", th);
            }
        } else if (i == 2) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, str, "onReceive: ON_HEADER.");
            }
            try {
                ((IRemoteProcessListener) handlerParam.listener).onHeader((MtopHeaderEvent) handlerParam.event, reqContext);
            } catch (Throwable th2) {
                TBSdkLog.e(TAG, str, "listener onHeader callback error.", th2);
            }
        } else if (i == 3) {
            TBSdkLog.LogEnable logEnable = TBSdkLog.LogEnable.InfoEnable;
            if (TBSdkLog.isLogEnable(logEnable)) {
                TBSdkLog.i(TAG, str, "onReceive: ON_FINISHED.");
            }
            long currentTimeMillis = System.currentTimeMillis();
            MtopResponse mtopResponse = handlerParam.mtopResponse;
            long j2 = 0;
            if (mtopResponse != null) {
                mtopStatistics = mtopResponse.getMtopStat();
                if (mtopStatistics != null) {
                    rbStatisticData = mtopStatistics.getRbStatData();
                    rbStatisticData.toMainThTime = currentTimeMillis - handlerParam.mtopBusiness.onBgFinishTime;
                    j = handlerParam.mtopResponse.getBytedata() != null ? (long) handlerParam.mtopResponse.getBytedata().length : 0;
                    handler = handlerParam.mtopBusiness.mtopProp.handler;
                    if (handler == null) {
                        if (mtopStatistics != null) {
                            mtopStatistics.isMain = handler.getLooper().equals(Looper.getMainLooper());
                            long currentTimeMillis2 = System.currentTimeMillis();
                            mtopStatistics.rspCbStart = currentTimeMillis2;
                            mtopStatistics.rspCbEnd = currentTimeMillis2;
                        }
                        handlerParam.mtopBusiness.mtopProp.handler.post(new Runnable() {
                            /* class com.taobao.tao.remotebusiness.handler.HandlerMgr.AnonymousClass1 */

                            public void run() {
                                HandlerParam handlerParam = handlerParam;
                                handlerParam.mtopBusiness.doFinish(handlerParam.mtopResponse, handlerParam.pojo);
                            }
                        });
                    } else {
                        if (rbStatisticData != null) {
                            j2 = mtopStatistics.currentTimeMillis();
                            mtopStatistics.rspCbStart = System.currentTimeMillis();
                        }
                        handlerParam.mtopBusiness.doFinish(handlerParam.mtopResponse, handlerParam.pojo);
                        if (rbStatisticData != null) {
                            rbStatisticData.bizCallbackTime = mtopStatistics.currentTimeMillis() - j2;
                            mtopStatistics.rspCbEnd = System.currentTimeMillis();
                        }
                    }
                    if (TBSdkLog.isLogEnable(logEnable)) {
                        StringBuilder sb = new StringBuilder(128);
                        sb.append("onReceive: ON_FINISHED. ");
                        sb.append("doFinishTime=");
                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                        sb.append("; dataSize=");
                        sb.append(j);
                        sb.append("; ");
                        if (rbStatisticData != null) {
                            sb.append(rbStatisticData.toString());
                        }
                        TBSdkLog.i(TAG, str, sb.toString());
                    }
                    if (mtopStatistics != null) {
                        mtopStatistics.commitStatData(true);
                        mtopStatistics.commitFullTrace();
                    }
                } else {
                    j = 0;
                }
            } else {
                j = 0;
                mtopStatistics = null;
            }
            rbStatisticData = null;
            handler = handlerParam.mtopBusiness.mtopProp.handler;
            if (handler == null) {
            }
            if (TBSdkLog.isLogEnable(logEnable)) {
            }
            if (mtopStatistics != null) {
            }
        } else if (i == 4) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, str, "onReceive: ON_CACHED");
            }
            MtopCacheEvent mtopCacheEvent = (MtopCacheEvent) handlerParam.event;
            if (mtopCacheEvent == null) {
                TBSdkLog.e(TAG, str, "HandlerMsg.event is null.");
                return;
            }
            if (!(mtopCacheEvent.getMtopResponse() == null || (mtopStat = mtopCacheEvent.getMtopResponse().getMtopStat()) == null)) {
                MtopStatistics.RbStatisticData rbStatData = mtopStat.getRbStatData();
                rbStatData.toMainThTime = System.currentTimeMillis() - handlerParam.mtopBusiness.onBgFinishTime;
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.d(TAG, str, rbStatData.toString());
                }
                mtopStat.commitStatData(true);
            }
            try {
                if (handlerParam.listener instanceof IRemoteCacheListener) {
                    TBSdkLog.i(TAG, str, "listener onCached callback");
                    ((IRemoteCacheListener) handlerParam.listener).onCached(mtopCacheEvent, handlerParam.pojo, reqContext);
                } else {
                    TBSdkLog.i(TAG, handlerParam.mtopBusiness.getSeqNo(), "listener onCached transfer to onSuccess callback");
                    ((IRemoteListener) handlerParam.listener).onSuccess(handlerParam.mtopBusiness.getRequestType(), handlerParam.mtopResponse, handlerParam.pojo, reqContext);
                }
            } catch (Throwable th3) {
                TBSdkLog.e(TAG, str, "listener onCached callback error.", th3);
            }
        }
        message.obj = null;
    }
}

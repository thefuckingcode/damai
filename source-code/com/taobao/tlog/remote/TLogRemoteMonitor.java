package com.taobao.tlog.remote;

import android.content.Context;
import android.util.Log;
import com.alibaba.ha.bizerrorreporter.BizErrorBuilder;
import com.alibaba.ha.bizerrorreporter.BizErrorReporter;
import com.alibaba.ha.bizerrorreporter.module.AggregationType;
import com.alibaba.ha.bizerrorreporter.module.BizErrorModule;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.tao.log.TLog;
import com.taobao.tao.log.monitor.TLogMonitor;
import com.taobao.tao.log.monitor.TLogStage;

/* compiled from: Taobao */
public class TLogRemoteMonitor implements TLogMonitor {
    private static String BIZ_ERROR_TYPE = "TLOG_MONITOR";
    private static String MONITOR_POINTER = "TLOG_MONITOR_STAGE";
    private static String PAGE = "TLOG_MONITOR";
    public static String TAG = "tlogRemotge.TLogRemoteMonitor";
    private static String TLOG_MODEL = "TLOG_MONITOR";
    private static String dim_stage = "stage";
    private static String mea_errorCount = "errorStageCount";
    private static String mea_totalCount = "totalStageCount";
    private Context mContext = null;

    private String buildInfo(String str, String str2) {
        return str + " : " + str2;
    }

    private void monitorStageError(String str) {
        DimensionValueSet create = DimensionValueSet.create();
        create.setValue(dim_stage, str);
        MeasureValueSet create2 = MeasureValueSet.create();
        create2.setValue(mea_totalCount, 0.0d);
        create2.setValue(mea_errorCount, 1.0d);
        AppMonitor.Stat.commit(PAGE, MONITOR_POINTER, create, create2);
    }

    private void registMonitorStage() {
        try {
            DimensionSet create = DimensionSet.create();
            create.addDimension(dim_stage);
            MeasureSet create2 = MeasureSet.create();
            create2.addMeasure(mea_totalCount);
            create2.addMeasure(mea_errorCount);
            AppMonitor.register(PAGE, MONITOR_POINTER, create2, create, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(Context context) {
        this.mContext = context;
        registMonitorStage();
    }

    @Override // com.taobao.tao.log.monitor.TLogMonitor
    public void stageError(String str, String str2, String str3) {
        try {
            TLog.logw(TLOG_MODEL, str, buildInfo(str2, str3));
            String str4 = TAG;
            Log.e(str4, str + ":" + str2 + ":" + str3);
            BizErrorModule bizErrorModule = new BizErrorModule();
            bizErrorModule.aggregationType = AggregationType.CONTENT;
            bizErrorModule.businessType = BIZ_ERROR_TYPE;
            bizErrorModule.exceptionCode = str;
            bizErrorModule.exceptionId = str2;
            bizErrorModule.exceptionDetail = str3;
            bizErrorModule.exceptionVersion = BizErrorBuilder._VERSION;
            if (this.mContext != null) {
                BizErrorReporter.getInstance().send(this.mContext, bizErrorModule);
            } else {
                Log.e(TAG, "you need call TLogRemoteMonitor.init() method ");
            }
            monitorStageError(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.tao.log.monitor.TLogMonitor
    public void stageInfo(String str, String str2, String str3) {
        try {
            TLog.logi(TLOG_MODEL, str, buildInfo(str2, str3));
            Log.w(TAG, str + ":" + str2 + ":" + str3);
            if (!str.equals(TLogStage.MSG_SEND)) {
                if (!str.equals(TLogStage.MSG_LOG_UPLOAD)) {
                    if (!str.equals(TLogStage.MSG_REVEIVE)) {
                        str = null;
                    }
                }
            }
            if (str != null) {
                DimensionValueSet create = DimensionValueSet.create();
                create.setValue(dim_stage, str);
                MeasureValueSet create2 = MeasureValueSet.create();
                create2.setValue(mea_totalCount, 1.0d);
                create2.setValue(mea_errorCount, 0.0d);
                AppMonitor.Stat.commit(PAGE, MONITOR_POINTER, create, create2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.taobao.tao.log.monitor.TLogMonitor
    public void stageError(String str, String str2, Throwable th) {
        try {
            TLog.loge(TLOG_MODEL, str, th);
            String str3 = TAG;
            Log.e(str3, str + ":" + str2, th);
            BizErrorModule bizErrorModule = new BizErrorModule();
            bizErrorModule.aggregationType = AggregationType.STACK;
            bizErrorModule.businessType = BIZ_ERROR_TYPE;
            bizErrorModule.exceptionCode = str;
            bizErrorModule.exceptionId = str2;
            bizErrorModule.exceptionVersion = BizErrorBuilder._VERSION;
            bizErrorModule.throwable = th;
            if (this.mContext != null) {
                BizErrorReporter.getInstance().send(this.mContext, bizErrorModule);
            } else {
                Log.e(TAG, "you need call TLogRemoteMonitor.init() method ");
            }
            monitorStageError(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.alibaba.motu.crashreporter2;

import android.content.Context;
import com.alibaba.ha.bizerrorreporter.BizErrorConstants;
import com.alibaba.motu.crashreporter.Configuration;
import com.alibaba.motu.crashreporter.CrashReport;
import com.alibaba.motu.crashreporter.ICrashReportSendListener;
import com.alibaba.motu.crashreporter.LogUtil;
import com.alibaba.motu.crashreporter.MotuCrashReporter;
import com.alibaba.motu.crashreporter.ReporterContext;
import com.alibaba.motu.crashreporter.async.AsyncThreadPool;
import com.alibaba.motu.tbrest.SendService;
import com.alibaba.motu.tbrest.rest.RestConstants;
import com.alibaba.motu.tbrest.rest.RestUrlWrapper;
import com.alibaba.motu.tbrest.utils.Base64;
import com.alibaba.motu.tbrest.utils.GzipUtils;
import com.alibaba.motu.tbrest.utils.StringUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* access modifiers changed from: package-private */
/* compiled from: Taobao */
public final class SendManager {
    Configuration mConfiguration;
    Context mContext;
    ReportBuilder mReportBuilder;
    ReportSender mReportSender;
    ReporterContext mReporterContext;
    AtomicBoolean mSending = new AtomicBoolean(false);
    Map<String, CrashReport> mWaitingSend = new ConcurrentHashMap();
    Map<String, ICrashReportSendListener> sendListenerMap = new ConcurrentHashMap();

    /* compiled from: Taobao */
    class DefaultSender implements ReportSender {
        Configuration mConfiguration;
        Context mContext;
        ReporterContext mReporterContext;

        public DefaultSender(Context context, ReporterContext reporterContext, Configuration configuration) {
            this.mContext = context;
            this.mReporterContext = reporterContext;
            this.mConfiguration = configuration;
            if (configuration.getBoolean(Configuration.enableSecuritySDK, true)) {
                RestUrlWrapper.enableSecuritySDK();
                RestUrlWrapper.setContext(this.mContext);
            }
        }

        @Override // com.alibaba.motu.crashreporter2.SendManager.ReportSender
        public boolean sendReport(CrashReport crashReport) {
            int i;
            String str;
            if (crashReport == null) {
                return true;
            }
            if ("java".equals(crashReport.mReportType)) {
                i = 1;
            } else if ("native".equals(crashReport.mReportType) || "anr".equals(crashReport.mReportType)) {
                i = 61006;
            } else {
                LogUtil.i(String.format("unsupport report type:%s path:%s", crashReport.mReportType, crashReport.mReportPath));
                return true;
            }
            crashReport.mPropertys.copyTo(new HashMap());
            String string = this.mConfiguration.getString(Configuration.adashxServerHost, RestConstants.G_DEFAULT_ADASHX_HOST);
            String reportContent = crashReport.getReportContent();
            if (Configuration.getInstance().getBoolean(Configuration.enableReportContentCompress, true)) {
                reportContent = Base64.encodeBase64String(GzipUtils.gzip(reportContent.getBytes()));
                str = BizErrorConstants.SEND_FLAG;
            } else {
                str = "MOTU_REPORTER_SDK_3.0.0_PRIVATE";
            }
            return SendService.getInstance().sendRequest(string, System.currentTimeMillis(), "-", i, str, reportContent, "-", null).booleanValue();
        }
    }

    /* compiled from: Taobao */
    interface ReportSender {
        boolean sendReport(CrashReport crashReport);
    }

    public SendManager(Context context, ReporterContext reporterContext, Configuration configuration, ReportBuilder reportBuilder) {
        this.mContext = context;
        this.mReporterContext = reporterContext;
        this.mConfiguration = configuration;
        this.mReportBuilder = reportBuilder;
        this.mReportSender = new DefaultSender(context, reporterContext, configuration);
    }

    public void addListener(ICrashReportSendListener iCrashReportSendListener) {
        if (iCrashReportSendListener != null && StringUtils.isNotBlank(iCrashReportSendListener.getName())) {
            this.sendListenerMap.put(iCrashReportSendListener.getName(), iCrashReportSendListener);
        }
    }

    public void removeListener(ICrashReportSendListener iCrashReportSendListener) {
        if (iCrashReportSendListener != null && StringUtils.isNotBlank(iCrashReportSendListener.getName())) {
            this.sendListenerMap.remove(iCrashReportSendListener.getName());
        }
    }

    public void sendAllReport() {
        sendReports(this.mReportBuilder.listProcessCrashReport());
    }

    public void sendReport(CrashReport crashReport) {
        sendReports(new CrashReport[]{crashReport});
    }

    public void sendReports(CrashReport[] crashReportArr) {
        if (crashReportArr != null) {
            for (CrashReport crashReport : crashReportArr) {
                if (crashReport != null && StringUtils.isNotBlank(crashReport.mReportPath)) {
                    this.mWaitingSend.put(crashReport.mReportPath, crashReport);
                }
            }
            if (!this.mWaitingSend.isEmpty() && this.mSending.compareAndSet(false, true)) {
                AnonymousClass1 r7 = new Runnable() {
                    /* class com.alibaba.motu.crashreporter2.SendManager.AnonymousClass1 */

                    public void run() {
                        try {
                            Iterator<Map.Entry<String, CrashReport>> it = SendManager.this.mWaitingSend.entrySet().iterator();
                            if (it != null) {
                                while (it.hasNext()) {
                                    Map.Entry<String, CrashReport> next = it.next();
                                    if (next != null) {
                                        try {
                                            CrashReport value = next.getValue();
                                            if (value != null) {
                                                if (StringUtils.isBlank(value.mReportPath) || StringUtils.isBlank(value.mReportName) || StringUtils.isBlank(value.mReportType)) {
                                                    try {
                                                        value.deleteReportFile();
                                                    } catch (Exception e) {
                                                        LogUtil.e("remote invalid crash report.", e);
                                                    }
                                                } else {
                                                    try {
                                                        if (value.isComplete()) {
                                                            value.extractPropertys();
                                                            for (ICrashReportSendListener iCrashReportSendListener : SendManager.this.sendListenerMap.values()) {
                                                                try {
                                                                    iCrashReportSendListener.beforeSend(value);
                                                                } catch (Exception e2) {
                                                                    LogUtil.e("beforeSend", e2);
                                                                }
                                                            }
                                                            boolean sendReport = SendManager.this.mReportSender.sendReport(value);
                                                            for (ICrashReportSendListener iCrashReportSendListener2 : SendManager.this.sendListenerMap.values()) {
                                                                try {
                                                                    iCrashReportSendListener2.afterSend(sendReport, value);
                                                                } catch (Exception e3) {
                                                                    LogUtil.e("beforeSend", e3);
                                                                }
                                                            }
                                                            if (sendReport) {
                                                                LogUtil.e("sendSucc");
                                                                TLogAdapter.log("sendSucc", value.mReportFile);
                                                                value.deleteReportFile();
                                                            }
                                                        } else if (!value.mCurrentTrigger) {
                                                            value.deleteReportFile();
                                                        }
                                                    } catch (Exception e4) {
                                                        LogUtil.e("send and del crash report.", e4);
                                                    }
                                                }
                                            }
                                        } catch (Throwable th) {
                                            it.remove();
                                            throw th;
                                        }
                                    }
                                    it.remove();
                                }
                            }
                        } finally {
                            SendManager.this.mSending.set(false);
                        }
                    }
                };
                AsyncThreadPool asyncThreadPool = MotuCrashReporter.getInstance().asyncTaskThread;
                AsyncThreadPool.start(r7);
            }
        }
    }
}

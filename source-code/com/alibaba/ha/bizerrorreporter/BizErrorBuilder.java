package com.alibaba.ha.bizerrorreporter;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.alibaba.ha.bizerrorreporter.module.BizErrorModule;
import com.alibaba.ha.bizerrorreporter.module.SendModule;
import com.alibaba.motu.tbrest.SendService;
import com.alibaba.motu.tbrest.utils.AppUtils;
import com.alibaba.motu.tbrest.utils.Base64;
import com.alibaba.motu.tbrest.utils.GzipUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.weex.annotation.JSMethod;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
public class BizErrorBuilder {
    public static final String _JAVA_VERSION = "";
    public static final String _MAGIC = "BizErrorReporterSDK";
    public static final String _NATIVE_VERSION = "160509105620";
    public static final String _TARGET = "beta";
    public static final String _VERSION = "1.0.0.0";

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public class JavaExceptionReportBuilder extends SimpleJavaExceptionReportBuilder {
        JavaExceptionReportBuilder(BizErrorModule bizErrorModule, Context context, String str, long j, String str2) {
            super(bizErrorModule, context, str, j, str2);
        }

        /* access modifiers changed from: protected */
        @Override // com.alibaba.ha.bizerrorreporter.BizErrorBuilder.ReportBuilder, com.alibaba.ha.bizerrorreporter.BizErrorBuilder.SimpleJavaExceptionReportBuilder
        public String buildContent() {
            StringBuilder sb = new StringBuilder();
            sb.append(buildThrowable());
            sb.append(buildExtraInfo());
            sb.append(buildStatus());
            sb.append(buildStorageinfo());
            sb.append(buildFileDescriptor());
            if (this.mThrowable instanceof OutOfMemoryError) {
                sb.append(buildApplictionMeminfo());
            }
            sb.append(buildLogcat());
            return sb.toString();
        }
    }

    /* compiled from: Taobao */
    class SimpleJavaExceptionReportBuilder extends ReportBuilder {
        String mExceptionContent;
        BizErrorModule mExceptionModule;
        Thread mThread;
        Throwable mThrowable;

        SimpleJavaExceptionReportBuilder(BizErrorModule bizErrorModule, Context context, String str, long j, String str2) {
            super();
            String str3;
            this.mExceptionModule = bizErrorModule;
            this.mThrowable = bizErrorModule.throwable;
            this.mThread = bizErrorModule.thread;
            this.mExceptionContent = bizErrorModule.exceptionDetail;
            if (this.mExtraInfo == null) {
                this.mExtraInfo = new HashMap();
            }
            String str4 = bizErrorModule.exceptionId;
            if (str4 != null) {
                this.mExtraInfo.put(BizErrorConstants.exceptionId, str4);
            }
            String str5 = bizErrorModule.exceptionCode;
            if (str5 != null) {
                this.mExtraInfo.put(BizErrorConstants.exceptionCode, str5);
            }
            String str6 = bizErrorModule.exceptionVersion;
            if (str6 != null) {
                this.mExtraInfo.put(BizErrorConstants.exceptionVersion, str6);
            }
            String str7 = bizErrorModule.exceptionArg1;
            if (str7 != null) {
                this.mExtraInfo.put(BizErrorConstants.exceptionArg1, str7);
            }
            String str8 = bizErrorModule.exceptionArg2;
            if (str8 != null) {
                this.mExtraInfo.put(BizErrorConstants.exceptionArg2, str8);
            }
            String str9 = bizErrorModule.exceptionArg3;
            if (str9 != null) {
                this.mExtraInfo.put(BizErrorConstants.exceptionArg3, str9);
            }
            if (!(this.mThrowable == null || (str3 = this.mExceptionContent) == null)) {
                this.mExtraInfo.put(BizErrorConstants.exceptionDetail, str3);
            }
            Map<String, Object> map = bizErrorModule.exceptionArgs;
            if (map != null && map.size() > 0) {
                this.mExtraInfo.putAll(map);
            }
            this.mContext = context;
            this.mReportName = str;
            this.mTimestamp = j;
            this.mReportType = str2;
        }

        /* access modifiers changed from: protected */
        @Override // com.alibaba.ha.bizerrorreporter.BizErrorBuilder.ReportBuilder
        public String buildContent() {
            return buildThrowable() + buildExtraInfo();
        }

        /* access modifiers changed from: protected */
        public String buildThread(Thread thread) {
            StringBuilder sb = new StringBuilder();
            try {
                sb.append(String.format("Thread Name: '%s'\n", thread.getName()));
                sb.append(String.format("\"%s\" prio=%d tid=%d %s\n", thread.getName(), Integer.valueOf(thread.getPriority()), Long.valueOf(thread.getId()), thread.getState()));
                StackTraceElement[] stackTrace = thread.getStackTrace();
                int length = stackTrace.length;
                for (int i = 0; i < length; i++) {
                    sb.append(String.format("\tat %s\n", stackTrace[i].toString()));
                }
            } catch (Exception e) {
                Log.e(BizErrorConstants.LOGTAG, "dumpThread", e);
            }
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00aa A[SYNTHETIC, Splitter:B:37:0x00aa] */
        public String buildThrowable() {
            Thread thread;
            ByteArrayOutputStream byteArrayOutputStream;
            Throwable th;
            Exception e;
            StringBuilder sb = new StringBuilder();
            try {
                sb.append(String.format("Process Name: '%s' \n", BizErrorReporter.getInstance().getProcessName(this.mContext)));
                Thread thread2 = this.mThread;
                if (thread2 != null) {
                    sb.append(String.format("Thread Name: '%s' \n", thread2.getName()));
                } else {
                    sb.append(String.format("Thread Name: '%s' \n", "adapter no thread name"));
                }
                sb.append("Back traces starts.\n");
                ByteArrayOutputStream byteArrayOutputStream2 = null;
                try {
                    if (this.mThrowable != null) {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            this.mThrowable.printStackTrace(new PrintStream(byteArrayOutputStream));
                            sb.append(byteArrayOutputStream.toString());
                            byteArrayOutputStream2 = byteArrayOutputStream;
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                Log.e(BizErrorConstants.LOGTAG, "print throwable", e);
                                AppUtils.closeQuietly(byteArrayOutputStream);
                                sb.append("Back traces end.\n");
                                sb.append(buildEnd());
                                thread = this.mThread;
                                if (thread != null) {
                                }
                                sb.append(buildEnd());
                                return sb.toString();
                            } catch (Throwable th2) {
                                th = th2;
                                AppUtils.closeQuietly(byteArrayOutputStream);
                                throw th;
                            }
                        }
                    } else {
                        String str = this.mExceptionContent;
                        if (str != null) {
                            sb.append(str);
                            sb.append(StringUtils.LF);
                        } else {
                            sb.append("无内容");
                        }
                    }
                    AppUtils.closeQuietly(byteArrayOutputStream2);
                } catch (Exception e3) {
                    byteArrayOutputStream = null;
                    e = e3;
                    Log.e(BizErrorConstants.LOGTAG, "print throwable", e);
                    AppUtils.closeQuietly(byteArrayOutputStream);
                    sb.append("Back traces end.\n");
                    sb.append(buildEnd());
                    thread = this.mThread;
                    if (thread != null) {
                    }
                    sb.append(buildEnd());
                    return sb.toString();
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                    AppUtils.closeQuietly(byteArrayOutputStream);
                    throw th;
                }
                sb.append("Back traces end.\n");
                sb.append(buildEnd());
            } catch (Exception e4) {
                Log.e(BizErrorConstants.LOGTAG, "write throwable", e4);
            }
            thread = this.mThread;
            if (thread != null) {
                try {
                    sb.append(buildThread(thread));
                } catch (Exception e5) {
                    Log.e(BizErrorConstants.LOGTAG, "write thread", e5);
                }
            }
            sb.append(buildEnd());
            return sb.toString();
        }
    }

    public static String buildReportName(String str, String str2, long j, String str3, String str4) {
        String replaceUnderscore = replaceUnderscore(str2);
        String replaceUnderscore2 = replaceUnderscore(str3);
        return "BizErrorReporterSDK_1.0.0.0_df_df_df_df_" + str + JSMethod.NOT_SET + replaceUnderscore + JSMethod.NOT_SET + String.valueOf(j) + JSMethod.NOT_SET + getGMT8Time(j) + JSMethod.NOT_SET + com.alibaba.motu.tbrest.utils.StringUtils.defaultString(replaceUnderscore2, "df") + JSMethod.NOT_SET + str4 + ".log";
    }

    public static String getGMT8Time(long j) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            return simpleDateFormat.format(new Date(j));
        } catch (Exception e) {
            Log.e(BizErrorConstants.LOGTAG, "getGMT8Time", e);
            return "";
        }
    }

    public static String replaceUnderscore(String str) {
        return str != null ? str.replace(JSMethod.NOT_SET, "&#95;") : "";
    }

    public SendModule build(Context context, BizErrorModule bizErrorModule) {
        SendModule sendModule = new SendModule();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            sendModule.sendContent = Base64.encodeBase64String(GzipUtils.gzip(new JavaExceptionReportBuilder(bizErrorModule, context, buildReportName(SendService.getInstance().appKey, SendService.getInstance().appVersion, currentTimeMillis, "catch", "BUSINESS"), currentTimeMillis, "BUSINESS").builder().getBytes()));
            sendModule.aggregationType = String.valueOf(bizErrorModule.aggregationType);
            sendModule.businessType = bizErrorModule.businessType;
            sendModule.eventId = BizErrorConstants.EVENTID_61005;
            sendModule.sendFlag = BizErrorConstants.SEND_FLAG;
            return sendModule;
        } catch (Exception e) {
            Log.e(BizErrorConstants.LOGTAG, "base64 and gzip err", e);
            return null;
        }
    }

    /* compiled from: Taobao */
    public abstract class ReportBuilder {
        Context mContext;
        Map<String, Object> mExtraInfo;
        long mFull;
        long mLimit;
        long mReject;
        String mReportName;
        String mReportType;
        long mTimestamp;
        long mWrite;

        public ReportBuilder() {
        }

        /* access modifiers changed from: protected */
        public String buildApplictionMeminfo() {
            return "appliction meminfo:\n" + AppUtils.dumpMeminfo(this.mContext) + buildEnd();
        }

        /* access modifiers changed from: protected */
        public String buildBanner() {
            StringBuilder sb = new StringBuilder();
            sb.append("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n");
            sb.append(String.format("Basic Information: 'pid: %d/tid: %d/logver: 2/time: %s/cpu: %s/cpu hardware: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), Long.valueOf(this.mTimestamp), Build.getCPU_ABI(), android.os.Build.HARDWARE));
            sb.append(String.format("Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.getMODEL(), Build.VERSION.getRELEASE(), Integer.valueOf(Build.VERSION.SDK_INT)));
            sb.append(String.format("Build fingerprint: '" + android.os.Build.FINGERPRINT + "'\n", new Object[0]));
            sb.append(String.format("Runtime Information: 'start: %s/maxheap: %s'\n", BizErrorReporter.getInstance().reporterStartTime, Long.valueOf(Runtime.getRuntime().maxMemory())));
            sb.append(String.format("Application Information: 'version: %s/subversion: %s/buildseq: %s'\n", SendService.getInstance().appVersion, SendService.getInstance().appVersion, android.os.Build.ID));
            sb.append(String.format("%s Information: 'version: %s/nativeseq: %s/javaseq: %s/target: %s'\n", BizErrorBuilder._MAGIC, BizErrorBuilder._VERSION, "160509105620", "", "beta"));
            sb.append("Report Name: " + this.mReportName + StringUtils.LF);
            sb.append("UUID: " + UUID.randomUUID().toString().toLowerCase() + StringUtils.LF);
            sb.append("Log Type: " + this.mReportType + StringUtils.LF);
            sb.append(buildEnd());
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public abstract String buildContent();

        /* access modifiers changed from: protected */
        public String buildDone() {
            return String.format("Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Long.valueOf(this.mFull), Long.valueOf(this.mWrite), Long.valueOf(this.mLimit), Long.valueOf(this.mReject)) + String.format("log end: %s\n", BizErrorBuilder.getGMT8Time(System.currentTimeMillis()));
        }

        /* access modifiers changed from: protected */
        public String buildEnd() {
            return "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
        }

        /* access modifiers changed from: protected */
        public String buildExtraInfo() {
            StringBuilder sb = new StringBuilder();
            Map<String, Object> map = this.mExtraInfo;
            if (map != null && !map.isEmpty()) {
                try {
                    sb.append("extrainfo:\n");
                    for (String str : this.mExtraInfo.keySet()) {
                        sb.append(String.format("%s: %s\n", str, this.mExtraInfo.get(str)));
                    }
                } catch (Exception e) {
                    Log.e(BizErrorConstants.LOGTAG, "write extral info", e);
                }
                sb.append(buildEnd());
            }
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public String buildFileDescriptor() {
            StringBuilder sb = new StringBuilder();
            File[] fileArr = null;
            try {
                fileArr = new File("/proc/self/fd").listFiles();
                if (fileArr != null) {
                    sb.append(String.format("opened file count: %d, write limit: %d.\n", Integer.valueOf(fileArr.length), 1024));
                } else {
                    sb.append("[DEBUG] listFiles failed!\n");
                }
            } catch (Exception e) {
                Log.e(BizErrorConstants.LOGTAG, "print file descriptor.", e);
            }
            if (fileArr != null) {
                try {
                    if (fileArr.length >= 1024) {
                        sb.append("opened files:\n");
                        StringBuilder sb2 = new StringBuilder();
                        try {
                            for (File file : fileArr) {
                                sb2.append(file.getName());
                                sb2.append(" -> ");
                                sb2.append(file.getCanonicalPath());
                                sb2.append(StringUtils.LF);
                            }
                        } catch (Exception e2) {
                            Log.e(BizErrorConstants.LOGTAG, "print file descriptor.", e2);
                        }
                        sb.append(sb2.toString());
                    }
                } catch (Exception e3) {
                    Log.e(BizErrorConstants.LOGTAG, "print file descriptor.", e3);
                }
            }
            sb.append(buildEnd());
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public String buildLogcat() {
            return buildLogcat(null, 100) + buildLogcat("events", 100);
        }

        /* access modifiers changed from: protected */
        public String buildStatus() {
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("meminfo:\n");
                sb.append(com.alibaba.motu.tbrest.utils.StringUtils.defaultString(AppUtils.getMeminfo(), "") + StringUtils.LF);
                sb.append(buildEnd());
            } catch (Exception e) {
                Log.e(BizErrorConstants.LOGTAG, "write meminfo.", e);
            }
            try {
                sb.append("status:\n");
                sb.append(com.alibaba.motu.tbrest.utils.StringUtils.defaultString(AppUtils.getMyStatus(), "") + StringUtils.LF);
                sb.append(buildEnd());
            } catch (Exception e2) {
                Log.e(BizErrorConstants.LOGTAG, "adapter write status.", e2);
            }
            try {
                sb.append("virtual machine:\nMaxMemory: " + Runtime.getRuntime().maxMemory() + " TotalMemory: " + Runtime.getRuntime().totalMemory() + " FreeMemory: " + Runtime.getRuntime().freeMemory() + StringUtils.LF);
            } catch (Exception e3) {
                Log.e(BizErrorConstants.LOGTAG, "adapter write virtual machine info.", e3);
            }
            sb.append(buildEnd());
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public String buildStorageinfo() {
            return "storageinfo:\n" + AppUtils.dumpStorage(this.mContext) + buildEnd();
        }

        public String builder() {
            return buildBanner() + buildContent() + buildDone();
        }

        private String buildLogcat(String str, int i) {
            Process process;
            Throwable th;
            int i2;
            int i3;
            int i4;
            int i5;
            Exception exc;
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = new ArrayList();
            arrayList.add("logcat");
            arrayList.add("-d");
            if (com.alibaba.motu.tbrest.utils.StringUtils.isBlank(str)) {
                sb.append("logcat main: \n");
            } else {
                sb.append("logcat " + str + ": \n");
                arrayList.add("-b");
                arrayList.add(str);
            }
            arrayList.add("-v");
            arrayList.add("threadtime");
            if (i < 0) {
                sb.append("[DEBUG] custom java logcat lines count is 0!\n");
            } else {
                arrayList.add("-t");
                arrayList.add(String.valueOf(i));
                BufferedReader bufferedReader = null;
                try {
                    process = new ProcessBuilder(new String[0]).command(arrayList).redirectErrorStream(true).start();
                } catch (Exception e) {
                    Log.e(BizErrorConstants.LOGTAG, "exec logcat", e);
                    process = null;
                }
                if (process == null) {
                    sb.append("[DEBUG] exec logcat failed!\n");
                } else {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()), 8192);
                        i2 = 0;
                        i3 = 0;
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                i2++;
                                if (i3 < i) {
                                    sb.append(readLine + StringUtils.LF);
                                    i3++;
                                }
                            } catch (Exception e2) {
                                i4 = i2;
                                bufferedReader = bufferedReader2;
                                i5 = i3;
                                exc = e2;
                                try {
                                    Log.e(BizErrorConstants.LOGTAG, "print log.", exc);
                                    AppUtils.closeQuietly(bufferedReader);
                                    i2 = i4;
                                    i3 = i5;
                                    sb.append(String.format("[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)));
                                    sb.append(buildEnd());
                                    return sb.toString();
                                } catch (Throwable th2) {
                                    bufferedReader2 = bufferedReader;
                                    th = th2;
                                    AppUtils.closeQuietly(bufferedReader2);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                AppUtils.closeQuietly(bufferedReader2);
                                throw th;
                            }
                        }
                        AppUtils.closeQuietly(bufferedReader2);
                    } catch (Exception e3) {
                        exc = e3;
                        i4 = 0;
                        i5 = 0;
                        Log.e(BizErrorConstants.LOGTAG, "print log.", exc);
                        AppUtils.closeQuietly(bufferedReader);
                        i2 = i4;
                        i3 = i5;
                        sb.append(String.format("[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)));
                        sb.append(buildEnd());
                        return sb.toString();
                    }
                    sb.append(String.format("[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)));
                }
            }
            sb.append(buildEnd());
            return sb.toString();
        }
    }
}

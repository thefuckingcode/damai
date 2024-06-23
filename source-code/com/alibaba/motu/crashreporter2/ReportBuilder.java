package com.alibaba.motu.crashreporter2;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.alibaba.motu.crashreporter.Configuration;
import com.alibaba.motu.crashreporter.Constants;
import com.alibaba.motu.crashreporter.CrashReport;
import com.alibaba.motu.crashreporter.LogUtil;
import com.alibaba.motu.crashreporter.ReporterContext;
import com.alibaba.motu.crashreporter2.CatcherManager;
import com.alibaba.motu.tbrest.utils.AppUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import tb.fw1;

/* compiled from: Taobao */
public final class ReportBuilder {
    Configuration mConfiguration;
    Context mContext;
    ReporterContext mReporterContext;
    StorageManager mStorageManager;

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class ANRReportPrintWrite extends FileReportPrintWrite {
        CatcherManager.ANRCatcher.TracesFinder mTracesFinder;

        ANRReportPrintWrite(Context context, ReporterContext reporterContext, Configuration configuration, String str, long j, File file, CatcherManager.ANRCatcher.TracesFinder tracesFinder) {
            super(context, reporterContext, configuration, str, "anr", j, file, null);
            this.mTracesFinder = tracesFinder;
        }

        private void printTraces() {
            Throwable th;
            IOException e;
            try {
                if (this.needBanner) {
                    write("traces starts.\n");
                }
                BufferedReader bufferedReader = null;
                try {
                    File file = this.mTracesFinder.mSystemTraceFile;
                    boolean endsWith = file.getName().endsWith("anr.log");
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    int i = 0;
                    boolean z = false;
                    boolean z2 = true;
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            i++;
                            if (!this.mTracesFinder.strStartFlag.equals(readLine)) {
                                z = true;
                            }
                            if (!z) {
                                if (i > 5) {
                                    break;
                                }
                            } else {
                                write(readLine + StringUtils.LF);
                                if (z2 && !this.needBanner && readLine.startsWith("--- --- --- --- --- --- --- --- --- ")) {
                                    write("isForegroundANR:" + this.isForegroundANR + StringUtils.LF);
                                    z2 = false;
                                }
                            }
                            if (this.mTracesFinder.strEndFlag.equals(readLine) && !endsWith) {
                                break;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader = bufferedReader2;
                            try {
                                LogUtil.e("read anr file.", e);
                                AppUtils.closeQuietly(bufferedReader);
                                write("traces end.\n");
                                printEnd();
                            } catch (Throwable th2) {
                                th = th2;
                                AppUtils.closeQuietly(bufferedReader);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = bufferedReader2;
                            AppUtils.closeQuietly(bufferedReader);
                            throw th;
                        }
                    }
                    AppUtils.closeQuietly(bufferedReader2);
                } catch (IOException e3) {
                    e = e3;
                    LogUtil.e("read anr file.", e);
                    AppUtils.closeQuietly(bufferedReader);
                    write("traces end.\n");
                    printEnd();
                }
                write("traces end.\n");
            } catch (Exception e4) {
                LogUtil.e("write traces.", e4);
            }
            printEnd();
        }

        /* access modifiers changed from: protected */
        @Override // com.alibaba.motu.crashreporter2.ReportBuilder.ReportPrintWrite
        public void printContent() {
            printTraces();
        }
    }

    /* compiled from: Taobao */
    public abstract class FileReportPrintWrite extends ReportPrintWrite {
        File mReportFile;

        public FileReportPrintWrite(Context context, ReporterContext reporterContext, Configuration configuration, String str, String str2, long j, File file, Map<String, Object> map) {
            super();
            this.mContext = context;
            this.mReporterContext = reporterContext;
            this.mConfiguration = configuration;
            this.mReportName = str;
            this.mReportType = str2;
            this.mTimestamp = j;
            this.mReportFile = file;
            this.mExtraInfo = map;
            if (file.exists()) {
                file.delete();
            }
            try {
                this.mOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                LogUtil.e("create fileOutputStream.", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* compiled from: Taobao */
    public final class UncaughtExceptionReportPrintWrite extends FileReportPrintWrite {
        Thread mThread;
        Throwable mThrowable;

        UncaughtExceptionReportPrintWrite(Context context, ReporterContext reporterContext, Configuration configuration, String str, long j, File file, Throwable th, Thread thread, Map<String, Object> map) {
            super(context, reporterContext, configuration, str, "java", j, file, map);
            this.mThrowable = th;
            this.mThread = thread;
        }

        private void printThrowable() {
            ByteArrayOutputStream byteArrayOutputStream;
            Throwable th;
            Exception e;
            try {
                write(String.format("Process Name: '%s' \n", this.mReporterContext.getProperty("PROCESS_NAME")));
                write(String.format("Thread Name: '%s' \n", this.mThread.getName()));
                write("Back traces starts.\n");
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        this.mThrowable.printStackTrace(new PrintStream(byteArrayOutputStream));
                        write(byteArrayOutputStream.toString());
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            LogUtil.e("print throwable", e);
                            AppUtils.closeQuietly(byteArrayOutputStream);
                            write("Back traces end.\n");
                            printEnd();
                            write(AppUtils.dumpThread(this.mThread));
                            printEnd();
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (Exception e3) {
                    byteArrayOutputStream = null;
                    e = e3;
                    LogUtil.e("print throwable", e);
                    AppUtils.closeQuietly(byteArrayOutputStream);
                    write("Back traces end.\n");
                    printEnd();
                    write(AppUtils.dumpThread(this.mThread));
                    printEnd();
                } catch (Throwable th3) {
                    byteArrayOutputStream = null;
                    th = th3;
                    AppUtils.closeQuietly(byteArrayOutputStream);
                    throw th;
                }
                AppUtils.closeQuietly(byteArrayOutputStream);
                write("Back traces end.\n");
                printEnd();
            } catch (Exception e4) {
                LogUtil.e("write throwable", e4);
            }
            try {
                write(AppUtils.dumpThread(this.mThread));
            } catch (Exception e5) {
                LogUtil.e("write thread", e5);
            }
            printEnd();
        }

        /* access modifiers changed from: protected */
        @Override // com.alibaba.motu.crashreporter2.ReportBuilder.ReportPrintWrite
        public void printContent() {
            printThrowable();
            printExtraInfo();
            printStatus();
            printStorageinfo();
            printFileDescriptor();
            if (this.mThrowable instanceof OutOfMemoryError) {
                printApplictionMeminfo();
            }
            printLogcat();
        }
    }

    public ReportBuilder(Context context, ReporterContext reporterContext, Configuration configuration, StorageManager storageManager) {
        this.mContext = context;
        this.mReporterContext = reporterContext;
        this.mConfiguration = configuration;
        this.mStorageManager = storageManager;
    }

    private File[] listProcessCrashReportFile() {
        FileFilter fileFilter;
        if ("true".equals(SwitcherUtils.valueOf("delDupAnr", "false"))) {
            fileFilter = new FileFilter() {
                /* class com.alibaba.motu.crashreporter2.ReportBuilder.AnonymousClass1 */

                public boolean accept(File file) {
                    return file.getName().endsWith("java.log") || file.getName().endsWith("native.log");
                }
            };
        } else {
            fileFilter = new FileFilter() {
                /* class com.alibaba.motu.crashreporter2.ReportBuilder.AnonymousClass2 */

                public boolean accept(File file) {
                    return file.getName().endsWith("java.log") || file.getName().endsWith("native.log") || file.getName().endsWith("anr.log");
                }
            };
        }
        return this.mStorageManager.listProcessTombstoneFiles(fileFilter);
    }

    public CrashReport buildANRReport(CatcherManager.ANRCatcher.TracesFinder tracesFinder, Map<String, String> map) {
        clearCrashRepoterFile();
        long currentTimeMillis = System.currentTimeMillis();
        String buildReportName = CrashReport.buildReportName(this.mReporterContext.getPropertyAndSet(Constants.UTDID), this.mReporterContext.getProperty(Constants.APP_KEY), this.mReporterContext.getProperty(Constants.APP_VERSION), currentTimeMillis, fw1.HOME_SCAN_PAGE, "anr");
        File processTombstoneFile = this.mStorageManager.getProcessTombstoneFile(buildReportName);
        new ANRReportPrintWrite(this.mContext, this.mReporterContext, this.mConfiguration, buildReportName, currentTimeMillis, processTombstoneFile, tracesFinder).print();
        return CrashReport.buildCrashReport(this.mContext, processTombstoneFile, this.mReporterContext, false);
    }

    public CrashReport buildNativeExceptionReport(File file, Map<String, String> map) {
        clearCrashRepoterFile();
        File processTombstoneFile = this.mStorageManager.getProcessTombstoneFile(CrashReport.buildReportName(this.mReporterContext.getPropertyAndSet(Constants.UTDID), this.mReporterContext.getProperty(Constants.APP_KEY), this.mReporterContext.getProperty(Constants.APP_VERSION), System.currentTimeMillis(), fw1.HOME_SCAN_PAGE, "native"));
        file.renameTo(processTombstoneFile);
        return CrashReport.buildCrashReport(this.mContext, processTombstoneFile, this.mReporterContext, false);
    }

    public CrashReport buildSigQuitANRReport(CatcherManager.ANRCatcher.TracesFinder tracesFinder, boolean z) {
        clearCrashRepoterFile();
        long currentTimeMillis = System.currentTimeMillis();
        String buildReportName = CrashReport.buildReportName(this.mReporterContext.getPropertyAndSet(Constants.UTDID), this.mReporterContext.getProperty(Constants.APP_KEY), this.mReporterContext.getProperty(Constants.APP_VERSION), currentTimeMillis, fw1.HOME_SCAN_PAGE, "anr");
        File processTombstoneFile = this.mStorageManager.getProcessTombstoneFile(buildReportName);
        ANRReportPrintWrite aNRReportPrintWrite = new ANRReportPrintWrite(this.mContext, this.mReporterContext, this.mConfiguration, buildReportName, currentTimeMillis, processTombstoneFile, tracesFinder);
        aNRReportPrintWrite.needBanner = false;
        aNRReportPrintWrite.isForegroundANR = z;
        aNRReportPrintWrite.print();
        return CrashReport.buildCrashReport(this.mContext, processTombstoneFile, this.mReporterContext, false);
    }

    public CrashReport buildUncaughtExceptionReport(Throwable th, Thread thread, Map<String, Object> map) {
        clearCrashRepoterFile();
        long currentTimeMillis = System.currentTimeMillis();
        String buildReportName = CrashReport.buildReportName(this.mReporterContext.getPropertyAndSet(Constants.UTDID), this.mReporterContext.getProperty(Constants.APP_KEY), this.mReporterContext.getProperty(Constants.APP_VERSION), currentTimeMillis, "true".equals(map.get(Constants.REPORT_IGNORE)) ? "ignore" : "catch", "java");
        File processTombstoneFile = this.mStorageManager.getProcessTombstoneFile(buildReportName);
        new UncaughtExceptionReportPrintWrite(this.mContext, this.mReporterContext, this.mConfiguration, buildReportName, currentTimeMillis, processTombstoneFile, th, thread, map).print();
        return CrashReport.buildCrashReport(this.mContext, processTombstoneFile, this.mReporterContext, true);
    }

    public void clearCrashRepoterFile() {
        try {
            File[] listProcessCrashReportFile = listProcessCrashReportFile();
            if (listProcessCrashReportFile != null && listProcessCrashReportFile.length > 20) {
                List<File> asList = Arrays.asList(listProcessCrashReportFile);
                Collections.sort(asList, new Comparator<File>() {
                    /* class com.alibaba.motu.crashreporter2.ReportBuilder.AnonymousClass3 */

                    public int compare(File file, File file2) {
                        if (file.lastModified() > file2.lastModified()) {
                            return -1;
                        }
                        return file.lastModified() == file2.lastModified() ? 0 : 1;
                    }
                });
                for (File file : asList) {
                }
            }
        } catch (Exception e) {
            LogUtil.e("clear crashReport file", e);
        }
    }

    public CrashReport[] listProcessCrashReport() {
        File[] listProcessCrashReportFile = listProcessCrashReportFile();
        if (listProcessCrashReportFile == null || listProcessCrashReportFile.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : listProcessCrashReportFile) {
            arrayList.add(CrashReport.buildCrashReport(this.mContext, file, this.mReporterContext, false));
        }
        return (CrashReport[]) arrayList.toArray(new CrashReport[0]);
    }

    /* compiled from: Taobao */
    public abstract class ReportPrintWrite {
        boolean isForegroundANR = false;
        Configuration mConfiguration;
        Context mContext;
        Map<String, Object> mExtraInfo;
        long mFull;
        long mLimit;
        OutputStream mOutputStream;
        long mReject;
        String mReportName;
        String mReportType;
        ReporterContext mReporterContext;
        long mTimestamp;
        long mWrite;
        boolean needBanner = true;

        public ReportPrintWrite() {
        }

        /* access modifiers changed from: protected */
        public void close() {
            AppUtils.closeQuietly(this.mOutputStream);
        }

        public void print() {
            if (this.needBanner) {
                printBanner();
            }
            printContent();
            printDone();
        }

        /* access modifiers changed from: protected */
        public void printApplictionMeminfo() {
            write("appliction meminfo:\n");
            write(AppUtils.dumpMeminfo(this.mContext));
            printEnd();
        }

        /* access modifiers changed from: protected */
        public void printBanner() {
            write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n");
            write(String.format("Basic Information: 'pid: %d/tid: %d/logver: 2/time: %s/cpu: %s/cpu hardware: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), Long.valueOf(this.mTimestamp), Build.getCPU_ABI(), android.os.Build.HARDWARE));
            write(String.format("Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.getMODEL(), Build.VERSION.getRELEASE(), Integer.valueOf(Build.VERSION.SDK_INT)));
            write(String.format("Build fingerprint: '" + android.os.Build.FINGERPRINT + "'\n", new Object[0]));
            write(String.format("Runtime Information: 'start: %s/maxheap: %s'\n", this.mReporterContext.getProperty(Constants.STARTUP_TIME), Long.valueOf(Runtime.getRuntime().maxMemory())));
            write(String.format("Application Information: 'version: %s/subversion: %s/buildseq: %s'\n", this.mReporterContext.getProperty(Constants.APP_VERSION), this.mReporterContext.getProperty(Constants.APP_SUBVERSION), this.mReporterContext.getProperty(Constants.APP_BUILD)));
            write(String.format("%s Information: 'version: %s/nativeseq: %s/javaseq: %s/target: %s'\n", CrashReporter._MAGIC, CrashReporter._VERSION, "160509105620", "", "beta"));
            write("Report Name: " + this.mReportName + StringUtils.LF);
            write("UUID: " + UUID.randomUUID().toString().toLowerCase() + StringUtils.LF);
            write("Log Type: " + this.mReportType + StringUtils.LF);
            printEnd();
        }

        /* access modifiers changed from: protected */
        public abstract void printContent();

        /* access modifiers changed from: protected */
        public void printDone() {
            write(String.format("Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Long.valueOf(this.mFull), Long.valueOf(this.mWrite), Long.valueOf(this.mLimit), Long.valueOf(this.mReject)));
            write(String.format("log end: %s\n", AppUtils.getGMT8Time(System.currentTimeMillis())));
        }

        /* access modifiers changed from: protected */
        public void printEnd() {
            write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
        }

        /* access modifiers changed from: protected */
        public void printExtraInfo() {
            Map<String, Object> map = this.mExtraInfo;
            if (!(map == null || map.isEmpty())) {
                try {
                    write("extrainfo:\n");
                    for (String str : this.mExtraInfo.keySet()) {
                        write(String.format("%s: %s\n", str, this.mExtraInfo.get(str)));
                    }
                } catch (Exception e) {
                    LogUtil.e("write extral info", e);
                }
                printEnd();
            }
        }

        /* access modifiers changed from: protected */
        public void printFileDescriptor() {
            int i = this.mConfiguration.getInt(Configuration.fileDescriptorLimit, 900);
            File[] fileArr = null;
            try {
                fileArr = new File("/proc/self/fd").listFiles();
                if (fileArr != null) {
                    write(String.format("opened file count: %d, write limit: %d.\n", Integer.valueOf(fileArr.length), Integer.valueOf(i)));
                } else {
                    write("[DEBUG] listFiles failed!\n");
                }
            } catch (Exception e) {
                LogUtil.e("print file descriptor.", e);
            }
            if (fileArr != null) {
                try {
                    if (fileArr.length >= i) {
                        write("opened files:\n");
                        StringBuilder sb = new StringBuilder();
                        try {
                            for (File file : fileArr) {
                                sb.append(file.getName());
                                sb.append(" -> ");
                                sb.append(file.getCanonicalPath());
                                sb.append(StringUtils.LF);
                            }
                        } catch (Exception e2) {
                            LogUtil.e("print file descriptor.", e2);
                        }
                        write(sb.toString());
                    }
                } catch (Exception e3) {
                    LogUtil.e("print file descriptor.", e3);
                }
            }
            printEnd();
        }

        /* access modifiers changed from: protected */
        public void printLogcat() {
            int i = this.mConfiguration.getInt(Configuration.mainLogLineLimit, 2000);
            int i2 = this.mConfiguration.getInt(Configuration.eventsLogLineLimit, 200);
            printLogcat(null, i);
            printLogcat("events", i2);
        }

        /* access modifiers changed from: protected */
        public void printStatus() {
            try {
                write("meminfo:\n");
                write(com.alibaba.motu.tbrest.utils.StringUtils.defaultString(AppUtils.getMeminfo(), "") + StringUtils.LF);
                printEnd();
            } catch (Exception e) {
                LogUtil.e("write meminfo.", e);
            }
            try {
                write("status:\n");
                write(com.alibaba.motu.tbrest.utils.StringUtils.defaultString(AppUtils.getMyStatus(), "") + StringUtils.LF);
                printEnd();
            } catch (Exception e2) {
                LogUtil.e("write status.", e2);
            }
            try {
                write("virtual machine:\nMaxMemory: " + Runtime.getRuntime().maxMemory() + " TotalMemory: " + Runtime.getRuntime().totalMemory() + " FreeMemory: " + Runtime.getRuntime().freeMemory() + StringUtils.LF);
            } catch (Exception e3) {
                LogUtil.e("write virtual machine info.", e3);
            }
            printEnd();
        }

        /* access modifiers changed from: protected */
        public void printStorageinfo() {
            write("storageinfo:\n");
            write(AppUtils.dumpStorage(this.mContext));
            printEnd();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|5|6|7|8|9|13) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
            com.alibaba.motu.crashreporter.LogUtil.e("write.", r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001a */
        public void write(String str) {
            byte[] bArr = new byte[0];
            try {
                bArr = str.getBytes("UTF-8");
            } catch (Exception e) {
                LogUtil.e("write.", e);
            }
            this.mFull += (long) bArr.length;
            LogUtil.i(str);
            this.mOutputStream.write(str.getBytes("UTF-8"));
            this.mWrite += (long) bArr.length;
            this.mOutputStream.flush();
        }

        private void printLogcat(String str, int i) {
            Process process;
            Throwable th;
            int i2;
            int i3;
            int i4;
            int i5;
            Exception exc;
            ArrayList arrayList = new ArrayList();
            arrayList.add("logcat");
            arrayList.add("-d");
            if (com.alibaba.motu.tbrest.utils.StringUtils.isBlank(str)) {
                write("logcat main: \n");
            } else {
                write("logcat " + str + ": \n");
                arrayList.add("-b");
                arrayList.add(str);
            }
            arrayList.add("-v");
            arrayList.add("threadtime");
            if (i < 0) {
                write("[DEBUG] custom java logcat lines count is 0!\n");
            } else {
                arrayList.add("-t");
                arrayList.add(String.valueOf(i));
                BufferedReader bufferedReader = null;
                try {
                    process = new ProcessBuilder(new String[0]).command(arrayList).redirectErrorStream(true).start();
                } catch (Exception e) {
                    LogUtil.e("exec logcat", e);
                    process = null;
                }
                if (process == null) {
                    write("[DEBUG] exec logcat failed!\n");
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
                                    write(readLine + StringUtils.LF);
                                    i3++;
                                }
                            } catch (Exception e2) {
                                i4 = i2;
                                bufferedReader = bufferedReader2;
                                i5 = i3;
                                exc = e2;
                                try {
                                    LogUtil.e("print log.", exc);
                                    AppUtils.closeQuietly(bufferedReader);
                                    i2 = i4;
                                    i3 = i5;
                                    write(String.format("[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)));
                                    printEnd();
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
                        LogUtil.e("print log.", exc);
                        AppUtils.closeQuietly(bufferedReader);
                        i2 = i4;
                        i3 = i5;
                        write(String.format("[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)));
                        printEnd();
                    }
                    write(String.format("[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)));
                }
            }
            printEnd();
        }
    }
}

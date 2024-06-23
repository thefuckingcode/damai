package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.cyclone.update.UpdateService;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.uc.webview.export.internal.update.b;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.i;
import com.uc.webview.export.internal.utility.l;
import com.uc.webview.export.internal.utility.p;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Callable;
import tb.jl1;

/* compiled from: Taobao */
public class by extends l {
    public static final String a = by.class.getSimpleName();
    String c;
    String d;
    String e;
    public UpdateService f;
    public Map<String, ValueCallback> g;
    private boolean h = false;
    private boolean i = false;

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02e4, code lost:
        if (((java.lang.Integer) r1.first).intValue() == 1) goto L_0x0330;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02e6, code lost:
        r2 = ((java.lang.Integer) r1.first).intValue();
        r1 = r1.second;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02f5, code lost:
        r5 = com.uc.webview.export.internal.setup.UCSetupTask.getTotalLoadedUCM();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02f9, code lost:
        if (r5 == null) goto L_0x0328;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02fe, code lost:
        if (r5.coreType != 2) goto L_0x030c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x030a, code lost:
        if (com.uc.webview.export.internal.utility.i.a().b(com.uc.webview.export.extension.UCCore.OPTION_MULTI_CORE_TYPE) != false) goto L_0x0328;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x030c, code lost:
        com.uc.webview.export.internal.utility.Log.d(r13, ".shareCoreWaitTimeout UCCore had initialized.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x031a, code lost:
        if (((java.lang.Integer) r1.first).intValue() == 1) goto L_0x0330;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x031c, code lost:
        r2 = ((java.lang.Integer) r1.first).intValue();
        r1 = r1.second;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0328, code lost:
        com.uc.webview.export.internal.utility.n.a(new com.uc.webview.export.internal.setup.cc(r17, r3, r2, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0356, code lost:
        r0 = th;
     */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0349  */
    @Override // com.uc.webview.export.internal.setup.UCAsyncTask
    public void run() {
        long j;
        bq bqVar;
        Throwable th;
        Long l;
        Long l2;
        boolean z;
        Throwable th2;
        Throwable th3;
        int intValue;
        Object obj;
        long j2;
        long j3;
        String str = a;
        Log.d(str, "run");
        Context context = (Context) getOption("CONTEXT");
        String str2 = (String) getOption(UCCore.OPTION_UCM_UPD_URL);
        Boolean bool = (Boolean) getOption(UCCore.OPTION_CHECK_MULTI_CORE);
        Callable callable = (Callable) getOption(UCCore.OPTION_DOWNLOAD_CHECKER);
        int createToken = UCLogger.createToken("i", str);
        UCMRunningInfo totalLoadedUCM = UCSetupTask.getTotalLoadedUCM();
        if (totalLoadedUCM != null) {
            boolean z2 = !totalLoadedUCM.isShareCore || totalLoadedUCM.coreType == 2;
            if (!z2) {
                String param = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_HOST_UPDATE_STILL);
                Log.d(str, "stileUpdate : " + param);
                if (p.b(param)) {
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_UPDATE_STILL);
                    z2 = true;
                }
            }
            Log.d(str, "stile update task : " + z2);
            if (!z2) {
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_UPDATE_STOP);
                return;
            }
        }
        if (!p.a(str2)) {
            bq bqVar2 = new bq();
            Object option = getOption(UCCore.OPTION_UPD_SETUP_TASK_WAIT_MILIS);
            if (option == null) {
                j = 7200000;
            } else if (option instanceof Long) {
                j = ((Long) option).longValue();
            } else if (option instanceof Integer) {
                j = ((Integer) option).longValue();
            } else {
                j = Long.parseLong(String.valueOf(option));
            }
            Long valueOf = Long.valueOf(j);
            Long valueOf2 = Long.valueOf(Math.min(valueOf.longValue(), 600000L));
            try {
                String param2 = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_HOST_UPD_SETUP_TASK_WAIT_MILIS);
                if (!p.a(param2)) {
                    valueOf2 = Long.valueOf(Math.min(Long.valueOf(param2).longValue(), valueOf.longValue()));
                }
            } catch (Exception e2) {
                Log.d(a, "Long.valueOf(String) exceptin.", e2);
            }
            UCLogger.print(createToken, "run:update from [" + str2 + jl1.ARRAY_END_STR, new Throwable[0]);
            String str3 = a;
            Log.d(str3, "shareCoreWait: " + valueOf2 + " wait: " + valueOf);
            UCElapseTime uCElapseTime = new UCElapseTime();
            synchronized (bqVar2) {
                try {
                    Object option2 = getOption(UCCore.OPTION_DWN_RETRY_WAIT_MILIS);
                    if (option2 == null) {
                        l = null;
                    } else {
                        if (option2 instanceof Long) {
                            j3 = ((Long) option2).longValue();
                        } else if (option2 instanceof Integer) {
                            j3 = ((Integer) option2).longValue();
                        } else {
                            j3 = Long.parseLong(String.valueOf(option2));
                        }
                        l = Long.valueOf(j3);
                    }
                    Object option3 = getOption(UCCore.OPTION_DWN_RETRY_MAX_WAIT_MILIS);
                    if (option3 == null) {
                        l2 = null;
                    } else {
                        if (option3 instanceof Long) {
                            j2 = ((Long) option3).longValue();
                        } else if (option3 instanceof Integer) {
                            j2 = ((Integer) option3).longValue();
                        } else {
                            j2 = Long.parseLong(String.valueOf(option3));
                        }
                        l2 = Long.valueOf(j2);
                    }
                    File b = b.b(context);
                    new l.b("ut_cvsv");
                    UpdateService a2 = b.a();
                    this.f = a2;
                    if (a2 != null) {
                        Log.d(str3, "startUpdateAsync url:" + str2 + ", updateTask:" + this + ", service:" + this.f);
                        this.f.setup(UpdateService.OPTION_CONTEXT, context).setup("url", str2).setup(UpdateService.OPTION_ROOT_DIR, b).setup(UpdateService.OPTION_CHECK_FILE, "sdk_shell.jar").setup(UpdateService.OPTION_CHECK_LAST_MODIFIED, Boolean.valueOf(i.a().b(UCCore.OPTION_EXACT_LAST_MODIFIED_CHECK))).setup(UpdateService.OPTION_CONNECT_TIME_OUT, Integer.valueOf(p.c())).setup(UpdateService.OPTION_READ_TIME_OUT, Integer.valueOf(p.d())).setup(UpdateService.OPTION_RETRY_WAIT_MILLIS, l).setup(UpdateService.OPTION_RETRY_MAX_MILLIS, l2).setup(UpdateService.OPTION_UPDATE_CORE, Boolean.TRUE).setup(UpdateService.OPTION_DOWNLOADER_DELEGATE, getOption(UpdateService.OPTION_DOWNLOADER_DELEGATE)).setCallback(new cb(this, context, callable, this.g, b, bqVar2)).start();
                        long longValue = valueOf2.longValue();
                        bqVar = bqVar2;
                        try {
                            Pair<Integer, Object> a3 = bqVar.a(longValue);
                            if (!(((Integer) a3.first).intValue() == 0 || ((Integer) a3.first).intValue() == 4)) {
                                Log.d(str3, ".shareCoreWaitTimeout");
                                try {
                                    if (!CDParamKeys.CD_VALUE_LOAD_POLICY_SHARE_CORE.equals(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_LOAD_POLICY))) {
                                        try {
                                            Log.d(str3, ".shareCoreWaitTimeout !CDKeys.CD_VALUE_LOAD_POLICY_SHARE_CORE.equals(shareCoreLoadPolicy).");
                                            if (((Integer) a3.first).intValue() != 1) {
                                                intValue = ((Integer) a3.first).intValue();
                                                obj = a3.second;
                                            }
                                            a3 = bqVar.a(valueOf.longValue() - valueOf2.longValue() > 0 ? valueOf.longValue() - valueOf2.longValue() : valueOf.longValue());
                                        } catch (Throwable th4) {
                                            th2 = th4;
                                            z = true;
                                            bqVar.a(((Integer) a3.first).intValue(), a3.second);
                                            throw th2;
                                        }
                                    } else {
                                        ValueCallback callback = getCallback(UCCore.EVENT_UPDATE_SHARE_CORE);
                                        if (callback == null) {
                                            Log.d(str3, ".shareCoreWaitTimeout dlShareCoreCB == null.");
                                            if (((Integer) a3.first).intValue() != 1) {
                                                intValue = ((Integer) a3.first).intValue();
                                                obj = a3.second;
                                            }
                                            a3 = bqVar.a(valueOf.longValue() - valueOf2.longValue() > 0 ? valueOf.longValue() - valueOf2.longValue() : valueOf.longValue());
                                        } else {
                                            synchronized (this) {
                                                try {
                                                    if (!this.h && !this.i && ((Integer) a3.first).intValue() != 1) {
                                                        try {
                                                            Log.d(str3, ".shareCoreWaitTimeout !mHasExcepted && !mHasFailed");
                                                        } catch (Throwable th5) {
                                                            th3 = th5;
                                                            z = true;
                                                            while (true) {
                                                                try {
                                                                    break;
                                                                } catch (Throwable th6) {
                                                                    th3 = th6;
                                                                }
                                                            }
                                                            throw th3;
                                                        }
                                                    }
                                                } catch (Throwable th7) {
                                                    th3 = th7;
                                                    z = false;
                                                    while (true) {
                                                        break;
                                                    }
                                                    throw th3;
                                                }
                                            }
                                        }
                                    }
                                    bqVar.a(intValue, obj);
                                    a3 = bqVar.a(valueOf.longValue() - valueOf2.longValue() > 0 ? valueOf.longValue() - valueOf2.longValue() : valueOf.longValue());
                                } catch (Throwable th8) {
                                    th2 = th8;
                                    z = false;
                                    if (z && ((Integer) a3.first).intValue() != 1) {
                                        bqVar.a(((Integer) a3.first).intValue(), a3.second);
                                    }
                                    throw th2;
                                }
                            }
                            Log.d(str3, "result.first: " + a3.first);
                            if (((Integer) a3.first).intValue() == 1) {
                                throw new UCSetupException(4010, String.format("Thread [%s] waiting for update is up to [%s] milis.", Thread.currentThread().getName(), String.valueOf(valueOf)));
                            } else if (((Integer) a3.first).intValue() == 3) {
                                throw new UCSetupException(4019, (Exception) a3.second);
                            } else if (((Integer) a3.first).intValue() != 8) {
                                boolean z3 = ((Integer) a3.first).intValue() == 0;
                                boolean z4 = ((Integer) a3.first).intValue() == 4;
                                boolean z5 = z3 || z4;
                                File b2 = b.b(context);
                                if (z3) {
                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_UPD_DOWNLOAD_ELAPSE_TIME, Long.toString(uCElapseTime.getMilis()));
                                }
                                if (!z5 || (!z3 && UCSetupTask.getTotalLoadedUCM() != null && !p.a(UCSetupTask.getTotalLoadedUCM()))) {
                                    Log.d(str3, "else, need not new ThinSetupTask.");
                                    return;
                                }
                                Log.d(str3, "new ThinSetupTask.");
                                i.a().a("gk_upd_exist", Boolean.valueOf(z4));
                                ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) (p.f() ? new bb() : new bh()).setParent(this)).setOptions(this.mOptions)).setCallbacks(this.mCallbacks)).setup(UCCore.OPTION_DEX_FILE_PATH, (Object) null)).setup(UCCore.OPTION_SO_FILE_PATH, (Object) null)).setup(UCCore.OPTION_RES_FILE_PATH, (Object) null)).setup(UCCore.OPTION_UCM_CFG_FILE, (Object) null)).setup(UCCore.OPTION_UCM_LIB_DIR, (Object) null)).setup(UCCore.OPTION_UCM_ZIP_DIR, (Object) null)).setup(UCCore.OPTION_UCM_ZIP_FILE, (Object) null)).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) b2.getAbsolutePath())).setup(UCCore.OPTION_ENABLE_LOAD_CLASS, (Object) Boolean.valueOf(p.a(UCSetupTask.getTotalLoadedUCM())))).onEvent("switch", (ValueCallback) new ca(this))).onEvent("stop", (ValueCallback) new UCAsyncTask.b())).onEvent(UCCore.LEGACY_EVENT_SETUP, (ValueCallback) (p.b(bool) ? null : new bz(this)))).start();
                            } else {
                                throw new UCSetupException(4030, String.format("Thread [%s] waiting timeout for share core task.", Thread.currentThread().getName()));
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            throw th;
                        }
                    } else {
                        throw new RuntimeException();
                    }
                } catch (Throwable th10) {
                    th = th10;
                    bqVar = bqVar2;
                    throw th;
                }
            }
        } else {
            throw new UCSetupException(3014, String.format("Option [%s] expected.", UCCore.OPTION_UCM_UPD_URL));
        }
    }
}

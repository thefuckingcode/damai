package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.taobao.windvane.service.WVEventId;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;
import com.taobao.accs.common.Constants;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.cyclone.Log;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.cyclone.UCHashMap;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.cyclone.UCVmsize;
import com.uc.webview.export.extension.SettingKeys;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.uc.webview.export.internal.setup.UCSubSetupTask;
import com.uc.webview.export.internal.uc.startup.a;
import com.uc.webview.export.internal.uc.startup.b;
import com.uc.webview.export.internal.utility.d;
import com.uc.webview.export.internal.utility.i;
import com.uc.webview.export.internal.utility.j;
import com.uc.webview.export.internal.utility.m;
import com.uc.webview.export.internal.utility.p;
import com.uc.webview.export.utility.SetupTask;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.Callable;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: Taobao */
public class o extends SetupTask {
    private static o c;
    private static Stack<UCSetupTask> d = new Stack<>();
    public l a;
    private l e;
    private l f;
    private l g;
    private Context h;
    private UCElapseTime i;
    private UCSetupException j;
    private UCSetupTask k;
    private ValueCallback<l> l;
    private ValueCallback<l> m;
    private List<ax> n;
    private boolean o = false;
    private final ValueCallback<l> p = new p(this);
    private final ValueCallback<l> q = new u(this);
    private final ValueCallback<l> r = new v(this);
    private final ValueCallback<l> s = new w(this);
    private final ValueCallback<l> t = new ad(this);
    private Object u = new Object();
    private bb v = null;

    private o() {
    }

    static /* synthetic */ l i(o oVar) {
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_CREATE_DELAY_SEARE_CORE_FILE_TASK_PV);
        l a2 = oVar.a(new ar(), "ShareCoreSearchCoreFileTask");
        a2.setParent(UCSetupTask.getRoot());
        return a2;
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask
    public void run() {
        l lVar;
        l a2;
        l lVar2;
        l a3;
        b.a(5);
        this.i = new UCElapseTime();
        d.a("HasStartedU4SDKSetup", "true");
        Log.rInfo("ucstartup", "start U4 SDK setup");
        ((SetupTask) setup(UCCore.OPTION_UCM_ZIP_DIR, (Object) null)).setup(UCCore.OPTION_USE_SDK_SETUP, (Object) Boolean.TRUE);
        setupGlobalOnce();
        onEvent(UCCore.EVENT_STAT, (ValueCallback) new r(this, getCallback(UCCore.EVENT_STAT)));
        callbackStat(new Pair<>(IWaStat.SETUP_START, null));
        if (p.b(p.a(this.mOptions, UCCore.OPTION_USE_SYSTEM_WEBVIEW))) {
            d.push(null);
        }
        b.a(287);
        this.h = (Context) getOption("CONTEXT");
        this.m = new UCAsyncTask.a();
        this.l = new UCSubSetupTask.a();
        af.a(this.mOptions);
        if (!p.b(p.a(this.mOptions, UCCore.OPTION_USE_SYSTEM_WEBVIEW))) {
            Log.i("SdkSetupTask", "force to use system webview");
            b((l) new ba()).start();
        } else if (p.a(this.mOptions)) {
            Log.i("SdkSetupTask", "isThickSDK");
            b.a(314);
            String str = (String) this.mOptions.get(UCCore.OPTION_UCM_KRL_DIR);
            String str2 = (String) this.mOptions.get(UCCore.OPTION_SO_FILE_PATH);
            String str3 = (String) this.mOptions.get(UCCore.OPTION_RES_FILE_PATH);
            String str4 = (String) this.mOptions.get(UCCore.OPTION_UCM_ZIP_FILE);
            String str5 = p.a(str) ? str2 : str;
            if (m.b(this.h, this.mOptions)) {
                String str6 = m.a().soDirPath;
                b.a(509);
                lVar2 = a(b(), str6);
                b.a(510);
                lVar2.setUCM(m.a());
                b.a(500, "1");
            } else if (!p.a(str5)) {
                lVar2 = (l) ((l) ((l) a(new bb(), aj.a(str5)).setup(UCCore.OPTION_SO_FILE_PATH, (Object) str2)).setup(UCCore.OPTION_RES_FILE_PATH, (Object) str3)).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) str);
            } else if (!p.a(str4)) {
                lVar2 = (l) a(new b(), str4).setup(UCCore.OPTION_UCM_ZIP_FILE, (Object) str4);
                if (p.a((Boolean) this.mOptions.get(UCCore.OPTION_FIRST_USE_SYSTEM_WEBVIEW))) {
                    Log.i("SdkSetupTask", "first use system webview for unzip in thick");
                    this.g = lVar2;
                    lVar2 = b((l) new ba());
                }
            } else {
                lVar2 = null;
            }
            if (m.a(this.h, this.mOptions) && (a3 = a(lVar2, true)) != null) {
                lVar2 = a3;
            }
            b.a(315);
            if (lVar2 != null) {
                b.a(291);
                lVar2.start();
            } else if (this.e != null) {
                b.a(291);
                a(new bb(), "").start();
            } else {
                throw new UCSetupException((int) WVEventId.WV_CORE_SWITCH, "At least 1 of OPTION_SO_FILE_PATH |OPTION_UCM_KRL_DIR |OPTION_UCM_UPD_URL  should be given.");
            }
            SDKFactory.c("Thick SDK");
        } else {
            b.a(288);
            b.a(141);
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_NEW_DEF_TASK);
            String str7 = (String) this.mOptions.get(UCCore.OPTION_DEX_FILE_PATH);
            if (m.b(this.h, this.mOptions)) {
                lVar = a((l) new bh().setUCM(m.a()), (String) m.a().coreImplModule.second);
                b.a(500, "1");
            } else if (!p.a(str7)) {
                lVar = (l) ((l) ((l) a(new bh(), str7).setup(UCCore.OPTION_DEX_FILE_PATH, (Object) str7)).setup(UCCore.OPTION_SO_FILE_PATH, getOption(UCCore.OPTION_SO_FILE_PATH))).setup(UCCore.OPTION_RES_FILE_PATH, getOption(UCCore.OPTION_RES_FILE_PATH));
            } else {
                String str8 = (String) this.mOptions.get(UCCore.OPTION_UCM_ZIP_FILE);
                if (!p.a(str8)) {
                    lVar = (l) a(new b(), str8).setup(UCCore.OPTION_UCM_ZIP_FILE, (Object) str8);
                    if (p.a((Boolean) this.mOptions.get(UCCore.OPTION_FIRST_USE_SYSTEM_WEBVIEW))) {
                        Log.i("SdkSetupTask", "first use system webview for unzip");
                        this.g = lVar;
                        lVar = b((l) new ba());
                    }
                } else {
                    String str9 = (String) this.mOptions.get(UCCore.OPTION_UCM_LIB_DIR);
                    if (!p.a(str9)) {
                        this.mOptions.get(UCCore.OPTION_FORBID_GEN_REPAIR_DIR);
                        lVar = (l) a(new bh(), str9).setup(UCCore.OPTION_UCM_LIB_DIR, (Object) str9);
                    } else {
                        String str10 = (String) this.mOptions.get(UCCore.OPTION_UCM_KRL_DIR);
                        if (!p.a(str10)) {
                            lVar = (l) a(new bh(), str10).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) str10);
                        } else {
                            String str11 = (String) this.mOptions.get(UCCore.OPTION_UCM_CFG_FILE);
                            lVar = !p.a(str11) ? (l) a(new bh(), str11).setup(UCCore.OPTION_UCM_CFG_FILE, (Object) str11) : null;
                        }
                    }
                }
            }
            if (m.a(this.h, this.mOptions) && (a2 = a(lVar, p.a((Boolean) getOption(UCCore.OPTION_SKIP_OLD_KERNEL)))) != null) {
                lVar = a2;
            }
            b.a(142);
            l e2 = CDParamKeys.CD_VALUE_LOAD_POLICY_SHARE_CORE.equals(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_LOAD_POLICY)) ? e() : null;
            Log.d("SdkSetupTask", "mUpdateTask: " + this.e + " shareCoreTask: " + e2);
            b.a(289);
            if (lVar != null) {
                if (!(this.e == null || e2 == null)) {
                    a(e2);
                    d.push(e2);
                }
                b.a(290);
                lVar.start();
            } else if (this.e != null) {
                b.a(290);
                a(new bh(), "").start();
            } else if (e2 != null) {
                a(e2);
                b.a(290);
                e2.start();
            } else {
                throw new UCSetupException((int) WVEventId.WV_CORE_SWITCH, "At least 1 of OPTION_DEX_FILE_PATH|OPTION_UCM_LIB_DIR|OPTION_UCM_KRL_DIR|OPTION_UCM_CFG_FILE|OPTION_UCM_UPD_URL and CD_KEY_SHARE_CORE_CLIENT_LOAD_POLICY should be given.");
            }
        }
        b.a(6);
    }

    /* access modifiers changed from: private */
    public l e() {
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_NEW_SC_TASK);
        return (l) a(new aq(), "ShareCoreSdcardSetupTask").setup(UCCore.OPTION_SHARE_CORE_SETUP_TASK_FLAG, (Object) Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    public void f() {
        try {
            if (UCSetupTask.getTotalLoadedUCM().coreType != 2) {
                com.uc.webview.export.internal.utility.b.c();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            SDKFactory.c(SDKFactory.a(UCSetupTask.getTotalLoadedUCM().ucmPackageInfo, (String) getOption(UCCore.OPTION_LOAD_POLICY)));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            j.a((String) getOption(UCCore.OPTION_LOAD_SHARE_CORE_HOST));
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        bt btVar;
        if (af.b() && (btVar = UCSetupTask.getTotalLoadedUCM().ucmPackageInfo) != null && this.h != null) {
            m.a(btVar, this.mOptions);
            m.a(btVar, m.b(this.h));
        }
    }

    /* access modifiers changed from: private */
    public l b(l lVar) {
        ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) lVar.setParent(this)).setOptions(this.mOptions)).onEvent(UCCore.LEGACY_EVENT_SETUP, (ValueCallback) this.m)).onEvent("load", (ValueCallback) this.m)).onEvent(UCCore.LEGACY_EVENT_INIT, (ValueCallback) this.m)).onEvent("switch", (ValueCallback) this.m)).onEvent(UCCore.EVENT_STAT, (ValueCallback) this.l)).onEvent("success", (ValueCallback) this.p)).onEvent("exception", (ValueCallback) this.q);
        return lVar;
    }

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            if (c == null) {
                b.a(327);
                c = new o();
                b.a(331);
            }
            oVar = c;
        }
        return oVar;
    }

    private l a(l lVar, String str) {
        ((l) ((l) ((l) ((l) ((l) ((l) b(lVar).setup(UCCore.OPTION_DEX_FILE_PATH, (Object) null)).setup(UCCore.OPTION_SO_FILE_PATH, (Object) null)).setup(UCCore.OPTION_RES_FILE_PATH, (Object) null)).setup(UCCore.OPTION_UCM_ZIP_FILE, (Object) null)).setup(UCCore.OPTION_UCM_LIB_DIR, (Object) null)).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) null)).setup(UCCore.OPTION_UCM_CFG_FILE, (Object) null);
        if (!p.a(str)) {
            aj setupCrashImprover = lVar.getSetupCrashImprover(getContext(), str);
            ((l) ((l) ((l) ((l) lVar.onEvent("start", (ValueCallback) setupCrashImprover.b)).onEvent(UCCore.EVENT_DIE, (ValueCallback) setupCrashImprover.c)).onEvent("crash_none", (ValueCallback) null)).onEvent("crash_seen", (ValueCallback) null)).onEvent("crash_repeat", (ValueCallback) this.r);
        }
        return lVar;
    }

    public final bb b() {
        if (this.v == null) {
            synchronized (this.u) {
                if (this.v == null) {
                    this.v = new bb();
                }
            }
        }
        return this.v;
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x025a A[Catch:{ all -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x025f A[Catch:{ all -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x027b A[Catch:{ all -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x027e A[Catch:{ all -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x028e A[Catch:{ all -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0291 A[Catch:{ all -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02cf A[Catch:{ all -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x02d2 A[Catch:{ all -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02e9 A[Catch:{ all -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02ec A[Catch:{ all -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02fa A[Catch:{ all -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02fd A[Catch:{ all -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0309 A[Catch:{ all -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0353 A[Catch:{ all -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0356 A[Catch:{ all -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0363 A[Catch:{ all -> 0x0371 }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03b3 A[Catch:{ all -> 0x03fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03c6 A[Catch:{ all -> 0x03fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x03e6 A[Catch:{ all -> 0x03fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0469 A[Catch:{ all -> 0x0492, all -> 0x052b }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x049c A[Catch:{ all -> 0x04ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x04ff A[Catch:{ all -> 0x0506 }] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0516 A[SYNTHETIC, Splitter:B:223:0x0516] */
    /* JADX WARNING: Removed duplicated region for block: B:238:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0159 A[Catch:{ all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01a3 A[Catch:{ all -> 0x01aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01a5 A[Catch:{ all -> 0x01aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b7 A[Catch:{ all -> 0x0377 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0218 A[Catch:{ all -> 0x022d }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x021b A[Catch:{ all -> 0x022d }] */
    static /* synthetic */ void b(o oVar, UCMRunningInfo uCMRunningInfo) {
        String str;
        String str2;
        UCLogger uCLogger;
        String str3;
        String str4;
        List<ax> list;
        Boolean bool;
        l lVar;
        l lVar2;
        List<ax> list2;
        boolean z;
        Throwable th;
        boolean z2;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Integer num;
        String str10;
        String str11;
        String str12;
        Throwable th2;
        long j2;
        long j3;
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_SUCCESS_CB_TOTEL_PV);
        try {
            UCLogger create = UCLogger.create("d", "SdkSetupTask");
            if (create != null) {
                Object[] objArr = new Object[3];
                objArr[0] = UCSetupTask.getTotalLoadedUCM().ucmPackageInfo != null ? UCSetupTask.getTotalLoadedUCM().ucmPackageInfo.dataDir : null;
                objArr[1] = Integer.valueOf(UCSetupTask.getTotalLoadedUCM().coreType);
                objArr[2] = Boolean.valueOf(UCSetupTask.getTotalLoadedUCM().isShareCore);
                create.print(String.format("mSuccessCB: dataDir is [%s] core type: [%d] isShareCore{%b}.", objArr), new Throwable[0]);
            }
            oVar.g();
            try {
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_SUCCESS_CB_INIT_PV);
                oVar.callbackFinishStat(String.valueOf(UCSetupTask.getTotalLoadedUCM().coreType));
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            try {
                String str13 = (String) oVar.getOption(UCCore.OPTION_UCM_UPD_URL);
                if (str13 != null) {
                    File b = p.b(p.a(oVar.h, Constants.KEY_FLAGS), "uc_upd");
                    File file = new File(b, UCCyclone.getSourceHash(str13) + "_frun");
                    if (!file.exists()) {
                        if (!file.createNewFile()) {
                            throw new Exception("createNewFile firstTimeRunFlagFile failed");
                        }
                    }
                    str = "T";
                    if (uCMRunningInfo.coreType != 2) {
                        try {
                            File file2 = new File(b, UCCyclone.getSourceHash(str13) + "_ucrun");
                            if (!file2.exists()) {
                                if (!file2.createNewFile()) {
                                    throw new Exception("createNewFile ucrunFlagFile failed");
                                }
                            }
                            j2 = file2.lastModified() - file.lastModified();
                            if (!uCMRunningInfo.isOldExtraKernel) {
                                File file3 = new File(b, UCCyclone.getSourceHash(str13) + "_curucrun");
                                if (!file3.exists()) {
                                    if (!file3.createNewFile()) {
                                        throw new Exception("createNewFile currentUcRunFlagFile failed");
                                    }
                                }
                                j3 = file3.lastModified() - file.lastModified();
                                if (j3 == 0) {
                                    j3 = System.currentTimeMillis() - file.lastModified();
                                }
                                str2 = UTConstant.Args.UT_SUCCESS_F;
                                IWaStat.WaStat.stat(IWaStat.SETUP_UCCORE_COST_HOUR, String.valueOf((int) Math.ceil((double) (j2 / DateUtils.MILLIS_PER_HOUR))));
                                IWaStat.WaStat.stat(IWaStat.SETUP_CUR_UCCORE_COST_HOUR, String.valueOf((int) Math.ceil((double) (j3 / DateUtils.MILLIS_PER_HOUR))));
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            str2 = UTConstant.Args.UT_SUCCESS_F;
                            th2.printStackTrace();
                            IWaStat.WaStat.stat("sdk_ucm_old", UCSetupTask.getTotalLoadedUCM().isOldExtraKernel ? "1" : "0");
                            if (UCSetupTask.getTotalLoadedUCM().coreType == 2) {
                            }
                            String str14 = "";
                            if (z2) {
                            }
                            num = (Integer) oVar.getOption(UCCore.OPTION_SETUP_THREAD_PRIORITY);
                            try {
                                Callable callable = (Callable) oVar.getOption(UCCore.OPTION_DOWNLOAD_CHECKER);
                                if (callable == null) {
                                }
                            } catch (Throwable unused) {
                                str10 = ExifInterface.LONGITUDE_EAST;
                            }
                            str4 = UCCore.OPTION_DELETE_OLD_DEX_DIR;
                            try {
                                str3 = "SdkSetupTask";
                                try {
                                    UCHashMap uCHashMap = new UCHashMap().set("cnt", "1").set("code", String.valueOf(UCSetupTask.getTotalLoadedUCM().coreType));
                                    if (UCSetupTask.getTotalLoadedUCM().ucmPackageInfo == null) {
                                    }
                                    UCHashMap uCHashMap2 = uCHashMap.set("dir", str11).set("old", UCSetupTask.getTotalLoadedUCM().isOldExtraKernel ? str : str5).set("frun", UCSetupTask.getTotalLoadedUCM().isFirstTimeOdex ? str : str5).set("cpu_cnt", p.a()).set("cpu_freq", p.b()).set("cost_cpu", String.valueOf(oVar.i.getMilisCpu())).set("cost", String.valueOf(oVar.i.getMilis()));
                                    if (num == null) {
                                    }
                                    UCHashMap uCHashMap3 = uCHashMap2.set("pri", str12).set("wifi", str10).set(IWaStat.SHARE_CORE_INIT_TASK_SUCCESS, UCSetupTask.getTotalLoadedUCM().isShareCore ? IWaStat.SHARE_CORE_INIT_TASK_SUCCESS_IS_SHARECORE : IWaStat.SHARE_CORE_INIT_TASK_SUCCESS_NOT_SHARECORE).set(IWaStat.KEY_QUICK_INIT, a.b() ? "1" : "0");
                                    if (z2) {
                                    }
                                    oVar.callbackStat(new Pair<>(IWaStat.SETUP_SUCCESS, uCHashMap3));
                                    IWaStat.WaStat.stat("sdk_ucm_old", UCSetupTask.getTotalLoadedUCM().isOldExtraKernel ? "1" : "0");
                                    if (UCSetupTask.getTotalLoadedUCM().isShareCore) {
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    uCLogger = create;
                                    th.printStackTrace();
                                    oVar.f();
                                    n nVar = new n();
                                    UCCyclone.statCallback = nVar;
                                    ((n) ((n) nVar.setParent(UCSetupTask.getRoot())).onEvent(UCCore.EVENT_STAT, new UCSubSetupTask.a())).start();
                                    Boolean bool2 = (Boolean) oVar.getOption(UCCore.OPTION_VMSIZE_SAVING);
                                    if (bool2 == null) {
                                    }
                                    p.a((Map<String, String>) new s(oVar, z));
                                    if (uCLogger != null) {
                                    }
                                    if (z) {
                                    }
                                    ((f) ((f) ((f) ((f) ((f) ((f) new f().setParent(UCSetupTask.getRoot())).setup("CONTEXT", oVar.h)).setup("del_dec_fil", Boolean.TRUE)).setup("del_upd_fil", Boolean.FALSE)).setup(str4, oVar.getOption(str4))).onEvent(UCCore.EVENT_DIE, new t(oVar))).start();
                                    list2 = oVar.n;
                                    if (list2 != null) {
                                    }
                                    list = null;
                                    oVar.n = list;
                                    lVar2 = oVar.g;
                                    if (lVar2 != null) {
                                    }
                                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_DELAY_DECOMPRESS_START_PV);
                                    oVar.f.start(2000);
                                    oVar.f = null;
                                    UCSetupTask.getTotalLoadedUCM();
                                    lVar = oVar.e;
                                    if (lVar != null) {
                                    }
                                    bool = (Boolean) oVar.mOptions.get(UCCore.OPTION_DISTINGUISH_JS_ERROR);
                                    if (bool != null) {
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                str3 = "SdkSetupTask";
                                uCLogger = create;
                                th.printStackTrace();
                                oVar.f();
                                n nVar2 = new n();
                                UCCyclone.statCallback = nVar2;
                                ((n) ((n) nVar2.setParent(UCSetupTask.getRoot())).onEvent(UCCore.EVENT_STAT, new UCSubSetupTask.a())).start();
                                Boolean bool22 = (Boolean) oVar.getOption(UCCore.OPTION_VMSIZE_SAVING);
                                if (bool22 == null) {
                                }
                                p.a((Map<String, String>) new s(oVar, z));
                                if (uCLogger != null) {
                                }
                                if (z) {
                                }
                                ((f) ((f) ((f) ((f) ((f) ((f) new f().setParent(UCSetupTask.getRoot())).setup("CONTEXT", oVar.h)).setup("del_dec_fil", Boolean.TRUE)).setup("del_upd_fil", Boolean.FALSE)).setup(str4, oVar.getOption(str4))).onEvent(UCCore.EVENT_DIE, new t(oVar))).start();
                                list2 = oVar.n;
                                if (list2 != null) {
                                }
                                list = null;
                                oVar.n = list;
                                lVar2 = oVar.g;
                                if (lVar2 != null) {
                                }
                                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_DELAY_DECOMPRESS_START_PV);
                                oVar.f.start(2000);
                                oVar.f = null;
                                UCSetupTask.getTotalLoadedUCM();
                                lVar = oVar.e;
                                if (lVar != null) {
                                }
                                bool = (Boolean) oVar.mOptions.get(UCCore.OPTION_DISTINGUISH_JS_ERROR);
                                if (bool != null) {
                                }
                            }
                            oVar.f();
                            n nVar22 = new n();
                            UCCyclone.statCallback = nVar22;
                            ((n) ((n) nVar22.setParent(UCSetupTask.getRoot())).onEvent(UCCore.EVENT_STAT, new UCSubSetupTask.a())).start();
                            Boolean bool222 = (Boolean) oVar.getOption(UCCore.OPTION_VMSIZE_SAVING);
                            if (bool222 == null) {
                            }
                            p.a((Map<String, String>) new s(oVar, z));
                            if (uCLogger != null) {
                            }
                            if (z) {
                            }
                            ((f) ((f) ((f) ((f) ((f) ((f) new f().setParent(UCSetupTask.getRoot())).setup("CONTEXT", oVar.h)).setup("del_dec_fil", Boolean.TRUE)).setup("del_upd_fil", Boolean.FALSE)).setup(str4, oVar.getOption(str4))).onEvent(UCCore.EVENT_DIE, new t(oVar))).start();
                            list2 = oVar.n;
                            if (list2 != null) {
                            }
                            list = null;
                            oVar.n = list;
                            lVar2 = oVar.g;
                            if (lVar2 != null) {
                            }
                            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_DELAY_DECOMPRESS_START_PV);
                            oVar.f.start(2000);
                            oVar.f = null;
                            UCSetupTask.getTotalLoadedUCM();
                            lVar = oVar.e;
                            if (lVar != null) {
                            }
                            bool = (Boolean) oVar.mOptions.get(UCCore.OPTION_DISTINGUISH_JS_ERROR);
                            if (bool != null) {
                            }
                        }
                    } else {
                        j2 = System.currentTimeMillis() - file.lastModified();
                    }
                    j3 = 0;
                    if (j3 == 0) {
                    }
                    str2 = UTConstant.Args.UT_SUCCESS_F;
                    try {
                        IWaStat.WaStat.stat(IWaStat.SETUP_UCCORE_COST_HOUR, String.valueOf((int) Math.ceil((double) (j2 / DateUtils.MILLIS_PER_HOUR))));
                        IWaStat.WaStat.stat(IWaStat.SETUP_CUR_UCCORE_COST_HOUR, String.valueOf((int) Math.ceil((double) (j3 / DateUtils.MILLIS_PER_HOUR))));
                    } catch (Throwable th7) {
                        th2 = th7;
                    }
                } else {
                    str = "T";
                    str2 = UTConstant.Args.UT_SUCCESS_F;
                }
            } catch (Throwable th8) {
                th2 = th8;
                str = "T";
                str2 = UTConstant.Args.UT_SUCCESS_F;
                th2.printStackTrace();
                IWaStat.WaStat.stat("sdk_ucm_old", UCSetupTask.getTotalLoadedUCM().isOldExtraKernel ? "1" : "0");
                if (UCSetupTask.getTotalLoadedUCM().coreType == 2) {
                }
                String str142 = "";
                if (z2) {
                }
                num = (Integer) oVar.getOption(UCCore.OPTION_SETUP_THREAD_PRIORITY);
                Callable callable2 = (Callable) oVar.getOption(UCCore.OPTION_DOWNLOAD_CHECKER);
                if (callable2 == null) {
                }
                str4 = UCCore.OPTION_DELETE_OLD_DEX_DIR;
                str3 = "SdkSetupTask";
                UCHashMap uCHashMap4 = new UCHashMap().set("cnt", "1").set("code", String.valueOf(UCSetupTask.getTotalLoadedUCM().coreType));
                if (UCSetupTask.getTotalLoadedUCM().ucmPackageInfo == null) {
                }
                UCHashMap uCHashMap22 = uCHashMap4.set("dir", str11).set("old", UCSetupTask.getTotalLoadedUCM().isOldExtraKernel ? str : str5).set("frun", UCSetupTask.getTotalLoadedUCM().isFirstTimeOdex ? str : str5).set("cpu_cnt", p.a()).set("cpu_freq", p.b()).set("cost_cpu", String.valueOf(oVar.i.getMilisCpu())).set("cost", String.valueOf(oVar.i.getMilis()));
                if (num == null) {
                }
                UCHashMap uCHashMap32 = uCHashMap22.set("pri", str12).set("wifi", str10).set(IWaStat.SHARE_CORE_INIT_TASK_SUCCESS, UCSetupTask.getTotalLoadedUCM().isShareCore ? IWaStat.SHARE_CORE_INIT_TASK_SUCCESS_IS_SHARECORE : IWaStat.SHARE_CORE_INIT_TASK_SUCCESS_NOT_SHARECORE).set(IWaStat.KEY_QUICK_INIT, a.b() ? "1" : "0");
                if (z2) {
                }
                oVar.callbackStat(new Pair<>(IWaStat.SETUP_SUCCESS, uCHashMap32));
                IWaStat.WaStat.stat("sdk_ucm_old", UCSetupTask.getTotalLoadedUCM().isOldExtraKernel ? "1" : "0");
                if (UCSetupTask.getTotalLoadedUCM().isShareCore) {
                }
                oVar.f();
                n nVar222 = new n();
                UCCyclone.statCallback = nVar222;
                ((n) ((n) nVar222.setParent(UCSetupTask.getRoot())).onEvent(UCCore.EVENT_STAT, new UCSubSetupTask.a())).start();
                Boolean bool2222 = (Boolean) oVar.getOption(UCCore.OPTION_VMSIZE_SAVING);
                if (bool2222 == null) {
                }
                p.a((Map<String, String>) new s(oVar, z));
                if (uCLogger != null) {
                }
                if (z) {
                }
                ((f) ((f) ((f) ((f) ((f) ((f) new f().setParent(UCSetupTask.getRoot())).setup("CONTEXT", oVar.h)).setup("del_dec_fil", Boolean.TRUE)).setup("del_upd_fil", Boolean.FALSE)).setup(str4, oVar.getOption(str4))).onEvent(UCCore.EVENT_DIE, new t(oVar))).start();
                list2 = oVar.n;
                if (list2 != null) {
                }
                list = null;
                oVar.n = list;
                lVar2 = oVar.g;
                if (lVar2 != null) {
                }
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_DELAY_DECOMPRESS_START_PV);
                oVar.f.start(2000);
                oVar.f = null;
                UCSetupTask.getTotalLoadedUCM();
                lVar = oVar.e;
                if (lVar != null) {
                }
                bool = (Boolean) oVar.mOptions.get(UCCore.OPTION_DISTINGUISH_JS_ERROR);
                if (bool != null) {
                }
            }
            try {
                IWaStat.WaStat.stat("sdk_ucm_old", UCSetupTask.getTotalLoadedUCM().isOldExtraKernel ? "1" : "0");
            } catch (Throwable th9) {
                th9.printStackTrace();
            }
            try {
                z2 = (UCSetupTask.getTotalLoadedUCM().coreType == 2 || oVar.j == null) ? false : true;
                String str1422 = "";
                if (z2) {
                    String valueOf = String.valueOf(oVar.j.errCode());
                    try {
                        str8 = oVar.j.getRootCause().getClass().getSimpleName();
                    } catch (Throwable unused2) {
                        str8 = str1422;
                    }
                    try {
                        str1422 = p.a(oVar.j.getRootCause());
                    } catch (Throwable unused3) {
                    }
                    str7 = oVar.k.getCrashCode();
                    str6 = oVar.k.getClass().getSimpleName();
                    str5 = str2;
                    str9 = str1422;
                    str1422 = valueOf;
                } else {
                    str5 = str2;
                    str9 = str1422;
                    str8 = str9;
                    str7 = str8;
                    str6 = str7;
                }
                num = (Integer) oVar.getOption(UCCore.OPTION_SETUP_THREAD_PRIORITY);
                Callable callable22 = (Callable) oVar.getOption(UCCore.OPTION_DOWNLOAD_CHECKER);
                str10 = callable22 == null ? "N" : ((Boolean) callable22.call()).booleanValue() ? str : str5;
                str4 = UCCore.OPTION_DELETE_OLD_DEX_DIR;
                str3 = "SdkSetupTask";
                UCHashMap uCHashMap42 = new UCHashMap().set("cnt", "1").set("code", String.valueOf(UCSetupTask.getTotalLoadedUCM().coreType));
                if (UCSetupTask.getTotalLoadedUCM().ucmPackageInfo == null) {
                    str11 = "null";
                    uCLogger = create;
                } else {
                    uCLogger = create;
                    try {
                        str11 = UCSetupTask.getTotalLoadedUCM().ucmPackageInfo.getDirAlias(oVar.h);
                    } catch (Throwable th10) {
                        th = th10;
                        th.printStackTrace();
                        oVar.f();
                        n nVar2222 = new n();
                        UCCyclone.statCallback = nVar2222;
                        ((n) ((n) nVar2222.setParent(UCSetupTask.getRoot())).onEvent(UCCore.EVENT_STAT, new UCSubSetupTask.a())).start();
                        Boolean bool22222 = (Boolean) oVar.getOption(UCCore.OPTION_VMSIZE_SAVING);
                        if (bool22222 == null) {
                        }
                        p.a((Map<String, String>) new s(oVar, z));
                        if (uCLogger != null) {
                        }
                        if (z) {
                        }
                        ((f) ((f) ((f) ((f) ((f) ((f) new f().setParent(UCSetupTask.getRoot())).setup("CONTEXT", oVar.h)).setup("del_dec_fil", Boolean.TRUE)).setup("del_upd_fil", Boolean.FALSE)).setup(str4, oVar.getOption(str4))).onEvent(UCCore.EVENT_DIE, new t(oVar))).start();
                        list2 = oVar.n;
                        if (list2 != null) {
                        }
                        list = null;
                        oVar.n = list;
                        lVar2 = oVar.g;
                        if (lVar2 != null) {
                        }
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_DELAY_DECOMPRESS_START_PV);
                        oVar.f.start(2000);
                        oVar.f = null;
                        UCSetupTask.getTotalLoadedUCM();
                        lVar = oVar.e;
                        if (lVar != null) {
                        }
                        bool = (Boolean) oVar.mOptions.get(UCCore.OPTION_DISTINGUISH_JS_ERROR);
                        if (bool != null) {
                        }
                    }
                }
                UCHashMap uCHashMap222 = uCHashMap42.set("dir", str11).set("old", UCSetupTask.getTotalLoadedUCM().isOldExtraKernel ? str : str5).set("frun", UCSetupTask.getTotalLoadedUCM().isFirstTimeOdex ? str : str5).set("cpu_cnt", p.a()).set("cpu_freq", p.b()).set("cost_cpu", String.valueOf(oVar.i.getMilisCpu())).set("cost", String.valueOf(oVar.i.getMilis()));
                if (num == null) {
                    str12 = "n";
                } else {
                    str12 = String.valueOf(num);
                }
                UCHashMap uCHashMap322 = uCHashMap222.set("pri", str12).set("wifi", str10).set(IWaStat.SHARE_CORE_INIT_TASK_SUCCESS, UCSetupTask.getTotalLoadedUCM().isShareCore ? IWaStat.SHARE_CORE_INIT_TASK_SUCCESS_IS_SHARECORE : IWaStat.SHARE_CORE_INIT_TASK_SUCCESS_NOT_SHARECORE).set(IWaStat.KEY_QUICK_INIT, a.b() ? "1" : "0");
                if (z2) {
                    uCHashMap322 = uCHashMap322.set("multi_core", i.a().b(UCCore.OPTION_MULTI_CORE_TYPE) ? "1" : "0").set("err", str1422).set("cls", str8).set("msg", str9).set("crash", str7).set("task", str6).set(IWaStat.SHARE_CORE_INIT_TASK_SUCCESS, IWaStat.SHARE_CORE_INIT_TASK_SUCCESS_FAILUE);
                }
                oVar.callbackStat(new Pair<>(IWaStat.SETUP_SUCCESS, uCHashMap322));
                IWaStat.WaStat.stat("sdk_ucm_old", UCSetupTask.getTotalLoadedUCM().isOldExtraKernel ? "1" : "0");
                if (UCSetupTask.getTotalLoadedUCM().isShareCore) {
                    if (z2) {
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_NOT_UPD_SC_INIT_FAILURE_PV);
                    } else {
                        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_NOT_UPD_SC_INIT_SUCCESS_PV);
                    }
                }
            } catch (Throwable th11) {
                th = th11;
                str4 = UCCore.OPTION_DELETE_OLD_DEX_DIR;
                str3 = "SdkSetupTask";
                uCLogger = create;
                th.printStackTrace();
                oVar.f();
                n nVar22222 = new n();
                UCCyclone.statCallback = nVar22222;
                ((n) ((n) nVar22222.setParent(UCSetupTask.getRoot())).onEvent(UCCore.EVENT_STAT, new UCSubSetupTask.a())).start();
                Boolean bool222222 = (Boolean) oVar.getOption(UCCore.OPTION_VMSIZE_SAVING);
                if (bool222222 == null) {
                }
                p.a((Map<String, String>) new s(oVar, z));
                if (uCLogger != null) {
                }
                if (z) {
                }
                ((f) ((f) ((f) ((f) ((f) ((f) new f().setParent(UCSetupTask.getRoot())).setup("CONTEXT", oVar.h)).setup("del_dec_fil", Boolean.TRUE)).setup("del_upd_fil", Boolean.FALSE)).setup(str4, oVar.getOption(str4))).onEvent(UCCore.EVENT_DIE, new t(oVar))).start();
                list2 = oVar.n;
                if (list2 != null) {
                }
                list = null;
                oVar.n = list;
                lVar2 = oVar.g;
                if (lVar2 != null) {
                }
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_DELAY_DECOMPRESS_START_PV);
                oVar.f.start(2000);
                oVar.f = null;
                UCSetupTask.getTotalLoadedUCM();
                lVar = oVar.e;
                if (lVar != null) {
                }
                bool = (Boolean) oVar.mOptions.get(UCCore.OPTION_DISTINGUISH_JS_ERROR);
                if (bool != null) {
                }
            }
            oVar.f();
            try {
                n nVar222222 = new n();
                UCCyclone.statCallback = nVar222222;
                ((n) ((n) nVar222222.setParent(UCSetupTask.getRoot())).onEvent(UCCore.EVENT_STAT, new UCSubSetupTask.a())).start();
            } catch (Throwable th12) {
                th12.printStackTrace();
            }
            try {
                Boolean bool2222222 = (Boolean) oVar.getOption(UCCore.OPTION_VMSIZE_SAVING);
                z = bool2222222 == null && bool2222222.booleanValue();
                p.a((Map<String, String>) new s(oVar, z));
                if (uCLogger != null) {
                    StringBuilder sb = new StringBuilder("mSuccessCB: vmsize_saving_enable=");
                    sb.append(z ? "true" : "false");
                    uCLogger.print(sb.toString(), new Throwable[0]);
                }
                if (z) {
                    new UCAsyncTask(new UCVmsize(oVar.h)).setParent(UCSetupTask.getRoot()).start();
                }
            } catch (Throwable th13) {
                Log.i(str3, "successCallbackImpl " + th13.getMessage());
            }
            try {
                ((f) ((f) ((f) ((f) ((f) ((f) new f().setParent(UCSetupTask.getRoot())).setup("CONTEXT", oVar.h)).setup("del_dec_fil", Boolean.TRUE)).setup("del_upd_fil", Boolean.FALSE)).setup(str4, oVar.getOption(str4))).onEvent(UCCore.EVENT_DIE, new t(oVar))).start();
            } catch (Throwable th14) {
                th14.printStackTrace();
            }
            try {
                list2 = oVar.n;
                if (list2 != null) {
                    ((e) ((e) ((e) new e(list2).setParent(UCSetupTask.getRoot())).setOptions(oVar.mOptions)).onEvent(UCCore.EVENT_STAT, new UCSubSetupTask.a())).start();
                }
                list = null;
            } catch (Throwable th15) {
                oVar.n = null;
                throw th15;
            }
            oVar.n = list;
            try {
                lVar2 = oVar.g;
                if (lVar2 != null) {
                    ((l) ((l) ((l) ((l) lVar2.setup(UCCore.OPTION_CHECK_MULTI_CORE, (Object) Boolean.TRUE)).onEvent("success", (ValueCallback) null)).onEvent("exception", (ValueCallback) null)).onEvent("switch", (ValueCallback) oVar.t)).start();
                    oVar.g = null;
                }
            } catch (Throwable th16) {
                th16.printStackTrace();
            }
            try {
                if (p.a(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_HOST_UPD_SETUP_TASK_WAIT_MILIS)) && oVar.f != null) {
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_DELAY_DECOMPRESS_START_PV);
                    oVar.f.start(2000);
                    oVar.f = null;
                }
            } catch (Throwable th17) {
                th17.printStackTrace();
            }
            try {
                UCSetupTask.getTotalLoadedUCM();
            } catch (Throwable th18) {
                th18.printStackTrace();
            }
            try {
                lVar = oVar.e;
                if (lVar != null) {
                    lVar.start(2000);
                    oVar.e = null;
                }
            } catch (Throwable th19) {
                th19.printStackTrace();
            }
            bool = (Boolean) oVar.mOptions.get(UCCore.OPTION_DISTINGUISH_JS_ERROR);
            if (bool != null) {
                try {
                    IGlobalSettings f2 = SDKFactory.f();
                    if (f2 != null) {
                        f2.setBoolValue(SettingKeys.DistinguishJSError, bool.booleanValue());
                    }
                } catch (Throwable th20) {
                    th20.printStackTrace();
                }
            }
        } catch (Throwable th21) {
            oVar.setException(new UCSetupException(4004, th21));
        }
    }

    public final void a(String str, Callable<Boolean> callable) {
        Boolean bool = Boolean.TRUE;
        l lVar = (l) ((l) ((l) ((l) ((l) ((l) new by().setParent(UCSetupTask.getRoot())).setOptions(this.mOptions)).setup(UCCore.OPTION_UCM_ZIP_DIR, (Object) null)).setup(UCCore.OPTION_UCM_ZIP_FILE, (Object) null)).setup(UCCore.OPTION_USE_SDK_SETUP, (Object) bool)).setup(UCCore.OPTION_CHECK_MULTI_CORE, (Object) bool);
        Object obj = this.l;
        if (obj == null) {
            obj = new UCSubSetupTask.a();
        }
        l lVar2 = (l) ((l) ((l) ((l) ((l) lVar.onEvent(UCCore.EVENT_STAT, (ValueCallback) obj)).onEvent("switch", (ValueCallback) this.t)).onEvent(UCCore.EVENT_DOWNLOAD_EXCEPTION, (ValueCallback) new ac(this))).onEvent(UCCore.EVENT_DOWNLOAD_FILE_DELETE, (ValueCallback) new ab(this, str))).onEvent(UCCore.EVENT_UPDATE_PROGRESS, (ValueCallback) new aa(this));
        this.a = lVar2;
        this.e = lVar2;
        if (callable != null) {
            lVar2.setup(UCCore.OPTION_DOWNLOAD_CHECKER, (Object) callable);
        }
        if (!p.a(str)) {
            this.e.setup(UCCore.OPTION_UCM_UPD_URL, (Object) str);
        }
        if (CDParamKeys.CD_VALUE_LOAD_POLICY_SHARE_CORE.equals(UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_LOAD_POLICY))) {
            this.e.onEvent(UCCore.EVENT_UPDATE_SHARE_CORE, (ValueCallback) this.s);
        }
    }

    private l a(l lVar, boolean z) {
        String str = (String) getOption(UCCore.OPTION_UCM_UPD_URL);
        if (p.a(str)) {
            return null;
        }
        a((String) getOption(UCCore.OPTION_UCM_UPD_URL), (Callable<Boolean>) null);
        try {
            File a2 = p.a(this.h, "updates");
            if (a2.list().length > 0) {
                if (z) {
                    String sourceHash = UCCyclone.getSourceHash(str);
                    String[] list = a2.list();
                    Log.d("SdkSetupTask", "hashcode: " + sourceHash + " list: " + list);
                    int length = list.length;
                    boolean z2 = false;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (list[i2].equals(sourceHash)) {
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z2) {
                        return null;
                    }
                }
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_NEW_UPD_TASK);
                this.o = true;
                if (lVar != null) {
                    d.push(lVar);
                }
                String absolutePath = a2.getAbsolutePath();
                if (z || a2.list().length > 1) {
                    absolutePath = new File(a2, UCCyclone.getSourceHash(str)).getAbsolutePath();
                }
                return (l) ((l) a(p.f() ? new bb() : new bh(), absolutePath).setup(UCCore.OPTION_CHECK_DECOMPRESS_FINISH, (Object) Boolean.TRUE)).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) absolutePath);
            }
        } catch (Exception e2) {
            Log.d("SdkSetupTask", "UCMPackageInfo.getUpdateRoot exception: " + e2);
        }
        return null;
    }

    private void a(l lVar) {
        l lVar2;
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_FAULT_TOLERANCE_TASK);
        String param = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_BAK_KRL_DIR);
        String param2 = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_BAK_ZIP_FPATH);
        if (!p.a(param) || !p.a(param2)) {
            lVar2 = a(new ap(), "ShareCoreFaultToleranceTask");
        } else {
            lVar2 = null;
        }
        if (lVar2 != null) {
            d.push(lVar2);
            lVar.onEvent(UCCore.EVENT_DELAY_SEARCH_CORE_FILE, (ValueCallback) new z(this));
        }
    }

    static /* synthetic */ void a(o oVar, UCMRunningInfo uCMRunningInfo) {
        oVar.setLoadedUCM(uCMRunningInfo);
        oVar.setTotalLoadedUCM(uCMRunningInfo);
        SDKFactory.h = uCMRunningInfo.loadType;
        Log.d("SdkSetupTask", "initLoadUcm sLoadType: " + SDKFactory.h + ", isShareCore:" + uCMRunningInfo.isShareCore);
        if (uCMRunningInfo.isShareCore) {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDCARD_SETUP_SUCCESS);
        }
        if (uCMRunningInfo.isOldExtraKernel) {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_OLD_KERNAL_SETUP_SUCCESS);
        }
        if (uCMRunningInfo.isFirstTimeOdex) {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_FIRST_KERNAL_SETUP_SUCCESS);
        }
    }
}

package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCElapseTime;
import com.uc.webview.export.cyclone.UCHashMap;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.UCAsyncTask;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.i;
import com.uc.webview.export.internal.utility.p;
import java.io.File;

/* compiled from: Taobao */
public class b extends l {
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0364, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0365, code lost:
        r11 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0368, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0369, code lost:
        r11 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x036c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x036d, code lost:
        r4 = "0";
        r3 = r0;
        r13 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0375, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0376, code lost:
        r8 = r12;
        r11 = r14;
        r4 = "0";
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x012f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0130, code lost:
        r3 = r0;
        r4 = "0";
        r0 = r16;
        r13 = r13;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0368 A[ExcHandler: UCKnownException (e com.uc.webview.export.cyclone.UCKnownException), PHI: r4 r7 r8 r19 r24 
      PHI: (r4v21 java.lang.String) = (r4v22 java.lang.String), (r4v22 java.lang.String), (r4v54 java.lang.String), (r4v54 java.lang.String) binds: [B:64:0x01e4, B:65:?, B:57:0x01c9, B:58:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r7v12 java.lang.String) = (r7v13 java.lang.String), (r7v13 java.lang.String), (r7v22 java.lang.String), (r7v22 java.lang.String) binds: [B:64:0x01e4, B:65:?, B:57:0x01c9, B:58:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r8v21 java.lang.String) = (r8v22 java.lang.String), (r8v22 java.lang.String), (r8v28 java.lang.String), (r8v28 java.lang.String) binds: [B:64:0x01e4, B:65:?, B:57:0x01c9, B:58:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r19v8 boolean) = (r19v9 boolean), (r19v9 boolean), (r19v12 boolean), (r19v12 boolean) binds: [B:64:0x01e4, B:65:?, B:57:0x01c9, B:58:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r24v0 java.lang.String) = (r24v1 java.lang.String), (r24v1 java.lang.String), (r24v3 java.lang.String), (r24v3 java.lang.String) binds: [B:64:0x01e4, B:65:?, B:57:0x01c9, B:58:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:57:0x01c9] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0375 A[ExcHandler: UCKnownException (e com.uc.webview.export.cyclone.UCKnownException), Splitter:B:25:0x00e8] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x012f A[Catch:{ UCKnownException -> 0x0375, all -> 0x012f }, ExcHandler: all (r0v67 'th' java.lang.Throwable A[CUSTOM_DECLARE, Catch:{ UCKnownException -> 0x0375, all -> 0x012f }]), Splitter:B:29:0x00ff] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x013b A[Catch:{ UCKnownException -> 0x0375, all -> 0x012f }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0175 A[Catch:{ Exception -> 0x01ac, all -> 0x012f }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0208  */
    @Override // com.uc.webview.export.internal.setup.UCAsyncTask
    public void run() {
        File file;
        File file2;
        File b;
        boolean z;
        float f;
        String str;
        Throwable th;
        String str2;
        String str3;
        String str4;
        float freeSpace;
        Throwable th2;
        boolean z2;
        boolean z3;
        boolean z4;
        String str5;
        String str6;
        String str7;
        UCCore.Callable callable;
        com.uc.webview.export.internal.uc.startup.b.a(294);
        String str8 = (String) getOption(UCCore.OPTION_UCM_ZIP_DIR);
        String str9 = (String) getOption(UCCore.OPTION_UCM_ZIP_FILE);
        String str10 = (String) getOption(UCCore.OPTION_DECOMPRESS_ROOT_DIR);
        Log.d("DecompressSetupTask", "zipDirPath : " + str8 + " zipFilePath : " + str9 + " decRootDirPath : " + str10);
        boolean a = p.a(str8);
        boolean a2 = p.a(str9);
        if ((!a || !a2) && (a || a2)) {
            Context context = (Context) getOption("CONTEXT");
            if (a2) {
                file = p.g(str8);
            } else {
                file = UCCyclone.expectFile(str9);
            }
            if (file != null) {
                synchronized (b.class) {
                    if (!p.a(str10)) {
                        file2 = new File(str10);
                    } else {
                        file2 = p.a(context, "decompresses2");
                    }
                    b = p.b(p.b(file2, UCCyclone.getSourceHash(file.getAbsolutePath())), UCCyclone.getSourceHash(file.length(), file.lastModified()));
                    af.a(file, b);
                    String str11 = "";
                    String str12 = "0";
                    String str13 = "";
                    String str14 = "0";
                    String str15 = "0";
                    try {
                        UCElapseTime uCElapseTime = new UCElapseTime();
                        boolean equalsIgnoreCase = UCCyclone.serverZipTag.equalsIgnoreCase((String) getOption(UCCore.OPTION_ZIP_FILE_TYPE));
                        try {
                            boolean a3 = p.a((Boolean) getOption(UCCore.OPTION_DELETE_AFTER_EXTRACT));
                            if (p.a((Boolean) this.mOptions.get(UCCore.OPTION_SHARE_CORE_SETUP_TASK_FLAG))) {
                                try {
                                    String str16 = (String) getOption(UCCore.OPTION_UCM_ZIP_FILE);
                                    String param = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_COMMONALITY_TARGET_FPATH);
                                    if (!p.a(param)) {
                                        if (!p.a(str16)) {
                                            z2 = new File(str16).getAbsolutePath().startsWith(new File(param).getAbsolutePath());
                                            int i = !z2 ? UCCyclone.DecFileOrign.Sdcard_Share_Core : UCCyclone.DecFileOrign.Other;
                                            Log.d("DecompressSetupTask", String.format("forceUsing7z : %b, deleteAfterExtract : %b, orign : %d", Boolean.valueOf(equalsIgnoreCase), Boolean.valueOf(a3), Integer.valueOf(i)));
                                            com.uc.webview.export.internal.uc.startup.b.a(20);
                                            callable = (UCCore.Callable) getOption(UCCore.OPTION_DECOMPRESS_CALLBACK);
                                            if (callable != null) {
                                                Bundle bundle = new Bundle();
                                                bundle.putString("decDirPath", b.getAbsolutePath());
                                                bundle.putString("zipFilePath", file.getAbsolutePath());
                                                bundle.putString("zipFileType", equalsIgnoreCase ? "7z" : "");
                                                bundle.putBoolean("deleteAfterExtract", a3);
                                                z3 = ((Boolean) callable.call(bundle)).booleanValue();
                                                z4 = true;
                                                if (!z4) {
                                                    str3 = str15;
                                                    str4 = str14;
                                                    str5 = str13;
                                                    z = z3;
                                                    str = "0";
                                                    try {
                                                        z = UCCyclone.decompressIfNeeded(context, equalsIgnoreCase, file, b, null, a3, i);
                                                    } catch (UCKnownException e) {
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        str14 = str4;
                                                        str15 = str3;
                                                        str2 = str12;
                                                        str13 = str5;
                                                        f = 0.0f;
                                                        try {
                                                            callbackStat(new Pair<>("sdk_7z", new UCHashMap().set("cnt", "1").set("code", str11).set("cost", str).set("cost_cpu", str2).set("data", str13).set("cpu_cnt", str14).set("cpu_freq", str15).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(f))));
                                                            Log.d("DecompressSetupTask", String.format("need : %b, code : %s, CostsMilis : %s, Cpu: %s", Boolean.valueOf(z), str11, str, str2));
                                                        } catch (Throwable unused) {
                                                        }
                                                        throw th;
                                                    }
                                                } else {
                                                    str3 = str15;
                                                    str5 = str13;
                                                    str4 = str14;
                                                    z = z3;
                                                    str = "0";
                                                }
                                                com.uc.webview.export.internal.uc.startup.b.a(21);
                                                com.uc.webview.export.internal.uc.startup.b.a(19, z ? "1" : "0");
                                                if (z) {
                                                    str7 = "0";
                                                    str12 = String.valueOf(uCElapseTime.getMilisCpu());
                                                    str6 = String.valueOf(uCElapseTime.getMilis());
                                                } else {
                                                    str7 = "1";
                                                    str6 = str;
                                                }
                                                callbackStat(new Pair<>("sdk_7z", new UCHashMap().set("cnt", "1").set("code", str7).set("cost", str6).set("cost_cpu", str12).set("data", str5).set("cpu_cnt", str4).set("cpu_freq", str3).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, "0.0")));
                                                Log.d("DecompressSetupTask", String.format("need : %b, code : %s, CostsMilis : %s, Cpu: %s", Boolean.valueOf(z), str7, str6, str12));
                                            }
                                            z4 = false;
                                            z3 = false;
                                            if (!z4) {
                                            }
                                            com.uc.webview.export.internal.uc.startup.b.a(21);
                                            com.uc.webview.export.internal.uc.startup.b.a(19, z ? "1" : "0");
                                            if (z) {
                                            }
                                            callbackStat(new Pair<>("sdk_7z", new UCHashMap().set("cnt", "1").set("code", str7).set("cost", str6).set("cost_cpu", str12).set("data", str5).set("cpu_cnt", str4).set("cpu_freq", str3).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, "0.0")));
                                            Log.d("DecompressSetupTask", String.format("need : %b, code : %s, CostsMilis : %s, Cpu: %s", Boolean.valueOf(z), str7, str6, str12));
                                        }
                                    }
                                } catch (Exception e2) {
                                    Log.d("DecompressSetupTask", "decCallback", e2);
                                } catch (Throwable th4) {
                                }
                            }
                            z2 = false;
                            if (!z2) {
                            }
                            Log.d("DecompressSetupTask", String.format("forceUsing7z : %b, deleteAfterExtract : %b, orign : %d", Boolean.valueOf(equalsIgnoreCase), Boolean.valueOf(a3), Integer.valueOf(i)));
                            com.uc.webview.export.internal.uc.startup.b.a(20);
                            callable = (UCCore.Callable) getOption(UCCore.OPTION_DECOMPRESS_CALLBACK);
                            if (callable != null) {
                            }
                            z4 = false;
                            z3 = false;
                            if (!z4) {
                            }
                            com.uc.webview.export.internal.uc.startup.b.a(21);
                            com.uc.webview.export.internal.uc.startup.b.a(19, z ? "1" : "0");
                            if (z) {
                            }
                            try {
                                callbackStat(new Pair<>("sdk_7z", new UCHashMap().set("cnt", "1").set("code", str7).set("cost", str6).set("cost_cpu", str12).set("data", str5).set("cpu_cnt", str4).set("cpu_freq", str3).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, "0.0")));
                                Log.d("DecompressSetupTask", String.format("need : %b, code : %s, CostsMilis : %s, Cpu: %s", Boolean.valueOf(z), str7, str6, str12));
                            } catch (Throwable unused2) {
                            }
                        } catch (UCKnownException e3) {
                        } catch (Throwable th42) {
                        }
                    } catch (UCKnownException e4) {
                        UCKnownException e5 = e4;
                        str3 = str15;
                        str4 = str14;
                        String str17 = str13;
                        str = "0";
                        z = false;
                        str11 = "2";
                        try {
                            str13 = String.valueOf(e5.errCode());
                            try {
                                freeSpace = (float) (b.getFreeSpace() / 1024);
                            } catch (Throwable th5) {
                                th = th5;
                                str14 = str4;
                                str15 = str3;
                                str2 = str12;
                                f = 0.0f;
                                callbackStat(new Pair<>("sdk_7z", new UCHashMap().set("cnt", "1").set("code", str11).set("cost", str).set("cost_cpu", str2).set("data", str13).set("cpu_cnt", str14).set("cpu_freq", str15).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(f))));
                                Log.d("DecompressSetupTask", String.format("need : %b, code : %s, CostsMilis : %s, Cpu: %s", Boolean.valueOf(z), str11, str, str2));
                                throw th;
                            }
                            try {
                                str14 = p.a();
                                try {
                                    str15 = p.b();
                                    try {
                                        throw e5;
                                    } catch (Throwable th6) {
                                        th2 = th6;
                                        f = freeSpace;
                                    }
                                } catch (Throwable th7) {
                                    th2 = th7;
                                    f = freeSpace;
                                    str15 = str3;
                                    th = th2;
                                    str2 = str12;
                                    callbackStat(new Pair<>("sdk_7z", new UCHashMap().set("cnt", "1").set("code", str11).set("cost", str).set("cost_cpu", str2).set("data", str13).set("cpu_cnt", str14).set("cpu_freq", str15).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(f))));
                                    Log.d("DecompressSetupTask", String.format("need : %b, code : %s, CostsMilis : %s, Cpu: %s", Boolean.valueOf(z), str11, str, str2));
                                    throw th;
                                }
                            } catch (Throwable th8) {
                                th2 = th8;
                                f = freeSpace;
                                str14 = str4;
                                str15 = str3;
                                th = th2;
                                str2 = str12;
                                callbackStat(new Pair<>("sdk_7z", new UCHashMap().set("cnt", "1").set("code", str11).set("cost", str).set("cost_cpu", str2).set("data", str13).set("cpu_cnt", str14).set("cpu_freq", str15).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(f))));
                                Log.d("DecompressSetupTask", String.format("need : %b, code : %s, CostsMilis : %s, Cpu: %s", Boolean.valueOf(z), str11, str, str2));
                                throw th;
                            }
                        } catch (Throwable th9) {
                            Throwable th10 = th9;
                            th = th10;
                            str14 = str4;
                            str15 = str3;
                            str13 = str17;
                            str2 = str12;
                            f = 0.0f;
                            callbackStat(new Pair<>("sdk_7z", new UCHashMap().set("cnt", "1").set("code", str11).set("cost", str).set("cost_cpu", str2).set("data", str13).set("cpu_cnt", str14).set("cpu_freq", str15).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(f))));
                            Log.d("DecompressSetupTask", String.format("need : %b, code : %s, CostsMilis : %s, Cpu: %s", Boolean.valueOf(z), str11, str, str2));
                            throw th;
                        }
                    } catch (Throwable th11) {
                        str = "0";
                        th = th11;
                        str2 = str12;
                        f = 0.0f;
                        z = false;
                        callbackStat(new Pair<>("sdk_7z", new UCHashMap().set("cnt", "1").set("code", str11).set("cost", str).set("cost_cpu", str2).set("data", str13).set("cpu_cnt", str14).set("cpu_freq", str15).set(IWaStat.KEY_LINK_SO_CODE, "-1").set(IWaStat.KEY_FREE_DISK_SPACE, String.valueOf(f))));
                        Log.d("DecompressSetupTask", String.format("need : %b, code : %s, CostsMilis : %s, Cpu: %s", Boolean.valueOf(z), str11, str, str2));
                        throw th;
                    }
                }
                if (z || UCSetupTask.getTotalLoadedUCM() == null || p.a((Boolean) getOption(UCCore.OPTION_CONTINUE_ODEX_ON_DECOMPRESSED))) {
                    Boolean bool = (Boolean) getOption(UCCore.OPTION_CHECK_MULTI_CORE);
                    if (getParent() != null && !(getParent() instanceof com.uc.webview.export.business.setup.p)) {
                        i.a().a("gk_dec_exist", Boolean.valueOf(!z));
                    }
                    UCAsyncTask bbVar = p.f() ? new bb() : new bh();
                    com.uc.webview.export.internal.uc.startup.b.a(295);
                    ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) ((l) bbVar.setParent(this)).setOptions(this.mOptions)).setCallbacks(this.mCallbacks)).setup(UCCore.OPTION_DEX_FILE_PATH, (Object) null)).setup(UCCore.OPTION_SO_FILE_PATH, (Object) null)).setup(UCCore.OPTION_RES_FILE_PATH, (Object) null)).setup(UCCore.OPTION_UCM_CFG_FILE, (Object) null)).onEvent("start", (ValueCallback) null)).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) b.getAbsolutePath())).onEvent("stop", (ValueCallback) new UCAsyncTask.b())).setup(UCCore.OPTION_ENABLE_LOAD_CLASS, (Object) Boolean.valueOf(p.a(UCSetupTask.getTotalLoadedUCM())))).onEvent("switch", (ValueCallback) new d(this))).onEvent(UCCore.LEGACY_EVENT_SETUP, (ValueCallback) (p.b(bool) ? null : new c(this)))).start();
                }
                this.mCallbacks = null;
                return;
            }
            throw new UCSetupException(3011, String.format("No kernel file found in dir [%s].", str8));
        }
        throw new UCSetupException(3010, String.format("Option [%s] or  [%s] expected.", UCCore.OPTION_UCM_ZIP_DIR, UCCore.OPTION_UCM_ZIP_FILE));
    }
}
